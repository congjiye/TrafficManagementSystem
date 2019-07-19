<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/5/10
  Time: 下午 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统主页</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--<title>layout 后台大布局 - Layui</title>--%>
    <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<body>
<div style="padding: 20px;">
    <blockquote class="layui-elem-quote">
        交通信息网上查询系统基本功能大致介绍
    </blockquote>

    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-collapse" lay-accordion="">
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">公交信息管理</h2>
                    <div class="layui-colla-content layui-show">

                        <div class="layui-collapse" lay-accordion="">
                            <div class="layui-colla-item">
                                <h2 class="layui-colla-title">车辆管理</h2>
                                <div class="layui-colla-content layui-show">
                                    <blockquote class="layui-elem-quote">
                                        车辆管理包含了公交车详细信息查看、公交车路线详细信息查看以及公交车的增删改查
                                    </blockquote>
                                    <img src="../image/busConfig.png" style="width: 960px;height: 540px;">
                                    <br>
                                    <div class="layui-collapse" lay-accordion="">
                                        <div class="layui-colla-item">
                                            <h2 class="layui-colla-title">添加公交</h2>
                                            <div class="layui-colla-content layui-show">
                                                <img src="../image/busadd.png">
                                                <strong>------------->></strong>
                                                <img src="../image/busaddinfo.png">
                                            </div>
                                        </div>
                                        <div class="layui-colla-item">
                                            <h2 class="layui-colla-title">公交详情</h2>
                                            <div class="layui-colla-content">
                                                <img src="../image/busdetails.png">
                                            </div>
                                        </div>
                                        <div class="layui-colla-item">
                                            <h2 class="layui-colla-title">修改公交</h2>
                                            <div class="layui-colla-content">
                                                <img src="../image/busedit.png">
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="layui-colla-item">
                                <h2 class="layui-colla-title">站点管理</h2>
                                <div class="layui-colla-content">
                                    <img src="../image/busstation.png" style="width: 960px;height: 540px;">
                                </div>
                            </div>
                            <div class="layui-colla-item">
                                <h2 class="layui-colla-title">路线管理</h2>
                                <div class="layui-colla-content">
                                    <img src="../image/busroute.png" style="width: 960px;height: 540px;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">地铁管理</h2>
                    <div class="layui-colla-content">
                        <img src="../image/subway.png" style="width: 960px;height: 540px;">
                    </div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">列车管理</h2>
                    <div class="layui-colla-content">
                        <img src="../image/train.png" style="width: 960px;height: 540px;">
                    </div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">航班管理</h2>
                    <div class="layui-colla-content">
                        <img src="../image/planeInfo.png" style="width: 960px;height: 540px;">
                    </div>
                </div>
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">用户管理</h2>
                    <div class="layui-colla-content">
                        <img src="../image/userInfo.png" style="width: 960px;height: 540px;">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../layui/layui.js"></script>
<script>
    layui.use(['element', 'layer'], function(){
        var element = layui.element;
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(test)', function(data){
            layer.msg('展开状态：'+ data.show);
        });
    });
</script>
</body>
</html>
