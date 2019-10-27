package org.jlf.plugin.server.core.rpc.dubbo.config;

import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import com.alibaba.dubbo.config.MethodConfig;

/**
 * 
 * @ClassName: DubboMethodConfig
 * @Description: Method≈‰÷√
 * @author Lone Wolf
 * @date 2019ƒÍ10‘¬26»’
 */

public class DubboMethodConfig {

	@JLFCheckAnn(isSkipValidate = true)
	private MethodConfig method = new MethodConfig();

	private String name;

	@JLFCheckAnn(isNull = true)
	private Integer stat;

	@JLFCheckAnn(isNull = true)
	private BooleanType retry;

	@JLFCheckAnn(isNull = true)
	private BooleanType reliable;

	@JLFCheckAnn(isNull = true)
	private Integer executes;

	@JLFCheckAnn(isNull = true)
	private BooleanType deprecated;

	@JLFCheckAnn(isNull = true)
	private BooleanType sticky;

	@JLFCheckAnn(isNull = true)
	private BooleanType isReturn;

	@JLFCheckAnn(isNull = true)
	private String oninvoke;

	@JLFCheckAnn(isNull = true)
	private String oninvokeMethod;

	@JLFCheckAnn(isNull = true)
	private String onreturn;

	@JLFCheckAnn(isNull = true)
	private String onreturnMethod;

	@JLFCheckAnn(isNull = true)
	private String onthrow;

	@JLFCheckAnn(isNull = true)
	private String onthrowMethod;

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

	public MethodConfig getMethod() {
		return method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		method.setName(name);
	}

	public Integer getStat() {
		return stat;
	}

	@SuppressWarnings("deprecation")
	public void setStat(Integer stat) {
		this.stat = stat;
		method.setStat(stat);
	}

	public BooleanType getRetry() {
		return retry;
	}

	@SuppressWarnings("deprecation")
	public void setRetry(BooleanType retry) {
		this.retry = retry;
		method.setRetry(retry.isBln());
	}

	public BooleanType getReliable() {
		return reliable;
	}

	@SuppressWarnings("deprecation")
	public void setReliable(BooleanType reliable) {
		this.reliable = reliable;
		method.setReliable(reliable.isBln());
	}

	public Integer getExecutes() {
		return executes;
	}

	public void setExecutes(Integer executes) {
		this.executes = executes;
		method.setExecutes(executes);
	}

	public BooleanType getDeprecated() {
		return deprecated;
	}

	public void setDeprecated(BooleanType deprecated) {
		this.deprecated = deprecated;
		method.setDeprecated(deprecated.isBln());
	}

	public BooleanType getSticky() {
		return sticky;
	}

	public void setSticky(BooleanType sticky) {
		this.sticky = sticky;
		method.setSticky(sticky.isBln());
	}

	public BooleanType getIsReturn() {
		return isReturn;
	}

	public void setIsReturn(BooleanType isReturn) {
		this.isReturn = isReturn;
		method.setReturn(isReturn.isBln());
	}

	public String getOninvoke() {
		return oninvoke;
	}

	public void setOninvoke(String oninvoke) {
		this.oninvoke = oninvoke;
		method.setOninvoke(oninvoke);
	}

	public String getOninvokeMethod() {
		return oninvokeMethod;
	}

	public void setOninvokeMethod(String oninvokeMethod) {
		this.oninvokeMethod = oninvokeMethod;
		method.setOninvokeMethod(oninvokeMethod);
	}

	public String getOnreturn() {
		return onreturn;
	}

	public void setOnreturn(String onreturn) {
		this.onreturn = onreturn;
		method.setOnreturn(onreturn);
	}

	public String getOnreturnMethod() {
		return onreturnMethod;
	}

	public void setOnreturnMethod(String onreturnMethod) {
		this.onreturnMethod = onreturnMethod;
		method.setOnreturnMethod(onreturnMethod);
	}

	public String getOnthrow() {
		return onthrow;
	}

	public void setOnthrow(String onthrow) {
		this.onthrow = onthrow;
		method.setOnthrow(onthrow);
	}

	public String getOnthrowMethod() {
		return onthrowMethod;
	}

	public void setOnthrowMethod(String onthrowMethod) {
		this.onthrowMethod = onthrowMethod;
		method.setOnthrowMethod(onthrowMethod);
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
		method.setTimeout(timeout);
	}

	public Integer getRetries() {
		return retries;
	}

	public void setRetries(Integer retries) {
		this.retries = retries;
		method.setRetries(retries);
	}

	public Integer getActives() {
		return actives;
	}

	public void setActives(Integer actives) {
		this.actives = actives;
		method.setActives(actives);
	}

	public String getLoadbalance() {
		return loadbalance;
	}

	public void setLoadbalance(String loadbalance) {
		this.loadbalance = loadbalance;
		method.setLoadbalance(loadbalance);
	}

	public BooleanType getAsync() {
		return async;
	}

	public void setAsync(BooleanType async) {
		this.async = async;
		method.setAsync(async.isBln());
	}

	public BooleanType getSent() {
		return sent;
	}

	public void setSent(BooleanType sent) {
		this.sent = sent;
		method.setSent(sent.isBln());
	}

	public String getMock() {
		return mock;
	}

	public void setMock(String mock) {
		this.mock = mock;
		method.setMock(mock);
	}

	public String getMerger() {
		return merger;
	}

	public void setMerger(String merger) {
		this.merger = merger;
		method.setMerger(merger);
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
		method.setCache(cache);
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
		method.setValidation(validation);
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
		method.setParameters(parameters);
	}

}
