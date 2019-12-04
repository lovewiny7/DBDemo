package com.global.ui.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.global.R;
import com.global.databinding.SimpleTitleActivityBinding;
import com.waterbase.ui.BaseActivity;
import com.waterbase.utile.ResourceHelper;


public class Simple_Title_Activity extends BaseActivity {
    
    private SimpleTitleActivityBinding mBinding;
    public TextView tvLeftOne;
    public ImageView ivBack;
    public TextView tvTitle;
    public ImageView ivRightOne;
    public TextView tvRightOne;
    public View lineTitle;
    public LinearLayout llSubView;
    private RelativeLayout llTitleBar;
    private LinearLayout llRoot;
    private View root;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mBinding = setView( R.layout.simple_title_activity);
        mBinding = DataBindingUtil.setContentView(this, R.layout.simple_title_activity);
        initTitle();
        initView();
        initData();
        initListener();
        
        
    }
    
    /**
     * 重点是重写setContentView，让继承者可以继续设置setContentView
     * 重写setContentView
     *
     * @param resId
     */
    
    public <T extends ViewDataBinding> T setView(int resId) {
        
        root = mInflater.inflate(resId, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        if (null != llTitleBar)
            llRoot.addView(root, lp);
        return DataBindingUtil.bind(root);
    }
    
    
    private void initListener() {
        // 标题控件点击事件
        mBinding.setClick(v -> {
            if (v.getId() == R.id.iv_back) {
                ivLeftOneOnClick();
            } else if (v.getId() == R.id.tv_left_one) {
                tvLeftOneOnClick();
            } else if (v.getId() == R.id.tv_right_one) {
                tvRightOneOnClick();
            } else if (v.getId() == R.id.iv_right_one) {
                ivRightOneOnClick();
            }
        });
        
    }
    
    protected void ivLeftOneOnClick() {
        finish();
    }
    protected void ivRightOneOnClick() {
    
    }
    
    protected void tvRightOneOnClick() {
    
    }
    
    protected void tvLeftOneOnClick() {
    
    }
    
    private void initView() {
        llRoot = mBinding.llRoot; //根布局
        llTitleBar = mBinding.llTitleBar; //标题根布局
        tvLeftOne = mBinding.tvLeftOne; //左一文字
        ivBack = mBinding.ivBack; //左一图片
        tvTitle = mBinding.tvTitle; //标题
        ivRightOne = mBinding.ivRightOne;//右一文字
        tvRightOne = mBinding.tvRightOne;//右一图片
        lineTitle = mBinding.lineTitle;//标题栏底部线
//        llSubView = mBinding.llSubView; //主页面父控件
        
        //默认只显示返回按钮和标题
        tvLeftOne.setVisibility(View.GONE);
        ivRightOne.setVisibility(View.GONE);
        tvRightOne.setVisibility(View.GONE);
    }
    
    private void initData() {
//        mPresenter = new Presenter(this, this, this);
    }
    
    private void initTitle() {
    setStatusBarColor(ResourceHelper.getColor(R.color.grey_title),this);
    }
    
    // 标题栏不入侵
    @Override
    protected boolean isFullStatusBar() {
        return false;
    }
    
    //标题栏字体黑色
    @Override
    protected boolean isDarkStatusBar() {
        return true;
    }
    
    /**
     * 设置标题栏颜色
     *
     * @param res
     */
    protected void setTitleBackground(int res) {
        
        llTitleBar.setBackgroundResource(res);
    }
    
    /**
     * 设置左一图片
     *
     * @param icon
     */
    protected void setLeftIcon(int icon) {
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setImageResource(icon);
    }
    
    /**
     * 设置右一图片
     *
     * @param icon
     */
    protected void setRightIcon(int icon) {
        ivRightOne.setVisibility(View.VISIBLE);
        ivRightOne.setImageResource(icon);
    }
    
    protected void setRightIcon(Drawable icon) {
        
        ivRightOne.setVisibility(View.VISIBLE);
        ivRightOne.setImageDrawable(icon);
    }
    
    /**
     * 设置左一文字
     *
     * @param text
     */
    protected void setLeftOneText(String text) {
        tvLeftOne.setVisibility(View.VISIBLE);
        tvLeftOne.setText(text);
        
    }
    
    /**
     * 设置左一文字颜色
     *
     * @param res
     */
    protected void setLeftOneTextColor(int res) {
        
        tvLeftOne.setTextColor(res);
    }
    
    
    /**
     * 设置左一文字大小
     *
     * @param size
     */
    protected void setLeftOneTextSize(float size) {
        
        tvLeftOne.setTextSize(size);
    }
    
    /**
     * 设置标题文字
     *
     * @param title
     */
    protected void setTitleText(String title) {
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(title);
    }
    
    /**
     * 设置标题文字颜色
     *
     * @param res
     */
    protected void setTitleTextColor(int res) {
        
        tvTitle.setTextColor(res);
    }
    
    
    /**
     * 设置标题文字大小
     *
     * @param size
     */
    protected void setTitleTextSize(float size) {
        
        tvTitle.setTextSize(size);
    }
    
    
    /**
     * 设置右一文字
     *
     * @param text
     */
    protected void setRightOneText(String text) {
        tvRightOne.setVisibility(View.VISIBLE);
        tvRightOne.setText(text);
    }
    
    /**
     * 设置右一文字颜色
     *
     * @param res
     */
    protected void setRightOneTextColor(int res) {
        
        tvRightOne.setTextColor(res);
    }
    
    
    /**
     * 设置右一文字大小
     *
     * @param size
     */
    protected void setRightOneTextSize(float size) {
        
        tvRightOne.setTextSize(size);
    }
    
    
    
}
