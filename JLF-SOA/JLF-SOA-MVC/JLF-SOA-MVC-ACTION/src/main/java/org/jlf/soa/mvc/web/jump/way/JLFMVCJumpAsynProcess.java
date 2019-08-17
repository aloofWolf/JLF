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
 * @Description:�첽��ת����
 * @author Lone Wolf
 * @date 2019��5��27��
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
