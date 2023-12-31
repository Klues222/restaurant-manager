package com.web.entity;

import java.sql.Timestamp;

public class Cart {
    private  int ctId;
    private  int uId;
    private  int gId;
    private  int gNum;
    private Timestamp ctTime;
    private String specif;

    public Cart(int uId, int gId, int gNum, Timestamp ctTime, String specif) {
        this.uId = uId;
        this.gId = gId;
        this.gNum = gNum;
        this.ctTime = ctTime;
        this.specif = specif;
    }

    public Cart(int ctId, int uId, int gId, int gNum, Timestamp ctTime, String specif, int oId) {
        this.ctId = ctId;
        this.uId = uId;
        this.gId = gId;
        this.gNum = gNum;
        this.ctTime = ctTime;
        this.specif = specif;
        this.oId = oId;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    private int oId;
    public Cart() {
    }

    public Cart(int ctId, int uId, int gId, int gNum, Timestamp ctTime, String specif) {
        this.ctId = ctId;
        this.uId = uId;
        this.gId = gId;
        this.gNum = gNum;
        this.ctTime = ctTime;
        this.specif = specif;
    }

    public int getCtId() {
        return ctId;
    }

    public void setCtId(int ctId) {
        this.ctId = ctId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    public int getgNum() {
        return gNum;
    }

    public void setgNum(int gNum) {
        this.gNum = gNum;
    }

    public Timestamp getCtTime() {
        return ctTime;
    }

    public void setCtTime(Timestamp ctTime) {
        this.ctTime = ctTime;
    }

    public String getSpecif() {
        return specif;
    }

    public void setSpecif(String specif) {
        this.specif = specif;
    }
}
