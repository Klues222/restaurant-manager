package com.web.entity;

import java.sql.Timestamp;

public class Goods {
    private int gId;
    private String gName;
    private Double shopPrice;
    private String image;
    private String g_desc;
    private int g_number;
    private int csid;
    private int saleNum;
    private int gState;
    private Timestamp gDate;
    public Goods(){}

    @Override
    public String toString() {
        return "Goods{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                ", shopPrice=" + shopPrice +
                ", image='" + image + '\'' +
                ", g_desc='" + g_desc + '\'' +
                ", g_number=" + g_number +
                ", csid=" + csid +
                ", saleNum=" + saleNum +
                ", gState=" + gState +
                ", gDate=" + gDate +
                '}';
    }

    public Goods(int gId, String gName, Double shopPrice, String image, String g_desc, int g_number, int csid, int saleNum, int gState, Timestamp gDate) {
        this.gId = gId;
        this.gName = gName;
        this.shopPrice = shopPrice;
        this.image = image;
        this.g_desc = g_desc;
        this.g_number = g_number;
        this.csid = csid;
        this.saleNum = saleNum;
        this.gState = gState;
        this.gDate = gDate;
    }


    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getG_desc() {
        return g_desc;
    }

    public void setG_desc(String g_desc) {
        this.g_desc = g_desc;
    }

    public int getG_number() {
        return g_number;
    }

    public void setG_number(int g_number) {
        this.g_number = g_number;
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public int getgState() {
        return gState;
    }

    public void setgState(int gState) {
        this.gState = gState;
    }

    public Timestamp getgDate() {
        return gDate;
    }

    public void setgDate(Timestamp gDate) {
        this.gDate = gDate;
    }
}
