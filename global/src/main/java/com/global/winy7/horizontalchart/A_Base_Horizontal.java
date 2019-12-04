package com.global.winy7.horizontalchart;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.WindowManager;

import com.global.R;
import com.global.databinding.AHorizontalBinding;
import com.global.ui.activity.TitleActivity;
import com.global.winy7.horizontalchart.adapter.HorizontalAdapter;
import com.global.winy7.horizontalchart.bean.HorizontalData;
import com.waterbase.utile.LogUtil;

import java.util.ArrayList;

public class A_Base_Horizontal extends TitleActivity {
    
    private AHorizontalBinding mBinding;
    private HorizontalAdapter mAdapter;
    private ArrayList<HorizontalData> horizontalData;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = setView(R.layout.a_horizontal);
        //  mBinding = DataBindingUtil.setContentView(this, R.layout.demo);
        initTitle();
        initView();
        initData();
        initListener();
        
    }
    
    public ArrayList<HorizontalData> getHorizontalData() {
        return horizontalData;
    }
    
    public void setHorizontalData(ArrayList<HorizontalData> horizontalData) {
        this.horizontalData = horizontalData;
    }
    
    public void initListener() {
    
    }
    
    public void initView() {
    
    }
    
    public void initData() {
        
        
        // 获取集合中的最大值
        ArrayList<Float> floats = new ArrayList<>();
        for (HorizontalData data : horizontalData) {
            floats.add(data.getItemData());
        }
        float max = GetMaxValues.getMax(floats);
        LogUtil.e("CAO", "----max------->" + max);
        // 初始化Adapt数据
        mAdapter = new HorizontalAdapter(getWidth(), max);
        mBinding.rvData.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvData.setAdapter(mAdapter);
        
        
        
    }
    
    
    public int getWidth() {
        
        WindowManager wm = this.getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        int width = point.x;
        int height = point.y;
        return width;
    }
    
    public void initTitle() {
    
    }
    
    
    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setData(horizontalData);
    }
}
