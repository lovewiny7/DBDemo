package com.global.ustewardConstant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 项目中的一些常量
 * <p>
 * Created by Guangkuo on 2018/2/5.
 */
public final class Constant {
    /**
     * 项目中的日期格式
     */
    public static final DateFormat APP_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    /**
     * 项目中的时间格式
     */
    public static final DateFormat APP_TIME_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault());
}