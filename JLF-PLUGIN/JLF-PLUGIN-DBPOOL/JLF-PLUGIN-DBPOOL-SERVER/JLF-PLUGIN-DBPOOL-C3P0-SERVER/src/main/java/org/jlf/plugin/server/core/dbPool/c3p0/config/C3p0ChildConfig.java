package org.jlf.plugin.server.core.dbPool.c3p0.config;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;

/**
 * 
 * @ClassName: C3p0ChildConfig
 * @Description:c3p0子库配置
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class C3p0ChildConfig extends C3p0MainConfig {

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
