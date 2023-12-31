<%--
  Created by IntelliJ IDEA.
  User: lifan
  Date: 2023-12-05
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
</head>
<body>
    <h1>用户登录</h1>
    <span style="color:red;">${msg}</span>
    <form action="UserLogin" method="post">
        账户:<input type="text" name="aName"/><br/><br/>
        密码:<input type="password" name="aPassword"/><br/><br/>
        <input type="submit" value="登录"/>
        <input type="button" value="注册"/>
    </form>
</body>
</html>
