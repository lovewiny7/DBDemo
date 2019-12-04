package com.global.util;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Created By Caoqi on 2019/5/20  下午4:23
 */
public class DateUtilForCQ {
    
    private static String pTime;
    
    /**
     * 计算时间差
     * @param endTime 结束时间
     * @return
     */
    public static String getSubTime(String endTime) {
        long endTimeLong = 0;
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTimeInMillis();
        
        try {
            endTimeLong = DateUtils.stringToLong2(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long subTime = endTimeLong - time;
        if (subTime != 0) {
            long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
            long nh = 1000 * 60 * 60;// 一小时的毫秒数
            long nm = 1000 * 60;// 一分钟的毫秒数
            long ns = 1000;// 一秒钟的毫秒数
            long subDay = subTime / nd;
            long subHour = subTime % nd / nh;
            long subMinute = subTime % nd % nh / nm;
            long subSecond = subTime % nd % nh % nm / ns;
            pTime = subDay * 24 + subHour + ":" + subMinute + ":" + subSecond ;
        }
        return pTime;
    }
    
    /**
     * 计算时间差
     * @param endTime 结束时间
     * @return
     */
    public static String getSubTime(long endTime) {
        
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTimeInMillis();
        
        long subTime = endTime - time;
        if (subTime > 0) {
            long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
            long nh = 1000 * 60 * 60;// 一小时的毫秒数
            long nm = 1000 * 60;// 一分钟的毫秒数
            long ns = 1000;// 一秒钟的毫秒数
            long subDay = subTime / nd;
            long subHour = subTime % nd / nh;
            long subMinute = subTime % nd % nh / nm;
            long subSecond = subTime % nd % nh % nm / ns;
            pTime = subDay * 24 + subHour + ":" + subMinute + ":" + subSecond;
        }
        return pTime;
    }
    
    /*
    * 获取long 类型的当前时间
    * */
    public static long getTimeInMillis() {
        
        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTimeInMillis();
        
        
        return time;
    }
    
//    public static long getTimeInMillis() {
//
//        Calendar calendar = Calendar.getInstance();
//        long time = calendar.getTimeInMillis();
//
//
//        return time;
//    }
}
