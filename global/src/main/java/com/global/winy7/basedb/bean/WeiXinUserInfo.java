package com.global.winy7.basedb.bean;

import java.io.Serializable;

/**
 * <pre>
 *     desc   : 微信用户信息
 *     author : winy7
 *     time   : 2019/09/24
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class WeiXinUserInfo implements Serializable {
    
    private String weiXInName; //昵称
    private String weiXinId; //微信号
    private String icon; //头像
    private int age; //年龄
    private String country; // 国籍

    private String province; //省
    private String city; // 市
    private String signature; // 个性签名
    private String checkMess; // 验证消息
    private int bindingPhone; // 绑定手机

    private int sex;   //性别 1.男 0.女
    private String realName; //实名
    private String idCard;  //  身份证

    public WeiXinUserInfo() {
    }
    
    public WeiXinUserInfo(String name, String weiXinId, String icon, int age, String country,
                          String province, String city, String signature, String checkMess,
                          int bindingPhone, int sex, String realName, String idCard) {
        this.weiXInName = name;
        this.weiXinId = weiXinId;
        this.icon = icon;
        this.age = age;
        this.country = country;
        this.province = province;
        this.city = city;
        this.signature = signature;
        this.checkMess = checkMess;
        this.bindingPhone = bindingPhone;
        this.sex = sex;
        this.realName = realName;
        this.idCard = idCard;
    }

    public String getWeiXInName() {
        return weiXInName;
    }

    public void setWeiXInName(String weiXInName) {
        this.weiXInName = weiXInName;
    }

    public String getWeiXinId() {
        return weiXinId;
    }

    public void setWeiXinId(String weiXinId) {
        this.weiXinId = weiXinId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCheckMess() {
        return checkMess;
    }

    public void setCheckMess(String checkMess) {
        this.checkMess = checkMess;
    }

    public int getBindingPhone() {
        return bindingPhone;
    }

    public void setBindingPhone(int bindingPhone) {
        this.bindingPhone = bindingPhone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
