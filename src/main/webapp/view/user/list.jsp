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
</head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function(){
        list(1);
    })
    function list(page) {
        $.post("user/list.action","",function (res) {
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
                var td6=$("<td><a href='user/get.action?id="+us[i].us_id+"'></a>|<a href='user/del.action?id="+us[i].us_id+"'></a></td>");
                tr.append(td6);
                $("#thead1").append(tr);
            }

        },"json")

    }
</script>
<body>
     <div id="div1">
         <table>
             <tr>
                 <td>员工编号</td>
                 <td>员工名</td>
                 <td>角色</td>
                 <td>部门</td>
                 <td>职位</td>
                 <td>操作</td>
             </tr>
             <thead id="thead1">

             </thead>
         </table>

     </div>
</body>
</html>
