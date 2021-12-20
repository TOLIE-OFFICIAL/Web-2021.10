<%@ page import="users.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.Dao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head lang="en">
    <meta charset="utf-8">
    <title>管理页面</title>
    <script src="js/adsearch.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.1/owl.carousel.min.js"></script>
    <link rel="stylesheet" href="css/adex.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700i" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.1/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="https://themes.audemedia.com/html/goodgrowth/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.css">

</head>

<body>

<div class="container">
    <br><br><br><br><br><br>
    <center><h1><b>欢迎您，Admin!</b></h1></center>
    <br><br><br>

    <table class="list">
        <caption>用户信息</caption>
        <tr>
            <td class="td1">id</td>
            <td class="td1">用户</td>
            <td class="td1">密码</td>
        </tr>


        <%
            Dao userDao = new Dao();

            List<Users> lst = userDao.getAllUsers();
            for (Users users : lst) {
                out.println("<tr><td class=\"td2\" >" + users.getId() + "</td><td class=\"td2\" >" + users.getName() + "</td><td class=\"td2\">" + users.getPassword() + "</td></tr>");
            }
        %>

    </table>

</body>
</html>