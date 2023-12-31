package com.web.mapper;

import com.web.entity.Goods;
import com.web.entity.Order;
import com.web.util.RowMapper;

import java.sql.ResultSet;

public class GoodsMapper implements RowMapper {
    public Object mapRow(ResultSet rs) throws Exception {
        Goods g = new Goods();
        g.setCsid(rs.getInt("csId"));
        g.setG_desc(rs.getString("g_desc"));
        g.setG_number(rs.getInt("g_number"));
        g.setgDate(rs.getTimestamp("gDate"));
        g.setgId(rs.getInt("gId"));
        g.setgName(rs.getString("gName"));
        g.setgState(rs.getInt("gState"));
        g.setImage(rs.getString("image"));
        g.setSaleNum(rs.getInt("saleNum"));
        g.setShopPrice(rs.getDouble("shopPrice"));
        return g;
    }
}
