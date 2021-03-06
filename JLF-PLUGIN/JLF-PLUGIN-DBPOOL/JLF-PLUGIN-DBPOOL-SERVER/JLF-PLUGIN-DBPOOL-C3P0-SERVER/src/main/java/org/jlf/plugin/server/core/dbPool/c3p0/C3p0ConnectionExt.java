package org.jlf.plugin.server.core.dbPool.c3p0;

import java.sql.Connection;

/**
 * 
 * @ClassName: C3p0ConnectionExt
 * @Description:connection的扩展
 * @author Lone Wolf
 * @date 2019年5月26日
 */
public class C3p0ConnectionExt {

	private Connection conn; // conn连接

	private boolean allowCommit; // conn是否可提交

	public C3p0ConnectionExt(Connection conn) {
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
