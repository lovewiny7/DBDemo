package com.cq.aaa.dbdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;

import com.cq.aaa.dbdemo.R;
import com.cq.aaa.dbdemo.databinding.ASendMsgBinding;
import com.cq.aaa.dbdemo.mvpview.SendView;
import com.cq.aaa.dbdemo.presenter.SendPresenter;
import com.waterbase.ui.BaseActivity;
import com.waterbase.utile.StrUtil;

/**
 * 数据发送页
 */
public class A_Send_Msg extends BaseActivity implements SendView {
    
    private ASendMsgBinding mBinding;
    private SendPresenter mPresenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       mBinding = setView( R.layout.a_send_msg);
        mBinding = DataBindingUtil.setContentView(this, R.layout.a_send_msg);
        initTitle();
        initView();
        initData();
        initListener();
        
        
    }
    
    private void initListener() {
        mBinding.setClick(v -> mPresenter.click(v, StrUtil.tvGetText(mBinding.etInput)));
    }
    
    private void initView() {
    
    }
    
    private void initData() {
        mPresenter = new SendPresenter(this, this);
    }
    
    private void initTitle() {
    
    }
    
}
