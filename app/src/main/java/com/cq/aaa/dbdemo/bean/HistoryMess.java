package com.cq.aaa.dbdemo.bean;

import java.io.Serializable;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/10/24
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class HistoryMess implements Serializable{
    
    private String content;
    private long date;
    private int type;
    
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public long getDate() {
        return date;
    }
    
    public void setDate(long date) {
        this.date = date;
    }
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public HistoryMess() {
    }
}
