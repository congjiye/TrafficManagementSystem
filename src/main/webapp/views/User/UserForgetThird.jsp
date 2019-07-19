<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/6/2
  Time: 下午 5:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>忘记密码</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../css/forget.css">
    <style>
        *{
            font-family: 微软雅黑;
        }
    </style>
</head>
<body>
<div class="forgetForm">
    <div class="forgetUl">
        <table>
            <tr>
                <td>
                    <div class="trangle select">
                        <i class="forgetI select">1</i>
                    </div>
                </td>
                <td>
                    <div class="trangle select">
                        <i class="forgetI select">2</i>
                    </div>
                </td>
                <td>
                    <div class="trangle select">
                        <i class="forgetI select">3</i>
                    </div>
                </td>
                <td>
                    <div class="trangle">
                        <i class="forgetI">4</i>
                    </div>
                </td>
            </tr>
            <tr>
                <td><span class="spanSelect">填写用户名</span></td>
                <td><span class="spanSelect">验证身份</span></td>
                <td><span class="spanSelect">设置新密码</span></td>
                <td><span>完成</span></td>
            </tr>
        </table>
    </div>
    <div class="submitForm">
        <form action="/userChange?userId=${user.userId}" method="post">
            <div class="inputBox">
                <span id="span" style="float: right;display: block;font-size: 14px;margin-right: 30px;line-height: 32px;"></span>
                <label for="user" style="display: inline-block;width: 80px;">账户名：</label>
                <input type="text" id="user" class="inputEmail" name="user" value="${user.userName}" readonly="readonly">
            </div>
            <div class="inputBox">
                <label for="password">输入密码：</label>
                <input type="password" id="password" class="inputEmail" name="password" placeholder="输入密码" style="color: #000;">
            </div>
            <div class="inputBox">
                <label for="confirmPass">输入密码：</label>
                <input type="password" id="confirmPass" class="inputEmail" name="email" placeholder="确认密码" style="color: #000;" oninput="checkPass()">
                <span id="tips" style="font-size: 14px;"></span>
            </div>
            <input type="submit" value="确认" class="submitBtn" id="btn" disabled="disabled" style="cursor: not-allowed;">
        </form>
    </div>
    <div class="back">
        <a href="/exit">« 返回登录</a>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script>
    function checkPass() {
        var password = $("#password").val();
        var confirmPass =$("#confirmPass").val();

        if(password === confirmPass){
            $("#tips").html("两次密码相同");
            $("#tips").css("color","green");
            $("#btn").removeAttr("disabled");
            $("#btn").css("cursor","pointer");
        }else if(confirmPass === ""){
            $("#tips").html("");
            $("#btn").css("cursor","not-allowed");
        } else {
            $("#tips").html("请输入同密码");
            $("#tips").css("color","red");
            $("#btn").attr("disabled","disabled");
            $("#btn").css("cursor","not-allowed");
        }
    }
</script>
</html>
