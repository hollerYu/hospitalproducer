package com.jk.untils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


/**
 *  * 汉字拼音工具
 *  * @author czh
 *  *
 *  
 */
public class PinyinSortUtil {

    /**
     * 将传入的list，按汉字首字母排序，汉字串会转换成首字母串
     * 如果有英文直接是英文，有符号会自动忽略
     *
     * @param list     集合list
     * @param sortName 需要排序的属性名称
     * @return
     */
    public static <T> List<T> sortListByFstSpell(List<T> list, String sortName) {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T t1, T t2) {
                try {
                    Field field1 = t1.getClass().getDeclaredField(sortName);
                    field1.setAccessible(true);
                    Field field2 = t2.getClass().getDeclaredField(sortName);
                    field2.setAccessible(true);
                    String s1 = PinyinSortUtil.getFirstSpell((String) field1.get(t1));
                    String s2 = PinyinSortUtil.getFirstSpell((String) field2.get(t2));
                    if (s1.compareTo(s2) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });// new Comparator() 根据需求定义排序 ;
        return list;
    }

    /**
     * 获取汉字串拼音首字母，英文字符不变  
     *
     * @param chinese
     * @return
     */
    public static String getFirstSpell(String chinese) {
        StringBuffer pybf = new StringBuffer();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(
                            arr[i], defaultFormat);
                    if (temp != null) {
                        pybf.append(temp[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pybf.append(arr[i]);
            }
        }
        return pybf.toString().replaceAll("\\W", "").trim();
    }

    /**
     * 将汉字转换成拼音
     *
     * @param hanzi
     * @param separator
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String hanziToPinyin(String hanzi, String separator) {
// 创建汉语拼音处理类
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
// 输出设置，大小写，音标方式
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        String pinyingStr = "";
        try {
            pinyingStr = PinyinHelper.toHanyuPinyinString(hanzi, defaultFormat, separator);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return pinyingStr;
    }

}