package org.jlf.soa.mvc.web.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.common.util.EnumUtil;
import org.jlf.common.util.LogUtil;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.soa.mvc.metadata.enums.JLFMVCOperatorResult;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;
import org.jlf.soa.mvc.metadata.response.JLFMVCResponse;
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
public class JLFMVCServlet extends HttpServlet {

	private static final long serialVersionUID = -1039307679551378098L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		JLFJson params = (JLFJson) request.getAttribute("params");
		LogUtil.get().debug("params=%s", params.toStr());
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
			jumpProcess.process(request, response, responseBean, jumpUrl);
		} catch (Exception e) {
			e.printStackTrace();
			exceptionProcess(request, response, e);
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
		try {
			JLFMVCJumpWay.ASYN.getType().process(request, response, responseBean, null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}