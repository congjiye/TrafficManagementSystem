<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/4/29
  Time: 下午 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>交通信息网上查询系统</title>
    <link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/carousel.css">
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">交通信息查询</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/showPage">主页</a></li>
                        <li><a href="/chooseBus">公交</a></li>
                        <li><a href="/chooseSubway">地铁</a></li>
                        <li><a href="/choosePlane">飞机</a></li>
                        <li><a href="/chooseTrain">火车</a></li>
                        <li><a href="/getMap">地图</a></li>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class=""></li>
        <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item">
            <img class="first-slide" src="../image/planeStation.jpg" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>飞机机票</h1>
                    <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">点我查询</a></p>
                </div>
            </div>
        </div>
        <div class="item active">
            <img class="second-slide" src="../image/night.jpg" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>城市公交</h1>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">点我查询</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide" src="../image/timg.jfif" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>高铁火车</h1>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">点我查询</a></p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="../image/bus.jfif" alt="Generic placeholder image" width="140" height="140">
            <h2>城市交通</h2>
            <p>支持城市公交查询、地铁查询、城市公交地铁详细资料查询，提供地铁路线表等服务。</p>
            <p><a class="btn btn-default" href="/chooseBus" role="button">查看更多 »</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="../image/plane.jfif" alt="Generic placeholder image" width="140" height="140">
            <h2>飞机</h2>
            <p>支持机票查询、机场时刻表实时查询，提供机场攻略查看</p>
            <p><a class="btn btn-default" href="/choosePlane" role="button">查看更多 »</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="../image/train.jfif" alt="Generic placeholder image" width="140" height="140">
            <h2>高铁火车</h2>
            <p>支持国内火车查询、出行路线查询、全国列车时刻实时查询，提供12306直连等服务。</p>
            <p><a class="btn btn-default" href="/chooseTrain" role="button">查看更多 »</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">旅途不迷路 <span class="text-muted">机票有限制，服务无极限</span></h2>
            <p class="lead">出门在外不容易，一人不识票难订；
                酒店不知价几何，被宰不说气难平。
                旅游本是去观光，奈何被骗进商场；
                不买东西甭出来，出来身上响叮当。
                读书不如行万里，现在有我来帮您；
                四个六后四个零，特价统统都打尽。
                特价到底有那些，机票酒店和旅行；
                路路通达路路顺，服务一万四颗心
                <a href="#">» 查看机票</a>
            </p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500" src="../image/planeroute.png" data-holder-rendered="true">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
            <h2 class="featurette-heading">城市出行不方便？<span class="text-muted">交通信息网上查</span></h2>
            <p class="lead">
                道路畅通让城市提速，出行文明使广州增辉。
                彼此让一让，路宽心更宽。
                路好，车好，文明最好；快行，慢行，安全才行。
                天天出行人人礼让，日日安全路路通畅。
                迈文明步子，开安全车子，做礼让君子，过平安日子。
                <a href="#">» 查看城市</a>
            </p>
        </div>
        <div class="col-md-5 col-md-pull-7">
            <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500" src="../image/traffic.png" data-holder-rendered="true">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">安全快捷处处舒心， <span class="text-muted">温馨服务美丽心情</span></h2>
            <p class="lead">新高铁，兴成渝，心服务，馨感受。
                梦为快乐旅途守候，心被成渝高铁挽留。
                聆听巴山夜雨，畅享成渝高铁。
                杭黄高铁，美时美刻。
                成渝高铁，拉近你我，温暖一冬。
                <a href="#">» 查看火车</a>
            </p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500" src="../image/trainRoute.png" data-holder-rendered="true">
        </div>
    </div>

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->


    <!-- FOOTER -->
    <footer>
        <p class="pull-right"><a href="#">返回顶部</a></p>
        <%--<p>友情链接<a href="#">12306</a> </p>--%>
        <p>© 2016 Company, Inc. · <a href="#">Privacy</a> · <a href="#">Terms</a></p>

    </footer></div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
