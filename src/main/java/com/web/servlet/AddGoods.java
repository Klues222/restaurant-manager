package com.web.servlet;
import com.web.service.GoodsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Timestamp;
@MultipartConfig
@WebServlet("/addGoods")
public class AddGoods extends HttpServlet{

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //'
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String gName = req.getParameter("gName");
        String i = req.getParameter("shopPrice");
        double shopPrice = Double.parseDouble(i);
        String g_desc = req.getParameter("g_desc");
        int g_number = Integer.parseInt(req.getParameter("g_number"));
        int csId = Integer.parseInt(req.getParameter("csId"));
        int gState = Integer.parseInt(req.getParameter("gState"));
        Timestamp gDate = new Timestamp(System.currentTimeMillis());
        Part part = req.getPart("image");
        String fileName = part.getSubmittedFileName();
        File file = new File(""); // 创建空字符串表示当前目录
        String path = file.getAbsolutePath(); // 获取当前路径的绝对路径
        part.write("C:\\Users\\klues\\Desktop\\myjava\\h_m\\src\\main\\webapp\\images\\" + fileName);
        String image = fileName;
        GoodsService goodsService = new GoodsService();
        boolean ok = goodsService.addNewGoods(gName, shopPrice, image, g_desc, g_number, gState, gDate, csId,0);
        if (ok) {
            resp.getWriter().print("添加成功<meta http-equiv=\"refresh\" content=\"1;url=newGoods\">");
        } else {
            resp.getWriter().print("添加失败<meta http-equiv=\"refresh\" content=\"1;url=newGoods\">");
        }
    }
}
