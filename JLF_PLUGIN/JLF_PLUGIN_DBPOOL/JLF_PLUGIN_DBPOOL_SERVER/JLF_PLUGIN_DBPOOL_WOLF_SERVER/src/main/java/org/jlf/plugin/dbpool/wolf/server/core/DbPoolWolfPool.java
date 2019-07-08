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
 * @Description:DbWolf���ӳ�ʵ��
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class DbPoolWolfPool {

	/**
	 * ϵͳ�ѳ�ʼ��������dataSource
	 */
	private static Map<String, ComboPooledDataSource> dataSources = new ConcurrentHashMap<String, ComboPooledDataSource>();

	/**
	 * 
	 * @Title: initMainDataSource
	 * @Description:����config��ʼ������dataSource
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
	 * @Description:����config��ʼ���ӿ�dataSource
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
	    * @Description:����config��ʼ��dataSource
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
	 * @Description:����dbName��dataSource�л�ȡconn
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
