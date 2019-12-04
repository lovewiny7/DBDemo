package com.global.winy7.sqlite.bean;

import com.waterbase.utile.StrUtil;

import java.io.Serializable;

/**
 * <pre>
 *     desc   : 车辆实体类
 *     author : winy7
 *     time   : 2019/07/08
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class CarBean implements Serializable {
    
    private int id;
    private String carNum;
    private String oilMess;
    private String airFilterMess;
    private String machineFilterMess;
    private String fixDate;
    private String mileage;
    private String titlePrice;
    private String owner;
    private String phone;
    private String others;
    private String otherPro;// 后加字段
    private int totalToday;
    
    public CarBean(int id, String carNum, String oilMess, String airFilterMess, String machineFilterMess, String fixDate, String mileage,
                   String titlePrice, String owner, String phone, String others, String otherPro) {
        this.id = id;
        this.carNum = carNum;
        this.oilMess = oilMess;
        this.airFilterMess = airFilterMess;
        this.machineFilterMess = machineFilterMess;
        this.fixDate = fixDate;
        this.mileage = mileage;
        this.titlePrice = titlePrice;
        this.owner = owner;
        this.phone = phone;
        this.others = others;
        this.otherPro = otherPro;
    }
    
    public CarBean(String carNum, String oilMess, String airFilterMess, String machineFilterMess, String fixDate, String mileage, String titlePrice) {
        this.carNum = carNum;
        this.oilMess = oilMess;
        this.airFilterMess = airFilterMess;
        this.machineFilterMess = machineFilterMess;
        this.fixDate = fixDate;
        this.mileage = mileage;
        this.titlePrice = titlePrice;
        
    }
    
    public CarBean() {
    }
    
    public int getTotalToday() {
        return totalToday;
    }
    
    public void setTotalToday(int totalToday) {
        this.totalToday = totalToday;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCarNum() {
        return carNum;
    }
    
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
    
    public String getOilMess() {
        return oilMess;
    }
    
    public void setOilMess(String oilMess) {
        this.oilMess = oilMess;
    }
    
    public String getAirFilterMess() {
        return airFilterMess;
    }
    
    public void setAirFilterMess(String airFilterMess) {
        this.airFilterMess = airFilterMess;
    }
    
    public String getMachineFilterMess() {
        return machineFilterMess;
    }
    
    public void setMachineFilterMess(String machineFilterMess) {
        this.machineFilterMess = machineFilterMess;
    }
    
    public String getFixDate() {
        return fixDate;
    }
    
    public void setFixDate(String fixDate) {
        this.fixDate = fixDate;
    }
    
    public String getMileage() {
        return mileage;
    }
    
    public void setMileage(String mileage) {
        this.mileage = mileage;
    }
    
    public String getTitlePrice() {
        return titlePrice;
    }
    
    public void setTitlePrice(String titlePrice) {
        this.titlePrice = titlePrice;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getOthers() {
        if (StrUtil.isEmpty(others)) {
            return "";
        }
        return others;
    }
    
    public void setOthers(String others) {
        this.others = others;
    }
    
    public String getOtherPro() {
        return otherPro;
    }
    
    public void setOtherPro(String otherPro) {
        this.otherPro = otherPro;
    }
}
