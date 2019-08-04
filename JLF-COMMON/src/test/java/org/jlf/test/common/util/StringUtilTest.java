package org.jlf.test.common.util;

import java.math.BigDecimal;

import org.jlf.common.util.StringUtil;
import org.junit.Test;

public class StringUtilTest {

	/**
	 * 
	 * @Title: replaceFirstToUp
	 * @Description:将首字母大写测试
	 */
	@Test
	public void replaceFirstToUp() {
		System.out.println("1:  " + StringUtil.replaceFirstToUp("asd"));
	}

	/**
	 * 
	 * @Title: isContainChina
	 * @Description:判断字符串中是否包含中文测试
	 */
	@Test
	public void isContainChina() {
		System.out.println("2:  " + StringUtil.isContainChina("asd"));
		System.out.println("2:  " + StringUtil.isContainChina("a我s"));
	}

	/**
	 * 
	 * @Title: flushChar
	 * @Description:字符串填充测试
	 */
	@Test
	public void flushChar() {
		System.out.println("3:  " + StringUtil.flushChar('a', 10, "qwert", 0));
	}

	/**
	 * 
	 * @Title: flushZeroLeft4MD5
	 * @Description:对MD5字符串进行填充测试
	 */
	@Test
	public void flushZeroLeft4MD5() {
		System.out.println("4:  " + StringUtil.flushZeroLeft4MD5("erty"));
	}

	/**
	 * 
	 * @Title: formatAmount2CNMontrayUnit
	 * @Description:将金额转换为中文大写测试
	 */
	@Test
	public void formatAmount2CNMontrayUnit() {
		System.out.println("5:  " + StringUtil.formatAmount2CNMontrayUnit(new BigDecimal(3938.32)));
	}

	/**
	 * 
	 * @Title: formatAmount
	 * @Description:格式花金额，添加千分符测试
	 */
	@Test
	public void formatAmount() {
		System.out.println("6:  " + StringUtil.formatAmount(new BigDecimal(3938.32)));
	}

	/**
	 * 
	 * @Title: formatCount
	 * @Description:格式化笔数测试
	 */
	@Test
	public void formatCount() {
		System.out.println("7:  " + StringUtil.formatCount(1287364));
	}

	/**
	 * 
	 * @Title: arrToStr
	 * @Description:将数组转成字符串测试
	 */
	@Test
	public void arrToStr() {
		System.out.println("8:  " + StringUtil.arrToStr(new Integer[] { 1, 2, 3 }));
	}

	/**
	 * 
	 * @Title: arrToStr
	 * @Description:将数组转成字符串测试
	 */
	@Test
	public void arrToStrWithSpilt() {
		System.out.println("9:  " + StringUtil.arrToStr(new Integer[] { 1, 2, 3 }, "|"));
	}
}
