package com.web.entity;

public class Admin {
    /*
    aId INT(16) PRIMARY KEY AUTO_INCREMENT COMMENT '管理员id号',
                            aName VARCHAR(64) unique NOT NULL  COMMENT '管理员用户名',
                            aPassword VARCHAR(64) NOT NULL  COMMENT '管理员密码',
                            aTelephone VARCHAR(64)  NOT NULL  COMMENT '管理员电话'
     */
    private int aId;

    private String aName;
    private String aPassword;
    private String aTelephone;
    public Admin(){

    }
    public Admin(String aName,String aPassword){
        this.aName = aName;
        this.aPassword = aPassword;
    }

    public Admin(String aName, String aPassword, String aTelephone) {
        this.aName = aName;
        this.aPassword = aPassword;
        this.aTelephone = aTelephone;
    }

    public Admin(int aId, String aName, String aPassword, String aTelephone){
        this.aName = aName;
        this.aPassword = aPassword;
        this.aTelephone = aTelephone;
        this.aId = aId;
    }
    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public String getaTelephone() {
        return aTelephone;
    }

    public void setaTelephone(String aTelephone) {
        this.aTelephone = aTelephone;
    }
}
