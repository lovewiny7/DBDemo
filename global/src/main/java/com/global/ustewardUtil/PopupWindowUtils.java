package com.global.ustewardUtil;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
 * PopupWindow 弹框
 * <p>
 * Created by Guangkuo on 2018/2/9.
 */
public class PopupWindowUtils {
    /**
     * 显示文本提示框
     *
     * @param activity 上下文
     * @param content  内容
     */
    public static void showTextPopupWindow(@NonNull Activity activity, View parent, String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }
        View popup_text = activity.getLayoutInflater().inflate(R.layout.popup_text, null);
        PopupWindow popupWindow = new PopupWindow(popup_text, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        // 设置PopupWindow可点击
        popupWindow.setTouchable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
//        popupWindow.setBackgroundDrawable(new ColorDrawable(ResUtils.getColor(R.color.half_transparent)));
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.argb(128, 0, 0, 0)));

        TextView tvContent = popup_text.findViewById(R.id.tvContent);
        tvContent.setText(content);
        popup_text.setOnClickListener(v -> {
            popupWindow.dismiss();
            setArrow((TextView) parent, R.mipmap.icon_qx_down);
        });
        setArrow((TextView) parent, R.mipmap.icon_qx_up);
        // PopupWindow的显示及位置设置
        popupWindow.showAtLocation(parent, Gravity.BOTTOM, 0, 0);

    }

    /**
     * Laughing:显示文本列表提示框(可以调用，因为点击item 要发送网络请求，所以，写到要使用的类中)
     *
     * @param activity 上下文
     * @param contents 集合
     */
    public static void showListPopupWindow(@NonNull Activity activity, View parent, ArrayList<Parking> contents) {
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
        Adapter_List_For_Popup_Window adapter = new Adapter_List_For_Popup_Window();
//        添加默认分割线
        recyclerView.addItemDecoration(new RecycleViewDivider(activity, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setData(contents);
        adapter.setItemClickListener(new ItemClickListener<Parking>() {
            @Override
            public void itemClick(View v, Parking parkings, int index) {
                ToastUtil.showToast(activity, "click--->" + parkings.getId());
            }
        });

        PopupWindow popupWindow = new PopupWindow(ll_popup_content, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

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
        popupWindow.showAtLocation(parent, Gravity.TOP, 0, 0);

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
