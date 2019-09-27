package org.jlf.product.log.web.metadata.entity;

import java.util.Date;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanFieldMapped;
import org.jlf.soa.mvc.metadata.ann.JLFMVCBeanTableMapped;
import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;
import org.jlf.soa.mvc.metadata.enums.JLFMVCOperatorResult;

/**
 * 
 * @ClassName: JLFLogEntity
 * @Description: JLFLogEntity
 * @author Lone Wolf
 * @date 2019年9月23日
 */

@JLFMVCBeanTableMapped(tableName = "log", desc = "日志表")
public class JLFLogEntity extends JLFMVCEntity {

	private static final long serialVersionUID = 5074963330546760595L;

	@JLFCheckAnn(desc = "用户id")
	@JLFMVCBeanFieldMapped(desc = "用户id")
	private Long userId;
	@JLFCheckAnn(desc = "用户名称")
	@JLFMVCBeanFieldMapped(desc = "用户名称")
	private String userName;
	@JLFCheckAnn(desc = "请求类型")
	@JLFMVCBeanFieldMapped(desc = "请求类型")
	private String reqType;
	@JLFCheckAnn(desc = "数据库名称")
	@JLFMVCBeanFieldMapped(desc = "数据库名称")
	private String dbName;
	@JLFCheckAnn(desc = "请求时间")
	@JLFMVCBeanFieldMapped(desc = "请求时间")
	private Date requestTime;
	@JLFCheckAnn(desc = "响应时间")
	@JLFMVCBeanFieldMapped(desc = "响应时间")
	private Date responseTime;
	@JLFCheckAnn(desc = "参数", maxLength = 1000, isNull = true)
	@JLFMVCBeanFieldMapped(desc = "参数", strLength = 1000, isNotNull = false)
	private String params;
	@JLFCheckAnn(desc = "请求结果")
	@JLFMVCBeanFieldMapped(desc = "请求结果")
	private JLFMVCOperatorResult result;
	@JLFCheckAnn(desc = "错误信息", maxLength = 1000, isNull = true)
	@JLFMVCBeanFieldMapped(desc = "错误信息", strLength = 1000, isNotNull = false)
	private String errMsg;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public JLFMVCOperatorResult getResult() {
		return result;
	}

	public void setResult(JLFMVCOperatorResult result) {
		this.result = result;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dbName == null) ? 0 : dbName.hashCode());
		result = prime * result + ((errMsg == null) ? 0 : errMsg.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		result = prime * result + ((reqType == null) ? 0 : reqType.hashCode());
		result = prime * result + ((requestTime == null) ? 0 : requestTime.hashCode());
		result = prime * result + ((responseTime == null) ? 0 : responseTime.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		JLFLogEntity other = (JLFLogEntity) obj;
		if (dbName == null) {
			if (other.dbName != null)
				return false;
		} else if (!dbName.equals(other.dbName))
			return false;
		if (errMsg == null) {
			if (other.errMsg != null)
				return false;
		} else if (!errMsg.equals(other.errMsg))
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		if (reqType == null) {
			if (other.reqType != null)
				return false;
		} else if (!reqType.equals(other.reqType))
			return false;
		if (requestTime == null) {
			if (other.requestTime != null)
				return false;
		} else if (!requestTime.equals(other.requestTime))
			return false;
		if (responseTime == null) {
			if (other.responseTime != null)
				return false;
		} else if (!responseTime.equals(other.responseTime))
			return false;
		if (result != other.result)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JLFLogEntity [userId=" + userId + ", userName=" + userName + ", reqType=" + reqType + ", dbName="
				+ dbName + ", requestTime=" + requestTime + ", responseTime=" + responseTime + ", params=" + params
				+ ", result=" + result + ", errMsg=" + errMsg + ", toString()=" + super.toString() + "]";
	}

}
