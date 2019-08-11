package org.jlf.soa.mvc.test.start;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.jlf.core.JLFCore;

@WebServlet(value="/startServlet",loadOnStartup=1)
public class StartServlet extends HttpServlet{

	private static final long serialVersionUID = -2188096744347237353L;
	
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
