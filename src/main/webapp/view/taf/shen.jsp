<%--
  Created by IntelliJ IDEA.
  User: 倪浩川
  Date: 2019/8/19
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
    <script type="text/javascript" src="js/javascript.js"></script>
    <script type="text/javascript" src="datepicker/WdatePicker.js"> </script>
</head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    function save(prop,url){
        var us=$("#form_taf").serialize();
        $.post("taf/mod.action",us,function (res) {
            if(res!=null) {
                alert(prop+'成功！');
                location.href=url;
            } else {
                alert(prop+"失败");
            }
        });
    }

</script>
<body>
<div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >当前位置：客户服务管理&nbsp;&gt;&nbsp;添加员工
        <hr class="hr1" />
    <div class="operation_button">
        <button title="保存" onclick="save('保存','view/taf/list.jsp')">保存</button>
    </div>
    <div class="out_bg">
        <form id="form_taf" method="post">
            <div class="in_bg" >
                <table border="0" cellpadding="0" cellspacing="0" class="table_input txt" style="text-align: center;">
                    <input type="hidden" name="tf_id" value="${mv.tf_id}"/>
                    <tr style="margin: auto">
                        <td width="126"></td>
                        <td width="126"></td>
                        <td width="126">申请人</td>
                        <td width="411"><input type="text" value="${mv.tf_us_id.us_name}" disabled="disabled" /></td>
                        <td width="126"></td>
                        <td  width="411"></td>
                    </tr>
                    <tr>
                        <td ></td><td></td>
                        <td>申请项目</td>
                        <td><input type="text"  value="${mv.tf_tr_id.tr_subject}" disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td ></td><td></td>
                        <td>状态</td>
                        <td><input style="width: 20px" type="radio" name="tf_status" value="同意">同意 <input type="radio" name="tf_status" value="拒绝">拒绝</td>
                    </tr>
                    <tr>
                        <td ></td><td></td>
                        <td>申请时间</td>
                        <td><input type="text" value="<fmt:formatDate value="${mv.tf_date}" pattern="yyyy-MM-dd HH:mm:ss" />"  disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td ></td><td></td>
                        <td>审批人</td>
                        <td><input type="text" value="${sessionScope.loger.us_name}"  disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td ></td><td></td>
                        <td>审批意见</td>
                        <td><input type="text" value="${mv.tf_opinion}" name="tf_opinion"  /></td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>
</body>
</html>
