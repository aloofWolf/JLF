package org.jlf.soa.mvc.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.common.util.EnumUtil;
import org.jlf.common.util.LogUtil;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.client.dbPool.JLFDbPoolClient;
import org.jlf.plugin.client.json.JLFJsonClient;
import org.jlf.plugin.client.session.JLFSessionClient;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.soa.mvc.metadata.enums.JLFMVCOperatorResult;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;
import org.jlf.soa.mvc.metadata.response.JLFMVCResponse;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
import org.jlf.soa.mvc.web.jump.way.JLFMVCIJumpProcess;
import org.jlf.soa.mvc.web.jump.way.JLFMVCJumpWay;
import org.jlf.soa.mvc.web.route.JLFMVCRouteManager;
import org.jlf.soa.mvc.web.route.JLFMVCRouteTarget;

/**
 * 
 * @ClassName: JLFMVCServlet
 * @Description:JLFMVCServlet
 * @author Lone Wolf
 * @date 2019年5月27日
 */

@WebServlet(name="JLF",value="/JLF",asyncSupported=true)
public class JLFMVCServlet extends HttpServlet {

	private static final long serialVersionUID = -1039307679551378098L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		JLFJson params = (JLFJson) request.getAttribute("params");
		process(request, response, params);
	}

	/**
	 * 
	 * @Title: process
	 * @Description:核心处理
	 * @param request
	 * @param response
	 * @param params
	 */
	private void process(HttpServletRequest request, HttpServletResponse response, JLFJson params) {
		try {
			String reqTypeObj = params.getStr("reqType");
			JLFMVCRouteTarget target = JLFMVCRouteManager.getTarget(reqTypeObj);
			JLFMVCRequest requestBean = (JLFMVCRequest) JLFCheckClient.get().check(params.toStr(),
					target.getCheckCls());
			requestBean.setRequest(request);
			requestBean.setResponse(response);
			Object resp = target.getMethod().invoke(target.getWebObj(), requestBean);
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
			jumpProcess.process(request, response, respJson, jumpUrl);
			LogUtil.get().debug("请求结果:{}",JLFMVCOperatorResult.SUCCESS.getDesc());
			LogUtil.get().debug("响应参数:{}",respJson.toStr());
		} catch (Exception e) {
			e.printStackTrace();
			exceptionProcess(request, response, e);
		}finally{
			LogUtil.get().debug("线程结束,开始回收线程资源.......");
			JLFDbPoolClient.get().closeAllConn();
			JLFMVCThreadLocal.deleteDbName();
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
	public void exceptionProcess(HttpServletRequest request, HttpServletResponse response, Exception e) {
		String errMsg = e.getMessage();
		if (errMsg == null || errMsg.length() == 0) {
			errMsg = "操作失败";
		}
		JLFMVCResponse<?> responseBean = new JLFMVCResponse<Object>(JLFMVCOperatorResult.FAIL, "操作失败");
		JLFJson respJson = JLFJsonClient.get().beanToJson(responseBean);
		JLFMVCJumpWay.ASYN.getType().process(request, response, respJson, null);
		LogUtil.get().debug("请求结果:{}",JLFMVCOperatorResult.FAIL.getDesc());
		LogUtil.get().debug("响应参数:{}",respJson.toStr());
	}
}