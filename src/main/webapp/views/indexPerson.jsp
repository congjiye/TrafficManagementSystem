<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/4/23
  Time: 上午 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台信息管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <%--<title>layout 后台大布局 - Layui</title>--%>
    <link rel="stylesheet" href="../font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../css/index.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            后台信息管理
        </div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <%--<li class="layui-nav-item"><a href="">控制台</a></li>--%>
            <%--<li class="layui-nav-item"><a href="">商品管理</a></li>--%>
            <%--<li class="layui-nav-item"><a href="">用户</a></li>--%>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="/showPage">交通信息网上查询系统</a></dd>
                    <%--<dd><a href="">消息管理</a></dd>--%>
                    <%--<dd><a href="">授权管理</a></dd>--%>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    <%=session.getAttribute("username")%>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="/exit">退出</a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-this">
                    <a href="javascript:;" data-id="0" data-title="系统主页" data-url="/index"
                       class="site-demo-active" data-type="tabAdd"><i class="fa fa-home" style="margin-right: 10px;"></i>系统主页</a>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;"><i class="fa fa-bus" style="margin-right: 10px;"></i>公交信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-id="1" data-title="车辆管理" data-url="/busInfo"
                               class="site-demo-active" data-type="tabAdd">车辆管理</a></dd>
                        <dd><a href="javascript:;" data-id="2" data-title="站点管理" data-url="/busStation"
                               class="site-demo-active" data-type="tabAdd">站点管理</a></dd>
                        <dd><a href="javascript:;" data-id="3" data-title="路线管理" data-url="/busRoute"
                               class="site-demo-active" data-type="tabAdd">路线管理</a></dd>
                        <%--<dd><a href="javascript:;"></a></dd>--%>
                        <%--<dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-subway" style="margin-right: 10px;"></i>地铁管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-id="4" data-title="车次管理" data-url="/subwayInfo"
                               class="site-demo-active" data-type="tabAdd">车次管理</a></dd>
                        <dd><a href="javascript:;" data-id="5" data-title="车站管理" data-url="/subwayStation"
                               class="site-demo-active" data-type="tabAdd">车站管理</a></dd>
                        <%--<dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-train" style="margin-right: 10px;"></i>列车管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-id="6" data-title="车次管理" data-url="/trainInfo"
                               class="site-demo-active" data-type="tabAdd">车次管理</a></dd>
                        <dd><a href="javascript:;" data-id="7" data-title="车站管理" data-url="/trainStation"
                               class="site-demo-active" data-type="tabAdd">车站管理</a></dd>
                        <%--<dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-id="8" data-title="航班管理" data-url="/planeInfo"
                       class="site-demo-active" data-type="tabAdd"> <i class="fa fa-plane" style="margin-right: 10px;"></i>航班管理</a>
                </li>
                <%--<li class="layui-nav-item"><a href="">发布商品</a></li>--%>
            </ul>
        </div>
    </div>

    <div class="layui-tab layui-tab-brief" lay-filter="demo" lay-allowclose="true">
        <ul class="layui-tab-title site-demo-title">
            <li lay-id="0" class="layui-this" id="indexPage">系统主页</li>
        </ul>
        <%--<div class="layui-tab-content"></div>--%>
        <%--<div class="layui-body">--%>
        <!-- 内容主体区域 -->
        <div class="layui-body layui-tab-content site-demo site-demo-body">
            <div class="layui-tab-item layui-show">
                <iframe data-frameid="0" scrolling="auto" frameborder="0" src="/index" style="width:100%;height: 100%;"></iframe>
            </div>
        </div>
        <%--</div>--%>
    </div>


    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 交通信息网上查询系统后台管理
    </div>
</div>
<script src="../layui/layui.js"></script>
<script src="../js/iframeShow.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>
