package com.global.winy7.viewutil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/06/20
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class JumpActivityUtil {
    
    /**
     * 页面跳转（反射，不带参数）
     *
     * @param context   上下文
     * @param className 类名
     */
    
    
    public static void WithOutDataByReflex(Context context, String className) {
        try {
            context.startActivity(new Intent(context, Class.forName(className)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 页面跳转
     *
     * @param context   上下文
     * @param className 类
     */
    
    public static void WithOutData(Context context, Class className) {
        
        Intent intent = new Intent(context, className);
        context.startActivity(intent);
    }
    
    
    /**
     * 页面跳转（string）
     *
     * @param context   上下文
     * @param className 类
     * @param key       键
     * @param value     值
     */
    
    public static void WithData(Context context, Class className, String key, String value) {
        
        Intent intent = new Intent(context, className);
        intent.putExtra(key, value);
        context.startActivity(intent);
    }
    
    /**
     * 页面跳转（string）
     *
     * @param context   上下文
     * @param className 类
     * @param key       键
     * @param value     值
     */
    
    public static void WithDataForResult(Activity context, Class className, String key, String value) {
        
        Intent intent = new Intent(context, className);
        intent.putExtra(key, value);
        context.startActivityForResult(intent, 0);
    }
    
    public static void ForResultByReflex(Activity context, String className, String key, String value) {
        
        
        try {
            Intent intent = new Intent(context, Class.forName(className));
            intent.putExtra(key, value);
            context.startActivityForResult(intent, 0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    
    public static void ForResultByReflex(Activity context, String className, String key, boolean value) {
        
        
        try {
            Intent intent = new Intent(context, Class.forName(className));
            intent.putExtra(key, value);
            context.startActivityForResult(intent, 0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void ForResultByReflex(Activity context, String className, String key, Serializable value) {
        
        
        try {
            Intent intent = new Intent(context, Class.forName(className));
            intent.putExtra(key, value);
            context.startActivityForResult(intent, 0);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    /**
     * 页面跳转（int）
     *
     * @param context   上下文
     * @param className 类
     * @param key       键
     * @param value     值
     */
    
    public static void WithData(Context context, Class className, String key, int value) {
        
        Intent intent = new Intent(context, className);
        intent.putExtra(key, value);
        context.startActivity(intent);
    }
    
    /**
     * 页面跳转（boolean）
     *
     * @param context   上下文
     * @param className 类
     * @param key       键
     * @param value     值
     */
    
    public static void WithData(Context context, Class className, String key, boolean value) {
        
        Intent intent = new Intent(context, className);
        intent.putExtra(key, value);
        context.startActivity(intent);
    }
    
    
    /**
     * 页面跳转（Serializable Bean）
     *
     * @param context   上下文
     * @param className 类
     * @param key       键
     * @param bean      实体类
     */
    
    public static void WithData(Context context, Class className, String key, Serializable bean) {
        
        Intent intent = new Intent(context, className);
        intent.putExtra(key, bean);
        context.startActivity(intent);
    }
}
