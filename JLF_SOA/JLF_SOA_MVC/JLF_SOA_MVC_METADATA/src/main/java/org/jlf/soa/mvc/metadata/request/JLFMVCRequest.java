package org.jlf.soa.mvc.metadata.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: JLFMVCRequest
 * @Description:����������ı�ʶ
 * @author Lone Wolf
 * @date 2019��6��1��
 */

public class JLFMVCRequest {

	@JLFCheckAnn(isSkipValidate=true)
	private HttpServletRequest request;
	@JLFCheckAnn(isSkipValidate=true)
	private HttpServletResponse response;
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
}
