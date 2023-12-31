package com.web.servlet;

import com.web.entity.Cart_Goods;
import com.web.entity.Order;
import com.web.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/myOrder")
public class MyOrder extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        OrderService orderService = new OrderService();
        Cookie[] cookies = req.getCookies();
        int uId = 0;
        if (cookies != null) {
            for (jakarta.servlet.http.Cookie cookie : cookies) {
                if (cookie.getName().equals("uId")) {
                    uId = Integer.parseInt(cookie.getValue());
                    List orders = orderService.getAll(uId);
                    req.setAttribute("orders", orders);
                    req.getRequestDispatcher("myOrder.jsp").forward(req, resp);
                }

            }
            if (uId == 0) {
                resp.sendRedirect("UserLogin");
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        OrderService orderService = new OrderService();
        int oId = Integer.parseInt(req.getParameter("oId"));
        boolean ok = orderService.appDelOrder(oId);
        if (ok) {
            resp.getWriter().print("申请成功");
        } else {
            resp.getWriter().print("申请失败");
        }
    }
}