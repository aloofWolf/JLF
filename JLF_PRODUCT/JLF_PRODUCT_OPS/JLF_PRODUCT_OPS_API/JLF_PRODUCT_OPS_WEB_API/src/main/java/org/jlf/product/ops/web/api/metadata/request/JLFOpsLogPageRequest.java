package org.jlf.product.ops.web.api.metadata.request;

import java.util.Date;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.product.ops.web.api.enums.JLFOpsModule;
import org.jlf.product.ops.web.api.enums.JLFOpsResult;
import org.jlf.product.ops.web.api.enums.JLFOpsType;
import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: JLFOpsLogPageRequest
 * @Description:JLFOpsLogPageRequest
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class JLFOpsLogPageRequest extends JLFMVCRequest {

	@JLFCheckAnn(desc = "��ҳ��Ϣ")
	private JLFMVCPagingRequest pages;
	@JLFCheckAnn(isNull = true, desc = "��άģ��")
	private JLFOpsModule module;
	@JLFCheckAnn(isNull = true, desc = "��ά����")
	private JLFOpsType type;
	@JLFCheckAnn(isNull = true, maxLength = 50, desc = "�ͻ��˱��")
	private String clientCode;
	@JLFCheckAnn(isNull = true, maxLength = 50, desc = "����˱��")
	private String serverCode;
	@JLFCheckAnn(isNull = true, maxLength = 50, desc = "�������")
	private String hostCode;
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
