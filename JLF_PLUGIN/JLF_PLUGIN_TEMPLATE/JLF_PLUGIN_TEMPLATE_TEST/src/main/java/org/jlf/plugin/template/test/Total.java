package org.jlf.plugin.template.test;

import java.util.List;

/**
 * 
 * @ClassName: Total
 * @Description:模板对象
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class Total {

	private String SrvDate;
	private String srvTime;
	private String srvOpName;
	private String msgID;
	private String corrID;
	private String branch;
	private String company;
	private List<Detail> details;

	public String getSrvDate() {
		return SrvDate;
	}

	public void setSrvDate(String SrvDate) {
		this.SrvDate = SrvDate;
	}

	public String getSrvTime() {
		return srvTime;
	}

	public void setSrvTime(String srvTime) {
		this.srvTime = srvTime;
	}

	public String getSrvOpName() {
		return srvOpName;
	}

	public void setSrvOpName(String srvOpName) {
		this.srvOpName = srvOpName;
	}

	public String getMsgID() {
		return msgID;
	}

	public void setMsgID(String msgID) {
		this.msgID = msgID;
	}

	public String getCorrID() {
		return corrID;
	}

	public void setCorrID(String corrID) {
		this.corrID = corrID;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}
}
