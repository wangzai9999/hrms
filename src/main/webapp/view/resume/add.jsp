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
            <form action="resume/add.action" method="post" enctype="multipart/form-data">
                <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
                    <tr>
                        <td>招聘人数</td>
                        <td ><input type="text" name="re_name" value="${en.en_account}" disabled="disabled"/></td>
                        <td >职位描述</td>
                        <td><input type="text" name="re_position" value="${en.en_major_describe}" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>工作经验</td>
                        <td><input type="text" name="re_name" value="${en.en_experience}" disabled="disabled"/></td>
                        <td>截止日期</td>
                        <td><input type="text" name="re_position" value="<fmt:formatDate value='${en.en_deadline}'/>" disabled="disabled"/></td>
                    </tr>
                    <tr>
                        <td>投简人</td>
                        <td><input type="text" name="re_name"/></td>
                        <td>应聘职位</td>
                        <td><input type="text" name="re_position"/></td>
                    </tr>
                    <tr>
                        <td>上传简历</td>
                        <td><input type="file" name="file"/></td>
                        <td><input type="hidden" name="re_enid.en_id" value="${en.en_id}" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td ></td>
                        <td><input type="submit" value="投简"></td>
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
