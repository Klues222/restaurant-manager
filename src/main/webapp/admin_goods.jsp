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
    <link rel="stylesheet" href="css/a007.css">
    <script src="js/jquery.js"></script>
    <script src="js/a004.js"></script>
    <script>
        function delgoods(data){
            var gId = data;
            $.post("delGoods",{"gId":gId},function (data){
                alert(data);
                location.href = location.href;
            })
        }
        function addGnumber(number,gId){
            var gnumber=number;
            var id=gId;
            var addNumber=document.getElementById("number").value;
            $.post("addGoodsNumber",{"gId":gId,"gNum":gnumber,"num":addNumber},function (data){
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
                    <td colspan="9" align="center">商品信息</td>
                    <td colspan="2" align="center">操作</td>
                </tr>
                <tr>
                    <td width=160px align="center">商品Id</td>
                    <td width=160px align="center">商品名</td>
                    <td width=160px align="center">价格</td>
                    <td width=160px align="center">图片</td>
                    <td width="160px" align="center">库存</td>
                    <td width="160px" align="center">已售</td>
                    <td width="160px" align="center">有效</td>
                    <td width="160px" align="center">添加时间</td>
                    <td width="160px" align="center">删除</td>
                    <td width="160px" align="center">增加库存</td>
                </tr>
                </thead>
                <tbody id="goodsT">
                <c:forEach items="${goods}" var="goods">
                    <tr>
                        <td align="center">${goods.gId}</td>
                        <td align="center">${goods.gName}</td>
                        <td align="center">${goods.shopPrice}</td>
                        <td align="center"><img src="images/${goods.image}" alt="" width="100px"></td>
                        <td align="center">${goods.g_number}</td>
                        <td align="center">${goods.saleNum}</td>
                        <c:choose>
                            <c:when test="${goods.gState ==1}">
                                <td align="center">有效</td>
                            </c:when>
                            <c:otherwise>
                                <td align="center">无效</td>
                            </c:otherwise>
                        </c:choose>

                        <td align="center">${goods.gDate}</td>
                        <td align="center"> <input  type = "button" value = "删除" onclick="delgoods('${goods.gId}')"></td>
                        <td align="center"><input type="text" id="number" style="width: 20%;"><input  type = "button" value = "增加库存" onclick="addGnumber('${goods.g_number}','${goods.gId}')"></td>
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
