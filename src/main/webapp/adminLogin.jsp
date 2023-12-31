<%--
  Created by IntelliJ IDEA.
  User: klues
  Date: 2023/12/11
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page import="com.web.util.DBUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>欢迎来到美味餐厅</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <style>
        body{


            background-image: url("images/1.jpg");
            background-size: 2000px ;
            background-repeat: no-repeat;
        }

        .box{
            width: 60%;
            height: 450px;
            box-shadow: 0 5px 15px rgba(0,0,0,.8);
            display: flex;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
        }
        .left{
            width: 65%;
        }
        .left>img {
            display: block;
            height: 100%;
            width: 100%;
            max-height: 100%;
        }
        .right{
            width: 35%;
            height: 100%;
            background-color: #fff;
            box-sizing: border-box;
            padding: 10px 20px;
        }
        h1{
            text-align: center;
            padding-top: 45px;
            margin-top: 0;

        }
        .inputItem{
            height: 40px;
            width: 60%;
            padding-left: 20px;
            border: none;
            background: none;
            outline: none;
            border-bottom: 3px solid #B3A5FC;
            font-size: 20px;
            margin-top: 5px;
            margin-left: 25px;
        }
        .but{
            background: #f1f1f1 ;
            border-radius: 10px 10px 10px 10px;
            color: black;
            border: none;
            height: 46px;
            width: 30%;
            font-size: 18px;
            margin-top: 30px;
            margin-left: 20px;
        }
        span{
            color:red;
            margin-left: 100px;
        }
        #login{
            margin-left: 100px;
        }


    </style>
</head>
<body>
<div class="box">
    <div class="left">
        <img src="images/hsr.png" alt="" >
    </div>
    <div class="right">
        <h1>管理员登陆</h1>
        <span  id="msg">${msg}</span>
        <form action="adminLogin" method="post">
            <input type="text" class="inputItem" placeholder="用户名" name="aName"/><br>
            <input type="password" class="inputItem" placeholder="密码" name="aPassword"/><br>
            <input type="submit" value="登录" class="but" id="login"/>
        </form>
    </div>
</div>
</body>
</html>