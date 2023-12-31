package com.web.servlet;

import com.web.entity.Admin;
import com.web.entity.User;
import com.web.service.AdminService;
import com.web.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/userLogin.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        if (userService.login(new User(username,password))){
            Cookie cookie = new Cookie("uId",Integer.toString(userService.getUId(username)) );
            Cookie cookie1 = new Cookie("username",username);
            resp.addCookie(cookie);
            resp.addCookie(cookie1);
            resp.sendRedirect("searchByName");
        }else {
            req.setAttribute("msg","账号或密码错误");
            req.getRequestDispatcher("userLogin.jsp").forward(req,resp);
        }
    }
}
