<%--
  Created by IntelliJ IDEA.
  User: 杜伊斯堡
  Date: 2023/12/6
  Time: 17:15
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
            overflow:auto;
            width:800px;
            height:110%
        }
        .main_list{ width:200px; height:100%;float:left;}
        .main_list h2{ width:200px; background:#393836; font-size:18px; padding-left:20px; line-height:38px; color:#fff; text-align:left; float:left;}
        .main_list ul{  width:200px; height:100%;background:#8c9d41; margin-top:0px; margin-left:0px;padding-top:50px;}
        .main_list li{ width:150px; padding-top:30px; margin-bottom: 50px; text-align:center;}
        .main_list li a{ font-size:20px; color:#ddd; line-height:35px;}
        .main_list li a:hover{font-size:24px; color:#fff; line-height:36px; text-decoration:none;}
        body{
            min-width: 1250px;
            height: 500px;
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
    <script>
        function add_to_cart(gId){
                var gNum = document.getElementById("goods_num"+gId).value;
                var specif = document.getElementById("goods_specif"+gId).value;
            $.post("addCart",{"gId":gId ,"gNum":gNum,"specif":specif},function (data){
                if (data==="加入成功"){
                    alert("添加成功");
                }else if (data==="加入失败"){
                    alert("加入失败");
                }else{
                    alert("加入失败，请登录");
                }
            });
        }
    </script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <script>

        function search_t(){
            var options=$("#goods option:selected");
            var search = document.getElementById("search").value;
            var s_t =options.text();
            var s_v=options.val();
                $.post("searchByName",{"search":search ,"name":s_t},function (data){
                    if(data==="未查到相关信息"){
                        alert(data);
                    }else {
                        var res = JSON.parse(data);

                        console.log(res[0]["gName"]);
                        var str = "";
                        for (var i = 0;i<res.length;i++){
                            str = str + "<tr>";
                            str = str + "<td align='center'>"+res[i]['gName']+"</td>";
                            str = str + "<td align='center'><img src='images/"+res[i]['image']+"' alt='' width='100px'></td>";
                            str = str + "<td align='center'>"+res[i]['saleNum']+"</td>";
                            var price = parseFloat(res[i]['shopPrice'])
                            str = str + "<td align='center'>"+price+"</td>";
                            str = str + "<td align='center' id='specif'>";
                            str = str + "<select name='age' id='goods_specif"+res[i]["gId"]+"'>";
                            str = str + "<option value='不辣'>不辣</option>";
                            str = str + "<option value='中辣'>中辣</option>";
                            str = str + "<option value='特辣'>特辣</option>";
                            str = str + "</select>";
                            str = str + "</td >";
                            str = str + "<td align='center' >";
                            str = str + "<select name='age' id='"+"goods_num"+res[i]["gId"]+"'>";

                            for (j=0;j<=res[i]['g_number'];j++){
                                str = str + "<option value='"+j+"'>"+j+"</option>";
                            }
                            str = str + "</td>";
                            str = str + "<td align='center'> <input type = 'button' value = '加入' onclick=\"add_to_cart('"+res[i]['gId']+"')\"></td>";
                            str = str + "</tr>";
                        }
                        document.getElementById("goodsT").innerHTML = str;
                    }


                });
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
                        <td colspan="4" align="center">菜单</td>
                        <td colspan="2" align="center">操作</td>
                    </tr>
                    <tr>
                        <td width=160px align="center">菜名</td>
                        <td width=160px align="center">图片</td>
                        <td width=160px align="center">销量</td>
                        <td width=160px align="center">价格</td>
                        <td width="160px" align="center">口味</td>
                        <td width="160px" align="center">购买数量</td>
                        <td width="160px" align="center">加入购物车</td>
                    </tr>
                    </thead>
                    <tbody id="goodsT">
                    <c:forEach items="${goods}" var="goods">
                        <tr>
                            <td align="center">${goods.gName}</td>
                            <td align="center"><img src="images/${goods.image}" alt="" width="100px"></td>
                            <td align="center">${goods.saleNum}</td>
                            <td align="center">${goods.shopPrice}</td>
                            <td align="center" id="specif">
                                <select name="age" id="goods_specif${goods.gId}">
                                            <option value="不辣">不辣</option>
                                            <option value="中辣">中辣</option>
                                            <option value="特辣">特辣</option>
                                </select>
                            </td>
                            <td align="center" id="goods_num">
                                <select name="age" id="goods_num${goods.gId}">
                                <c:forEach begin="0" end="${goods.g_number}" var="i">
                                    <option value='${i}'>${i}</option>
                                </c:forEach>
                                </select>
                            </td>

                            <td align="center"> <input  type = "button" value = "加入" onclick="add_to_cart('${goods.gId}')"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot></tfoot>
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
