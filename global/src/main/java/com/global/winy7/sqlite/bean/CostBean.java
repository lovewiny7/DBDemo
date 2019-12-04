package com.global.winy7.sqlite.bean;

import java.io.Serializable;

/**
 * <pre>
 *     desc   : 进货单类
 *     author : winy7
 *     time   : 2019/08/29
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class CostBean implements Serializable{
    
    private String name;
    private String id;
    private String merchant;
    private String phone;
    private double singlePrice;
    private int count;
    private double totalPrice;
    private String date;
    
    
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
    
    public String getMerchant() {
        return merchant;
    }
    
    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public double getSinglePrice() {
        return singlePrice;
    }
    
    public void setSinglePrice(double singlePrice) {
        this.singlePrice = singlePrice;
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
}
