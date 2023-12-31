package com.web.dao;

import com.web.mapper.Cart_GoodsMapper;
import com.web.util.DBUtil;

import java.util.List;

public class Cart_GoodsDao {
//    得到一个用户的购物车
    public List get(int uId){
        return DBUtil.queryForList("SELECT * FROM goods_info JOIN cart_info ON goods_info.gId = cart_info.gId where cart_info.uId = ? and cart_info.oId = 0",new Cart_GoodsMapper(),uId);
    }
}
