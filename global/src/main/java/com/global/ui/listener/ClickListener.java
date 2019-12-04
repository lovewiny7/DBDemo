package com.global.ui.listener;

import android.view.View;

/**
 * RecyclerView 局部点击
 * 该app中已使用位置：1.停车记录-车场投诉监听
 *                 2.共享车位列表信息 的"发布车位"点击等
 *
 * @param <T>
 */
public interface ClickListener<T> {
    void complaint(View item, T t, int index);
}