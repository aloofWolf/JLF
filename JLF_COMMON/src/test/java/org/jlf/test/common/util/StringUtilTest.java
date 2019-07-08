package org.jlf.test.common.util;

import java.math.BigDecimal;

import org.jlf.common.util.StringUtil;
import org.junit.Test;

public class StringUtilTest {

	/**
	 * 
	 * @Title: replaceFirstToUp
	 * @Description:������ĸ��д����
	 */
	@Test
	public void replaceFirstToUp() {
		System.out.println("1:  " + StringUtil.replaceFirstToUp("asd"));
	}

	/**
	 * 
	 * @Title: isContainChina
	 * @Description:�ж��ַ������Ƿ�������Ĳ���
	 */
	@Test
	public void isContainChina() {
		System.out.println("2:  " + StringUtil.isContainChina("asd"));
		System.out.println("2:  " + StringUtil.isContainChina("a��s"));
	}

	/**
	 * 
	 * @Title: flushChar
	 * @Description:�ַ���������
	 */
	@Test
	public void flushChar() {
		System.out.println("3:  " + StringUtil.flushChar('a', 10, "qwert", 0));
	}

	/**
	 * 
	 * @Title: flushZeroLeft4MD5
	 * @Description:��MD5�ַ�������������
	 */
	@Test
	public void flushZeroLeft4MD5() {
		System.out.println("4:  " + StringUtil.flushZeroLeft4MD5("erty"));
	}

	/**
	 * 
	 * @Title: formatAmount2CNMontrayUnit
	 * @Description:�����ת��Ϊ���Ĵ�д����
	 */
	@Test
	public void formatAmount2CNMontrayUnit() {
		System.out.println("5:  " + StringUtil.formatAmount2CNMontrayUnit(new BigDecimal(3938.32)));
	}

	/**
	 * 
	 * @Title: formatAmount
	 * @Description:��ʽ�������ǧ�ַ�����
	 */
	@Test
	public void formatAmount() {
		System.out.println("6:  " + StringUtil.formatAmount(new BigDecimal(3938.32)));
	}

	/**
	 * 
	 * @Title: formatCount
	 * @Description:��ʽ����������
	 */
	@Test
	public void formatCount() {
		System.out.println("7:  " + StringUtil.formatCount(1287364));
	}

	/**
	 * 
	 * @Title: arrToStr
	 * @Description:������ת���ַ�������
	 */
	@Test
	public void arrToStr() {
		System.out.println("8:  " + StringUtil.arrToStr(new Integer[] { 1, 2, 3 }));
	}

	/**
	 * 
	 * @Title: arrToStr
	 * @Description:������ת���ַ�������
	 */
	@Test
	public void arrToStrWithSpilt() {
		System.out.println("9:  " + StringUtil.arrToStr(new Integer[] { 1, 2, 3 }, "|"));
	}
}
