<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/4/23
  Time: 下午 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>地铁图</title>
    <script type="text/javascript" src="https://api.map.baidu.com/api?type=subway&v=1.0&ak=gnQYKhUU12apru76oIUG2F4gCobxWgQU"></script>
    <style type="text/css">
        #container{height:100%}
    </style>
</head>
<body>
<div id="container">
</div>
<script type="text/javascript">
    /**
     * 从所有城市列表中获取北京信息
     * 结果格式
     * {
     *     keyword: 'beijing',
     *     name: '北京',
     *     citycode: '131'
     * }
     */
    /* globals BMapSub */
    var subwayCityName = '杭州';
    var list = BMapSub.SubwayCitiesList;
    var subwaycity = null;
    for (var i = 0; i < list.length; i++) {
        if (list[i].name === subwayCityName) {
            subwaycity = list[i];
            break;
        }
    }
    // 获取北京地铁数据-初始化地铁图
    var subway = new BMapSub.Subway('container', subwaycity.citycode);
    var zoomControl  = new BMapSub.ZoomControl({
        anchor: BMAPSUB_ANCHOR_BOTTOM_RIGHT,
        offset: new BMapSub.Size(10,100)
    });
    subway.setZoom(0.8);
    subway.addControl(zoomControl);
    subway.addEventListener('tap', function(e) {
        window.location.href = '/desSubwayStation?stationName='+ encodeURI(e.station.name);
    });

</script>
</body>
</html>
