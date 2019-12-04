package com.global.winy7.viewutil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/06/17
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class SoftBoradUtil {
    
    /**
     * //销毁弹框同时收起软键盘
     *
     * @param context    当前上下文
     * @param dialog     当前弹框
     * @param window     当前窗口
     * @param passLayout 控件
     */
    private static void dismissDialog(Context context, AlertDialog dialog, Window window, View passLayout) {
        //销毁软键盘
        window.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(passLayout.getWindowToken(), 0);
        
        dialog.dismiss();
    }
    
    
    /**
     * 隐藏键盘
     *
     * @param window 当前窗口
     */
    
    public static void hiddenKeyBoard(Window window) {
        
        //        // 自动弹出输入法
        window.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        window.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
    }
    
    
    /**
     * 自动展示键盘
     *
     * @param window 当前窗口
     */
    
    public static void autoShowKeyBoard(Window window) {
        
        //        // 自动弹出输入法
        window.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        window.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        
    }
    
    /**
     * 页面结束收起软键盘*
     */
    
    public static void hideSoftInput(Activity activity, View editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
    
    /**
     * 页面结束收起软键盘
     */
    
    public static void hideSoftInput(Activity activity) {
        
        
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && activity.getCurrentFocus() != null) {
            if (activity.getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
            
        }
    }
    
    
    /**
     * 隐藏或显示软键盘
     * 如果现在是显示调用后则隐藏 反之则显示
     *
     * @param activity
     */
    public static void showORhideSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
    
    /**
     * 强制显示软键盘
     *
     * @param activity
     */
    public static void showSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(activity.getWindow().getDecorView(), InputMethodManager.SHOW_FORCED);
    }
    
    /**
     * 强制隐藏软键盘
     *
     * @param activity
     */
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0); //强制隐藏键盘
    }
    
    /**
     * 调用系统方法 强制隐藏软键盘
     *
     * @param activity
     */
    public static void hideSystemSoftKeyboard(Activity activity) {
        ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
    
    /**
     * 判断软键盘是否显示方法
     *
     * @param activity
     * @return
     */
    
    public static boolean isSoftShowing(Activity activity) {
        //获取当屏幕内容的高度
        int screenHeight = activity.getWindow().getDecorView().getHeight();
        //获取View可见区域的bottom
        Rect rect = new Rect();
        //DecorView即为activity的顶级view
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        //考虑到虚拟导航栏的情况（虚拟导航栏情况下：screenHeight = rect.bottom + 虚拟导航栏高度）
        //选取screenHeight*2/3进行判断
        return screenHeight * 2 / 3 > rect.bottom + getSoftButtonsBarHeight(activity);
    }
    
    /**
     * 底部虚拟按键栏的高度
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static int getSoftButtonsBarHeight(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        //这个方法获取可能不是真实屏幕的高度
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int usableHeight = metrics.heightPixels;
        //获取当前屏幕的真实高度
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        int realHeight = metrics.heightPixels;
        if (realHeight > usableHeight) {
            return realHeight - usableHeight;
        } else {
            return 0;
        }
    }
    
    public boolean softsShow(Activity activity) {
        final boolean[] isShow = new boolean[1];
        //获取当前屏幕内容的高度
        int screenHeight = activity.getWindow().getDecorView().getHeight();
        activity.getWindow().getDecorView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                //获取View可见区域的bottom
                Rect rect = new Rect();
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                if (bottom != 0 && oldBottom != 0 && bottom - rect.bottom <= 0) {
//                    Toast.makeText(Main3Activity.this, "隐藏", Toast.LENGTH_SHORT).show();
                    isShow[0] = false;
                } else {
//                    Toast.makeText(Main3Activity.this, "弹出", Toast.LENGTH_SHORT).show();
                    isShow[0] = true;
                }
            }
        });
        return isShow[0];
    }
    
    
    public static int getStatusBarHeight(Activity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
