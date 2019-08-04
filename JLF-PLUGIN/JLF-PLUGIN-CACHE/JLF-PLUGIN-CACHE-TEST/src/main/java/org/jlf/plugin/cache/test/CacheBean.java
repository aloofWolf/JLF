package org.jlf.plugin.cache.test;

import java.io.Serializable;

/**
 * 
 * @ClassName: CacheBean
 * @Description:�������
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class CacheBean implements Serializable {

	private static final long serialVersionUID = 6715721838114864944L;

	private String str = "qqq";
	private String name = "����˭";

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CacheBean [str=" + str + ", name=" + name + "]";
	}
	
	

}
