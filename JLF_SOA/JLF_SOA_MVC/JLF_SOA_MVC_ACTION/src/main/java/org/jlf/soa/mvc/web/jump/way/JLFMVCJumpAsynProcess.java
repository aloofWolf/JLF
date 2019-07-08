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
 * @Description:异步跳转处理
 * @author Lone Wolf
 * @date 2019年5月27日
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
