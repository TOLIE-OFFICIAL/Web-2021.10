<%--
  Created by IntelliJ IDEA.
  User: 23773
  Date: 2021/11/10
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/style-login-1.css"/>
    <link rel="stylesheet" href="css/iconfont.css"/>
    <script src="js/login.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="http://ip.ws.1 26.net/ipquery"></script>
    <script type="text/javascript">
        dynamicIp(秦皇岛);//这是获取天气调用的方法 lc就是城市名称
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录界面</title>
</head>
<body>

<!-- 旋转开关 -->
<div id="switch"><h3>没有/已有账号？</h3></div>
<input type="checkbox" style="display: none;" id="change">
<label for="change">切 换</label>
${inf}
<div class="turn">
    <div class="over">

        <form method="post" action="login.do" class="login" id="lg">
            <h1>欢迎回来</h1>
            <input type="text" placeholder="用户名" id="username1" value="${name}" name="username1" autocomplete="off">
            <input type="password" placeholder="密码" id="password1" name="password1">
            <input type="button" value="登 录" class="btn" id="login" onclick="Log()">
            <input type="button" value="修改注册信息" class="btn" id="update" onclick="window.location.href='chg.jsp'">
        </form>

        <form method="post" action="res.action" class="sign" id="sg">
            <h1>加入我们</h1>
            <input type="text" placeholder="用户名" id="username2" name="username2">
            <input type="password" placeholder="密码" id="password2" name="password2">
            <input type="password" placeholder="确认密码" id="repassword2">
            <input type="button" value="注 册" class="btn" id="reg" onclick="Reg()">
        </form>
    </div>
</div>
<div id="weather">
    <iframe width="500" height="40" frameborder="0" scrolling="no" hspace="0"
            src="https://i.tianqi.com/?c=code&a=getcode&id=40&icon=1"></iframe>
</div>
<body>
</html>
