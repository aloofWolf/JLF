package org.jlf.product.quartz.wolf.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 
 * @ClassName: JLFServer
 * @Description:启动JLF服务
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class JLFServer extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init();
		JLFManager manager = new JLFManager();
		try {
			manager.starts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
