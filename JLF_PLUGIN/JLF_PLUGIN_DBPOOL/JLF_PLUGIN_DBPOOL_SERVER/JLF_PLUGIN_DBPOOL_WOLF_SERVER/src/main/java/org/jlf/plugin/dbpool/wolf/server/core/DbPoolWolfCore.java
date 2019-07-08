package org.jlf.plugin.dbPool.wolf.server.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.plugin.dbPool.wolf.server.config.DbPoolWolfChildConfig;

/**
 * 
 * @ClassName: DbWolfCore
 * @Description:DbWolf的集体实现
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class DbPoolWolfCore implements JLFDbPool {

	private DbPoolWolfManager manager = DbPoolWolfManager.getInstance();

	@Override
	public boolean isOpenConn(String dbName) {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			return false;
		}
		return true;
	}

	@Override
	public void openConn(String dbName) {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			conn = DbPoolWolfPool.getConnection(dbName);
			manager.setConn(dbName, conn);
		}
	}

	@Override
	public Connection getConn(String dbName) {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			conn = DbPoolWolfPool.getConnection(dbName);
			manager.setConn(dbName, conn);
		}
		return conn;
	}

	@Override
	public void closeConn(String dbName) {
		Map<String, DbPoolWolfConnectionExt> conns = manager.getConns();
		Connection conn = conns.get(dbName).getConn();
		if (conn == null) {
			throw new JLFException("关闭连接失败,未获取到当前conn对象");
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		conns.remove(dbName);

	}
	
	@Override
	public void closeAllConn() {
		Map<String, DbPoolWolfConnectionExt> conns = manager.getConns();
		if(conns == null || conns.isEmpty()){
			return;
		}
		for (Map.Entry<String, DbPoolWolfConnectionExt> entry : conns.entrySet()) {
			String dbName = entry.getKey();
			Connection conn = entry.getValue().getConn();
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
			conns.remove(dbName);
		}
		
	}

	@Override
	public boolean isOpenTrans(String dbName) {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			return false;
		}
		try {
			return !conn.getAutoCommit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	@Override
	public void openTrans(String dbName) {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			openConn(dbName);
			conn = manager.getConn(dbName);
		}
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

	@Override
	public void commitTrans(String dbName) {
		// 将当前事物打上可提交标记
		DbPoolWolfConnectionExt currConnExt = manager.getConnExt(dbName);
		if (currConnExt == null) {
			throw new JLFException("提交事物失败,未获取到当前conn对象");
		}
		currConnExt.setAllowCommit(true);

		// 首先遍历是打可提交事物标记的连接
		Map<String, DbPoolWolfConnectionExt> conns = manager.getConns();
		for (DbPoolWolfConnectionExt connExt : conns.values()) {
			if (!connExt.isAllowCommit()) {
				return;
			}
		}

		// 遍历所有连接，进行提交和关闭连接
		for (DbPoolWolfConnectionExt connExt : conns.values()) {
			Connection conn = connExt.getConn();
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new JLFException(e);
			}
			conns.remove(dbName);
		}

	}

	@Override
	public void rollbackTrans() {
		Map<String, DbPoolWolfConnectionExt> conns = manager.getConns();
		for (Map.Entry<String, DbPoolWolfConnectionExt> entry : conns.entrySet()) {
			String dbName = entry.getKey();
			Connection conn = entry.getValue().getConn();
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}

			conns.remove(dbName);
		}
	}

	@Override
	public void initChildDatabases(List<Map<String, Object>> configs) {
		for (Map<String, Object> map : configs) {
			DbPoolWolfChildConfig config = JLFCheckClient.get().check(map, DbPoolWolfChildConfig.class);
			DbPoolWolfPool.initChildDataSource(config);
		}

	}

	

}
