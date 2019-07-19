<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/4/23
  Time: 下午 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--<title>layout 后台大布局 - Layui</title>--%>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <%--<link rel="stylesheet" href="../css/login.css">--%>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>公交添加</legend>
</fieldset>
<div style="padding: 0px 20px;">
    <form action="" class="layui-form layui-form-pane" id="form1">
        <div class="layui-form-item">
            <label class="layui-form-label">公交名</label>
            <div class="layui-input-block">
                <input type="text" name="busName" lay-verify="required|busname" placeholder="请输入公交车名" autocomplete="off" class="layui-input" id="busName">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公交路线ID</label>
            <div class="layui-input-block">
                <select name="route" id="route" lay-verify="required">
                    <option value="">请选择路线</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" id="bus-btn-success">立即提交</button>
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
        form.verify({
            busname: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '公交名不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '公交名首尾不能出现下划线\'_\'';
                }
            }
        });
    })
</script>
</body>
</html>
