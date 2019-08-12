package org.jlf.soa.mvc.test.start;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.jlf.core.JLFCore;
import org.jlf.plugin.client.dbPool.JLFDbPoolClient;

/**
 * 
 * @ClassName: StartServlet
 * @Description:StartServlet
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ12ÈÕ
 */
@WebServlet(value = "/startServlet", loadOnStartup = 1)
public class StartServlet extends HttpServlet {

	private static final long serialVersionUID = -2188096744347237353L;

	public void init(ServletConfig config) throws ServletException {
		super.init();
		try {
			JLFCore.starts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Map<String, Object>> dbConfigs = new ArrayList<Map<String, Object>>();
		Map<String, Object> dbConfig = new HashMap<String, Object>();
		dbConfig.put("driver", "com.mysql.cj.jdbc.Driver");
		dbConfig.put("url", "jdbc:mysql://39.108.166.34:3306/wolf2?serverTimezone=GMT%2B8");
		dbConfig.put("userName", "root");
		dbConfig.put("password", "yun4xue2wen2");
		dbConfig.put("dbName", "wolf2");
		dbConfigs.add(dbConfig);
		JLFDbPoolClient.get().initChildDatabases(dbConfigs);
	}

}
