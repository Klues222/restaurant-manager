package com.web.service;

import com.web.dao.CartDao;
import com.web.dao.Cart_GoodsDao;

import java.sql.Timestamp;
import java.util.List;

public class CartService {
    CartDao cartDao = new CartDao();
    Cart_GoodsDao cart_goodsDao = new Cart_GoodsDao();
//    购物车生成
    public boolean makeCart(int uId, int gId, int gNum, Timestamp ctTime , String specif){
        int ok = cartDao.set(uId,gId,gNum,ctTime,specif);
        if (ok>0){
            return true;
        }else return false;
    }
    //    删除某一用户的所有购物车
    public boolean DelAll(int uId){
        int ok = cartDao.delAll(uId);
        if (ok>0){
            return true;
        }else return false;
    }
//    删除用户前先删购物车
    public boolean DelUser(int uId){
        int ok = cartDao.delAlluser(uId);
        if (ok>0){
            return true;
        }else return false;
    }
//    用户删除自己的购物车
    public boolean Del(int ctId){
        int ok = cartDao.del(ctId);
        if (ok>0){
            return true;
        }else return false;
    }
    //    得到一个用户的购物车
    public List GetAll(int uId){
        return cart_goodsDao.get(uId);
    }
    //    将购物车绑定订单
    public int addCartToOrder(int ctId,int oId){
        return cartDao.carToOrder(ctId,oId);
    }
    //    删除所有有某一商品的购物车
    public boolean DelByGoods(int gid){
        int ok = cartDao.delByGoods(gid);
        if (ok>0){
            return true;
        }else return false;
    }
    //    删除所有有某一订单的购物车
    public boolean DelByOrders(int oid){
        int ok = cartDao.delByOrders(oid);
        if (ok>0){
            return true;
        }else return false;
    }

}
