package com.erhuohaha.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final  class DateUtils {
	
	public static final String FORMAT_YYYYMMDD ="yyyyMMdd";
	
	private DateUtils(){
		
	}
	
	public static String getTomorrowForStringByFormat(String format){
		DateFormat df = new SimpleDateFormat(format);
		return df.format(getTomorrowForDate());
	}
	
	/**
	 * 获取当前日期
	 * @param format
	 * @return
	 */
	public static String getTodayForStringByFormat(String format){
		DateFormat df = new SimpleDateFormat(format);
		return df.format(getTodayForDate());
	}
	
	public static String getYesterdayForStringByFormat(String format){
		DateFormat df = new SimpleDateFormat(format);
		return df.format(getYesterdayForDate());
	}
		
	
	
	public static Date getTomorrowForDate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	} 
	
	public static Date getTodayForDate(){
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	public static Date getYesterdayForDate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	} 
}
