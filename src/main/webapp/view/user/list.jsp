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

        $("body").on("click","#papa a",function(){
            var pp=$(this).attr("name");
            list(pp);
        })
    })
    function query() {
        list(1);
    }
    function gopage() {
        var page=document.getElementById("page").value;
        list(page);
    }
    
    function list(page) {
        var param=$("#form_us").serialize()+"&page="+page;
        $.post("user/getall.action",param,function (res) {
            var us=res.list;
            $("#us").html("");
            for(var i=0;i<us.length;i++){
                var  tr=$("<tr></tr>");
                var td1=$("<td>"+us[i].us_id+"</td>");
                tr.append(td1);
                var td2=$("<td><a href='arc/getOne.action?id="+us[i].us_id+"'>"+us[i].us_name+"</a></td>");
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
         <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户流失管理&nbsp;&gt;&nbsp;流失信息
             <hr class="hr1" />
         </div>
         <a href="view/user/add.jsp">添加</a>
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
             <div class="position" id="papa">
                 共${pb.totalNum}条记录&nbsp;每页${pb.pageSize}条&nbsp;第${pb.currpage}页/共${pb.totalPage}页
                 <a name='1' title='首页'>&laquo;首页</a>
                 <a name='"+(res.currpage-1)+"' title="上一页">&laquo; 上一页</a>
                 <c:forEach begin='1' var='pa' end='"+res.totalPage+"'>
                     <a href="salt/getall.action?page=${pa}" class="number ${pb.currpage == pa?'current':''}" title="${pa}">${pa}</a>
                 </c:forEach>
                 <a name='"+(res.currpage+1)"' title='下一页'>下一页&raquo;</a>
                 <a name='"+res.totalPage+"' title="末页">末页&raquo;</a>
                 转到&nbsp;<input name="ppp" size="2" id="page"/>&nbsp;页
                 <button name="跳转页面按钮" id="gosalpage" onclick="gopage()">GO</button>
             </div>
     </div>
</body>
</html>
