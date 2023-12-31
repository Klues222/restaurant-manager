package com.web.servlet;
import com.web.entity.Cart_Goods;
import com.web.entity.Goods;
import com.web.service.CartService;
import com.web.service.GoodsService;
import com.web.service.OrderService;
import com.web.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
@WebServlet("/delGoods")
public class DelGoods extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        GoodsService goodsService = new GoodsService();
        List list = goodsService.GetAllGoods();
        for(int i = 0; i < list.size(); i++) {
            Goods good = (Goods) list.get(i);
            System.out.println(good.toString());
        }
        req.setAttribute("goods",list);
        req.getRequestDispatcher("/admin_goods.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        GoodsService goodsService = new GoodsService();
        CartService cartService = new CartService();

        int gId = Integer.parseInt(req.getParameter("gId"));
//        删除有改商品的购物车
        cartService.DelByGoods(gId);
//        判断是否删除商品成功
        boolean ok = goodsService.delGoods(gId);
        if (ok){
            resp.getWriter().print("删除成功");
        }else {
            resp.getWriter().print("删除失败");
        }


    }
}
