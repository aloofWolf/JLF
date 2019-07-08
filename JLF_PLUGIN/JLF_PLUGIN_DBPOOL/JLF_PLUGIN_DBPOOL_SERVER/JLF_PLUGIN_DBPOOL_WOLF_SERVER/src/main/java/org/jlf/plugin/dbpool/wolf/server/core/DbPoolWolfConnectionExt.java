package org.jlf.plugin.dbPool.wolf.server.core;

import java.sql.Connection;

/**
 * 
 * @ClassName: DbWolfConnectionExt
 * @Description:connection����չ
 * @author Lone Wolf
 * @date 2019��5��26��
 */
public class DbPoolWolfConnectionExt {

	private Connection conn; // conn����

	private boolean allowCommit; // conn�Ƿ���ύ

	public DbPoolWolfConnectionExt(Connection conn) {
		this.conn = conn;
		this.allowCommit = false;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public boolean isAllowCommit() {
		return allowCommit;
	}

	public void setAllowCommit(boolean allowCommit) {
		this.allowCommit = allowCommit;
	}
}
