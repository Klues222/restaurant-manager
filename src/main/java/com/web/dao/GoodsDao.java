package com.web.dao;

import com.web.entity.Goods;
import com.web.mapper.GoodsMapper;
import com.web.util.DBUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
//    得到所有状态为1的商品
    public List getAll(){

        List<Goods> list = new ArrayList<>();
        list = DBUtil.queryForList("select * from goods_info where gState = 1", new GoodsMapper());
        return list;
    }
//    得到所有商品
    public List getAllGoods(){
        return DBUtil.queryForList("select * from goods_info",new GoodsMapper());
    }
//    根据名字查商品
    public List selectByName(String name){
        List<Goods> list = new ArrayList<>();
        list = DBUtil.queryForList("select * from goods_info where gState = 1 and gName like ?", new GoodsMapper(),"%"+name+"%");
        return list;
    }
//    根二级商品查商品
    public List selectByType(int type){
        return DBUtil.queryForList("select * from goods_info where gState = 1 and csId = ?", new GoodsMapper(),type);
    }
//    根据一级商品查商品
    public  List selectByOneType(int type){
        return DBUtil.queryForList("select * from goods_info " +
                "join category_second on goods_info.csId = category_second.csId" +
                "join category_first on category_second.cId = category_first.cId where category_first.cId = ?",new GoodsMapper(),type);
    }
    public Goods selectBygId(int gId){
        return (Goods) DBUtil.queryForObject("select * from goods_info where gId = ?", new GoodsMapper(),gId);
    }
//    更新某一商品的销量和库存
    public int upDateGNumber(int gNumber,int saleNumber,int gId){
        return DBUtil.update("update goods_info set g_number = ? , saleNum = ? where gId = ?",gNumber,saleNumber,gId);
    }
//    删除商品
    public int delGoods(int gid){
        return DBUtil.update("delete from goods_info where gId =?",gid);
    }
//    增加新商品
    public int addNewGoods(String gName, double shopPrice, String image, String g_desc, int g_number, int gState, Timestamp gDate,int csId,int saleNum){
        return DBUtil.update("Insert into goods_info (gName,shopPrice,image,g_desc,g_number,gState,gDate,csId,saleNum) VALUES(?,?,?,?,?,?,?,?,?)",gName,shopPrice,image,g_desc,g_number,gState,gDate,csId,saleNum);
    }
//    增加库存
    public int addGoodsNumber(int gNumber,int gId){
        return DBUtil.update("update goods_info set g_number = ? where gId = ?",gNumber,gId);
    }
}
