package com.web.mapper;

import com.web.util.RowMapper;
import com.web.entity.User;
import java.sql.ResultSet;

public class UserMapper implements RowMapper {
    public Object mapRow(ResultSet rs) throws Exception {
        User u = new User();
        u.setName(rs.getString("name"));
        u.setUid(rs.getInt("uId"));
        u.setSex(rs.getString("sex"));
        u.setPassword(rs.getString("password"));
        u.setTelephone(rs.getString("telephone"));
        u.setUsername(rs.getString("username"));
        return u;
    }
}
