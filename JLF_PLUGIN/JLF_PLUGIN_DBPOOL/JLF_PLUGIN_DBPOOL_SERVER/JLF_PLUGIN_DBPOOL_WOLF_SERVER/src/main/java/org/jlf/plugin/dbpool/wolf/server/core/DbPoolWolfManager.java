package org.jlf.plugin.dbPool.wolf.server.core;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: DbWolfManager
 * @Description:DbWolf���̰߳�ȫ����
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class DbPoolWolfManager {

	private DbPoolWolfManager() {
	}

	private static DbPoolWolfManager INSTANCE = new DbPoolWolfManager();

	public static DbPoolWolfManager getInstance() {
		return INSTANCE;
	}

	/**
	 * ��ǰ�̵߳��Ѵ�����conn
	 */
	private ThreadLocal<Map<String, DbPoolWolfConnectionExt>> conns = new ThreadLocal<Map<String, DbPoolWolfConnectionExt>>();

	/**
	 * 
	 * @Title: getConn
	 * @Description:����dbName��ȡ��ǰ�̵߳�conn
	 * @param dbName
	 * @return
	 */
	public Connection getConn(String dbName) {
		Map<String, DbPoolWolfConnectionExt> map = conns.get();
		if (map == null) {
			map = new HashMap<String, DbPoolWolfConnectionExt>();
		}
		conns.set(map);
		DbPoolWolfConnectionExt connectionBean = map.get(dbName);
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
		DbPoolWolfConnectionExt connExt = new DbPoolWolfConnectionExt(conn);
		Map<String, DbPoolWolfConnectionExt> map = conns.get();
		map.put(dbName, connExt);
		conns.set(map);
	}

	/**
	 * 
	 * @Title: getConnExt
	 * @Description:����dbName��ȡ��ǰ�̵߳�connExt
	 * @param dbName
	 * @return
	 */
	public DbPoolWolfConnectionExt getConnExt(String dbName) {
		return conns.get().get(dbName);
	}

	/**
	 * 
	 * @Title: getConns
	 * @Description:��ȡ��ǰ�̵߳������Ѵ򿪵�conn
	 * @return
	 */
	public Map<String, DbPoolWolfConnectionExt> getConns() {
		return conns.get();
	}

}
