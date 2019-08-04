package org.jlf.plugin.server.core.dbPool.c3p0;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: C3p0Manager
 * @Description:c3p0的线程安全管理
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class C3p0Manager {

	private C3p0Manager() {
	}

	private static C3p0Manager INSTANCE = new C3p0Manager();

	public static C3p0Manager getInstance() {
		return INSTANCE;
	}

	/**
	 * 当前线程的已打来的conn
	 */
	private ThreadLocal<Map<String, C3p0ConnectionExt>> conns = new ThreadLocal<Map<String, C3p0ConnectionExt>>();

	/**
	 * 
	 * @Title: getConn
	 * @Description:根据dbName获取当前线程的conn
	 * @param dbName
	 * @return
	 */
	public Connection getConn(String dbName) {
		Map<String, C3p0ConnectionExt> map = conns.get();
		if (map == null) {
			map = new HashMap<String, C3p0ConnectionExt>();
		}
		conns.set(map);
		C3p0ConnectionExt connectionBean = map.get(dbName);
		if (connectionBean == null) {
			return null;
		}
		return connectionBean.getConn();
	}

	/**
	 * 
	 * @Title: setConn
	 * @Description:setConn
	 * @param dbName
	 * @param conn
	 */
	public void setConn(String dbName, Connection conn) {
		C3p0ConnectionExt connExt = new C3p0ConnectionExt(conn);
		Map<String, C3p0ConnectionExt> map = conns.get();
		map.put(dbName, connExt);
		conns.set(map);
	}

	/**
	 * 
	 * @Title: getConnExt
	 * @Description:根据dbName获取当前线程的connExt
	 * @param dbName
	 * @return
	 */
	public C3p0ConnectionExt getConnExt(String dbName) {
		return conns.get().get(dbName);
	}

	/**
	 * 
	 * @Title: getConns
	 * @Description:获取当前线程的所有已打开的conn
	 * @return
	 */
	public Map<String, C3p0ConnectionExt> getConns() {
		return conns.get();
	}

}
