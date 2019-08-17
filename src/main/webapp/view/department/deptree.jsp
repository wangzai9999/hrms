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

  <title>部门职位树</title>
  <link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
  <link href="css/style.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/themes/icon.css">
  <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/themes/default/easyui.css">
  <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript">
    $(function () {
      // 右键点击节点并显示快捷菜单
      $('#deptree').tree({
        onContextMenu: function(e, node){
          e.preventDefault();
          // 查找节点
          $('#deptree').tree('select', node.target);
          // 显示快捷菜单
          $('#depmenu').menu('show', {
            left: e.pageX,
            top: e.pageY
          });
        }
      });
    })
    function append() {
      
    }


  </script>
</head>

<body>
<div style="width: 10%">
<ul id="deptree" class="easyui-tree" data-options="url:'dep/getall.action',dnd:true,lines:true">

</ul>
</div>

<div id="depmenu" class="easyui-menu" style="width:120px;">
  <div onclick="append()" data-options="iconCls:'icon-add'">增加</div>
  <div onclick="remove()" data-options="iconCls:'icon-remove'">删除</div>
  <div onclick="editnode()" data-options="iconCls:'icon-edit'">修改</div>
</div>

</body>
</html>
