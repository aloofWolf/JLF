package org.jlf.test.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jlf.common.util.DateUtil;
import org.junit.Test;

/**
 * 
 * @ClassName: DateUtilTest
 * @Description:日期工具类测试
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class DateUtilTest {

	/**
	 * 
	 * @Title: getDateString
	 * @Description:测试获取日期字符串
	 */
	@Test
	public void getDateString() {
		System.out.println("1:  " + DateUtil.getDateString(new Date()));
	}

	/**
	 * 
	 * @Title: getDateNotTime
	 * @Description:测试获取没有时间的日期
	 */
	@Test
	public void getDateNotTime() {
		System.out.println("2:  " + DateUtil.getDateNotTime(new Date()));
	}

	/**
	 * 
	 * @Title: getDateOnlyTime
	 * @Description:测试获取没有日期的时间
	 */
	@Test
	public void getDateOnlyTime() {
		System.out.println("3:  " + DateUtil.getDateOnlyTime(new Date()));
	}

	/**
	 * 
	 * @Title: getDateStringFormat
	 * @Description:测试根据日期获取日期字符串
	 */
	@Test
	public void getDateStringFormat() {
		System.out.println("4:  " + DateUtil.getDateString(new Date(), DateUtil.DEFAULT_DATETIMEPATTERN));
	}

	/**
	 * 
	 * @Title: formatDate
	 * @Description:测试根据日期字符串获取日期
	 */
	@Test
	public void formatDate() {
		System.out.println("5:  " + DateUtil.formatDate("2019-09-21"));

	}

	/**
	 * 
	 * @Title: formatDateFormat
	 * @Description:测试根据日期字符串获取日期
	 */
	@Test
	public void formatDateFormat() {
		System.out.println("6:  " + DateUtil.formatDate("2019-09-21 10:21:32", DateUtil.DEFAULT_DATETIMEPATTERN));

	}

	/**
	 * 
	 * @Title: compareDataString
	 * @Description:测试日期字符串比较
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
	 * @Description:测试获取指定日期字符串前一天的日期字符串
	 */
	@Test
	public void getSpecifiedDayBefore() {
		System.out.println("8:  " + DateUtil.getSpecifiedDayBefore("2019-09-21"));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayBeforeFormat
	 * @Description:测试根据指定日期字符串。获取前几天（由dayNume指定）的日期字符串
	 */
	@Test
	public void getSpecifiedDayBeforeFormat() {
		System.out.println("9:  " + DateUtil.getSpecifiedDayBefore("2019-09-21", 11, DateUtil.DEFAULT_DATEPATTERN));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayBeforeDate
	 * @Description:测试根据指定日期字符串获取前一天
	 */
	@Test
	public void getSpecifiedDayBeforeDate() {
		System.out.println("10:  " + DateUtil.getSpecifiedDayBeforeDate("2019-09-21"));
	}

	/**
	 * 
	 * @Title: getSomeDayBefore
	 * @Description:测试根据指n定日期获取前几天（由参数interval指定）的日期字符串
	 */
	@Test
	public void getSomeDayBefore() {
		System.out.println("11:  " + DateUtil.getSomeDayBefore(new Date(), 11,DateUtil.DEFAULT_DATEPATTERN));
	}

	/**
	 * 
	 * @Title: getSomeDayBefore_beginDate
	 * @Description:测试据指n定日期获取前几天（由参数interval指定）的日期开始
	 */
	@Test
	public void getSomeDayBefore_beginDate() {
		System.out.println("12:  " + DateUtil.getSomeDayBefore_beginDate(new Date(), 11));
	}

	/**
	 * 
	 * @Title: getSomeDayBefore_endDate
	 * @Description:测试据指n定日期获取前几天（由参数interval指定）的日期结束
	 */
	@Test
	public void getSomeDayBefore_endDate() {
		System.out.println("13:  " + DateUtil.getSomeDayBefore_endDate(new Date(), 11));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayAfter
	 * @Description:测试获取后一天
	 */
	@Test
	public void getSpecifiedDayAfter() {
		System.out.println("14:  " + DateUtil.getSpecifiedDayAfter("2019-08-22"));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayAfterFormat
	 * @Description:测试根据指定日期字符串。获取后几天（由dayNume指定）的日期字符串
	 */
	@Test
	public void getSpecifiedDayAfterFormat() {
		System.out.println(
				"15:  " + DateUtil.getSpecifiedDayAfter("2019-08-22 11:23:11", 11, DateUtil.DEFAULT_DATETIMEPATTERN));
	}

	/**
	 * 
	 * @Title: getSpecifiedDayAfterDate
	 * @Description:测试根据指定日期字符串获取后一天
	 */
	@Test
	public void getSpecifiedDayAfterDate() {
		System.out.println("16:  " + DateUtil.getSpecifiedDayAfterDate("2019-08-22"));
	}

	/**
	 * 
	 * @Title: getSomeDayAfter
	 * @Description:测试根据指n定日期获取后几天（由参数interval指定）的日期字符串
	 */
	@Test
	public void getSomeDayAfter() {
		System.out.println("17:  " + DateUtil.getSomeDayAfter(new Date(), 3,DateUtil.DEFAULT_DATEPATTERN));
	}

	/**
	 * 
	 * @Title: getSomeDayAfter_beginDate
	 * @Description:测试据指n定日期获取后几天（由参数interval指定）的日期开始
	 */
	@Test
	public void getSomeDayAfter_beginDate() {
		System.out.println("18:  " + DateUtil.getSomeDayAfter_beginDate(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getSomeDayAfter_endDate
	 * @Description:测试据指n定日期获取后几天（由参数interval指定）的日期结束
	 */
	@Test
	public void getSomeDayAfter_endDate() {
		System.out.println("19:  " + DateUtil.getSomeDayAfter_endDate(new Date(), 3));
	}

	/**
	 * 
	 * @Title: isSameDate
	 * @Description:测试判断时间串与时间是否是同一天
	 */
	@Test
	public void isSameDate() {
		System.out.println("20:  " + DateUtil.isSameDate("2019-05-24", new Date()));

	}

	/**
	 * 
	 * @Title: daysBetween
	 * @Description:测试计算两个日期相隔天数
	 */
	@Test
	public void daysBetween() {
		System.out.println("21:  " + DateUtil.daysBetween(new Date(), new Date()));
	}

	/**
	 * 
	 * @Title: daysBetweenStr
	 * @Description:测试计算两个日期字符串相隔天数
	 */
	@Test
	public void daysBetweenStr() {
		System.out.println("22:  " + DateUtil.daysBetween("2019-08-23", "2019-07-24"));
	}

	/**
	 * 
	 * @Title: getSameWeekFirstDay
	 * @Description:测试获取指定日期获取日期同一周中的第一天(周日作为第一天)
	 */
	@Test
	public void getSameWeekFirstDay() {
		System.out.println("23:  " + DateUtil.getSameWeekFirstDay(new Date()));
	}

	/**
	 * 
	 * @Title: getSameWeekFirstDay_chinese
	 * @Description:测试获取指定日期获取日期同一周中的第一天(周一作为第一天)
	 */
	@Test
	public void getSameWeekFirstDay_chinese() {
		System.out.println("24:  " + DateUtil.getSameWeekFirstDay_chinese(new Date()));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekFirstDay
	 * @Description:测试获取指定日期指定几周之前（由assigned指定）的第一天(周日作为第一天)
	 */
	@Test
	public void getAssignedBeforeWeekFirstDay() {
		System.out.println("25:  " + DateUtil.getAssignedBeforeWeekFirstDay(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekFirstDay_chinese
	 * @Description:测试获取指定日期指定几周之前（由assigned指定）的第一天(周一作为第一天)
	 */
	@Test
	public void getAssignedBeforeWeekFirstDay_chinese() {
		System.out.println("26:  " + DateUtil.getAssignedBeforeWeekFirstDay_chinese(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getSameWeekLastDay
	 * @Description:测试获取指定日期获取日期同一周中的最后一天(周六作为最后一天)
	 */
	@Test
	public void getSameWeekLastDay() {
		System.out.println("27:  " + DateUtil.getSameWeekLastDay(new Date()));
	}

	/**
	 * 
	 * @Title: getSameWeekLastDay_chinese
	 * @Description:测试获取指定日期获取日期同一周中的最后一天(周六作为最后一天)
	 * @return
	 */
	@Test
	public void getSameWeekLastDay_chinese() {
		System.out.println("28:  " + DateUtil.getSameWeekLastDay_chinese(new Date()));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekLastDay
	 * @Description:测试获取指定日期指定几周之前（由assigned指定）的最后天(周六作为最后一天)
	 */
	@Test
	public void getAssignedBeforeWeekLastDay() {
		System.out.println("29:  " + DateUtil.getAssignedBeforeWeekLastDay(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekLastDay_chinese
	 * @Description:测试获取指定日期指定几周之前（由assigned指定）的最后天(周日作为最后一天)
	 */
	@Test
	public void getAssignedBeforeWeekLastDay_chinese() {
		System.out.println("30:  " + DateUtil.getAssignedBeforeWeekLastDay_chinese(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getSameMonthFirstDay
	 * @Description:测试获取指定日期当月第一天
	 */
	@Test
	public void getSameMonthFirstDay() {
		System.out.println("31:  " + DateUtil.getSameMonthFirstDay(new Date()));
	}

	/**
	 * 
	 * @Title: getSameMonthLastDay
	 * @Description:测试获取指定日期当月最后一天
	 */
	@Test
	public void getSameMonthLastDay() {
		System.out.println("32:  " + DateUtil.getSameMonthLastDay(new Date()));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeMonthFirstDay
	 * @Description:测试获取指定日期指定之前月（由assigned指定）的第一天
	 */
	@Test
	public void getAssignedBeforeMonthFirstDay() {
		System.out.println("33:  " + DateUtil.getAssignedBeforeMonthFirstDay(new Date(), 3));
	}

	/**
	 * 
	 * @Title: getAssignedBeforeMonthLaseDay
	 * @Description:测试获取指定日期指定之前月（由assigned指定）的最后一天
	 */
	@Test
	public void getAssignedBeforeMonthLaseDay() {
		System.out.println("34:  " + DateUtil.getAssignedBeforeMonthLaseDay(new Date(), 3));
	}
	
	/**
	 * 
	 * @Title: getDateAfterMinute
	 * @Description:获取几分钟后的时间测试
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
