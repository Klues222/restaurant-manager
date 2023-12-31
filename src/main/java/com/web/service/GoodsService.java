package com.web.service;

import  com.web.dao.Category1Dao;
import com.web.dao.Category2Dao;
import com.web.dao.GoodsDao;
import com.web.entity.Category1;
import com.web.entity.Category2;
import com.web.entity.Goods;
import com.web.servlet.SearchByName;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GoodsService {
    GoodsDao goodsDao = new GoodsDao();
    //    得到所有状态为1的商品
    public List listAllGoods(){
        return goodsDao.getAll();
    }
    //    得到所有商品
    public List GetAllGoods(){
        return goodsDao.getAllGoods();
    }
    //    根据名字查商品
    public List SearchByName(String name){
        return goodsDao.selectByName(name);
    }
//    根据一级商品名查询商品
    public List SearchByOneType(String oneName){
        Category1Dao category1Dao = new Category1Dao();
        List list = category1Dao.getByCname(oneName);
        List<Goods> goods = new ArrayList();
        for(int i=0;i<list.size();i++){
            Category1 category1 = (Category1) list.get(i);
            List aGoods = goodsDao.selectByOneType(category1.getCid());
            for(int j=0;j<aGoods.size();j++){
                goods.add((Goods) aGoods.get(j));
            }
        }
        return goods;
    }
    //    根据二级商品名模糊查询
    public List SearchByType(String name){
        Category2Dao category2Dao = new Category2Dao();
        List list = category2Dao.getByName(name);
        List<Goods> goods = new ArrayList();
        for (int i = 0;i<list.size();i++){
            Category2 category2 = (Category2) list.get(i);
            List aGoods = goodsDao.selectByType(category2.getCsid());
            for (int j = 0;j<aGoods.size();j++){
                goods.add((Goods) aGoods.get(j));
            }

        }
        return goods;
    }
    //    删除商品
    public boolean delGoods(int gid){

        int ok = goodsDao.delGoods(gid);
        if(ok>0){
            return true;
        }else{
            return false;
        }
    }
    //    更新某一商品的销量和库存
    public int upDateGNumber(int gNumber ,int saleNum , int gId){
        return goodsDao.upDateGNumber(gNumber,saleNum,gId);
    }
//    新增商品
    public boolean addNewGoods(String gName, double shopPrice, String image, String g_desc, int g_number, int gState, Timestamp gDate, int csId,int saleNum){
        int ok = goodsDao.addNewGoods(gName,shopPrice,image,g_desc,g_number,gState,gDate,csId,saleNum);
        if(ok>0){
            return true;
        }else{
            return false;
        }
    }
    //    增加库存
    public boolean addGoodsNumber(int gNumber,int gId){
        int ok = goodsDao.addGoodsNumber(gNumber,gId);
        if(ok>0){
            return true;
        }else{
            return false;
        }
    }
}
