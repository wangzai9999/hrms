<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17 0017
  Time: 11:56
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
    <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
    <script type="text/javascript" src="js/javascript.js"></script>
    <script type="text/javascript" src="datepicker/WdatePicker.js"> </script>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">

        $(function () {
            show(1);

            $("body").on("click","#pages a",function(){
                var page = $(this).attr("name");
                show(page);
            })

        })

        function show(page){
            $.post("ach/getall.action","page="+page,function (res) {
                $("#achs").html("");
                for (var i=0;i<res.list.length;i++){
                    var ach = res.list[i];
                    var tr1=$("<tr></tr>");

                    var td1=$("<td>"+ach.ach_id+"</td>");
                    tr1.append(td1);
                    var td2=$("<td>"+ach.ach_resid.re_name+"</td>");
                    tr1.append(td2);
                    var td3=$("<td>"+ach.ach_exam+"</td>");
                    tr1.append(td3);
                    var td4=$("<td>"+ach.ach_interview+"</td>");
                    tr1.append(td4);
                    var td5=$("<td>"+ach.ach_auditor.us_name+"</td>");
                    tr1.append(td5);
                    var td6=$("<td>"+ach.ach_status+"</td>");
                    tr1.append(td6);
                    var td7=$("<td>"+ach.ach_comm+"</td>");
                    tr1.append(td7);
                    var td8=$("<td><a href='ach/getone.action?ach_id="+ach.ach_id+"'>修改<a/>||<a href='ach/del.action?ach_id="+ach.ach_id+"'>删除<a/></td>");
                    tr1.append(td8);

                    $("#achs").append(tr1);
                }
                $("#pages").html("");
                var a1=$("<a name='1'>首页</a>");
                $("#pages").append(a1);
                var a2=$("<a name='"+(res.currpage-1)+"'>上一页</a>");
                $("#pages").append(a2);
                var a3=$("<a name='"+(res.currpage+1)+"'>下一页</a>");
                $("#pages").append(a3);
                var a4=$("<a name='"+(res.totalPage)+"'>尾页</a>");
                $("#pages").append(a4);
            })
        }

    </script>
</head>
<body>
<div id="div1">
    <table>
        <tr>

        </tr>
        <thead id="thead1">

        </thead>
    </table>

</div>
<div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >
        <hr class="hr1" />
    </div>
    <div class="operation_button">

    </div>
    <div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
            <thead>
            <tr>
                <th width="12%">考核编号</th>
                <th width="12%">投简人</th>
                <th width="12%">笔试成绩</th>
                <th width="12%">面试成绩</th>
                <th width="12%">审核人</th>
                <th width="12%">状态</th>
                <th width="12%">审核意见</th>
                <th width="16%">操作</th>
            </tr>
            </thead>
            <tbody id="achs">

            </tbody>
        </table>
    </div>
    <div class="position" id="pages">
        <%--共59条记录&nbsp;每页10条&nbsp;第1页/共5页
        <a href="#" title="首页">&laquo;首页</a><a href="#" title="上一页">&laquo; 上一页</a><a href="#" title="下一页">下一页&raquo;</a><a href="#" title="末页">末页&raquo;</a> 转到&nbsp;
        <input value="1" size="2" />
        &nbsp;页<a href="#">GO</a>
        </li>--%>
    </div>
</div>
</body>
</html>