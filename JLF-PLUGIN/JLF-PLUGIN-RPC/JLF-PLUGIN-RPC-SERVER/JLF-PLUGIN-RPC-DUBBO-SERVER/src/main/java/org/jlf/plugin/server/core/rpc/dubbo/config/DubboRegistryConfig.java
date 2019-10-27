package org.jlf.plugin.server.core.rpc.dubbo.config;

import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import com.alibaba.dubbo.config.RegistryConfig;

/**
 * 
 * @ClassName: DubboRegistryConfig
 * @Description: registry配置
 * @author Lone Wolf
 * @date 2019年10月26日
 */
public class DubboRegistryConfig {
	
	@JLFCheckAnn(isSkipValidate = true)
	private RegistryConfig registry = new RegistryConfig();
	
	private String registryId;// 配置多个registry,用于区分的唯一标识,在serviceConfig中可以根据此id选择用哪个registry

	private String address;

	@JLFCheckAnn(isNull = true)
	private String username;

	@JLFCheckAnn(isNull = true)
	private String password;

	@JLFCheckAnn(isNull = true)
	private Integer port;

	@JLFCheckAnn(isNull = true)
	private String protocol;

	@JLFCheckAnn(isNull = true)
	private String transporter;

	@JLFCheckAnn(isNull = true)
	private String server;

	@JLFCheckAnn(isNull = true)
	private String client;

	@JLFCheckAnn(isNull = true)
	private String cluster;

	@JLFCheckAnn(isNull = true)
	private String group;

	@JLFCheckAnn(isNull = true)
	private String version;

	@JLFCheckAnn(isNull = true)
	private Integer timeout;

	@JLFCheckAnn(isNull = true)
	private Integer session;

	@JLFCheckAnn(isNull = true)
	private String file;

	@JLFCheckAnn(isNull = true)
	private Integer wait;

	@JLFCheckAnn(isNull = true)
	private BooleanType check;

	@JLFCheckAnn(isNull = true)
	private BooleanType dynamic;

	@JLFCheckAnn(isNull = true)
	private BooleanType register;

	@JLFCheckAnn(isNull = true)
	private BooleanType subscribe;

	@JLFCheckAnn(isNull = true)
	private Map<String, String> parameters;

	public RegistryConfig getRegistry() {
		return registry;
	}

	public String getRegistryId() {
		return registryId;
	}

	public void setRegistryId(String registryId) {
		this.registryId = registryId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		registry.setAddress(address);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		registry.setUsername(username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		registry.setPassword(password);
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
		registry.setPort(port);
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
		registry.setProtocol(protocol);
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
		registry.setTransporter(transporter);
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
		registry.setServer(server);
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
		registry.setClient(client);
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
		registry.setCluster(cluster);
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
		registry.setGroup(group);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
		registry.setVersion(version);
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
		registry.setTimeout(timeout);
	}

	public Integer getSession() {
		return session;
	}

	public void setSession(Integer session) {
		this.session = session;
		registry.setSession(session);
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
		registry.setFile(file);
	}

	public Integer getWait() {
		return wait;
	}

	@SuppressWarnings("deprecation")
	public void setWait(Integer wait) {
		this.wait = wait;
		registry.setWait(wait);
	}

	public BooleanType getCheck() {
		return check;
	}

	public void setCheck(BooleanType check) {
		this.check = check;
		registry.setCheck(check.isBln());
	}

	public BooleanType getDynamic() {
		return dynamic;
	}

	public void setDynamic(BooleanType dynamic) {
		this.dynamic = dynamic;
		registry.setDynamic(dynamic.isBln());
	}

	public BooleanType getRegister() {
		return register;
	}

	public void setRegister(BooleanType register) {
		this.register = register;
		registry.setRegister(register.isBln());
	}

	public BooleanType getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(BooleanType subscribe) {
		this.subscribe = subscribe;
		registry.setSubscribe(subscribe.isBln());
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
		registry.setParameters(parameters);
	}

}
