package com.global.winy7.broadcastutil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * <pre>
 *     desc   : 广播
 *     author : winy7
 *     time   : 2019/06/13
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class BCUtil {
    
    private static String action;
    public static String ADD_ADDRESS = "ADD_ADDRESS";   // 新增地址
    public static String DEL_ADDRESS = "DEL_ADDRESS";   // 删除地址
    public static String EDIT_ADDRESS = "EDIT_ADDRESS"; // 修改地址
    
    public static void initBCUtil(String action) {
        BCUtil.action = action;
    }
    
    public static Intent sendBroadcastIntent() {
        
        Intent intent = new Intent();
        intent.setAction(action);
        return intent;
    }
    
    
    private class myBroadcastReceiver extends BroadcastReceiver {
    
    
        @Override
        public void onReceive(Context context, Intent intent) {
        
        }
    }
    
    public static IntentFilter getBroadcastIntent() {
        
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        return intentFilter;
    }
}
