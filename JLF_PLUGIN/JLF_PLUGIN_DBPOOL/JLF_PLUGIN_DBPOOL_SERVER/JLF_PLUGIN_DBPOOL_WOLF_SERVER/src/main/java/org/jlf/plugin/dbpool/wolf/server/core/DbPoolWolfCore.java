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
 * @Description:DbWolf�ļ���ʵ��
 * @author Lone Wolf
 * @date 2019��5��22��
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
			throw new JLFException("�ر�����ʧ��,δ��ȡ����ǰconn����");
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
		// ����ǰ������Ͽ��ύ���
		DbPoolWolfConnectionExt currConnExt = manager.getConnExt(dbName);
		if (currConnExt == null) {
			throw new JLFException("�ύ����ʧ��,δ��ȡ����ǰconn����");
		}
		currConnExt.setAllowCommit(true);

		// ���ȱ����Ǵ���ύ�����ǵ�����
		Map<String, DbPoolWolfConnectionExt> conns = manager.getConns();
		for (DbPoolWolfConnectionExt connExt : conns.values()) {
			if (!connExt.isAllowCommit()) {
				return;
			}
		}

		// �����������ӣ������ύ�͹ر�����
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
