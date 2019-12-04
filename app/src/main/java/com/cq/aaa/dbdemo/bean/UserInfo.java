package com.cq.aaa.dbdemo.bean;

import java.util.List;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/10/24
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class UserInfo {
    
    private String id;
    private String name;
    private int sex;
    private int age;
    private String imgUrl;
    
    public UserInfo(String id, String name, int sex, int age, String imgUrl) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.imgUrl = imgUrl;
    }
    
    public UserInfo() {
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getSex() {
        return sex;
    }
    
    public void setSex(int sex) {
        this.sex = sex;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getImgUrl() {
        return imgUrl;
    }
    
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
