package com.web.servlet;

import com.web.entity.Admin;
import com.web.service.AdminService;
import com.web.service.CartService;
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

/**
 * 用户将菜品添加购物车
 */
@WebServlet("/addCart")
public class AddCart extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Cookie[] cookies = req.getCookies();
        int uId=0;
        if (cookies != null) {
            for (jakarta.servlet.http.Cookie cookie : cookies) {
                if (cookie.getName().equals("uId")) {

                    uId = Integer.parseInt(cookie.getValue());
                    int gId = Integer.parseInt(req.getParameter("gId"));
                    int gNum = Integer.parseInt(req.getParameter("gNum"));
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String specif = req.getParameter("specif");
                    CartService cartService = new CartService();
                    boolean ok = cartService.makeCart(uId,gId,gNum,timestamp,specif);
                    if (ok){
                        resp.getWriter().print("加入成功");

                    }else {
                        resp.getWriter().print("加入失败");
                    }
                }

            }
            if (uId==0) resp.getWriter().print("加入失败,请登录");
        }


    }
}
