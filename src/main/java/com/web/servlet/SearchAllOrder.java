package com.web.servlet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.web.entity.Goods;
import com.web.service.GoodsService;
import com.web.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/searchAllOrder")
public class SearchAllOrder extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        OrderService orderService = new OrderService();
        List list = orderService.getAll();
        req.setAttribute("orders",list);
        req.getRequestDispatcher("/admin_all_order.jsp").forward(req, resp);
    }
}
