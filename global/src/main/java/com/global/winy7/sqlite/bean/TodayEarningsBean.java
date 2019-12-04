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
public class TodayEarningsBean {
    
    private ArrayList<String> dates;
    private ArrayList<Integer>  prices;
    
    
    public TodayEarningsBean(ArrayList<String> dates, ArrayList<Integer> prices) {
        this.dates = dates;
        this.prices = prices;
    }
    
    public ArrayList<String> getDates() {
        return dates;
    }
    
    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }
    
    public ArrayList<Integer> getPrices() {
        return prices;
    }
    
    public void setPrices(ArrayList<Integer> prices) {
        this.prices = prices;
    }
}
