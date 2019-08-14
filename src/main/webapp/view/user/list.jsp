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
    <link href="/css/stylesheet.css" rel="stylesheet" type="text/css" />
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="/js/simpla.jquery.configuration.js"></script>
    <script type="text/javascript" src="/js/javascript.js"></script>
    <script type="text/javascript" src="/datepicker/WdatePicker.js"> </script>
</head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function(){
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
        list(1);
    })
    function query() {
        list(1);
    }
    
    function list(page) {
        var us=$("#form_us").serialize();
        $.post("user/getall.action",us,function (res) {
            var us=res.list;
            $("#thead1").html("");
            for(var i=0;i<us.length;i++){
                var  tr=$("<tr></tr>");
                var td1=$("<td>"+us[i].us_id+"</td>");
                tr.append(td1);
                var td2=$("<td>"+us[i].us_name+"</td>");
                tr.append(td2);
                var td3=$("<td>"+us[i].ro_id.ro_name+"</td>");
                tr.append(td3);
                var td4=$("<td>"+us[i].us_dep.de_name+"</td>");
                tr.append(td4);
                var td5=$("<td>"+us[i].us_pos.pos_name+"</td>");
                tr.append(td5);
                var td6=$("<td><a href='user/get.action?id="+us[i].us_id+"'>修改</a>|<a href='user/del.action?id="+us[i].us_id+"'>删除</a></td>");
                tr.append(td6);
                $("#us").append(tr);
            }

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
         <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户流失管理&nbsp;&gt;&nbsp;流失信息
             <hr class="hr1" />
         </div><a href="view/user/add.jsp"><button >添加员工</button></a>
         <div class="operation_button">
             <button value="查询" onclick="query()">查询</button>
         </div>
         <div class="search_input">
             <form id="form_us">
             <ul class="txt">
                 <li>员工名称：
                     <input type="text" size="30" name="name"/>
                 </li>
                 <li>角色：
                     <select name="ro_id" id="roid">
                         <option value="0">请选择...</option>
                     </select>
                 </li>
                 <li>部门：
                     <select name="de_id" id="deoid">
                         <option value="0">请选择...</option>
                     </select>
                 </li>
                 <li>职位：
                     <select name="pos_id" id="posid">
                         <option value="0">请选择...</option>
                     </select>
                 </li>
             </ul>
             </form>
         </div>
         <div>
             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
                 <thead>
                 <tr>
                     <th width="15%">员工编号</th>
                     <th width="10%">员工名</th>
                     <th width="15%">角色</th>
                     <th width="20%">部门</th>
                     <th width="20%">职位</th>
                     <th width="20%">操作</th>
                 </tr>
                 </thead>
                 <tbody id="us">

                 </tbody>
             </table>
         </div>
         <div class="position">
             共59条记录&nbsp;每页10条&nbsp;第1页/共5页
             <a href="#" title="首页">&laquo;首页</a><a href="#" title="上一页">&laquo; 上一页</a> <a href="#" class="number current" title="1">1</a> <a href="#" class="number" title="2">2</a> <a href="#" class="number" title="3">3</a> <a href="#" class="number" title="4">4</a> <a href="#" title="下一页">下一页&raquo;</a><a href="#" title="末页">末页&raquo;</a> 转到&nbsp;
             <input value="1" size="2" />
             &nbsp;页<a href="#">GO</a>
             </li>
         </div>
     </div>
</body>
</html>
