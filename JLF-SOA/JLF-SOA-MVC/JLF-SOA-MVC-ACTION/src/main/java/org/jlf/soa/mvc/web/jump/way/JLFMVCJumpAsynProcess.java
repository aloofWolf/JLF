package org.jlf.soa.mvc.web.jump.way;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFMVCJumpAsynProcess
 * @Description:异步跳转处理
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public class JLFMVCJumpAsynProcess implements JLFMVCIJumpProcess {

	@Override
	public void process(ServletRequest request, ServletResponse response, JLFJson respJson,
			String url) {
		response.setCharacterEncoding("UTF-8");
		String respJsonStr = respJson.toStr();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(respJsonStr);
		} catch (IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		} finally {
			out.close();
		}

	}

}
