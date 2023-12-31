package com.web.entity;

import java.sql.Timestamp;

public class Order {
    /*
    oId INT(16) PRIMARY KEY AUTO_INCREMENT  COMMENT '订单id号',
                            totalMoney DOUBLE NOT NULL  COMMENT '订单总价格',
                            oState INT(16) NOT NULL  COMMENT '订单状态标识',
                            tableId VARCHAR(64) NOT NULL  COMMENT '订单桌台号',
                            pickupId VARCHAR(500) NOT NULL  COMMENT '订单取餐号',
                            orderTime TIMESTAMP NOT NULL  COMMENT '订单创建时间',
                            uid INT(16) NOT NULL  COMMENT '外键，订单所属用户id号'
     */

    private int oId;
    private Double totalMoney;
    private int oState;
    private String tableId;
    private String pickupId;
    private Timestamp orderTime;
    private int uid;


    public Order(Double totalMoney, int oState, String tableId, String pickupId, Timestamp orderTime, int uid) {
        this.totalMoney = totalMoney;
        this.oState = oState;
        this.tableId = tableId;
        this.pickupId = pickupId;
        this.orderTime = orderTime;
        this.uid = uid;
    }

    public Order(int oid, Double totalMoney, int oState, String tableId, String pickupId, Timestamp orderTime, int uid){
        this.oId = oid;
        this.totalMoney = totalMoney;
        this.oState = oState;
        this.tableId = tableId;
        this.pickupId = pickupId;
        this.orderTime = orderTime;
        this.uid = uid;
    }

    public Order(){}

    public int getOid() {
        return oId;
    }

    public void setOid(int oid) {
        this.oId = oid;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getoState() {
        return oState;
    }

    public void setoState(int oState) {
        this.oState = oState;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getPickupId() {
        return pickupId;
    }

    public void setPickupId(String pickupId) {
        this.pickupId = pickupId;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
