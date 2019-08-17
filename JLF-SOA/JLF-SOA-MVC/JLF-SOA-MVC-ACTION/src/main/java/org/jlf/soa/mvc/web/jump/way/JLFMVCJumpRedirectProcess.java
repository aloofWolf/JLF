package org.jlf.soa.mvc.web.jump.way;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFMVCJumpRedirectProcess
 * @Description:�ض�����ת����
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCJumpRedirectProcess implements JLFMVCIJumpProcess {

	@Override
	public void process(ServletRequest request, ServletResponse response, JLFJson respJson,
			String url) {
		try {
			((HttpServletResponse) response).sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

}
