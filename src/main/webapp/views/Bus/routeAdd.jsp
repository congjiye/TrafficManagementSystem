<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/5/10
  Time: 下午 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加路线</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--<title>layout 后台大布局 - Layui</title>--%>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <%--<link rel="stylesheet" href="../css/login.css">--%>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>路线添加</legend>
</fieldset>
<div style="padding: 0px 20px;">
    <h3>输入始发站终点站请按“xxx-xxx”的格式输入</h3>
    <br>
    <form action="" class="layui-form-pane" id="form1">
        <div class="layui-form-item">
            <label class="layui-form-label">路线Id</label>
            <div class="layui-input-block">
                <input type="text" id="routeId" name="routeId" lay-verify="required" value="" autocomplete="off" class="layui-input layui-disabled" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">始发站-终点站</label>
            <div class="layui-input-block">
                <input type="text" name="routeName" lay-verify="required" placeholder="请输入路线始终站" autocomplete="off" class="layui-input" id="routeName">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" id="bus-route-btn-success">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script src="../../layui/layui.js"></script>
<script src="../../js/Bus.js"></script>
<script>
    layui.use('table', function() {
        var $ = layui.jquery;
        var form = layui.form;
        var len;
        $.ajax({
            url: "/getRouteId",
            type: "GET",
            success: function (result) {
                len = result.length;
                document.getElementById("routeId").value = len + 1;
            }
        });
    })
</script>
</body>
</html>
