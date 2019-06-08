package org.jlf.soa.mvc.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFMVCFilter
 * @Description:����������
 * @author Lone Wolf
 * @date 2019��5��26��
 */
public class JLFMVCParamsFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	/**
	 * @Title: paramsPackage
	 * @Description:��web�˴����Ĳ�����������JSON
	 * @param request
	 * @throws IOException
	 * @throws ServletException
	 */
	@SuppressWarnings("unchecked")
	public void paramsPackage(ServletRequest request) throws IOException, ServletException {
		LogUtil.get().debug("JLFMVCParamsFilter��������ʼִ��.......");
		JLFJson params = JLFJsonClient.get().newJson();
		Enumeration<String> paraNames = request.getParameterNames();
		String paramName;
		String paramValue;
		while (paraNames.hasMoreElements()) {
			paramName = paraNames.nextElement();
			paramValue = request.getParameter(paramName);
			if (paramValue != null && !"".equals(paramValue.trim())) {
				try {
					params.put(paramName, paramValue);
				} catch (Exception e) {
					e.printStackTrace();
					throw new ServletException(String.format("��������,%s=%s", paramName,paramValue));
				}
			}
		}
		request.setAttribute("params", params);
		LogUtil.get().debug("JLFMVCParamsFilter������ִ�н���.......");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		paramsPackage(request);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
