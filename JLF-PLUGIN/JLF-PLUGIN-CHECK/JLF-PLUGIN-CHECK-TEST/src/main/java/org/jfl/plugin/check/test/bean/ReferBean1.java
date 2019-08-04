package org.jfl.plugin.check.test.bean;

import java.util.Date;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

public class ReferBean1 {

	@JLFCheckAnn(maxLength = 100,desc="≤‚ ‘8")
	private String str;
	//@JLFCheckAnn(maxDate = "2019-06-10 11:12:13",desc="≤‚ ‘9")
	private Date date;
	@JLFCheckAnn(maxValue = 100,desc="≤‚ ‘10")
	private Byte b;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Byte getB() {
		return b;
	}

	public void setB(Byte b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "ReferBean1 [str=" + str + ", date=" + date + ", b=" + b + "]";
	}

}
