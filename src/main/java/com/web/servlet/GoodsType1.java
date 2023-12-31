package com.web.servlet;
import com.web.service.Category1Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/Cate1")
public class GoodsType1 extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Category1Service category1Service = new Category1Service();
        PrintWriter out = resp.getWriter();
        List list = category1Service.SearchType();
        req.setAttribute("category1",list);
        req.getRequestDispatcher("/admin_category_new.jsp").forward(req, resp);
    }
}
