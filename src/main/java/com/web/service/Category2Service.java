package com.web.service;

import  com.web.dao.Category1Dao;
import com.web.dao.Category2Dao;
import com.web.dao.GoodsDao;
import com.web.entity.Category1;
import com.web.entity.Category2;
import com.web.entity.Goods;
import com.web.servlet.SearchByName;

import java.util.ArrayList;
import java.util.List;
public class Category2Service {
    Category2Dao category2Dao = new Category2Dao();
    //    得到所有二级商品
    public List SearchType(){
        List list = category2Dao.getAll();
        return list;
    }
    //    删除某一二级商品
    public boolean delCategory2(int csId){
        int ok = category2Dao.delCategory2(csId);
        if(ok>0){
            return true;
        }else{
            return false;
        }
    }
    //    新增二级商品
    public boolean addCategory2(String csname,int cId){
        int ok = category2Dao.addCategory2(csname,cId);
        if (ok>0){
            return true;
        }else return false;
    }
}
