<%--
  Created by IntelliJ IDEA.
  User: 倪浩川
  Date: 2019/8/13
  Time: 20:03
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
    <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
    <script type="text/javascript" src="js/javascript.js"></script>
    <script type="text/javascript" src="datepicker/WdatePicker.js"> </script>
</head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function(){
        list(1);

        $("body").on("click","#papa a",function(){
            var pp=$(this).attr("name");
            list(pp);
        });
        $.post("tra/all.action", "", function (res) {
            for (var i = 0; i < res.length; i++) {
                $("#trid1").append("<option value='" + res[i].tr_id + "'>" + res[i].tr_subject + "</option>");
            }
        }, "json");
    })
    function query() {
        list(1);
    }
    function gopage() {
        var page=document.getElementById("page").value;
        list(page);
    }
    function formateTime(time)
    {
        var date = new Date(time);
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate() + ' ';
//        h = date.getHours() + ':';
//        m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) : date.getMinutes()) + ':';
//        s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) : date.getSeconds());
        return Y+M+D;
    }
    
    function list(page) {
        var param=$("#form_taf").serialize()+"&page="+page;
        $.post("taf/getAll.action",param,function (res) {
            var taf=res.list;
            var tdiv=res.div;
            $("#us").html("");
            for(var i=0;i<taf.length;i++){
                var  tr=$("<tr></tr>");
                var td1=$("<td>"+taf[i].tf_us_id.us_name+"</td>");
                tr.append(td1);
                var td2=$("<td>"+taf[i].tf_tr_id.tr_subject+"</td>");
                tr.append(td2);
                var td3=$("<td>"+taf[i].tf_status+"</td>");
                tr.append(td3);
                var td4=$("<td>"+formateTime(taf[i].tf_date)+"</td>");
                tr.append(td4);
                var td5=$("<td>"+taf[i].tf_auditor+"</td>");
                tr.append(td5);
                var td6=$("<td>"+taf[i].tf_opinion+"</td>");
                tr.append(td6);
                var shen ="<a href='taf/shen.action?id="+taf[i].tf_id+"'>审批</a>|";
                if (taf[i].tf_status!="申请中") {shen="";}
                var td7=$("<td>"+shen+"<a href='taf/del.action?id="+taf[i].tf_tr_id.tr_id+"'>删除</a></td>");
                tr.append(td7);
                $("#us").append(tr);
            }
            $("#papa").html("");

            $("#papa").append("共"+res.totalNum+"条记录&nbsp;每页"+res.pageSize+"条&nbsp;第"+res.currpage+"页/共"+res.totalPage+"页");
            $("#papa").append("<a name='1' title='首页'>&laquo;首页</a><a name='"+(res.currpage-1)+"' title='上一页'>&laquo; 上一页</a>")
            for(var i=1;i<=res.totalPage;i++) {
                var cla="";
                if(i==res.currpage) cla="current";
                $("#papa").append(" <a name='"+i+"' class='"+cla+"'>"+i+"</a>");
            }
            $("#papa").append(" <a name='"+(res.currpage+1)+"' title='下一页'>下一页&raquo;</a> <a name='"+res.totalPage+"' title='末页'>末页&raquo;</a> ");
            $("#papa").append("转到&nbsp;<input size='2' id='page'/>&nbsp;页<button  id='gosalpage' onclick='gopage()'>GO</button>");

        },"json")

    }
</script>
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
         <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户流失管理&nbsp;&gt;&nbsp;培训信息
             <hr class="hr1" />
         </div>
         <a>申请</a>
         <div class="operation_button">
             <button value="查询" onclick="query()">查询</button>
         </div>
         <div class="search_input">
             <form id="form_taf">
             <ul class="txt">
                 <li>培训项目：
                     <select name="tr_id" id="trid1">
                         <option value="0">请选择...</option>
                     </select>
                 </li>
                 <li>状态：
                     <select name="tr_status" >
                         <option value="">请选择...</option>
                         <option value="申请中">申请中</option>
                         <option value="拒绝">拒绝</option>
                         <option value="同意">同意</option>
                     </select>
                 </li>
             </ul>
             </form>
         </div>
         <div>
             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
                 <thead>
                 <tr>
                     <th width="10%">申请人</th>
                     <th width="15%">申请项目</th>
                     <th width="15%">申请状态</th>
                     <th width="15%">申请时间</th>
                     <th width="15%">审批人</th>
                     <th width="15%">审批意见</th>
                     <th width="15%">操作</th>
                 </tr>
                 </thead>
                 <tbody id="us">

                 </tbody>
             </table>
         </div>
             <div class="position" id="papa">

             </div>
     </div>
</body>
</html>
