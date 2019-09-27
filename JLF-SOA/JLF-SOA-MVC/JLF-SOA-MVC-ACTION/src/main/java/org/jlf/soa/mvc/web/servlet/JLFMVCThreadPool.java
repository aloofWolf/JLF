package org.jlf.soa.mvc.web.servlet;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.jlf.common.util.EnumUtil;
import org.jlf.common.util.LogUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.client.dbPool.JLFDbPoolClient;
import org.jlf.plugin.client.json.JLFJsonClient;
import org.jlf.plugin.client.session.JLFSessionClient;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.soa.mvc.metadata.enums.JLFMVCOperatorResult;
import org.jlf.soa.mvc.metadata.response.JLFMVCResponse;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
import org.jlf.soa.mvc.web.jump.way.JLFMVCIJumpProcess;
import org.jlf.soa.mvc.web.jump.way.JLFMVCJumpWay;
import org.jlf.soa.mvc.web.route.JLFMVCRouteManager;
import org.jlf.soa.mvc.web.route.JLFMVCRouteTarget;

public class JLFMVCThreadPool {
	
    private static ExecutorService executeService;
	
	static{
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		executeService = new ThreadPoolExecutor(200, 200,
                0L, TimeUnit.MILLISECONDS,queue);
	}
	
	protected static void submit(AsyncContext asyncContext,String paramsStr,ServletOutputStream outputStream){
		ExecuteThread et = new ExecuteThread(asyncContext,paramsStr,outputStream);
		executeService.submit(et);
	}
	
	/**
	 * 
	 * @ClassName: ExecuteThread
	 * @Description:Callable线程
	 * @author Lone Wolf
	 * @date 2019年5月28日
	 */
	static class ExecuteThread implements Callable<String> {

		private AsyncContext asyncContext;
		private String paramsStr;
		private ServletOutputStream outputStream;

		public ExecuteThread(AsyncContext asyncContext,String paramsStr,ServletOutputStream outputStream) {
			this.asyncContext = asyncContext;
			this.paramsStr = paramsStr;
			this.outputStream = outputStream;
		}

		@Override
		public String call() {
			try {
				HttpServletRequest request = (HttpServletRequest) asyncContext.getRequest();
				String url = request.getRequestURI();
				String routeKey = request.getPathInfo();
				LogUtil.get().debug("请求url:{}", url);
				LogUtil.get().debug("请求routeKey:{}", routeKey);
				LogUtil.get().debug("请求参数:{}", paramsStr);
				
				JLFMVCRouteTarget target = JLFMVCRouteManager.getTarget(routeKey);
				if(target == null){
					throw new JLFException("未找到请求:"+routeKey);
				}
				Method targetMethod = target.getMethod();
	            Object[] paramsValues = JLFCheckClient.get().check(paramsStr, targetMethod);
	            JLFMVCThreadLocal.setAsyncContext(asyncContext);
				Object resp = target.getMethod().invoke(target.getWebObj(), paramsValues);
				JLFMVCResponse<?> responseBean = new JLFMVCResponse<Object>(resp);
				JLFMVCJumpWay jumpWay;
				String jumpUrl = null;
				if (target.getRouteMethodAnn() == null) {
					jumpWay = JLFMVCJumpWay.ASYN;
				} else {
					jumpWay = EnumUtil.getByID(JLFMVCJumpWay.class, target.getRouteMethodAnn().jumpWay(),
							JLFMVCJumpWay.ASYN);
					jumpUrl = target.getRouteMethodAnn().jumpUrl();
				}
				JLFMVCIJumpProcess jumpProcess = jumpWay.getType();
				JLFJson respJson = JLFJsonClient.get().beanToJson(responseBean);
				jumpProcess.process(asyncContext, respJson, jumpUrl,outputStream);
				LogUtil.get().debug("请求结果:{}",JLFMVCOperatorResult.SUCCESS.getDesc());
				LogUtil.get().debug("响应参数:{}",respJson.toStr());
				return "success";
			} catch (Throwable e) {
				e.printStackTrace();
				LogUtil.get().error(e.getMessage(),e);
				exceptionProcess(e);
				return "fail";
			} finally {
				LogUtil.get().debug("线程结束,开始回收线程资源.......");
				JLFDbPoolClient.get().closeAllConn();
				JLFMVCThreadLocal.deleteDbName();
				JLFMVCThreadLocal.deleteAsyncContext();
				JLFSessionClient.get().clearThreadLocal();
				LogUtil.get().debug("线程结束,回收线程资源结束.......");
			}
		}
		
		/**
		 * 
		 * @Title: exceptionProcess
		 * @Description:异常处理
		 * @param request
		 * @param response
		 * @param e
		 */
		public void exceptionProcess(Throwable e) {
			String errMsg = JLFException.getExceptionMsg();
			if (errMsg == null || errMsg.length() == 0) {
				errMsg = "操作失败";
			}
			JLFMVCResponse<?> responseBean = new JLFMVCResponse<Object>(JLFMVCOperatorResult.FAIL, errMsg);
			JLFJson respJson = JLFJsonClient.get().beanToJson(responseBean);
			JLFMVCJumpWay.ASYN.getType().process(asyncContext,respJson, null,outputStream);
			LogUtil.get().debug("请求结果:{}",JLFMVCOperatorResult.FAIL.getDesc());
			LogUtil.get().debug("响应参数:{}",respJson.toStr());
		}

	}

}
