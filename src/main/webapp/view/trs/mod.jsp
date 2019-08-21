<%--
  Created by IntelliJ IDEA.
  User: 倪浩川
  Date: 2019/8/14
  Time: 10:32
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
    <link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">


    </script>
</head>

<body>
<div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >当前位置：客户服务管理&nbsp;&gt;&nbsp;修改员工
        <hr class="hr1" />
    </div>
    <div class="out_bg">
        <form action="trs/mod.action" method="post">
        <div class="in_bg" >
            <table border="0" cellpadding="0" cellspacing="0" class="table_input txt" style="text-align: center;">
                <input type="hidden" name="ts_id" value="${trs.ts_id}">
                <tr style="margin: auto">
                    <td width="126"></td>
                    <td width="126"></td>
                    <td width="126">姓名</td>
                    <td width="411"><input type="text" value="${trs.ts_usid.us_name}" disabled="disabled" /></td>
                    <td width="126"></td>
                    <td  width="411"></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>培训名</td>
                    <td><input type="text"  value="${trs.ts_trid.tr_subject}"  disabled="disabled"/></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>评论</td>
                    <td><textarea style="height: 150px;width: 200px" name="ts_comm">${trs.ts_comm}</textarea>
                        </td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td colspan="2"><input type="submit" value="提交" /></td></tr>
            </table>
        </div>
        </form>
    </div>

</body>
</html>
