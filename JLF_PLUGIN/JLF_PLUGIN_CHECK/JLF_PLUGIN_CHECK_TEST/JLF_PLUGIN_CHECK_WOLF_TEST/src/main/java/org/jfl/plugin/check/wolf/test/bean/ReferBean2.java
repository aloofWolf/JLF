package org.jfl.plugin.check.wolf.test.bean;

import java.math.BigDecimal;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

public class ReferBean2 {
	
	@JLFCheckAnn(minValue=1,desc="≤‚ ‘11")
	private Short s;
	@JLFCheckAnn(maxValue=1000.11,desc="≤‚ ‘12")
	private BigDecimal bigd;
	@JLFCheckAnn(minValue=1,desc="≤‚ ‘13")
	private Integer intt;
	public Short getS() {
		return s;
	}
	public void setS(Short s) {
		this.s = s;
	}
	public BigDecimal getBigd() {
		return bigd;
	}
	public void setBigd(BigDecimal bigd) {
		this.bigd = bigd;
	}
	public Integer getIntt() {
		return intt;
	}
	public void setIntt(Integer intt) {
		this.intt = intt;
	}
	@Override
	public String toString() {
		return "ReferBean2 [s=" + s + ", bigd=" + bigd + ", intt=" + intt + "]";
	}
	

}
