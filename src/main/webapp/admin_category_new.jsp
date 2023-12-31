<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: klues
  Date: 2023/12/11
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员界面</title>
    <link rel="stylesheet" href="css/a006.css">
    <script src="js/jquery.js"></script>
    <script src="js/a004.js"></script>
    <script>
        function newCate(){
            var csname = document.getElementById("csname").value;
            var cId = document.getElementById("cId").value;
            $.post("addCategory2",{"cId":cId,"csname":csname},function (data){
                alert(data);
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
            <span  id="msg"></span>
            <table id="new_list">
                <tr>
                    <td align="center" colspan="2"><input type="text" class="inputItem" placeholder="商品类名" name="csname" id="csname"/> </td>
                </tr>
                <tr>
                    <td align="center" >
                        <select name="cId" id="cId">
                            <c:forEach items="${category1}" var="category1">
                                <option value="${category1.cid}">${category1.cname}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td align="center"><input type="button" value="新增" class="but" id="add" onclick="newCate()"/></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>

</html>
