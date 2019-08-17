package org.jlf.soa.mvc.web.jump.way;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jlf.plugin.json.server.api.JLFJson;

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
	public void process(ServletRequest request, ServletResponse response, JLFJson respJson,
			String url);

}
