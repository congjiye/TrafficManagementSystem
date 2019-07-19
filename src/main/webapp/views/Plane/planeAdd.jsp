<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/5/16
  Time: 上午 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加地铁</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--<title>layout 后台大布局 - Layui</title>--%>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <%--<link rel="stylesheet" href="../css/login.css">--%>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>地铁添加</legend>
</fieldset>
<div style="padding: 0px 20px;">
    <form action="/addPlane" method="post" class="layui-form layui-form-pane" id="form1">
        <div class="layui-form-item">
            <label class="layui-form-label">飞机Id</label>
            <div class="layui-input-block">
                <input type="text" name="planeId" id="planeId" lay-verify="required" value="" autocomplete="off" class="layui-input layui-disabled" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">飞机名</label>
            <div class="layui-input-block">
                <input type="text" name="planeName" lay-verify="required" placeholder="请输入飞机名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">路线名</label>
            <div class="layui-input-block">
                <input type="text" name="routeName" lay-verify="required" placeholder="请输入路线名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" id="plane-btn-success">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script src="../../layui/layui.js"></script>
<script src="../../js/plane.js"></script>
<script>
    layui.use('table', function() {
        var $ = layui.jquery;
        var form = layui.form;
        $.ajax({
            url: "/getPlaneId",
            type: "POST",
            success: function (result) {
                document.getElementById("planeId").value = result + 1;
            }
        });
    })
</script>
</body>
</html>
