package com.erhuohaha.utils;

public class StringUtils {
	
	private StringUtils(){
		
	}

	public static boolean isNotNull(String content){
		return content !=null && content.trim().length() >0;
	}
}
