package org.jlf.soa.mvc.web.jump.way;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFMVCJumpForwardProcess
 * @Description:转发跳转处理
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public class JLFMVCJumpForwardProcess implements JLFMVCIJumpProcess {

	@Override
	public void process(AsyncContext asyncContext,JLFJson respJson,
			String url, ServletOutputStream outputStream) {
		ServletRequest request = asyncContext.getRequest();
		ServletResponse response = asyncContext.getResponse();
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
