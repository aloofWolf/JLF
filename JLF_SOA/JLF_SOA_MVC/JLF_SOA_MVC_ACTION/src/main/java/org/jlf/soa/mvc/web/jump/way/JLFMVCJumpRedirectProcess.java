package org.jlf.soa.mvc.web.jump.way;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.soa.mvc.metadata.response.JLFMVCResponse;

/**
 * 
 * @ClassName: JLFMVCJumpRedirectProcess
 * @Description:重定向跳转处理
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public class JLFMVCJumpRedirectProcess implements JLFMVCIJumpProcess {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response, JLFMVCResponse<?> respBean, String url)
			throws Exception {
		response.sendRedirect(url);
	}

}
