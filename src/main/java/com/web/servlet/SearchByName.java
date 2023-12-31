package com.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.web.entity.Goods;
import com.web.service.GoodsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 查询主页
 * @return:
 */

@WebServlet("/searchByName")
public class SearchByName extends HttpServlet {

    /**
     * get方法传所有菜的信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        GoodsService goodsService = new GoodsService();
        PrintWriter out = resp.getWriter();
        List list = goodsService.listAllGoods();
        for(int i = 0; i < list.size(); i++) {
            Goods good = (Goods) list.get(i);
            System.out.println(good.toString());
        }
        req.setAttribute("goods",list);
        req.setAttribute("length",list.size());
        req.getRequestDispatcher("/homepage.jsp").forward(req, resp);
    }

    /**
     * post查询菜名或类型名
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String search = req.getParameter("search");
        String name = req.getParameter("name");
        List list = null;
        GoodsService goodsService = new GoodsService();
        /**
         * 根据菜名或类型查数据
         */
        if (name.equals("菜名")){

             list = goodsService.SearchByName(search);
        }else {
            list = goodsService.SearchByType(search);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // 可选，用于格式化输出
        String jsonData = null;
        try {
            // 将List转换为JSON字符串
            if (list.isEmpty()){
                resp.getWriter().print("未查到相关信息");
            }else {
                jsonData = objectMapper.writeValueAsString(list);
                resp.getWriter().print(jsonData);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}