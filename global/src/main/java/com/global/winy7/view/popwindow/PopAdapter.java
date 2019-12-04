package com.global.winy7.view.popwindow;

import android.databinding.DataBindingUtil;

import com.global.R;
import com.global.databinding.ItemPopWindowListBinding;
import com.global.listener.ItemClickListener;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/09/11
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class PopAdapter extends BaseAdapter<String>{
    
    private ItemClickListener itemClickListener;
    
    public PopAdapter() {
    
    }
    
    
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    
    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_pop_window_list;
    }
    
    @Override
    public void convert(BaseViewHolder holder, String data, int index) {
        ItemPopWindowListBinding binding = DataBindingUtil.bind(holder.itemView);
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
