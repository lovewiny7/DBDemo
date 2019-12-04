package com.global.util;

/**
 * 隐藏电话号码中的4位
 * Created by Laughing on 2017/3/10.
 */
public class HideNumber {
    //隐藏电话中间的4个号码
    public static String hideFourNumberInPhone(String str) {
        if (str.length() != 11) {
            return "";
        }
        String strOk = str.substring(0, 3) + "****" + str.substring(7);
        return strOk;
    }

}
