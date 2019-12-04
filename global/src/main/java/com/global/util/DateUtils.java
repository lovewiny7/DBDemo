package com.global.util;


import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.waterbase.utile.DateUtil;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.StrUtil;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 作者：Laughing on 2016/12/26 0026.本工具类的作用是把时间格式化
 * 邮箱：719240226@qq.com
 */

public class DateUtils {


    /**
     * 时间日期格式化到年月日时分秒.
     */
    public static final String dateFormatYMDHMS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间日期格式化到年月日.
     */
    public static final String dateFormatYMD = "yyyy-MM-dd";
    
    public static final String dateFormatYMD1 = "yyyy年MM月dd日";
    /**
     * 时间日期格式化到年月.
     */
    public static final String dateFormatYM = "yyyy-MM";

    /**
     * 时间日期格式化到年月日时分.
     */
    public static final String dateFormatYMDHM = "yyyy-MM-dd HH:mm";

    /**
     * 时间日期格式化到月日.
     */
    public static final String dateFormatMD = "MM/dd";

    /**
     * 时分秒.
     */
    public static final String dateFormatHMS = "HH:mm:ss";

    /**
     * 时分.
     */
    public static final String dateFormatHM = "HH:mm";

    /**
     * 上午.
     */
    public static final String AM = "AM";

    /**
     * 下午.
     */
    public static final String PM = "PM";


    /**
     * 返回String类型的时间格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String transformDate2Str(Date date) {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return myFmt.format(date);
    }

    /**
     * 获取当前年(时间格式 yyyy)
     *
     * @return
     */
    public static int getCurrentYear() {
        Date dt = new Date();
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy");
        String year = myFmt.format(dt);
        if (StrUtil.isNumber(year)) {
            return Integer.parseInt(year);
        }
        return 0;
    }

    /**
     * 获取当前月(时间格式 MM)
     *
     * @return
     */
    public static int getCurrentMonth() {
        Date dt = new Date();
        SimpleDateFormat myFmt = new SimpleDateFormat("MM");
        String month = myFmt.format(dt);
        if (StrUtil.isNumber(month)) {
            return Integer.parseInt(month);
        }
        return 0;
    }

    /**
     * 获取当前日(时间格式 MM)
     *
     * @return
     */
    public static int getCurrentDay() {
        Date dt = new Date();
        SimpleDateFormat myFmt = new SimpleDateFormat("dd");
        String day = myFmt.format(dt);
        if (StrUtil.isNumber(day)) {
            return Integer.parseInt(day);
        }
        return 0;
    }

    /**
     * 获取当前小时(时间格式 HH)
     *
     * @return
     */
    public static int getCurrentHour() {
        Date dt = new Date();
        SimpleDateFormat myFmt = new SimpleDateFormat("HH");
        String hour = myFmt.format(dt);
        if (StrUtil.isNumber(hour)) {
            return Integer.parseInt(hour);
        }
        return 0;
    }

    /**
     * 获取当前分钟(时间格式 mm)
     *
     * @return
     */
    public static int getCurrentMinute() {
        Date dt = new Date();
        SimpleDateFormat myFmt = new SimpleDateFormat("mm");
        String minute = myFmt.format(dt);
        if (StrUtil.isNumber(minute)) {
            return Integer.parseInt(minute);
        }
        return 0;
    }

    /**
     * 获取当前秒(时间格式 ss)
     *
     * @return
     */
    public static int getCurrentSecond() {
        Date dt = new Date();
        SimpleDateFormat myFmt = new SimpleDateFormat("ss");
        String second = myFmt.format(dt);
        if (StrUtil.isNumber(second)) {
            return Integer.parseInt(second);
        }
        return 0;
    }


    /**
     * 获取时间格式 yyyy-MM-dd HH:mm:ss (24小时制)
     *
     * @return
     */
    public static String getCurrentFormatString() {
        Date dt = new Date();
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return myFmt.format(dt);
    }

    /**
     * 获取时间格式 月.日 时:分
     *
     * @return
     */

    public static String getCurrentDate() {
        Date dt = new Date();
        SimpleDateFormat myFmt = new SimpleDateFormat("MM.dd HH:mm");
        return myFmt.format(dt);
    }

    /**
     * 获取时间
     *
     * @return
     */
    public static String getCurrentFormatWithMill() {
        Date dt = new Date();
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        return myFmt.format(dt);
    }

