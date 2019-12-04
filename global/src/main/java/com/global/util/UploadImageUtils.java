package com.global.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.global.R;
import com.waterbase.utile.GlideUtile;

/**
 * Created by Water on 2018/5/8.
 * 加载网络图片
 */

public class UploadImageUtils {
    @BindingAdapter({"res"})
    public static void LocalImageLoad(ImageView imageView, int res) {
        imageView.setImageResource(res);
    }

    /**
     * 加载网络圆形图片 (用来加载圆形头像)
     *
     * @param imageView
     * @param url
     */
    @BindingAdapter({"mycentreurl"})
    public static void loadCircleImage(ImageView imageView, String url) {
        GlideUtile.loadCircleImage(imageView, url, R.mipmap.ic_head_normal, R.mipmap.ic_head_normal);
    }

    /**
     * 加载方型图像
     *
     * @param imageView
     * @param url
     */
    public static void loadRectangleImage(ImageView imageView, String url) {
        GlideUtile.loadImage(imageView, url, R.mipmap.icon_empty, R.mipmap.icon_empty);
    }

}
