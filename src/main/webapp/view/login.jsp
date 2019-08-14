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

<title>My JSP 'hello.jsp' starting page</title>

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="css/style2.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

</head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})

		$("#nameinput").val($.cookie("logname"));
		$("#pwdinput").val($.cookie("logpwd"));
		
		

	});
</script>



<body
	style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>

	<%-- 	<%
  String name="";
  String password="";
   Cookie[] ck=request.getCookies();
   for(Cookie cookie:ck){
     if(cookie.getName().equals("logname"))
     {
        name=cookie.getValue();
     }
     if(cookie.getName().equals("logpassword"))
     {
        password=cookie.getValue();
     }
     
   }
 %> --%>


	<div class="logintop">
		<span>欢迎登录后台管理界面平台</span>
		<ul>
			<li><a href="#">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>

	<div class="loginbody">

		<span class="systemlogo"></span>

		<div class="loginbox">
			<form action="user/login.action" method="post">
				<ul>
					<li><input name="name" type="text" class="loginuser"
						value="admin" onclick="JavaScript:this.value=''" /></li>
					<li><input name="password" type="text" class="loginpwd"
						value="密码" onclick="JavaScript:this.value=''" /></li>
					<li><input type="submit" class="loginbtn" value="登录" /> <label><input
							id="checkkeep" name="checkkeep" type="checkbox" value="1" />记住用户名和密码</label><label><input
							id="automaticlogon" name="automaticlogon" type="checkbox"
							value="1" />自动登录</label></li>
				</ul>
			</form>

		</div>

	</div>



	<div class="loginbm">版权所有 2013 .com 仅供学习交流，勿用于任何商业用途</div>
</body>
</html>
