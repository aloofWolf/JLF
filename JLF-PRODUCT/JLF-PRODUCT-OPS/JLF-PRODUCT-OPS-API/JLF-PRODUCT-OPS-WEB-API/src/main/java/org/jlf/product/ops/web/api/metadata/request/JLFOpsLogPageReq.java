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
 * @date 2019��7��4��
 */
public class JLFOpsLogPageReq {

	@JLFCheckAnn(desc = "��ҳ��Ϣ")
	private JLFMVCPagingRequest pages;
	@JLFCheckAnn(isNull = true, desc = "��άģ��")
	private JLFOpsModule module;
	@JLFCheckAnn(isNull = true, desc = "��ά����")
	private JLFOpsType type;
	@JLFCheckAnn(isNull = true, maxLength = 50, desc = "�ͻ��˱��")
	private String clientClsName;
	@JLFCheckAnn(isNull = true, maxLength = 50, desc = "����˱��")
	private String serverClsName;
	@JLFCheckAnn(isNull = true, maxLength = 50, desc = "�������")
	private String hostIp;
	@JLFCheckAnn(isNull = true, desc = "��ʼʱ��")
	private Date startTime;
	@JLFCheckAnn(isNull = true, desc = "����ʱ��")
	private Date endTime;
	@JLFCheckAnn(isNull = true, desc = "��ά��Աid")
	private Long userId;
	@JLFCheckAnn(isNull = true, desc = "��ά��Ա����")
	private String userName;
	@JLFCheckAnn(isNull = true, desc = "��ά���")
	private JLFOpsResult opsResult;
	@JLFCheckAnn(isNull = true, desc = "ʧ��ԭ��")
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
