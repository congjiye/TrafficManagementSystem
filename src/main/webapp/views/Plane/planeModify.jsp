<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/5/16
  Time: 上午 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改地铁信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--<title>layout 后台大布局 - Layui</title>--%>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <%--<link rel="stylesheet" href="../css/login.css">--%>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title">
    <legend>修改${plane.planeName}信息</legend>
</fieldset>
<div style="margin: 20px;">
    <form class="layui-form" action="/editPlane" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">飞机名</label>
            <div class="layui-input-block">
                <input type="text" name="planeName" lay-verify="required" value="${plane.planeName}" autocomplete="off" class="layui-input layui-disabled" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">路线名</label>
            <div class="layui-input-block">
                <select name="planeRoute" id="planeRoute">
                    <option value="">请选择路线</option>
                </select>
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
            url: "/planeRouteId",
            type: "GET",
            success: function (result) {
                var list = result;
                var route = document.getElementById("planeRoute");
                for (var p in list) {
                    var option = document.createElement("option");
                    option.setAttribute("value", parseInt(p)+1);
                    option.innerText = list[p];
                    route.appendChild(option);
                    form.render("select");
                }
            }
        });
    })
</script>
</body>
</html>
