package com.web.mapper;

import com.web.util.RowMapper;
import com.web.entity.Category1;
import java.sql.ResultSet;

public class Category1Mapper implements RowMapper {
    public Object mapRow(ResultSet rs) throws Exception {
        Category1 C1 = new Category1();
        C1.setCid(rs.getInt("cId"));
        C1.setCname(rs.getString("cname"));
        return C1;
    }
}
