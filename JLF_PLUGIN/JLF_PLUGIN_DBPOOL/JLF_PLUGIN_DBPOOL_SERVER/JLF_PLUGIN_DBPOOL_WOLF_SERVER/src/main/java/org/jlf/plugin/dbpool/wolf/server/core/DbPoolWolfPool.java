package org.jlf.plugin.dbpool.wolf.server.core;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.jlf.plugin.dbpool.wolf.server.config.DbPoolWolfConfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @ClassName: DbWolfPool
 * @Description:DbWolf连接池实现
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class DbPoolWolfPool {

	/**
	 * 系统已初始化的所有dataSource
	 */
	private static Map<String, ComboPooledDataSource> dataSources = new HashMap<String, ComboPooledDataSource>();

	/**
	 * 
	 * @Title: init
	 * @Description:根据config初始化dataSource
	 * @param config
	 * @throws Exception
	 */
	public static void init(DbPoolWolfConfig config) throws Exception {
		initDataSource(config);
	}

	/**
	 * 
	 * @Title: initDataSource
	 * @Description:根据config初始化dataSource
	 * @param config
	 * @throws Exception
	 */
	private static void initDataSource(DbPoolWolfConfig config) throws Exception {
		String dbName = config.getDbName();
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(config.getDriver());
		dataSource.setJdbcUrl(config.getUrl());
		dataSource.setUser(config.getUserName());
		dataSource.setPassword(config.getPassword());
		
		dataSource.setMinPoolSize(10);
		dataSource.setMaxPoolSize(10);
		dataSource.setInitialPoolSize(10);
		dataSources.put(dbName, dataSource);
	}

	/**
	 * 
	 * @Title: getConnection
	 * @Description:根据dbName从dataSource中获取conn
	 * @param dbName
	 * @return
	 * @throws Exception
	 */
	protected static Connection getConnection(String dbName) throws Exception {
		ComboPooledDataSource dataSource = dataSources.get(dbName);
		if (dataSource == null) {
			return null;
		}
		return dataSource.getConnection();
	}
}
