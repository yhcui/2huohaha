package com.erhuohaha.utils;

import org.apache.log4j.Logger;

import bsh.This;

public class LoggerUtil {

	private static final  Logger log = Logger.getLogger(LoggerUtil.class);
	
	private LoggerUtil(){
		
	}
	
	public static void debug(String messagg){
		log.debug(messagg);
	}
	
}
