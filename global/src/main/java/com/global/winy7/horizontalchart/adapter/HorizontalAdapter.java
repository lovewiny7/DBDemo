package com.global.winy7.horizontalchart.adapter;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.widget.LinearLayout;

import com.global.R;
import com.global.databinding.ItemHorizontalDataBinding;
import com.global.winy7.horizontalchart.bean.HorizontalData;
import com.global.winy7.horizontalchart.bean.HorizontalDataVm;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/09/06
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class HorizontalAdapter extends BaseAdapter<HorizontalData> {
    
    private int screenWidth;
    private float max;
    
    public HorizontalAdapter(int screenWidth, float max) {
        this.screenWidth = screenWidth;
        this.max = max;
    }
    
    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_horizontal_data;
    }
    
    @SuppressLint("SetTextI18n")
    @Override
    public void convert(BaseViewHolder holder, HorizontalData data, int index) {
        ItemHorizontalDataBinding bind = DataBindingUtil.bind(holder.itemView);
        bind.setViewModel(new HorizontalDataVm(data));
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) bind.viewProgress.getLayoutParams();
        lp.width = (int) (data.getItemData() / max * screenWidth * 2 / 3); //最大的数据占屏幕宽度的2/3
        bind.viewProgress.setLayoutParams(lp);
        
        
    }
    
    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {
    
    }
    
    
}
