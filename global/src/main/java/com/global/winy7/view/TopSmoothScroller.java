package com.global.winy7.view;

import android.content.Context;
import android.support.v7.widget.LinearSmoothScroller;
import android.util.DisplayMetrics;


/**
 * <pre>
 *     desc   : 控制recycleview滑动
 *     author : winy7
 *     time   : 2019/09/27
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 *
 *          使用方法： mManager为rv传入的 LinearLayoutManager
 *          final TopSmoothScroller mScroller = new TopSmoothScroller(getActivity());
 *          mScroller.setTargetPosition(showIndex.get(i));
 *          mManager.startSmoothScroll(mScroller);
 * </pre>
 */
public class TopSmoothScroller extends LinearSmoothScroller {
    public TopSmoothScroller(Context context) {
        super(context);
    }
    
    @Override
    protected int getHorizontalSnapPreference() {
        return SNAP_TO_START;//具体见源码注释
    }
    
    @Override
    protected int getVerticalSnapPreference() {
        return SNAP_TO_START;//具体见源码注释
    }
    
    
    ///设置滑动时间
    @Override
    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 0.001f;
    }
}

