<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <base href="<%=basePath%>">

  <title>部门人数统计</title>
  <link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
  <link href="css/style.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="js/echarts.min.js"></script>
  <script type="text/javascript" src="js/jquery-1.12.4.js"></script>


</head>

<body>
<div id="main" style="width: 600px;height:400px;"></div>



</body>
</html>

<script type="text/javascript">
  // 基于准备好的dom，初始化echarts实例
  var myChart = echarts.init(document.getElementById('main'));

  // 指定图表的配置项和数据
  var option = {
    title: {
      text: '部门员工数量'
    },
    tooltip: {},
    legend: {
      data:['人数']
    },
    xAxis: {
      data: ${xk}
    },
    yAxis: {},
    series: [{
      name: '人数',
      type: 'bar',
      data: ${yv}
    }]
  };

  // 使用刚指定的配置项和数据显示图表。
  myChart.setOption(option);


</script>
