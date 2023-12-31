package com.web.servlet;
import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import com.web.entity.Cart_Goods;
import com.web.entity.Goods;
import com.web.entity.Order;
import com.web.service.GoodsService;
import com.web.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/reviewOrder")
public class ReviewOrder extends  HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        OrderService orderService = new OrderService();
        List list = orderService.getAppliDel();
        req.setAttribute("orders",list);
        req.getRequestDispatcher("/admin_order.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        OrderService orderService = new OrderService();
        int oId = Integer.parseInt(req.getParameter("oId"));
        boolean ok = orderService.delAppOrder(oId);
        if (ok){
            resp.getWriter().print("删除成功");
        }else {
            resp.getWriter().print("删除失败");
        }
    }
}
