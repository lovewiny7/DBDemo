package com.global.winy7.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.global.R;

/**
 * <pre>
 *     desc   : 自定义小三角  使用方法 布局文件中直接引用，注意设置小三角位置可以直接使用 marginStart 控制
 *              需精准设置请使用@link setTriangleLocation()方法
 *     author : winy7
 *     time   : 2019/09/18
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class TriangleView extends View {
    
    private final int TOP = 0;
    private final int BOTTOM = 1;
    private final int RIGHT = 2;
    private final int LEFT = 3;
    
    /**
     * 画三角的画笔
     */
    private Paint mPaint = new Paint();
    
    /**
     * 三角的颜色
     */
    private int color = 0xFF000000;
    
    /**
     * 三角的宽度
     */
    private int width = 50;
    
    /**
     * 三角的高度
     */
    private int height = 50;
    
    /**
     * 三角的方向
     */
    private int direction = TOP;
    
    public TriangleView(Context context) {
        super(context);
    }
    
    public TriangleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TriangleView, 0, 0);
        color = a.getColor(R.styleable.TriangleView_sjv_color, color);
        width = (int) a.getDimension(R.styleable.TriangleView_sjv_resolutionWidth, width);
        height = (int) a.getDimension(R.styleable.TriangleView_sjv_resolutionHeight, height);
        direction = a.getInt(R.styleable.TriangleView_sjv_direction, direction);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        //设置画笔的颜色
        mPaint.setColor(color);
        //设置画笔抗锯齿
        mPaint.setAntiAlias(true);
        //设置画笔为实心的
        mPaint.setStyle(Paint.Style.FILL);
        //设置画笔的路径
        Path path = new Path();
        switch (direction) {
            case TOP:
                path.moveTo(0, width);
                path.lineTo(width, height);
                path.lineTo(width / 2, 0);
                break;
            case BOTTOM:
                path.moveTo(0, 0);
                path.lineTo(width / 2, height);
                path.lineTo(width, 0);
                break;
            case RIGHT:
                path.moveTo(0, 0);
                path.lineTo(0, height);
                path.lineTo(width, height / 2);
                break;
            case LEFT:
                path.moveTo(0, height / 2);
                path.lineTo(width, height);
                path.lineTo(width, 0);
                break;
        }
        
        path.close();
        canvas.drawPath(path, mPaint);
    }
    
    /**
     * @param locationView 定位的控件 如位于该控件之下
     * @param parentView   父控件 Rl ll
     * @param traView      TriangleView对象
     */
    public static void setTriangleLocation(Activity activity, View locationView, View parentView, TriangleView traView) {
        
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        
        int left = locationView.getLeft();
        int top = locationView.getTop();
        int right = locationView.getRight();
        
        //获取手机的分辨率
        Display display = activity.getWindowManager().getDefaultDisplay();
        int dWidth = display.getWidth();
        int dHeight = display.getHeight();
        
        //获取popupwindow布局的padding值
        int paddingLeft = parentView.getPaddingLeft();
        int paddingRight = parentView.getPaddingRight();
        parentView.measure(w, h);
        parentView.measure(w, h);
        
        //popupwindow主体的宽度
        int width1 = parentView.getMeasuredWidth();
        
        //popwindow带padding的宽度
        int widthP = width1 + paddingLeft + paddingRight;
        
        //popupwindow上方控件的宽度
        int parentWidth = right - left;
        
        //小三角的宽度
        traView.measure(w, h);
        int width = traView.getMeasuredWidth();
        
        //小三角最大的marginLeft值
        int maxMarginLeft = width1 - width;
        
        //控件需调整的margin值
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        
        //判断使用那种计算方式来计算小三角的位移量
        int centerIndex;
        if (parentWidth > widthP) {
            centerIndex = maxMarginLeft / 2;
        } else if ((dWidth - left) > widthP) {
            centerIndex = parentWidth / 2 - width / 2 - paddingLeft;
        } else {
            int rWidth = dWidth - right;
            centerIndex = width1 - (parentWidth / 2 + rWidth - paddingRight);
        }
        
        if (centerIndex > maxMarginLeft) {
            centerIndex = maxMarginLeft;
        }
        
        params.setMargins(centerIndex, 0, 0, 0);
        traView.setLayoutParams(params);
        
    }
    
    //获取状态栏高度
    public static int getStatusBarHeight(Activity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
