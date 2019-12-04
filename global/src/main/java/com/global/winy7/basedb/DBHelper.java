package com.global.winy7.basedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.global.winy7.basedb.form.TalkMessForm;
import com.global.winy7.basedb.form.UserTalkForm;

import static com.global.winy7.basedb.form.UserInfoForm.*;


/**
 * <pre>
 *     desc   : 微信 SQLite数据库
 *     author : winy7
 *     time   : 2019/10/17
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class DBHelper extends SQLiteOpenHelper {
    
    // 数据库文件名
    public static final String DB_NAME = "weiXin.db";
    // 数据库版本号
    public static final int DB_VERSION = 1;
    private final SQLiteDatabase mDatabase;
    
    public DBHelper(Context context, boolean writeAble) {
        super(context, DB_NAME, null, DB_VERSION);
        if (writeAble) {
            mDatabase = getWritableDatabase();
        } else
            mDatabase = getReadableDatabase();
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        
        String sql = "create table " +
                TABLE_NAME +
                "(_id integer primary key autoincrement, " +
                weiXInName + " varchar, " +
                weiXinId + " varchar," +
                icon + " varchar," +
                age + " integer," +
                county + " varchar," +
                
                province + " varchar," +
                city + " varchar," +
                signature + " varchar," +
                checkMess + " varchar," +
                bindingPhone + " integer," +
                
                sex + " integer," +
                realName + " varchar," +
                idCard + " varchar" +
                ")";
        db.execSQL(sql);
       
        
        String sqlTalk = "create table " +
                UserTalkForm.TABLE_NAME +
                "(_id integer primary key autoincrement, " +
                UserTalkForm.weiXinId + " varchar, " +
                UserTalkForm.talkContent + " varchar," +
                UserTalkForm.contentType + " int," +
                UserTalkForm.canBack + " int," +
                UserTalkForm.date + " long" +
                ")";
        
        db.execSQL(sqlTalk);
    
        String sqlTalkMess = "create table " +
                TalkMessForm.TABLE_NAME +
                "(_id integer primary key autoincrement, " +
                UserTalkForm.talkContent + " varchar," +
                UserTalkForm.contentType + " int," +
                UserTalkForm.canBack + " int," +
                UserTalkForm.date + " long" +
                ")";
    
        db.execSQL(sqlTalkMess);
    }
    
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    
    }
    
    
    public SQLiteDatabase getmDatabase() {
        return mDatabase;
    }
}
