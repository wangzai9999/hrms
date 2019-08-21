<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/19 0019
  Time: 11:06
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
    <link href="/css/stylesheet.css" rel="stylesheet" type="text/css" />
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >
        <hr class="hr1" />
    </div>
    <div class="operation_button">
        <a href="#" title="保存" onclick="save('保存','add.html');">保存</a>
    </div>
    <div class="out_bg">
        <div class="in_bg">
                <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
                    <tr>
                        <td>投简人</td>
                        <td><input type="text" value="${ach.ach_resid.re_name}" disabled="disabled"/></td>
                        <td><input type="hidden" name="ach_resid.re_id" value="${ach.ach_resid.re_id}"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>笔试成绩</td>
                        <td><input type="text" name="ach_exam" value="${ach.ach_exam}"/></td>
                        <td>面试成绩</td>
                        <td><input type="text" name="ach_interview" value="${ach.ach_interview}"/></td>
                    </tr>
                    <tr>
                        <td>状态</td>
                        <td><input type="text" name="ach_status" value="${ach.ach_status}"/></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>审核意见</td>
                        <td><textarea name="ach_comm">${ach.ach_comm}</textarea></td>
                        <td><input type="hidden" name="ach_id" value="${ach.ach_id}"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><a href="view/resume/list.jsp">返回</a></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
        </div>
    </div>
</div>
</body>
</html>
