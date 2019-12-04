package com.global.winy7.viewutil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.global.R;
import com.global.winy7.view.CustomTextView.RTextView;
import com.waterbase.utile.StrUtil;

/**
 * <pre>
 *     desc   : 布局调整
 *     author : winy7
 *     time   : 2019/06/12
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class ViewSettingUtil {
    
//    private static Context context;
//    private static Activity activity;
    public static int totalSecond =60;
    
//    public static void initViewUtil(Context mContext) {
//
//        context = mContext;
//
//    }
//
//    public static void initViewUtil(Activity mContext) {
//        activity = mContext;
//
//    }
    
    /**
     * 获取状态栏高度
     */
    
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    
    /**
     * 获取屏幕栏高度
     */
    
    public static int getWindowHeight(Activity activity) {
        
        WindowManager wm = activity.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int height = point.y;
        return height;
    }
    
    /**
     * 获取屏幕栏宽度
     */
    public static int getWindowWidth(Activity activity) {
        
        WindowManager wm = activity.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        return width;
    }
    
    /**
     * 设置控件Margin间距
     *
     * @param view   被调整的View
     * @param left   左边距
     * @param top    上边距
     * @param right  右边距
     * @param bottom 下边距
     */
    
    public static void setViewMargin(View view, int left, int top, int right, int bottom) {
//        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(view.getLayoutParams());
//        lp.setMargins(left, top, right, bottom);
//        view.setLayoutParams(lp);
        
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            lp.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
        
        
    }
    
    /**
     *  间隔几秒切换布局
     * @param view
     * @param context
     */
    public static void changeViewEverySecond(RTextView view, Context context) {
        if (StrUtil.tvGetTextTrim(view).equals("重新发送")) {
            totalSecond = 5;
        }
        view.setClickable(false);
        view.setBackgroundColorNormal(context.getResources().getColor(R.color.grey_3));
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
    
                view.setText("重新发送(" + totalSecond + "s)");
                totalSecond--;
                /**每隔几秒执行代码*/
                handler.postDelayed(this, 1000);
                if (totalSecond == -1) {
//                    timer.cancel();
                    view.setText("重新发送");
                    view.setClickable(true);
                    handler.removeCallbacks(this);
                    view.setBackgroundColorNormal(context.getResources().getColor(R.color.orange));
                }
            
            }
        };
        handler.post(runnable);
    }
}
