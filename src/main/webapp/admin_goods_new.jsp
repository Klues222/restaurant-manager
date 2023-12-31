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
    <link rel="stylesheet" href="css/a005.css">
    <script src="js/jquery.js"></script>
    <script src="js/a005.js"></script>
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

            <table id="new_list" >
                <form action="addGoods" method="post" enctype="multipart/form-data">
                <tr>
                    <td align="center" colspan="3"> <input type="text" class="inputItem" placeholder="商品名" id="gName" name="gName"/></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><input type="password" class="inputItem" placeholder="商品价格" id="shopPrice" name="shopPrice"/>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><input type="file" class="inputItem" placeholder="图片" name="image" id="filed" accept="image/*"/></td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><div id="box" ></div></td>
                </tr>
                <script>
                    document.getElementById('filed').addEventListener('change',function(e){

                        var files = this.files;
                        var img = new Image();
                        var reader = new FileReader();
                        reader.readAsDataURL(files[0]);
                        reader.onload = function(e){
                            var mb = (e.total/1024)/1024;
                            if(mb>= 2){
                                alert('文件大小大于2M');
                                return;
                            }
                            img.src = this.result;
                            img.style.width = "100%";
                            img.style.height = "100%";
                            document.getElementById('box').innerHTML = '';
                            document.getElementById('box').appendChild(img);
                        }
                    });
                </script>
                <tr>
                    <td align="center"  colspan="3">
                        <div class="scrollable">
                            <textarea rows="4" cols="50" class="scrip" name="g_desc" id="g_desc" placeholder="描述"></textarea>
                        </div>

                    </td>
                </tr>

                <tr>
                    <td align="center"><input type="text" class="inputItem1" placeholder="库存" name="g_number"/></td>
                    <td align="center">
                        类型<select  id="csId" name="csId">
                        <c:forEach var="type" items="${category2}">
                            <option value="${type.csid}">${type.csname}</option>
                        </c:forEach>
                        </select>
                    </td>
                    <td align="center">
                        是否启用<select id="gState"  name="gState">
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="3"><input type="submit" value="新增" class="but" id="add" onclick="addAction()"></td>
                </tr>
                </form>
            </table>

        </div>
    </div>
</div>
</body>

</html>
