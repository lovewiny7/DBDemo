package com.global.winy7.basedb.form;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.global.winy7.basedb.bean.WeiXinUserInfo;
import com.global.winy7.basedb.DBHelper;
import com.global.winy7.basedb.bean.TalkBean;

import java.util.ArrayList;

/**
 * <pre>
 *     desc   : 用户信息表
 *     author : winy7
 *     time   : 2019/10/18
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class UserTalkForm {
    
    public static final String TABLE_NAME = "UserTalkForm";  // 表名
    
    public static final String weiXinId = "weiXinId";  // 微信号
    public static final String talkContent = "talkContent"; //消息内容
    public static final String contentType = "contentType";  //消息 类型：1.发送 2.接收
    public static final String canBack = "canBack";  //是否可撤销
    public static final String date = "date";   //发送/接收 时间
    public WeiXinUserInfo data;   //发送/接收 时间

    private SQLiteDatabase getmDatabase;
    
    
    public UserTalkForm(Context context, boolean write) {
        DBHelper dbHelper = new DBHelper(context, write);
        getmDatabase = dbHelper.getmDatabase();
    }
    
    public void insert() {
        
        ContentValues values = new ContentValues();
        values.put(weiXinId, "cq347267801");
        values.put(talkContent, "cq347267801");
        values.put(contentType, 1);
        values.put(canBack, false);
        values.put(date, 1820055412354L);

        getmDatabase.insert(TABLE_NAME, null, values);
        
    }
    
//    public ArrayList<TalkBean> query(String key, String value) {
//
//        ArrayList<TalkBean> list = new ArrayList<>();
//
//        String[] selectioinArgs = {value};//注意：这里没有单引号
//        String sql = "select * from " + TABLE_NAME
//                + " where " + key + " = ? ";
//
//        Cursor cursor = getmDatabase.rawQuery(sql, selectioinArgs);
//        while (cursor.moveToNext()) {
//            TalkBean info = new TalkBean();
//
//            info.setTalkContent(cursor.getString(cursor.getColumnIndex(talkContent)));
//            info.setContentType(cursor.getInt(cursor.getColumnIndex(contentType)));
//            info.setCanBack(cursor.getInt(cursor.getColumnIndex(canBack)));
//            info.setDate(cursor.getLong(cursor.getColumnIndex(date)));
////            info.setSignature((String) extras.get(signature));
//            list.add(info);
//        }
//        cursor.close();
//        return list;
//
//    }

//    public void update(String key, String value) {
//
//        ContentValues values = new ContentValues();
//        values.put(talkContent, "cq347267801");
//        values.put(contentType, "中国");
//        values.put(canBack, "陕西西安");
//        values.put(date, 1);
//        getmDatabase.update(TABLE_NAME, values, key + " = ?", new String[]{value});
//
//    }
    
    
    public void delete(String key, String value) {
        getmDatabase.delete(TABLE_NAME, key + " = ?", new String[]{value});
        
    }
    

}
