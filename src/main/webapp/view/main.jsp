<%--
  Created by IntelliJ IDEA.
  User: 倪浩川
  Date: 2019/8/18
  Time: 15:46
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
</head>
<frameset rows="110,*" frameborder="0" border="0" framespacing="0">
    <frame style="height: 20px" src="view/top.jsp" scrolling="no" noresize="noresize" marginheight="0" marginwidth="0" >
    <frameset cols="240,7,*" frameborder="0" border="0" framespacing="0" name="myFrame" >
    <frame src="view/left.jsp" scrolling="no" noresize="noresize" marginheight="0" marginwidth="0" />
    <frame src="view/switch.jsp" scrolling="no" noresize="noresize" marginheight="0" marginwidth="0" />
    <frame src="view/right.jsp" noresize="noresize" marginheight="0" marginwidth="0" name="rightFrame" target="_self" />
</frameset>
<frame src="UntitledFrame-3">
</frameset>
<noframes>
    <body>
    </body>
</noframes>

<body>

</body>
</html>
