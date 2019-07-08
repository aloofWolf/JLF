package org.jlf.product.ops.web.api.metadata.response;

import java.util.Date;

/**
 * 
 * @ClassName: JLFOpsLogPageDetailResponse
 * @Description:opsLog分页查询响应明细信息
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class JLFOpsLogPageDetailResponse {

	private Integer module;
	private Integer type;
	private String clientCode;
	private String serverCode;
	private String hostCode;
	private Date opsTime;
	private Long userId;
	private String userName;
	private Integer opsResult;
	private String failReason;

	public Integer getModule() {
		return module;
	}

	public void setModule(Integer module) {
		this.module = module;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
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

	public String getHostCode() {
		return hostCode;
	}

	public void setHostCode(String hostCode) {
		this.hostCode = hostCode;
	}

	public Date getOpsTime() {
		return opsTime;
	}

	public void setOpsTime(Date opsTime) {
		this.opsTime = opsTime;
	}

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

	public Integer getOpsResult() {
		return opsResult;
	}

	public void setOpsResult(Integer opsResult) {
		this.opsResult = opsResult;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

}
