package org.jlf.plugin.server.core.dbPool.c3p0;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.plugin.server.core.dbPool.c3p0.config.C3p0ChildConfig;

/**
 * 
 * @ClassName: C3p0Core
 * @Description:DbWolf的集体实现
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class C3p0Core implements JLFDbPool {

	private C3p0Manager manager = C3p0Manager.getInstance();

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
			conn = C3p0Pool.getConnection(dbName);
			manager.setConn(dbName, conn);
		}
	}

	@Override
	public Connection getConn(String dbName) {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			conn = C3p0Pool.getConnection(dbName);
			manager.setConn(dbName, conn);
		}
		return conn;
	}

	@Override
	public void closeConn(String dbName) {
		Map<String, C3p0ConnectionExt> conns = manager.getConns();
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
		Map<String, C3p0ConnectionExt> conns = manager.getConns();
		if (conns == null || conns.isEmpty()) {
			return;
		}
		for (Map.Entry<String, C3p0ConnectionExt> entry : conns.entrySet()) {
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
		conns.clear();

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
		C3p0ConnectionExt currConnExt = manager.getConnExt(dbName);
		if (currConnExt == null) {
			throw new JLFException("提交事物失败,未获取到当前conn对象");
		}
		currConnExt.setAllowCommit(true);

		// 首先遍历是打可提交事物标记的连接
		Map<String, C3p0ConnectionExt> conns = manager.getConns();
		for (C3p0ConnectionExt connExt : conns.values()) {
			if (!connExt.isAllowCommit()) {
				return;
			}
		}

		// 遍历所有连接，进行提交和关闭连接
		for (C3p0ConnectionExt connExt : conns.values()) {
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
		Map<String, C3p0ConnectionExt> conns = manager.getConns();
		for (Map.Entry<String, C3p0ConnectionExt> entry : conns.entrySet()) {
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
			C3p0ChildConfig config = JLFCheckClient.get().check(map, C3p0ChildConfig.class);
			C3p0Pool.initChildDataSource(config);
		}

	}

}
