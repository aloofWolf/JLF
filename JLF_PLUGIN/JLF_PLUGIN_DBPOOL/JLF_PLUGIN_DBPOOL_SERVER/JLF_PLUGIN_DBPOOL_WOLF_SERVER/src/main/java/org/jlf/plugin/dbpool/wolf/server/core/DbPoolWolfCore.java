package org.jlf.plugin.dbpool.wolf.server.core;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.dbpool.server.api.JLFDbPool;
import org.jlf.plugin.dbpool.wolf.server.config.DbPoolWolfConfig;

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
	public boolean isOpenConn(String dbName) throws Exception {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			return false;
		}
		return true;
	}

	@Override
	public void openConn(String dbName) throws Exception {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			conn = DbPoolWolfPool.getConnection(dbName);
			manager.setConn(dbName, conn);
		}
	}

	@Override
	public Connection getConn(String dbName) throws Exception {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			throw new JLFException("δ��ȡ���ӿ�����:" + dbName);
		}
		return conn;
	}

	@Override
	public void closeConn(String dbName) throws Exception {
		Map<String, DbPoolWolfConnectionExt> conns = manager.getConns();
		Connection conn = conns.get(dbName).getConn();
		if (conn == null) {
			throw new JLFException("�ر�����ʧ��,δ��ȡ����ǰconn����");
		}
		conn.close();
		conns.remove(dbName);

	}

	@Override
	public boolean isOpenTrans(String dbName) throws Exception {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			throw new JLFException("�ж��Ƿ������ʧ��,δ��ȡ����ǰconn����");
		}
		return !conn.getAutoCommit();
	}

	@Override
	public void openTrans(String dbName) throws Exception {
		Connection conn = manager.getConn(dbName);
		if (conn == null) {
			throw new JLFException("������ʧ��,δ��ȡ����ǰconn����");
		}
		conn.setAutoCommit(false);

	}

	@Override
	public void commitTrans(String dbName) throws Exception {
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
			conn.commit();
			conn.close();
			conns.remove(dbName);
		}

	}

	@Override
	public void rollbackTrans() throws Exception {
		Map<String, DbPoolWolfConnectionExt> conns = manager.getConns();
		for (Map.Entry<String, DbPoolWolfConnectionExt> entry : conns.entrySet()) {
			String dbName = entry.getKey();
			Connection conn = entry.getValue().getConn();
			conn.rollback();
			conn.close();
			conns.remove(dbName);
		}
	}

	@Override
	public void initChildDatabases(List<Map<String, Object>> configs) throws Exception {
		for (Map<String, Object> map : configs) {
			DbPoolWolfConfig config = JLFCheckClient.get().check(map, DbPoolWolfConfig.class);
			DbPoolWolfPool.init(config);
		}

	}

}
