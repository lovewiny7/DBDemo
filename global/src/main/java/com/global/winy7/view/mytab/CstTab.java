package com.global.winy7.view.mytab;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.global.R;
import com.global.winy7.view.CustomTextView.RTextView;

import java.util.List;

/**
 * 自定义Tab 可修改Title字体、颜色
 * Created By Caoqi on 2019/5/17  上午10:40
 */
public class CstTab extends TabLayout {
    
    
    public CstTab(Context context) {
        super(context);
    }
    
    public CstTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public CstTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    //初始化Fragment添加到viewPager中
    public static void initViewPager(FragmentManager fm, ViewPager viewPager, final List<Fragment> fragments) {
        viewPager.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }
            
            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        
    }
    
    /***
     *
     * @param mContext      上下文
     * @param tabTitles     标题
     * @param tabIcons      图标
     * @param myTab         Tab控件
     */
    public static void initCstTab(Context mContext, List<String> tabTitles, List<Integer> tabIcons, List<Integer> tabIconsUnselected,
                                  final int textColor, final int textSelectColor, TabLayout myTab) {
        for (int i = 0; i < tabTitles.size(); i++) {
            Tab tab = myTab.getTabAt(i);
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_tab, null);
            RTextView textView = view.findViewById(R.id.tab_item_textview);
            //修改字体大小
            textView.setText(tabTitles.get(i));
            
            if (i == 0) {
                textView.setIconNormal(tabIcons.get(i)).setTextColor(textSelectColor);
            } else {
                textView.setIconNormal(tabIconsUnselected.get(i)).setTextColor(textColor);
            }
            if (tab != null) {
                tab.setCustomView(view);
                
            }
//            去掉tab点击效果
            LinearLayout layout = tab.view;
            layout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.transparent));
            
            
        }
        //点击事件
        myTab.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                View view = tab.getCustomView();
                if (view != null && view instanceof TextView) {
                    ((RTextView) view).setIconNormal(tabIcons.get(tab.getPosition())).setTextColor(textSelectColor);
                    
                }
            }
            
            @Override
            public void onTabUnselected(Tab tab) {
                View view = tab.getCustomView();
                if (view != null && view instanceof TextView) {
                    ((RTextView) view).setIconNormal(tabIconsUnselected.get(tab.getPosition())).setTextColor(textColor);
                }
            }
            
            @Override
            public void onTabReselected(Tab tab) {
            
            }
        });
    }
    
    /**
     * 可动态修改item文字大小
     *
     * @param mContext
     * @param tabTitles 标题
     * @param myTab     Tab控件
     * @param textColor 默认字体颜色
     * @param textSize  默认字体大小
     */
    public static void initCstTab(final Context mContext, List<String> tabTitles, TabLayout myTab, final int textColor, final int textSelectColor, final float textSize) {
        for (int i = 0; i < myTab.getTabCount(); i++) {
            myTab.setTabGravity(GRAVITY_FILL);
            myTab.setTabMode(MODE_SCROLLABLE);
            myTab.setTabIndicatorFullWidth(false);
            Tab tab = myTab.getTabAt(i);
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_tab, null);
            TextView textView = (TextView) view.findViewById(R.id.tab_item_textview);
            //修改字体大小
            textView.setTextColor(mContext.getResources().getColor(textColor));
            textView.setText(tabTitles.get(i));
            if (i == 0) {
                textView.setTextSize(textSize + 4);
            }
            if (tab != null) {
                tab.setCustomView(view);
                
            }
        }
        
        myTab.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                View view = tab.getCustomView();
                if (view != null && view instanceof TextView) {
                    ((TextView) view).setTextSize(textSize + 4f);
                    ((TextView) view).setTextColor(mContext.getResources().getColor(textSelectColor));
                }
            }
            
            @Override
            public void onTabUnselected(Tab tab) {
                View view = tab.getCustomView();
                if (view != null && view instanceof TextView) {
                    ((TextView) view).setTextSize(textSize);
                    ((TextView) view).setTextColor(mContext.getResources().getColor(textColor));
                }
            }
            
            @Override
            public void onTabReselected(Tab tab) {
            
            }
        });
        
        
    }
    
    
}
