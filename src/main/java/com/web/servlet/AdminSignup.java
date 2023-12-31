package com.web.servlet;

import com.web.entity.Admin;
import com.web.entity.User;
import com.web.service.AdminService;
import com.web.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminSignup")
public class AdminSignup extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("aName");
        String password = req.getParameter("aPassword");
        String telephone = req.getParameter("aTelephone");
        Admin admin = new Admin(username,password,telephone);
        AdminService adminService = new AdminService();
        boolean ok = adminService.signUp(admin);
        PrintWriter out = resp.getWriter();
        if (ok){
            req.setAttribute("msg","注册成功");
            out.print("注册成功");
//            req.getRequestDispatcher("").forward(req,resp);

        }else {
            req.setAttribute("msg","注册失败,用户名重复");
            out.print("注册失败");
//            req.getRequestDispatcher("").forward(req,resp);
        }
    }
}
