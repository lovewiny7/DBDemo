package com.waterbase.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;

import com.waterbase.R;
import com.waterbase.utile.AppManager;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * 基础的activity 实现则Retrofit生命周期的碧昂定
 * Created by Water on 2018/3/26.
 */

public class BaseActivity extends AppCompatActivity implements LifecycleProvider<ActivityEvent> {
    protected Context mContext = this;
    protected String TAG;
    protected ProgressDialog proDia;
    /**
     * 全局的LayoutInflater对象，已经完成初始化.
     */
    protected LayoutInflater mInflater;
    
    @Override
    @CallSuper
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //8.1不能使用透明主题
        if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1) {
            this.setTheme(R.style.MyAppTheme);//不透明
        } else {
            this.setTheme(R.style.MyAppThemeTranslucent);//透明主题
        }
        
        
        AppManager.getAppManager().addActivity(this);
        lifecycleSubject.onNext(ActivityEvent.CREATE);
        // 不显示标题
        getSupportActionBar().hide();
        // 设置竖屏显示
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        TAG = this.getClass().getSimpleName();
        mInflater = LayoutInflater.from(this);
        proDia = new ProgressDialog(this);
//        proDia.setTitle("正在请求网络");
        proDia.setMessage("努力加载中。。。");
        //状态栏入侵
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && isFullStatusBar()) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && isDarkStatusBar()) {
            //修改为深色，因为我们把状态栏的背景色修改为主题色白色，默认的文字及图标颜色为白色，导致看不到了。
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        
    }
    
    /**
     * 修改状态栏颜色
     *
     * @param statusColor 状态栏颜色
     * @param activity    activity
     */
    public static void setStatusBarColor(int statusColor, Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            //取消设置Window半透明的Flag
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //添加Flag把状态栏设为可绘制模式
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏为透明
            window.setStatusBarColor(statusColor);
        }
    }
    
    /**
     * 是否入侵状态栏，默认入侵
     * true 入侵
     * false 不入侵
     */
    protected boolean isFullStatusBar() {
        return true;
    }
    
    /**
     * 状态栏文字颜色修改为黑色，（默认白色）
     * true 白色
     * false 黑色
     */
    protected boolean isDarkStatusBar() {
        return false;
    }
    
    private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();
    
    @Override
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> lifecycle() {
        return lifecycleSubject.hide();
    }
    
    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }
    
    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecycleAndroid.bindActivity(lifecycleSubject);
    }
    
    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        lifecycleSubject.onNext(ActivityEvent.START);
    }
    
    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        lifecycleSubject.onNext(ActivityEvent.RESUME);
        
    }
    
    @Override
    @CallSuper
    protected void onPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
        super.onPause();
        
    }
    
    @Override
    @CallSuper
    protected void onStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP);
        super.onStop();
    }
    
    @Override
    @CallSuper
    protected void onDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }
}
