package org.jlf.plugin.server.core.dbPool.c3p0.config;

import java.beans.PropertyVetoException;

import org.jlf.common.enums.BooleanType;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @ClassName: C3p0MainConfig
 * @Description:c3p0主库配置
 * @author Lone Wolf
 * @date 2019年5月28日
 */
public class C3p0MainConfig {

	@JLFCheckAnn(isSkipValidate = true)
	private ComboPooledDataSource dataSource = new ComboPooledDataSource();

	private String driver;
	private String url;
	private String userName;
	private String password;

	@JLFCheckAnn(isNull = true)
	private Integer acquireIncrement;
	@JLFCheckAnn(isNull = true)
	private Integer acquireRetryAttempts;
	@JLFCheckAnn(isNull = true)
	private Integer acquireRetryDelay;
	@JLFCheckAnn(isNull = true)
	private BooleanType autoCommitOnClose;
	@JLFCheckAnn(isNull = true)
	private String automaticTestTable;
	@JLFCheckAnn(isNull = true)
	private BooleanType breakAfterAcquireFailure;
	@JLFCheckAnn(isNull = true)
	private Integer checkoutTimeout;
	@JLFCheckAnn(isNull = true)
	private String connectionCustomizerClassName;
	@JLFCheckAnn(isNull = true)
	private String connectionTesterClassName;
	@JLFCheckAnn(isNull = true)
	private String contextClassLoaderSource;
	@JLFCheckAnn(isNull = true)
	private BooleanType debugUnreturnedConnectionStackTraces;
	@JLFCheckAnn(isNull = true)
	private String factoryClassLocation;
	@JLFCheckAnn(isNull = true)
	private BooleanType forceIgnoreUnresolvedTransactions;
	@JLFCheckAnn(isNull = true)
	private BooleanType forceSynchronousCheckins;
	@JLFCheckAnn(isNull = true)
	private String identityToken;
	@JLFCheckAnn(isNull = true)
	private Integer idleConnectionTestPeriod;
	@JLFCheckAnn(isNull = true)
	private Integer initialPoolSize;
	@JLFCheckAnn(isNull = true)
	private Integer maxAdministrativeTaskTime;
	@JLFCheckAnn(isNull = true)
	private Integer maxConnectionAge;
	@JLFCheckAnn(isNull = true)
	private Integer maxIdleTime;
	@JLFCheckAnn(isNull = true)
	private Integer maxIdleTimeExcessConnections;
	@JLFCheckAnn(isNull = true)
	private Integer maxPoolSize;
	@JLFCheckAnn(isNull = true)
	private Integer maxStatements;
	@JLFCheckAnn(isNull = true)
	private Integer maxStatementsPerConnection;
	@JLFCheckAnn(isNull = true)
	private Integer minPoolSize;
	@JLFCheckAnn(isNull = true)
	private String overrideDefaultPassword;
	@JLFCheckAnn(isNull = true)
	private String overrideDefaultUser;
	@JLFCheckAnn(isNull = true)
	private String preferredTestQuery;
	@JLFCheckAnn(isNull = true)
	private BooleanType privilegeSpawnedThreads;
	@JLFCheckAnn(isNull = true)
	private Integer propertyCycle;
	@JLFCheckAnn(isNull = true)
	private Integer statementCacheNumDeferredCloseThreads;
	@JLFCheckAnn(isNull = true)
	private BooleanType testConnectionOnCheckin;
	@JLFCheckAnn(isNull = true)
	private BooleanType testConnectionOnCheckout;
	@JLFCheckAnn(isNull = true)
	private Integer unreturnedConnectionTimeout;
	@JLFCheckAnn(isNull = true)
	private String userOverridesAsString;
	@JLFCheckAnn(isNull = true)
	private BooleanType usesTraditionalReflectiveProxies;

