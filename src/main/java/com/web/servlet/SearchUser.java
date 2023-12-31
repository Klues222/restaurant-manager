package com.web.servlet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.web.entity.User;
import com.web.service.UserService;
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

@WebServlet("/searchUser")
public class SearchUser extends HttpServlet {

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
        UserService userService = new UserService();
        List list = userService.getAll();
        req.setAttribute("users",list);
        req.setAttribute("length",list.size());
        req.getRequestDispatcher("admin_user.jsp").forward(req, resp);

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
        UserService user = new UserService();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // 可选，用于格式化输出
        String jsonData = null;
        if (name.equals("用户名")){
            list = user.SearchByName(name);
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
        }else {
           User user1 = user.SearchByTel(name);
            try {
                // 将List转换为JSON字符串
                if (user1.equals("")){
                    resp.getWriter().print("未查到相关信息");
                }else {
                    jsonData = objectMapper.writeValueAsString(user1);
                    resp.getWriter().print(jsonData);
                }

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }
}