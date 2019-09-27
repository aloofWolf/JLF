package org.jlf.product.log.web.metadata.request;

import java.util.Date;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.enums.JLFMVCOperatorResult;
import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;

/**
 * 
 * @ClassName: JLFLogPageReq
 * @Description: ��ҳ��ѯ��־�����������Ϣ
 * @author Lone Wolf
 * @date 2019��9��23��
 */
public class JLFLogPageReq {

	@JLFCheckAnn(desc = "��ҳ��Ϣ")
	private JLFMVCPagingRequest pages;
	@JLFCheckAnn(desc = "��ѯ�·�", minValue = 200000, maxValue = 209912)
	private Integer queryMonth;
	@JLFCheckAnn(desc = "�û�id", isNull = true)
	private Long userId;
	@JLFCheckAnn(desc = "�û�����", isNull = true)
	private String userName;
	@JLFCheckAnn(desc = "��������", isNull = true)
	private String reqType;
	@JLFCheckAnn(desc = "���ݿ�����", isNull = true)
	private String dbName;
	@JLFCheckAnn(desc = "����ʱ����", isNull = true)
	private Date requestTimeStart;
	@JLFCheckAnn(desc = "����ʱ��ֹ", isNull = true)
	private Date requestTimeEnd;
	@JLFCheckAnn(desc = "��Ӧʱ����", isNull = true)
	private Date responseTimeStart;
	@JLFCheckAnn(desc = "��Ӧʱ��ֹ", isNull = true)
	private Date responseTimeEnd;
	@JLFCheckAnn(desc = "����", isNull = true)
	private String params;
	@JLFCheckAnn(desc = "������", isNull = true)
	private JLFMVCOperatorResult result;
	@JLFCheckAnn(desc = "������Ϣ", isNull = true)
	private String errMsg;

	public JLFMVCPagingRequest getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingRequest pages) {
		this.pages = pages;
	}

	public Integer getQueryMonth() {
		return queryMonth;
	}

	public void setQueryMonth(Integer queryMonth) {
		this.queryMonth = queryMonth;
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

	public Date getRequestTimeStart() {
		return requestTimeStart;
	}

	public void setRequestTimeStart(Date requestTimeStart) {
		this.requestTimeStart = requestTimeStart;
	}

	public Date getRequestTimeEnd() {
		return requestTimeEnd;
	}

	public void setRequestTimeEnd(Date requestTimeEnd) {
		this.requestTimeEnd = requestTimeEnd;
	}

	public Date getResponseTimeStart() {
		return responseTimeStart;
	}

	public void setResponseTimeStart(Date responseTimeStart) {
		this.responseTimeStart = responseTimeStart;
	}

	public Date getResponseTimeEnd() {
		return responseTimeEnd;
	}

	public void setResponseTimeEnd(Date responseTimeEnd) {
		this.responseTimeEnd = responseTimeEnd;
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

}
