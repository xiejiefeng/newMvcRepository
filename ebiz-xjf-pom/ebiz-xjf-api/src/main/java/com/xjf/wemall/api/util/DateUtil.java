/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: DateUtil.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午3:25:37
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 日期类<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateUtil {
    /**日志类*/
    private static final Logger logger= LoggerFactory.getLogger(DateUtil.class);
    /**日期格式化集合*/
    protected static Map<String, DateFormat> dateFormatMap = new HashMap<String, DateFormat>();
    /** FORMAT_DATE_DEFAULT:YYYY-MM-DD eg: 2013-01-11 */
    public static final String FORMAT_DATE_DEFAULT = "yyyy-MM-dd";
    /** FORMAT_DATE_YYYYMMDD:yyyyMMdd eg:20130111 */
    public static final String FORMAT_DATE_YYYYMMDD = "yyyyMMdd";
    /** FORMAT_DATE_YYYY_MM_DD:yyyy-MM-dd */
    public static final String FORMAT_DATE_YYYY_MM_DD = "yyyy-MM-dd";
    /** FORMAT_DATE_SLASH_YYYY_MM_DD:yyyy/MM/dd */
    public static final String FORMAT_DATE_SLASH_YYYY_MM_DD = "yyyy/MM/dd";
    /** FORMAT_DATE_SLASH_YYYY_M_DD:yyyy/M/dd */
    public static final String FORMAT_DATE_SLASH_YYYY_M_DD = "yyyy/M/dd";
    /** FORMAT_DATETIME_DEFAULT:yyyy-MM-dd HH:mm:ss */
    public static final String FORMAT_DATETIME_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    /** FORMAT_DATETIME_DEFAULT:yyyy-MM-dd HH:mm:ss */
    public static final String FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS = FORMAT_DATETIME_DEFAULT;
    /** FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS_SSS:yyyy-MM-dd HH:mm:ss.SSS */
    public static final String FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    /**FORMAT_DATETIME_YYYY_MM_DD_HHMM:yyyy-MM-dd HHmm*/
    public static final String FORMAT_DATETIME_YYYY_MM_DD_HHMM = "yyyy-MM-dd HHmm";
    /**FORMAT_DATETIME_YYYY_MM_DD_HH_MM:yyyy-MM-dd HH:mm*/
    public static final String FORMAT_DATETIME_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    /**FORMAT_DATETIME_YYYY_MM_DD_HHMMSS:yyyy-MM-dd HHmmss*/
    /**FORMAT_DATETIME_YYYYMMDDHHMMSS:yyyyMMddHHmmss*/
    public static final String FORMAT_DATETIME_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /**FORMAT_DATETIME_YYYYMMDDHHMMSSSSS:yyyyMMddHHmmssSSS*/
    public static final String FORMAT_DATETIME_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    /**FORMAT_TIME_DEFAULT:HH:mm:ss*/
    public static final String FORMAT_TIME_DEFAULT = "HH:mm:ss";
    /**FORMAT_TIME_HH_MM:HH:mm*/
    public static final String FORMAT_TIME_HH_MM = "HH:mm";
    /** FORMAT_TIME_HH_MM_SS:HHmm */
    public static final String FORMAT_TIME_HHMM = "HHmm";
    /** FORMAT_TIME_HH_MM_SS:HH:mm:ss */
    public static final String FORMAT_TIME_HH_MM_SS = "HH:mm:ss";
    /** FORMAT_TIME_HHMMSS:HHmmss */
    public static final String FORMAT_TIME_HHMMSS = "HHmmss";
    /** FORMAT_TIME_EEEE */
    public static final String FORMAT_TIME_EEEE = "MM月dd日 EEEE";
    /** FORMAT_DATE_YYYYMM:yyyyMM eg:201301 */
    public static final String FORMAT_DATE_YYYYMM = "yyyyMM";
    /** FORMAT_TIME_MMDD */
    public static final String FORMAT_TIME_MMDD = "MM月dd日";
    
    /**
     * 
     * @param formatPattern
     * @return
     */
    protected static DateFormat getCachedDateFormat(String formatPattern) {
        DateFormat dateFormat =dateFormatMap.get(formatPattern);
        if (dateFormat == null) {
                dateFormat=DateUtil.getDateFormat(formatPattern);
                dateFormatMap.put(formatPattern, DateUtil.getDateFormat(formatPattern));
        }
        return dateFormat;
    }

    /**
     * 
     * @param date
     * @param formatPattern
     * @return
     */
    public static String formatDate(Date date, String formatPattern) {
         
       logger.debug("date:"+date.toString()+"  formatPattern:"+formatPattern);
        return  getCachedDateFormat(formatPattern).format(date);
    }
    
    public static Date parse(String dateStr,String formatPattern){
        if (dateStr == null) {
            return null;
        }
        try {
           return  getCachedDateFormat(formatPattern).parse(dateStr);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /***
     * 
     * @param formatPattern
     * @return DateFormat
     */
    public static DateFormat getDateFormat(String formatPattern) {
        return new SimpleDateFormat(formatPattern, Locale.CHINA);
    }

    /***
     * 转换日期格式<br>
     * （MM月dd日 星期？）
     * 
     * @param formatPattern
     * @return DateFormat
     */
    public static String date2week(String date) {
        Date d = parse(date, FORMAT_DATE_DEFAULT);
        DateFormat format = getDateFormat(FORMAT_TIME_EEEE);
        return format.format(d);
    }
    
    /**
     * 转换上下午文字<br>
     * 1：上午 2：下午 3：晚上
     * 
     * @param timeFlag
     * @return
     */
    public static String parseTimeFlag(String timeFlag) {
    	if (StringUtils.isEmpty(timeFlag)) {
    		return "";
    	}
    	
        switch (timeFlag) {
        case "1":
        	return "上午";
        case "2":
        	return "下午";
        case "3":
        	return "晚上";
    	default:
    		return "";
        }
    }
    
    /**
     * 获取当前系统日期
     *
     * @return Date 当前系统日期
     */
    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 获取当前年份
     *
     * @return int 当前年份
     */
    public static int getCurrentYear() {
    	Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }
    
    /**
     * 根据指定时间转换当前日时
     *
     * @return Date 当前日期指定时间
     */
    public static Date parseCurrentDateTime(String time) {
    	
    	String currentDate = formatDate(getCurrentDate(), FORMAT_DATE_DEFAULT);
    	String dt = currentDate + " " + time;
        return parse(dt, FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS);
    }
    
    /**
     * 计算时间
     * @param date    日期
     * @param field   类型 如按秒计算为： Calendar.SECOND
     * @param amount  计算量
     * @return
     * @throws Exception
     * 例子：计算当前时间的前10秒的时间？
     * TimeCalculate(new Date(), Calendar.SECOND, -10)
     * 例子：计算当前时间的后10秒的时间？
     * TimeCalculate(new Date(), Calendar.SECOND, 10)
     */
    public static Date timeCalculate(Date date, int field, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, amount);
        return cal.getTime();
    }
    
    /**
     * 
     * 功能描述: 获取当前日时(YYYYMMDDHHMMSS)<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getCurrentDateTime() {
        return formatDate(getCurrentDate(), FORMAT_DATETIME_YYYYMMDDHHMMSS);
    }
    
    /**
     * 
     * 功能描述: 获取当前日时(YYYYMMDDHHMMSS)<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public String getCurrentDateTimeNow() {
        return formatDate(getCurrentDate(), FORMAT_DATETIME_YYYYMMDDHHMMSS);
    }
    
    private static String getCurrentDateTimePrivate() {
        return formatDate(getCurrentDate(), FORMAT_DATETIME_YYYYMMDDHHMMSS);
    }
}
