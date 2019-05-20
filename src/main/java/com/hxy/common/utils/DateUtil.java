package com.hxy.common.utils;
/**
 * 日期工具类
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/*
	* 方法1：(5分)
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	public static String getDateByInitMonth(Date src) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar c = getCalendar(src);
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date cdate = c.getTime();
		return sdf.format(cdate);
	}
	/*
	* 方法2：(5分)
	* 给一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	public static String getDateByFullMonth(Date src) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar c = getCalendar(src);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 0);
		Date cdate = c.getTime();
		return sdf.format(cdate);
	}
	//时间格式工具
	private static Calendar getCalendar(Date date) throws ParseException {
		Calendar c = Calendar.getInstance();
		if(date != null) {
			c.setTime(date);
		}
		System.out.println(c.toString());
		return c;
	}
}
