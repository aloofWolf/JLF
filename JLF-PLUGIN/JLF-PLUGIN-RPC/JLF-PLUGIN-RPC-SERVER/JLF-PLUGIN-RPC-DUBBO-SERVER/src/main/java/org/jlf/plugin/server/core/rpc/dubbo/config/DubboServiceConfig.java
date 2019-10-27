package org.jlf.plugin.server.core.rpc.dubbo.config;

import java.util.List;
import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import com.alibaba.dubbo.config.ServiceConfig;

/**
 * 
 * @ClassName: DubboServiceConfig
 * @Description: service配置
 * @author Lone Wolf
 * @param <T>
 * @date 2019年10月26日
 */
public class DubboServiceConfig<T> {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@JLFCheckAnn(isSkipValidate = true)
	private ServiceConfig<T> service = new ServiceConfig();

	private String interfaceName;

	@JLFCheckAnn(isNull = true)
	private List<String> registryId; // 未配置使用配置的第一个registry,多个之间用,分隔

	@JLFCheckAnn(isNull = true)
	private List<String> protocolId; // 未配置使用配置的第一个protocol,多个之间用,分隔

	@JLFCheckAnn(isNull = true)
	private String version;

	@JLFCheckAnn(isNull = true)
	private String group;

	@JLFCheckAnn(isNull = true)
	private BooleanType deprecated;

	@JLFCheckAnn(isNull = true)
	private Integer delay;

	@JLFCheckAnn(isNull = true)
	private BooleanType export;

	@JLFCheckAnn(isNull = true)
	private Integer weight;

	@JLFCheckAnn(isNull = true)
	private String document;

	@JLFCheckAnn(isNull = true)
	private BooleanType dynamic;

	@JLFCheckAnn(isNull = true)
	private String token;

	@JLFCheckAnn(isNull = true)
	private String accesslog;

	@JLFCheckAnn(isNull = true)
	private Integer executes;

	@JLFCheckAnn(isNull = true)
	private BooleanType register;

	@JLFCheckAnn(isNull = true)
	private Integer warmup;

	@JLFCheckAnn(isNull = true)
	private String serialization;

	@JLFCheckAnn(isNull = true)
	private String local;

	@JLFCheckAnn(isNull = true)
	private String stub;

	

	@JLFCheckAnn(isNull = true)
	private String proxy;

	@JLFCheckAnn(isNull = true)
	private String cluster;

	@JLFCheckAnn(isNull = true)
	private String filter;

	@JLFCheckAnn(isNull = true)
	private String listener;

	@JLFCheckAnn(isNull = true)
	private String owner;

	@JLFCheckAnn(isNull = true)
	private Integer connections;

	@JLFCheckAnn(isNull = true)
	private String layer;

	@JLFCheckAnn(isNull = true)
	private String onconnect;

	@JLFCheckAnn(isNull = true)
	private String ondisconnect;

	@JLFCheckAnn(isNull = true)
	private Integer callbacks;

	@JLFCheckAnn(isNull = true)
	private String scope;

	@JLFCheckAnn(isNull = true)
	private Integer timeout;

	@JLFCheckAnn(isNull = true)
	private Integer retries;

	@JLFCheckAnn(isNull = true)
	private Integer actives;

	@JLFCheckAnn(isNull = true)
	private String loadbalance;

	@JLFCheckAnn(isNull = true)
	private BooleanType async;

	@JLFCheckAnn(isNull = true)
	private BooleanType sent;

	@JLFCheckAnn(isNull = true)
	private String mock;

	@JLFCheckAnn(isNull = true)
	private String merger;

	@JLFCheckAnn(isNull = true)
	private String cache;

	@JLFCheckAnn(isNull = true)
	private String validation;

	@JLFCheckAnn(isNull = true)
	private Map<String, String> parameters;

	public List<String> getRegistryId() {
		return registryId;
	}

	public void setRegistryId(List<String> registryId) {
		this.registryId = registryId;
	}

	public List<String> getProtocolId() {
		return protocolId;
	}

	public void setProtocolId(List<String> protocolId) {
		this.protocolId = protocolId;
	}

	public ServiceConfig<T> getService() {
		return service;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
		try {
			service.setInterface(Class.forName(interfaceName));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new JLFException("未找到dubbo接口 :"+interfaceName);
		}
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
		service.setVersion(version);
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
		service.setGroup(group);
	}

