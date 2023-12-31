package com.web.entity;

public class User {
    private int uid;
    private  String username;
    private  String password;
    private  String name;
    private  String sex;
    private String telephone;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String name, String sex, String telephone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.telephone = telephone;
    }

    public User(int uid, String username, String password, String name, String sex, String telephone) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.telephone = telephone;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
