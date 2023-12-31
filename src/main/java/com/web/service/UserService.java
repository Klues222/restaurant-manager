package com.web.service;

import com.web.dao.Category1Dao;
import com.web.dao.UserDao;
import com.web.entity.Category1;
import com.web.entity.Goods;
import com.web.entity.User;
import java.util.ArrayList;
import java.util.List;
public class UserService {
    UserDao userDao = new UserDao();
//    用户登录
    public boolean login(User user){
        User u = userDao.get(user.getUsername());
        if(u!=null && u.getPassword().equals(user.getPassword())){
            return true;
        }else return false;
    }
//    用户注册
    public boolean signUp(User user){
        int i = userDao.set(user.getUsername(),user.getPassword(),user.getName(),user.getSex(),user.getTelephone());
        System.out.println(i);
        if (i>0){
            return true;
        }else return false;

    }
//    根据电话查询用户
    public User SearchByTel(String tel){
        return userDao.SearchByTel(tel);
    }
    // 根据名字查询用户
    public List SearchByName(String name){
        List list = userDao.SearchByName(name);
        return list;
    }
    //    得到所有非管理员的用户
    public List getAll(){
        return userDao.getAll();
    }
//    删除用户
    public boolean delUser(int uid){

        int ok = userDao.delUser(uid);
        if(ok>0){
            return true;
        }else{
            return false;
        }
    }
    //    根据用户名查询用户
    public int getUId(String username){
        return userDao.get(username).getUid();
    }
}
