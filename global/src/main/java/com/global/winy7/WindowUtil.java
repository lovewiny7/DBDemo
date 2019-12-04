package com.global.winy7;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;

/**
 * <pre>
 *     desc   : 处理屏幕的相关方法
 *     author : winy7
 *     time   : 2019/09/26
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class WindowUtil {
    
    /**
     * 获取状态栏高度
     *
     * @param activity
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    
    /**
     * 获取 屏幕宽度
     *
     * @param activity
     * @return
     */
    public static int getScreenWidth(Activity activity) {
        
        WindowManager wm = activity.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        return width;
    }
    
    
    /**
     * 获取 屏幕高度
     *
     * @param activity
     * @return
     */
    public static int getScreenHeight(Activity activity) {
        
        WindowManager wm = activity.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int height = point.y;
        return height;
    }
    
    /**
     * 获取 高度（去除状态栏）
     *
     * @param activity
     * @return
     */
    public static int getSubHeight(Activity activity) {
        
        return getScreenHeight(activity) - getStatusBarHeight(activity);
    }
}
