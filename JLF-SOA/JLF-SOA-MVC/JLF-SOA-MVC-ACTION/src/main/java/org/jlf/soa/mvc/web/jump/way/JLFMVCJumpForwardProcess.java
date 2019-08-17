package org.jlf.soa.mvc.web.jump.way;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFMVCJumpForwardProcess
 * @Description:ת����ת����
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCJumpForwardProcess implements JLFMVCIJumpProcess {

	@Override
	public void process(ServletRequest request, ServletResponse response,JLFJson respJson,
			String url) {
		request.setAttribute("resp", respJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

}
