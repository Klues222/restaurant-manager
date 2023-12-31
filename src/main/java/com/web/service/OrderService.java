package com.web.service;

import com.web.dao.OrderDao;
import com.web.entity.Admin;
import com.web.entity.Order;

import java.util.List;

public class OrderService {
    OrderDao orderDao = new OrderDao();
    //    新增订单
    public boolean makeOrder(Order order){
        int i = orderDao.makeOrder(order);
        if (i>0){
            return true;
        }else return false;
    }
    //    根据桌号查订单
    public Order get(String pickupId){
        return orderDao.get(pickupId);
    }
//    得到所有状态为1的订单
    public List getAll(int uId){
        return orderDao.getAll(uId);
    }
    //    管理员查询所有订单
    public List getAll(){
        return orderDao.getAll();
    }
    //    用户申请取消订单
    public boolean appDelOrder(int oId){
        int ok = orderDao.appliDel(oId);
        if (ok>0){
            return true;
        }else return false;
    }
    //    删除某一用户的订单
    public boolean delOrder(int uId){
        int ok = orderDao.delUser(uId);
        if (ok>0){
            return true;
        }else return false;
    }
    //    删除某一订单
    public boolean delByOrder(int oId){
        int ok = orderDao.delAppOrder(oId);
        if (ok>0){
            return true;
        }else return false;
    }
    //    管理员审核订单
    public boolean checkOrder(int oId){
        int ok = orderDao.checkOrder(oId);
        if (ok>0){
            return true;
        }else return false;
    }
//    获得所有申请取消的订单
    public List getAppliDel(){
        return orderDao.getAllAppDel();
    }

//    管理员同意删除订单
    public boolean delAppOrder(int oId){
        int ok = orderDao.delAppOrder(oId);
        if (ok>0){
         return true;
     }else return false;
    }
}
