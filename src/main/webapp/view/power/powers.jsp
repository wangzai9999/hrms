<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html lang="en">
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.5/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.5/themes/default/easyui.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var aaa;
	$(function() {
	    $('#treeshow').tree({
			onContextMenu : function(e, node) {
				e.preventDefault();
				// 查找节点
				alert("aaa");
				aaa = node;
				$('#treeshow').tree('select', node.target);
				// 显示快捷菜单
				$('#menu1').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			},
			/***********拖拽   改变其父类****************/
			            /*****目标   源点    拖拽方式*/
			onDrop : function(aaa, bbb, append) {
				var aId = $('#treeshow').tree('getNode', aaa).id;
				$.post("powers/modPar.action", "praid=" + aId + "&id=" + bbb.id, function(res) {
					if (res == "1") {
						alert('ok');
					}
				});
			}
		});

		/*****增加按钮******/
		$("#addbut").click(function() {
			var pa = $("#from1").serialize();
			$.post("powers/add.action", pa, function(res) {
				if (res == '1') {
					alert('ok');
					$("#addwin").window("close");
					$("#treeshow").tree("reload");
				}
			});
		})

		/*****修改按钮******/
		$("#modbut").click(function() {
			var pa = $("#from2").serialize();
			$.post("powers/mod.action", pa, function(res) {
				if (res == '1') {
					alert('ok');
					$("#modwin").window("close");
					$("#treeshow").tree("reload");
				}
			});
		})
		/*****删除按钮******/
		$("#delbut").click(function() {
			var did = $("#from3").serialize();
			$.post("powers/del.action", did, function(res) {
				if (res == '1') {
					alert('ok');
					$("#delwin").window("close");
					$("#treeshow").tree("reload");
				}
			});
		})
		
		$("#getAll").click(function() {
		       var nodes = $('#treeshow').tree('getChecked', ['checked','indeterminate']);
                var s = '';
                for (var i = 1; i < nodes.length; i++) {
                    s +=nodes[0].id;
                    if (s != '') 
                        s += ',';
                    s += nodes[i].id;
                }
                alert(s);
                var name = $("#addname").serialize();
                $.post("role/add.action","s="+s+"&name="+name, function(res) {
              
				if (res == '1') {
					alert('ok');
				}
			    },"json");
		})
	})

	function add() {
	    
		$("#pname").val(aaa.text);
		$("#praid").val(aaa.id);
		$("#addwin").window("open"); // 打开一个 window窗口    
	}

	function mod() {
		$("#name").val(aaa.text);
		$("#id").val(aaa.id);
		$("#modwin").window("open");
	}
	
	function del() {
	    
	    $("#dname").val(aaa.text);
	    $("#did").val(aaa.id);
	    $("#delwin").window("open");
	}
</script>
</head>
<body>

	<ul id="treeshow" class="easyui-tree"
		data-options="url:'powers/list.action',dnd:true,checkbox:true,state:'closed'"></ul>

	<div id="menu1" class="easyui-menu">
		<div data-options="iconCls:'icon-add'" onclick="add()">添加</div>
		<div data-options="iconCls:'icon-remove'" onclick="del()">删除</div>
		<div data-options="iconCls:'icon-edit'" onclick="mod()">修改</div>
	</div>


	<div id="addwin" class="easyui-window" title="添加权限"
		style="width:400px;height:200px" data-options="closed:true,modal:true">
		<form id="from1">
			<input type="hidden" name="po_fa.id" id="praid" /> <br> 当前权限名:<input
				type="text" id="pname" disabled="disabled" /> <br> 添加权限名:<input
				type="text" name="text">
			<br> 添加权限路径:<input
				type="text" name="po_url"><br> <input type="button"
				id="addbut" value="save">
		</form>
	</div>


	<div id="modwin" class="easyui-window" title="修改"
		style="width:400px;height:200px" data-options="closed:true,modal:true">
		<form id="from2">
			<input type="hidden" name="id" id="id" /> <br> 修改权限名:<input
				type="text" name="name" id="name"> <br> <input
				type="button" id="modbut" value="save" />
		</form>
	</div>

	<div id="delwin" class="easyui-window" title="删除"
		style="width:400px;height:200px" data-options="closed:true,modal:true">
		<form id="from3">
			<input type="hidden" name="did" id="did" /> <br> 要删除权限名:<input
				type="text" id="dname" disabled="disabled"> <br> <input
				type="button" id="delbut" value="save" />
		</form>
	</div>

	<div>

		添加的角色名<input type="text" name="name" id="addname"><br> <input
			type="button" id="getAll" value="提交">
	</div>
</body>
</html>
