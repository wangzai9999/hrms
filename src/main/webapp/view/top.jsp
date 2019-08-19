<%--
  Created by IntelliJ IDEA.
  User: 倪浩川
  Date: 2019/8/18
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <title>导航</title>
    <link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/sidebar.css" type="text/css"  />
</head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
function signin() {
        $.post("wt/add.action","",function (res) {
        alert(res);
    },"json");
}
function signout() {
    $.post("wt/mod.action","",function (res) {
        alert(res);
    },"json");
}
</script>
<body>
<div>

    <div class="navigation">
        <ul class="shortcut_buttons_set">
            <li>
                <div class="current_user attention">
                    <div> 欢迎您，<strong>${requestScope.loger.us_name}</strong><br />
                        [系统管理员，<a href="view/login.jsp">退出</a>] </div>
                </div>
            </li>
            <li><a class="shortcut_button" href="view/main.jsp"><span> <img src="images/home.ico" alt="icon" /><br />
      首页 </span></a></li>
            <li><a class="shortcut_button" href="#"><span> <img src="images/calendar.ico" alt="icon" /><br />
      日程 </span></a></li>
            <li><a class="shortcut_button" href="#"><span> <img src="images/clipboard.ico" alt="icon" /><br />
      公告栏 </span></a></li>
            <li><a class="shortcut_button" href="#"><span> <img src="images/write.png" alt="icon" /><br />
      写消息 </span></a></li>
            <li><a class="shortcut_button" href="#"><span> <img src="images/bubble.ico" alt="icon" /><br />
      我的消息 </span></a></li>
            <li><a class="shortcut_button" href="#"><span> <img src="images/trash.ico" alt="icon" /><br />
      回收站 </span></a></li>
            <li><a class="shortcut_button" onclick="signin()"><span> <img src="images/signin.jpg" alt="icon" /><br />
      签到 </span></a></li>
            <li><a class="shortcut_button"  onclick="signout()"><span> <img src="images/signout.jpg" alt="icon" /><br />
      签退 </span></a></li>
        </ul>
        <!-- end shortcut_buttons_set -->
    </div>
</div>
</body>
</html>
