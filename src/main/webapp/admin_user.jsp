
<%--
  Created by IntelliJ IDEA.
  User: klues
  Date: 2023/12/11
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page import="com.web.util.DBUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员界面</title>
    <link rel="stylesheet" href="css/a004.css">
    <script src="js/jquery.js"></script>
    <script src="js/a004.js"></script>
    <script>
        function delete_user(uId){
            $.post("delUser",{"uId":uId},function (data){
                alert(data);
                location.href = location.href;

            })
        }
    </script>
</head>

<body>
<div class="admin-main">
    <!-- 导航栏 -->
    <div class="navigation-bar">
        <%
            Cookie[] cookies = request.getCookies();
            String aName = null;
            if (cookies != null) {
                for (jakarta.servlet.http.Cookie cookie : cookies) {
                    if (cookie.getName().equals("aName")) {
                        aName = cookie.getValue();
                    }
                }
            }
        %>
        <!-- 管理员信息 -->
        <div class="admin-information">
            <span class="adminName">Hello Admin : <%=aName%></span>
        </div>
        <div class="list-information">
            <ul class="nav-ul">
                <li>
                    <div class="nav-li-div">查看商品</div>
                    <ul class="div-ul">
                        <li class="ul_li"><a href="newGoods">新增商品</a></li>
                        <li class="ul_li"><a href="delGoods">删除商品</a></li>
                    </ul>
                </li>
                <li>
                    <div class="nav-li-div">查看商品类</div>
                    <ul class="div-ul">
                        <li class="ul_li"><a href="delCategory2">删除二级商品类</a></li>
                        <li class="ul_li"><a href="addCategory2">新增二级商品类</a></li>
                    </ul>
                </li>
                <li>
                    <div class="nav-li-div">查看用户</div>
                    <ul class="div-ul">
                        <li class="ul_li"><a href="searchUser">删除用户</a></li>
                    </ul>
                </li>
                <li>
                    <div class="nav-li-div">查看订单</div>
                    <ul class="div-ul">
                        <li class="ul_li"><a href="reviewOrder">审核订单</a></li>
                        <li class="ul_li"><a href="searchAllOrder">所有订单</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="function-module">
        <div class="module-index">
            <div id="mIndex">

            </div>
            <div class="admin-permiss">Permissions-->1</div>
        </div>
        <div class="main_list">
            <table border="1">
                <thead>
                <tr>
                    <td colspan="6" align="center">用户信息</td>
                    <td colspan="1" align="center">操作</td>
                </tr>
                <tr>
                    <td width=160px align="center">用户Id</td>
                    <td width=160px align="center">用户名</td>
                    <td width=160px align="center">密码</td>
                    <td width=160px align="center">姓名</td>
                    <td width=160px align="center">性别</td>
                    <td width="160px" align="center">电话</td>
                    <td width="160px" align="center">删除</td>
                </tr>
                </thead>
                <tbody id="goodsT">
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td width=160px align="center">${user.uid}</td>
                        <td width=160px align="center">${user.username}</td>
                        <td width=160px align="center">${user.password}</td>
                        <td width=160px align="center">${user.name}</td>
                        <td width=160px align="center">${user.sex}</td>
                        <td width="160px" align="center">${user.telephone}</td>
                        <td width="160px" align="center"><input type="button" value="删除" onclick="delete_user('${user.uid}')"></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot></tfoot>
            </table>
        </div>
    </div>
</div>
</body>

</html>
