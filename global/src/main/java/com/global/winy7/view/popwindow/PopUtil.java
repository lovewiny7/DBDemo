package com.global.winy7.view.popwindow;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.global.R;
import com.global.bean.Parking;
import com.global.listener.ItemClickListener;
import com.global.ui.adapter.Adapter_List_For_Popup_Window;
import com.waterbase.ui.BaseApplication;
import com.waterbase.utile.ToastUtil;
import com.waterbase.widget.recycleview.RecycleViewDivider;

import java.util.ArrayList;

/**
 * <pre>
 *     desc   : popupWindow 工具类
 *     author : winy7
 *     time   : 2019/09/11
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class PopUtil {
    
    /***
     *  列表弹窗
     * @param activity
     * @param parent
     * @param contents
     */
    public static void showListPopupWindow(@NonNull Activity activity, View parent, ArrayList<String> contents) {
//        if (TextUtils.isEmpty(content)) {
        if (contents == null) {
            return;
        }
        View popup_window_list = activity.getLayoutInflater().inflate(R.layout.popup_window_list, null);
        
        
        RecyclerView recyclerView = popup_window_list.findViewById(R.id.rv_parking_names);
        LinearLayout ll_popup_content = popup_window_list.findViewById(R.id.ll_popup_content);

//        tvContent.setText(content);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        PopAdapter adapter = new PopAdapter();
//        添加默认分割线
        recyclerView.addItemDecoration(new RecycleViewDivider(activity, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setData(contents);
        adapter.setItemClickListener(new ItemClickListener<String>() {
            @Override
            public void itemClick(View v, String item, int index) {
                ToastUtil.showToast(activity, "click--->" +item);
            }
        });
        
        PopupWindow popupWindow = new PopupWindow(ll_popup_content, ViewGroup.LayoutParams.MATCH_PARENT,  ViewGroup.LayoutParams.MATCH_PARENT, true);
        
        popupWindow.setContentView(popup_window_list);
        
        
        // 设置PopupWindow可点击
        popupWindow.setTouchable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
//        popupWindow.setBackgroundDrawable(new ColorDrawable(ResUtils.getColor(R.color.half_transparent)));
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.argb(128, 0, 0, 0)));
        
        
        popup_window_list.setOnClickListener(v -> {
            popupWindow.dismiss();
            setArrow((TextView) parent, R.mipmap.icon_qx_down);
        });
        setArrow((TextView) parent, R.mipmap.icon_qx_up);
        // PopupWindow的显示及位置设置
//        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        popupWindow.showAsDropDown(parent, Gravity.BOTTOM, 0, 0);
        
    }
    
    /**
     * 设置箭头
     *
     * @param arrowIcon 箭头图标
     */
    public static void setArrow(TextView textView, @DrawableRes int arrowIcon) {
        Drawable drawable = null;
        if (arrowIcon != 0) {
//            drawable = ResUtils.getDrawable(arrowIcon);
            drawable = AppCompatResources.getDrawable(BaseApplication.getAppContext(), arrowIcon);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        textView.setCompoundDrawables(null, null, drawable, null);
    }
}
