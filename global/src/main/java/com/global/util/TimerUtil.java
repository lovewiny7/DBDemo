package com.global.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器  获取验证码的倒计时 及 自动弹出软键盘
 * 作者：Laughing on 2018/9/14 15:19
 * 邮箱：719240226@qq.com
 */
public class TimerUtil {

    /**
     * new倒计时对象,总共的时间,每隔多少秒更新一次时间*
     *
     * @param view
     */
    public static void countDown(TextView view) {
        MyCountDownTimer myCountDownTimer = new MyCountDownTimer(view, 60000, 1000);
        // 触发倒计时
        myCountDownTimer.start();

    }

    /**
     * 自动弹出软键盘
     *
     * @param context
     */
    public static void showSoftInput(Context context) {
        //自动弹出软键盘
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }, 500); // 秒后自动弹出
    }
}