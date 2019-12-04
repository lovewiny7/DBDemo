package com.cq.aaa.dbdemo.presenter;

import android.content.ContentValues;
import android.content.Intent;
import android.view.View;

import com.cq.aaa.dbdemo.activity.A_Get_Msg;
import com.cq.aaa.dbdemo.activity.A_Send_Msg;
import com.cq.aaa.dbdemo.R;
import com.cq.aaa.dbdemo.bean.HistoryMess;
import com.cq.aaa.dbdemo.db.DBHelper;
import com.cq.aaa.dbdemo.mvpview.SendView;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/10/24
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class SendPresenter {
    
    private SendView mView;
    private A_Send_Msg activity;
    private DBHelper mDbHelper;
    
    public SendPresenter(SendView mView, A_Send_Msg activity) {
        
        this.mView = mView;
        this.activity = activity;
    
        mDbHelper = new DBHelper(activity);
    }
    
    public void click(View v,String content) {
        
        if (v.getId() == R.id.tv_send_msg) {
            insertData(content);
        } else if (v.getId() == R.id.tv_get_mess) {
            activity.startActivity(new Intent(  activity ,A_Get_Msg.class));//页面跳转
        }
// else if (v.getId() == R.id.) {
//
//        }
    
    }
    
    private void insertData(String content) {
    
        
        ContentValues values = new ContentValues();
        
        HistoryMess historyMess = new HistoryMess();
        historyMess.setContent(content);
        historyMess.setDate(System.currentTimeMillis());
        historyMess.setType(1);
        values.put(DBHelper.wId, "001");
        values.put(DBHelper.name, "接收者");
        values.put(DBHelper.sex, 1);
        values.put(DBHelper.age, 10);
        values.put(DBHelper.imgUrl, System.currentTimeMillis());
        mDbHelper.getWritableDatabase().insert(DBHelper.TABLE_NAME, null, values);
    }
    
    
    private void queryData() {
        
        mDbHelper = new DBHelper(activity);
    
//        String sql = "select DBHelper.historyMess from "+DBHelper.TABLE_NAME;
//        Cursor cursor = mDbHelper.getReadableDatabase().rawQuery(sql, null);
//        while (cursor.moveToNext()){
//
//            byte[] blob = cursor.getBlob(cursor.getColumnIndex(DBHelper.historyMess));
//        }
    }
    
   
    
}