    public static void getFormatTimeValueOfhhmm(String time) {
        String currentFormatString = getCurrentFormatString();
        int[] t = new int[]{};
    }

    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取时间 小时:分;秒 HH:mm:ss
     *
     * @return
     */
    public static String getTimeShort() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        return dateString;
    }


    public static long getLongTimeFormat(String strTime) {
        long time = -1;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            time = simpleDateFormat.parse(strTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }


    public static String getWeek(String sdate) {
        // 再转换为时间
        Date date = strToDateLong(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param sdate
     * @return
     */
    public static String getWeekStr(String sdate) {
        String str = "";
        str = getWeek(sdate);
        if ("1".equals(str)) {
            str = "星期日";
        } else if ("2".equals(str)) {
            str = "星期一";
        } else if ("3".equals(str)) {
            str = "星期二";
        } else if ("4".equals(str)) {
            str = "星期三";
        } else if ("5".equals(str)) {
            str = "星期四";
        } else if ("6".equals(str)) {
            str = "星期五";
        } else if ("7".equals(str)) {
            str = "星期六";
        }
        return str;
    }

    /**
     * 根据一个日期，返回是xx月xx日的字符串
     *
     * @param formatTime
     * @return
     */
    public static String getStringDateMonth(String formatTime) {
        String sreturn = "";
        if (formatTime != null) {
            String s_nd = formatTime.substring(0, 4); // 年份
            String s_yf = formatTime.substring(5, 7); // 月份
            String s_rq = formatTime.substring(8, 10); // 日期
            sreturn = s_yf + "月" + s_rq + "日";

        }
        return sreturn;
    }


    /**
     * Date类型转换为String类型
     *
     * @param data       Date类型的时间
     * @param formatType 格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
     * @return
     */
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }


    /**
     * 控件展示日期的方法（最大：今天，最小：今天-10年）
     *
     * @param context 上下文
     * @param date    标题（截止日期）
     * @param view    控件
     */
    public static void showDateDialogUntilToday(Context context, String date, TextView view) {
        PickerViewUtil.showSelectDatePickerViewBefore(context, date, dateStr -> view.setText(dateStr));
    }


    /**
     * Long类型转换为String类型
     *
     * @param currentTime 要转换的long类型的时间
     * @param formatType  要转换的string类型的时间格式
     * @return
     * @throws ParseException
     */
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        if (currentTime != 0L) {
            Date date = longToDate(currentTime, formatType); // long类型转成Date类型
            String strTime = dateToString(date, formatType); // date类型转成String
            return strTime;
        } else {
            return "";
        }
    }

    /**
     * Long类型转换为String类型
     *
     * @param currentTime 要转换的long类型的时间
     * @return
     * @throws ParseException
     */
    public static String longToString2(Long currentTime)
            throws ParseException {

        if (currentTime == null) {
            return "";

        } else {
            if (currentTime != 0L) {
                String formatType = "yyyy-MM-dd HH:mm:ss"; //要转换的string类型的时间格式
                Date date = longToDate(currentTime, formatType); // long类型转成Date类型
                String strTime = dateToString(date, formatType); // date类型转成String
                return strTime;
            } else {
                return "";
            }
        }

    }


    /**
     * String类型转换为Date类型
     *
     * @param strTime    要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒，的时间格式必须要与formatType的时间格式相同
     * @param formatType
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }


    /**
     * 要转换的long类型的时间
     *
     * @param currentTime 要转换的long类型的时间
     * @param formatType  要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
     * @return
     * @throws ParseException
     */
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }


    /**
     * String类型转换为Long类型
     *
     * @param strTime    要转换的String类型的时间的时间格式和formatType的时间格式必须相同
     * @param formatType 时间格式
     * @return
     * @throws ParseException
     */
    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    /* String类型转换为Long类型
     *
     * @param strTime    要转换的String类型的时间的时间格式和formatType的时间格式必须相同
     * @param formatType 时间格式
     * @return
     * @throws ParseException
     */
    public static long stringToLong2(String strTime)
            throws ParseException {
        //dateFormatYMDHMS 格式为："yyyy-MM-dd HH:mm:ss"
//        String formatType ="yyyy-MM-dd HH:mm:ss";

        Date date = stringToDate(strTime, dateFormatYMDHMS); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }


    /**
     * Date类型转换为Long类型
     *
     * @param date 要转换的date类型的时间
     * @return
     */
    public static long dateToLong(Date date) {
        return date.getTime();
    }

    //////////////////////////////今天 ，昨天/////////////////////////////////////

    /**
     * 判断给定字符串时间是否为今日(效率不是很高，不过也是一种方法)
     *
     * @param sdate
     * @return boolean
     */
    public static boolean isToday(String sdate) {
        boolean b = false;
        Date time = toDate(sdate);
        Date today = new Date();
        if (time != null) {
            String nowDate = dateFormater2.get().format(today);
            String timeDate = dateFormater2.get().format(time);
            if (nowDate.equals(timeDate)) {
                b = true;
            }
        }
        return b;
    }

    /**
     * 将字符串转位日期类型
     *
     * @param sdate
     * @return
     */
    public static Date toDate(String sdate) {
        try {
            return dateFormater.get().parse(sdate);
        } catch (ParseException e) {
            return null;
        }
    }

    private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    private static ThreadLocal<SimpleDateFormat> DateLocal = new ThreadLocal<SimpleDateFormat>();

    /**
     * 判断是否为今天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true今天 false不是
     * @throws ParseException
     */
    public static boolean IsToday(String day) throws ParseException {

        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);

        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);

            if (diffDay == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为昨天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true今天 false不是
     * @throws ParseException
     */
    public static boolean IsYesterday(String day) throws ParseException {

        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);

        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);

            if (diffDay == -1) {
                return true;
            }
        }
        return false;
    }

    public static SimpleDateFormat getDateFormat() {
        if (null == DateLocal.get()) {
            DateLocal.set(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA));
        }
        return DateLocal.get();
    }


    ///////////////////////////////////////////////////

    /**
     * @param date
     * @param date2
     * @return
     */
    public static String showTime2Time(String date, String date2) {
        if (!StrUtil.isEmpty(date) && !StrUtil.isEmpty(date2)) {


            String s1 = showTodayOrYesterday(date);//时间转换为：  今天HH:mm格式
            String s2 = showTodayOrYesterday(date2);//时间转换为： 今天HH:mm格式
            String s3;
            if (s1.length() > 2) {
                s3 = StrUtil.substring2chars(s1);//获取字符串前两位
            } else {
                return "";
            }

            String s4;
            if (s1.length() > 2) {
                s4 = StrUtil.substring2chars(s2);//获取字符串前两位

            } else {
                return "";
            }

            //截取日期
            String beforeDay;
            if (s1.length() > 2) {
                beforeDay = s1.substring(3, 5);
            } else {
                return "";
            }

            String endDay;
            if (s1.length() > 2) {
                endDay = s2.substring(3, 5);

            } else {
                return "";
            }


            if (s3.equals(s4) && beforeDay.equals(endDay)) {

                return s1 + "-" + DateUtil.getStringByFormat(date2, "HH:mm");

            } else {
                return s1 + "-" + s2;
            }
        } else {
            return "";
        }
    }

    /**
     * @param date
     * @param date2
     * @return
     */
    public static String showTime2Time2(String date, String date2) {
        if (!StrUtil.isEmpty(date) && !StrUtil.isEmpty(date2)) {
            String s1 = showTodayOrYesterdayPlus(date);//时间转换为：  今天HH:mm格式
            String s2 = showTodayOrYesterdayPlus(date2);//时间转换为： 今天HH:mm格式
            LogUtil.e("TAG", "laughing------------s1s1s1s1---------->   " + s1);
            LogUtil.e("TAG", "laughing-------------s2s2s2s2--------->   " + s2);

            String s3;

            if (s1.length() > 2) {
                s3 = StrUtil.substring2chars(s1);//获取字符串前两位
            } else {
                return "";
            }

            String s4;
            if (s1.length() > 2) {
                s4 = StrUtil.substring2chars(s2);//获取字符串前两位

            } else {
                return "";
            }

            if (s3.equals(s4)) {

                return s1 + "-" + DateUtil.getStringByFormat(date2, "HH:mm");

            } else {
                return s1 + "-" + s2;
            }
        } else {
            return "";
        }
    }


    /**
     * 获取类型为 今天 23:00 类型的时间
     *
     * @param date
     * @return
     */
    public static String showTodayOrYesterday(String date) {
        LogUtil.e("TAG", DateUtil.formatDateStr2Desc2(date, "HH:mm"));
        LogUtil.e("TAG", DateUtil.formatDateStr2Desc2(date, "MM月dd日  HH:mm"));
        try {
            if (DateUtils.IsToday(date)) {
                return DateUtil.formatDateStr2Desc2(date, "HH:mm");
            } else if (DateUtils.IsYesterday(date)) {
                return DateUtil.formatDateStr2Desc2(date, "HH:mm");
            } else {
                return DateUtil.formatDateStr2Desc2(date, "MM-dd HH:mm");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";

    }

    /**
     * 获取类型为 今天 23:00 类型的时间
     *
     * @param date
     * @return
     */
    public static String showTodayOrYesterdayPlus(String date) {
        LogUtil.e("TAG", DateUtil.formatDateStr2Desc2(date, "HH:mm"));
        LogUtil.e("TAG", DateUtil.formatDateStr2Desc2(date, "MM月dd日  HH:mm"));
        try {
            if (DateUtils.IsToday(date)) {
                return DateUtil.formatDateStr2Desc2(date, "HH:mm");
            } else if (DateUtils.IsYesterday(date)) {
                return DateUtil.formatDateStr2Desc2(date, "HH:mm");
            } else {
                return DateUtil.formatDateStr2Desc2(date, "yyyy-MM-dd HH:mm");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";

    }

    /**
     * 获取类型为 今天 23:00 类型的时间
     *
     * @param date
     * @return
     */
    public static String showTodayOrYesterday2(String date) {
        LogUtil.e("TAG", DateUtil.formatDateStr2Desc2(date, "HH:mm"));
        LogUtil.e("TAG", DateUtil.formatDateStr2Desc2(date, "MM月dd日  HH:mm"));
        try {
            if (DateUtils.IsToday(date)) {
                return DateUtil.formatDateStr2Desc2(date, "HH:mm");
            } else if (DateUtils.IsYesterday(date)) {
                return DateUtil.formatDateStr2Desc2(date, "HH:mm");
            } else {
                return DateUtil.formatDateStr2Desc2(date, "yyyy-MM-dd HH:mm");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";

    }

    //////////////////////////////////////////////////

    /**
     * test
     *
     * @param date
     * @return
     */
    public static String time15And30And45And00(long date) {
        String dateStr = date + "";
        int length = dateStr.length();
        int a = 15 * 60 * 1000;
        int b = 30 * 60 * 1000;
        int c = 45 * 60 * 1000;
        int d = 60 * 60 * 1000;
        String untilEnd7 = dateStr.substring(0, length - 7); //long类型时间前 直到倒数第7位
        String end7 = dateStr.substring(length - 7, length);//long 类型 最后7位
        LogUtil.e("TAG", "laughing----------dateStr.substring(0, length - 7);------------>   " + dateStr.substring(0, length - 7));
        LogUtil.e("TAG", "laughing----------dateStr.substring(length - 7, length);------------>   " + dateStr.substring(length - 7, length));
        boolean b1 = end7.startsWith("0");
        LogUtil.e("TAG", "laughing-------b1--------------->   " + b1);

        return "";
    }

    public static double long2Double(long date) {
        double oneHour = 1000 * 60 * 60;
        double v = date / oneHour;
        double newNum = v + 0.05;
        return 0.0;
    }

    //分钟转小时
    public static String minute2hour(int minute) {
        return (minute / 60) + "小时";
    }


    /**
     * 分钟转小时
     *
     * @param minute
     * @return
     */
    public static String minute2hourPlus(int minute) {
        if (minute >= 60) {
            return (minute / 60) + "小时";
        } else {
            return minute + "分钟";
        }

    }

    /**
     * 去掉时间最后的秒
     *
     * @param date
     * @return
     */
    public static String replaceSecondWithBlank(String date) {

        return date.substring(0, 16);
    }

    /**
     * 设置中间弹出的 dialog 样式等
     *
     * @param dialog        Dialog 对象
     * @param localView     Dialog布局对应的View
     * @param windowManager windowManager对象
     */
    public static void initDialogCenter(Dialog dialog, View localView, WindowManager windowManager) {
        dialog.setContentView(localView);
        dialog.getWindow().setGravity(Gravity.CENTER);
        // 设置全屏
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = display.getWidth(); // 设置宽度
        dialog.getWindow().setAttributes(lp);
    }
}