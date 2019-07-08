package org.jlf.soa.mvc.web.jump.way;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.soa.mvc.metadata.response.JLFMVCResponse;

/**
 * 
 * @ClassName: JLFMVCJumpAsynProcess
 * @Description:�첽��ת����
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCJumpAsynProcess implements JLFMVCIJumpProcess {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response, JLFMVCResponse<?> respBean,
			String url) {
		response.setCharacterEncoding("UTF-8");
		String respJsonStr = JLFJsonClient.get().beanToJsonStr(respBean);
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
