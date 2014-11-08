package com.erhuohaha.comparator;

import java.util.Comparator;

import com.erhuohaha.utils.PinyinUtils;

/**
 * @author yuhuicui E-mail:yuhuicui@xyh.com
 * @version 创建时间：Dec 19, 2013 9:03:11 PM
 * 类说明
 * 中文排序器
 */
public class ChineseComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String pinyin1 = PinyinUtils.stringToPingYinWithTone((String)o1);
		String pinyin2 = PinyinUtils.stringToPingYinWithTone((String)o2);
		return pinyin1.compareTo(pinyin2);
	}
}
