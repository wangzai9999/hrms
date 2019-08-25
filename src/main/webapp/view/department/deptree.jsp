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
    var selectednode;
    $(function () {
      // 右键点击节点并显示快捷菜单
      $('#deptree').tree({
        onContextMenu: function(e, node){
          e.preventDefault();
          // 查找节点
          selectednode=node;

          $('#deptree').tree('select', node.target);
          // 显示快捷菜单
          $('#depmenu').menu('show', {
            left: e.pageX,
            top: e.pageY
          });
        }
      });
    });

   function adddept() {
     if (${depid!=2}){
       alert("你没有权限操作！请向上级获取权限后再进行操作！");
       return false;
     }else {

     $("#addwin").window("open");
       $.post("user/getnotm.action","",function (ulist) {

         for (var i=0;i<ulist.length;i++){
           $("#depman").append("<option value='"+ulist[i].us_id+"'>"+ulist[i].us_name+"</option>");
         }
       },"json")
   }
   }
   function moddept() {
     if (${depid!=2}){
       alert("你没有权限操作！请向上级获取权限后再进行操作！");
       return false;
     }else {
     $("#modwin").window("open");
     var deid=selectednode.id;
     $.getJSON("dep/getbyid.action?did="+deid,"",function (dept) {
       $("#deptname").val(dept.de_name);
       $("#duname").val(dept.de_man.us_name);
       $("#deid").val(dept.de_id);
     });
     $.post("user/getnotm.action","",function (ulist) {
       for (var i=0;i<ulist.length;i++){
         $("#userlist").append("<option value='"+ulist[i].us_id+"'>"+ulist[i].us_name+"</option>");
       }
     },"json")
   }
   }


   function adddepoption() {

    var usid= $("#depman").val();
     if(usid!=0){
       var dept=$("#adddep").serialize();
       $.get("dep/add.action",dept,function (res) {
         if (res=='1'){
           $("#addwin").window("close");
           $("#deptree").reload();
         }
       },"json");
     }else {
       alert("请重新添加部门！部门经理不能为空！");
     }

   }

   function moddepoption() {
     var mform=$("#moddep").serialize();
     $.post("dep/mod.action",mform,function (res) {
       if(res=='1'){
         alert("修改成功！");
         $("#deptree").reload();
       }
     },"json");
   }

   function remove() {
     if (${depid!=2}){
       alert("你没有权限操作！请向上级获取权限后再进行操作！");
       return false;
     }else {
       alert("该部门下有员工等其它信息！如要删除请先清除员工等信息！");
     }
   }

  </script>
</head>

<body>
<div style="width: 6%">
<ul id="deptree" class="easyui-tree" data-options="url:'dep/getall.action',dnd:true">

</ul>
</div>

<div id="depmenu" class="easyui-menu" style="width:120px;">

  <div onclick="adddept()" data-options="iconCls:'icon-add'">增加部门</div>
  <div onclick="moddept()" data-options="iconCls:'icon-edit'">修改部门</div>
  <div onclick="remove()" data-options="iconCls:'icon-remove'">移除</div>
</div>

<div id="addwin" class="easyui-window" style="width: 500px ;height: 400px" data-options="title:'增加部门',closed:true,modal:true">
  <form id="adddep" method="post">
    <input type="text" name="de_name"><br>
    <select name="de_man.us_id" id="depman">
      <option value="0">--请选择部门经理--</option>
    </select>

     <button onclick="adddepoption()">增加</button>
  </form>
</div>

<div id="modwin" class="easyui-window" style="width: 500px ;height: 400px" data-options="title:'修改部门',closed:true,modal:true">
  <form id="moddep" method="post">
    <input type="hidden" name="de_id" value="" id="deid">
    <input type="text" name="de_name" value="" id="deptname"><br>
    原部门经理<input type="text" id="duname" disabled value="" ><br>
    请输入员工的姓名：<input name="de_man.us_id"  list="userlist">
    <datalist id="userlist">

    </datalist>

    <button onclick="moddepoption()">修改</button>
  </form>
</div>

</body>
</html>
