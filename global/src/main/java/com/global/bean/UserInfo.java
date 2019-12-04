package com.global.bean;

import com.waterbase.ui.BaseApplication;
import com.waterbase.utile.PreferencesManager;

/**
 * <pre>
 *     desc   : 保存用户信息/获取用户信息
 *     author : winy7
 *     time   : 2019/05/28
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class UserInfo {
    
    // 获取 匿称
    public static String getUserName() {
        return PreferencesManager.getInstance(BaseApplication.getAppContext()).get("userName");
    }
    // 保存 匿称
    public static void setUserName(String userName) {
        PreferencesManager.getInstance(BaseApplication.getAppContext()).put("userName",userName);
    }
    
    
    // 获取 头像
    public static String getImgUrl() {
        return PreferencesManager.getInstance(BaseApplication.getAppContext()).get("imgUrl");
    }
    // 保存 头像
    public static void setImgUrl(String imgUrl) {
        PreferencesManager.getInstance(BaseApplication.getAppContext()).put("imgUrl",imgUrl);
    }
    // 获取 匿称
    public static String getName() {
        return PreferencesManager.getInstance(BaseApplication.getAppContext()).get("name");
    }
    // 保存 匿称
    public static void setName(String name) {
        PreferencesManager.getInstance(BaseApplication.getAppContext()).put("name",name);
    }
    
    // 获取 性别
    public static String getSex() {
        return PreferencesManager.getInstance(BaseApplication.getAppContext()).get("date");
    }
    // 保存 性别
    public static void setSex(String sex) {
        PreferencesManager.getInstance(BaseApplication.getAppContext()).put("date",sex);
    }
    
    // 获取 Id
    public static String getId() {
        return PreferencesManager.getInstance(BaseApplication.getAppContext()).get("name");
    }
    // 保存 Id
    public static void setId(String id) {
        PreferencesManager.getInstance(BaseApplication.getAppContext()).put("name",id);
    }
    
    // 获取 手机号
    public static String getPhone() {
        return PreferencesManager.getInstance(BaseApplication.getAppContext()).get("phone");
    }
    // 保存 手机号
    public static void setPhone(String phone) {
        PreferencesManager.getInstance(BaseApplication.getAppContext()).put("Phone",phone);
    }
}
