package com.global.winy7.view;

import android.content.Context;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.global.R;
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
public class MPChartMarkerView extends MarkerView {
    
    private ArrowTextView tvContent;
    
    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    public MPChartMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        
        tvContent = (ArrowTextView) findViewById(R.id.tvContent);
    }
    
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        if (e instanceof CandleEntry) {
            
            CandleEntry ce = (CandleEntry) e;
            
            tvContent.setText(StringUtils.hideInvalidBit(ce.getHigh()));
        } else {
            
            tvContent.setText(StringUtils.hideInvalidBit(e.getY()));
        }
        
        super.refreshContent(e, highlight);//必须加上该句话；This sentence must be added.
    }
    
    private MPPointF mOffset;
    
    @Override
    public MPPointF getOffset() {
        if (mOffset == null) {
            // center the marker horizontally and vertically
            mOffset = new MPPointF(-(getWidth() / 2), -getHeight());
        }
        
        return mOffset;
    }
}


