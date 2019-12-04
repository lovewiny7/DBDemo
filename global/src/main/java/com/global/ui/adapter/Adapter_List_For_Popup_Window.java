package com.global.ui.adapter;

import android.databinding.DataBindingUtil;

import com.global.R;
import com.global.bean.Parking;
import com.global.databinding.ItemPopupWindowListBinding;
import com.global.listener.ItemClickListener;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 *
 * 作者：Laughing on 2018/5/3 10:15
 * 邮箱：719240226@qq.com
 */

public class Adapter_List_For_Popup_Window extends BaseAdapter<Parking> {

    private ItemClickListener itemClickListener;

    public Adapter_List_For_Popup_Window() {

    }


    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_popup_window_list;
    }

    @Override
    public void convert(BaseViewHolder holder, Parking data, int index) {
        ItemPopupWindowListBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setViewModel(data);
        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null)
                itemClickListener.itemClick(v, data, index);
        });
    }

    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {

    }
}
