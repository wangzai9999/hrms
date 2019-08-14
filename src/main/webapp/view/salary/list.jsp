<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>薪酬标准展示</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript" src="datepicker/WdatePicker.js"> </script>

</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：人力资源服务管理&nbsp;&gt;&nbsp;薪酬标准列表
    <hr class="hr1" />
    <a href="view/salary/add.jsp">增加薪酬标准</a>
  </div>


  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="10%">薪酬标准编号</th>
          <th width="10%">薪酬标准名称</th>
          <th width="25%">薪酬标准总金额</th>
          <th width="10%">薪酬标准的职位</th>
          <th width="10%">创建人</th>
          <th width="15%">创建日期</th>
          <th width="10%">操作</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${pb.list}" var="sd">
        <tr>
          <td>${sd.sa_id}</td>
          <td><a href="#">${sd.sa_name}</a></td>
          <td>${sd.sa_totalmoney}</td>
          <td>${sd.sa_pos.pos_name}</td>
          <td>${sd.sa_cre_id.us_id}</td>
          <td><fmt:formatDate value="${sd.sa_date}" pattern="yyyy-MM-dd HH:mm" /></td>
          <td><a href="salt/delst.action?delsaid=${sd.sa_id}">删除</a>|<a href="salt/getonest.action?gsid=${sd.sa_id}">修改</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <div class="position"> 
  	共${pb.totalNum}条记录&nbsp;每页${pb.pageSize}条&nbsp;第${pb.currpage}页/共${pb.totalPage}页
    <a href="salt/getall.action?page=1" title="首页">&laquo;首页</a>
    <a href="salt/getall.action?page=${pb.currpage-1}" title="上一页">&laquo; 上一页</a>
    <c:forEach begin="1" var="pa" end="${pb.totalPage}">
      <c:if test="${pb.currpage ==pa}">
        <a href="salt/getall.action?page=${pa}" class="number current" title="${pa}">${pa}</a>
      </c:if>

    </c:forEach>
    <a href="salt/getall.action?page=${pb.currpage+1}" title="下一页">下一页&raquo;</a><a href="#" title="末页">末页&raquo;</a> 转到&nbsp;
    <input value="1" size="2" />
    &nbsp;页<a href="#">GO</a>
    </li>
  </div>
</div>
</body>
</html>
