package org.jlf.product.quartz.wolf.server.metadata.bean;

import org.jlf.product.quartz.wolf.server.metadata.enums.JLFOpsModule;
import org.jlf.product.quartz.wolf.server.metadata.enums.JLFOpsResult;
import org.jlf.product.quartz.wolf.server.metadata.enums.JLFOpsType;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;

/**
 * 
 * @ClassName: OpsLog
 * @Description:运维日志实体
 * @author Lone Wolf
 * @date 2019年7月4日
 */
@JLFMVCBeanTableMapped(tableName = "OpsLog", desc = "运维日志表")
public class JLFOpsLog extends JLFMVCEntity {

	private static final long serialVersionUID = 2644035861639577634L;

	@JLFMVCBeanFieldMapped(desc = "运维模块")
	private JLFOpsModule module;
	@JLFMVCBeanFieldMapped(desc = "运维类型")
	private JLFOpsType type;
	@JLFMVCBeanFieldMapped(desc = "主机编号")
	private String hostIp;
	@JLFMVCBeanFieldMapped(desc = "客户端编号", isNotNull = false)
	private String clientClsName;
	@JLFMVCBeanFieldMapped(desc = "服务端编号", isNotNull = false)
	private String serverClsName;
	@JLFMVCBeanFieldMapped(desc = "创建记录用户名")
	private String createUserName;
	@JLFMVCBeanFieldMapped(desc = "运维结果")
	private JLFOpsResult opsResult;
	@JLFMVCBeanFieldMapped(strLength = 100, desc = "失败原因", isNotNull = false)
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

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public String getClientClsName() {
		return clientClsName;
	}

	public void setClientClsName(String clientClsName) {
		this.clientClsName = clientClsName;
	}

	public String getServerClsName() {
		return serverClsName;
	}

	public void setServerClsName(String serverClsName) {
		this.serverClsName = serverClsName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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
		result = prime * result + ((clientClsName == null) ? 0 : clientClsName.hashCode());
		result = prime * result + ((createUserName == null) ? 0 : createUserName.hashCode());
		result = prime * result + ((failReason == null) ? 0 : failReason.hashCode());
		result = prime * result + ((hostIp == null) ? 0 : hostIp.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((opsResult == null) ? 0 : opsResult.hashCode());
		result = prime * result + ((serverClsName == null) ? 0 : serverClsName.hashCode());
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
		JLFOpsLog other = (JLFOpsLog) obj;
		if (clientClsName == null) {
			if (other.clientClsName != null)
				return false;
		} else if (!clientClsName.equals(other.clientClsName))
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
		if (hostIp == null) {
			if (other.hostIp != null)
				return false;
		} else if (!hostIp.equals(other.hostIp))
			return false;
		if (module != other.module)
			return false;
		if (opsResult != other.opsResult)
			return false;
		if (serverClsName == null) {
			if (other.serverClsName != null)
				return false;
		} else if (!serverClsName.equals(other.serverClsName))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OpsLog [module=" + module + ", type=" + type + ", hostIp=" + hostIp + ", clientClsName=" + clientClsName
				+ ", serverClsName=" + serverClsName + ", createUserName=" + createUserName + ", opsResult=" + opsResult
				+ ", failReason=" + failReason + ", toString()=" + super.toString() + "]";
	}

}
