package com.cq.aaa.dbdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/10/24
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DBName = "DBDemo.db";
    private static final int version = 1;
    
    //表一  用户表
    public static String TABLE_NAME = "MessTable";
    public static String wId = "wId";
    public static String name = "name";
    public static String sex = "sex";
    public static String age = "age";
    public static String imgUrl = "imgUrl";
    
    
    //表一  用户表
    public static String TABLE_TALK = "talkMess";
    //    public static String wId = "wId";  用户id 唯一
    public static String talkDate = "talkDate";
    public static String talkType = "talkType";
    public static String talkContent = "talkContent";
    
    
    public DBHelper(Context context) {
        super(context, DBName, null, version);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " +
                TABLE_NAME +
                "(_id integer primary key autoincrement, " +
                wId + " varchar, " +
                name + " varchar," +
                sex + " integer," +
                age + " integer," +
                imgUrl + " varchar" +
                ")";
        
        db.execSQL(sql);
        String sql1 = "create table " +
                TABLE_TALK +
                "(_id integer primary key autoincrement, " +
                wId + " varchar, " +
                talkDate + " long," +
                talkType + " integer," +
                talkContent + " varchar" +
                ")";
        db.execSQL(sql1);
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    
    }
}
