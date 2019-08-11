package org.jlf.soa.mvc.web.filter;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.jlf.common.util.LogUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.client.json.JLFJsonClient;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFMVCFilter
 * @Description:����������
 * @author Lone Wolf
 * @date 2019��5��26��
 */

@WebFilter(filterName = "ParamsFilter", urlPatterns = "/*")
public class JLFMVCParamsFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) {

	}

	/**
	 * @Title: paramsPackage
	 * @Description:��web�˴����Ĳ�����������JSON
	 * @param request
	 */
	public void paramsPackage(ServletRequest request) {
		LogUtil.get().debug("JLFMVCParamsFilter��������ʼִ��.......");
		StringBuffer params = new StringBuffer();
		String line = null;
		BufferedReader reader;
		try {
			reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				params.append(line);
			}
		} catch (IOException e) {
			throw new JLFException(e);
		}

		JLFJson paramsJson = JLFJsonClient.get().jsonStrToJson(params.toString());
		request.setAttribute("params", paramsJson);
		LogUtil.get().debug("�������:{}", params);
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
