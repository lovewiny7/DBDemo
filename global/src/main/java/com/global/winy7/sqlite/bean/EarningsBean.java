package com.global.winy7.sqlite.bean;

import java.util.ArrayList;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/08/06
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class EarningsBean {
    
    private ArrayList<String> date;
    private ArrayList<Integer> todayEarnings;
    
    public EarningsBean(ArrayList<String> date, ArrayList<Integer> todayEarnings) {
        this.date = date;
        this.todayEarnings = todayEarnings;
    }
    
    public ArrayList<String> getDate() {
        return date;
    }
    
    public void setDate(ArrayList<String> date) {
        this.date = date;
    }
    
    public ArrayList<Integer> getTodayEarnings() {
        return todayEarnings;
    }
    
    public void setTodayEarnings(ArrayList<Integer> todayEarnings) {
        this.todayEarnings = todayEarnings;
    }
}
