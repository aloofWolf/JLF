package org.jlf.plugin.server.core.dbPool.c3p0.config;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: C3p0MainConfig
 * @Description:c3p0主库配置
 * @author Lone Wolf
 * @date 2019年5月28日
 */
public class C3p0MainConfig {

	@JLFCheckAnn
	private String driver;
	@JLFCheckAnn
	private String url;
	@JLFCheckAnn
	private String userName;
	@JLFCheckAnn
	private String password;

	private Integer acquireIncrement;
	private Integer acquireRetryAttempts;
	private Integer acquireRetryDelay;
	private BooleanType autoCommitOnClose;
	private String automaticTestTable;
	private BooleanType breakAfterAcquireFailure;
	private Integer checkoutTimeout;
	private String connectionCustomizerClassName;
	private String connectionTesterClassName;
	private String contextClassLoaderSource;
	private BooleanType debugUnreturnedConnectionStackTraces;
	private String factoryClassLocation;
	private BooleanType forceIgnoreUnresolvedTransactions;
	private BooleanType forceSynchronousCheckins;
	private String identityToken;
	private Integer idleConnectionTestPeriod;
	private Integer initialPoolSize;
	private Integer maxAdministrativeTaskTime;
	private Integer maxConnectionAge;
	private Integer maxIdleTime;
	private Integer maxIdleTimeExcessConnections;
	private Integer maxPoolSize;
	private Integer maxStatements;
	private Integer maxStatementsPerConnection;
	private Integer minPoolSize;
	private String overrideDefaultPassword;
	private String overrideDefaultUser;
	private String preferredTestQuery;
	private BooleanType privilegeSpawnedThreads;
	private Integer propertyCycle;
	private Integer statementCacheNumDeferredCloseThreads;
	private BooleanType testConnectionOnCheckin;
	private BooleanType testConnectionOnCheckout;
	private Integer unreturnedConnectionTimeout;
	private String userOverridesAsString;
	private BooleanType usesTraditionalReflectiveProxies;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAcquireIncrement() {
		return acquireIncrement;
	}

	public void setAcquireIncrement(Integer acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}

	public Integer getAcquireRetryAttempts() {
		return acquireRetryAttempts;
	}

	public void setAcquireRetryAttempts(Integer acquireRetryAttempts) {
		this.acquireRetryAttempts = acquireRetryAttempts;
	}

	public Integer getAcquireRetryDelay() {
		return acquireRetryDelay;
	}

	public void setAcquireRetryDelay(Integer acquireRetryDelay) {
		this.acquireRetryDelay = acquireRetryDelay;
	}

	public BooleanType getAutoCommitOnClose() {
		return autoCommitOnClose;
	}

	public void setAutoCommitOnClose(BooleanType autoCommitOnClose) {
		this.autoCommitOnClose = autoCommitOnClose;
	}

	public String getAutomaticTestTable() {
		return automaticTestTable;
	}

	public void setAutomaticTestTable(String automaticTestTable) {
		this.automaticTestTable = automaticTestTable;
	}

	public BooleanType getBreakAfterAcquireFailure() {
		return breakAfterAcquireFailure;
	}

	public void setBreakAfterAcquireFailure(BooleanType breakAfterAcquireFailure) {
		this.breakAfterAcquireFailure = breakAfterAcquireFailure;
	}

	public Integer getCheckoutTimeout() {
		return checkoutTimeout;
	}

	public void setCheckoutTimeout(Integer checkoutTimeout) {
		this.checkoutTimeout = checkoutTimeout;
	}

	public String getConnectionCustomizerClassName() {
		return connectionCustomizerClassName;
	}

	public void setConnectionCustomizerClassName(String connectionCustomizerClassName) {
		this.connectionCustomizerClassName = connectionCustomizerClassName;
	}

	public String getConnectionTesterClassName() {
		return connectionTesterClassName;
	}

	public void setConnectionTesterClassName(String connectionTesterClassName) {
		this.connectionTesterClassName = connectionTesterClassName;
	}

	public String getContextClassLoaderSource() {
		return contextClassLoaderSource;
	}

	public void setContextClassLoaderSource(String contextClassLoaderSource) {
		this.contextClassLoaderSource = contextClassLoaderSource;
	}

	public BooleanType getDebugUnreturnedConnectionStackTraces() {
		return debugUnreturnedConnectionStackTraces;
	}

	public void setDebugUnreturnedConnectionStackTraces(BooleanType debugUnreturnedConnectionStackTraces) {
		this.debugUnreturnedConnectionStackTraces = debugUnreturnedConnectionStackTraces;
	}

	public String getFactoryClassLocation() {
		return factoryClassLocation;
	}

	public void setFactoryClassLocation(String factoryClassLocation) {
		this.factoryClassLocation = factoryClassLocation;
	}

	public BooleanType getForceIgnoreUnresolvedTransactions() {
		return forceIgnoreUnresolvedTransactions;
	}

	public void setForceIgnoreUnresolvedTransactions(BooleanType forceIgnoreUnresolvedTransactions) {
		this.forceIgnoreUnresolvedTransactions = forceIgnoreUnresolvedTransactions;
	}

