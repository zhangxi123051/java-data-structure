package com.tencent.springaop.util;

/**
 * @author Jet
 */
public class StringUtils {
    public static boolean isNotBlank(String str){
        if(str != null && str.trim().length() > 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isBlank(String str){
        return !isNotBlank(str);
    }
}
