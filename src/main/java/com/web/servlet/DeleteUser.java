package com.web.servlet;

import com.web.entity.Cart_Goods;
import com.web.service.CartService;
import com.web.service.OrderService;
import com.web.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/delUser")
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        UserService userService = new UserService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();
        int uId = Integer.parseInt(req.getParameter("uId"));
        cartService.DelUser(uId);
        orderService.delOrder(uId);
        boolean ok =userService.delUser(uId);
        if (ok){
            resp.getWriter().print("删除成功");
        }else {
            resp.getWriter().print("删除失败");
        }


    }
}