<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/4/30
  Time: 下午 3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
    <title>异步加载地图</title>
</head>
<body>

<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
    //百度地图API功能
    function loadJScript() {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=gnQYKhUU12apru76oIUG2F4gCobxWgQU&callback=init";
        document.body.appendChild(script);
    }
    function init() {
        var map = new BMap.Map("allmap");
        var point = new BMap.Point(116.331398,39.897445);
        map.centerAndZoom(point,12);

        function myFun(result){
            var cityName = result.name;
            map.setCenter(cityName);
        }
        var myCity = new BMap.LocalCity();
        myCity.get(myFun);
        map.enableScrollWheelZoom();                 //启用滚轮放大缩小
    }
    window.onload = loadJScript;  //异步加载地图
</script>


