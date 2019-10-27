package org.jlf.plugin.server.core.rpc.dubbo.config;

import java.util.Map;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import com.alibaba.dubbo.config.ApplicationConfig;

/**
 * 
 * @ClassName: DubboApplicationConfig
 * @Description: application≈‰÷√
 * @author Lone Wolf
 * @date 2019ƒÍ10‘¬26»’
 */
public class DubboApplicationConfig {

	@JLFCheckAnn(isSkipValidate = true)
	private ApplicationConfig application = new ApplicationConfig();

	private String name;

	@JLFCheckAnn(isNull = true)
	private String version;

	@JLFCheckAnn(isNull = true)
	private String owner;

	@JLFCheckAnn(isNull = true)
	private String organization;

	@JLFCheckAnn(isNull = true)
	private String architecture;

	@JLFCheckAnn(isNull = true)
	private String environment;

	@JLFCheckAnn(isNull = true)
	private String compiler;

	@JLFCheckAnn(isNull = true)
	private String logger;

	@JLFCheckAnn(isNull = true)
	private BooleanType isDefault;

	@JLFCheckAnn(isNull = true)
	private String dumpDirectory;

	@JLFCheckAnn(isNull = true)
	private BooleanType qosEnable;

	@JLFCheckAnn(isNull = true)
	private Integer qosPort;

	@JLFCheckAnn(isNull = true)
	private BooleanType qosAcceptForeignIp;

	@JLFCheckAnn(isNull = true)
	private Map<String, String> parameters;

	public ApplicationConfig getApplication() {
		return application;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		application.setName(name);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
		application.setVersion(version);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
		application.setOwner(owner);
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
		application.setOrganization(organization);
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
		application.setArchitecture(architecture);
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
		application.setEnvironment(environment);
	}

	public String getCompiler() {
		return compiler;
	}

	public void setCompiler(String compiler) {
		this.compiler = compiler;
		application.setCompiler(compiler);
	}

	public String getLogger() {
		return logger;
	}

	public void setLogger(String logger) {
		this.logger = logger;
		application.setLogger(logger);
	}

	public BooleanType getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(BooleanType isDefault) {
		this.isDefault = isDefault;
		application.setDefault(isDefault.isBln());
	}

	public String getDumpDirectory() {
		return dumpDirectory;
	}

	public void setDumpDirectory(String dumpDirectory) {
		this.dumpDirectory = dumpDirectory;
		application.setDumpDirectory(dumpDirectory);
	}

	public BooleanType getQosEnable() {
		return qosEnable;
	}

	public void setQosEnable(BooleanType qosEnable) {
		this.qosEnable = qosEnable;
		application.setQosEnable(qosEnable.isBln());
	}

	public Integer getQosPort() {
		return qosPort;
	}

	public void setQosPort(Integer qosPort) {
		this.qosPort = qosPort;
		application.setQosPort(qosPort);
	}

	public BooleanType getQosAcceptForeignIp() {
		return qosAcceptForeignIp;
	}

	public void setQosAcceptForeignIp(BooleanType qosAcceptForeignIp) {
		this.qosAcceptForeignIp = qosAcceptForeignIp;
		application.setQosAcceptForeignIp(qosAcceptForeignIp.isBln());
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
		application.setParameters(parameters);
	}

	
}
