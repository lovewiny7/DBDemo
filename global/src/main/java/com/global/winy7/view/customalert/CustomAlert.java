package com.global.winy7.view.customalert;


import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.global.R;
import com.global.databinding.AlertOkCancleBinding;
import com.global.winy7.view.customalert.bean.AlertBean;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.ResourceHelper;

/**
 * <pre>
 *     desc   : 自定义弹框
 *     author : winy7
 *     time   : 2019/09/02
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class CustomAlert {
    
    /**
     *  默认弹框 居中 宽度自定义
     * @param context  上下文 
     * @param data     实体类 包括文字头，确认、取消文字设置
     * @param listener 点击事件
     */
    public static void create(Activity context, AlertBean data, AlertListener listener) {
        
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        /**
         * 普通方式初始化
         */
//        AlertDialog dialog = builder.setView(R.layout.alert_ok_cancle).create();
//        dialog.show();
//        Window window = dialog.getWindow();
//
//        TextView title = window.findViewById(R.id.tv_title);
//        TextView cancle = window.findViewById(R.id.tv_cancel);
//        TextView ok = window.findViewById(R.id.tv_ok);
//        title.setText(data.getTitle());
//        cancle.setText(data.getCancle());
//        ok.setText(data.getOk());
//        //确定
//        ok.setOnClickListener(v -> {
//            listener.alertOk();
//            dialog.dismiss();
//        });
//        //取消
//        cancle.setOnClickListener(v -> {
//            listener.alertCancle();
//            dialog.dismiss();
//        });
    
        /**
         *  
         * DataBinding初始化
         */
        View view = LayoutInflater.from(context).inflate(R.layout.alert_ok_cancle, null);
        AlertDialog dialog = builder.setView(view).create();
       
        AlertOkCancleBinding bind = DataBindingUtil.bind(view.getRootView());
        bind.setViewModel(data);
        bind.setClick(v -> {
            if (v.getId() == R.id.tv_ok) {
                listener.alertOk();
            } else if (v.getId() == R.id.tv_cancel) {
                listener.alertCancle();
            }
            dialog.dismiss();
        });
        dialog.show();
        WindowManager wm = context.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        int height = point.y;
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width= (int) (width*(0.8)); //弹框宽度百分比
    
        window.setBackgroundDrawableResource(R.color.transparent); //弹框背景色设置透明，否则圆角四周会有白色
        window.setAttributes(attributes);
    }
    
    
    /**
     *  默认弹框 居中 宽度自定义
     * @param context  上下文
     * @param data     实体类 包括文字头，确认、取消文字设置
     * @param listener 点击事件
     * @param widthRadio  宽度百分比
     */
    public static void createCenterCustWidth(Activity context, AlertBean data, AlertListener listener, double widthRadio) {
        
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        /**
         * 普通方式初始化
         */
//        AlertDialog dialog = builder.setView(R.layout.alert_ok_cancle).create();
//        dialog.show();
//        Window window = dialog.getWindow();
//
//        TextView title = window.findViewById(R.id.tv_title);
//        TextView cancle = window.findViewById(R.id.tv_cancel);
//        TextView ok = window.findViewById(R.id.tv_ok);
//        title.setText(data.getTitle());
//        cancle.setText(data.getCancle());
//        ok.setText(data.getOk());
//        //确定
//        ok.setOnClickListener(v -> {
//            listener.alertOk();
//            dialog.dismiss();
//        });
//        //取消
//        cancle.setOnClickListener(v -> {
//            listener.alertCancle();
//            dialog.dismiss();
//        });
        
        /**
         *
         * DataBinding初始化
         */
        View view = LayoutInflater.from(context).inflate(R.layout.alert_ok_cancle, null);
        AlertDialog dialog = builder.setView(view).create();
        
        AlertOkCancleBinding bind = DataBindingUtil.bind(view.getRootView());
        bind.setViewModel(data);
        bind.setClick(v -> {
            if (v.getId() == R.id.tv_ok) {
                listener.alertOk();
            } else if (v.getId() == R.id.tv_cancle) {
                listener.alertCancle();
            }
            dialog.dismiss();
        });
        dialog.show();
        
        WindowManager wm = context.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        int height = point.y;
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width= (int) (width*(widthRadio)); //弹框宽度百分比
        window.setBackgroundDrawableResource(R.color.transparent);
        window.setAttributes(attributes);
        
    }
    
    /**
     *  单个确定按钮弹框
     * @param context context
     * @param data   data
     * @param listener listener
     */
    public static void creatSingleOk(Activity context, AlertBean data, AlertListener listener) {
        
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        /**
         *
         * DataBinding初始化
         */
        View view = LayoutInflater.from(context).inflate(R.layout.alert_ok_cancle, null);
        AlertDialog dialog = builder.setView(view).create();
        AlertOkCancleBinding bind = DataBindingUtil.bind(view.getRootView());
        bind.setViewModel(data);
        bind.tvOk.setCornerRadius(0,0,
                ResourceHelper.getDimens(R.dimen.dialog_radius), //左下角弧度 与弹框弧度一致
                ResourceHelper.getDimens(R.dimen.dialog_radius));//右下角弧度 与弹框弧度一致
        bind.tvCancel.setVisibility(View.GONE);
        bind.setClick(v -> {
            if (v.getId() == R.id.tv_ok) {
                listener.alertOk();
            }
            dialog.dismiss();
        });
        dialog.show();
    
        WindowManager wm = context.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        int height = point.y;
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width= (int) (width*(0.6)); //弹框宽度百分比
        window.setBackgroundDrawableResource(R.color.transparent);
        window.setAttributes(attributes);
    }
    
    /**
     *   // 底部全屏
     * @param activity
     * @param view
     * @return
     */
   
    public static AlertDialog bottomDialog(Activity activity, View view) {
        
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setView(view);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
        WindowManager wm = activity.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        int height = point.y;
        Window window = alertDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width=width;
        window.setBackgroundDrawableResource(R.color.white);
        window.setAttributes(attributes);
        return alertDialog;
    }
    
    
    
    // 顶部全屏
    public static AlertDialog topDialog(Activity activity, View view) {
        
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setView(view);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
        WindowManager wm = activity.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        int height = point.y;
        Window window = alertDialog.getWindow();
        window.setGravity(Gravity.TOP);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width=width;
        window.setBackgroundDrawableResource(R.color.white);
        window.setAttributes(attributes);
        return alertDialog;
    }
    
    // 顶部全屏
    public static AlertDialog topDialogNormal(Activity activity, View view) {
        //引入自定义的样式
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity,R.style.dialog_parent);
    
        dialog.setCancelable(true); //dialog弹出后会点击屏幕或物理返回键，dialog不消失
        dialog.setView(view);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
        WindowManager wm = activity.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        int height = point.y;
        Window window = alertDialog.getWindow();
