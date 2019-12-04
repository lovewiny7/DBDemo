package com.global.winy7;

import com.global.R;
import com.waterbase.utile.StrUtil;

/**
 * <pre>
 *     desc   : 车辆常用常量
 *     author : winy7
 *     time   : 2019/07/31
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class CarTypeConversion {
    
    /**
     * 配件字段
     */
    public static final String KEY_PRODUCT = "PRODUCT";
    public static final String KEY_OIL = "OIL";
    public static final String KEY_MACHINE = "MACHINE";
    public static final String KEY_AIR = "AIR";
    public static final String KEY_AIR_CONDITIONER = "AIR_CONDITIONER";
    public static final String KEY_WIPER = "WIPER";
    public static final String KEY_BATTERY = "BATTERY";
    public static final String KEY_OTHERS = "OTHERS";
    
    
    public static String getTitleText(String title) {
        if (StrUtil.isEmpty(title)){
            return "配件管理";
        }
        switch (title) {
            case KEY_OIL: {
                
                return "机油列表";
                
            }
            case KEY_MACHINE: {
                return "机滤列表";
            }
            case KEY_AIR: {
                return "空滤列表";
            }
            case KEY_AIR_CONDITIONER: {
                return "空调滤列表";
            }
            case KEY_WIPER: {
                return "雨刮器列表";
            }
            case KEY_BATTERY: {
                return "电瓶列表";
            }
            case KEY_OTHERS: {
                return "其他备件";
            }
            
            
        }
    
        return "配件管理";
    }
    
        public static String getType(String title) {
        if (StrUtil.isEmpty(title)){
            return "配件";
        }
        switch (title) {
            case KEY_OIL: {
                
                return "机油";
                
            }
            case KEY_MACHINE: {
                return "机滤";
            }
            case KEY_AIR: {
                return "空滤";
            }
            case KEY_AIR_CONDITIONER: {
                return "空调滤";
            }
            case KEY_WIPER: {
                return "雨刮器";
            }
            case KEY_BATTERY: {
                return "电瓶";
            }
            case KEY_OTHERS: {
                return "其他备件";
            }
            
            
        }
        
        return "配件管理";
    }
}
