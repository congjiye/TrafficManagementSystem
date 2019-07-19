<%--
  Created by IntelliJ IDEA.
  User: Aydon
  Date: 2019/6/1
  Time: 下午 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <div class="trangle">
                            <i class="forgetI">2</i>
                        </div>
                    </td>
                    <td>
                        <div class="trangle">
                            <i class="forgetI">3</i>
                        </div>
                    </td>
                    <td>
                        <div class="trangle">
                            <i class="forgetI">4</i>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><span class="spanSelect">填写用户名</span></td>
                    <td><span>验证身份</span></td>
                    <td><span>设置新密码</span></td>
                    <td><span>完成</span></td>
                </tr>
            </table>
        </div>
        <div class="submitForm">
            <form action="/checkCode" method="post" onsubmit="return checkText()">
                <div class="inputBox">
                    <span id="span" style="float: right;display: block;font-size: 14px;margin-right: 30px;line-height: 32px;"></span>
                    <label for="user">账户名：</label>
                    <input type="text" id="user" style="padding: 7px 5px;width: 320px;font-size: 14px;border: 1px solid #e3e3e3;" placeholder="请输入账号" name="user" oninput="userCheck()">
                </div>
                <div class="inputBox">
                    <label for="register">验证码：</label>
                    <input type="text" id="register" style="padding: 7px 5px;width: 216px;font-size: 14px;border: 1px solid #e3e3e3;" placeholder="请输入验证码" name="register">
                    <div style="padding: 3px;float: right;margin-right: 120px;">
                        <img src="/getCode" onclick="changeImage()" id="imgObj">
                    </div>
                </div>
                <input type="submit" value="确认" class="submitBtn">
            </form>
        </div>
        <div class="back">
            <a href="/exit">« 返回登录</a>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script>
    function changeImage() {
        var imageSrc = $("#imgObj");
        var src = imageSrc.attr("src");
        imageSrc.attr("src",changeUrl(src));
    }

    function changeUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0,20);
        if((url.indexOf("&") >= 0 )){
            url = url + "*tamp" + timestamp;
        }else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }

    function checkText() {
        var user = $("#user").val();
        var register = $("#register").val();
        if(user === ""){
            alert("账号名不能为空");
            return false;
        }else if(register === ""){
            alert("请输入验证码");
            return false;
        }else {
            $.ajax({
                url:"/regCheck",
                data:{"reg":register},
                type:"POST",
                success:function (data) {
                    if(data === "false"){
                        alert("验证码错误");
                        changeImage();
                    }
                }
            });

        }
        return true;
    }
    function userCheck() {
        var user = $("#user").val();
        $.ajax({
            url:"/userCheck",
            data:{"user":user},
            type:"POST",
            success:function (data) {
                if(data === "false"){
                    $("#span").css("color","red").html("用户不存在");
                }else {
                    $("#span").html("");
                }
            }
        });
    }
</script>
</html>
