package com.web.mapper;

import com.web.entity.Order;
import com.web.util.RowMapper;

import java.sql.ResultSet;

public class OrderMapper implements RowMapper {
    public Object mapRow(ResultSet rs) throws Exception {
        Order o = new Order();
        o.setOid(rs.getInt("oId"));
        o.setOrderTime(rs.getTimestamp("orderTime"));
        o.setoState(rs.getInt("oState"));
        o.setUid(rs.getInt("uId"));
        o.setTotalMoney(rs.getDouble("totalMoney"));
        o.setPickupId(rs.getString("pickupId"));
        o.setTableId(rs.getString("tableId"));
        return o;

    }
}
