package com.global.even;

/**
 * 售后申请 EventBus
 * 作者：丁光阔
 * 时间：2017/8/30 10:24
 */
public class RechargeEvent {
    private int type;
    private String message;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
