package com.cq.aaa.dbdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.cq.aaa.dbdemo.R;
import com.cq.aaa.dbdemo.bean.UserInfo;
import com.cq.aaa.dbdemo.databinding.AAddUserBinding;
import com.cq.aaa.dbdemo.mvpview.AddUserView;
import com.cq.aaa.dbdemo.presenter.AddUserPresenter;
import com.global.ui.activity.TitleActivity;
import com.global.winy7.view.CustomTextView.RTextView;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.ResourceHelper;
import com.waterbase.utile.StrUtil;

/**
 * <pre>
 *     desc   : 添加用户
 *     author : winy7
 *     time   : 2019/11/04
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class A_Add_User extends TitleActivity implements AddUserView {
    
    private AAddUserBinding mBinding;
    private AddUserPresenter mPresenter;
    private int sex;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = setView(R.layout.a_add_user);
        //  mBinding = DataBindingUtil.setContentView(this, R.layout.demo);
        initTitle();
        initView();
        initData();
        initListener();
        
        
    }
    
    private void initListener() {
        mBinding.setClick(v -> mPresenter.click(v));
    }
    
    private void initView() {
    
    }
    
    private void initData() {
        mPresenter = new AddUserPresenter(this, this);
    }
    
    private void initTitle() {
        setTitleBackgroundColor(ResourceHelper.getColor(R.color.grey_title));
        setTitleText("");
    }
    
    @Override
    public void addUser() {
        
        if (StrUtil.isEmpty(mBinding.etId)) {
            return;
        }
        
        if (StrUtil.isEmpty(mBinding.etName)) {
            return;
        }
        UserInfo userInfo = new UserInfo();
        if (!StrUtil.isEmpty(mBinding.etAge)) {
            userInfo.setAge(Integer.parseInt(StrUtil.tvGetText(mBinding.etAge)));
           
        }
        userInfo.setSex(sex);
        
    }
    
    @Override
    public void changeChecked(int type) {
        
        switch (type) {
            case 0:
                mBinding.tvSexMan.setIconNormal(R.mipmap.ic_checked_box);
                mBinding.tvSexWoman.setIconNormal(R.mipmap.ic_unchecked_box);
                mBinding.tvSexUnknown.setIconNormal(R.mipmap.ic_unchecked_box);
                break;
            case 1:
                mBinding.tvSexMan.setIconNormal(R.mipmap.ic_unchecked_box);
                mBinding.tvSexWoman.setIconNormal(R.mipmap.ic_checked_box);
                mBinding.tvSexUnknown.setIconNormal(R.mipmap.ic_unchecked_box);
                break;
            case -1:
                mBinding.tvSexMan.setIconNormal(R.mipmap.ic_unchecked_box);
                mBinding.tvSexWoman.setIconNormal(R.mipmap.ic_unchecked_box);
                mBinding.tvSexUnknown.setIconNormal(R.mipmap.ic_checked_box);
                break;
            
        }
        
        sex = type;
        
        LogUtil.e("CAO", "------sex----->" + sex);
    }
}
