package org.jlf.plugin.mq.test;

import java.io.Serializable;

/**
 * 
 * @ClassName: Bean
 * @Description:��Ϣ���д���bean
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class Bean implements Serializable {

	private static final long serialVersionUID = -4633648849761248791L;
	private String str1;
	private String str2;

	public Bean(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	@Override
	public String toString() {
		return "Bean [str1=" + str1 + ", str2=" + str2 + "]";
	}

}
