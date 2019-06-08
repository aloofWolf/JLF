package org.jfl.plugin.check.wolf.test.bean;

import java.util.List;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

public class ChildBean extends ParentBean2{
	
	@JLFCheckAnn(maxValue=100.00,desc="≤‚ ‘1")
	private Float f;
	@JLFCheckAnn(minLength=1,desc="≤‚ ‘2")
	private List<ReferBean1> list;
	public Float getF() {
		return f;
	}
	public void setF(Float f) {
		this.f = f;
	}
	public List<ReferBean1> getList() {
		return list;
	}
	public void setList(List<ReferBean1> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "ChildBean [f=" + f + ", list=" + list + ", toString()=" + super.toString() + "]";
	}
	
	

}
