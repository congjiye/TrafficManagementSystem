<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/6/2
  Time: 下午 6:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>忘记密码</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../../css/forget.css">
    <style>
        *{
            font-family: 微软雅黑;
        }
    </style>
</head>
<body>
<div class="forgetForm">
    <div class="forgetUl">
        <table>
            <tr>
                <td>
                    <div class="trangle select">
                        <i class="forgetI select">1</i>
                    </div>
                </td>
                <td>
                    <div class="trangle select">
                        <i class="forgetI select">2</i>
                    </div>
                </td>
                <td>
                    <div class="trangle select">
                        <i class="forgetI select">3</i>
                    </div>
                </td>
                <td>
                    <div class="trangle select">
                        <i class="forgetI select">4</i>
                    </div>
                </td>
            </tr>
            <tr>
                <td><span class="spanSelect">填写用户名</span></td>
                <td><span class="spanSelect">验证身份</span></td>
                <td><span class="spanSelect">设置新密码</span></td>
                <td><span class="spanSelect">完成</span></td>
            </tr>
        </table>
    </div>
    <div class="submitForm">
        <h1 class="spanSelect">恭喜您，密码修改成功</h1>
        <p id="page_div" style="text-align: center"></p>
        <p style="text-align: center"><a href="/exit" style="font-size: 14px;color: dodgerblue;">如果没有跳转，请点击这里</a></p>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script>
    var num = 4; //倒计时的秒数
    var URL = "/exit";
    window.setTimeout("doUpdate()", 1000);
    function doUpdate(){
        if(num != 0){
            document.getElementById('page_div').innerHTML = '将在'+num+'秒后自动跳转到登录界面' ;
            num --;
            window.setTimeout("doUpdate()", 1000);
        }else{
            num = 4;
            window.location = URL;
        }
    }
</script>
</html>

