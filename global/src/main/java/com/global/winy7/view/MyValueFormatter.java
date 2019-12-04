package com.global.winy7.view;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.global.ustewardUtil.StringUtils;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/08/01
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class MyValueFormatter extends ValueFormatter {

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return StringUtils.hideInvalidBit(value );
    }
}
