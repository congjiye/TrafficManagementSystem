<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/6/2
  Time: 下午 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>安全设置</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--<title>layout 后台大布局 - Layui</title>--%>
    <link rel="stylesheet" href="../font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../../css/safe.css">
    <%--<link rel="stylesheet" href="../css/index.css">--%>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>安全设置</legend>
</fieldset>
<div class="safeBox">
    <div class="safeInput">
        <h1 class="safeH1">用户名<h3 style="color: dodgerblue;margin-top: 20px;float: right;"><%=session.getAttribute("username")%></h3></h1>
        <hr class="safeHr">
    </div>
    <div class="safeInput" style="margin-top: 50px;">
        <h1 class="safeH1">邮箱
            <small style="font-size: 18px;color: #1b6d85;">
                <%--<i class="fa fa-refresh" aria-hidden="true"></i>--%>
                <%--<a href="#" style="color: #1b6d85;" id="change">修改邮箱</a>--%>
            </small>
            <h3 style="color: dodgerblue;margin-top: 20px;float: right;">${mail}</h3>
        </h1>
        <hr class="safeHr">
    </div>
    <blockquote class="layui-elem-quote">
        其他功能正在开发中
    </blockquote>
</div>
<script src="../layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
