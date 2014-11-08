package com.erhuohaha.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtils {
	
	private static final List<String> OBJECT_METHOD_LIST =new ArrayList<String>();
	
	static{
		OBJECT_METHOD_LIST.add("clone");
		OBJECT_METHOD_LIST.add("equals");
		OBJECT_METHOD_LIST.add("finalize");
		OBJECT_METHOD_LIST.add("getClass");
		OBJECT_METHOD_LIST.add("hashCode");
		OBJECT_METHOD_LIST.add("notify");
		OBJECT_METHOD_LIST.add("notifyAll");
		OBJECT_METHOD_LIST.add("toString");
		OBJECT_METHOD_LIST.add("wait");
	}
	
	private ReflectUtils(){
		
	}
	
	
	
	public static String getClassGetMethodForString(Object obj){
		Class clazz = obj.getClass();
		Method[] methods = clazz.getMethods();
		StringBuffer sb = new StringBuffer(50);
		try {
			for(Method method:methods){
				Class returnType = method.getReturnType();
				String methodName = method.getName();
				if(OBJECT_METHOD_LIST.contains(methodName)){
					continue;
				}
				if(!returnType.toString().equals("void")){
					Object returnObj = method.invoke(obj, null);
					sb.append(returnObj);
					sb.append(",");
				}
//				if(returnType !=null){
//					Object returnObj = method.invoke(obj, null);
//					sb.append(returnObj);
//				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
}
