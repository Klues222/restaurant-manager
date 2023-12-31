package com.web.dao;

import com.web.entity.Cart;
import com.web.mapper.CartMapper;
import com.web.util.DBUtil;

import java.sql.Timestamp;
import java.util.List;

public class CartDao {
//    得到用户的购物车
    public List get(int uId){
        return DBUtil.queryForList("select * from cart_info where uId = ? and oId = 0",new CartMapper(),uId);
    }

    public Cart getACartByCtId(int ctId){
        return (Cart) DBUtil.queryForObject("select * from cart_info where ctId = ?",new CartMapper(),ctId);
    }

//    新建购物车
    public int set(int uId, int gId, int gNum, Timestamp ctTime ,String specif){
        return DBUtil.update("Insert into cart_info (uId,gId,gNum,ctTime,specif,oId) values(?,?,?,?,?,0)",uId,gId,gNum,ctTime,specif);

    }
//    删除某一用户的所有购物车
    public int delAll(int uId){
        return DBUtil.update("delete from cart_info where uId = ? and oId = 0",uId);
    }
//    删除用户前先删购物车
    public int delAlluser(int uId){
        return DBUtil.update("delete from cart_info where uId = ?",uId);
    }
//    用户删除自己的购物车
    public int del(int ctId){
        return DBUtil.update("delete from cart_info where ctId = ?",ctId);
    }
//    将购物车绑定订单
    public int carToOrder(int ctId,int oId){
        return DBUtil.update("Update cart_info set oId = ? where ctId = ?",oId,ctId);
    }
//    删除所有有某一商品的购物车
    public int delByGoods(int gid){
        return DBUtil.update("delete from cart_info where gid = ?",gid);
    }
//    删除所有有某一订单的购物车
    public int delByOrders(int oid){
        return DBUtil.update("delete from cart_info where oid = ?",oid);
    }
}
