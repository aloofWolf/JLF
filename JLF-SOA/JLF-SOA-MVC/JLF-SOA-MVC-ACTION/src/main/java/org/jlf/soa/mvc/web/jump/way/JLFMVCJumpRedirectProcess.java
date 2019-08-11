package org.jlf.soa.mvc.web.jump.way;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFMVCJumpRedirectProcess
 * @Description:重定向跳转处理
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public class JLFMVCJumpRedirectProcess implements JLFMVCIJumpProcess {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response, JLFJson respJson,
			String url) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

}
