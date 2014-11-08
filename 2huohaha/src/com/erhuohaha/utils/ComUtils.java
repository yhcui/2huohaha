package com.erhuohaha.utils;

/**
 * @author yuhuicui E-mail:yuhuicui@xyh.com
 * @version 创建时间：Nov 29, 2013 9:35:36 PM 类说明
 */
public class ComUtils {
	
	private ComUtils(){
		
	}
	
	public static boolean isNumeric(Object num) {
		if ((num == null) || (num.toString().length() <= 0)) {
			return false;
		}
		String str = num.toString();
		if (str.length() <= 0) {
			return false;
		}
		if (str.matches("\\d{1,}")) {
			return true;
		}
		if (str.matches("^((-\\d+)|(0+))$")) {
			return true;
		}

		return (str.matches("^[0-9]+(.[0-9]{1,3})?$"));
	}
}
