/* @(#)
 *
 * Project:Clear
 *
 * Modify Information:
 * =============================================================================
 *   Author         Date           Description
 *   ------------ ---------- ---------------------------------------------------
 *   lihj           2015        机构结算 first release
 *
 *
 * Copyright Notice:
 * =============================================================================
 *       Copyright 2015 Quantdo.com.cn All rights reserved.
 *
 *
 * Warning:
 * =============================================================================
 *
 */
package com.sh.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.PatternSyntaxException;


/**
 * 日期处理工具类
 *<br>

 */
public class DateUtils {  
    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(  
            "yyyyMMdd HH:mm:ss");  
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(  
            "yyyyMMdd");  
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat(  
            "HH:mm:ss");  
    
    private static final SimpleDateFormat timeFormatHM = new SimpleDateFormat(  
            "HH:mm");
    
    public static final String date_fm_zh_long = "yyyyMMdd";
    public static final String date_fm_en_long ="dd/MM/yy";
    
    public static final String date_fm_zh_short = "yyMM";
    public static final String date_fm_en_short ="MMMyy";

    private static final Log logger = LogFactory.getLog(DateUtils.class);
  
    /** 
     * 获得当前日期时间 
     * <p> 
     * 日期时间格式yyyyMMdd HH:mm:ss 
     *  
     * @return 
     */  
    public static String currentDatetime() {  
        return datetimeFormat.format(now());  
    }  
  
    /** 
     * 格式化日期时间 
     * <p> 
     * 日期时间格式yyyyMMdd HH:mm:ss 
     *  
     * @return 
     */  
    public static String formatDatetime(Date date) {  
        return datetimeFormat.format(date);  
    }  
  
    /** 
     * 格式化日期时间 
     *  
     * @param date 
     * @param pattern 
     *            格式化模式，详见{@link SimpleDateFormat}构造器 
     *            <code>SimpleDateFormat(String pattern)</code> 
     * @return 
     */  
    public static String formatDatetime(Date date, String pattern) {  
        SimpleDateFormat customFormat = (SimpleDateFormat) datetimeFormat  
                .clone();  
        customFormat.applyPattern(pattern);  
        return customFormat.format(date);  
    }  
  
    /** 
     * 获得当前日期 
     * <p> 
     * 日期格式yyyyMMdd 
     *  
     * @return 
     */  
    public static String currentDate() {  
        return dateFormat.format(now());  
    }  
  
    /** 
     * 格式化日期 
     * <p> 
     * 日期格式yyyyMMdd 
     *  
     * @return 
     */  
    public static String formatDate(Date date) {  
        return dateFormat.format(date);  
    }  
  
    /** 
     * 获得当前时间 
     * <p> 
     * 时间格式HH:mm:ss 
     *  
     * @return 
     */  
    public static String currentTime() {  
        return timeFormat.format(now());  
    }  
  
    /** 
     * 获得当前时间 
     * <p> 
     * 时间格式HH:mm
     *  
     * @return 
     */  
    public static String currentTimeHm() {  
        return timeFormatHM.format(now());  
    }
    
    /** 
     * 格式化时间 
     * <p> 
     * 时间格式HH:mm:ss 
     *  
     * @return 
     */  
    public static String formatTime(Date date) {  
        return timeFormat.format(date);  
    }  
  
    /** 
     * 获得当前时间的<code>java.util.Date</code>对象 
     *  
     * @return 
     */  
    public static Date now() {  
        return new Date();  
    }  
  
