package com.waterbase.ui;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.res.ColorStateList;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.waterbase.R;
import com.waterbase.utile.UiUtil;

/**
 * 你可以继承该类来获取一个带有默认头部的Activity
 * Created by Water on 2017/1/18.
 */
public class BaseTitleActivity extends BaseActivity {
    
    private LinearLayout llRoot; // 跟布局
    private View root; // 除去标题以外的布局
    protected RelativeLayout title;
    protected ImageView leftOneImage;
    private ImageView leftTwoImage;
    protected ImageView rightOneImage;
    private ImageView rightTwoImage;
    private TextView titleText;
    public TextView statusBar; // 状态栏
    protected TextView rightTextView, leftTextView;
    
    private View line1;
    private View line2;
    private View line3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.a_base_title);
//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            //修改为深色，因为我们把状态栏的背景色修改为主题色白色，默认的文字及图标颜色为白色，导致看不到了。
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }
        initTitle();
        initView();
        setStatusBarHeight();
    }
    
    private void initTitle() {
    
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
        if (null != llRoot)
            llRoot.addView(root, lp);
        return DataBindingUtil.bind(root);
    }
    
    
    public void setView(View view) {
        root = view;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        if (null != llRoot)
            llRoot.addView(root, lp);
    }

//    protected <T extends ViewDataBinding> T getBind() {
//        return DataBindingUtil.bind(root);
//    }
    
    /**
     * 实例化控件
     */
    private void initView() {
        
        line1 = findViewById(R.id.title_line1);
        line2 = findViewById(R.id.title_line2);
        line3 = findViewById(R.id.title_line3);
        
        llRoot = (LinearLayout) findViewById(R.id.ll_basetitle_root);
        title = (RelativeLayout) findViewById(R.id.ll_basetitle);
        statusBar = (TextView) findViewById(R.id.status_bar);
        titleText = (TextView) findViewById(R.id.tv_basetitle_title);
        titleText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗标题
        leftOneImage = (ImageView) findViewById(R.id.iv_left_one);
        leftTwoImage = (ImageView) findViewById(R.id.iv_left_two);
        rightOneImage = (ImageView) findViewById(R.id.iv_right_one);
        rightTextView = (TextView) findViewById(R.id.tv_right);
        leftTextView = (TextView) findViewById(R.id.tv_left);
        rightTwoImage = (ImageView) findViewById(R.id.iv_right_two);
        
        leftOneImage.setOnClickListener((v) -> leftOneImageOnClick());
        leftTwoImage.setOnClickListener((v) -> leftTwoImageOnClick());
        rightOneImage.setOnClickListener((v) -> rightOneImageOnClick());
        rightTwoImage.setOnClickListener((v) -> rightTwoImageOnClick());
        rightTextView.setOnClickListener((v) -> rightTextViewOnClick());
        leftTextView.setOnClickListener((v) -> leftTextViewOnClick());
    }
    
   
    
    /**
     * 设置分割线的颜色
     */
    protected void setLineColor(int color) {
        if (line1 != null && line2 != null && line3 != null) {
            line1.setBackgroundColor(color);
            line2.setBackgroundColor(color);
            line3.setBackgroundColor(color);
        }
    }
    
    /**
     * 设置分割线的颜色
     */
    protected void setLineBackgroundResource(int color) {
        if (line1 != null && line2 != null && line3 != null) {
            line1.setBackgroundResource(color);
            line2.setBackgroundResource(color);
            line3.setBackgroundResource(color);
        }
    }
    
    /**
     * 设置分割线的颜色
     */
    protected void setLineBackground(Drawable drawable) {
        if (line1 != null && line2 != null && line3 != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                line1.setBackground(drawable);
                line2.setBackground(drawable);
                line3.setBackground(drawable);
            } else {
                line1.setBackgroundDrawable(drawable);
                line2.setBackgroundDrawable(drawable);
                line3.setBackgroundDrawable(drawable);
            }
        }
    }
    
    /**
     * 设置分割线是否显示
     */
    protected void setlineVisible(boolean visible) {
        if (visible) {
            line1.setVisibility(View.VISIBLE);
            line2.setVisibility(View.VISIBLE);
            line3.setVisibility(View.VISIBLE);
        } else {
            line1.setVisibility(View.GONE);
            line2.setVisibility(View.GONE);
            line3.setVisibility(View.GONE);
        }
    }
    
    /**
     * 设置状态栏高度
     */
    protected void setStatusBarHeight() {
        statusBar.setHeight(UiUtil.getStatusBarHeight(this));
    }
    
    /**
     * 设置状态栏背景色
     *
     * @param color
     */
    protected void setStatusBarBackgroundColor(int color) {
        if (statusBar != null) {
            statusBar.setBackgroundColor(color);
        }
    }
    
    /**
     * 设置状态栏背景色
     *
     * @param res
     */
    protected void setStatusBarBackgroundResource(int res) {
        if (statusBar != null) {
            statusBar.setBackgroundResource(res);
        }
    }
    
    
    /**
     * 设置状态栏背景色
     *
     * @param drawable
     */
    protected void setStatusBarBackground(Drawable drawable) {
        if (statusBar != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                statusBar.setBackground(drawable);
            } else {
                statusBar.setBackgroundDrawable(drawable);
            }
        }
    }
    
    
    /**
     * 设置title背景
     *
     * @param color
     */
    protected void setTitleBackgroundColor(int color) {
        if (rightOneImage != null) {
            title.setBackgroundColor(color);
        }
    }
    
    /**
     * 设置title背景
     *
     * @param res
     */
    protected void setTitleBackgroundResource(int res) {
        if (rightOneImage != null) {
            title.setBackgroundResource(res);
        }
    }
    
    /**
     * 设置title背景
     *
     * @param drawable
     */
    protected void setTitleBackground(Drawable drawable) {
        if (rightOneImage != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                title.setBackground(drawable);
            } else {
                title.setBackgroundDrawable(drawable);
            }
        }
    }
    
    /**
     * 设置中间标题文字
     *
     * @param c
     */
    protected void setTitleText(CharSequence c) {
        if (titleText != null)
            titleText.setText(c);
    }
    
    /**
     * 设置中间标题文字
     *
     * @param resId
     */
    protected void setTitleText(int resId) {
        if (titleText != null)
            titleText.setText(resId);
    }
    
    /**
     * 设置中间标题文字颜色
     *
     * @param res
     */
    protected void setTitleTextColor(int res) {
        if (titleText != null) {
            titleText.setTextColor(res);
        }
    }
    
    /**
     * 设置中间标题文字颜色
     *
     * @param colorStateList
     */
    protected void setTitleTextColor(ColorStateList colorStateList) {
        if (titleText != null) {
            titleText.setTextColor(colorStateList);
        }
    }
    
    /**
     * 设置中间标题文字大小
     *
     * @param size sp
     */
    protected void setTitleTextSize(float size) {
        if (titleText != null) {
            titleText.setTextSize(size);
        }
    }
    
    /**
     * 设置中间标题文字大小
     *
     * @param unit
     * @param size
     */
    protected void setTitleTextSize(int unit, float size) {
        if (titleText != null) {
            titleText.setTextSize(unit, size);
        }
    }
    
    /**
     * 左一TextView点击事件
     */
    protected void leftTextViewOnClick() {
    
    }
    
    /**
     * 设置左一按钮是否显示
     *
     * @param visible
     */
    protected void setLeftOneImageVisibity(boolean visible) {
        if (leftOneImage != null) {
            if (visible) {
                if (leftTwoImage.getVisibility() == View.GONE) {
                    line1.setVisibility(View.GONE);
                } else {
                    line1.setVisibility(View.VISIBLE);
                }
                leftOneImage.setVisibility(View.VISIBLE);
            } else {
                leftOneImage.setVisibility(View.GONE);
                if (line1.getVisibility() == View.VISIBLE) {
                    line1.setVisibility(View.GONE);
                }
            }
        }
    }
    
    /**
     * 设置左一按钮图标
     *
     * @param resId
     */
    protected void setLeftOneImagePic(int resId) {
        if (leftOneImage != null) {
            leftOneImage.setImageResource(resId);
        }
    }
    
    /**
     * 设置左一按钮图标(黑色返回按钮变白色)
     *
     * @param resId
     */
    protected void setLeftOneImagePic2White(int resId) {
        if (leftOneImage != null) {
            leftOneImage.setImageResource(resId);
            leftOneImage.setColorFilter(getResources().getColor(R.color.white));
            ;
        }
    }
    
    
    /**
     * 设置左侧侧TextView文字
     *
     * @param c
     */
    protected void setLeftTextViewText(CharSequence c) {
        if (leftTextView != null)
            leftTextView.setText(c);
    }
    
    /**
     * 设置左侧TextView文字
     *
     * @param resId
     */
    protected void setLeftTextViewText(int resId) {
        if (leftTextView != null)
            leftTextView.setText(resId);
    }
    
    /**
     * 设置右侧TextView文字颜色
     *
     * @param res
     */
    protected void setLeftTextViewTextColor(int res) {
        if (leftTextView != null) {
            leftTextView.setTextColor(res);
        }
    }
    
    /**
     * 设置右侧TextView文字颜色
     *
     * @param colorStateList
     */
    protected void setLeftTextViewTextColor(ColorStateList colorStateList) {
        if (leftTextView != null) {
            leftTextView.setTextColor(colorStateList);
        }
    }
    
    /**
     * 设置右侧TextView文字颜色大小
     *
     * @param size sp
     */
    protected void setLeftTextViewTextSize(float size) {
        if (leftTextView != null) {
            leftTextView.setTextSize(size);
        }
    }
    
    /**
     * 设置右侧TextView文字颜色大小
     *
     * @param unit
     * @param size
     */
    protected void setLeftTextViewTextSize(int unit, float size) {
        if (leftTextView != null) {
            leftTextView.setTextSize(unit, size);
        }
    }
    
    /**
     * 设置右侧TextView是否显示
     *
     * @param visible
     */
    protected void setLeftTextViewVisibity(boolean visible) {
        if (leftTextView != null) {
            if (visible) {
                leftTextView.setVisibility(View.VISIBLE);
                
            } else {
                leftTextView.setVisibility(View.GONE);
            }
        }
        
        
    }
    
    /**
     * 设置左二按钮是否显示
     *
     * @param visible
     */
    protected void setLeftTwoImageVisibity(boolean visible) {
        if (leftTwoImage != null) {
            if (visible) {
                if (leftOneImage.getVisibility() == View.GONE) {
                    line1.setVisibility(View.GONE);
                } else {
                    line1.setVisibility(View.VISIBLE);
                }
                leftTwoImage.setVisibility(View.VISIBLE);
            } else {
                leftTwoImage.setVisibility(View.GONE);
                if (line1.getVisibility() == View.VISIBLE) {
                    line1.setVisibility(View.GONE);
                }
            }
        }
    }
    
    /**
     * 设置左二按钮图标
     *
     * @param resId
     */
    protected void setLeftTwoImagePic(int resId) {
        if (leftTwoImage != null) {
            leftTwoImage.setImageResource(resId);
        }
    }
    
    /**
     * 设置右一按钮是否显示
     *
     * @param visible
     */
    protected void setRightOneImageVisibity(boolean visible) {
        if (rightOneImage != null) {
            if (visible) {
                if (rightTextView.getVisibility() == View.VISIBLE) {
                    line3.setVisibility(View.VISIBLE);
                }
                if (rightTwoImage.getVisibility() == View.VISIBLE) {
                    line2.setVisibility(View.VISIBLE);
                }
                rightOneImage.setVisibility(View.VISIBLE);
            } else {
                rightOneImage.setVisibility(View.GONE);
                if (rightTextView.getVisibility() == View.VISIBLE) {
                    line3.setVisibility(View.GONE);
                } else {
                    if (rightTwoImage.getVisibility() == View.VISIBLE) {
                        line2.setVisibility(View.GONE);
                    }
                }
            }
        }
    }
    
    /**
     * 设置右一按钮图标
     *
     * @param resId
     */
    protected void setRightOneImagePic(int resId) {
        if (rightOneImage != null) {
            rightOneImage.setImageResource(resId);
        }
    }
    
    /**
     * 设置右二按钮是否显示
     *
     * @param visible
     */
    protected void setRightTwoImageVisibity(boolean visible) {
        if (rightTwoImage != null) {
            if (visible) {
                if (rightOneImage.getVisibility() == View.VISIBLE
                        || rightTextView.getVisibility() == View.VISIBLE) {
                    line2.setVisibility(View.VISIBLE);
                } else {
                    line2.setVisibility(View.GONE);
                }
                rightTwoImage.setVisibility(View.VISIBLE);
            } else {
                rightTwoImage.setVisibility(View.GONE);
                line2.setVisibility(View.GONE);
            }
        }
    }
    
    /**
     * 设置右二按钮图标
     *
     * @param resId
     */
    protected void setRightTwoImagePic(int resId) {
        if (rightTwoImage != null) {
            rightTwoImage.setImageResource(resId);
        }
    }
    
    /**
     * 设置右侧TextView文字
     *
     * @param c
     */
    protected void setRightTextViewText(CharSequence c) {
        if (rightTextView != null)
            rightTextView.setText(c);
    }
    
    /**
     * 设置右侧TextView文字
     *
     * @param resId
     */
    protected void setRightTextViewText(int resId) {
        if (rightTextView != null)
            rightTextView.setText(resId);
    }
    
    /**
     * 设置右侧TextView文字颜色
     *
     * @param res
     */
    protected void setRightTextViewTextColor(int res) {
        if (rightTextView != null) {
            rightTextView.setTextColor(res);
        }
    }
    
    /**
     * 设置右侧TextView文字颜色
     *
     * @param colorStateList
     */
    protected void setRightTextViewTextColor(ColorStateList colorStateList) {
        if (rightTextView != null) {
            rightTextView.setTextColor(colorStateList);
        }
    }
    
    /**
     * 设置右侧TextView文字颜色大小
     *
     * @param size sp
     */
    protected void setRightTextViewTextSize(float size) {
        if (rightTextView != null) {
            rightTextView.setTextSize(size);
        }
    }
    
    /**
     * 设置右侧TextView文字颜色大小
     *
     * @param unit
     * @param size
     */
    protected void setRightTextViewTextSize(int unit, float size) {
        if (rightTextView != null) {
            rightTextView.setTextSize(unit, size);
        }
    }
    
    /**
     * 设置右侧TextView是否显示
     *
     * @param visible
     */
    protected void setRightTextViewVisibity(boolean visible) {
        if (rightTextView != null) {
            if (visible) {
                rightTextView.setVisibility(View.VISIBLE);
                if (rightOneImage.getVisibility() == View.VISIBLE) {
                    line3.setVisibility(View.VISIBLE);
                } else {
                    line3.setVisibility(View.GONE);
                }
                
            } else {
                rightTextView.setVisibility(View.GONE);
                line3.setVisibility(View.GONE);
            }
        }
    }
    
    /**
     * 左一按钮点击事件
     */
    protected void leftOneImageOnClick() {
        
        finish();
        //隐藏键盘
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && getCurrentFocus() != null) {
            if (getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        
        }
    }
    
    /**
     * 左二按钮点击事件
     */
    protected void leftTwoImageOnClick() {
    }
    
    /**
     * 右一按钮点击事件
     */
    protected void rightOneImageOnClick() {
    }
    
    /**
     * 右侧TextView的点击事件
     */
    protected void rightTextViewOnClick() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && getCurrentFocus() != null) {
            if (getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        
        }
    }
    
    /**
     * 右二按钮点击事件
     */
    protected void rightTwoImageOnClick() {
    }
    
    public LinearLayout getRoot() {
        return llRoot;
    }
    
    /**
     * 如果是以 " . " 开头的, 在前面加个 0
     *
     * @param string
     * @return
     */
    public String startWithPoint(String string) {
        if (string.startsWith(".")) {
            string = "0" + string;
        }
        return string;
    }
    
}
