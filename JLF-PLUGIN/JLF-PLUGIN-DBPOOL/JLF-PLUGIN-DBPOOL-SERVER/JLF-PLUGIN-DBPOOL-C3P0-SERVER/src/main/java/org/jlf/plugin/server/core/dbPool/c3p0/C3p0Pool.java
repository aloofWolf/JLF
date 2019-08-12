package org.jlf.plugin.server.core.dbPool.c3p0;

import java.beans.PropertyVetoException;
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
		
		if(config.getAcquireIncrement() != null){
			dataSource.setAcquireIncrement(config.getAcquireIncrement());
		}
		
		if(config.getAcquireRetryAttempts() != null){
			dataSource.setAcquireRetryAttempts(config.getAcquireRetryAttempts());
		}
		
		if(config.getAcquireRetryDelay() != null){
			dataSource.setAcquireRetryDelay(config.getAcquireRetryDelay());
		}
		
		if(config.getAutoCommitOnClose() != null){
			dataSource.setAutoCommitOnClose(config.getAutoCommitOnClose().isBln());
		}
		
		if(config.getAutomaticTestTable() != null){
			dataSource.setAutomaticTestTable(config.getAutomaticTestTable());
		}
		
		if(config.getBreakAfterAcquireFailure() != null){
			dataSource.setBreakAfterAcquireFailure(config.getBreakAfterAcquireFailure().isBln());
		}
		
		if(config.getCheckoutTimeout() != null){
			dataSource.setCheckoutTimeout(config.getCheckoutTimeout());
		}
		
		if(config.getConnectionCustomizerClassName() != null){
			dataSource.setConnectionCustomizerClassName(config.getConnectionCustomizerClassName());
		}
		
		if(config.getConnectionTesterClassName() != null){
			try {
				dataSource.setConnectionTesterClassName(config.getConnectionTesterClassName());
			} catch (PropertyVetoException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
		}
		
		if(config.getContextClassLoaderSource() != null){
			try {
				dataSource.setContextClassLoaderSource(config.getContextClassLoaderSource());
			} catch (PropertyVetoException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
		}
		
		if(config.getDebugUnreturnedConnectionStackTraces() != null){
			dataSource.setDebugUnreturnedConnectionStackTraces(config.getDebugUnreturnedConnectionStackTraces().isBln());
		}
		
		if(config.getFactoryClassLocation() != null){
			dataSource.setFactoryClassLocation(config.getFactoryClassLocation());
		}
		
		if(config.getForceIgnoreUnresolvedTransactions() != null){
			dataSource.setForceIgnoreUnresolvedTransactions(config.getForceIgnoreUnresolvedTransactions().isBln());
		}
		
		if(config.getForceSynchronousCheckins() != null){
			dataSource.setForceSynchronousCheckins(config.getForceSynchronousCheckins().isBln());
		}
		
		if(config.getIdentityToken() != null){
			dataSource.setIdentityToken(config.getIdentityToken());
		}
		
		if(config.getIdleConnectionTestPeriod() != null){
			dataSource.setIdleConnectionTestPeriod(config.getIdleConnectionTestPeriod());
		}
		
		if(config.getInitialPoolSize() != null){
			dataSource.setInitialPoolSize(config.getInitialPoolSize());
		}
		
		if(config.getMaxAdministrativeTaskTime() != null){
			dataSource.setMaxAdministrativeTaskTime(config.getMaxAdministrativeTaskTime());
		}
		
		if(config.getMaxConnectionAge() != null){
			dataSource.setMaxConnectionAge(config.getMaxConnectionAge());
		}
		
		if(config.getMaxIdleTime() != null){
			dataSource.setMaxIdleTime(config.getMaxIdleTime());
		}
		
		if(config.getMaxIdleTimeExcessConnections() != null){
			dataSource.setMaxIdleTimeExcessConnections(config.getMaxIdleTimeExcessConnections());
		}
		
		if(config.getMaxPoolSize() != null){
			dataSource.setMaxPoolSize(config.getMaxPoolSize());
		}
		
		if(config.getMaxStatements() != null){
			dataSource.setMaxStatements(config.getMaxStatements());
		}
		
		if(config.getMaxStatementsPerConnection() != null){
			dataSource.setMaxStatementsPerConnection(config.getMaxStatementsPerConnection());
		}
		
		if(config.getMinPoolSize() != null){
			dataSource.setMinPoolSize(config.getMinPoolSize());
		}
		
		if(config.getOverrideDefaultPassword() != null){
			dataSource.setOverrideDefaultPassword(config.getOverrideDefaultPassword());
		}
		
		if(config.getOverrideDefaultUser() != null){
			dataSource.setOverrideDefaultUser(config.getOverrideDefaultUser());
		}
		
		if(config.getPreferredTestQuery() != null){
			dataSource.setPreferredTestQuery(config.getPreferredTestQuery());
		}
		
		if(config.getPrivilegeSpawnedThreads() != null){
			dataSource.setPrivilegeSpawnedThreads(config.getPrivilegeSpawnedThreads().isBln());
		}
		
		if(config.getPropertyCycle() != null){
			dataSource.setPropertyCycle(config.getPropertyCycle());
		}
		
		if(config.getStatementCacheNumDeferredCloseThreads() != null){
			dataSource.setStatementCacheNumDeferredCloseThreads(config.getStatementCacheNumDeferredCloseThreads());
		}
		
		if(config.getTestConnectionOnCheckin() != null){
			dataSource.setTestConnectionOnCheckin(config.getTestConnectionOnCheckin().isBln());
		}
		
		if(config.getTestConnectionOnCheckout() != null){
			dataSource.setTestConnectionOnCheckout(config.getTestConnectionOnCheckout().isBln());
		}
		
		if(config.getUnreturnedConnectionTimeout() != null){
			dataSource.setUnreturnedConnectionTimeout(config.getUnreturnedConnectionTimeout());
		}
		
		if(config.getUserOverridesAsString() != null){
			try {
				dataSource.setUserOverridesAsString(config.getUserOverridesAsString());
			} catch (PropertyVetoException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
		}
		
		if(config.getUsesTraditionalReflectiveProxies() != null){
			dataSource.setUsesTraditionalReflectiveProxies(config.getUsesTraditionalReflectiveProxies().isBln());
		}
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
