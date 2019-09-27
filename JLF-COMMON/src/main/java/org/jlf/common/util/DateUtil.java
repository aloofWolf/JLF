package org.jlf.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtil
 * @Description:���ڹ�����
 * @author Lone Wolf
 * @date 2019��5��24��
 */
public class DateUtil {

	public static final String DEFAULT_DATEPATTERN = "yyyy-MM-dd";

	public static final String DEFAULT_TIMEPATTERN = " hh:mm:ss";

	public static final String DEFAULT_DATETIMEPATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String DEFAULT_DATEPATTERN_SIMP = "yyyyMMdd";

	public static final String DEFAULT_DATETIMEPATTERN_SIMP = "yyyyMMddHHmmss";

	/**
	 * 
	 * @Title: getDateString
	 * @Description:��ȡ�����ַ���
	 * @param date
	 * @return
	 */
	public static String getDateString(Date date) {
		if (date != null) {
			return new SimpleDateFormat(DEFAULT_DATEPATTERN).format(date.getTime());
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @Title: getDateNotTime
	 * @Description:��ȡû��ʱ�������
	 * @param date
	 * @return
	 */
	public static Date getDateNotTime(Date date) {
		String str_date = getDateString(date);
		try {
			return new SimpleDateFormat(DEFAULT_DATEPATTERN).parse(str_date);
		} catch (ParseException e) {
			e.printStackTrace();
			return date;
		}
	}

	/**
	 * 
	 * @Title: getDateOnlyTime
	 * @Description:��ȡû�����ڵ�ʱ��
	 * @param date
	 * @return
	 */
	public static String getDateOnlyTime(Date date) {
		DateFormat df = DateFormat.getTimeInstance();// ֻ��ʾ��ʱ����
		return df.format(date);
	}

	/**
	 * 
	 * @Title: getDateString
	 * @Description:�������ڻ�ȡ�����ַ���
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateString(Date date, String format) {
		String dayStr = new SimpleDateFormat(format).format(date.getTime());
		return dayStr;
	}

	public static void main(String[] args) {
		System.out.print(getDateString(new Date(), "YYYYMM"));
	}

	/**
	 * 
	 * @Title: formatDate
	 * @Description:���������ַ�����ȡ����
	 * @param str_date
	 * @return
	 */
	public static Date formatDate(String str_date) {
		Date result = null;
		try {
			result = new SimpleDateFormat(DEFAULT_DATEPATTERN).parse(str_date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;

	}

	/**
	 * 
	 * @Title: formatDate
	 * @Description:���������ַ�����ȡ����
	 * @param str_date
	 * @param format
	 * @return
	 */
	public static Date formatDate(String str_date, String format) {
		Date result = null;
		try {
			result = new SimpleDateFormat(format).parse(str_date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;

	}

	/**
	 * 
	 * @Title: compareDataString
	 * @Description:�����ַ����Ƚ�
	 * @param begin
	 *            ��ʼ����
	 * @param end
	 *            ��������
	 * @return �������ڴ��ڿ�ʼ����֮�󣬷��� 1 �����ڣ����� 0 ��С�ڣ����� -1
	 */
	public static int compareDataString(String begin, String end) {
		Date beingD = formatDate(begin);
		Date endD = formatDate(end);
		if (endD.getTime() == beingD.getTime()) {
			return 0;
		} else if (endD.getTime() > beingD.getTime()) {
			return 1;
		} else {
			return -1;
		}

	}

	/**
	 * 
	 * @Title: compareData
	 * @Description:���ڱȽ�
	 * @param begin
	 *            ��ʼ����
	 * @param end
	 *            ��������
	 * @return �������ڴ��ڿ�ʼ����֮�󣬷��� 1 �����ڣ����� 0 ��С�ڣ����� -1
	 */
	public static int compareData(Date begin, Date end) {
		if (end.getTime() == begin.getTime()) {
			return 0;
		} else if (end.getTime() > begin.getTime()) {
			return 1;
		} else {
			return -1;
		}

	}

	/**
	 * 
	 * @Title: getSpecifiedDayBefore
	 * @Description:��ȡָ�������ַ���ǰһ��������ַ���
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDayBefore(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(DEFAULT_DATEPATTERN).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayBefore;
	}

	/**
	 * 
	 * @Title: getSpecifiedDayBefore
	 * @Description:����ָ�������ַ�������ȡǰ���죨��dayNumeָ�����������ַ���
	 * @param specifiedDay
	 *            ָ������
	 * @param dayNum
	 *            ָ������
	 * @param format
	 *            ���������ַ�����ʽ��
	 * @return
	 */
	public static String getSpecifiedDayBefore(String specifiedDay, int dayNum, String format) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(format).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - dayNum);

		String dayBefore = new SimpleDateFormat(format).format(c.getTime());
		return dayBefore;
	}

	/**
	 * 
	 * @Title: getSpecifiedDayBeforeDate
	 * @Description:����ָ�������ַ�����ȡǰһ��
	 * @param specifiedDay
	 * @return
	 */
	public static Date getSpecifiedDayBeforeDate(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(DEFAULT_DATEPATTERN).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getSomeDayBefore
	 * @Description:����ָn�����ڻ�ȡǰ���죨�ɲ���intervalָ�����������ַ���
	 * @param date
	 * @param interval
	 * @param format
	 * @return
	 */
	public static String getSomeDayBefore(Date date, int interval, String format) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - interval);

		String dayBefore = new SimpleDateFormat(format).format(c.getTime());
		return dayBefore;
	}

	/**
	 * 
	 * @Title: getSomeDayBefore_beginDate
	 * @Description:��ָn�����ڻ�ȡǰ���죨�ɲ���intervalָ���������ڿ�ʼ
	 * @param date
	 * @param interval
	 * @return
	 */
	public static Date getSomeDayBefore_beginDate(Date date, int interval) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - interval);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getSomeDayBefore_endDate
	 * @Description:��ָn�����ڻ�ȡǰ���죨�ɲ���intervalָ���������ڽ���
	 * @param date
	 * @param interval
	 * @return
	 */
	public static Date getSomeDayBefore_endDate(Date date, int interval) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - interval);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getSpecifiedDayAfter
	 * @Description:��ȡ��һ��
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(DEFAULT_DATEPATTERN).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}

