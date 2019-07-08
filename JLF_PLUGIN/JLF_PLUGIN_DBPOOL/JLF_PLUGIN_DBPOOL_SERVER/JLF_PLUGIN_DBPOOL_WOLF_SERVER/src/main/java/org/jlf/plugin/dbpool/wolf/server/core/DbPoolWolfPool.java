package org.jlf.plugin.dbPool.wolf.server.core;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.plugin.dbPool.wolf.server.config.DbPoolWolfChildConfig;
import org.jlf.plugin.dbPool.wolf.server.config.DbPoolWolfMainConfig;

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
	private static Map<String, ComboPooledDataSource> dataSources = new ConcurrentHashMap<String, ComboPooledDataSource>();

	/**
	 * 
	 * @Title: initMainDataSource
	 * @Description:根据config初始化主库dataSource
	 * @param config
	 * @throws Exception
	 */
	public static void initMainDataSource(DbPoolWolfMainConfig config) {
		String dbName = JLFDbPool.mainDbName;
		initDataSource(dbName,config);
	}
	
	/**
	 * 
	 * @Title: initChildDataSource
	 * @Description:根据config初始化子库dataSource
	 * @param config
	 * @throws Exception
	 */
	public static void initChildDataSource(DbPoolWolfChildConfig config) {
		String dbName = JLFDbPool.mainDbName;
		initDataSource(dbName,config);
	}
	
	/**
	 * 
	    * @Title: initDataSource
	    * @Description:根据config初始化dataSource
	    * @param dbName
	    * @param config
	 */
	private static void initDataSource(String dbName,DbPoolWolfMainConfig config){
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(config.getDriver());
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
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
	 */
	protected static Connection getConnection(String dbName) {
		ComboPooledDataSource dataSource = dataSources.get(dbName);
		if (dataSource == null) {
			return null;
		}
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}
}
