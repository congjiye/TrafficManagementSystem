<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/6/1
  Time: 下午 7:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <div class="trangle">
                        <i class="forgetI">3</i>
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
                <td><span>设置新密码</span></td>
                <td><span>完成</span></td>
            </tr>
        </table>
    </div>
    <div class="submitForm">
        <form action="" method="post" >
            <div class="inputBox">
                <span id="span" style="float: right;display: block;font-size: 14px;margin-right: 30px;line-height: 32px;"></span>
                <label for="user" style="display: inline-block;width: 80px;">账户名：</label>
                <input type="text" id="user" class="inputEmail" name="user" readonly="readonly" value="${user}">
            </div>
            <div class="inputBox">
                <label for="email">验证邮箱：</label>
                <input type="email" id="email" class="inputEmail" name="email" value="${email}" readonly="readonly">
            </div>
            <h3 id="spanMail" style="margin-left: 78px;"></h3>
        </form>
    </div>
    <div class="back">
        <a href="/exit">« 返回登录</a>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script>
    window.onload = function () {
        $.ajax({
           url:"/sendMail",
           type:"POST",
           data:{"email":$("#email").val(),"user":$("#user").val()},
           success:function () {
               $("#spanMail").html("邮件已发送到该邮箱，请登录该邮箱进行密码修改");
           }
        });
    }
</script>
</html>
