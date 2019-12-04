package com.global.winy7.sqlite.bean;

import com.waterbase.utile.StrUtil;

import java.io.Serializable;

/**
 * <pre>
 *     desc   : 供货商实体类
 *     author : winy7
 *     time   : 2019/07/08
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class SupplierBean implements Serializable {
    
    private String id;
    private String name; //名称
    private String address; //地址
    private String product; //产品
    private String phone;   //电话
    private int type; //编号
    
    
    public SupplierBean() {
    }
    
    public SupplierBean(String id, String name, String address, String product, String phone, int type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.product = product;
        this.phone = phone;
        this.type = type;
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
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getProduct() {
        return product;
    }
    
    public void setProduct(String product) {
        this.product = product;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
}
