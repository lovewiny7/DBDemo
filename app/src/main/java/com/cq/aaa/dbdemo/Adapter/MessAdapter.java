package com.cq.aaa.dbdemo.Adapter;

import android.databinding.DataBindingUtil;

import com.cq.aaa.dbdemo.R;
import com.cq.aaa.dbdemo.bean.HistoryMess;
import com.cq.aaa.dbdemo.bean.UserInfo;
import com.cq.aaa.dbdemo.databinding.ItemMessDataBinding;
import com.waterbase.widget.recycleview.BaseAdapter;
import com.waterbase.widget.recycleview.BaseViewHolder;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/10/24
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class MessAdapter extends BaseAdapter<HistoryMess>{
    
    private UserInfo userInfo;
    
    public MessAdapter(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    @Override
    public int getLayoutRes(int index) {
        return R.layout.item_mess_data;
    }
    
    @Override
    public void convert(BaseViewHolder holder, HistoryMess data, int index) {
        ItemMessDataBinding bind = DataBindingUtil.bind(holder.itemView);
        bind.setViewModel(data);
//        bind.s
    }
    
    @Override
    public void bind(BaseViewHolder holder, int layoutRes) {
    
    }
}
