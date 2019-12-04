package com.global.winy7.NumUtil;

import com.waterbase.utile.LogUtil;

import java.text.DecimalFormat;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/06/28
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class NumberUtil {
    
    
    public static String toSmallStyle(int num) {
        
        if (num >= 10000) {
            double i = (double) num / 10000;
            DecimalFormat df = new DecimalFormat("#.0");
            String format = df.format(i);
            if (format.endsWith(".0")) {
                String s = format.replace(".0", "");
                return s + "万";
            }
            
            return format + "万";
        } else {
            return num + "";
        }
    }
    
    
    public static String delete0(float number) {
        String num;
        if (number == 0.0) return "0";
        DecimalFormat df = new DecimalFormat("#.00");
        num = df.format(number);
        if (num.indexOf(".") > 0) {
            num = num.replaceAll("0+?$", "");//去掉后面无用的零
            num = num.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
        }
        return num;
    }
    
    public static String FloathideInvalidBit(float number) {
        String num;
        if (number == 0.0) return "0";
        DecimalFormat df = new DecimalFormat("#.00");
        num = df.format(number);
        if (num.indexOf(".") > 0) {
            num = num.replaceAll("0+?$", "");//去掉后面无用的零
            num = num.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
        }
        return num;
    }
}