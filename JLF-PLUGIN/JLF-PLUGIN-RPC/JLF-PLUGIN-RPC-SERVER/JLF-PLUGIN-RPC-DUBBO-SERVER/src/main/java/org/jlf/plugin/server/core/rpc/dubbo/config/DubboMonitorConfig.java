package org.jlf.plugin.server.core.rpc.dubbo.config;

import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import com.alibaba.dubbo.config.MonitorConfig;

/**
 * 
 * @ClassName: DubboMonitorConfig
 * @Description: monitor≈‰÷√
 * @author Lone Wolf
 * @date 2019ƒÍ10‘¬26»’
 */
public class DubboMonitorConfig {

	@JLFCheckAnn(isSkipValidate = true)
	private MonitorConfig monitor = new MonitorConfig();

	private String protocol;

	@JLFCheckAnn(isNull = true)
	private String address;

	@JLFCheckAnn(isNull = true)
	private String username;

	@JLFCheckAnn(isNull = true)
	private String password;

	@JLFCheckAnn(isNull = true)
	private String group;

	@JLFCheckAnn(isNull = true)
	private String version;

	@JLFCheckAnn(isNull = true)
	private String interval;

	@JLFCheckAnn(isNull = true)
	private Map<String, String> parameters;

	private BooleanType isDefault;

	public MonitorConfig getMonitor() {
		return monitor;
	}
	
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
		monitor.setProtocol(protocol);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		monitor.setAddress(address);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		monitor.setUsername(username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		monitor.setPassword(password);
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
		monitor.setGroup(group);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
		monitor.setVersion(version);
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
		monitor.setInterval(interval);
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
		monitor.setParameters(parameters);
	}

	public BooleanType getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(BooleanType isDefault) {
		this.isDefault = isDefault;
		monitor.setDefault(isDefault.isBln());
	}

}
