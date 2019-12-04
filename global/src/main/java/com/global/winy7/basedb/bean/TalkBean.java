package com.global.winy7.basedb.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <pre>
 *     desc   : 消息实体类
 *     author : winy7
 *     time   : 2019/10/21
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class TalkBean implements Serializable{
    
    private String weiXinId;  // 微信号
    
    private ArrayList<TalkMessList>  list;  // 消息列表
    
    private WeiXinUserInfo data; //用户信息
    
    public TalkBean() {
    }
    
    public TalkBean(String weiXinId, ArrayList<TalkMessList> list, WeiXinUserInfo data) {
        this.weiXinId = weiXinId;
        this.list = list;
        this.data = data;
    }
    
    public String getWeiXinId() {
        return weiXinId;
    }
    
    public void setWeiXinId(String weiXinId) {
        this.weiXinId = weiXinId;
    }
    
    public ArrayList<TalkMessList> getList() {
        return list;
    }
    
    public void setList(ArrayList<TalkMessList> list) {
        this.list = list;
    }
    
    public void setData(WeiXinUserInfo data) {
        this.data = data;
    }
    
    public WeiXinUserInfo getData() {
        return data;
    }
}