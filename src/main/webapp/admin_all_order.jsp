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
  <link rel="stylesheet" href="css/a004.css">
  <script src="js/jquery.js"></script>
  <script src="js/a004.js"></script>
  <script>
    function confirm(){

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
            <li class="ul_li"><a href="delCategory2">新增二级商品类</a></li>
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
          <td colspan="7" align="center">订单信息</td>
        </tr>
        <tr>
          <td width=140px align="center">订单号</td>
          <td width=140px align="center">总金额</td>
          <td width=140px align="center">台号</td>
          <td width=140px align="center">取餐码</td>
          <td width="140px" align="center">下单时间</td>
          <td width="140px" align="center">用户ID</td>
          <td width="140px" align="center">订单状态</td>
        </tr>
        </thead>
        <tbody id="goodsT">
        <c:forEach items="${orders}" var="orders">
          <%--                    int oid, Double totalMoney, int oState, String tableId, String pickupId, Timestamp orderTime, int uid--%>
          <tr>
            <td align="center">${orders.oid}</td>
            <td align="center">${orders.totalMoney}</td>
            <td align="center">${orders.tableId}</td>
            <td align="center">${orders.pickupId}</td>
            <td align="center">${orders.orderTime}</td>
            <td align="center">${orders.uid}</td>
            <c:choose>
              <c:when test="${orders.oState ==1}">
                <td align="center">申请结账</td>
              </c:when>
              <c:when test="${orders.oState ==0}">
                <td align="center">订单完成</td>
              </c:when>
              <c:otherwise>
                <td align="center">申请退单</td>
              </c:otherwise>
            </c:choose>
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
