package com.cq.aaa.dbdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.cq.aaa.dbdemo.R;
import com.cq.aaa.dbdemo.databinding.AGetMsgBinding;
import com.cq.aaa.dbdemo.mvpview.GetView;
import com.cq.aaa.dbdemo.presenter.GetPresenter;
import com.waterbase.ui.BaseActivity;

/**
 * 数据接收页
 */
public class A_Get_Msg extends BaseActivity implements GetView {
    
    private AGetMsgBinding mBinding;
    private GetPresenter mPresenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       mBinding = setView( R.layout.a_send_msg);
        mBinding = DataBindingUtil.setContentView(this, R.layout.a_get_msg);
        initTitle();
        initView();
        initData();
        initListener();
        
        
    }
    
    private void initListener() {
    
    
    }
    
    private void initView() {
    
    }
    
    private void initData() {
        mPresenter = new GetPresenter(this, this);
//        List<HistoryMess> objects = mPresenter.queryData();
//        for (HistoryMess list : objects) {
//            Log.e(TAG, "initData: ->>>>>" + list.getContent());
//        }
        
        
    }
    
    private void initTitle() {
    
    }
    
}
