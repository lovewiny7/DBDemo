package com.global.winy7.sqlite.bean;

import java.io.Serializable;

/**
 * <pre>
 *     desc   : 配件实体类
 *     author : winy7
 *     time   : 2019/07/31
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class ProBean implements Serializable {
    private int id;
    private String type;
    private String name;
    private int price;
    private byte[] img;
    
    public ProBean(int id, String type, String name, int price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }
    
    public ProBean(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public byte[] getImg() {
       return  img;
    }
    
    public void setImg(byte[] img) {
        this.img = img;
    }
}
