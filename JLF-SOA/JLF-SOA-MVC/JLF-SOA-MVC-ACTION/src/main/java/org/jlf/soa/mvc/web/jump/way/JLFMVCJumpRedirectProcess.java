package org.jlf.soa.mvc.web.jump.way;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
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
	public void process(AsyncContext asyncContext, JLFJson respJson,
			String url, ServletOutputStream outputStream) {
		ServletResponse response = asyncContext.getResponse();
		try {
			((HttpServletResponse) response).sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

}
