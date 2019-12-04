package com.global.util;

import android.content.Context;

import com.global.bean.Parking;
import com.waterbase.global.AppConfig;
import com.waterbase.utile.PreferencesManager;

/**
 * 作者：Laughing on 2019-3-25 10:34
 * 邮箱：719240226@qq.com
 */
public class CacheUtil {

    public static void cacheParkingInfo(Context context, Parking parking) {
        PreferencesManager.getInstance(context).put(AppConfig.parkingLotId, parking.getId());//缓存停车场ID
        PreferencesManager.getInstance(context).put(AppConfig.parkingLotName, parking.getParkingLotName());//缓存停车场名称
        PreferencesManager.getInstance(context).put(AppConfig.ParkingLotNumber, parking.getParkingLotNumber());//缓存停车场编号
        PreferencesManager.getInstance(context).put(AppConfig.parkingLotPublic, parking.getCarLotPublic());//缓存停车场数量
    }

    public static Parking getParkingInfo(Context context) {
        Parking parking = new Parking();
        parking.setId(PreferencesManager.getInstance(context).get(AppConfig.parkingLotId));//缓存停车场ID
        parking.setParkingLotName(PreferencesManager.getInstance(context).get(AppConfig.parkingLotName));//缓存停车场名称
        parking.setParkingLotNumber(PreferencesManager.getInstance(context).get(AppConfig.ParkingLotNumber));//缓存停车场编号
        parking.setCarLotPublic(PreferencesManager.getInstance(context).get(AppConfig.parkingLotPublic,1));//缓存停车场数量

        return parking;
    }
}
