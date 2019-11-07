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
 * @Description:c3p0连接池实现
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class C3p0Pool {

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
	public static void initMainDataSource(C3p0MainConfig config) {
		String dbName = JLFDbPool.mainDbName;
		initDataSource(dbName, config);
	}

	/**
	 * 
	 * @Title: initChildDataSource
	 * @Description:根据config初始化子库dataSource
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
	 * @Description:根据config初始化dataSource
	 * @param dbName
	 * @param config
	 */
	private static void initDataSource(String dbName, C3p0MainConfig config) {
		dataSources.put(dbName, config.getDataSource());
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
