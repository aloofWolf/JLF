package org.jlf.plugin.server.core.dbPool.c3p0;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.plugin.server.core.dbPool.c3p0.config.C3p0ChildConfig;
import org.jlf.plugin.server.core.dbPool.c3p0.config.C3p0MainConfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @ClassName: C3p0Pool
 * @Description:c3p0���ӳ�ʵ��
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class C3p0Pool {

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
	public static void initMainDataSource(C3p0MainConfig config) {
		String dbName = JLFDbPool.mainDbName;
		initDataSource(dbName, config);
	}

	/**
	 * 
	 * @Title: initChildDataSource
	 * @Description:����config��ʼ���ӿ�dataSource
	 * @param config
	 * @throws Exception
	 */
	public static void initChildDataSource(C3p0ChildConfig config) {
		String dbName = config.getDbName();
		initDataSource(dbName, config);
	}

	/**
	 * 
	 * @Title: initDataSource
	 * @Description:����config��ʼ��dataSource
	 * @param dbName
	 * @param config
	 */
	private static void initDataSource(String dbName, C3p0MainConfig config) {
		dataSources.put(dbName, config.getDataSource());
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