	public BooleanType getDeprecated() {
		return deprecated;
	}

	public void setDeprecated(BooleanType deprecated) {
		this.deprecated = deprecated;
		service.setDeprecated(deprecated.isBln());
		
	}

	public Integer getDelay() {
		return delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
		service.setDelay(delay);
	}

	public BooleanType getExport() {
		return export;
	}

	public void setExport(BooleanType export) {
		this.export = export;
		service.setExport(export.isBln());
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
		service.setWeight(weight);
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
		service.setDocument(document);
	}

	public BooleanType getDynamic() {
		return dynamic;
	}

	public void setDynamic(BooleanType dynamic) {
		this.dynamic = dynamic;
		service.setDynamic(dynamic.isBln());
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
		service.setToken(token);
	}

	public String getAccesslog() {
		return accesslog;
	}

	public void setAccesslog(String accesslog) {
		this.accesslog = accesslog;
		service.setAccesslog(accesslog);
	}

	public Integer getExecutes() {
		return executes;
	}

	public void setExecutes(Integer executes) {
		this.executes = executes;
		service.setExecutes(executes);
	}

	public BooleanType getRegister() {
		return register;
	}

	public void setRegister(BooleanType register) {
		this.register = register;
		service.setRegister(register.isBln());
	}

	public Integer getWarmup() {
		return warmup;
	}

	public void setWarmup(Integer warmup) {
		this.warmup = warmup;
		service.setWarmup(warmup);
	}

	public String getSerialization() {
		return serialization;
	}

	public void setSerialization(String serialization) {
		this.serialization = serialization;
		service.setSerialization(serialization);
	}

	public String getLocal() {
		return local;
	}

	@SuppressWarnings("deprecation")
	public void setLocal(String local) {
		this.local = local;
		service.setLocal(local);
	}

	public String getStub() {
		return stub;
	}

	public void setStub(String stub) {
		this.stub = stub;
		service.setStub(stub);
	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
		service.setProxy(proxy);
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
		service.setCluster(cluster);
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
		service.setFilter(filter);
	}

	public String getListener() {
		return listener;
	}

	public void setListener(String listener) {
		this.listener = listener;
		service.setListener(listener);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
		service.setOwner(owner);
	}

	public Integer getConnections() {
		return connections;
	}

	public void setConnections(Integer connections) {
		this.connections = connections;
		service.setConnections(connections);
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
		service.setLayer(layer);
	}

	public String getOnconnect() {
		return onconnect;
	}

	public void setOnconnect(String onconnect) {
		this.onconnect = onconnect;
		service.setOnconnect(onconnect);
	}

	public String getOndisconnect() {
		return ondisconnect;
	}

	public void setOndisconnect(String ondisconnect) {
		this.ondisconnect = ondisconnect;
		service.setOndisconnect(ondisconnect);
	}

	public Integer getCallbacks() {
		return callbacks;
	}

	public void setCallbacks(Integer callbacks) {
		this.callbacks = callbacks;
		service.setCallbacks(callbacks);
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
		service.setScope(scope);
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
		service.setTimeout(timeout);
	}

	public Integer getRetries() {
		return retries;
	}

	public void setRetries(Integer retries) {
		this.retries = retries;
		service.setRetries(retries);
	}

	public Integer getActives() {
		return actives;
	}

	public void setActives(Integer actives) {
		this.actives = actives;
		service.setActives(actives);
	}

	public String getLoadbalance() {
		return loadbalance;
	}

	public void setLoadbalance(String loadbalance) {
		this.loadbalance = loadbalance;
		service.setLoadbalance(loadbalance);
	}

	public BooleanType getAsync() {
		return async;
	}

	public void setAsync(BooleanType async) {
		this.async = async;
		service.setAsync(async.isBln());
	}

	public BooleanType getSent() {
		return sent;
	}

	public void setSent(BooleanType sent) {
		this.sent = sent;
		service.setSent(sent.isBln());
	}

	public String getMock() {
		return mock;
	}

	public void setMock(String mock) {
		this.mock = mock;
		service.setMock(mock);
	}

	public String getMerger() {
		return merger;
	}

	public void setMerger(String merger) {
		this.merger = merger;
		service.setMerger(merger);
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
		service.setCache(cache);
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
		service.setValidation(validation);
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
		service.setParameters(parameters);
	}

}
