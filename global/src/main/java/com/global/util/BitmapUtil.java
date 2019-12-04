package com.global.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.ByteArrayOutputStream;

/**
 * Bitmap工具类
 * Created by Guangkuo on 2017/5/23.
 */
public class BitmapUtil {
    private static BitmapUtil mBitmapUtil;

    /**
     * 单例
     */
    public static BitmapUtil getInstance() {
        if (mBitmapUtil == null) {
            synchronized (BitmapUtil.class) {
                if (mBitmapUtil == null) {
                    mBitmapUtil = new BitmapUtil();
                }
            }
        }
        return mBitmapUtil;
    }

    //    /**
    //     * 通过uri获取图片并进行压缩
    //     *
    //     * @param uri 图片Uri
    //     */
    //    @Nullable
    //    public byte[] getByteArrayFormUri(Activity ac, Uri uri) throws IOException {
    //        InputStream input = ac.getContentResolver().openInputStream(uri);
    //        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
    //        onlyBoundsOptions.inJustDecodeBounds = true;
    //        onlyBoundsOptions.inDither = true;//optional
    //        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
    //        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
    //        input.close();
    //        int originalWidth = onlyBoundsOptions.outWidth;
    //        int originalHeight = onlyBoundsOptions.outHeight;
    //        if ((originalWidth == -1) || (originalHeight == -1))
    //            return null;
    //        //图片分辨率以480x800为标准
    //        float hh = 1920f;//这里设置高度为1920f
    //        float ww = 1080f;//这里设置宽度为1080f
    //        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
    //        int be = 1;//be=1表示不缩放
    //        if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
    //            be = (int) (originalWidth / ww);
    //        } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
    //            be = (int) (originalHeight / hh);
    //        }
    //        if (be <= 0)
    //            be = 1;
    //        //比例压缩
    //        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
    //        bitmapOptions.inSampleSize = be;//设置缩放比例
    //        bitmapOptions.inDither = true;//optional
    //        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
    //        input = ac.getContentResolver().openInputStream(uri);
    //        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
    //        assert input != null;
    //        input.close();
    //
    //        return compressImage(bitmap);//再进行质量压缩
    //    }
    //
    //    /**
    //     * 质量压缩方法
    //     *
    //     * @param image
    //     * @return
    //     */
    //    public byte[] compressImage(Bitmap image) {
    //        ByteArrayOutputStream baos;
    //        baos = new ByteArrayOutputStream();
    //        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
    //        //        float size = baos.toByteArray().length / 1024 / 1024;// M
    //        //        int options = size > 1.5 ? (int) (100 * 1.5 / size) : 100;// 计数压缩比例
    //        int options = 100;
    //        while (baos.toByteArray().length / 1024 > 1024) {  //循环判断如果压缩后图片是否大于1.5M,大于继续压缩
    //            baos.reset();//重置baos即清空baos
    //            //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
    //            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
    //            options -= 10;//每次都减少10
    //        }
    //        byte[] ret = baos.toByteArray();
    //        try {
    //            baos.close();
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //        return ret;
    //    }
    //
    //    /**
    //     * drawable转Bitmap方法
    //     *
    //     * @param drawable
    //     * @return
    //     */
    //    public static Bitmap drawableToBitmap(Drawable drawable) {
    //        // 取 drawable 的长宽
    //        int w = drawable.getIntrinsicWidth();
    //        int h = drawable.getIntrinsicHeight();
    //
    //        // 取 drawable 的颜色格式
    //        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
    //                : Bitmap.Config.RGB_565;
    //        // 建立对应 bitmap
    //        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
    //        // 建立对应 bitmap 的画布
    //        Canvas canvas = new Canvas(bitmap);
    //        drawable.setBounds(0, 0, w, h);
    //        // 把 drawable 内容画到画布中
    //        drawable.draw(canvas);
    //        return bitmap;
    //    }

    public byte[] getSmallBitmap(Activity ac, Uri uri) {
        return getSmallBitmap(getPath(ac, uri));
    }

    private String getPath(Activity ac, Uri uri) {
        String pickPath = MiPictureHelper.getPath(ac, uri);  // 获取图片路径的方法调用
        //        String[] projection = {MediaStore.Video.Media.DATA};
        //        Cursor cursor = ac.managedQuery(uri, projection, null, null, null);
        //        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        //        cursor.moveToFirst();
        //        return cursor.getString(column_index);
        return pickPath;
    }

    public byte[] getSmallBitmap(String filePath) {
        Bitmap bitmap;
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
//        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inSampleSize = calculateInSampleSize(options, 1080, 1920);
        options.inJustDecodeBounds = false;

        try {
            bitmap = BitmapFactory.decodeFile(filePath, options);
        } catch (Exception e) {
            options.inSampleSize = calculateInSampleSize(options, 480, 800);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(filePath, options);
        }
        byte[] bytes = compressBitmap(bitmap);
        if (null != bitmap && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bytes;
    }


    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio > widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    private byte[] compressBitmap(Bitmap bm) {
        int options = 100;
        byte[] ret = new byte[0];
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, options, baos);
            while (baos.toByteArray().length / 1024 > 1024) {  //循环判断如果压缩后图片是否大于1.5M,大于继续压缩
                baos.reset();//重置baos即清空baos
                //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
                bm.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
                options -= 10;// 每次都减少10
            }
            ret = baos.toByteArray();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
