package com.web.servlet;

import com.web.entity.Cart_Goods;
import com.web.service.CartService;
import com.web.service.Category2Service;
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
@WebServlet("/delCategory2")
public class DelCategory2 extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Category2Service category2Service = new Category2Service();
        List list = category2Service.SearchType();
        req.setAttribute("category2",list);
        req.getRequestDispatcher("admin_category.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Category2Service category2Service = new Category2Service();
        /**
         * 删除二级商品
         */
        int csId = Integer.parseInt(req.getParameter("csId"));
        boolean ok =category2Service.delCategory2(csId);
        if (ok){
            resp.getWriter().print("删除成功");
        }else {
            resp.getWriter().print("请先将该二级商品下的商品删除");
        }
    }
}
