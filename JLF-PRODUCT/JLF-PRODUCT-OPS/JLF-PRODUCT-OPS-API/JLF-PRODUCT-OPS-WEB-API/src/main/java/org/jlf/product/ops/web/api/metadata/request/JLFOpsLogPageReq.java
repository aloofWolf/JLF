package org.jlf.product.ops.web.api.metadata.request;

import java.util.Date;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.product.ops.web.api.enums.JLFOpsModule;
import org.jlf.product.ops.web.api.enums.JLFOpsResult;
import org.jlf.product.ops.web.api.enums.JLFOpsType;
import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;

/**
 * 
 * @ClassName: JLFOpsLogPageRequest
 * @Description:JLFOpsLogPageRequest
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class JLFOpsLogPageReq {

	@JLFCheckAnn(desc = "分页信息")
	private JLFMVCPagingRequest pages;
	@JLFCheckAnn(isNull = true, desc = "运维模块")
	private JLFOpsModule module;
	@JLFCheckAnn(isNull = true, desc = "运维类型")
	private JLFOpsType type;
	@JLFCheckAnn(isNull = true, maxLength = 50, desc = "客户端编号")
	private String clientClsName;
	@JLFCheckAnn(isNull = true, maxLength = 50, desc = "服务端编号")
	private String serverClsName;
	@JLFCheckAnn(isNull = true, maxLength = 50, desc = "主机编号")
	private String hostIp;
	@JLFCheckAnn(isNull = true, desc = "开始时间")
	private Date startTime;
	@JLFCheckAnn(isNull = true, desc = "结束时间")
	private Date endTime;
	@JLFCheckAnn(isNull = true, desc = "运维人员id")
	private Long userId;
	@JLFCheckAnn(isNull = true, desc = "运维人员名称")
	private String userName;
	@JLFCheckAnn(isNull = true, desc = "运维结果")
	private JLFOpsResult opsResult;
	@JLFCheckAnn(isNull = true, desc = "失败原因")
	private String failReason;
	public JLFMVCPagingRequest getPages() {
		return pages;
	}
	public void setPages(JLFMVCPagingRequest pages) {
		this.pages = pages;
	}
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
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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


}
