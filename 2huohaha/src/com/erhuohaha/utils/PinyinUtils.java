package com.erhuohaha.utils;

import java.util.ArrayList;
import java.util.List;

import com.erhuohaha.comparator.ChineseComparator;

import edu.emory.mathcs.backport.java.util.Collections;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

/**
 * @author yuhuicui E-mail:yuhuicui@xyh.com
 * @version 创建时间：Dec 19, 2013 8:54:08 PM
 * 类说明
 */
public class PinyinUtils {

	private PinyinUtils(){
		
	}
	
	public static String stringToPingYinWithTone(String content){
		if(content == null || content.trim().length()<1){
			return null;
		}
		char[] chars = content.toCharArray();
		StringBuffer pinyinsb = new StringBuffer(50);
		for(char c:chars){
			String pinyin = charToPinyin(c);
			if(pinyin==null){
				pinyinsb.append(c);
			}else{
				pinyinsb.append(pinyin);
			}
		}
		return pinyinsb.toString();
	}
	
	public static  String charToPinyin(char c){
		HanyuPinyinOutputFormat format= new HanyuPinyinOutputFormat();
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		try {
			String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c, format);
			if(pinyins == null || pinyins.length<1){
				return null;
			}else{
				return pinyins[0];//多音字不做处理
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("张明勇");
		list.add("不好");
		list.add("你好");
		Collections.sort(list,new ChineseComparator());
		for(String aa:list){
			System.out.println(aa);
		}
	}
	
	
	
}
