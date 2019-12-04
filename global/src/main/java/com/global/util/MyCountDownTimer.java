package com.global.util;

import android.os.CountDownTimer;
import android.widget.TextView;


//复写倒计时
public class MyCountDownTimer extends CountDownTimer {
    TextView mBtnGetCode;

    public MyCountDownTimer(TextView btnGetCode,
                            long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mBtnGetCode = btnGetCode;
    }

    @Override
    public void onTick(long l) { //计时过程
        //防止计时过程中重复点击
        mBtnGetCode.setClickable(false);
        mBtnGetCode.setText(l / 1000 + "s");
    }

    @Override
    public void onFinish() {//计时完毕的方法
        // 重新给Button设置文字
        mBtnGetCode.setText("重新获取验证码");
        // 设置可点击
        mBtnGetCode.setClickable(true);
    }
}