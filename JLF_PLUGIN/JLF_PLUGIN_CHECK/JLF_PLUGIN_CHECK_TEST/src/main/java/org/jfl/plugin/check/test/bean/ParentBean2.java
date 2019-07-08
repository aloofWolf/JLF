package org.jfl.plugin.check.test.bean;

import java.util.Map;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

public class ParentBean2 extends ParentBean1 {

	@JLFCheckAnn(maxLength=100,desc="≤‚ ‘5")
	private String s;
	@JLFCheckAnn(maxLength=10,desc="≤‚ ‘6")
	private Map<String, String> map;
	@JLFCheckAnn(maxValue=100,desc="≤‚ ‘7")
	private Integer intt;
	@JLFCheckAnn
	private ReferBean2 r2;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Integer getIntt() {
		return intt;
	}

	public void setIntt(Integer intt) {
		this.intt = intt;
	}

	public ReferBean2 getR2() {
		return r2;
	}

	public void setR2(ReferBean2 r2) {
		this.r2 = r2;
	}

	@Override
	public String toString() {
		return "ParentBean2 [s=" + s + ", map=" + map + ", intt=" + intt + ", r2=" + r2 + ", toString()="
				+ super.toString() + "]";
	}

	

}
