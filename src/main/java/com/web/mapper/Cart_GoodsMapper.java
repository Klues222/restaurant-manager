package com.web.mapper;

import com.web.entity.Cart_Goods;
import com.web.util.RowMapper;

import java.sql.ResultSet;

public class Cart_GoodsMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs) throws Exception {
        Cart_Goods c = new Cart_Goods();
        c.setCtId(rs.getInt("ctId"));
        c.setuId(rs.getInt("uId"));
        c.setgId(rs.getInt("gId"));
        c.setgNum(rs.getInt("gNum"));
        c.setCtTime(rs.getTimestamp("ctTime"));
        c.setSpecif(rs.getString("specif"));
        c.setCsid(rs.getInt("csId"));
        c.setG_desc(rs.getString("g_desc"));
        c.setG_number(rs.getInt("g_number"));
        c.setgDate(rs.getTimestamp("gDate"));
        c.setgName(rs.getString("gName"));
        c.setgState(rs.getInt("gState"));
        c.setImage(rs.getString("image"));
        c.setSaleNum(rs.getInt("saleNum"));
        c.setShopPrice(rs.getDouble("shopPrice"));
        return c;
    }
}
