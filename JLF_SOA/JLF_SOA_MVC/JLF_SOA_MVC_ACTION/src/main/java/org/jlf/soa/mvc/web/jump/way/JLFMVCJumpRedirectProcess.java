package org.jlf.soa.mvc.web.jump.way;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.common.exception.JLFException;
import org.jlf.soa.mvc.metadata.response.JLFMVCResponse;

/**
 * 
 * @ClassName: JLFMVCJumpRedirectProcess
 * @Description:�ض�����ת����
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCJumpRedirectProcess implements JLFMVCIJumpProcess {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response, JLFMVCResponse<?> respBean,
			String url) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

}
