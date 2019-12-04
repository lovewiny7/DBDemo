package com.global.winy7.DateUtilForMe;

/**
 * <pre>
 *     desc   : 我的日期处理工具
 *     author : winy7
 *     time   : 2019/10/23
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class DateUitlForMe {
    
    /**
     * 获取两个时间之差
     *
     * @param date1 时间1
     * @param date2 时间2
     * @return 时间差 long
     */
    public static long getDate1SubDate2(Long date1, Long date2) {
        return date1 - date2;
    }
    
    /**
     * 获取与当前时间之差  （几分钟）
     * @param date 目标时间
     * @param minute 分钟差
     * @return true /false
     */
    public static boolean getTimeDifferenceMinute(Long date, int minute) {
        
        return ((System.currentTimeMillis() - date) > minute * 1000 * 60);
    }
}
