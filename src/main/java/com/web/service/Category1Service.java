package com.web.service;

import com.web.dao.Category1Dao;

import java.util.List;

public class Category1Service {
    Category1Dao category1Dao = new Category1Dao();
    //    得到所有一级商品内容
    public List SearchType(){
        List list = category1Dao.getAll();
        return list;
    }
}
