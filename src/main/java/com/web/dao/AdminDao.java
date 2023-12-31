package com.web.dao;

import com.web.entity.Admin;
import com.web.mapper.AdminMapper;
import com.web.util.DBUtil;

/**
 *
 */
public class AdminDao {
//    查询管理员名字
    public Admin get(String aName){
        return (Admin) DBUtil.queryForObject("select * from admin_info where aName=?",new AdminMapper(),aName);


    }
//    新增管理员
    public int set (String aName,String aPassword, String aTelephone){
        return DBUtil.update("insert into admin_info (aName,aPassword,aTelephone) values(?,?,?)",aName,aPassword,aTelephone);
    }
}
