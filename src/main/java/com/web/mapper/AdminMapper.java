package com.web.mapper;

import com.web.entity.Admin;
import com.web.util.RowMapper;

import java.sql.ResultSet;

public class AdminMapper implements RowMapper {
    public Object mapRow(ResultSet rs) throws Exception{
        Admin A = new Admin();
        A.setaId(rs.getInt("aId"));
        A.setaName(rs.getString("aName"));
        A.setaPassword(rs.getString("aPassword"));
        A.setaTelephone(rs.getString("aTelephone"));
        return A;
    }
}
