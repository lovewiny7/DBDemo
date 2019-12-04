package com.global.winy7.basedb.form;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.global.util.DateUtils;
import com.global.winy7.DateUtilForMe.DateUitlForMe;
import com.global.winy7.basedb.DBHelper;
import com.global.winy7.basedb.bean.TalkMessList;
import com.global.winy7.basedb.bean.WeiXinUserInfo;
import com.waterbase.utile.DateUtil;

import java.util.ArrayList;

/**
 * <pre>
 *     desc   : 聊天记录
 *     author : winy7
 *     time   : 2019/10/23
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class TalkMessForm {
    
    public static final String TABLE_NAME = "TalkMessForm";  // 表名
    
    public static final String talkContent = "talkContent"; //消息内容
    public static final String contentType = "contentType";  //消息 类型：1.发送 2.接收
    public static final String canBack = "canBack";  //是否可撤销 1.true 0.false
    public static final String date = "date";   //发送/接收 时间
    
    private SQLiteDatabase getmDatabase;
    
    public TalkMessForm(Context context, boolean write) {
        DBHelper dbHelper = new DBHelper(context, write);
        getmDatabase = dbHelper.getmDatabase();
    }
    
    public void insert(TalkMessList data) {
        
        ContentValues values = new ContentValues();
        values.put(talkContent, data.getTalkContent());
        values.put(contentType, 1);
        values.put(canBack, 1);
        values.put(date, System.currentTimeMillis());
        
        
        getmDatabase.insert(TABLE_NAME, null, values);
        
    }
    
    public boolean delect(String date) {
        
        int delete = getmDatabase.delete(TABLE_NAME, date + " =? ", new String[]{date});
        return delete != -1;
        
    }
    
    public ArrayList<TalkMessList> query() {
        
        ArrayList<TalkMessList> list = new ArrayList<>();

//        String[] selectioinArgs = {value};//注意：这里没有单引号
        String sql = "select * from " + TABLE_NAME
                + " order by  " + date + " desc ";
        
        Cursor cursor = getmDatabase.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            TalkMessList info = new TalkMessList();
            
            info.setTalkContent(cursor.getString(cursor.getColumnIndex(talkContent)));
            info.setContentType(cursor.getInt(cursor.getColumnIndex(contentType)));
            long time = cursor.getLong(cursor.getColumnIndex(date));
            // 依据时间判断是否可撤销
            int canBackVale;
            if (DateUitlForMe.getTimeDifferenceMinute(time, 2)) {
                canBackVale = 0;
            } else canBackVale = 1;
            info.setCanBack(canBackVale);
            info.setDate(time);
            
            list.add(info);
        }
        cursor.close();
        return list;
        
    }
}
