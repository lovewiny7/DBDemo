package com.global.winy7.view;

/**
 * <pre>
 *     desc   :对字符串类型的坐标轴标记进行格式化
 *     author : winy7
 *     time   : 2019/08/01
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */

import com.github.mikephil.charting.formatter.ValueFormatter;
import com.global.util.DateUtils;
import com.waterbase.utile.DateUtil;
import com.waterbase.utile.LogUtil;

import java.util.List;


public class StringAxisValueFormatter extends ValueFormatter {
    
    //区域值
    private List<String> mStrs;
    
    /**
     * 对字符串类型的坐标轴标记进行格式化
     *
     * @param strs
     */
    public StringAxisValueFormatter(List<String> strs) {
        this.mStrs = strs;
        LogUtil.e("CAO","-----mStrs------>"+mStrs.size());
    }
    
    @Override
    public String getFormattedValue(float v) {
        return DateUtil.getStringByFormat(mStrs.get((int) v / 10).replace("月", "-").replace("日", ""),
                DateUtil.dateFormatYMD, com.global.ustewardUtil.DateUtils.timeFormatWithMD);
        
    }
//    @Override
//    public String getFormattedValue(float v) {
////        String string = DateUtil.getStringByFormat(mStrs.get((int) v).replace("月", "-").replace("日", ""),
////                DateUtil.dateFormatYMD, com.global.ustewardUtil.DateUtils.timeFormatWithMD);
//        return "8-"+mStrs.get((int) v);
//    }
}
