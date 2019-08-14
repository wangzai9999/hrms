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
        $(function() {
            $.get("role/getall.action", "", function (res) {
                for (var i = 0; i < res.length; i++) {

                    $("#roid").append("<option value='" + res[i].ro_id + "'>" + res[i].ro_name + "</option>");
                }

            }, "json");

            $.get("pos/getall.action", "", function (res) {
                for (var i = 0; i < res.length; i++) {

                    $("#posid").append("<option value='" + res[i].pos_id + "'>" + res[i].pos_name + "</option>");
                }

            }, "json");

            $.post("dep/getall.action", "", function (res) {
                for (var i = 0; i < res.length; i++) {

                    $("#deoid").append("<option value='" + res[i].de_id + "'>" + res[i].de_name + "</option>");
                }

            }, "json");
        })
        function save(prop,url){
            var us=$("#form_us").serialize();
            $.post("user/add.action",us,function (res) {
                if(res=="1") {
                    alert(prop+'成功！');
                    location.href=url;
                } else {
                    alert(prop+"失败");
                }
            });
        }

    </script>
</head>

<body>
<div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >当前位置：客户服务管理&nbsp;&gt;&nbsp;添加员工
        <hr class="hr1" />
    </div><a href="view/user/list.jsp"><button >列表员工</button></a>
    <div class="operation_button">
        <button title="保存" onclick="save('保存','list.jsp')">保存</button>
    </div>
    <div class="out_bg">
        <form id="form_us" method="post">
        <div class="in_bg" >
            <table border="0" cellpadding="0" cellspacing="0" class="table_input txt" style="text-align: center;">
                <tr style="margin: auto">
                    <td width="126"></td>
                    <td width="126"></td>
                    <td width="126">姓名</td>
                    <td width="411"><input type="text" name="us_name"   /></td>
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
                    <td>
                        <select name="ro_id.ro_id" id="roid">
                            <option>请选择...</option>
                    </select></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>部门</td>
                    <td><select name="us_dep.de_id" id="deoid">
                        <option>请选择...</option>
                    </select></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>职位</td>
                    <td><select name="us_pos.pos_id" id="posid">
                        <option>请选择...</option>
                    </select></td>
                </tr>

            </table>
        </div>
        </form>
    </div>

</body>
</html>
