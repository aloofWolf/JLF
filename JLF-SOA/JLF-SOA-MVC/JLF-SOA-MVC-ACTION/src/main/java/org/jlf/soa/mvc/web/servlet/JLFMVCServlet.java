package org.jlf.soa.mvc.web.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFMVCServlet
 * @Description:JLFMVCServlet
 * @author Lone Wolf
 * @date 2019年5月27日
 */

@WebServlet(name="JLF",value="/JLF",asyncSupported=true)
public class JLFMVCServlet extends HttpServlet {

	private static final long serialVersionUID = -1039307679551378098L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		JLFJson params = (JLFJson) request.getAttribute("params");
		process(request, response, params);
	}

	/**
	 * 
	 * @Title: process
	 * @Description:核心处理
	 * @param request
	 * @param response
	 * @param params
	 */
	private void process(HttpServletRequest request, HttpServletResponse response, JLFJson params) {
		AsyncContext asyncContext = request.startAsync();
		asyncContext.setTimeout(900000000);  
		ServletInputStream inputStream = null;
		ServletOutputStream outputStream = null;
		try {
			inputStream = request.getInputStream();
			outputStream = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLFMVCReadListener requestListener = new JLFMVCReadListener(asyncContext,inputStream,outputStream);
        inputStream.setReadListener(requestListener);
	}
}