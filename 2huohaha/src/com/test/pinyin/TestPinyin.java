package com.test.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author yuhuicui E-mail:yuhuicui@xyh.com
 * @version 创建时间：Dec 19, 2013 8:46:38 PM
 * 类说明
 */
public class TestPinyin {

	public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
		
		HanyuPinyinOutputFormat format= new HanyuPinyinOutputFormat();

		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

//		format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
		
			String[] pinyinArray =PinyinHelper.toHanyuPinyinStringArray('单',format);

			for(int i = 0; i < pinyinArray.length; ++i){
				System.out.println(pinyinArray[i]);
			}
//			System.out.println(PinyinHelper.toHanyuPinyinString("你好", null, null));
	}
	
}
