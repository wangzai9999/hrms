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
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function() {
            $.get("pos/getall.action", "", function (res) {
                for (var i = 0; i < res.length; i++) {

                    $("#posi").append("<option value='" + res[i].pos_id + "'>" + res[i].pos_name + "</option>");
                }
            }, "json");

            $.post("dep/getall.action", "", function (res) {
                for (var i = 0; i < res.length; i++) {

                    $("#depi").append("<option value='" + res[i].de_id + "'>" + res[i].de_name + "</option>");
                }
            }, "json");
        })
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
            <form action="en/add.action" method="post">
                <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
                    <tr>
                        <td width="126">计划招聘人数</td>
                        <td width="411"><input type="text" name="en_account" /></td>
                        <td width="126">职位描述</td>
                        <td width="442"><input type="text" name="en_major_describe"/></td>
                    </tr>
                    <tr>
                        <td>创建时间</td>
                        <td><input type="text" name="en_createtime"/></td>
                        <td>截止时间</td>
                        <td><input type="text" name="en_deadline"/></td>
                    </tr>
                    <tr>
                        <td>工作经验</td>
                        <td><input type="text" name="en_experience"/></td>
                        <td>状态</td>
                        <td><input type="text" name="en_status"/></td>
                    </tr>
                    <tr>
                        <td>所属职位</td>
                        <td><select id="posi" name="en_pos.pos_id"></select></td>
                        <td>所属部门</td>
                        <td><select id="depi" name="en_dep.de_id"></select></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="添加"></td>
                        <td></td>
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