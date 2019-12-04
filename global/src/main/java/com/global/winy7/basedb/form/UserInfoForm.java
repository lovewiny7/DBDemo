package com.global.winy7.basedb.form;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.global.winy7.basedb.bean.WeiXinUserInfo;
import com.global.winy7.basedb.DBHelper;

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
public class UserInfoForm {
    
    public static final String TABLE_NAME = "UserInfoForm";  // 表名
    
    public static final String weiXInName = "weiXInName"; //昵称
    public static final String weiXinId = "weiXinId";  // 微信号
    public static final String icon = "icon";  //头像
    public static final String age = "age";  //年龄
    public static final String county = "county";  //国家
    
    public static final String province = "province";  //省
    public static final String city = "city";  //城市
    public static final String signature = "signature";//个性签名
    public static final String checkMess = "checkMess"; // 验证消息
    public static final String bindingPhone = "bindingPhone"; // 绑定手机
    
    public static final String sex = "sex";   //性别
    public static final String realName = "realName"; //实名
    public static final String idCard = "idCard";  //  身份证
    
    private SQLiteDatabase getmDatabase;
    
    public UserInfoForm(Context context, boolean write) {
        DBHelper dbHelper = new DBHelper(context, write);
        getmDatabase = dbHelper.getmDatabase();
    }
    
    public void insert(WeiXinUserInfo data) {
        
        ContentValues values = new ContentValues();
        values.put(weiXInName, data.getWeiXInName());
        values.put(weiXinId, data.getWeiXinId());
        values.put(icon, data.getIcon());
        values.put(age, data.getAge());
        values.put(county, data.getCountry());
        
        values.put(province, data.getProvince());
        values.put(city, data.getCity());
        values.put(signature, data.getSignature());
        values.put(checkMess, data.getCheckMess());
        values.put(bindingPhone, data.getBindingPhone());
        
        values.put(sex, data.getSex());
        values.put(realName, data.getRealName());
        values.put(idCard, data.getIdCard());
        
        getmDatabase.insert(TABLE_NAME, null, values);
        
    }
    
    public ArrayList<WeiXinUserInfo> query(String key, String value) {
        
        ArrayList<WeiXinUserInfo> list = new ArrayList<>();
        
        String[] selectioinArgs = {value};//注意：这里没有单引号
        String sql = "select * from " + TABLE_NAME
                + " where " + key + " = ? ";
        
        Cursor cursor = getmDatabase.rawQuery(sql, selectioinArgs);
        while (cursor.moveToNext()) {
            WeiXinUserInfo info = new WeiXinUserInfo();
            info.setWeiXInName(cursor.getString(cursor.getColumnIndex(weiXInName)));
            info.setWeiXinId(cursor.getString(cursor.getColumnIndex(weiXinId)));
            info.setCity(cursor.getString(cursor.getColumnIndex(icon)));
            info.setAge(cursor.getInt(cursor.getColumnIndex(age)));
            info.setCountry(cursor.getString(cursor.getColumnIndex(county)));
            
            info.setProvince(cursor.getString(cursor.getColumnIndex(province)));
            info.setCity(cursor.getString(cursor.getColumnIndex(city)));
            info.setSignature(cursor.getString(cursor.getColumnIndex(signature)));
            info.setCheckMess(cursor.getString(cursor.getColumnIndex(checkMess)));
            info.setBindingPhone(cursor.getInt(cursor.getColumnIndex(bindingPhone)));
            
            info.setSex(cursor.getInt(cursor.getColumnIndex(sex)));
            info.setRealName(cursor.getString(cursor.getColumnIndex(realName)));
            info.setIdCard(cursor.getString(cursor.getColumnIndex(idCard)));
            list.add(info);
        }
        cursor.close();
        return list;
        
    }
    
    public void update(String key, String value) {
        
        ContentValues values = new ContentValues();
        values.put(weiXinId, "cq347267801");
        values.put(weiXInName, "cq347267801");
        values.put(county, "中国");
        values.put(city, "陕西西安");
        values.put(icon, "http://img5.imgtn.bdimg.com/it/u=2616736980,3933048081&fm=26&gp=0.jpg");
        values.put(sex, 1);
        values.put(realName, "曹琦");
        values.put(idCard, "6125251992255223");
        values.put(signature, "我自横刀向天笑");
        getmDatabase.update(TABLE_NAME, values, key + " = ?", new String[]{value});
        
    }
    
    
    public void delete(String key, String value) {
        getmDatabase.delete(TABLE_NAME, key + " = ?", new String[]{value});
        
    }
    
    public void truncate(String key, String value) {
//        getmDatabase.execSQL("delete table "+TABLE_NAME);
        
    }
    
    public SQLiteDatabase getGetmDatabase() {
        return getmDatabase;
    }
    
    public void setGetmDatabase(SQLiteDatabase getmDatabase) {
        this.getmDatabase = getmDatabase;
    }
}
