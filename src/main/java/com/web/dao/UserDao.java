package com.web.dao;

import com.web.entity.User;
import com.web.mapper.UserMapper;
import com.web.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
/**
 * user表 数据库交互
 */
public class UserDao {

    /**
     * 根据用户名称查询用户数据
     * @param username
     * @return
     */
//    根据用户名查询用户
    public User get(String username){
        return (User) DBUtil.queryForObject("select * from user_info where username=?",new UserMapper(),username);
    }

//    新增用户
    public int set( String username, String password, String name, String sex, String telephone){
        return DBUtil.update("Insert into user_info (username,password,name,sex,telephone) VALUES(?,?,?,?,?)",username,password,name,sex,telephone);
    }
//    得到所有非管理员的用户
    public List getAll(){
        return DBUtil.queryForList("select * from user_info where uId != 0",new UserMapper());
    }
//    模糊查询用户
    public List SearchByName(String name){
        return DBUtil.queryForList("select * from user_info where username like ?",new UserMapper(),"%"+name+"%");
    }
//    根据电话查询用户
    public User SearchByTel(String tel){
        return (User) DBUtil.queryForObject("select * from user_info where telephone = ?",new UserMapper(),tel);
    }
//    删除用户
    public int delUser(int uid){
        return DBUtil.update("delete from user_info where uId =?",uid);
    }
}
