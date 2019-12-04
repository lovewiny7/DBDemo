package com.global.winy7.horizontalchart;

import java.util.List;

/**
 * <pre>
 *     desc   : 获取集合中的最大值
 *     author : winy7
 *     time   : 2019/09/09
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class GetMaxValues {
    public static float getMax(List<Float> list) {
        float max = 0f;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
        
        return max;
    }
    
    
   
}
