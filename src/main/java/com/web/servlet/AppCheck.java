package com.web.servlet;

import com.web.service.CartService;
import com.web.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/appCheck")
public class AppCheck extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        OrderService orderService = new OrderService();
        CartService cartService = new CartService();

        int oId = Integer.parseInt(req.getParameter("oId"));
//        删除该订单的购物车
        cartService.DelByOrders(oId);
//        判断是否结账成功
        boolean ok = orderService.checkOrder(oId);
        if (ok) {
            resp.getWriter().print("结账成功");
        } else {
            resp.getWriter().print("结账失败");
        }

    }
}