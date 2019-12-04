package com.global.winy7.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Gravity;
import android.widget.Toast;

import com.global.winy7.sqlite.bean.CarBean;
import com.global.winy7.sqlite.bean.CostBean;
import com.global.winy7.sqlite.bean.ProBean;
import com.global.winy7.sqlite.bean.SupplierBean;
import com.global.winy7.sqlite.bean.TodayEarningsBean;
import com.waterbase.utile.DateUtil;
import com.waterbase.utile.LogUtil;
import com.waterbase.utile.StrUtil;
import com.waterbase.utile.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import static com.global.util.DateUtils.dateFormatYMD1;

/**
 * <pre>
 *     desc   : SQLite数据库
 *     author : winy7
 *     time   : 2019/07/08
 *     e-mail : 347267801@qq.com
 *     version: 1.0
 * </pre>
 */
public class DBHelper extends SQLiteOpenHelper {
    // 数据库文件名
    public static final String DB_NAME = "car_num.db";
    // 数据库表名
    public static final String TABLE_NAME = "car";
    // 数据库版本号
    public static final int DB_VERSION = 1;
    
    //每次展示页数
    private int size = 20;
    
    //数据库字段
    private String carNum = "carNum"; //车牌号
    private String oilMess = "oilMess"; //机油
    private String airFilterMess = "airFilterMess"; //空滤
    private String machineFilterMess = "machineFilterMess"; //机滤
    private String fixDate = "fixDate"; //保养时间
    private String mileage = "mileage"; //公里数
    private String titlePrice = "titlePrice"; //总价
    private String owner = "owner";   //车主
    private String phone = "phone";   //电话
    private String others = "others";  //备注
    
    private String otherPro = "otherPro";  //其他产品  后加字段
    
    private SQLiteDatabase mDatabase;
    private Context context;
    
    //表2
    private String Fix_Record = "Fix_Record";
    
    //表3
    private static final String PRODUCTS = "Products";
    private String name = "name";
    private String price = "price";
    private String type = "type";
    private String img = "img";
    
    //表4
    private String Earning_Record = "Earning_Record";
    
    //表5
    private String Cost = "Cost"; // 进货表
    
    private String merchant = "merchant";  //供货商
    private String singlePrice = "singlePrice";//单价
    private String count = "count";//数量
    private String totalPrice = "totalPrice";//总价
    private String date = "date";//日期
    
