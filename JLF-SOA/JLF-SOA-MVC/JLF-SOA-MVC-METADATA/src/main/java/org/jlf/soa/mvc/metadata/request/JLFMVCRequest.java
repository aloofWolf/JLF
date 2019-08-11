package org.jlf.soa.mvc.metadata.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: JLFMVCRequest
 * @Description:参数请求类的标识
 * @author Lone Wolf
 * @date 2019年6月1日
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
