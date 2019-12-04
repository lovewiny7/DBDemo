package com.global.bean;

import java.util.List;

/**
 * 停车场列表
 * 作者：Laughing on 2019-3-12 15:25
 * 邮箱：719240226@qq.com
 */
public class ParkingLotListBean {
    private List<Parking> parkingLotlist;

    public List<Parking> getParkingLotlist() {
        return parkingLotlist;
    }

    public void setParkingLotlist(List<Parking> parkingLotlist) {
        this.parkingLotlist = parkingLotlist;
    }
}
