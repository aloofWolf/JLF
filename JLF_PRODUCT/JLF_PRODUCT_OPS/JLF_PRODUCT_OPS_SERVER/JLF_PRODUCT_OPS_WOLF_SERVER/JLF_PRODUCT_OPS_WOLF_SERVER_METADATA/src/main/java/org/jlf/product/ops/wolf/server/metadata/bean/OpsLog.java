package org.jlf.product.ops.wolf.server.metadata.bean;

import org.jlf.product.ops.web.api.enums.JLFOpsModule;
import org.jlf.product.ops.web.api.enums.JLFOpsResult;
import org.jlf.product.ops.web.api.enums.JLFOpsType;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBean;

/**
 * 
 * @ClassName: OpsLog
 * @Description:运维日志实体
 * @author Lone Wolf
 * @date 2019年7月4日
 */
@JLFMVCBeanTableMapped(tableName = "OpsLog", dbName = "MAIN", desc = "运维日志表")
public class OpsLog extends JLFMVCBean {

	private static final long serialVersionUID = 2644035861639577634L;

	@JLFMVCBeanFieldMapped(desc = "运维模块")
	private JLFOpsModule module;
	@JLFMVCBeanFieldMapped(desc = "运维类型")
	private JLFOpsType type;
	@JLFMVCBeanFieldMapped(desc = "主机编号")
	private String hostCode;
	@JLFMVCBeanFieldMapped(desc = "客户端编号", isNotNull = true)
	private String clientCode;
	@JLFMVCBeanFieldMapped(desc = "服务端编号")
	private String serverCode;
	@JLFMVCBeanFieldMapped(desc = "创建记录用户名")
	private String createUserName;
	@JLFMVCBeanFieldMapped(desc = "运维结果")
	private JLFOpsResult opsResult;
	@JLFMVCBeanFieldMapped(strLength = 100, desc = "失败原因")
	private String failReason;

	public JLFOpsModule getModule() {
		return module;
	}

	public void setModule(JLFOpsModule module) {
		this.module = module;
	}

	public JLFOpsType getType() {
		return type;
	}

	public void setType(JLFOpsType type) {
		this.type = type;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getServerCode() {
		return serverCode;
	}

	public void setServerCode(String serverCode) {
		this.serverCode = serverCode;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getHostCode() {
		return hostCode;
	}

	public void setHostCode(String hostCode) {
		this.hostCode = hostCode;
	}

	public JLFOpsResult getOpsResult() {
		return opsResult;
	}

	public void setOpsResult(JLFOpsResult opsResult) {
		this.opsResult = opsResult;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((clientCode == null) ? 0 : clientCode.hashCode());
		result = prime * result + ((createUserName == null) ? 0 : createUserName.hashCode());
		result = prime * result + ((failReason == null) ? 0 : failReason.hashCode());
		result = prime * result + ((hostCode == null) ? 0 : hostCode.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((opsResult == null) ? 0 : opsResult.hashCode());
		result = prime * result + ((serverCode == null) ? 0 : serverCode.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpsLog other = (OpsLog) obj;
		if (clientCode == null) {
			if (other.clientCode != null)
				return false;
		} else if (!clientCode.equals(other.clientCode))
			return false;
		if (createUserName == null) {
			if (other.createUserName != null)
				return false;
		} else if (!createUserName.equals(other.createUserName))
			return false;
		if (failReason == null) {
			if (other.failReason != null)
				return false;
		} else if (!failReason.equals(other.failReason))
			return false;
		if (hostCode == null) {
			if (other.hostCode != null)
				return false;
		} else if (!hostCode.equals(other.hostCode))
			return false;
		if (module != other.module)
			return false;
		if (opsResult != other.opsResult)
			return false;
		if (serverCode == null) {
			if (other.serverCode != null)
				return false;
		} else if (!serverCode.equals(other.serverCode))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OpsLog [module=" + module + ", type=" + type + ", hostCode=" + hostCode + ", clientCode=" + clientCode
				+ ", serverCode=" + serverCode + ", createUserName=" + createUserName + ", opsResult=" + opsResult
				+ ", failReason=" + failReason + ", toString()=" + super.toString() + "]";
	}

}
