package com.crm.utils;

import org.apache.commons.lang3.StringUtils;


/**
 * import org.apache.commons.lang3.ArrayUtils; 数组处理类
 */
public class StringUtil {

    /*public static boolean isEmpty(String parameter){
        if (parameter.equals(null) || "".equals(parameter.trim())) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String parameter){
        if (!parameter.equals(null) &&! "".equals(parameter.trim())) {
            return true;
        }
        return false;
    }*/
    private StringUtil(){}

    /*
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /*
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }


}
