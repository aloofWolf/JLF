package org.jlf.soa.mvc.web.jump.way;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public void process(HttpServletRequest request, HttpServletResponse response, JLFMVCResponse<?> respBean, String url)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		String respJsonStr = JLFJsonClient.get().beanToJsonStr(respBean);
		PrintWriter out = response.getWriter();
		out.write(respJsonStr);
		out.close();
	}

}
