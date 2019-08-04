package org.jlf.plugin.template.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: Detail
 * @Description:模板对象list明细
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class Detail {

	private String company;
	private String branch;
	private String reqnno;
	private String stflag;
	private String txtline;

	public Detail(String company, String branch, String reqnno, String stflag, String txtline) {
		this.company = company;
		this.branch = branch;
		this.reqnno = reqnno;
		this.stflag = stflag;
		this.txtline = txtline;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("company", this.company);
		map.put("branch", this.branch);
		map.put("reqnno", this.reqnno);
		map.put("stflag", this.stflag);
		map.put("txtline", this.txtline);
		return map;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getReqnno() {
		return reqnno;
	}

	public void setReqnno(String reqnno) {
		this.reqnno = reqnno;
	}

	public String getStflag() {
		return stflag;
	}

	public void setStflag(String stflag) {
		this.stflag = stflag;
	}

	public String getTxtline() {
		return txtline;
	}

	public void setTxtline(String txtline) {
		this.txtline = txtline;
	}

}
