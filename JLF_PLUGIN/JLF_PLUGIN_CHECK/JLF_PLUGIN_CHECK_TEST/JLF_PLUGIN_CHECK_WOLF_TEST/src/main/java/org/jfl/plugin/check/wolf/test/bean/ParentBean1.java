package org.jfl.plugin.check.wolf.test.bean;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

public class ParentBean1 {

	@JLFCheckAnn(maxValue = 1, desc = "≤‚ ‘3")
	private Long l;
	@JLFCheckAnn(maxValue = 11.3, desc = "≤‚ ‘4")
	private Double d;

	public Long getL() {
		return l;
	}

	public void setL(Long l) {
		this.l = l;
	}

	public Double getD() {
		return d;
	}

	public void setD(Double d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "ParentBean1 [l=" + l + ", d=" + d + "]";
	}

}
