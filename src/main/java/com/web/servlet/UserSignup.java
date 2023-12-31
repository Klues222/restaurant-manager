package com.web.servlet;

import com.web.entity.User;
import com.web.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/userSignup")
public class UserSignup extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String telephone = req.getParameter("telephone");
        User user = new User(username,password,name,sex,telephone);
        UserService userService = new UserService();
        boolean ok = userService.signUp(user);
        PrintWriter out = resp.getWriter();
        if (ok){
            req.setAttribute("msg","注册成功");
            req.getRequestDispatcher("UserLogin").forward(req,resp);

        }else {
            req.setAttribute("msg","注册失败,用户名重复");
            req.getRequestDispatcher("userSignup.jsp").forward(req,resp);
        }
    }
}
