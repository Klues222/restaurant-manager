package com.web.mapper;

import com.web.entity.Cart;
import com.web.util.RowMapper;

import java.sql.ResultSet;

public class CartMapper implements RowMapper {
    public Object mapRow(ResultSet rs) throws Exception{
        Cart C = new Cart();
        C.setCtId(rs.getInt("ctId"));
        C.setuId(rs.getInt("uId"));
        C.setgId(rs.getInt("gId"));
        C.setgNum(rs.getInt("gNum"));
        C.setCtTime(rs.getTimestamp("ctTime"));
        C.setSpecif(rs.getString("specif"));
        return C;
    }
}