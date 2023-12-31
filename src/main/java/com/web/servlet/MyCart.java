package com.web.servlet;

import com.web.entity.Cart;
import com.web.entity.Cart_Goods;
import com.web.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/myCart")
public class MyCart extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        CartService cartService = new CartService();
        Cookie[] cookies = req.getCookies();
        int uId = 0;
        if (cookies != null) {
            for (jakarta.servlet.http.Cookie cookie : cookies) {
                if (cookie.getName().equals("uId")) {
                    uId = Integer.parseInt(cookie.getValue());
                    Double wholeMoney = (double) 0;
                    List carts = cartService.GetAll(uId);
                    for (int i = 0;i<carts.size();i++){
                        Cart_Goods cart = (Cart_Goods) carts.get(i);
                        wholeMoney = wholeMoney + cart.getgNum()*cart.getShopPrice();
                    }
                    req.setAttribute("carts",carts);
                    req.setAttribute("wholeMoney",wholeMoney);
                    req.getRequestDispatcher("myCart.jsp").forward(req,resp);
                }
            }
            if (uId==0) resp.sendRedirect("userLogin.jsp");

        }else {
            resp.sendRedirect("userLogin.jsp");
        }

    }
}
