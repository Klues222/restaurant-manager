package com.web.servlet;

import com.web.entity.Cart_Goods;
import com.web.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/delCart")
public class DelCart extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        CartService cartService = new CartService();
        String type = req.getParameter("determine");
        Cookie[] cookies = req.getCookies();
        int uId = 0;
        if (cookies != null) {
            for (jakarta.servlet.http.Cookie cookie : cookies) {
                if (cookie.getName().equals("uId")) {
                    uId = Integer.parseInt(cookie.getValue());
                }
            }
        }
        /**
         * 0就执行删除所有 其他就删除一个
         */
        if (type.equals("0")){
            boolean ok = cartService.DelAll(uId);
            if (ok){
                resp.getWriter().print("删除成功");
            }else {
                resp.getWriter().print("删除失败");
            }
        }else {
            int ctId = Integer.parseInt(req.getParameter("ctId"));
            boolean ok = cartService.Del(ctId);
            if (ok){
                resp.getWriter().print("删除成功");
            }else {
                resp.getWriter().print("删除失败");
            }
        }


    }
}