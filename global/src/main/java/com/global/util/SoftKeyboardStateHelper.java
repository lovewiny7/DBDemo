package com.global.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;

import java.util.LinkedList;
import java.util.List;

/**
 * 判断软键盘的打开和收起事件
 * 作者：Laughing on 2019-3-13 17:38
 * 邮箱：719240226@qq.com
 */
public class SoftKeyboardStateHelper implements ViewTreeObserver.OnGlobalLayoutListener {
    
    public interface SoftKeyboardStateListener {
        void onSoftKeyboardOpened(int keyboardHeightInPx);
        
        void onSoftKeyboardClosed();
    }
    
    private final List<SoftKeyboardStateListener> listeners = new LinkedList<SoftKeyboardStateListener>();
    private final View activityRootView;
    private int lastSoftKeyboardHeightInPx;
    private boolean isSoftKeyboardOpened;
    
    public SoftKeyboardStateHelper(View activityRootView) {
        this(activityRootView, false);
    }
    
    public SoftKeyboardStateHelper(View activityRootView, boolean isSoftKeyboardOpened) {
        this.activityRootView = activityRootView;
        this.isSoftKeyboardOpened = isSoftKeyboardOpened;
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
    
    @Override
    public void onGlobalLayout() {
        final Rect r = new Rect();
        //r will be populated with the coordinates of your view that area still visible.
        activityRootView.getWindowVisibleDisplayFrame(r);
        
        final int heightDiff = activityRootView.getRootView().getHeight() - (r.bottom - r.top);
        if (!isSoftKeyboardOpened && heightDiff > 100) { // if more than 100 pixels, its probably a keyboard...
            isSoftKeyboardOpened = true;
            notifyOnSoftKeyboardOpened(heightDiff);
        } else if (isSoftKeyboardOpened && heightDiff < 100) {
            isSoftKeyboardOpened = false;
            notifyOnSoftKeyboardClosed();
        }
    }
    
    public void setIsSoftKeyboardOpened(boolean isSoftKeyboardOpened) {
        this.isSoftKeyboardOpened = isSoftKeyboardOpened;
    }
    
    public boolean isSoftKeyboardOpened() {
        return isSoftKeyboardOpened;
    }
    
    /**
     * Default value is zero (0)
     *
     * @return last saved keyboard height in px
     */
    public int getLastSoftKeyboardHeightInPx() {
        return lastSoftKeyboardHeightInPx;
    }
    
    public void addSoftKeyboardStateListener(SoftKeyboardStateListener listener) {
        listeners.add(listener);
    }
    
    public void removeSoftKeyboardStateListener(SoftKeyboardStateListener listener) {
        listeners.remove(listener);
    }
    
    private void notifyOnSoftKeyboardOpened(int keyboardHeightInPx) {
        this.lastSoftKeyboardHeightInPx = keyboardHeightInPx;
        
        for (SoftKeyboardStateListener listener : listeners) {
            if (listener != null) {
                listener.onSoftKeyboardOpened(keyboardHeightInPx);
            }
        }
    }
    
    private void notifyOnSoftKeyboardClosed() {
        for (SoftKeyboardStateListener listener : listeners) {
            if (listener != null) {
                listener.onSoftKeyboardClosed();
            }
        }
    }
    
    /**
     * @param context,view 页面销毁收起软键盘
     *                     finish（）前调用
     */
    public static void hideSoftKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    
    public static void hideSoftKeyboard(Activity activity) {
        /**页面结束收起软键盘**/
        
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && activity.getCurrentFocus() != null) {
            if (activity.getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
            
        }
    }
    
    
}
