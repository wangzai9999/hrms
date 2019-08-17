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

        function save(prop,url){
            var tra=$("#form_tra").serialize();
            $.post("tra/add.action",tra,function (res) {
                if(res!=null) {
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
    </div><a href="view/tra/list.jsp"><button >列表员工</button></a>
    <div class="operation_button">
        <button title="保存" onclick="save('保存','view/tra/list.jsp')">保存</button>
    </div>
    <div class="out_bg">
        <form id="form_tra" method="post">
        <div class="in_bg" >
            <table border="0" cellpadding="0" cellspacing="0" class="table_input txt" style="text-align: center;">
                <tr style="margin: auto">
                    <td width="126"></td>
                    <td width="126"></td>
                    <td>培训人</td>
                    <td><input type="text"  name="tr_man"/></td>
                    <td width="126"></td>
                    <td  width="411"></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>培训项目</td>
                    <td><input type="text"  name="tr_subject" /></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>培训开始时间</td>
                    <td><input type="text"  name="tr_starttime" /></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>培训结束时间</td>
                    <td><input type="text"name="tr_endtime" /></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>培训人数</td>
                    <td><input type="text"  name="tr_num" /></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>备注</td>
                    <td><textarea rows="6" cols="72" name="tr_remark" ></textarea></td>
                </tr>
            </table>
        </div>
        </form>
    </div>
</div>
</body>
</html>
