package org.jlf.plugin.server.core.rpc.dubbo.config;

import java.util.List;
import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import com.alibaba.dubbo.config.ReferenceConfig;

/**
 * 
 * @ClassName: DubboReferenceConfig
 * @Description: reference配置
 * @author Lone Wolf
 * @param <T>
 * @date 2019年10月27日
 */
public class DubboReferenceConfig<T> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@JLFCheckAnn(isSkipValidate = true)
	private ReferenceConfig<T> reference = new ReferenceConfig();

	private String interfaceName;

	@JLFCheckAnn(isNull = true)
	private List<String> registryId; // 未配置使用配置的第一个registry,多个之间用,分隔

	@JLFCheckAnn(isNull = true)
	private String client;

	@JLFCheckAnn(isNull = true)
	private String url;

	@JLFCheckAnn(isNull = true)
	private String protocol;

	@JLFCheckAnn(isNull = true)
	protected BooleanType check;

	@JLFCheckAnn(isNull = true)
	protected BooleanType init;

	@JLFCheckAnn(isNull = true)
	protected String generic;

	@JLFCheckAnn(isNull = true)
	protected BooleanType injvm;

	@JLFCheckAnn(isNull = true)
	protected BooleanType lazy;

	@JLFCheckAnn(isNull = true)
	protected String reconnect;

	@JLFCheckAnn(isNull = true)
	protected BooleanType sticky;

	@JLFCheckAnn(isNull = true)
	protected BooleanType stubevent;

	@JLFCheckAnn(isNull = true)
	protected String version;

	@JLFCheckAnn(isNull = true)
	protected String group;

	@JLFCheckAnn(isNull = true)
	protected String local;

	@JLFCheckAnn(isNull = true)
	protected String stub;

	@JLFCheckAnn(isNull = true)
	protected String proxy;

	@JLFCheckAnn(isNull = true)
	protected String cluster;

	@JLFCheckAnn(isNull = true)
	protected String filter;

	@JLFCheckAnn(isNull = true)
	protected String listener;

	@JLFCheckAnn(isNull = true)
	protected String owner;

	@JLFCheckAnn(isNull = true)
	protected Integer connections;

	@JLFCheckAnn(isNull = true)
	protected String layer;

	@JLFCheckAnn(isNull = true)
	protected String onconnect;

	@JLFCheckAnn(isNull = true)
	protected String ondisconnect;

	@JLFCheckAnn(isNull = true)
	private Integer callbacks;

	@JLFCheckAnn(isNull = true)
	private String scope;

	@JLFCheckAnn(isNull = true)
	protected Integer timeout;

	@JLFCheckAnn(isNull = true)
	protected Integer retries;

	@JLFCheckAnn(isNull = true)
	protected Integer actives;

	@JLFCheckAnn(isNull = true)
	protected String loadbalance;

	@JLFCheckAnn(isNull = true)
	protected BooleanType async;

	@JLFCheckAnn(isNull = true)
	protected BooleanType sent;

	@JLFCheckAnn(isNull = true)
	protected String mock;

	@JLFCheckAnn(isNull = true)
	protected String merger;

	@JLFCheckAnn(isNull = true)
	protected String cache;

	@JLFCheckAnn(isNull = true)
	protected String validation;

	@JLFCheckAnn(isNull = true)
	protected Map<String, String> parameters;

	public ReferenceConfig<T> getReference() {
		return reference;
	}

	public void setReference(ReferenceConfig<T> reference) {
		this.reference = reference;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
		try {
			reference.setInterface(Class.forName(interfaceName));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new JLFException("未找到dubbo消费者接口 :" + interfaceName);
		}
	}

	public List<String> getRegistryId() {
		return registryId;
	}

	public void setRegistryId(List<String> registryId) {
		this.registryId = registryId;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
		reference.setClient(client);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		reference.setUrl(url);
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
		reference.setProtocol(protocol);
	}

	public BooleanType getCheck() {
		return check;
	}

	public void setCheck(BooleanType check) {
		this.check = check;
		reference.setCheck(check.isBln());
	}

	public BooleanType getInit() {
		return init;
	}

	public void setInit(BooleanType init) {
		this.init = init;
		reference.setInit(init.isBln());
	}

	public String getGeneric() {
		return generic;
	}

	public void setGeneric(String generic) {
		this.generic = generic;
		reference.setGeneric(generic);
	}

	public BooleanType getInjvm() {
		return injvm;
	}

	@SuppressWarnings("deprecation")
	public void setInjvm(BooleanType injvm) {
		this.injvm = injvm;
		reference.setInjvm(injvm.isBln());
	}

	public BooleanType getLazy() {
		return lazy;
	}

	public void setLazy(BooleanType lazy) {
		this.lazy = lazy;
		reference.setLazy(lazy.isBln());
	}

	public String getReconnect() {
		return reconnect;
	}

	public void setReconnect(String reconnect) {
		this.reconnect = reconnect;
		reference.setReconnect(reconnect);
	}

	public BooleanType getSticky() {
		return sticky;
	}

	public void setSticky(BooleanType sticky) {
		this.sticky = sticky;
		reference.setSticky(sticky.isBln());
	}

	public BooleanType getStubevent() {
		return stubevent;
	}

	public void setStubevent(BooleanType stubevent) {
		this.stubevent = stubevent;
		reference.setSticky(sticky.isBln());
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
		reference.setVersion(version);
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
		reference.setGroup(group);
	}

	public String getLocal() {
		return local;
	}

	@SuppressWarnings("deprecation")
	public void setLocal(String local) {
		this.local = local;
		reference.setLocal(local);
	}

	public String getStub() {
		return stub;
	}

	public void setStub(String stub) {
		this.stub = stub;
		reference.setStub(stub);

	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
		reference.setProxy(proxy);
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
		reference.setCluster(cluster);
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
		reference.setFilter(filter);
	}

	public String getListener() {
		return listener;
	}

	public void setListener(String listener) {
		this.listener = listener;
		reference.setListener(listener);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
		reference.setOwner(owner);
	}

	public Integer getConnections() {
		return connections;
	}

	public void setConnections(Integer connections) {
		this.connections = connections;
		reference.setConnections(connections);
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
		reference.setLayer(layer);
	}

	public String getOnconnect() {
		return onconnect;
	}

	public void setOnconnect(String onconnect) {
		this.onconnect = onconnect;
		reference.setOnconnect(onconnect);
	}

	public String getOndisconnect() {
		return ondisconnect;
	}

	public void setOndisconnect(String ondisconnect) {
		this.ondisconnect = ondisconnect;
		reference.setOnconnect(ondisconnect);
	}

	public Integer getCallbacks() {
		return callbacks;
	}

	public void setCallbacks(Integer callbacks) {
		this.callbacks = callbacks;
		reference.setCallbacks(callbacks);
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
		reference.setScope(scope);
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
		reference.setTimeout(timeout);
	}

	public Integer getRetries() {
		return retries;
	}

	public void setRetries(Integer retries) {
		this.retries = retries;
		reference.setRetries(retries);
	}

	public Integer getActives() {
		return actives;
	}

	public void setActives(Integer actives) {
		this.actives = actives;
		reference.setActives(actives);
	}

	public String getLoadbalance() {
		return loadbalance;
	}

	public void setLoadbalance(String loadbalance) {
		this.loadbalance = loadbalance;
		reference.setLoadbalance(loadbalance);
	}

	public BooleanType getAsync() {
		return async;
	}

	public void setAsync(BooleanType async) {
		this.async = async;
		reference.setAsync(async.isBln());
	}

	public BooleanType getSent() {
		return sent;
	}

	public void setSent(BooleanType sent) {
		this.sent = sent;
		reference.setSent(sent.isBln());
	}

	public String getMock() {
		return mock;
	}

	public void setMock(String mock) {
		this.mock = mock;
		reference.setMock(mock);
	}

	public String getMerger() {
		return merger;
	}

	public void setMerger(String merger) {
		this.merger = merger;
		reference.setMerger(merger);
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
		reference.setCache(cache);
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
		reference.setValidation(validation);
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
		reference.setParameters(parameters);
	}

}
