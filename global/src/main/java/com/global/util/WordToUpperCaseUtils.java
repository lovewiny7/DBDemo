package com.global.util;

import com.waterbase.utile.StrUtil;

/**
 * 本工具类的作用是把车牌里的小写字母转为大写字母
 * 作者：Laughing on 2019-3-12 16:36
 * 邮箱：719240226@qq.com
 */
public class WordToUpperCaseUtils {
    private static String strString = "abcdefghigklmnopqrstuvwxyz";
    private static String strString2 = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
    private static String strString3 = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
    private static String strString4 = "京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新港澳台";
    private static String strString5 = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ京津冀晋蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新港澳台1234567890";
    
    /**
     * @param string 车牌号(例如：陕A5fd764)
     * @param type   类型 0: 代表中间有点（例如：陕A·5FD764） 1 或者其他 int 值:中间没有点（例如：陕A5fd76a）
     * @return
     */
    public static String getUpperWord(String string, int type) {
        if (string.length() < 7 || string.contains(" ")) {
            return "车牌号解析异常";
        } else {
            
            
            StringBuffer str = new StringBuffer();
            
            String a1 = String.valueOf(string.charAt(0));
            String a2 = String.valueOf(string.charAt(1));
            String a3 = String.valueOf(string.charAt(2));
            String a4 = String.valueOf(string.charAt(3));
            String a5 = String.valueOf(string.charAt(4));
            String a6 = String.valueOf(string.charAt(5));
            String a7 = String.valueOf(string.charAt(6));
            String a8 = "";
            if (string.length() >= 8) {
                a8 = String.valueOf(string.charAt(7));
                if (strString.contains(a8)) {
                    a8 = a8.toUpperCase();
                }
            }
            
            
            if (strString.contains(a1)) {
                a1 = a1.toUpperCase();
            }
            if (strString.contains(a2)) {
                a2 = a2.toUpperCase();
            }
            
            if (strString.contains(a3)) {
                a3 = a3.toUpperCase();
            }
            if (strString.contains(a4)) {
                a4 = a4.toUpperCase();
            }
            if (strString.contains(a5)) {
                a5 = a5.toUpperCase();
            }
            if (strString.contains(a6)) {
                a6 = a6.toUpperCase();
            }
            if (strString.contains(a7)) {
                a7 = a7.toUpperCase();
            }
            
            if (type == 0) {
                return a1 + a2 + "·" + a3 + a4 + a5 + a6 + a7 + a8;
                
            } else {
                return a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8;
            }
        }
        
    }
    
    
    /**
     * 发送网络请求之前 校验车牌号
     *
     * @param string 车牌号(例如：陕A5fd764)
     * @return
     */
    public static String checkPlateNumber(String string) {
        if (StrUtil.isEmpty(string)) {
            return "车牌号不能为空";
        } else if (string.length() < 9) {
            return "right";
        } else {
            return "请检查车牌号";
        }
        
    }
    
    /**
     * 发送网络请求之前 校验车牌号
     *
     * @param string 车牌号(例如：陕A5fd764)
     * @return
     */
    public static String checkPlateNumber2(String string) {
        if (StrUtil.isEmpty(string)) {
            return "车牌号不能为空";
        } else if (string.length() < 7) {
            return "车牌号不完整";
        } else if (string.length() == 7 || string.length() == 8) {
            
            boolean first = checkFirst(String.valueOf(string.charAt(0)));
            boolean second = checkSecond(String.valueOf(string.charAt(1)));
            if (first && second) {
                return "right";
            } else {
                return "请检查车牌号";
            }
        } else {
            return "请检查车牌号";
        }
        
    }
    
    private static boolean checkFirst(String a1) {
        if (strString4.contains(a1)) {
            return true;
        }
        return false;
    }
    
    private static boolean checkSecond(String a2) {
        if (strString3.contains(a2)) {
            return true;
        }
        return false;
    }
    
    
}
