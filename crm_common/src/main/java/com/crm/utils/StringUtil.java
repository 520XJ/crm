package com.crm.utils;

public class StringUtil {

    public static boolean isEmpty(String parameter){
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
    }

}
