package com.web.servlet;

import com.web.service.Category1Service;
import com.web.service.Category2Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/addCategory2")
public class AddCategory2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Category1Service category1Service = new Category1Service();
        List list = category1Service.SearchType();
        req.setAttribute("category1",list);
        req.getRequestDispatcher("admin_category_new.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Category2Service category2Service = new Category2Service();
        String csname = req.getParameter("csname");
        int cId = Integer.parseInt(req.getParameter("cId"));
        boolean ok = category2Service.addCategory2(csname,cId);
        if (ok){
            resp.getWriter().print("添加成功");
        }else {
            resp.getWriter().print("商品名重复");
        }

    }
}