	public ComboPooledDataSource getDataSource() {
		return dataSource;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
		try {
			this.dataSource.setDriverClass(driver);
		} catch (PropertyVetoException e) {
			throw new JLFException(e);
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		this.dataSource.setJdbcUrl(url);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		this.dataSource.setUser(userName);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		this.dataSource.setPassword(password);
	}

	public Integer getAcquireIncrement() {
		return acquireIncrement;
	}

	public void setAcquireIncrement(Integer acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
		this.dataSource.setAcquireIncrement(acquireIncrement);
	}

	public Integer getAcquireRetryAttempts() {
		return acquireRetryAttempts;
	}

	public void setAcquireRetryAttempts(Integer acquireRetryAttempts) {
		this.acquireRetryAttempts = acquireRetryAttempts;
		this.dataSource.setAcquireRetryAttempts(acquireRetryAttempts);
	}

	public Integer getAcquireRetryDelay() {
		return acquireRetryDelay;
	}

	public void setAcquireRetryDelay(Integer acquireRetryDelay) {
		this.acquireRetryDelay = acquireRetryDelay;
		this.dataSource.setAcquireRetryDelay(acquireRetryDelay);
	}

	public BooleanType getAutoCommitOnClose() {
		return autoCommitOnClose;
	}

	public void setAutoCommitOnClose(BooleanType autoCommitOnClose) {
		this.autoCommitOnClose = autoCommitOnClose;
		this.dataSource.setAutoCommitOnClose(autoCommitOnClose.isBln());
	}

	public String getAutomaticTestTable() {
		return automaticTestTable;
	}

	public void setAutomaticTestTable(String automaticTestTable) {
		this.automaticTestTable = automaticTestTable;
		this.dataSource.setAutomaticTestTable(automaticTestTable);
	}

	public BooleanType getBreakAfterAcquireFailure() {
		return breakAfterAcquireFailure;
	}

	public void setBreakAfterAcquireFailure(BooleanType breakAfterAcquireFailure) {
		this.breakAfterAcquireFailure = breakAfterAcquireFailure;
		this.dataSource.setBreakAfterAcquireFailure(breakAfterAcquireFailure.isBln());
	}

	public Integer getCheckoutTimeout() {
		return checkoutTimeout;
	}

	public void setCheckoutTimeout(Integer checkoutTimeout) {
		this.checkoutTimeout = checkoutTimeout;
		this.dataSource.setCheckoutTimeout(checkoutTimeout);
	}

	public String getConnectionCustomizerClassName() {
		return connectionCustomizerClassName;
	}

	public void setConnectionCustomizerClassName(String connectionCustomizerClassName) {
		this.connectionCustomizerClassName = connectionCustomizerClassName;
		this.dataSource.setConnectionCustomizerClassName(connectionCustomizerClassName);
	}

	public String getConnectionTesterClassName() {
		return connectionTesterClassName;
	}

	public void setConnectionTesterClassName(String connectionTesterClassName) {
		this.connectionTesterClassName = connectionTesterClassName;
		this.dataSource.setConnectionCustomizerClassName(connectionTesterClassName);
	}

	public String getContextClassLoaderSource() {
		return contextClassLoaderSource;
	}

	public void setContextClassLoaderSource(String contextClassLoaderSource) {
		this.contextClassLoaderSource = contextClassLoaderSource;
		try {
			this.dataSource.setContextClassLoaderSource(contextClassLoaderSource);
		} catch (PropertyVetoException e) {
			throw new JLFException(e);
		}
	}

	public BooleanType getDebugUnreturnedConnectionStackTraces() {
		return debugUnreturnedConnectionStackTraces;
	}

	public void setDebugUnreturnedConnectionStackTraces(BooleanType debugUnreturnedConnectionStackTraces) {
		this.debugUnreturnedConnectionStackTraces = debugUnreturnedConnectionStackTraces;
		this.dataSource.setDebugUnreturnedConnectionStackTraces(debugUnreturnedConnectionStackTraces.isBln());
	}

	public String getFactoryClassLocation() {
		return factoryClassLocation;
	}

	public void setFactoryClassLocation(String factoryClassLocation) {
		this.factoryClassLocation = factoryClassLocation;
		this.dataSource.setFactoryClassLocation(factoryClassLocation);
	}

	public BooleanType getForceIgnoreUnresolvedTransactions() {
		return forceIgnoreUnresolvedTransactions;
	}

	public void setForceIgnoreUnresolvedTransactions(BooleanType forceIgnoreUnresolvedTransactions) {
		this.forceIgnoreUnresolvedTransactions = forceIgnoreUnresolvedTransactions;
		this.dataSource.setForceIgnoreUnresolvedTransactions(forceIgnoreUnresolvedTransactions.isBln());
	}

	public BooleanType getForceSynchronousCheckins() {
		return forceSynchronousCheckins;
	}

	public void setForceSynchronousCheckins(BooleanType forceSynchronousCheckins) {
		this.forceSynchronousCheckins = forceSynchronousCheckins;
		this.dataSource.setForceSynchronousCheckins(forceSynchronousCheckins.isBln());
	}

	public String getIdentityToken() {
		return identityToken;
	}

	public void setIdentityToken(String identityToken) {
		this.identityToken = identityToken;
		this.dataSource.setIdentityToken(identityToken);
	}

	public Integer getIdleConnectionTestPeriod() {
		return idleConnectionTestPeriod;
	}

	public void setIdleConnectionTestPeriod(Integer idleConnectionTestPeriod) {
		this.idleConnectionTestPeriod = idleConnectionTestPeriod;
		this.dataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
	}

	public Integer getInitialPoolSize() {
		return initialPoolSize;
	}

	public void setInitialPoolSize(Integer initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
		this.dataSource.setInitialPoolSize(initialPoolSize);
	}

	public Integer getMaxAdministrativeTaskTime() {
		return maxAdministrativeTaskTime;
	}

	public void setMaxAdministrativeTaskTime(Integer maxAdministrativeTaskTime) {
		this.maxAdministrativeTaskTime = maxAdministrativeTaskTime;
		this.dataSource.setMaxAdministrativeTaskTime(maxAdministrativeTaskTime);
	}

	public Integer getMaxConnectionAge() {
		return maxConnectionAge;
	}

	public void setMaxConnectionAge(Integer maxConnectionAge) {
		this.maxConnectionAge = maxConnectionAge;
		this.dataSource.setMaxConnectionAge(maxConnectionAge);
	}

	public Integer getMaxIdleTime() {
		return maxIdleTime;
	}

	public void setMaxIdleTime(Integer maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
		this.dataSource.setMaxIdleTime(maxIdleTime);
	}

	public Integer getMaxIdleTimeExcessConnections() {
		return maxIdleTimeExcessConnections;
	}

	public void setMaxIdleTimeExcessConnections(Integer maxIdleTimeExcessConnections) {
		this.maxIdleTimeExcessConnections = maxIdleTimeExcessConnections;
		this.dataSource.setMaxIdleTimeExcessConnections(maxIdleTimeExcessConnections);
	}

	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
		this.dataSource.setMaxPoolSize(maxPoolSize);
	}

