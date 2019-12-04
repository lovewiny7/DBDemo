package com.waterbase.http.common;

/**
 * 服务器返回数据的基础类
 * Created by Laughing on 2019/3/4.
 */
public class BasicResponse<T> {
    /**
     * status : 4020
     * message : 用户不存在!
     * resultMap : null
     */
    private int status;
    private String message;
    private T resultMap;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResultMap() {
        return resultMap;
    }

    public void setResultMap(T resultMap) {
        this.resultMap = resultMap;
    }

}
