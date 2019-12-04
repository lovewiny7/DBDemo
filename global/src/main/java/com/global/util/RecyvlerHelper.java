package com.global.util;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.global.R;

/**
 * 作者：Laughing on 2019/3/17 15:49
 * 邮箱：719240226@qq.com
 */
public class RecyvlerHelper {
    public static void setDivderLine(Activity activity, RecyclerView recyclerView){
        DividerItemDecoration divider = new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(activity, R.drawable.divider_line));
        recyclerView.addItemDecoration(divider);
    }
}
