package org.jlf.plugin.dbPool.wolf.server.config;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;

/**
 * 
 * @ClassName: DbPoolWolfChildConfig
 * @Description:DbWolf子库配置
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class DbPoolWolfChildConfig extends DbPoolWolfMainConfig {

	@JLFCheckAnn
	private String dbName;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		if (dbName.equals(JLFDbPool.mainDbName)) {
			throw new JLFException("数据库名称不能与主数据库名称相同:" + dbName);
		}
		this.dbName = dbName;
	}

}
