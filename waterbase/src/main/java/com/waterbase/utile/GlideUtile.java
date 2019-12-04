package com.waterbase.utile;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.waterbase.R;
import com.waterbase.widget.glide.GlideCircleTransform;
import com.waterbase.widget.glide.GlideRoundTransform;


/**
 * 图片处理工具类
 * Created by Water on 2017/6/20.
 */

public class GlideUtile {

//    @BindingAdapter({"informationUrl"})
    public static void loadImage(ImageView imageView, String url, int loadingRes, int errorRes) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(loadingRes) // 加载时的图片
                .error(errorRes) // 错误是的图片
                .fitCenter()
                .into(imageView);
    }

    //    @BindingAdapter({"informationUrl"})

    /**
     * purpose: 自动拉伸
     * @param imageView
     * @param url
     * @param loadingRes
     * @param errorRes
     */
    public static void loadImageStretch(ImageView imageView, String url, int loadingRes, int errorRes) {

        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(loadingRes) // 加载时的图片
                .error(errorRes) // 错误是的图片
                .centerCrop()
                .into(imageView);
    }

    /**
     * 加载网络圆形图片
     *
     * @param imageView
     * @param url
     * @param loadingRes
     * @param errorRes
     */
    public static void loadCircleImage(ImageView imageView, String url, int loadingRes, int errorRes) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(loadingRes) // 加载时的图片
                .error(errorRes) // 错误是的图片
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    /**
     * 加载本地资源文件
     *
     * @param imageView
     * @param resourceId
     */
    public static void loadCircleImage(ImageView imageView, int resourceId) {
        Glide.with(imageView.getContext().getApplicationContext())
                .load(resourceId)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

   
    public static void loadRoundImage(final ImageView imageView, int resourceId,int round) {

        Glide.with(imageView.getContext().getApplicationContext())
                .load(resourceId)
                .transform(new GlideRoundTransform(imageView.getContext(),round))
                .into(imageView);
    }
    
    public static void loadRoundImage(final ImageView imageView, String url, int resourceId,int round) {
        
        Glide.with(imageView.getContext().getApplicationContext())
                .load(url)
                .error(resourceId)
                .transform(new GlideRoundTransform(imageView.getContext(),round))
                .into(imageView);
    }
    
    /**
     * 把资源图片转换成Bitmap
     *
     * @param drawable
     *            资源图片
     * @return 位图
     */
    public static Bitmap getBitmapFromDrawable(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, drawable
                .getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(-4, -4, width+4, height+4);
        drawable.draw(canvas);
        return bitmap;
    }
}
