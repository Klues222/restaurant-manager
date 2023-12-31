<%--
  Created by IntelliJ IDEA.
  User: klues
  Date: 2023/12/10
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page import="com.web.util.DBUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>美味餐厅</title>
    <style type="text/css">
        .head_web{
            /*display: inline-block;*/
        }
        #tit{
            align-content: center;
        }
        #log{
            align-content:end;
        }
        table{
            border-collapse: collapse;
        }
        #serar{
            width: 80%;
            height: 15%;
            /*background-image: url("images/scbc.png");*/
            background-size:cover;
            background-repeat: no-repeat;
        }
        ul,li{
            list-style:none;
            list-style-type:none;
        }
        #goodsList{

        }
        .main_list{ width:200px; height:100%;float:left;}
        .main_list h2{ width:200px; background:#393836; font-size:18px; padding-left:20px; line-height:38px; color:#fff; text-align:left; float:left;}
        .main_list ul{  width:200px; height:100%;background:#8c9d41; margin-top:0px; margin-left:0px;padding-top:50px;}
        .main_list li{ width:150px; padding-top:30px; margin-bottom: 50px; text-align:center;}
        .main_list li a{ font-size:20px; color:#ddd; line-height:35px;}
        .main_list li a:hover{font-size:24px; color:#fff; line-height:36px; text-decoration:none;}
        body{
            min-width: 1200px;
            height: 1000px;
            /*background-image: url("im.jpg");*/
            background-size: 1200px 1000px;
            background: white no-repeat;
            position: relative;
            display:flex;
            justify-content:center;
        }
        #header div{
            margin: 10px;
        }
        #header{
            display: flex;
            justify-content: flex-end;
            align-items: center;
        }
    </style>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <script>
        function appDelOrder(oId){
            $.post("myOrder",{"oId":oId},function (data){
                alert(data);
                location.href = location.href;

            })
        }
    </script>
</head>
<body>

<div id="container" >
    <!--网站头部-->
    <div id="header" style=" margin: auto; width:50%;" >
        <!--    background-color:skyblue;-->
        <div>
            <h1 style="" align="center">欢迎来到美味餐厅</h1>
        </div>
        <%
            Cookie[] cookies = request.getCookies();
            String username = null;
            String msg = "<a href=\"userLogin.jsp\" >登录</a>";
            if (cookies != null) {
                for (jakarta.servlet.http.Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        username = cookie.getValue();
                        msg = "欢迎用户:"+username;
                    }
                }
            }
        %>
        <div class="head_web" align="right" id="log">
            <%=msg%>
        </div>
    </div>
    <!--网站搜索框-->
    <div align="center" style="height: 10%;width:100%;" id="serar">
        <div class="se">

            <form>
                <input type="text" class="placeholder" placeholder="搜索" name="search" id = "search">
                <label for="goods">搜索类型:</label>
                <select id="goods" name="goods">
                    <option value="name">菜名</option>
                    <option value="type">类型</option>
                </select>
                <input type = "button" value = "搜索" onclick="search_t()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </form>
        </div>
    </div>
    <div>
        <!--  网站左侧功能框-->
        <div class="main_list">
            <div>
                <h2>功能分类</h2>
                <!--      <div class="clear"></div>-->
            </div>
            <div>
                <ul>
                    <li><a href="searchByName">菜品</a></li>
                    <li><a href="myCart">购物车</a></li>
                    <li><a href="myOrder">我的订单</a></li>
                </ul>
            </div>
        </div>
        <!--网站显示区-->
        <div id="content" style="width:800px;float:right;margin-left: 40px">
            <!--    background-color:#EEEEEE;-->
            <div id="goodsList" >
                <table border="1">
                    <thead>
                    <tr>
                        <td colspan="4" align="center">信息</td>
                        <td colspan="1" align="center">操作</td>
                    </tr>
                    <tr>
                        <td width=160px align="center">桌号</td>
                        <td width=160px align="center">下单时间</td>
                        <td width=160px align="center">取餐码</td>
                        <td width=160px align="center">总价</td>
                        <td width=160px align="center">退单 </td>
                    </tr>
                    </thead>
                    <tbody id="goodsT">
                    <c:choose>
                        <c:when test="${empty orders}">
                            <tr ><td colspan="6" style="text-align: center"> 无订单 </td></tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${orders}" var="orders">
                                <tr>
                                    <td align="center">${orders.tableId}</td>
                                    <td align="center">${orders.orderTime}</td>
                                    <td align="center">${orders.pickupId}</td>
                                    <td align="center">${orders.totalMoney}</td>
                                    <td align="center"> <input type = "button" value = "确认" onclick="appDelOrder('${orders.oid}')"></td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>


                    </tbody>
                    <tfoot>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>

    <!--/*底部*/-->
    <div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
    </div>
</div>

</body>
</html>
