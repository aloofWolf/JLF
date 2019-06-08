package org.jlf.soa.mvc.web.jump.way;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public void process(HttpServletRequest request, HttpServletResponse response, JLFMVCResponse<?> respBean, String url)
			throws Exception {
		request.setAttribute("resp", respBean);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
