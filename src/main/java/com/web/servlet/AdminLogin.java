package com.web.servlet;


import com.web.entity.Admin;
import com.web.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("aName");
        String password = req.getParameter("aPassword");
        AdminService adminService = new AdminService();
        if(adminService.login(new Admin(username,password))){

            Cookie cookie = new Cookie("aName",username);
            resp.addCookie(cookie);
            resp.sendRedirect("/adminhomepage.jsp");
        }else
        {
            //绑定错误信息
            req.setAttribute("msg","账户或者密码错误!");
            //转发
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
