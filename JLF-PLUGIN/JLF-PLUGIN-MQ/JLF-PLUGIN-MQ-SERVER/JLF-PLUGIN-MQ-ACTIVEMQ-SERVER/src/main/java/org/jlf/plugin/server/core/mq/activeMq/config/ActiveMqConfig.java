package org.jlf.plugin.server.core.mq.activeMq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: ActiveMqConfig
 * @Description:ActiveMq配置
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ActiveMqConfig {
	
	@JLFCheckAnn(isSkipValidate = true)
	private ActiveMQConnectionFactory factory;

	private String url; // url
	
	@JLFCheckAnn(isNull = true)
	private String userName; // 用户名
	@JLFCheckAnn(isNull = true)
	private String password; // 密码
	@JLFCheckAnn(isNull = true)
	private String clientID;
	@JLFCheckAnn(isNull = true)
	private BooleanType dispatchAsync;
	@JLFCheckAnn(isNull = true)
	private BooleanType alwaysSessionAsync;
	@JLFCheckAnn(isNull = true)
	private String clientIDPrefix;
	@JLFCheckAnn(isNull = true)
	private String connectionIDPrefix;
	@JLFCheckAnn(isNull = true)
	private BooleanType disableTimeStampsByDefault;
	@JLFCheckAnn(isNull = true)
	private BooleanType optimizedMessageDispatch;
	@JLFCheckAnn(isNull = true)
	private Long optimizeAcknowledgeTimeOut;
	@JLFCheckAnn(isNull = true)
	private Long optimizedAckScheduledAckInterval;
	@JLFCheckAnn(isNull = true)
	private BooleanType copyMessageOnSend;
	@JLFCheckAnn(isNull = true)
	private BooleanType useCompression;
	@JLFCheckAnn(isNull = true)
	private BooleanType objectMessageSerializationDefered;
	@JLFCheckAnn(isNull = true)
	private BooleanType useAsyncSend;
	@JLFCheckAnn(isNull = true)
	private BooleanType optimizeAcknowledge;
	@JLFCheckAnn(isNull = true)
	private Integer closeTimeout;
	@JLFCheckAnn(isNull = true)
	private BooleanType useRetroactiveConsumer;
	@JLFCheckAnn(isNull = true)
	private BooleanType exclusiveConsumer;
	@JLFCheckAnn(isNull = true)
	private BooleanType nestedMapAndListEnabled;
	@JLFCheckAnn(isNull = true)
	private BooleanType alwaysSyncSend;
	@JLFCheckAnn(isNull = true)
	private BooleanType watchTopicAdvisories;
	@JLFCheckAnn(isNull = true)
	private Integer producerWindowSize;
	@JLFCheckAnn(isNull = true)
	private Long warnAboutUnstartedConnectionTimeout;
	@JLFCheckAnn(isNull = true)
	private Integer sendTimeout;
	@JLFCheckAnn(isNull = true)
	private BooleanType sendAcksAsync;
	@JLFCheckAnn(isNull = true)
	private Integer auditDepth;
	@JLFCheckAnn(isNull = true)
	private Integer auditMaximumProducerNumber;
	@JLFCheckAnn(isNull = true)
	private BooleanType useDedicatedTaskRunner;
	@JLFCheckAnn(isNull = true)
	private Long consumerFailoverRedeliveryWaitPeriod;
	@JLFCheckAnn(isNull = true)
	private BooleanType checkForDuplicates;
	@JLFCheckAnn(isNull = true)
	private BooleanType messagePrioritySupported;
	@JLFCheckAnn(isNull = true)
	private BooleanType transactedIndividualAck;
	@JLFCheckAnn(isNull = true)
	private BooleanType nonBlockingRedelivery;
	@JLFCheckAnn(isNull = true)
	private Integer maxThreadPoolSize;

	public ActiveMQConnectionFactory getFactory() {
		return factory;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		this.factory = new ActiveMQConnectionFactory(url);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		this.factory.setUserName(userName);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		this.factory.setPassword(password);
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
		this.factory.setClientID(clientID);
	}

	public BooleanType getDispatchAsync() {
		return dispatchAsync;
	}

	public void setDispatchAsync(BooleanType dispatchAsync) {
		this.dispatchAsync = dispatchAsync;
		this.factory.setDispatchAsync(dispatchAsync.isBln());
	}

	public BooleanType getAlwaysSessionAsync() {
		return alwaysSessionAsync;
	}

	public void setAlwaysSessionAsync(BooleanType alwaysSessionAsync) {
		this.alwaysSessionAsync = alwaysSessionAsync;
		this.factory.setAlwaysSessionAsync(alwaysSessionAsync.isBln());
	}

	public String getClientIDPrefix() {
		return clientIDPrefix;
	}

	public void setClientIDPrefix(String clientIDPrefix) {
		this.clientIDPrefix = clientIDPrefix;
		this.factory.setClientIDPrefix(clientIDPrefix);
	}

	public String getConnectionIDPrefix() {
		return connectionIDPrefix;
	}

	public void setConnectionIDPrefix(String connectionIDPrefix) {
		this.connectionIDPrefix = connectionIDPrefix;
		this.factory.setConnectionIDPrefix(connectionIDPrefix);
	}

	public BooleanType getDisableTimeStampsByDefault() {
		return disableTimeStampsByDefault;
	}

	public void setDisableTimeStampsByDefault(BooleanType disableTimeStampsByDefault) {
		this.disableTimeStampsByDefault = disableTimeStampsByDefault;
		this.factory.setDisableTimeStampsByDefault(disableTimeStampsByDefault.isBln());
	}

	public BooleanType getOptimizedMessageDispatch() {
		return optimizedMessageDispatch;
	}

	public void setOptimizedMessageDispatch(BooleanType optimizedMessageDispatch) {
		this.optimizedMessageDispatch = optimizedMessageDispatch;
		this.factory.setOptimizedMessageDispatch(optimizedMessageDispatch.isBln());
	}

	public Long getOptimizeAcknowledgeTimeOut() {
		return optimizeAcknowledgeTimeOut;
	}

	public void setOptimizeAcknowledgeTimeOut(Long optimizeAcknowledgeTimeOut) {
		this.optimizeAcknowledgeTimeOut = optimizeAcknowledgeTimeOut;
		this.factory.setOptimizeAcknowledgeTimeOut(optimizeAcknowledgeTimeOut);
	}

	public Long getOptimizedAckScheduledAckInterval() {
		return optimizedAckScheduledAckInterval;
	}

	public void setOptimizedAckScheduledAckInterval(Long optimizedAckScheduledAckInterval) {
		this.optimizedAckScheduledAckInterval = optimizedAckScheduledAckInterval;
		this.factory.setOptimizedAckScheduledAckInterval(optimizedAckScheduledAckInterval);
	}

	public BooleanType getCopyMessageOnSend() {
		return copyMessageOnSend;
	}

	public void setCopyMessageOnSend(BooleanType copyMessageOnSend) {
		this.copyMessageOnSend = copyMessageOnSend;
		this.factory.setCopyMessageOnSend(copyMessageOnSend.isBln());
	}

	public BooleanType getUseCompression() {
		return useCompression;
	}

	public void setUseCompression(BooleanType useCompression) {
		this.useCompression = useCompression;
		this.factory.setUseCompression(useCompression.isBln());
	}

	public BooleanType getObjectMessageSerializationDefered() {
		return objectMessageSerializationDefered;
	}

	public void setObjectMessageSerializationDefered(BooleanType objectMessageSerializationDefered) {
		this.objectMessageSerializationDefered = objectMessageSerializationDefered;
		this.factory.setObjectMessageSerializationDefered(objectMessageSerializationDefered.isBln());
	}

	public BooleanType getUseAsyncSend() {
		return useAsyncSend;
	}

	public void setUseAsyncSend(BooleanType useAsyncSend) {
		this.useAsyncSend = useAsyncSend;
		this.factory.setUseAsyncSend(useAsyncSend.isBln());
	}

	public BooleanType getOptimizeAcknowledge() {
		return optimizeAcknowledge;
	}

	public void setOptimizeAcknowledge(BooleanType optimizeAcknowledge) {
		this.optimizeAcknowledge = optimizeAcknowledge;
		this.factory.setOptimizeAcknowledge(optimizeAcknowledge.isBln());
	}

	public Integer getCloseTimeout() {
		return closeTimeout;
	}

	public void setCloseTimeout(Integer closeTimeout) {
		this.closeTimeout = closeTimeout;
		this.factory.setCloseTimeout(closeTimeout);
	}

	public BooleanType getUseRetroactiveConsumer() {
		return useRetroactiveConsumer;
	}

	public void setUseRetroactiveConsumer(BooleanType useRetroactiveConsumer) {
		this.useRetroactiveConsumer = useRetroactiveConsumer;
		this.factory.setUseRetroactiveConsumer(useRetroactiveConsumer.isBln());
	}

	public BooleanType getExclusiveConsumer() {
		return exclusiveConsumer;
	}

	public void setExclusiveConsumer(BooleanType exclusiveConsumer) {
		this.exclusiveConsumer = exclusiveConsumer;
		this.factory.setExclusiveConsumer(exclusiveConsumer.isBln());
	}

	public BooleanType getNestedMapAndListEnabled() {
		return nestedMapAndListEnabled;
	}

	public void setNestedMapAndListEnabled(BooleanType nestedMapAndListEnabled) {
		this.nestedMapAndListEnabled = nestedMapAndListEnabled;
		this.factory.setNestedMapAndListEnabled(nestedMapAndListEnabled.isBln());
	}

	public BooleanType getAlwaysSyncSend() {
		return alwaysSyncSend;
	}

	public void setAlwaysSyncSend(BooleanType alwaysSyncSend) {
		this.alwaysSyncSend = alwaysSyncSend;
		this.factory.setAlwaysSyncSend(alwaysSyncSend.isBln());
	}

	public BooleanType getWatchTopicAdvisories() {
		return watchTopicAdvisories;
	}

	public void setWatchTopicAdvisories(BooleanType watchTopicAdvisories) {
		this.watchTopicAdvisories = watchTopicAdvisories;
		this.factory.setWatchTopicAdvisories(watchTopicAdvisories.isBln());
	}

	public Integer getProducerWindowSize() {
		return producerWindowSize;
	}

	public void setProducerWindowSize(Integer producerWindowSize) {
		this.producerWindowSize = producerWindowSize;
		this.factory.setProducerWindowSize(producerWindowSize);
	}

	public Long getWarnAboutUnstartedConnectionTimeout() {
		return warnAboutUnstartedConnectionTimeout;
	}

	public void setWarnAboutUnstartedConnectionTimeout(Long warnAboutUnstartedConnectionTimeout) {
		this.warnAboutUnstartedConnectionTimeout = warnAboutUnstartedConnectionTimeout;
		this.factory.setWarnAboutUnstartedConnectionTimeout(warnAboutUnstartedConnectionTimeout);
	}

	public Integer getSendTimeout() {
		return sendTimeout;
	}

	public void setSendTimeout(Integer sendTimeout) {
		this.sendTimeout = sendTimeout;
		this.factory.setSendTimeout(sendTimeout);
	}

	public BooleanType getSendAcksAsync() {
		return sendAcksAsync;
	}

	public void setSendAcksAsync(BooleanType sendAcksAsync) {
		this.sendAcksAsync = sendAcksAsync;
		this.factory.setSendAcksAsync(sendAcksAsync.isBln());
	}

	public Integer getAuditDepth() {
		return auditDepth;
	}

	public void setAuditDepth(Integer auditDepth) {
		this.auditDepth = auditDepth;
		this.factory.setAuditDepth(auditDepth);
	}

	public Integer getAuditMaximumProducerNumber() {
		return auditMaximumProducerNumber;
	}

	public void setAuditMaximumProducerNumber(Integer auditMaximumProducerNumber) {
		this.auditMaximumProducerNumber = auditMaximumProducerNumber;
		this.factory.setAuditMaximumProducerNumber(auditMaximumProducerNumber);
	}

	public BooleanType getUseDedicatedTaskRunner() {
		return useDedicatedTaskRunner;
	}

	public void setUseDedicatedTaskRunner(BooleanType useDedicatedTaskRunner) {
		this.useDedicatedTaskRunner = useDedicatedTaskRunner;
		this.factory.setUseDedicatedTaskRunner(useDedicatedTaskRunner.isBln());
	}

	public Long getConsumerFailoverRedeliveryWaitPeriod() {
		return consumerFailoverRedeliveryWaitPeriod;
	}

	public void setConsumerFailoverRedeliveryWaitPeriod(Long consumerFailoverRedeliveryWaitPeriod) {
		this.consumerFailoverRedeliveryWaitPeriod = consumerFailoverRedeliveryWaitPeriod;
		this.factory.setConsumerFailoverRedeliveryWaitPeriod(consumerFailoverRedeliveryWaitPeriod);
	}

	public BooleanType getCheckForDuplicates() {
		return checkForDuplicates;
	}

	public void setCheckForDuplicates(BooleanType checkForDuplicates) {
		this.checkForDuplicates = checkForDuplicates;
		this.factory.setCheckForDuplicates(checkForDuplicates.isBln());
	}

	public BooleanType getMessagePrioritySupported() {
		return messagePrioritySupported;
	}

	public void setMessagePrioritySupported(BooleanType messagePrioritySupported) {
		this.messagePrioritySupported = messagePrioritySupported;
		this.factory.setMessagePrioritySupported(messagePrioritySupported.isBln());
	}

	public BooleanType getTransactedIndividualAck() {
		return transactedIndividualAck;
	}

	public void setTransactedIndividualAck(BooleanType transactedIndividualAck) {
		this.transactedIndividualAck = transactedIndividualAck;
		this.factory.setTransactedIndividualAck(transactedIndividualAck.isBln());
	}

	public BooleanType getNonBlockingRedelivery() {
		return nonBlockingRedelivery;
	}

	public void setNonBlockingRedelivery(BooleanType nonBlockingRedelivery) {
		this.nonBlockingRedelivery = nonBlockingRedelivery;
		this.factory.setNonBlockingRedelivery(nonBlockingRedelivery.isBln());
	}

	public Integer getMaxThreadPoolSize() {
		return maxThreadPoolSize;
	}

	public void setMaxThreadPoolSize(Integer maxThreadPoolSize) {
		this.maxThreadPoolSize = maxThreadPoolSize;
		this.factory.setMaxThreadPoolSize(maxThreadPoolSize);
	}

}
