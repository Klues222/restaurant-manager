package com.web.dao;

import com.web.entity.Order;
import com.web.mapper.OrderMapper;
import com.web.util.DBUtil;

import java.sql.Timestamp;
import java.util.List;

public class OrderDao {
//    新增订单
    public int makeOrder(Order order){
        return DBUtil.update("Insert into order_info (totalMoney,oState,tableId,pickupId,orderTime,uId) values(?,1,?,?,?,?)",order.getTotalMoney(),order.getTableId(),order.getPickupId(),order.getOrderTime(),order.getUid());
    }
//    根据桌号查订单
    public Order get(String pickupId){
        return (Order) DBUtil.queryForObject("select * from order_info where pickupId = ?", new OrderMapper(),pickupId);
    }

    public int upDateTotalMoney(Double totalMoney, int oId){
        return DBUtil.update("update order_info set totalMoney = ? where oId = ?",totalMoney,oId);
    }
//    得到所有状态为1的订单
    public List getAll(int uId){
        return DBUtil.queryForList("select * from order_info where uId = ? and oState = 1",new OrderMapper(),uId);
    }
//    管理员查询所有订单
    public List getAll(){
        return DBUtil.queryForList("select * from order_info where oId!=0",new OrderMapper());
    }
//    用户申请取消订单
    public int appliDel(int oId){
        return DBUtil.update("update order_info set oState = 2 where oId = ?",oId);
    }
//    管理员查看申请取消的订单
    public List getAllAppDel(){
        return DBUtil.queryForList("select * from order_info where oState!= 0",new OrderMapper());
    }
//    删除某一用户的订单
    public int delUser(int uId){
        return DBUtil.update("delete from order_info where uId = ?",uId);
    }
//    删除某一订单
    public int delAppOrder(int oId){
        return DBUtil.update("delete from order_info where oId = ?",oId);
    }
//    管理员审核订单
    public int checkOrder(int oId){
        return DBUtil.update("update order_info set oState = 0 where oId = ?",oId);
    }

}
