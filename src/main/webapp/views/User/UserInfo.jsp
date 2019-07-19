<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/4/26
  Time: 上午 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--<title>layout 后台大布局 - Layui</title>--%>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../font-awesome-4.7.0/css/font-awesome.min.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>用户信息管理</legend>
</fieldset>

<div style="margin:10px">
    <div class="demoTable">
        搜索：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
    <table class="layui-hide" id="user_table" lay-filter="table"></table>
</div>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add" id="btn-add">添加</button>
        <button class="layui-btn layui-btn-sm" lay-event="refresh" id="btn-refresh"><i class="fa fa-refresh"></i></button>
    </div>
</script>

<script type="text/html" id="barOption">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="../../layui/layui.js"></script>
<script src="../../js/user.js"></script>
</body>
</html>
