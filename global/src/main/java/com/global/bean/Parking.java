package com.global.bean;

import java.io.Serializable;

/**
 * 停车场列表
 * 作者：Laughing on 2019-3-12 15:25
 * 邮箱：719240226@qq.com
 */
public class Parking implements Serializable {

    /**
     * carLotPublic : 3
     * id : 24830930-e395-11e7-bb4e-448a5bd4aa77
     * parkingLotName : 测试共享停车场陕西省西安市雁塔区
     * parkingLotNumber : UXW001
     */

    private int carLotPublic;//车位数
    private String id;//车场id
    private String parkingLotName;//停车场名字
    private String parkingLotNumber;//停车场编号

    public Parking() {

    }

    /**
     * 两个 参数的构造方法供   A_Fee_Add "费用添加" 使用
     *
     * @param id
     * @param parkingLotName
     */
    public Parking(String id, String parkingLotName) {
        this.id = id;
        this.parkingLotName = parkingLotName;
    }

    public int getCarLotPublic() {
        return carLotPublic;
    }

    public void setCarLotPublic(int carLotPublic) {
        this.carLotPublic = carLotPublic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getParkingLotNumber() {
        return parkingLotNumber;
    }

    public void setParkingLotNumber(String parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }
}
