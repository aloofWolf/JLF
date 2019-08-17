package org.jlf.soa.mvc.web.jump.way;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFMVCIJumpProcess
 * @Description:��ת��ʽ�ӿ�
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public interface JLFMVCIJumpProcess {

	/**
	 * 
	 * @Title: process
	 * @Description:��ת����
	 * @param request
	 * @param response
	 * @param respBean
	 * @param url
	 */
	public void process(ServletRequest request, ServletResponse response, JLFJson respJson,
			String url);

}
