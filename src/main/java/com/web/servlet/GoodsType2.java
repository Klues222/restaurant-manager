package com.web.servlet;

import com.web.service.Category2Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/newGoods")
public class GoodsType2 extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Category2Service category2Service = new Category2Service();
        PrintWriter out = resp.getWriter();
        List list = category2Service.SearchType();
        req.setAttribute("category2",list);
        req.getRequestDispatcher("/admin_goods_new.jsp").forward(req, resp);
    }
}
