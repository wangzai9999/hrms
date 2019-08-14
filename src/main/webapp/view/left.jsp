<%--
  Created by IntelliJ IDEA.
  User: 倪浩川
  Date: 2019/8/14
  Time: 9:02
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
    <link rel="stylesheet" href="css/stylesheet.css" type="text/css"  />
    <link rel="stylesheet" href="css/sidebar.css" type="text/css"  />
    <script type="text/javascript" src="js/javascript.js"></script>
    <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
</head>
<body>
<div>
    <div id="loader"><img src="images/1d_2.gif"/></div>
    <div class="current_user attention">
        <div> 欢迎您，<strong>${requestScope.loger.us_name}</strong><br />
            [系统管理员，<a href="#">退出</a>] </div>
    </div>
    <div id="sidebar">
        <div id="sidebar-wrapper">
            <ul id="main-nav">
                <li> <a href="#" class="nav-top-item current" id="man_nav_1" onclick="list_sub_nav(id)"> 营销管理 </a>
                    <ul>
                        <li><a href="crm_sale/opp/list.html" target="rightFrame" id="a_nav_1" onclick="a_sub_nav(id)">销售机会管理</a></li>
                        <li><a href="crm_sale/dev/list.html" target="rightFrame" id="a_nav_2" onclick="a_sub_nav(id)">客户开发计划</a></li>
                    </ul>
                </li>
                <li> <a href="#" class="nav-top-item" id="man_nav_2" onclick="list_sub_nav(id)"> 客户开发计划 </a>
                    <ul>
                        <li><a href="crm_cus/info/list.html" target="rightFrame" id="a_nav_3" onclick="a_sub_nav(id)">客户信息管理</a></li>
                        <li><a href="crm_cus/lose/list.html" target="rightFrame" id="a_nav_4" onclick="a_sub_nav(id)">客户流失管理</a></li>
                    </ul>
                </li>
                <li> <a href="#" class="nav-top-item" id="man_nav_3" onclick="list_sub_nav(id)"> 服务管理 </a>
                    <ul>
                        <li><a href="crm_service/add.html" target="rightFrame" id="a_nav_5" onclick="a_sub_nav(id)">服务创建</a></li>
                        <li><a href="crm_service/dispatch.html" target="rightFrame" id="a_nav_6" onclick="a_sub_nav(id)">服务分配</a></li>
                        <li><a href="crm_service/deal_list.html" target="rightFrame" id="a_nav_7" onclick="a_sub_nav(id)">服务处理</a></li>
                        <li><a href="crm_service/feedback_list.html" target="rightFrame" id="a_nav_8" onclick="a_sub_nav(id)">服务反馈</a></li>
                        <li><a href="crm_service/file_list.html" target="rightFrame" id="a_nav_9" onclick="a_sub_nav(id)">服务归档</a></li>
                    </ul>
                </li>
                <li> <a href="#" class="nav-top-item" id="man_nav_4" onclick="list_sub_nav(id)"> 统计报表 </a>
                    <ul>
                        <li><a href="crm_rep/contribution.html" target="rightFrame" id="a_nav_10" onclick="a_sub_nav(id)">客户贡献分析</a></li>
                        <li><a href="crm_rep/constitute.html" target="rightFrame" id="a_nav_11" onclick="a_sub_nav(id)">客户构成分析</a></li>
                        <li><a href="crm_rep/service.html" target="rightFrame" id="a_nav_12" onclick="a_sub_nav(id)">客户服务分析</a></li>
                        <li><a href="crm_rep/lose.html" target="rightFrame" id="a_nav_13" onclick="a_sub_nav(id)">客户流失分析</a></li>
                    </ul>
                </li>
                <li> <a href="#" class="nav-top-item" id="man_nav_5" onclick="list_sub_nav(id)"> 基础数据 </a>
                    <ul>
                        <li><a href="crm_base/dict.html" target="rightFrame" id="a_nav_14" onclick="a_sub_nav(id)">数据字典管理</a></li>
                        <li><a href="crm_base/product.html" target="rightFrame" id="a_nav_15" onclick="a_sub_nav(id)">查询产品信息</a></li>
                        <li><a href="crm_base/stock.html" target="rightFrame" id="a_nav_16" onclick="a_sub_nav(id)">查询库存</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
