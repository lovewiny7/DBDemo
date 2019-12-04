package com.global.winy7.horizontalchart.bean;

import com.global.winy7.NumUtil.NumberUtil;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/09/06
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class HorizontalDataVm {
    
    private String itemName;
    private float itemData;
    private HorizontalData data;
    
    public HorizontalDataVm(HorizontalData data) {
        this.data = data;
    }
    
    public String getItemName() {
        return data.getItemName();
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public String getItemData() {
        return NumberUtil.FloathideInvalidBit(data.getItemData())+"元";
    }
    
    public void setItemData(float itemData) {
        this.itemData = itemData;
    }
}