    public static Calendar calendar() {  
        Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);  
        cal.setFirstDayOfWeek(Calendar.MONDAY);  
        return cal;  
    }  
  
    /** 
     * 获得当前时间的毫秒数 
     * <p> 
     * 详见{@link System#currentTimeMillis()} 
     *  
     * @return 
     */  
    public static long millis() {  
        return System.currentTimeMillis();  
    }  
  
    /** 
     *  
     * 获得当前Chinese月份 
     *  
     * @return 
     */  
    public static int month() {  
        return calendar().get(Calendar.MONTH) + 1;  
    }  
  
    /** 
     * 获得月份中的第几天 
     *  
     * @return 
     */  
    public static int dayOfMonth() {  
        return calendar().get(Calendar.DAY_OF_MONTH);  
    }  
  
    /** 
     * 今天是星期的第几天 
     *  
     * @return 
     */  
    public static int dayOfWeek() {  
        return calendar().get(Calendar.DAY_OF_WEEK);  
    }  
  
    /** 
     * 今天是年中的第几天 
     *  
     * @return 
     */  
    public static int dayOfYear() {  
        return calendar().get(Calendar.DAY_OF_YEAR);  
    }  
  
    /** 
     *判断原日期是否在目标日期之前 
     *  
     * @param src 
     * @param dst 
     * @return 
     */  
    public static boolean isBefore(Date src, Date dst) {  
        return src.before(dst);  
    }  
  
    /** 
     *判断原日期是否在目标日期之后 
     *  
     * @param src 
     * @param dst 
     * @return 
     */  
    public static boolean isAfter(Date src, Date dst) {  
        return src.after(dst);  
    }  
  
    /** 
     *判断两日期是否相同 
     *  
     * @param date1 
     * @param date2 
     * @return 
     */  
    public static boolean isEqual(Date date1, Date date2) {  
        return date1.compareTo(date2) == 0;  
    }  
  
    /** 
     * 判断某个日期是否在某个日期范围 
     *  
     * @param beginDate 
     *            日期范围开始 
     * @param endDate 
     *            日期范围结束 
     * @param src 
     *            需要判断的日期 
     * @return 
     */  
    public static boolean between(Date beginDate, Date endDate, Date src) {  
        return beginDate.before(src) && endDate.after(src);  
    }  
  
    /** 
     * 获得当前月的最后一天 
     * <p> 
     * HH:mm:ss为0，毫秒为999 
     *  
     * @return 
     */  
    public static Date lastDayOfMonth() {  
        Calendar cal = calendar();  
        cal.set(Calendar.DAY_OF_MONTH, 0); // M月置零  
        cal.set(Calendar.HOUR_OF_DAY, 0);// H置零  
        cal.set(Calendar.MINUTE, 0);// m置零  
        cal.set(Calendar.SECOND, 0);// s置零  
        cal.set(Calendar.MILLISECOND, 0);// S置零  
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);// 月份+1  
        cal.set(Calendar.MILLISECOND, -1);// 毫秒-1  
        return cal.getTime();  
    }  
  
    /** 
     * 获得当前月的第一天 
     * <p> 
     * HH:mm:ss SS为零 
     *  
     * @return 
     */  
    public static Date firstDayOfMonth() {  
        Calendar cal = calendar();  
        cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1  
        cal.set(Calendar.HOUR_OF_DAY, 0);// H置零  
        cal.set(Calendar.MINUTE, 0);// m置零  
        cal.set(Calendar.SECOND, 0);// s置零  
        cal.set(Calendar.MILLISECOND, 0);// S置零  
        return cal.getTime();  
    }  
  
    private static Date weekDay(int week) {  
        Calendar cal = calendar();  
        cal.set(Calendar.DAY_OF_WEEK, week);  
        return cal.getTime();  
    }  
  
    /** 
     * 获得周五日期 
     * <p> 
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday 
     *  
     * @return 
     */  
    public static Date friday() {  
        return weekDay(Calendar.FRIDAY);  
    }  
  
    /** 
     * 获得周六日期 
     * <p> 
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday 
     *  
     * @return 
     */  
    public static Date saturday() {  
        return weekDay(Calendar.SATURDAY);  
    }  
  
    /** 
     * 获得周日日期 
     * <p> 
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday 
     *  
     * @return 
     */  
    public static Date sunday() {  
        return weekDay(Calendar.SUNDAY);  
    }  
  
    /** 
     * 将字符串日期时间转换成java.util.Date类型 
     * <p> 
     * 日期时间格式yyyyMMdd HH:mm:ss 
     *  
     * @param datetime 
     * @return 
     */  
    public static Date parseDatetime(String datetime) throws ParseException {  
        return datetimeFormat.parse(datetime);  
    }  
  
    /** 
     * 将字符串日期转换成java.util.Date类型 
     *<p> 
     * 日期时间格式yyyyMMdd 
     *  
     * @param date 
     * @return 
     * @throws ParseException 
     */  
    public static Date parseDate(String date) throws ParseException {  
        return dateFormat.parse(date);  
    }  
  
    /** 
     * 将字符串日期转换成java.util.Date类型 
     *<p> 
     * 时间格式 HH:mm:ss 
     *  
     * @param time 
     * @return 
     * @throws ParseException 
     */  
    public static Date parseTime(String time) throws ParseException {  
        return timeFormat.parse(time);  
    }  
  
    /** 
     * 根据自定义pattern将字符串日期转换成java.util.Date类型 
     *  
     * @param datetime 
     * @param pattern 
     * @return 
     * @throws ParseException 
     */  
    public static Date parseDatetime(String datetime, String pattern)  
            throws ParseException {  
        SimpleDateFormat format = (SimpleDateFormat) datetimeFormat.clone();  
        format.applyPattern(pattern);  
        return format.parse(datetime);  
    } 
    
    /**
     * 
     * 英文日期转换为中文日期
     * @return
     * @throws
     * @since
     */
	public static String parseEnDateToCH(String date, String sourceFormat, String descFormat) {
		SimpleDateFormat sdf_ch = new SimpleDateFormat(descFormat);
		SimpleDateFormat sdf_en = new SimpleDateFormat(sourceFormat, Locale.ENGLISH);
		String dateCH = "";
		try {
			dateCH = sdf_ch.format(sdf_en.parse(date));
		} catch (ParseException e) {
			logger.error(e);
		}
		return dateCH;
	}
	
	// 取系统时间
	public static String getsysid() throws PatternSyntaxException {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd-HH-mm-ss-SSS");
		Date currentTime = new Date();
		String str_date = formatter.format(currentTime);
		StringTokenizer token = new StringTokenizer(str_date, "-");
		String year = token.nextToken();
		String month = token.nextToken();
		String day = token.nextToken();
		String hh = token.nextToken();
		String mm = token.nextToken();
		String ss = token.nextToken();
		String sss = token.nextToken();
		String date = year +"-"+ month +"-"+ day;
		String time = date+" "+hh+":"+ mm +":"+ ss +":"+ sss;
		return time;
	}

	//获取上月最后一天
	public static String getLastMonthDay() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date strDateTo = calendar.getTime();
		return dateFormat.format(strDateTo);
	}

	//获取上周末最后一天
	public static String  getDayByLastWeek() {
		Calendar cal =Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		Date strDateTo = cal.getTime();
		return dateFormat.format(strDateTo);
	}

	//获取两个日期的间隔天数
	public static long getDayByBetweenDay(String begindate,String enddate){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date beginDate = null;
		try {
			beginDate = format.parse(begindate);
		} catch (Exception e) {
		}
		Date endDate = null;
		try {
			endDate = format.parse(enddate);
		} catch (Exception e) {
		}
		if(beginDate == null || endDate == null){
		    return 0;
        }
		long day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);    
		return day;
	}


    /**
     * 获取指定年月的第一天
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH,firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(cal.getTime());
    }
    /**
     * 获取指定年月的最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(cal.getTime());
    }


	public static void main(String args[]){
        System.out.println(getFirstDayOfMonth(2020,10).substring(4,8));
        System.out.println(getLastDayOfMonth(2020,10));

    }
}  
