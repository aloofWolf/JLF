package org.jlf.soa.mvc.web.jump.way;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;

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
	 * @param asyncContext
	 * @param respJson
	 * @param url
	 * @param outputStream
	 */
	public void process(AsyncContext asyncContext, JLFJson respJson, String url, ServletOutputStream outputStream);

}
