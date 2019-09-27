package org.jlf.test.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jlf.common.util.DateUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: DateUtilTest
 * @Description:���ڹ��������
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class DateUtilTest {

	/**
	 * 
	 * @Title: getDateString
	 * @Description:���Ի�ȡ�����ַ���
	 */
	@Test
	public void getDateString() {
		System.out.println("1:  " + DateUtil.getDateString(new Date()));
	}

	/**
	 * 
	 * @Title: getDateNotTime
	 * @Description:���Ի�ȡû��ʱ�������
	 */
	@Test
	public void getDateNotTime() {
		System.out.println("2:  " + DateUtil.getDateNotTime(new Date()));
	}

	/**
	 * 
	 * @Title: getDateOnlyTime
	 * @Description:���Ի�ȡû�����ڵ�ʱ��
	 */
	@Test
	public void getDateOnlyTime() {
		System.out.println("3:  " + DateUtil.getDateOnlyTime(new Date()));
	}

	/**
	 * 
	 * @Title: getDateStringFormat
	 * @Description:���Ը������ڻ�ȡ�����ַ���
	 */
	@Test
	public void getDateStringFormat() {
		System.out.println("4:  " + DateUtil.getDateString(new Date(), DateUtil.DEFAULT_DATETIMEPATTERN));
	}

	/**
	 * 
	 * @Title: formatDate
	 * @Description:���Ը��������ַ�����ȡ����
	 */
	@Test
	public void formatDate() {
		System.out.println("5:  " + DateUtil.formatDate("2019-09-21"));

	}

	/**
	 * 
	 * @Title: formatDateFormat
	 * @Description:���Ը��������ַ�����ȡ����
	 */
	@Test
	public void formatDateFormat() {
		System.out.println("6:  " + DateUtil.formatDate("2019-09-21 10:21:32", DateUtil.DEFAULT_DATETIMEPATTERN));

	}

	/**
	 * 
	 * @Title: compareDataString
	 * @Description:���������ַ����Ƚ�
	 */
	@Test
	public void compareDataString() {
		System.out.println("7:  " + DateUtil.compareDataString("2019-09-21", "2019-09-23"));
	}

	@Test
	public void compareData() {
		System.out.println("7.1:  " + DateUtil.compareData(new Date(), new Date()));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayBefore
	 * @Description:���Ի�ȡָ�������ַ���ǰһ��������ַ���
	 */
	@Test
	public void getSpecifiedDayBefore() {
		System.out.println("8:  " + DateUtil.getSpecifiedDayBefore("2019-09-21"));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayBeforeFormat
	 * @Description:���Ը���ָ�������ַ�������ȡǰ���죨��dayNumeָ�����������ַ���
	 */
	@Test
	public void getSpecifiedDayBeforeFormat() {
		System.out.println("9:  " + DateUtil.getSpecifiedDayBefore("2019-09-21", 11, DateUtil.DEFAULT_DATEPATTERN));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayBeforeDate
	 * @Description:���Ը���ָ�������ַ�����ȡǰһ��
	 */
	@Test
	public void getSpecifiedDayBeforeDate() {
		System.out.println("10:  " + DateUtil.getSpecifiedDayBeforeDate("2019-09-21"));
	}

	/**
	 * 
	 * @Title: getSomeDayBefore
	 * @Description:���Ը���ָn�����ڻ�ȡǰ���죨�ɲ���intervalָ�����������ַ���
	 */
	@Test
	public void getSomeDayBefore() {
		System.out.println("11:  " + DateUtil.getSomeDayBefore(new Date(), 11,DateUtil.DEFAULT_DATEPATTERN));
	}

	/**
	 * 
	 * @Title: getSomeDayBefore_beginDate
	 * @Description:���Ծ�ָn�����ڻ�ȡǰ���죨�ɲ���intervalָ���������ڿ�ʼ
	 */
	@Test
	public void getSomeDayBefore_beginDate() {
		System.out.println("12:  " + DateUtil.getSomeDayBefore_beginDate(new Date(), 11));
	}

	/**
	 * 
	 * @Title: getSomeDayBefore_endDate
	 * @Description:���Ծ�ָn�����ڻ�ȡǰ���죨�ɲ���intervalָ���������ڽ���
	 */
	@Test
	public void getSomeDayBefore_endDate() {
		System.out.println("13:  " + DateUtil.getSomeDayBefore_endDate(new Date(), 11));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayAfter
	 * @Description:���Ի�ȡ��һ��
	 */
	@Test
	public void getSpecifiedDayAfter() {
		System.out.println("14:  " + DateUtil.getSpecifiedDayAfter("2019-08-22"));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayAfterFormat
	 * @Description:���Ը���ָ�������ַ�������ȡ���죨��dayNumeָ�����������ַ���
	 */
	@Test
	public void getSpecifiedDayAfterFormat() {
		System.out.println(
				"15:  " + DateUtil.getSpecifiedDayAfter("2019-08-22 11:23:11", 11, DateUtil.DEFAULT_DATETIMEPATTERN));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayAfterDate
	 * @Description:���Ը���ָ�������ַ�����ȡ��һ��
	 */
	@Test
	public void getSpecifiedDayAfterDate() {
		System.out.println("16:  " + DateUtil.getSpecifiedDayAfterDate("2019-08-22"));
	}

	/**
	 * 
	 * @Title: getSomeDayAfter
	 * @Description:���Ը���ָn�����ڻ�ȡ���죨�ɲ���intervalָ�����������ַ���
	 */
	@Test
	public void getSomeDayAfter() {
		System.out.println("17:  " + DateUtil.getSomeDayAfter(new Date(), 3,DateUtil.DEFAULT_DATEPATTERN));
	}

	/**
	 * 
	 * @Title: getSomeDayAfter_beginDate
	 * @Description:���Ծ�ָn�����ڻ�ȡ���죨�ɲ���intervalָ���������ڿ�ʼ
	 */
	@Test
	public void getSomeDayAfter_beginDate() {
		System.out.println("18:  " + DateUtil.getSomeDayAfter_beginDate(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getSomeDayAfter_endDate
	 * @Description:���Ծ�ָn�����ڻ�ȡ���죨�ɲ���intervalָ���������ڽ���
	 */
	@Test
	public void getSomeDayAfter_endDate() {
		System.out.println("19:  " + DateUtil.getSomeDayAfter_endDate(new Date(), 3));
	}

	/**
	 * 
	 * @Title: isSameDate
	 * @Description:�����ж�ʱ�䴮��ʱ���Ƿ���ͬһ��
	 */
	@Test
	public void isSameDate() {
		System.out.println("20:  " + DateUtil.isSameDate("2019-05-24", new Date()));

	}

	/**
	 * 
	 * @Title: daysBetween
	 * @Description:���Լ������������������
	 */
	@Test
	public void daysBetween() {
		System.out.println("21:  " + DateUtil.daysBetween(new Date(), new Date()));
	}

	/**
	 * 
	 * @Title: daysBetweenStr
	 * @Description:���Լ������������ַ����������
	 */
	@Test
	public void daysBetweenStr() {
		System.out.println("22:  " + DateUtil.daysBetween("2019-08-23", "2019-07-24"));
	}

	/**
	 * 
	 * @Title: getSameWeekFirstDay
	 * @Description:���Ի�ȡָ�����ڻ�ȡ����ͬһ���еĵ�һ��(������Ϊ��һ��)
	 */
	@Test
	public void getSameWeekFirstDay() {
		System.out.println("23:  " + DateUtil.getSameWeekFirstDay(new Date()));
	}

	/**
	 * 
	 * @Title: getSameWeekFirstDay_chinese
	 * @Description:���Ի�ȡָ�����ڻ�ȡ����ͬһ���еĵ�һ��(��һ��Ϊ��һ��)
	 */
	@Test
	public void getSameWeekFirstDay_chinese() {
		System.out.println("24:  " + DateUtil.getSameWeekFirstDay_chinese(new Date()));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekFirstDay
	 * @Description:���Ի�ȡָ������ָ������֮ǰ����assignedָ�����ĵ�һ��(������Ϊ��һ��)
	 */
	@Test
	public void getAssignedBeforeWeekFirstDay() {
		System.out.println("25:  " + DateUtil.getAssignedBeforeWeekFirstDay(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekFirstDay_chinese
	 * @Description:���Ի�ȡָ������ָ������֮ǰ����assignedָ�����ĵ�һ��(��һ��Ϊ��һ��)
	 */
	@Test
	public void getAssignedBeforeWeekFirstDay_chinese() {
		System.out.println("26:  " + DateUtil.getAssignedBeforeWeekFirstDay_chinese(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getSameWeekLastDay
	 * @Description:���Ի�ȡָ�����ڻ�ȡ����ͬһ���е����һ��(������Ϊ���һ��)
	 */
	@Test
	public void getSameWeekLastDay() {
		System.out.println("27:  " + DateUtil.getSameWeekLastDay(new Date()));
	}

	/**
	 * 
	 * @Title: getSameWeekLastDay_chinese
	 * @Description:���Ի�ȡָ�����ڻ�ȡ����ͬһ���е����һ��(������Ϊ���һ��)
	 * @return
	 */
	@Test
	public void getSameWeekLastDay_chinese() {
		System.out.println("28:  " + DateUtil.getSameWeekLastDay_chinese(new Date()));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekLastDay
	 * @Description:���Ի�ȡָ������ָ������֮ǰ����assignedָ�����������(������Ϊ���һ��)
	 */
	@Test
	public void getAssignedBeforeWeekLastDay() {
		System.out.println("29:  " + DateUtil.getAssignedBeforeWeekLastDay(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekLastDay_chinese
	 * @Description:���Ի�ȡָ������ָ������֮ǰ����assignedָ�����������(������Ϊ���һ��)
	 */
	@Test
	public void getAssignedBeforeWeekLastDay_chinese() {
		System.out.println("30:  " + DateUtil.getAssignedBeforeWeekLastDay_chinese(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getSameMonthFirstDay
	 * @Description:���Ի�ȡָ�����ڵ��µ�һ��
	 */
	@Test
	public void getSameMonthFirstDay() {
		System.out.println("31:  " + DateUtil.getSameMonthFirstDay(new Date()));
	}

	/**
	 * 
	 * @Title: getSameMonthLastDay
	 * @Description:���Ի�ȡָ�����ڵ������һ��
	 */
	@Test
	public void getSameMonthLastDay() {
		System.out.println("32:  " + DateUtil.getSameMonthLastDay(new Date()));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeMonthFirstDay
	 * @Description:���Ի�ȡָ������ָ��֮ǰ�£���assignedָ�����ĵ�һ��
	 */
	@Test
	public void getAssignedBeforeMonthFirstDay() {
		System.out.println("33:  " + DateUtil.getAssignedBeforeMonthFirstDay(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeMonthLaseDay
	 * @Description:���Ի�ȡָ������ָ��֮ǰ�£���assignedָ���������һ��
	 */
	@Test
	public void getAssignedBeforeMonthLaseDay() {
		System.out.println("34:  " + DateUtil.getAssignedBeforeMonthLaseDay(new Date(), 3));
	}
	
	/**
	 * 
	 * @Title: getDateAfterMinute
	 * @Description:��ȡ�����Ӻ��ʱ�����
	 * @param minute
	 * @return
	 */
	@Test
	public void getDateAfterMinute() {
		Date date = DateUtil.getDateAfterMinute(3);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime= df.format(date);
		System.out.println(nowTime);
	}

}
