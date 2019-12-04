package com.global.winy7.basedb.bean;

import java.io.Serializable;

/**
 * <pre>
 *     desc   : 消息列表
 *     author : winy7
 *     time   : 2019/10/23
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class TalkMessList implements Serializable{
    
    private String talkContent; //消息内容
    private int contentType;  //消息 类型：1.发送 2.接收
    private int canBack;  //是否可撤销 1.true 0.false
    private long date;   //发送/接收 时间
    
    
    public TalkMessList() {
    }
    
    public TalkMessList(String talkContent, int contentType, long date) {
        this.talkContent = talkContent;
        this.contentType = contentType;
        this.date = date;
    }
    
    public String getTalkContent() {
        return talkContent;
    }
    
    public void setTalkContent(String talkContent) {
        this.talkContent = talkContent;
    }
    
    public int getContentType() {
        return contentType;
    }
    
    public void setContentType(int contentType) {
        this.contentType = contentType;
    }
    
    public int getCanBack() {
        if ((System.currentTimeMillis() - date) > 1000 * 60 * 2) {
            return 0;
        } else
            return 1;
    }
    
    public void setCanBack(int canBack) {
        this.canBack = canBack;
    }
    
    public long getDate() {
        return date;
    }
    
    public void setDate(long date) {
        this.date = date;
    }
}
