<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/21 0021
  Time: 21:22
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

        function havesal(usid){
            $.getJSON("sl/getonebyus.action","usid="+usid,function (res) {
                if(res=="0"){
                    location.href="sl/add.action?usid="+usid;
                }else{
                    alert("已有工资，不能重复生成！");
                    location.href="view/sl/list.jsp";
                }
            })
        }

        function gopage() {
            var page=document.getElementById("page").value;
            show(page);
        }

        function formateTime(time)
        {
            var date = new Date(time);
            Y = date.getFullYear() + '-';
            M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
            D = date.getDate() + ' ';
            h = date.getHours() + ':';
            m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) : date.getMinutes()) + ':';
            s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) : date.getSeconds());
            return Y+M+D+h+m+s;
        }

        function show(page){
            $.post("av/getall.action","page="+page,function (res) {
                $("#avs").html("");
                for (var i=0;i<res.list.length;i++){
                    var av = res.list[i];
                    var tr1=$("<tr></tr>");

                    var td1=$("<td>"+av.av_id+"</td>");
                    tr1.append(td1);
                    var td2=$("<td>"+av.us_id.us_name+"</td>");
                    tr1.append(td2);
                    var td3=$("<td>"+av.av_man.us_name+"</td>");
                    tr1.append(td3);
                    var td4=$("<td>"+av.av_day_score+"</td>");
                    tr1.append(td4);
                    var td5=$("<td>"+av.av_man_score+"</td>");
                    tr1.append(td5);
                    var td6=$("<td>"+formateTime(av.av_ym)+"</td>");
                    tr1.append(td6);
                    var td7=$("<td>"+av.av_sr+"</td>");
                    tr1.append(td7);
                    var td8=$("<td><a onclick='havesal("+av.us_id.us_id+")'>生成工资</a></td>");
                    tr1.append(td8);

                    $("#avs").append(tr1);
                }
                $("#pages").html("");
                $("#pages").append("共"+res.totalNum+"条记录&nbsp;每页"+res.pageSize+"条&nbsp;第"+res.currpage+"页/共"+res.totalPage+"页");
                var a1=$("<a name='1'>首页</a>");
                $("#pages").append(a1);
                if(res.currpage>1){
                    var a2=$("<a name='"+(res.currpage-1)+"'>上一页</a>");
                    $("#pages").append(a2);
                }
                for(var i=1;i<=res.totalPage;i++) {
                    var cla="";
                    if(i==res.currpage) cla="current";
                    $("#pages").append(" <a name='"+i+"' class='"+cla+"'>"+i+"</a>");
                }
                if(res.currpage<res.totalPage){
                    var a3=$("<a name='"+(res.currpage+1)+"'>下一页</a>");
                    $("#pages").append(a3);
                }
                var a4=$("<a name='"+(res.totalPage)+"'>尾页</a>");
                $("#pages").append(a4);
                $("#pages").append("转到&nbsp;<input size='2' id='page'/>&nbsp;页<button  id='gosalpage' onclick='gopage()'>GO</button>");
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
    <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户流失管理&nbsp;&gt;&nbsp;流失信息
        <hr class="hr1" />
    </div>
    <div class="operation_button">

    </div>
    <div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
            <thead>
            <tr>
                <th width="9%">绩效编号</th>
                <th width="9%">员工姓名</th>
                <th width="9%">考核经理</th>
                <th width="9%">考勤分数</th>
                <th width="9%">经理评分</th>
                <th width="9%">时间</th>
                <th width="9%">总分</th>
                <th width="9%">操&nbsp;&nbsp;&nbsp;&nbsp;作</th>
            </tr>
            </thead>
            <tbody id="avs">

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
