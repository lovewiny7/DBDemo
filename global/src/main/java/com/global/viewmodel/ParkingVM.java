package com.global.viewmodel;

import com.global.bean.Parking;

/**
 * 停车场列表
 * 作者：Laughing on 2019-3-12 15:25
 * 邮箱：719240226@qq.com
 */
public class ParkingVM {

    /**
     * carLotPublic : 3
     * id : 24830930-e395-11e7-bb4e-448a5bd4aa77
     * parkingLotName : 测试共享停车场陕西省西安市雁塔区
     * parkingLotNumber : UXW001
     */
    private Parking data;
    private int carLotPublic;
    private String id;
    private String parkingLotName;
    private String parkingLotNumber;

    public ParkingVM(Parking data) {
        this.data = data;

    }

    public String getId() {
        return data.getId();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkingLotName() {
        return data.getParkingLotName();
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getCarLotPublic() {
        return data.getCarLotPublic() + "";
    }

    public void setCarLotPublic(int carLotPublic) {
        this.carLotPublic = carLotPublic;
    }

    public String getParkingLotNumber() {
        return data.getParkingLotNumber();
    }

    public void setParkingLotNumber(String parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }

}
