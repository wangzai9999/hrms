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
    <link href="/css/stylesheet.css" rel="stylesheet" type="text/css" />
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/javascript.js"></script>
    <script type="text/javascript" src="/js/jquery-1.12.4.js"/>
    <script type="text/javascript">



    </script>
</head>

<body>
<div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >当前位置：客户服务管理&nbsp;&gt;&nbsp;修改员工
        <hr class="hr1" />
    </div>
    <div class="operation_button">
        <a href="#" title="保存" onclick="save('保存','add.html');">保存</a>
    </div>
    <div class="out_bg">
        <div class="in_bg" >
            <table border="0" cellpadding="0" cellspacing="0" class="table_input txt" style="text-align: center;">
                <tr style="margin: auto">
                    <td width="126"></td>
                    <td width="126"></td>
                    <td width="126">姓名</td>
                    <td width="411"><input type="text" name="us_name"  /></td>
                    <td width="126"></td>
                    <td  width="411"></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>密码</td>
                    <td><input type="text" value="123" disabled="disabled" /></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>角色</td>
                    <td><select name="ro_id">
                        <option>请选择...</option>
                        <option>咨询</option>
                        <option>投诉</option>
                        <option>建议</option>
                    </select></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>部门</td>
                    <td><select name="ro_id">
                        <option>请选择...</option>
                        <option>咨询</option>
                        <option>投诉</option>
                        <option>建议</option>
                    </select></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>职位</td>
                    <td><select name="ro_id">
                        <option>请选择...</option>
                        <option>咨询</option>
                        <option>投诉</option>
                        <option>建议</option>
                    </select></td>
                </tr>

            </table>
        </div>
    </div>

</body>
</html>
