package com.global.interfaces;

/**
 * 暂未使用
 * 用于微信支付之后的回调
 */
public interface OnWeiXinPayInfoCallback {
    /**
     * 支付成功
     */
    void onSuccess(String info);

    /**
     * 支付失败
     */
    void onFailure();
}