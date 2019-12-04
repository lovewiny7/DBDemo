package com.cq.aaa.dbdemo.presenter;

import android.view.View;

import com.cq.aaa.dbdemo.R;
import com.cq.aaa.dbdemo.activity.A_Add_User;
import com.cq.aaa.dbdemo.mvpview.AddUserView;
import com.global.winy7.view.CustomTextView.RTextView;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/11/05
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class AddUserPresenter {
    
    
    private AddUserView mView;
    private A_Add_User activity;
    
    public AddUserPresenter(AddUserView mView, A_Add_User activity) {
        this.mView = mView;
        this.activity = activity;
    }
    
    public void click(View v) {
        
        if (v.getId() == R.id.tv_sex_man) {
            mView.changeChecked(0);
        } else if (v.getId() == R.id.tv_sex_woman) {
            mView.changeChecked(1);
        } else if (v.getId() == R.id.tv_sex_unknown) {
            mView.changeChecked(-1);
        } else if (v.getId() == R.id.tv_commit) {
            mView.addUser();
        }
        
    }
}
