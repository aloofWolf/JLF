package org.jlf.plugin.dbpool.wolf.server.core;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.jlf.plugin.dbpool.wolf.server.config.DbPoolWolfConfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @ClassName: DbWolfPool
 * @Description:DbWolf���ӳ�ʵ��
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class DbPoolWolfPool {

	/**
	 * ϵͳ�ѳ�ʼ��������dataSource
	 */
	private static Map<String, ComboPooledDataSource> dataSources = new HashMap<String, ComboPooledDataSource>();

	/**
	 * 
	 * @Title: init
	 * @Description:����config��ʼ��dataSource
	 * @param config
	 * @throws Exception
	 */
	public static void init(DbPoolWolfConfig config) throws Exception {
		initDataSource(config);
	}

	/**
	 * 
	 * @Title: initDataSource
	 * @Description:����config��ʼ��dataSource
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
	 * @Description:����dbName��dataSource�л�ȡconn
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
