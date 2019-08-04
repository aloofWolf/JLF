package org.jlf.plugin.session.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.jlf.core.JLFCore;

/**
 * 
 * @ClassName: JLFServer
 * @Description:����JLF����
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class JLFServer extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init();
		try {
			JLFCore.starts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
