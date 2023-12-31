package com.web.service;

import com.web.dao.AdminDao;
import com.web.entity.Admin;

/**
 * Admin表业务操作类
 * login:
 */
public class AdminService {
    private AdminDao adminDao = new AdminDao();
//    管理员登录
    public boolean login (Admin admin){
        Admin a = this.adminDao.get(admin.getaName());
        if(a!=null && a.getaPassword().equals(admin.getaPassword())){
            return true;
        }else return false;
    }
//    管理员注册
    public boolean signUp (Admin admin){
        int i = adminDao.set(admin.getaName(),admin.getaPassword(),admin.getaTelephone());
        System.out.println(i);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
}
