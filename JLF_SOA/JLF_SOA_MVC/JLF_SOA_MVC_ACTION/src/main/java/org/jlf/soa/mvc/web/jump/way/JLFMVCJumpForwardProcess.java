package org.jlf.soa.mvc.web.jump.way;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.common.exception.JLFException;
import org.jlf.soa.mvc.metadata.response.JLFMVCResponse;

/**
 * 
 * @ClassName: JLFMVCJumpForwardProcess
 * @Description:ת����ת����
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCJumpForwardProcess implements JLFMVCIJumpProcess {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response, JLFMVCResponse<?> respBean,
			String url) {
		request.setAttribute("resp", respBean);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

}
