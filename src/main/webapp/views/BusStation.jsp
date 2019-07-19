<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/5/21
  Time: 下午 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/busInfo.css">
    <link rel="stylesheet" href="../css/blog.css">
    <link rel="stylesheet" href="../css/liRadius.css">
    <%--<link rel="stylesheet" href="../css/index.css">--%>
    <title>站点信息查询</title>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/showPage">交通信息查询</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/showPage">主页</a></li>
                <li class="active"><a href="/chooseBus">公交</a></li>
                <li><a href="/chooseSubway">地铁</a></li>
                <li><a href="/choosePlane">飞机</a></li>
                <li><a href="/chooseTrain">火车</a></li>
                <li><a href="/getMap">地图</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</nav>
<div class="container">
    <div class="blog-header">
        <h1 class="blog-title">${stationName}<small> 信息查询</small></h1>
        <p class="lead blog-description">站点详细信息显示</p>
    </div>
    <div class="row">
        <div class="col-sm-8 blog-main">
            <div class="row">
                <div class="col-sm-6" style="border-right: 5px solid #1dd1a1;">
                    <img src="../image/cityMain.jpg" class="img-thumbnail" style="width: 200px;height: 200px;">
                </div>
                <div class="col-sm-6">
                    站点名称：<small>${stationName}</small><br><br>
                    <p>
                        <em>
                            <h4>
                                [站点文字介绍]
                            </h4>
                        </em>
                    </p>
                </div>
            </div>
            <br>
            <br>
            <h4><strong>${stationName}站经过线路</strong>
            </h4>
            <hr style="background-color:#00cec9;height:2px;border:none">
            <div>
                <c:forEach items="${busList}" var="buslist">
                    <c:forEach items="${buslist}" var="bus">
                        <a href="/desRoute?busName=${bus.busName}" style="display: block;margin: 0 10px;float: left;"> ${bus.busName}</a>
                    </c:forEach>
                </c:forEach>
            </div>
        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <div class="sidebar-module sidebar-module-inset">
                <h4>大家都在搜</h4>
                <p><a href="https://www.baidu.com/s?ie=utf-8&wd=%E6%9D%AD%E5%B7%9E%E6%97%85%E6%B8%B8%E6%94%BB%E7%95%A5&tn=8684cpr&rsv_lu=1&fenlei=mv6qUZNxTZn0IZRqIHndPjbdP1R0T1YsujPbrHn3PhnvrAmLnWIW0ZwV5HDkn1RYPj60mvmqnfKzmWYs0AkdpvbqnfKWUMw85H6vrjwWTZc0TLPs5HD0TLPsnWYk0ZwYTjYk0AkdT1Ysryczn19hnyNbPhnvuHbd0AkdTLfqPyPbujnLnyR0UZNWIjYdmvwbPHmdr0K_INqGuAnqUhCsn6KWI7qYpgfq0APYgvP9IjY0mLwxUA7B5fKYTh7buHDqn0KYTh7buHcqn0KBThfq0AdbUjY0uZws5HD0pgwV5H00mywWUA71T1Ys0ZIG5Hf0uMPWpAdb5Hc0IAfqn1RYrHRLPfK-XZKGujY4njfLg1bsrjuxrHRsndt4PHDYg1bdPjKxrHR4nNtznj0snHKxnW0snjnzg1csnj0YPfKdThsqpZwYTZn-nYD-nbm-nbuCmy4MXh9EIiRzwH6vrjf-nbNWUBRzw60">杭州旅游攻略</a></p>
                <p><a href="https://www.baidu.com/s?ie=utf-8&wd=%E5%85%AC%E4%BA%A4%E7%AB%99%E5%8F%B0&tn=8684cpr&rsv_lu=1&fenlei=mv6qUZNxTZn0IZRqIHndPjbdP1R0T1YLPhfdPjKWnjPBnhn1Pyfk0ZwV5HDkn1RYPj60mvmqnfKzmWYs0Akdpvbqn6KWUMw85H6vrjwWTZc0TLPs5HD0TLPsnWYk0ZwYTjYk0AkdT1Ysryczn19hnyNbPhnvuHbd0AkdTLfqPyPbujnLnyR0UZNWIjYdmvwbPHm4n0K_INqGuAnqUhCsn6KWI7qYpgfq0APYgvP9IjY0mLwxUA7B5fKYTh7buHDqn0KYTh7buHcqn0KBThfq0AdbUjY0uZws5HD0pgwV5H00mywWUA71T1Ys0ZIG5Hf0uMPWpAdb5Hc0IAfqn1RYrHRLPfK-XZKGujY4njfLg1bsrjuxrHRsndt4PHDYg1bdPjKxrHR4nNtznj0snHKxnW0snjnzg1csnj0YPfKdThsqpZwYTZn-nYD-nbm-nbuCmy4MXh9EIiRzwH6vrjf-nbNWUBRzw60">公交站台</a></p>
                <p><a href="https://www.baidu.com/s?ie=utf-8&wd=%E6%9D%AD%E5%B7%9E%E6%B0%91%E5%AE%BF&tn=8684cpr&rsv_lu=1&fenlei=mv6qUZNxTZn0IZRqIHndPjbdP1R0T1dhPjwWnjb3P1DYnWbknjc10ZwV5HDkn1RYPj60mvmqnfKzmWYs0AkdpvbqPfKWUMw85H6vrjwWTZc0TLPs5HD0TLPsnWYk0ZwYTjYk0AkdT1Ysryczn19hnyNbPhnvuHbd0AkdTLfqPyPbujnLnyR0UZNWIjYdmvwbPHuBu0K_INqGuAnqUhCsn6KWI7qYpgfq0APYgvP9IjY0mLwxUA7B5fKYTh7buHDqn0KYTh7buHcqn0KBThfq0AdbUjY0uZws5HD0pgwV5H00mywWUA71T1Ys0ZIG5Hf0uMPWpAdb5Hc0IAfqn1RYrHRLPfK-XZKGujY4njfLg1bsrjuxrHRsndt4PHDYg1bdPjKxrHR4nNtznj0snHKxnW0snjnzg1csnj0YPfKdThsqpZwYTZn-nYD-nbm-nbuCmy4MXh9EIiRzwH6vrjf-nbNWUBRzw60">杭州民宿</a></p>
                <p><a href="https://www.baidu.com/s?ie=utf-8&wd=%E6%9D%AD%E5%B7%9E%E7%A7%9F%E6%88%BF&tn=8684cpr&rsv_lu=1&fenlei=mv6qUZNxTZn0IZRqIHndPjbdP1R0T1YLmWDdPjNWPWb4rHfvnjn40ZwV5HDkn1RYPj60mvmqnfKzmWYs0AkdpvbqrfKWUMw85H6vrjwWTZc0TLPs5HD0TLPsnWYk0ZwYTjYk0AkdT1Ysryczn19hnyNbPhnvuHbd0AkdTLfqPyPbujnLnyR0UZNWIjYdmvwbPHu-P0K_INqGuAnqUhCsn6KWI7qYpgfq0APYgvP9IjY0mLwxUA7B5fKYTh7buHDqn0KYTh7buHcqn0KBThfq0AdbUjY0uZws5HD0pgwV5H00mywWUA71T1Ys0ZIG5Hf0uMPWpAdb5Hc0IAfqn1RYrHRLPfK-XZKGujY4njfLg1bsrjuxrHRsndt4PHDYg1bdPjKxrHR4nNtznj0snHKxnW0snjnzg1csnj0YPfKdThsqpZwYTZn-nYD-nbm-nbuCmy4MXh9EIiRzwH6vrjf-nbNWUBRzw60">杭州租房</a></p>
            </div>
            <div class="sidebar-module">
                <h4>相关搜索</h4>
                <ol class="list-unstyled">
                    <li><a href="https://hangzhou.8684.cn/" style="font-family: sans-serif;">8684公交查询</a></li>
                    <li><a href="https://www.12306.cn/index/" style="font-family: sans-serif;">12306铁路查询</a></li>
                </ol>
            </div>
            <div class="sidebar-module">
                <h4>其他功能</h4>
                <ol class="list-unstyled">
                    <li><a href="/chooseSubway">地铁</a></li>
                    <li><a href="/chooseTrain">火车</a></li>
                    <li><a href="/choosePlane">飞机</a></li>
                    <li><a href="/getMap">地图</a></li>
                </ol>
            </div>
        </div><!-- /.blog-sidebar -->

    </div>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-muted">@交通信息网上查询系统</p>
    </div>
</footer>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="../layui/layui.js"></script>
<script>

    $(function(){
        //交换两个input中的值
        $("#exchange").click(function () {
            var start = document.getElementById("start").value;
            var end = document.getElementById("end").value;

            document.getElementById("start").value = end;
            document.getElementById("end").value = start;
        });


        //获取点击事件的对象
        $(".navSelect li").click(function(){
            //获取要显示或隐藏的对象
            var divShow = $(".content").children('.list');
            //判断当前对象是否被选中，如果没选中的话进入if循环
            if (!$(this).hasClass('selected')) {
                //获取当前对象的索引
                var index = $(this).index();
                //当前对象添加选中样式并且其同胞移除选中样式；
                $(this).addClass('selected').siblings('li').removeClass('selected');
                //索引对应的div块显示
                $(divShow[index]).show();
                //索引对应的div块的同胞隐藏
                $(divShow[index]).siblings('.list').hide();
            }
        });
    });
</script>
</html>
