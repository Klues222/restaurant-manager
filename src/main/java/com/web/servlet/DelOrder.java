package com.web.servlet;

import com.web.entity.Admin;
import com.web.service.AdminService;
import com.web.service.CartService;
import com.web.service.GoodsService;
import com.web.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;
@WebServlet("/delOrder")
public class DelOrder extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        OrderService orderService = new OrderService();
        CartService cartService = new CartService();

        int oId = Integer.parseInt(req.getParameter("oId"));
//        删除该订单的购物车
        cartService.DelByOrders(oId);
//        判断是否删除退单成功
        boolean ok = orderService.delByOrder(oId);
        if (ok){
            resp.getWriter().print("退单成功");
        }else {
            resp.getWriter().print("退单失败");
        }


    }
}