	public BooleanType getForceSynchronousCheckins() {
		return forceSynchronousCheckins;
	}

	public void setForceSynchronousCheckins(BooleanType forceSynchronousCheckins) {
		this.forceSynchronousCheckins = forceSynchronousCheckins;
	}

	public String getIdentityToken() {
		return identityToken;
	}

	public void setIdentityToken(String identityToken) {
		this.identityToken = identityToken;
	}

	public Integer getIdleConnectionTestPeriod() {
		return idleConnectionTestPeriod;
	}

	public void setIdleConnectionTestPeriod(Integer idleConnectionTestPeriod) {
		this.idleConnectionTestPeriod = idleConnectionTestPeriod;
	}

	public Integer getInitialPoolSize() {
		return initialPoolSize;
	}

	public void setInitialPoolSize(Integer initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}

	public Integer getMaxAdministrativeTaskTime() {
		return maxAdministrativeTaskTime;
	}

	public void setMaxAdministrativeTaskTime(Integer maxAdministrativeTaskTime) {
		this.maxAdministrativeTaskTime = maxAdministrativeTaskTime;
	}

	public Integer getMaxConnectionAge() {
		return maxConnectionAge;
	}

	public void setMaxConnectionAge(Integer maxConnectionAge) {
		this.maxConnectionAge = maxConnectionAge;
	}

	public Integer getMaxIdleTime() {
		return maxIdleTime;
	}

	public void setMaxIdleTime(Integer maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}

	public Integer getMaxIdleTimeExcessConnections() {
		return maxIdleTimeExcessConnections;
	}

	public void setMaxIdleTimeExcessConnections(Integer maxIdleTimeExcessConnections) {
		this.maxIdleTimeExcessConnections = maxIdleTimeExcessConnections;
	}

	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public Integer getMaxStatements() {
		return maxStatements;
	}

	public void setMaxStatements(Integer maxStatements) {
		this.maxStatements = maxStatements;
	}

	public Integer getMaxStatementsPerConnection() {
		return maxStatementsPerConnection;
	}

	public void setMaxStatementsPerConnection(Integer maxStatementsPerConnection) {
		this.maxStatementsPerConnection = maxStatementsPerConnection;
	}

	public Integer getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(Integer minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public String getOverrideDefaultPassword() {
		return overrideDefaultPassword;
	}

	public void setOverrideDefaultPassword(String overrideDefaultPassword) {
		this.overrideDefaultPassword = overrideDefaultPassword;
	}

	public String getOverrideDefaultUser() {
		return overrideDefaultUser;
	}

	public void setOverrideDefaultUser(String overrideDefaultUser) {
		this.overrideDefaultUser = overrideDefaultUser;
	}

	public String getPreferredTestQuery() {
		return preferredTestQuery;
	}

	public void setPreferredTestQuery(String preferredTestQuery) {
		this.preferredTestQuery = preferredTestQuery;
	}

	public BooleanType getPrivilegeSpawnedThreads() {
		return privilegeSpawnedThreads;
	}

	public void setPrivilegeSpawnedThreads(BooleanType privilegeSpawnedThreads) {
		this.privilegeSpawnedThreads = privilegeSpawnedThreads;
	}

	public Integer getPropertyCycle() {
		return propertyCycle;
	}

	public void setPropertyCycle(Integer propertyCycle) {
		this.propertyCycle = propertyCycle;
	}

	public Integer getStatementCacheNumDeferredCloseThreads() {
		return statementCacheNumDeferredCloseThreads;
	}

	public void setStatementCacheNumDeferredCloseThreads(Integer statementCacheNumDeferredCloseThreads) {
		this.statementCacheNumDeferredCloseThreads = statementCacheNumDeferredCloseThreads;
	}

	public BooleanType getTestConnectionOnCheckin() {
		return testConnectionOnCheckin;
	}

	public void setTestConnectionOnCheckin(BooleanType testConnectionOnCheckin) {
		this.testConnectionOnCheckin = testConnectionOnCheckin;
	}

	public BooleanType getTestConnectionOnCheckout() {
		return testConnectionOnCheckout;
	}

	public void setTestConnectionOnCheckout(BooleanType testConnectionOnCheckout) {
		this.testConnectionOnCheckout = testConnectionOnCheckout;
	}

	public Integer getUnreturnedConnectionTimeout() {
		return unreturnedConnectionTimeout;
	}

	public void setUnreturnedConnectionTimeout(Integer unreturnedConnectionTimeout) {
		this.unreturnedConnectionTimeout = unreturnedConnectionTimeout;
	}

	public String getUserOverridesAsString() {
		return userOverridesAsString;
	}

	public void setUserOverridesAsString(String userOverridesAsString) {
		this.userOverridesAsString = userOverridesAsString;
	}

	public BooleanType getUsesTraditionalReflectiveProxies() {
		return usesTraditionalReflectiveProxies;
	}

	public void setUsesTraditionalReflectiveProxies(BooleanType usesTraditionalReflectiveProxies) {
		this.usesTraditionalReflectiveProxies = usesTraditionalReflectiveProxies;
	}
	
	

}
