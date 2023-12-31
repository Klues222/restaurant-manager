package com.web.mapper;

import com.web.util.RowMapper;
import com.web.entity.Category2;
import java.sql.ResultSet;

public class Category2Mapper implements RowMapper {
    public Object mapRow(ResultSet rs) throws Exception {
        Category2 C2 = new Category2();
        C2.setCid(rs.getInt("cId"));
        C2.setCsid(rs.getInt("csId"));
        C2.setCsname(rs.getString("csname"));
        return C2;
    }
}