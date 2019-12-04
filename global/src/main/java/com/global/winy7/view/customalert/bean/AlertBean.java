package com.global.winy7.view.customalert.bean;

import com.waterbase.utile.StrUtil;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/09/02
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class AlertBean {
    
    private String title;  //标题
    private String mess;   //信息
    private String ok;     //确定
    private String cancle; //取消
    
    
    public AlertBean(String title, String mess, String ok, String cancle) {
        this.title = title;
        this.mess = mess;
        this.ok = ok;
        this.cancle = cancle;
    }
    
    public AlertBean(String title) {
        this.title = title;
    }
    
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getMess() {
        return mess;
    }
    
    public void setMess(String mess) {
        this.mess = mess;
    }
    
    public String getOk() {
        
        if (StrUtil.isEmpty(ok)) {
            return "确定";
        } else
            return ok;
    }
    
    public void setOk(String ok) {
        this.ok = ok;
    }
    
    public String getCancle() {
        if (StrUtil.isEmpty(cancle)) {
            return "取消";
        } else
            return cancle;
    }
    
    public void setCancle(String cancle) {
        this.cancle = cancle;
    }
}
