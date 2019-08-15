<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>增加薪酬标准</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  <script type="text/javascript">

    $(function () {
      $.post("pos/getall.action","",function (res) {
        for (var i=0;i<res.length;i++){
          var pos=res[i];
          $("#posname").append("<option value='"+pos.pos_id+"'>"+pos.pos_name+"</option>");
        }

      },"json");
    })
  </script>
</head>

<body>
<!--表单基本信息-->
<div style="padding:5px;">
  <div class="out_bg">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <td width="105">总金额</td>
          <td width="200"><input type="text" value="${sessionScope.totalmoney}" disabled="disabled" /></td>
              
          <td width="200" colspan="2">创建人&nbsp;&nbsp;&nbsp;<input type="text" value="${sessionScope.loger.us_name}" disabled="disabled" /></td>
        </tr>
        <tr>
          <td>创建时间</td>
          <td><input type="text" value="2013-12-12" disabled="disabled" /></td>
          
          <td>状态&nbsp;&nbsp;&nbsp;新创建</td>
        </tr>
      </table>
    </div>
  </div>
</div>
<!--标准明细表单-->

<div style="padding:5px;">
  <div class="out_bg">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <c:forEach items="${sessionScope.ssdlist}" var="sd" varStatus="status" >
        <tr>
          <td width="100">明细名称</td>
          <td width="200"><input type="text" value="${sd.si_name}" disabled="disabled" /></td>
          <td width="100">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;明细金额</td>
          <td width="200"><input type="text" value="${sd.si_money}" disabled="disabled" /> <a href="salt/delsd.action?index=${status.index}">删除</a></td>
        </tr>
        </c:forEach>
        <form action="salt/addsd.action" method="post">
        <tr>  
          <td>明细类型</td>
          <td><select name="si_name">
				<option value="基本工资">基本工资</option>
				<option value="交通补助">交通补助</option>
				<option value="住房补助">住房补助</option>
				<option value="餐饮补助">餐饮补助</option>
			</select></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金额</td>
          <td><input type="text" name="si_money"/>&nbsp;&nbsp;&nbsp;<input type="submit" value="增加"></td>
        </tr>
        </form>
      </table>
    </div>
  </div>
</div>

<form action="salt/addst.action" method="post">
<!--标准表单-->
<div style="padding:5px;">
  <div class="out_bg">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <td width="100">薪酬标准名称</td>
          <td width="200"><input type="text" name="sa_name"/></td>
        </tr>
        <tr>
          <td width="100">薪酬标准所属职位</td>
          <td width="200">
            <select name="sa_pos.pos_id" id="posname">
            </select>
          </td>
        </tr>
        <tr>
          <td valign="top">薪酬标准备注</td>
          <td><textarea rows="6" cols="36" name="sa_remark" ></textarea></td>
          <td><input type="submit" value="增加"></td>
          <td></td>
        </tr>
      </table>
    </div>
  </div>
</div>
</form>
</body>
</html>
