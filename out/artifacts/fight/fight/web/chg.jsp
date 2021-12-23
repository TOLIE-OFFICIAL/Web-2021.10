<%--
  Created by IntelliJ IDEA.
  User: 23773
  Date: 2021/11/10
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/chg,.css"/>
    <link rel="stylesheet" href="css/iconfont.css"/>
    <script src="js/chg.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="http://ip.ws.1 26.net/ipquery"></script>
    <script type="text/javascript">
        dynamicIp(秦皇岛);//这是获取天气调用的方法 lc就是城市名称
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改信息</title>
</head>
<body>
${inf}

<input type="checkbox" style="display: none;" id="change">


<div class="turn">
    <div class="over">
        <form method="post" action="login.chg" class="chg" id="chg">
            <h1>修改信息</h1>
            <input type="password" placeholder="旧用户名" id="oldname" name="oldname">
            <input type="text" placeholder="新用户名" id="username2" name="username2" >
            <input type="password" placeholder="新密码" id="password2" name="password2">

            <input type="button" value="修 改" class=btn id="chg" onclick="Chg()">
        </form>

    </div>
</div>
<div id="weather">
    <iframe width="500" height="40" frameborder="0" scrolling="no" hspace="0"
            src="https://i.tianqi.com/?c=code&a=getcode&id=40&icon=1"></iframe>
</div>
<body>
</html>
