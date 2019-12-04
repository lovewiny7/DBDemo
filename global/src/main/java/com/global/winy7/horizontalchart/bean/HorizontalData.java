package com.global.winy7.horizontalchart.bean;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/09/06
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class HorizontalData {
    
    private String itemName;
    private float itemData;
    
    public HorizontalData(String itemName, float itemData) {
        this.itemName = itemName;
        this.itemData = itemData;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public float getItemData() {
        return itemData;
    }
    
    public void setItemData(float itemData) {
        this.itemData = itemData;
    }
}
