<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.entity.Userinfo" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
<title>员工绩效展示</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript" src="datepicker/WdatePicker.js"> </script>
<script type="text/javascript">

    var loger="<%=session.getAttribute("depid")%>";

     $.getJSON("user/getallbydid.action","did="+loger,function (res) {

        for (var i=0;i<res.length;i++){
          var user=res[i];
          var newtr=$("<tr></tr>");
          var newtd1=$("<td>"+user.us_id+"</td>");
          newtr.append(newtd1);
          var newtd2=$("<td>"+user.us_name+"</td>");
          newtr.append(newtd2);
          var newtd3=$("<td>"+user.ro_id.ro_name+"</td>");
          newtr.append(newtd3);
          var newtd4=$("<td>"+user.us_pos.pos_name+"</td>");
          newtr.append(newtd4);
          var newtd5=$("<td><a href='wt/getwt.action?usid="+user.us_id+"'>绩效考核</a></td>");
          newtr.append(newtd5);
          $("#deptemp").append(newtr);
        }

     });


</script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：员工绩效服务管理&nbsp;&gt;&nbsp;员工绩效列表
    <hr class="hr1" />
    <a href="view/salary/add.jsp">增加绩效</a>
  </div>


  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="10%">员工编号</th>
          <th width="10%">员工姓名</th>
          <th width="25%">员工角色</th>
          <th width="10%">员工职位</th>
          <th width="10%">操作</th>
        </tr>
      </thead>
      <tbody id="deptemp">

      </tbody>
    </table>
  </div>

</div>
</body>
</html>