	public Integer getMaxStatements() {
		return maxStatements;
	}

	public void setMaxStatements(Integer maxStatements) {
		this.maxStatements = maxStatements;
		this.dataSource.setMaxStatements(maxStatements);
	}

	public Integer getMaxStatementsPerConnection() {
		return maxStatementsPerConnection;
	}

	public void setMaxStatementsPerConnection(Integer maxStatementsPerConnection) {
		this.maxStatementsPerConnection = maxStatementsPerConnection;
		this.dataSource.setMaxStatementsPerConnection(maxStatementsPerConnection);
	}

	public Integer getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(Integer minPoolSize) {
		this.minPoolSize = minPoolSize;
		this.dataSource.setMinPoolSize(minPoolSize);
	}

	public String getOverrideDefaultPassword() {
		return overrideDefaultPassword;
	}

	public void setOverrideDefaultPassword(String overrideDefaultPassword) {
		this.overrideDefaultPassword = overrideDefaultPassword;
		this.dataSource.setOverrideDefaultPassword(overrideDefaultPassword);
	}

	public String getOverrideDefaultUser() {
		return overrideDefaultUser;
	}

	public void setOverrideDefaultUser(String overrideDefaultUser) {
		this.overrideDefaultUser = overrideDefaultUser;
		this.dataSource.setOverrideDefaultUser(overrideDefaultUser);
	}

