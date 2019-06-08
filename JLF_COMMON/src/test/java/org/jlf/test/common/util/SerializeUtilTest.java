package org.jlf.test.common.util;

import java.io.Serializable;

import org.jlf.common.util.SerializeUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: SerializeUtilTest
 * @Description:���л����������
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class SerializeUtilTest {

	/**
	 * 
	 * @Title: serialize
	 * @Description:���л��뷴���л�����
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
 * @Description:���л���
 * @author Lone Wolf
 * @date 2019��5��31��
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
