<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/5/15
  Time: 上午 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>路线信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title">
    <legend>路线信息</legend>
</fieldset>
<div style="margin: 20px;">
    <c:forEach items="${subway}" var="route">
        <ul class="layui-timeline">
            <li class="layui-timeline-item">
                <i class="layui-icon layui-timeline-axis"></i>
                <div class="layui-timeline-content layui-text">
                    <h3 class="layui-timeline-title">${route.stationName}站</h3>
                </div>
            </li>
        </ul>
    </c:forEach>
</div>
<script src="../../layui/layui.js"></script>
<script src="../../js/subway.js"></script>
</body>
</html>
