package org.jlf.soa.mvc.web.jump.way;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.json.server.api.JLFJson;
import org.jlf.soa.mvc.web.servlet.JLFMVCWriteListener;

/**
 * 
 * @ClassName: JLFMVCJumpAsynProcess
 * @Description:�첽��ת����
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCJumpAsynProcess implements JLFMVCIJumpProcess {

	@Override
	public void process(AsyncContext asyncContext, JLFJson respJson,
			String url, ServletOutputStream outputStream) {
		HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		try {
			outputStream.write(respJson.toStr().getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		JLFMVCWriteListener responseListener = new JLFMVCWriteListener(asyncContext);
		outputStream.setWriteListener(responseListener);

	}

}
