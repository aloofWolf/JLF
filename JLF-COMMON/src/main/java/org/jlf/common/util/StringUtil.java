package org.jlf.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: StringUtil
 * @Description:String������
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public class StringUtil {

	private static final int MD5LENGTH = 32;

	/**
	 * ���������ִ�д
	 */
	private static final String[] CN_UPPER_NUMBER = { "��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��" };

	private static final String[] CN_UPPER_MONETRAY_UNIT = { "��", "��", "Ԫ", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ",
			"��", "Ǫ", "��", "ʰ", "��", "Ǫ" };

	/**
	 * �����ַ�����
	 */
	private static final String CN_FULL = "��";

	/**
	 * �����ַ�����
	 */
	private static final String CN_NEGATIVE = "��";

	/**
	 * ���ľ��ȣ�Ĭ��ֵΪ2
	 */
	private static final int MONEY_PRECISION = 2;

	/**
	 * �����ַ�����Ԫ��
	 */
	private static final String CN_ZEOR_FULL = "��Ԫ" + CN_FULL;

	/**
	 * 
	 * @Title: replaceFirstToUp
	 * @Description:������ĸ��д
	 * @param str
	 * @return
	 */
	public static String replaceFirstToUp(String str) {
		return str = str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * 
	 * @Title: isContainChina
	 * @Description:�ж��ַ������Ƿ��������
	 * @param str
	 * @return
	 */
	public static boolean isContainChina(String str) {
		if (str == null || str.length() <= 0) {
			return false;
		}
		if (str.getBytes().length == str.length()) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @Title: flushChar
	 * @Description:�ַ������
	 * @param c
	 *            ����ַ�
	 * @param length
	 *            ���󳤶�
	 * @param str
	 * @param flushType
	 *            ������� 0:������� 1:�������
	 * @return
	 */
	public static String flushChar(char c, long length, String str, int flushType) {
		int strLen = str.length();
		StringBuffer sb = null;
		while (strLen < length) {
			sb = new StringBuffer();
			if (flushType == 0) {
				sb.append(c).append(str);// ��
			} else if (flushType == 1) {
				sb.append(str).append(c); // �Ҳ�
			} else {
				throw new RuntimeException("��ָ�������ַ�������");
			}
			str = sb.toString();
			strLen = str.length();
		}
		return str;
	}

	/**
	 * 
	 * @Title: flushZeroLeft4MD5
	 * @Description:��MD5�ַ����������
	 * @param str
	 * @return
	 */
	public static String flushZeroLeft4MD5(String str) {
		if (str != null && !"".equals(str)) {
			if (str.length() < MD5LENGTH) {
				return flushChar('0', MD5LENGTH, str, 0);
			}
		}
		return str;
	}

	/**
	 * 
	 * @Title: formatAmount2CNMontrayUnit
	 * @Description:�����ת��Ϊ���Ĵ�д
	 * @param amount
	 * @return
	 */
	public static String formatAmount2CNMontrayUnit(BigDecimal amount) {
		StringBuffer sb = new StringBuffer();

		int signum = amount.signum();
		if (signum == 0) {
			return CN_ZEOR_FULL;
		}

		// �������н�����������
		long number = amount.movePointRight(MONEY_PRECISION).setScale(0, 4).abs().longValue();

		/**
		 * �õ�С�������λֵ
		 */
		long scale = number % 100;
		int numUnit = 0;
		int numIndex = 0;
		boolean getZero = false;
		// �ж������λ����һ�������������00 = 0, 01 = 1, 10, 11
		if (!(scale > 0)) {
			numIndex = 2;
			number = number / 100;
			getZero = true;
		}

		if ((scale > 0) && (!(scale % 10 > 0))) {
			numIndex = 1;
			number = number / 10;
			getZero = true;
		}

		int zeroSize = 0;
		while (true) {
			if (number <= 0) {
				break;
			}
			// ÿ�λ�ȡ�����һ����
			numUnit = (int) (number % 10);
			if (numUnit > 0) {
				if ((numIndex == 9) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
				}
				if ((numIndex == 13) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
				}
				sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				getZero = false;
				zeroSize = 0;
			} else {
				++zeroSize;
				if (!(getZero)) {
					sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				}
				if (numIndex == 2) {
					if (number > 0) {
						sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
					}
				} else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				}
				getZero = true;
			}
			// ��numberÿ�ζ�ȥ�����һ����
			number = number / 10;
			++numIndex;
		}
		// ���signum == -1����˵�����������Ϊ������������ǰ��׷�������ַ�����
		if (signum == -1) {
			sb.insert(0, CN_NEGATIVE);
		}
		// ���������С�������λΪ"00"���������Ҫ�����׷�������ַ�����
		if (!(scale > 0)) {
			sb.append(CN_FULL);
		}
		return sb.toString();
	}

	/**
	 * 
	 * @Title: formatAmount
	 * @Description:��ʽ�������ǧ�ַ�
	 * @param amount
	 * @return
	 */
	public static String formatAmount(BigDecimal amount) {
		DecimalFormat df = new DecimalFormat(",###,##0.00");
		return df.format(amount);
	}

	/**
	 * 
	 * @Title: formatCount
	 * @Description:��ʽ������
	 * @param count
	 * @return
	 */
	public static String formatCount(Integer count) {
		DecimalFormat df = new DecimalFormat(",###,##0");
		return df.format(count);
	}

	/**
	 * 
	 * @Title: arrToStr
	 * @Description:������ת���ַ���
	 * @param arr
	 * @return
	 */
	public static <T> String arrToStr(T[] arr) {
		return arrToStr(arr, ",");
	}

	/**
	 * 
	 * @Title: arrToStr
	 * @Description:������ת���ַ���
	 * @param arr
	 * @param split
	 * @return
	 */
	public static <T> String arrToStr(T[] arr, String split) {
		if (arr == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (T t : arr) {
			sb.append(t.toString()).append(split);
		}
		return sb.substring(0, sb.length() - 1);
	}
	
	public static void main(String[] args){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("aaa", null);
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		System.out.println(map.containsKey("aaa"));
		System.out.println(map.containsKey("bbb"));
	}
}
