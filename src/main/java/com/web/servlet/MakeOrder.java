package com.web.servlet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.dao.CartDao;
import com.web.dao.GoodsDao;
import com.web.dao.OrderDao;
import com.web.entity.Cart;
import com.web.entity.Cart_Goods;
import com.web.entity.Goods;
import com.web.entity.Order;
import com.web.service.CartService;
import com.web.service.GoodsService;
import com.web.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@WebServlet("/makeOrder")
public class MakeOrder extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();
        GoodsService goodsService = new GoodsService();
        //获取桌台号
        String tableId = req.getParameter("tableId");
        //获取uId
        Cookie[] cookies = req.getCookies();
        int uId = 0;
        if (cookies != null) {
            for (jakarta.servlet.http.Cookie cookie : cookies) {
                if (cookie.getName().equals("uId")) {
                    uId = Integer.parseInt(cookie.getValue());
                }
            }
        }
        //获取取餐码
        Random rand = new Random();
        int randomNum = rand.nextInt(999999) + 1;
        String pickupId = Integer.toString(randomNum);
        //获取当前时间戳
        Timestamp timestamp = new  Timestamp(System.currentTimeMillis());
        //获取下单的购物车
        List list = cartService.GetAll(uId);
        //获取总价格
        double totalMoney = Double.parseDouble(req.getParameter("totalMoney"));
        //Double totalMoney, int oState, String tableId, String pickupId, Timestamp orderTime, int uid
        //创建Order
        Order order = new Order(totalMoney,1,tableId,pickupId,timestamp,uId);
        orderService.makeOrder(order);

        int oId = orderService.get(pickupId).getOid();
        //更新goods里面销售量与库存
        for (Object o : list) {
            Cart_Goods cart = (Cart_Goods) o;
            cartService.addCartToOrder(cart.getCtId(), oId);
            int resultg_num = cart.getG_number()-cart.getgNum();
            int resultsaleNum = cart.getSaleNum()+cart.getgNum();
            goodsService.upDateGNumber(resultg_num, resultsaleNum, cart.getgId());

        }
        resp.getWriter().print("下单成功");


    }
}
