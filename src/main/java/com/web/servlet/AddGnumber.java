package com.web.servlet;
import com.web.entity.Admin;
import com.web.service.AdminService;
import com.web.service.CartService;
import com.web.service.GoodsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;
@WebServlet("/addGoodsNumber")
public class AddGnumber extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int gId = Integer.parseInt(req.getParameter("gId"));
        int gNum = Integer.parseInt(req.getParameter("gNum"));
        int num = Integer.parseInt(req.getParameter("num"));
        int gnumber=gNum+num;
        GoodsService goodsService = new GoodsService();
        boolean ok = goodsService.addGoodsNumber(gnumber,gId);
        if (ok){
            resp.getWriter().print("增加成功");

        }else {
            resp.getWriter().print("增加失败");
        }
    }
}