    /***
     * Supplier //表名 6
     *  name; //名称
     *  address; //地址
     *  product; //产品
     *  phone;   //电话
     *  type; //编号
     */
    private String Supplier = "Supplier"; // 供货商表
    private String address = "address";
    private String product = "product";
    
    
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        
        mDatabase = getWritableDatabase();
        
        
    }
    
    public DBHelper(Context context,int readOnly) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        
        mDatabase = getReadableDatabase();
        
        
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         *  车辆信息表
         */
        String sql = "create table " +
                TABLE_NAME +
                "(_id integer primary key autoincrement, " +
                carNum + " varchar, " +
                oilMess + " varchar," +
                airFilterMess + " varchar," +
                machineFilterMess + " varchar," +
                fixDate + " date," +
                mileage + " varchar," +
                titlePrice + " integer," +
                owner + " varchar," +
                phone + " varchar," +
                others + " varchar," +
                otherPro + " varchar"
                + ")";
        
        db.execSQL(sql);
        
        /**
         * 保养记录表
         */
        String sql1 = "create table " +
                Fix_Record +
                " (_id integer primary key autoincrement, " +
                fixDate + " date, " +
                carNum + " varchar," +
                oilMess + " varchar," +
                machineFilterMess + " varchar," +
                airFilterMess + " varchar," +
                titlePrice + " integer," +
                mileage + " integer," +
                otherPro + " varchar," +
                others + " varchar"
                + ")";
        
        db.execSQL(sql1);
        /**
         * 配件表
         */
        String sql2 = "create table " +
                PRODUCTS +
                " (_id integer primary key autoincrement, " +
                name + " varchar, " +
                price + " integer," +
                img + " blob," +
                type + " varchar"
                + ")";
        
        db.execSQL(sql2);
        // 建表
        String sql3 = "create table " +
                Earning_Record +
                "(_id integer primary key autoincrement, " +
                fixDate + " date, " +
                titlePrice + " integer"
                + ")";
        
        db.execSQL(sql3);
        createCost(db);
        createSupplier(db);
        
    }
    
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
    }
    
    /**
     * //新增车辆
     *
     * @param data 数据
     */
    public long insertCars(CarBean data) {
        ContentValues values = new ContentValues();
        if (StrUtil.isEmpty(data.getCarNum())) {
            values.put(carNum, "");
        } else values.put(carNum, data.getCarNum().toUpperCase().trim());
        values.put(oilMess, data.getOilMess());
        values.put(airFilterMess, data.getAirFilterMess());
        values.put(machineFilterMess, data.getMachineFilterMess());
        values.put(fixDate, DateUtil.getStringByFormat(data.getFixDate(), dateFormatYMD1, DateUtil.dateFormatYMD));
        values.put(mileage, data.getMileage());
        values.put(titlePrice, data.getTitlePrice());
        values.put(owner, data.getOwner());
        values.put(phone, data.getPhone());
        values.put(others, data.getOthers());
        values.put(otherPro, data.getOtherPro());
        long insert = mDatabase.insert(DBHelper.TABLE_NAME, null, values);
        insertFixRecords(data);
        return insert;
        
    }
    
    
    /**
     * //新增车辆
     *
     * @param list 数据
     */
    public void insertCars(List<CarBean> list) {
        for (int i = 0; i < list.size(); i++) {
            CarBean data = list.get(i);
            CarBean data1 = list.get(i);
            ContentValues values = new ContentValues();
            if (StrUtil.isEmpty(data.getCarNum())) {
                values.put(carNum, "");
            } else values.put(carNum, data.getCarNum().toUpperCase());
            values.put(oilMess, data1.getOilMess());
            values.put(airFilterMess, data1.getAirFilterMess());
            values.put(machineFilterMess, data1.getMachineFilterMess());
            values.put(fixDate, data1.getFixDate());
            values.put(mileage, data1.getMileage());
            values.put(titlePrice, data1.getTitlePrice());
            values.put(owner, data1.getOwner());
            values.put(phone, data.getPhone());
            values.put(others, data1.getOthers());
            values.put(otherPro, data1.getOtherPro());
            long insert = mDatabase.insert(DBHelper.TABLE_NAME, null, values);
            insertFixRecords(data, 0);
            
        }
        
        
    }
    
    /**
     * 删除车辆
     *
     * @param id
     */
    public void deleteCar(String id) {
        int count = mDatabase.delete(TABLE_NAME, "_id = ?", new String[]{id});
        Toast.makeText(context, "删除：" + count + "条数据", Toast.LENGTH_SHORT).show();
//        mDatabase.close();
    }
    
    /**
     * 删除车辆
     *
     * @param carNum 车牌号
     */
    public void deleteFixRecordByCarNum(String carNum) {
        mDatabase.delete(Fix_Record, "carNum = ?", new String[]{carNum});
//        mDatabase.close();
        
    }
    
    
    /**
     * //修改车辆信息
     *
     * @param data
     */
    public void updateData(CarBean data, String id) {
        ContentValues values = new ContentValues();
        values.put(carNum, data.getCarNum());
        values.put(oilMess, data.getOilMess());
        values.put(airFilterMess, data.getAirFilterMess());
        values.put(machineFilterMess, data.getMachineFilterMess());
        values.put(fixDate, DateUtil.getStringByFormat(data.getFixDate(), dateFormatYMD1, DateUtil.dateFormatYMD));
        values.put(mileage, data.getMileage());
        values.put(titlePrice, data.getTitlePrice());
        values.put(owner, data.getOwner());
        values.put(phone, data.getPhone());
        values.put(others, data.getOthers());
        values.put(otherPro, data.getOtherPro());
        int update = mDatabase.update(DBHelper.TABLE_NAME, values, "_id = ?",
                new String[]{id});
        if (update > 0) ToastUtil.showToast(context, "修改成功");
//        mDatabase.close();
    }
    
    
    /**
     * 车辆修改车牌号时，同时修改保养记录
     */
    public int updateFixRecord(String num, CarBean data) {
        ContentValues values = new ContentValues();
        values.put(carNum, data.getCarNum());
        values.put(oilMess, data.getOilMess());
        values.put(airFilterMess, data.getAirFilterMess());
        values.put(machineFilterMess, data.getMachineFilterMess());
        values.put(fixDate, DateUtil.getStringByFormat(data.getFixDate(), dateFormatYMD1, DateUtil.dateFormatYMD));
        values.put(mileage, data.getMileage());
        values.put(titlePrice, data.getTitlePrice());
        values.put(others, data.getOthers());
        values.put(otherPro, data.getOtherPro());
        
        int update = mDatabase.update(Fix_Record, values, "carNum = ?",
                new String[]{num});
        if (update > 0) ToastUtil.showToast(context, "修改成功");
//        mDatabase.close();
        return update;
    }
    
    
    /**
     * 精确查询
     *
     * @param str 车牌号查询
     * @return CarBean
     */
    public boolean queryCarIsExist(String str) {
        
        ArrayList<CarBean> list = new ArrayList<>();
        
        String[] selectioinArgs = {str};//注意：这里没有单引号
        String sql = "select " + "carNum,oilMess,airFilterMess,machineFilterMess,fixDate,mileage,titlePrice" + " from " + TABLE_NAME
                + " where " + carNum + " = ? ";
        
        Cursor cursor = mDatabase.rawQuery(sql, selectioinArgs);
        
        if (cursor.getCount()>0){
            return true;
        }
      
        return false;
    }
    
    /**
     * 指定车辆模糊查询
     *
     * @param str 车牌号查询
     * @return CarBean
     */
    public ArrayList<CarBean> queryDataByCarNum(String str) {
        
        ArrayList<CarBean> list = new ArrayList<>();
        
        String[] selectioinArgs = {"%" + str + "%"};//注意：这里没有单引号
        String sql = "select " + "*" + " from " + TABLE_NAME
                + " where " + carNum + " like ? order by carNum ";
        
        Cursor cursor = mDatabase.rawQuery(sql, selectioinArgs);
        
        int idIndex = cursor.getColumnIndex("_id");
        int carNumIndex = cursor.getColumnIndex(carNum);
        int oilMessIndex = cursor.getColumnIndex(oilMess);
        int airFilterMessIndex = cursor.getColumnIndex(airFilterMess);
        int machineFilterMessIndex = cursor.getColumnIndex(machineFilterMess);
        int fixDateIndex = cursor.getColumnIndex(fixDate);
        int mileageIndex = cursor.getColumnIndex(mileage);
        int titlePriceIndex = cursor.getColumnIndex(titlePrice);
        int ownerIndex = cursor.getColumnIndex(owner);
        int phoneIndex = cursor.getColumnIndex(phone);
        int othersIndex = cursor.getColumnIndex(others);
        int otherProIndex = cursor.getColumnIndex(otherPro);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(idIndex);
            String carNum = cursor.getString(carNumIndex);
            String oilMess = cursor.getString(oilMessIndex);
            String airFilterMess = cursor.getString(airFilterMessIndex);
            String machineFilterMess = cursor.getString(machineFilterMessIndex);
            String fixDate = cursor.getString(fixDateIndex);
            String mileage = cursor.getString(mileageIndex);
            String titlePrice = cursor.getString(titlePriceIndex);
            String owner = cursor.getString(ownerIndex);
            String phone = cursor.getString(phoneIndex);
            String others = cursor.getString(othersIndex);
            String otherPro = cursor.getString(otherProIndex);
            
            CarBean carBean = new CarBean(id, carNum, oilMess, airFilterMess, machineFilterMess, fixDate, mileage, titlePrice, owner, phone, others, otherPro);
            list.add(carBean);
        }
        cursor.close();
        return list;
    }
    
    
    /**
     * 查询指定日期数据
     *
     * @param date 车牌号查询
     * @return CarBean
     */
    public ArrayList<CarBean> queryByDate(String date) {
        ArrayList<CarBean> list = new ArrayList<>();
        
        String[] selectioinArgs = {date};//注意：这里没有单引号
        String sql = "select * from Fix_Record where fixDate = ?";
        Cursor cursor = mDatabase.rawQuery(sql, selectioinArgs);
        
        int carNumIndex = cursor.getColumnIndex(carNum);
        int oilMessIndex = cursor.getColumnIndex(oilMess);
        int airFilterMessIndex = cursor.getColumnIndex(airFilterMess);
        int machineFilterMessIndex = cursor.getColumnIndex(machineFilterMess);
        int titlePriceIndex = cursor.getColumnIndex(titlePrice);
        int fixDateIndex = cursor.getColumnIndex(fixDate);
        while (cursor.moveToNext()) {
            String carNum = cursor.getString(carNumIndex);
            String oilMess = cursor.getString(oilMessIndex);
            String airFilterMess = cursor.getString(airFilterMessIndex);
            String machineFilterMess = cursor.getString(machineFilterMessIndex);
            String titlePrice = cursor.getString(titlePriceIndex);
            String fixDate = cursor.getString(fixDateIndex);
            CarBean carBean = new CarBean(carNum, oilMess, airFilterMess, machineFilterMess, fixDate, "0", titlePrice);
            list.add(carBean);
        }
        cursor.close();
        return list;
    }
    
    
    /**
     * 查询七天数据
     *
     * @return CarBean
     */
    public TodayEarningsBean queryByDay() {
        ArrayList<String> dates = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();
        String sql = "select sum(titlePrice),fixDate from Fix_Record group by fixDate order by fixDate desc limit 0,7";
        Cursor cursor = mDatabase.rawQuery(sql, null);
        
        
        int titlePriceIndex = cursor.getColumnIndex("sum(titlePrice)");
        int fixDateIndex = cursor.getColumnIndex(fixDate);
        while (cursor.moveToNext()) {
            int titlePrice = cursor.getInt(titlePriceIndex);
            String fixDate = cursor.getString(fixDateIndex);
//            String substring = fixDate.substring(5, fixDate.length());
            String substring = fixDate;
            dates.add(substring);
            prices.add(titlePrice);
        }
        TodayEarningsBean bean = new TodayEarningsBean(dates, prices);
        cursor.close();
        return bean;
    }
    
    
    public CarBean queryToday(String currentDate) {
        CarBean carBean = new CarBean();
        
        String sql = "select sum(titlePrice),fixDate from Fix_Record where fixDate = ?";
        Cursor cursor = mDatabase.rawQuery(sql, new String[]{currentDate});
        
        
        int titlePriceIndex = cursor.getColumnIndex("sum(titlePrice)");
        int fixDateIndex = cursor.getColumnIndex(fixDate);
        while (cursor.moveToNext()) {
            int titlePrice = cursor.getInt(titlePriceIndex);
            String fixDate = cursor.getString(fixDateIndex);
            carBean.setFixDate(fixDate);
            carBean.setTitlePrice(String.valueOf(titlePrice));
        }
        cursor.close();
        return carBean;
    }
    
    /**
     * 新增保养记录
     *
     * @param data 数据
     * @return long
     */
    public long insertFixRecords(CarBean data) {
        ContentValues values = new ContentValues();
        values.put(fixDate, DateUtil.getStringByFormat(data.getFixDate(), dateFormatYMD1, DateUtil.dateFormatYMD));
        values.put(carNum, data.getCarNum().toUpperCase());
        values.put(oilMess, data.getOilMess());
        values.put(machineFilterMess, data.getMachineFilterMess());
        values.put(airFilterMess, data.getAirFilterMess());
        values.put(titlePrice, data.getTitlePrice());
        values.put(mileage, data.getMileage());
        values.put(otherPro, data.getOtherPro());
        values.put(others, data.getOthers());
        
        long insert = mDatabase.insert(Fix_Record, null, values);
//        mDatabase.close();
        return insert;
    }
    
    /**
     * 新增保养记录
     *
     * @param data 数据
     * @return long
     */
    public long insertFixRecords(CarBean data, int i) {
        ContentValues values = new ContentValues();
        values.put(fixDate, data.getFixDate());
        values.put(carNum, data.getCarNum().toUpperCase());
        values.put(oilMess, data.getOilMess());
        values.put(machineFilterMess, data.getMachineFilterMess());
        values.put(airFilterMess, data.getAirFilterMess());
        values.put(titlePrice, data.getTitlePrice());
        values.put(mileage, data.getMileage());
        values.put(otherPro, data.getOtherPro());
        values.put(others, data.getOthers());
        
        long insert = mDatabase.insert(Fix_Record, null, values);
//        mDatabase.close();
        return insert;
    }
    
    /**
     * 查询保养记录
     *
     * @param plateNum 车牌号
     * @return CarBean保养记录
     */
    public ArrayList<CarBean> queryFixRecord(String plateNum) {
        ArrayList<CarBean> list = new ArrayList<>();
        Cursor cursor = mDatabase.rawQuery("select * from " + Fix_Record + " where carNum = ? order by _id desc", new String[]{plateNum});
        int carNumIndex = cursor.getColumnIndex(carNum);
        int oilMessIndex = cursor.getColumnIndex(oilMess);
        int airFilterMessIndex = cursor.getColumnIndex(airFilterMess);
        int machineFilterMessIndex = cursor.getColumnIndex(machineFilterMess);
        int fixDateIndex = cursor.getColumnIndex(fixDate);
        int mileageIndex = cursor.getColumnIndex(mileage);
        int titlePriceIndex = cursor.getColumnIndex(titlePrice);
        int otherProIndex = cursor.getColumnIndex(otherPro);
        int othersIndex = cursor.getColumnIndex(others);
        while (cursor.moveToNext()) {
            String carNum = cursor.getString(carNumIndex);
            String oilMess = cursor.getString(oilMessIndex);
            String airFilterMess = cursor.getString(airFilterMessIndex);
            String machineFilterMess = cursor.getString(machineFilterMessIndex);
            String fixDate = cursor.getString(fixDateIndex);
            String mileage = cursor.getString(mileageIndex);
            String titlePrice = cursor.getString(titlePriceIndex);
            String otherPro = cursor.getString(otherProIndex);
            String others = cursor.getString(othersIndex);
            
            CarBean carBean = new CarBean(carNum, oilMess, airFilterMess, machineFilterMess, fixDate, mileage, titlePrice);
            carBean.setOtherPro(otherPro);
            carBean.setOthers(others);
            list.add(carBean);
            
        }
        cursor.close();
        return list;
    }
    
    
    /**
     * @param data 新增配件
     */
    public void insertProducts(ProBean data) {
        ContentValues values = new ContentValues();
        values.put(name, data.getName());
        values.put(price, data.getPrice());
        values.put(type, data.getType());
        values.put(img, data.getImg());
        long insert = mDatabase.insert(PRODUCTS, null, values);
        if (insert != -1) {
            Toast toast = Toast.makeText(context, "添加成功", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
    
    /**
     * 依据类型 查询配件
     *
     * @param str
     * @return
     */
    public ArrayList<ProBean> queryProductData(String str) {
        
        ArrayList<ProBean> list = new ArrayList<>();
        
        String[] selectioinArgs = {str};//注意：这里没有单引号
        String sql = "select * from " + PRODUCTS
                + " where type = ? ";
        
        
        Cursor cursor = mDatabase.rawQuery(sql, selectioinArgs);
        
        int idIndex = cursor.getColumnIndex("_id");
        int nameIndex = cursor.getColumnIndex(name);
        int priceIndex = cursor.getColumnIndex(price);
        int typeIndex = cursor.getColumnIndex(type);
        int imgIndex = cursor.getColumnIndex(img);
        
        while (cursor.moveToNext()) {
            int id = cursor.getInt(idIndex);
            String type = cursor.getString(typeIndex);
            String name = cursor.getString(nameIndex);
            int price = cursor.getInt(priceIndex);
            byte[] img = cursor.getBlob(imgIndex);
            
            
            ProBean data = new ProBean(id, type, name, price);
            data.setImg(img);
            list.add(data);
        }
        cursor.close();
        return list;
    }
    
    
    /**
     * 删除配件
     *
     * @param str
     * @return
     */
    public int deleteProductData(String str) {
        return mDatabase.delete(PRODUCTS, "_id =?", new String[]{str});
        
    }
    
    /**
     * 查询 每日收益
     *
     * @param date 日期
     * @return
     */
    public ArrayList<CarBean> queryDataByField(String date) {
        
        ArrayList<CarBean> list = new ArrayList<>();
        
        String[] selectioinArgs = {date};//注意：这里没有单引号
        String sql = "select * from  Fix_Record where fixDate  = ? ";
        
        Cursor cursor = mDatabase.rawQuery(sql, selectioinArgs);
        int carNumIndex = cursor.getColumnIndex(carNum);
        int fixDateIndex = cursor.getColumnIndex(fixDate);
        int titlePriceIndex = cursor.getColumnIndex(titlePrice);
        int oilMessIndex = cursor.getColumnIndex(oilMess);
        int airFilterMessIndex = cursor.getColumnIndex(airFilterMess);
        int machineFilterMessIndex = cursor.getColumnIndex(machineFilterMess);
        int mileageIndex = cursor.getColumnIndex(mileage);
        
        while (cursor.moveToNext()) {
            String carNum = cursor.getString(carNumIndex);
            int titlePrice = cursor.getInt(titlePriceIndex);
            String fixDate = cursor.getString(fixDateIndex);
            String oilMess = cursor.getString(oilMessIndex);
            String airFilterMess = cursor.getString(airFilterMessIndex);
            String machineFilterMess = cursor.getString(machineFilterMessIndex);
            String mileage = cursor.getString(mileageIndex);
            
            CarBean carBean = new CarBean(carNum, oilMess, airFilterMess, machineFilterMess, fixDate, mileage, String.valueOf(titlePrice));
            list.add(carBean);
        }
        cursor.close();
        return list;
    }
    
    /**
     * 查询 每月收益
     *
     * @param count 日期
     * @return
     */
    public ArrayList<CarBean> queryDataByMonth(String count) {
        
        ArrayList<CarBean> list = new ArrayList<>();
        
        String[] selectioinArgs = {count};//注意：这里没有单引号
        String sql = "select fixDate,sum(titlePrice) from  Fix_Record group by fixDate limit 0,?";
        
        Cursor cursor = mDatabase.rawQuery(sql, selectioinArgs);
        int titlePriceIndex = cursor.getColumnIndex("sum(titlePrice)");
        int fixDateIndex = cursor.getColumnIndex(fixDate);
        LogUtil.e("CAO", "----------->" + cursor.getCount());
        while (cursor.moveToNext()) {
            int titlePrice = cursor.getInt(titlePriceIndex);
            String fixDate = cursor.getString(fixDateIndex);
            CarBean carBean = new CarBean();
//            LogUtil.e("CAO","--------titlePrice--->"+titlePrice);
//            LogUtil.e("CAO","--------fixDate--->"+fixDate);
            carBean.setFixDate(fixDate);
            carBean.setTotalToday(titlePrice);
            list.add(carBean);
        }
        cursor.close();
        return list;
    }
    
    private void createCost(SQLiteDatabase db) {
        // 建表 5 进货表
        String sql4 = "create table " +
                Cost +
                "(_id integer primary key autoincrement, " +
                name + " varchar, " +
                date + " varchar, " +
                merchant + " varchar, " +
                phone + " varchar, " +
                singlePrice + " integer, " +
                count + " integer, " +
                totalPrice + " integer"
                + ")";
        
        db.execSQL(sql4);
    }
    
    /**
     * //新增货物
     * <p>
     * Cost +
     * "(_id integer primary key autoincrement, " +
     * name + " varchar, " +
     * date + " varchar, " +
     * merchant + " varchar, " +
     * phone + " varchar, " +
     * singlePrice + " integer, " +
     * count + " integer, " +
     * totalPrice + " integer"
     * + ")";
     *
     * @param data 数据
     */
    public long insertCosts(CostBean data) {
        ContentValues values = new ContentValues();
        
        values.put(name, data.getName());
        values.put(date, data.getDate());
        values.put(merchant, data.getMerchant());
        values.put(phone, data.getPhone());
        values.put(singlePrice, data.getSinglePrice());
        values.put(count, data.getCount());
        values.put(totalPrice, data.getTotalPrice());
        
        long insert = mDatabase.insert(Cost, null, values);
        
        return insert;
        
    }
    
    /**
     * 查询进货单
     *
     * @param startIndex 起始索引
     * @param endIndex   展示条数
     * @return CostBean
     */
    public List<CostBean> queryCosts(String startIndex, String endIndex) {
        String[] strings = {startIndex, endIndex};
        String sql = "select * from Cost order by date desc limit ?,?";
        Cursor cursor = mDatabase.rawQuery(sql, strings);
        
        ArrayList<CostBean> list = new ArrayList<>();
        int idIndex = cursor.getColumnIndex("_id");
        int nameIndex = cursor.getColumnIndex(name);
        int dateIndex = cursor.getColumnIndex(date);
        int merchantIndex = cursor.getColumnIndex(merchant);
        int phoneIndex = cursor.getColumnIndex(phone);
        int singlePriceIndex = cursor.getColumnIndex(singlePrice);
        int countIndex = cursor.getColumnIndex(count);
        int totalPriceIndex = cursor.getColumnIndex(totalPrice);
        while (cursor.moveToNext()) {
            String id = cursor.getString(idIndex);
            String name = cursor.getString(nameIndex);
            String date = cursor.getString(dateIndex);
            String merchant = cursor.getString(merchantIndex);
            String phone = cursor.getString(phoneIndex);
            int singlePrice = cursor.getInt(singlePriceIndex);
            int count = cursor.getInt(countIndex);
            int totalPrice = cursor.getInt(totalPriceIndex);
            CostBean bean = new CostBean();
            bean.setId(id);
            bean.setName(name);
            bean.setDate(date);
            bean.setMerchant(merchant);
            bean.setPhone(phone);
            bean.setSinglePrice(Integer.parseInt(String.valueOf(singlePrice)));
            bean.setCount(Integer.parseInt(String.valueOf(count)));
            bean.setTotalPrice(Integer.parseInt(String.valueOf(totalPrice)));
            list.add(bean);
        }
        
        cursor.close();
        return list;
    }
    
    /**
     * 删除进货单
     *
     * @return CarBean
     */
    public boolean deleteCost(String id) {
//        String[] strings = {id};
//        String sql = "delete from Cost where _id = ?";
//        mDatabase.execSQL(sql,strings);
//
//       return true;
        
        
        String[] strings = {id};
        int delete = mDatabase.delete(Cost, "_id = ?", strings);
        if (delete != -1) {
            return true;
        }
        return false;
    }
    
    /***
     *  新增供货商
     * Supplier //表名
     *  name; //名称
     *  address; //地址
     *  product; //产品
     *  phone;   //电话
     *  type; //编号
     */
    
    private void createSupplier(SQLiteDatabase db) {
        // 建表 5 进货表
        String sql = "create table " +
                Supplier +
                "(_id integer primary key autoincrement, " +
                name + " varchar, " +
                address + " varchar, " +
                product + " varchar, " +
                phone + " varchar " +
                ")";
        
        db.execSQL(sql);
    }
    
    public long insertSupplier(SupplierBean data) {
        ContentValues values = new ContentValues();
        
        values.put(name, data.getName());
        values.put(address, data.getAddress());
        values.put(product, data.getProduct());
        values.put(phone, data.getPhone());
//        values.put(type, data.getType());
        
        long insert = mDatabase.insert(Supplier, null, values);
        
        return insert;
        
    }
    
    /**
     * 查询供货商
     *
     * @return CostBean
     */
    public List<SupplierBean> querySupplier() {
        String sql = "select * from Supplier";
        Cursor cursor = mDatabase.rawQuery(sql, null);
        
        ArrayList<SupplierBean> list = new ArrayList<>();
        int idIndex = cursor.getColumnIndex("_id");
        int nameIndex = cursor.getColumnIndex(name);
        int addressIndex = cursor.getColumnIndex(address);
        int productIndex = cursor.getColumnIndex(product);
        int phoneIndex = cursor.getColumnIndex(phone);
//        int typeIndex = cursor.getColumnIndex(type);
        while (cursor.moveToNext()) {
            String id = cursor.getString(idIndex);
            String name = cursor.getString(nameIndex);
            String address = cursor.getString(addressIndex);
            String product = cursor.getString(productIndex);
            String phone = cursor.getString(phoneIndex);
//            int type = cursor.getInt(typeIndex);
            SupplierBean bean = new SupplierBean();
            bean.setId(id);
            bean.setName(name);
            bean.setAddress(address);
            bean.setProduct(product);
            bean.setPhone(phone);
//            bean.setType(Integer.parseInt(String.valueOf(type)));
            list.add(bean);
        }
        
        cursor.close();
        return list;
    }
    
    /**
     * 删除供货商
     *
     * @return CarBean
     */
    public boolean deleteSupplier(String id) {
        String[] strings = {id};
        int delete = mDatabase.delete(Supplier, "_id = ?", strings);
        if (delete != -1) {
            return true;
        }
        return false;
    }
    
    
    /**
     * 修改供货商
     *
     * @return CarBean
     */
    public boolean updateSupplier(String id, SupplierBean data) {
        String[] strings = {id};
        ContentValues values = new ContentValues();
        values.put(name, data.getName());
        values.put(address, data.getAddress());
        values.put(product, data.getProduct());
        values.put(phone, data.getPhone());
//        values.put(type, data.getType());
        int delete = mDatabase.update(Supplier, values, "_id = ?", strings);
        if (delete != -1) {
            return true;
        }
        return false;
    }
    
    /**
     * 跟新供货商产品
     *
     * @return CarBean
     */
    public boolean updateSupplierProduct(String id, String pro) {
        String[] strings = {id};
        ContentValues values = new ContentValues();
        values.put(product, pro);
//        values.put(type, data.getType());
        int delete = mDatabase.update(Supplier, values, "_id = ?", strings);
        if (delete != -1) {
            return true;
        }
        return false;
    }
}
