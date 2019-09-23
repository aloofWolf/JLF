package org.jlf.soa.mvc.web.jump.way;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;

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
	 * @param asyncContext
	 * @param respJson
	 * @param url
	 * @param outputStream
	 */
	public void process(AsyncContext asyncContext, JLFJson respJson, String url, ServletOutputStream outputStream);

}
