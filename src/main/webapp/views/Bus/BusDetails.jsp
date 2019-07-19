<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/5/5
  Time: 下午 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>公交车详细信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<body>
<div style="margin: 10px;">
    <button class="layui-btn layui-btn-warm" id="modify-btn">点击修改</button>
</div>
<fieldset class="layui-elem-field layui-field-title">
    <legend>${busInfo.busName}信息</legend>
</fieldset>
<div style="margin: 20px;">
    <form class="layui-form" action="/modifyBusDetails?bus_id=${busInfo.busId}" method="post">
        <div class="layui-form-item" style="margin-top: 10px">
            <div class="layui-inline">
                <label class="layui-form-label">运行时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="date" lay-verify="title" autocomplete="off" value="${busDetails.busRunDate}" class="layui-input layui-disabled" disabled="">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">所属公司</label>
                <div class="layui-input-inline">
                    <input type="text" name="company" lay-verify="title" autocomplete="off" value="${busDetails.busCompany}" class="layui-input layui-disabled" disabled="">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">乘车价格</label>
                <div class="layui-input-inline">
                    <input type="text" name="pay" lay-verify="title" autocomplete="off" value="${busDetails.busPay}" class="layui-input layui-disabled" disabled="">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">运行状态</label>
                <div class="layui-input-inline">
                    <input type="text" name="status" lay-verify="title" autocomplete="off" value="${busDetails.busStatus}" class="layui-input layui-disabled" disabled="">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" lay-submit="" id="bus-success">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script src="../../layui/layui.js"></script>
<script src="../../js/Bus.js"></script>
</body>
</html>
