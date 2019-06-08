package org.jlf.test.common.util;

import java.io.Serializable;

import org.jlf.common.util.SerializeUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: SerializeUtilTest
 * @Description:序列化工具类测试
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class SerializeUtilTest {

	/**
	 * 
	 * @Title: serialize
	 * @Description:序列化与反序列化测试
	 * @throws Exception
	 */
	@Test
	public void serialize() throws Exception {
		Ser ser = new Ser();
		ser.setStr("qqq");
		ser.setL(90l);
		ser.setI(123);
		System.out.println(Ser.serialVersionUID);
		String serStr = SerializeUtil.serialize(ser);
		System.out.println(SerializeUtil.serialize(serStr));
		System.out.println(SerializeUtil.serializeToObject(serStr, Ser.class).toString());
	}

}

/**
 * 
 * @ClassName: Ser
 * @Description:序列化类
 * @author Lone Wolf
 * @date 2019年5月31日
 */
class Ser implements Serializable {

	public static final long serialVersionUID = -8742543382652067777L;
	private String str;
	private Long l;
	private Integer i;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Long getL() {
		return l;
	}

	public void setL(Long l) {
		this.l = l;
	}

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "Ser [str=" + str + ", l=" + l + ", i=" + i + "]";
	}

}
