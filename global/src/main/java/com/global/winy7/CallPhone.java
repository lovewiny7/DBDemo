package com.global.winy7;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.global.winy7.hipermission.HiPermission;
import com.global.winy7.hipermission.PermissionCallback;
import com.global.winy7.view.customalert.AlertListener;
import com.global.winy7.view.customalert.CustomAlert;
import com.global.winy7.view.customalert.bean.AlertBean;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.ToastUtil;


import static android.Manifest.permission.CALL_PHONE;

/**
 * <pre>
 *     desc   : 电话
 *     author : winy7
 *     time   : 2019/09/05
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class CallPhone {
    /**
     * //调用系统电话
     *
     * @param mContext mContext
     * @param phone    phone
     */
    public static void Call(Activity mContext, String phone) {
        HiPermission.create(mContext).checkSinglePermission(CALL_PHONE, new PermissionCallback() {
            @Override
            public void onClose() {
            
            }
            
            @Override
            public void onFinish() {
            }
            
            @Override
            public void onDeny(String permission, int position) {
                ToastUtil.showToast(mContext, "请开启电话权限");
            }
            
            @Override
            public void onGuarantee(String permission, int position) {
                LogUtil.e(mContext, "----onGuarantee------->");
                
                CustomAlert.createCenterCustWidth(mContext, new AlertBean("即将拨打", phone, "确定", "取消"), new AlertListener() {
                    @Override
                    public void alertOk() {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + phone));
                        //开启系统拨号器
                        mContext.startActivity(intent);
                    }
                    
                    @Override
                    public void alertCancle() {
                    
                    }
                }, 0.8);
                
                
            }
        });
        
        
    }
}