	public String getPreferredTestQuery() {
		return preferredTestQuery;
	}

	public void setPreferredTestQuery(String preferredTestQuery) {
		this.preferredTestQuery = preferredTestQuery;
		this.dataSource.setPreferredTestQuery(preferredTestQuery);
	}

	public BooleanType getPrivilegeSpawnedThreads() {
		return privilegeSpawnedThreads;
	}

	public void setPrivilegeSpawnedThreads(BooleanType privilegeSpawnedThreads) {
		this.privilegeSpawnedThreads = privilegeSpawnedThreads;
		this.dataSource.setPrivilegeSpawnedThreads(privilegeSpawnedThreads.isBln());
	}

	public Integer getPropertyCycle() {
		return propertyCycle;
	}

	public void setPropertyCycle(Integer propertyCycle) {
		this.propertyCycle = propertyCycle;
		this.dataSource.setPropertyCycle(propertyCycle);
	}

	public Integer getStatementCacheNumDeferredCloseThreads() {
		return statementCacheNumDeferredCloseThreads;
	}

	public void setStatementCacheNumDeferredCloseThreads(Integer statementCacheNumDeferredCloseThreads) {
		this.statementCacheNumDeferredCloseThreads = statementCacheNumDeferredCloseThreads;
		this.dataSource.setStatementCacheNumDeferredCloseThreads(statementCacheNumDeferredCloseThreads);
	}

	public BooleanType getTestConnectionOnCheckin() {
		return testConnectionOnCheckin;
	}

	public void setTestConnectionOnCheckin(BooleanType testConnectionOnCheckin) {
		this.testConnectionOnCheckin = testConnectionOnCheckin;
		this.dataSource.setTestConnectionOnCheckin(testConnectionOnCheckin.isBln());
	}

	public BooleanType getTestConnectionOnCheckout() {
		return testConnectionOnCheckout;
	}

	public void setTestConnectionOnCheckout(BooleanType testConnectionOnCheckout) {
		this.testConnectionOnCheckout = testConnectionOnCheckout;
		this.dataSource.setTestConnectionOnCheckout(testConnectionOnCheckout.isBln());
	}

	public Integer getUnreturnedConnectionTimeout() {
		return unreturnedConnectionTimeout;
	}

	public void setUnreturnedConnectionTimeout(Integer unreturnedConnectionTimeout) {
		this.unreturnedConnectionTimeout = unreturnedConnectionTimeout;
		this.dataSource.setUnreturnedConnectionTimeout(unreturnedConnectionTimeout);
	}

	public String getUserOverridesAsString() {
		return userOverridesAsString;
	}

	public void setUserOverridesAsString(String userOverridesAsString) {
		this.userOverridesAsString = userOverridesAsString;
		try {
			this.dataSource.setUserOverridesAsString(userOverridesAsString);
		} catch (PropertyVetoException e) {
			throw new JLFException(e);
		}
	}

	public BooleanType getUsesTraditionalReflectiveProxies() {
		return usesTraditionalReflectiveProxies;
	}

	public void setUsesTraditionalReflectiveProxies(BooleanType usesTraditionalReflectiveProxies) {
		this.usesTraditionalReflectiveProxies = usesTraditionalReflectiveProxies;
		this.dataSource.setUsesTraditionalReflectiveProxies(usesTraditionalReflectiveProxies.isBln());
	}

}
