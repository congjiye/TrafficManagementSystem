<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/4/26
  Time: 下午 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--<title>layout 后台大布局 - Layui</title>--%>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../css/login.css">
</head>
<body>
<div class="login-box">
    <h1>用户登录</h1>
    <p class="errMsg">
        <%
            if(session.getAttribute("errMsg") != null){
                out.print(session.getAttribute("errMsg"));
            }
        %>
    </p>
    <form action="/login" method="post" onSubmit="return check()">
        <div class="textbox">
            <i class="layui-icon layui-icon-username"></i>
            <input type="text" name="username" placeholder="用户名" id="username">
        </div>
        <div class="textbox">
            <i class="layui-icon layui-icon-password"></i>
            <input type="password" name="password" placeholder="密码" id="password">
        </div>
        <input type="submit" class="btn" value="登录">
        <hr>
        <a href="/forget">忘记密码？</a>
    </form>
</div>
<script>
    function check() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        if(username == ""){
            alert("用户名不能为空");
            document.getElementById("username").focus();
            return false;
        }else if(password == ""){
            alert("密码不能为空")
            document.getElementById("password").focus();
            return false;
        }
        return true;
    }

</script>
</body>
</html>