	/**
	 * 
	 * @Title: getSpecifiedDayAfter
	 * @Description:����ָ�������ַ�������ȡhou���죨��dayNumeָ�����������ַ���
	 * @param specifiedDay
	 *            ָ������
	 * @param dayNum
	 *            ָ������
	 * @param format
	 *            ���������ַ�����ʽ��
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay, int dayNum, String format) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(format).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + dayNum);

		String dayAfter = new SimpleDateFormat(format).format(c.getTime());
		return dayAfter;
	}

	/**
	 * 
	 * @Title: getSpecifiedDayAfterDate
	 * @Description:����ָ�������ַ�����ȡ��һ��
	 * @param specifiedDay
	 * @return
	 */
	public static Date getSpecifiedDayAfterDate(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(DEFAULT_DATEPATTERN).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getSomeDayAfter
	 * @Description:����ָn�����ڻ�ȡ���죨�ɲ���intervalָ�����������ַ���
	 * @param date
	 * @param interval
	 * @param format
	 * @return
	 */
	public static String getSomeDayAfter(Date date, int interval, String format) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + interval);

		String dayAfter = new SimpleDateFormat(format).format(c.getTime());
		return dayAfter;
	}

	/**
	 * 
	 * @Title: getSomeDayAfter_beginDate
	 * @Description:��ָn�����ڻ�ȡ���죨�ɲ���intervalָ���������ڿ�ʼ
	 * @param date
	 * @param interval
	 * @return
	 */
	public static Date getSomeDayAfter_beginDate(Date date, int interval) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + interval);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getSomeDayAfter_endDate
	 * @Description:��ָn�����ڻ�ȡ���죨�ɲ���intervalָ���������ڽ���
	 * @param date
	 * @param interval
	 * @return
	 */
	public static Date getSomeDayAfter_endDate(Date date, int interval) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + interval);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: isSameDate
	 * @Description:�ж�ʱ�䴮��ʱ���Ƿ���ͬһ��
	 * @param dateStr
	 * @param date
	 * @return
	 */
	public static boolean isSameDate(String dateStr, Date date) {
		Calendar strC = Calendar.getInstance();
		Calendar dateC = Calendar.getInstance();
		Date strDate = null;
		try {
			strDate = new SimpleDateFormat(DEFAULT_DATEPATTERN).parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		strC.setTime(strDate);
		dateC.setTime(date);

		return strC.get(Calendar.YEAR) == dateC.get(Calendar.YEAR)
				&& strC.get(Calendar.MONTH) == dateC.get(Calendar.MONTH)
				&& strC.get(Calendar.DATE) == dateC.get(Calendar.DATE);

	}

	/**
	 * 
	 * @Title: daysBetween
	 * @Description:�������������������
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int daysBetween(Date beginDate, Date endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATEPATTERN);
		try {
			beginDate = sdf.parse(sdf.format(beginDate));
			endDate = sdf.parse(sdf.format(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(endDate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 
	 * @Title: daysBetween
	 * @Description:�������������ַ����������
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int daysBetween(String beginDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATEPATTERN);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(beginDate));
			cal.setTime(sdf.parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		long time1 = cal.getTimeInMillis();
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 
	 * @Title: getSameWeekFirstDay
	 * @Description:��ȡָ�����ڻ�ȡ����ͬһ���еĵ�һ��(������Ϊ��һ��)
	 * @param date
	 * @return
	 */
	public static Date getSameWeekFirstDay(Date date) {
		return getAssignedBeforeWeekFirstDay(date, 0);
	}

	/**
	 * 
	 * @Title: getSameWeekFirstDay_chinese
	 * @Description:��ȡָ�����ڻ�ȡ����ͬһ���еĵ�һ��(��һ��Ϊ��һ��)
	 * @param date
	 * @return
	 */
	public static Date getSameWeekFirstDay_chinese(Date date) {
		return getAssignedBeforeWeekFirstDay_chinese(date, 0);
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekFirstDay
	 * @Description:��ȡָ������ָ������֮ǰ����assignedָ�����ĵ�һ��(������Ϊ��һ��)
	 * @param date
	 * @param assigned
	 * @return
	 */
	public static Date getAssignedBeforeWeekFirstDay(Date date, int assigned) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, 1);
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - assigned * 7);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekFirstDay_chinese
	 * @Description:��ȡָ������ָ������֮ǰ����assignedָ�����ĵ�һ��(��һ��Ϊ��һ��)
	 * @param date
	 * @param assigned
	 * @return
	 */
	public static Date getAssignedBeforeWeekFirstDay_chinese(Date date, int assigned) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, 2);
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - assigned * 7);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getSameWeekLastDay
	 * @Description:��ȡָ�����ڻ�ȡ����ͬһ���е����һ��(������Ϊ���һ��)
	 * @return
	 */
	public static Date getSameWeekLastDay(Date date) {
		return getAssignedBeforeWeekLastDay(date, 0);
	}

	/**
	 * 
	 * @Title: getSameWeekLastDay_chinese
	 * @Description:��ȡָ�����ڻ�ȡ����ͬһ���е����һ��(������Ϊ���һ��)
	 * @param date
	 * @return
	 */
	public static Date getSameWeekLastDay_chinese(Date date) {
		return getAssignedBeforeWeekLastDay_chinese(date, 0);
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekLastDay
	 * @Description:��ȡָ������ָ������֮ǰ����assignedָ�����������(������Ϊ���һ��)
	 * @param date
	 * @param assigned
	 * @return
	 */
	public static Date getAssignedBeforeWeekLastDay(Date date, int assigned) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, 7);
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - assigned * 7);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getAssignedBeforeWeekLastDay_chinese
	 * @Description:��ȡָ������ָ������֮ǰ����assignedָ�����������(������Ϊ���һ��)
	 * @param date
	 * @param assigned
	 * @return
	 */
	public static Date getAssignedBeforeWeekLastDay_chinese(Date date, int assigned) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, 1);
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - (assigned - 1) * 7);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getSameMonthFirstDay
	 * @Description:��ȡָ�����ڵ��µ�һ��
	 * @param date
	 * @return
	 */
	public static Date getSameMonthFirstDay(Date date) {
		return getAssignedBeforeMonthFirstDay(date, 0);
	}

	/**
	 * 
	 * @Title: getSameMonthLastDay
	 * @Description:��ȡָ�����ڵ������һ��
	 * @param date
	 * @return
	 */
	public static Date getSameMonthLastDay(Date date) {
		return getAssignedBeforeMonthLaseDay(date, 0);
	}

	/**
	 * 
	 * @Title: getAssignedBeforeMonthFirstDay
	 * @Description:��ȡָ������ָ��֮ǰ�£���assignedָ�����ĵ�һ��
	 * @param date
	 * @param assigned
	 * @return
	 */
	public static Date getAssignedBeforeMonthFirstDay(Date date, int assigned) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) - assigned);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getAssignedBeforeMonthLaseDay
	 * @Description:��ȡָ������ָ��֮ǰ�£���assignedָ���������һ��
	 * @param date
	 * @param assigned
	 * @return
	 */
	public static Date getAssignedBeforeMonthLaseDay(Date date, int assigned) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1 - assigned);
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - 1);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getDateAfterMinute
	 * @Description:��ȡ�����Ӻ��ʱ��
	 * @param minute
	 * @return
	 */
	public static Date getDateAfterMinute(int minute) {
		long currentTime = System.currentTimeMillis() + minute * 60 * 1000;
		return new Date(currentTime);
	}

}
