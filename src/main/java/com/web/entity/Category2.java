package com.web.entity;

public class Category2 {
    private int csid;
    private  String csname;
    private int cid;

    public Category2(int csid, String csname, int cid) {
        this.csid = csid;
        this.csname = csname;
        this.cid = cid;
    }

    public Category2() {
    }

    public int getCsid() {
        return csid;
    }

    public void setCsid(int csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
