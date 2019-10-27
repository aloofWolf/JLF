package org.jlf.plugin.server.core.rpc.dubbo.config;

import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import com.alibaba.dubbo.config.ProtocolConfig;

/**
 * 
 * @ClassName: DubboProtocolConfig
 * @Description: Protocol配置
 * @author Lone Wolf
 * @date 2019年10月26日
 */
public class DubboProtocolConfig {

	@JLFCheckAnn(isSkipValidate = true)
	private ProtocolConfig protocol = new ProtocolConfig();
	
	private String protocolId; // 配置多个protocol,用于区分的唯一标识,在serviceConfig中可以根据此id选择用哪个protocol

	@JLFCheckAnn(isNull = true)
	private String host;

	@JLFCheckAnn(isNull = true)
	private Integer port;

	@JLFCheckAnn(isNull = true)
	private String contextpath;

	@JLFCheckAnn(isNull = true)
	private String threadpool;

	@JLFCheckAnn(isNull = true)
	private Integer threads;

	@JLFCheckAnn(isNull = true)
	private Integer iothreads;

	@JLFCheckAnn(isNull = true)
	private Integer queues;

	@JLFCheckAnn(isNull = true)
	private Integer accepts;

	@JLFCheckAnn(isNull = true)
	private String codec;

	@JLFCheckAnn(isNull = true)
	private String serialization;

	@JLFCheckAnn(isNull = true)
	private String charset;

	@JLFCheckAnn(isNull = true)
	private Integer payload;

	@JLFCheckAnn(isNull = true)
	private Integer buffer;

	@JLFCheckAnn(isNull = true)
	private Integer heartbeat;

	@JLFCheckAnn(isNull = true)
	private String accesslog;

	@JLFCheckAnn(isNull = true)
	private String transporter;

	@JLFCheckAnn(isNull = true)
	private String exchanger;

	@JLFCheckAnn(isNull = true)
	private String dispatcher;

	@JLFCheckAnn(isNull = true)
	private String networker;

	@JLFCheckAnn(isNull = true)
	private String server;

	@JLFCheckAnn(isNull = true)
	private String client;

	@JLFCheckAnn(isNull = true)
	private String telnet;

	@JLFCheckAnn(isNull = true)
	private String prompt;

	@JLFCheckAnn(isNull = true)
	private String status;

	@JLFCheckAnn(isNull = true)
	private BooleanType register;

	@JLFCheckAnn(isNull = true)
	private BooleanType keepAlive;

	@JLFCheckAnn(isNull = true)
	private String optimizer;

	@JLFCheckAnn(isNull = true)
	private String extension;

	@JLFCheckAnn(isNull = true)
	private Map<String, String> parameters;

	@JLFCheckAnn(isNull = true)
	private BooleanType isDefault;

	public ProtocolConfig getProtocol() {
		return protocol;
	}

	public String getProtocolId() {
		return protocolId;
	}

	public void setProtocolId(String protocolId) {
		this.protocolId = protocolId;
		protocol.setName(protocolId);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
		protocol.setHost(host);
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
		protocol.setPort(port);
	}

	public String getContextpath() {
		return contextpath;
	}

	public void setContextpath(String contextpath) {
		this.contextpath = contextpath;
		protocol.setContextpath(contextpath);
	}

	public String getThreadpool() {
		return threadpool;
	}

	public void setThreadpool(String threadpool) {
		this.threadpool = threadpool;
		protocol.setThreadpool(threadpool);
	}

	public Integer getThreads() {
		return threads;
	}

	public void setThreads(Integer threads) {
		this.threads = threads;
		protocol.setThreads(threads);
	}

	public Integer getIothreads() {
		return iothreads;
	}

	public void setIothreads(Integer iothreads) {
		this.iothreads = iothreads;
		protocol.setIothreads(iothreads);
	}

	public Integer getQueues() {
		return queues;
	}

	public void setQueues(Integer queues) {
		this.queues = queues;
		protocol.setQueues(queues);
	}

	public Integer getAccepts() {
		return accepts;
	}

	public void setAccepts(Integer accepts) {
		this.accepts = accepts;
		protocol.setAccepts(accepts);
	}

	public String getCodec() {
		return codec;
	}

	public void setCodec(String codec) {
		this.codec = codec;
		protocol.setCodec(codec);
	}

	public String getSerialization() {
		return serialization;
	}

	public void setSerialization(String serialization) {
		this.serialization = serialization;
		protocol.setSerialization(serialization);
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
		protocol.setCharset(charset);
	}

	public Integer getPayload() {
		return payload;
	}

	public void setPayload(Integer payload) {
		this.payload = payload;
		protocol.setPayload(payload);
	}

	public Integer getBuffer() {
		return buffer;
	}

	public void setBuffer(Integer buffer) {
		this.buffer = buffer;
		protocol.setBuffer(buffer);
	}

	public Integer getHeartbeat() {
		return heartbeat;
	}

	public void setHeartbeat(Integer heartbeat) {
		this.heartbeat = heartbeat;
		protocol.setHeartbeat(heartbeat);
	}

	public String getAccesslog() {
		return accesslog;
	}

	public void setAccesslog(String accesslog) {
		this.accesslog = accesslog;
		protocol.setAccesslog(accesslog);
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
		protocol.setTransporter(transporter);
	}

	public String getExchanger() {
		return exchanger;
	}

	public void setExchanger(String exchanger) {
		this.exchanger = exchanger;
		protocol.setExchanger(exchanger);
	}

	public String getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(String dispatcher) {
		this.dispatcher = dispatcher;
		protocol.setDispatcher(dispatcher);
	}

	public String getNetworker() {
		return networker;
	}

	public void setNetworker(String networker) {
		this.networker = networker;
		protocol.setNetworker(networker);
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
		protocol.setServer(server);
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
		protocol.setClient(client);
	}

	public String getTelnet() {
		return telnet;
	}

	public void setTelnet(String telnet) {
		this.telnet = telnet;
		protocol.setTelnet(telnet);
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
		protocol.setPrompt(prompt);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		protocol.setStatus(status);
	}

	public BooleanType getRegister() {
		return register;
	}

	public void setRegister(BooleanType register) {
		this.register = register;
		protocol.setRegister(register.isBln());
	}

	public BooleanType getKeepAlive() {
		return keepAlive;
	}

	public void setKeepAlive(BooleanType keepAlive) {
		this.keepAlive = keepAlive;
		protocol.setKeepAlive(keepAlive.isBln());
	}

	public String getOptimizer() {
		return optimizer;
	}

	public void setOptimizer(String optimizer) {
		this.optimizer = optimizer;
		protocol.setOptimizer(optimizer);
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
		protocol.setExtension(extension);
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
		protocol.setParameters(parameters);
	}

	public BooleanType getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(BooleanType isDefault) {
		this.isDefault = isDefault;
		protocol.setDefault(isDefault.isBln());
	}

}
