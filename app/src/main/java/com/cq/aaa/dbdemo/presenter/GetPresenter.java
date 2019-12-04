package com.cq.aaa.dbdemo.presenter;

import android.view.View;

import com.cq.aaa.dbdemo.activity.A_Get_Msg;
import com.cq.aaa.dbdemo.R;
import com.cq.aaa.dbdemo.db.DBHelper;
import com.cq.aaa.dbdemo.mvpview.GetView;

/**
 * <pre>
 *     desc   :
 *     author : winy7
 *     time   : 2019/10/24
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class GetPresenter {
    
    private GetView mView;
    private A_Get_Msg activity;
    private DBHelper mDbHelper;
    
    public GetPresenter(GetView mView, A_Get_Msg activity) {
        
        this.mView = mView;
        this.activity = activity;
        
        mDbHelper = new DBHelper(activity);
    }
    
    public void click(View v) {
        
        if (v.getId() == R.id.tv_send_msg) {
//            insertData();
        }
// else if (v.getId() == R.id.) {
//
//        } else if (v.getId() == R.id.) {
//
//        }
    
    }
//
//    private void insertData() {
//
//
//        ContentValues values = new ContentValues();
//
//        HistoryMess historyMess = new HistoryMess();
//        historyMess.setContent("122413113");
//        historyMess.setDate(System.currentTimeMillis());
//        historyMess.setType(1);
//        values.put(DBHelper.wId, "001");
//        values.put(DBHelper.name, "接收者");
//        values.put(DBHelper.sex, 1);
//        values.put(DBHelper.age, 10);
//        values.put(DBHelper.historyMess, FileUtils.bean2Byte(historyMess));
//        values.put(DBHelper.imgUrl, System.currentTimeMillis());
//        mDbHelper.getWritableDatabase().insert(DBHelper.TABLE_NAME, null, values);
//    }
    
    
//    public List<HistoryMess> queryData() {
////
////        mDbHelper = new DBHelper(activity);
////
////        String sql = "select " + DBHelper.historyMess + " from " + DBHelper.TABLE_NAME;
////        Cursor cursor = mDbHelper.getReadableDatabase().rawQuery(sql, null);
////        ArrayList<HistoryMess> objects = new ArrayList<>();
////        while (cursor.moveToNext()) {
////
////            byte[] blob = cursor.getBlob(cursor.getColumnIndex(DBHelper.historyMess));
////            if (blob != null && blob.length != 0)
////                objects.add((HistoryMess) FileUtils.ByteToObject(blob));
////        }
////        Log.e("AAAAA", "queryData: " + objects.size());
////        return objects;
//
//    }
    
    
}
