package com.global.winy7.FileUtil;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.waterbase.utile.LogUtil;
import com.waterbase.utile.ToastUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/08/09
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class FileUtils {
    
    
    /**
     * 复制单个文件
     *
     * @param oldPath$Name String 原文件路径+文件名 如：data/user/0/com.test/files/abc.txt
     * @param newPath$Name String 复制后路径+文件名 如：data/user/0/com.test/cache/abc.txt
     * @return <code>true</code> if and only if the file was copied;
     * <code>false</code> otherwise
     */
    public static boolean copyFile(String oldPath$Name, String newPath$Name) {
        try {
            File oldFile = new File(oldPath$Name);
            if (!oldFile.exists()) {
                Log.e("--Method--", "copyFile:  oldFile not exist.");
                return false;
            } else if (!oldFile.isFile()) {
                Log.e("--Method--", "copyFile:  oldFile not file.");
                return false;
            } else if (!oldFile.canRead()) {
                Log.e("--Method--", "copyFile:  oldFile cannot read.");
                return false;
            }
 
            /* 如果不需要打log，可以使用下面的语句
            if (!oldFile.exists() || !oldFile.isFile() || !oldFile.canRead()) {
                return false;
            }
            */
            
            FileInputStream fileInputStream = new FileInputStream(oldPath$Name);
            FileOutputStream fileOutputStream = new FileOutputStream(newPath$Name);
            byte[] buffer = new byte[1024];
            int byteRead;
            while (-1 != (byteRead = fileInputStream.read(buffer))) {
                fileOutputStream.write(buffer, 0, byteRead);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //** 将实体类(实现序列化)转为byte数组,可存入数据库。
    public static byte[] bean2Byte(Object o) {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        byte data[] = null;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.flush();
            data = arrayOutputStream.toByteArray();
            objectOutputStream.close();
            arrayOutputStream.close();
            LogUtil.e("CAO", "----------->" + data);

//            SQLiteDatabase database = dbHelper.getWritableDatabase();
//            database.execSQL("insert into Test (person) values(?)", new Object[] { data });
//            database.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return data;
    }
    
    //** 将实体类(实现序列化)转为byte数组,可存入数据库。
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static <T> Optional<T> bytes2Object(byte[] bytes) {
        T t = null;
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream sIn;
        try {
            sIn = new ObjectInputStream(in);
            t = (T) sIn.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(t);
        
    }
    
    public static Object ByteToObject(byte[] bytes) {
        Object obj = null;
        try {
            // bytearray to object
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);
            
            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return obj;
        
    }
    
}
