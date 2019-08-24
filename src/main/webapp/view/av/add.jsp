<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17 0017
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >当前位置：客户服务管理&nbsp;&gt;&nbsp;服务创建
        <hr class="hr1" />
    </div>
    <div class="operation_button">
        <a href="#" title="保存" onclick="save('保存','add.html');">保存</a>
    </div>
    <div class="out_bg">
        <div class="in_bg">
            <form action="av/add.action" method="post">
                <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
                    <tr>
                        <td>员工姓名</td>
                        <td ><input type="text" value="${us.us_name}" disabled="disabled"/></td>
                        <td >经理</td>
                        <td><input type="text" value="${loger.us_name}" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>迟到天数</td>
                        <td><input type="text" value="${cd}" disabled="disabled"/></td>
                        <td>早退天数</td>
                        <td><input type="text" value="${zt}" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>考勤天数</td>
                        <td><input type="text" name="av_day_score" value="${ts}" readonly/></td>
                        <td>经理评分</td>
                        <td><input type="text" name="av_man_score"/></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="us_id.us_id" value="${us.us_id}"></td>
                        <td><input type="submit" value="确定"></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