//        window.setGravity(Gravity.TOP);
//        WindowManager.LayoutParams attributes = window.getAttributes();
//        attributes.width=width;
//        window.setBackgroundDrawableResource(R.color.white);
//        window.setAttributes(attributes);
        
        WindowManager.LayoutParams wl=window.getAttributes();
        float x = view.getX();
        float y = view.getY();
        LogUtil.e("CAO","----------->"+x+"y"+y);
        wl.x= 500;
        wl.y= 600;
        //设置显示位置
        alertDialog.onWindowAttributesChanged(wl);
        return alertDialog;
    }
    
    
    // 指定控件之下
    public static AlertDialog DialogbelowView(Activity activity, View view,View view1) {
        //引入自定义的样式
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity,R.style.dialog_parent);
        
        dialog.setCancelable(true); //dialog弹出后会点击屏幕或物理返回键，dialog不消失
        dialog.setView(view);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
        WindowManager wm = activity.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
//        int width = point.x;
//        int height = point.y;
        Window window = alertDialog.getWindow();
        window.setGravity(Gravity.TOP);
//        WindowManager.LayoutParams attributes = window.getAttributes();
//        attributes.width=width;
//        window.setBackgroundDrawableResource(R.color.white);
//        window.setAttributes(attributes);
        
//        WindowManager.LayoutParams wl=window.getAttributes();
//        float x = view1.getX();
//        float y = view1.getTop();
//        LogUtil.e("CAO","----------->"+x+"y----"+y);
//        wl.x= (int) x-10;
//        wl.y= (int) y;
//        //设置显示位置
//        alertDialog.onWindowAttributesChanged(wl);
        return alertDialog;
    }
    
    /**
     *
     * @param activity
     * @param view  布局
     * @param ratio 宽度系数
     * @return
     */
    
    public static AlertDialog centerDialog(Activity activity, View view, double ratio) {
        
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setView(view);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
        WindowManager wm = activity.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        int height = point.y;
        Window window = alertDialog.getWindow();
        window.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width=(int) (width*ratio);
        window.setBackgroundDrawableResource(R.color.white);
        window.setAttributes(attributes);
        return alertDialog;
    }
}
