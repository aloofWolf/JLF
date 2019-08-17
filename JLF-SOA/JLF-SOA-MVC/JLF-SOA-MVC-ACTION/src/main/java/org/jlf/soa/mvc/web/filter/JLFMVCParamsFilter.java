package org.jlf.soa.mvc.web.filter;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.jlf.common.util.LogUtil;
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
public class JLFMVCParamsFilter extends JLFMVCFilter {

	/**
	 * 将web端传来的参数组包，组成JSON
	 */
	@Override
	public void doFilterProcess(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException {
		LogUtil.get().debug("JLFMVCParamsFilter过滤器开始执行.......");
		StringBuffer params = new StringBuffer();
		String line = null;
		BufferedReader reader;
		reader = request.getReader();
		while ((line = reader.readLine()) != null) {
			params.append(line);
		}
		JLFJson paramsJson = JLFJsonClient.get().jsonStrToJson(params.toString());
		request.setAttribute("params", paramsJson);
		LogUtil.get().debug("请求参数:{}", params);
		LogUtil.get().debug("JLFMVCParamsFilter过滤器执行结束.......");
	}
}
