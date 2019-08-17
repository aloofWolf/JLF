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
 * @Description:����������
 * @author Lone Wolf
 * @date 2019��5��26��
 */

@WebFilter(filterName = "ParamsFilter", urlPatterns = "/*")
public class JLFMVCParamsFilter extends JLFMVCFilter {

	/**
	 * ��web�˴����Ĳ�����������JSON
	 */
	@Override
	public void doFilterProcess(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException {
		LogUtil.get().debug("JLFMVCParamsFilter��������ʼִ��.......");
		StringBuffer params = new StringBuffer();
		String line = null;
		BufferedReader reader;
		reader = request.getReader();
		while ((line = reader.readLine()) != null) {
			params.append(line);
		}
		JLFJson paramsJson = JLFJsonClient.get().jsonStrToJson(params.toString());
		request.setAttribute("params", paramsJson);
		LogUtil.get().debug("�������:{}", params);
		LogUtil.get().debug("JLFMVCParamsFilter������ִ�н���.......");
	}
}
