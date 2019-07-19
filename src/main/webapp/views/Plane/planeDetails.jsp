<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/5/16
  Time: 上午 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>飞机详细信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<body>
<div style="margin: 10px;">
    <button class="layui-btn layui-btn-warm" id="modify-btn">点击修改</button>
</div>
<fieldset class="layui-elem-field layui-field-title">
    <legend>${plane.planeName}信息</legend>
</fieldset>
<div style="margin: 20px;">
    <form class="layui-form" action="/modifyPlaneDetails?plane_id=${planeDet.planeId}" method="post">
        <div class="layui-form-item" style="margin-top: 10px">
            <div class="layui-inline">
                <label class="layui-form-label">起飞时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="start" lay-verify="title" autocomplete="off" value="${planeDet.planeBeginTime}" class="layui-input layui-disabled" disabled="">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">到达时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="end" lay-verify="title" autocomplete="off" value="${planeDet.planeEndTime}" class="layui-input layui-disabled" disabled="">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" lay-submit="" id="plane-btn-success">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script src="../../layui/layui.js"></script>
<script src="../../js/plane.js"></script>
</body>
</html>