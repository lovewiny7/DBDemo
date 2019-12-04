package com.global.bean;

import java.math.BigDecimal;

/**
 * 提现申请
 * 作者：Laughing on 2019-3-14 15:12
 * 邮箱：719240226@qq.com
 */
public class ParkingLotWithdrawApplicationBean {


    /**
     * accountId : bf4005d3-e72c-11e8-b6d7-448a5bd4aa77
     * createTime : 1542190402000
     * modifyTime : 1552545226000
     * offlineParkingTotalAmount : 90.64
     * offlineParkingTotalWithdrawcash : 60.13
     * otherwayWithdrawcashTotal : 0.5
     * ownerIdCardNumber : 1147258369333333333
     * ownerMobileNumber : 18629248290
     * parkingLotId : 27ff1d8f-e493-11e7-bb4e-448a5bd4aa77
     * parkingLotName : 会展中心停车场
     * parkingLotOwner : 刘德华
     * toBankCardNumber : 9999999999999999999
     * toBankName : 农业银行
     */

    private String accountId;
    private BigDecimal balance;
    private Long createTime;
    private Long modifyTime;
    private BigDecimal offlineParkingTotalAmount;
    private BigDecimal offlineParkingTotalWithdrawcash;
    private BigDecimal otherwayWithdrawcashTotal;
    private String ownerIdCardNumber;
    private String ownerMobileNumber;
    private String parkingLotId;
    private String parkingLotName;
    private String parkingLotOwner;
    private String toBankCardNumber;
    private String toBankName;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public BigDecimal getOfflineParkingTotalAmount() {
        return offlineParkingTotalAmount;
    }

    public void setOfflineParkingTotalAmount(BigDecimal offlineParkingTotalAmount) {
        this.offlineParkingTotalAmount = offlineParkingTotalAmount;
    }

    public BigDecimal getOfflineParkingTotalWithdrawcash() {
        return offlineParkingTotalWithdrawcash;
    }

    public void setOfflineParkingTotalWithdrawcash(BigDecimal offlineParkingTotalWithdrawcash) {
        this.offlineParkingTotalWithdrawcash = offlineParkingTotalWithdrawcash;
    }

    public BigDecimal getOtherwayWithdrawcashTotal() {
        return otherwayWithdrawcashTotal;
    }

    public void setOtherwayWithdrawcashTotal(BigDecimal otherwayWithdrawcashTotal) {
        this.otherwayWithdrawcashTotal = otherwayWithdrawcashTotal;
    }

    public String getOwnerIdCardNumber() {
        return ownerIdCardNumber;
    }

    public void setOwnerIdCardNumber(String ownerIdCardNumber) {
        this.ownerIdCardNumber = ownerIdCardNumber;
    }

    public String getOwnerMobileNumber() {
        return ownerMobileNumber;
    }

    public void setOwnerMobileNumber(String ownerMobileNumber) {
        this.ownerMobileNumber = ownerMobileNumber;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getParkingLotOwner() {
        return parkingLotOwner;
    }

    public void setParkingLotOwner(String parkingLotOwner) {
        this.parkingLotOwner = parkingLotOwner;
    }

    public String getToBankCardNumber() {
        return toBankCardNumber;
    }

    public void setToBankCardNumber(String toBankCardNumber) {
        this.toBankCardNumber = toBankCardNumber;
    }

    public String getToBankName() {
        return toBankName;
    }

    public void setToBankName(String toBankName) {
        this.toBankName = toBankName;
    }

}
