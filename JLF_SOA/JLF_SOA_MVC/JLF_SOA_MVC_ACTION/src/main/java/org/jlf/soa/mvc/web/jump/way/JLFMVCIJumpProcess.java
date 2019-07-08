package org.jlf.soa.mvc.web.jump.way;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.soa.mvc.metadata.response.JLFMVCResponse;

/**
 * 
 * @ClassName: JLFMVCIJumpProcess
 * @Description:跳转方式接口
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public interface JLFMVCIJumpProcess {

	/**
	 * 
	 * @Title: process
	 * @Description:跳转处理
	 * @param request
	 * @param response
	 * @param respBean
	 * @param url
	 */
	public void process(HttpServletRequest request, HttpServletResponse response, JLFMVCResponse<?> respBean,
			String url);

}
