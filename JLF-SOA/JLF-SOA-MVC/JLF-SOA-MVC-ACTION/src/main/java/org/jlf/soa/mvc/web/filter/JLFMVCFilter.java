package org.jlf.soa.mvc.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.client.json.JLFJsonClient;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.soa.mvc.metadata.enums.JLFMVCOperatorResult;
import org.jlf.soa.mvc.metadata.response.JLFMVCResponse;
import org.jlf.soa.mvc.web.jump.way.JLFMVCJumpWay;

/**
 * 
 * @ClassName: JLFMVCFilter
 * @Description:JLFMVCFilter
 * @author Lone Wolf
 * @date 2019年8月16日
 */
public abstract class JLFMVCFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) {

	}

	/**
	 * 
	 * @Title: doFilterProcess
	 * @Description:过滤逻辑的执行
	 * @param request
	 * @param response
	 * @param chain
	 * @throws Throwable
	 */
	protected abstract void doFilterProcess(ServletRequest request, ServletResponse response, FilterChain chain)
			throws Throwable;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			doFilterProcess(request, response, chain);
			chain.doFilter(request, response);
		} catch (Throwable e) {
			LogUtil.get().error(e.getMessage(), e);
			JLFMVCResponse<?> responseBean = new JLFMVCResponse<Object>(JLFMVCOperatorResult.FAIL, "操作失败");
			JLFJson respJson = JLFJsonClient.get().beanToJson(responseBean);
			JLFMVCJumpWay.ASYN.getType().process(request, response, respJson, null);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
