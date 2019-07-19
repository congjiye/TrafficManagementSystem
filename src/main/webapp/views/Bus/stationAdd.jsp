<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/5/14
  Time: 下午 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加站点</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--<title>layout 后台大布局 - Layui</title>--%>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <%--<link rel="stylesheet" href="../css/login.css">--%>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>站点添加</legend>
</fieldset>
<div style="padding: 0px 20px;">
    <form action="" class="layui-form layui-form-pane" id="form1">
        <div class="layui-form-item">
            <label class="layui-form-label">站点Id</label>
            <div class="layui-input-block">
                <input type="text" id="stationId" name="stationId" lay-verify="required" value="" autocomplete="off" class="layui-input layui-disabled" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">站点名</label>
            <div class="layui-input-block">
                <input type="text" id="stationName" name="stationName" lay-verify="required" value="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公交路线ID</label>
            <div class="layui-input-block">
                <select name="route" id="route">
                    <option value="">请选择路线</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">站点位置</label>
            <div class="layui-input-block">
                <input type="text" id="stationPosition" name="stationPosition" lay-verify="required" value="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" id="bus-station-btn-success">立即提交</button>
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
            url: "/getStationId",
            type: "GET",
            success: function (result) {
                document.getElementById("stationId").value = result + 1;
            }
        });
        $.ajax({
            url: "/routeId",
            type: "POST",
            success: function (result) {
                var list = result;
                var route = document.getElementById("route");
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
