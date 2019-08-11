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
 * @Description:参数过滤器
 * @author Lone Wolf
 * @date 2019年5月26日
 */

@WebFilter(filterName = "ParamsFilter", urlPatterns = "/*")
public class JLFMVCParamsFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) {

	}

	/**
	 * @Title: paramsPackage
	 * @Description:将web端传来的参数组包，组成JSON
	 * @param request
	 */
	public void paramsPackage(ServletRequest request) {
		LogUtil.get().debug("JLFMVCParamsFilter过滤器开始执行.......");
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
		LogUtil.get().debug("请求参数:{}", params);
		LogUtil.get().debug("JLFMVCParamsFilter过滤器执行结束.......");
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
