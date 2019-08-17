<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <base href="<%=basePath%>">

  <title>增加员工档案信息</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
  function getQueryVariable(variable)
  {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
      var pair = vars[i].split("=");
      if(pair[0] == variable){return pair[1];}
    }
    return(false);
  }
  $(function () {
    var usid=getQueryVariable("id");
    $.getJSON("user/getone.action","usid="+usid,function (res) {
         $("#usid").attr("value",res.us_id);
         $("#usname").attr("value",res.us_name);
    });
  })
</script>
</head>

<body>


<form action="arc/add.action" method="post" enctype="multipart/form-data" >
<!--标准表单-->
<div style="padding:5px;">
  <div class="out_bg">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <input type="hidden" name="ar_uid.us_id" value="" id="usid">
          <td>员工姓名：<input type="text" name="name" value="" id="usname" disabled></td>
          <td>身份证号：<input type="text" name="ar_id_card" required size="18" pattern="/^\d{15}$)|(^\d{17}([0-9]|X)$/" /></td>
        </tr>
        <tr>
          <td>性别：男<input type="radio" name="ar_sex" value="男" checked/>女<input type="radio" name="ar_sex" value="女"/></td>
          <td>年龄：<input type="number" name="ar_age" required min="18" max="65"/></td>

        </tr>
        <tr>
          <td>工龄：<input type="number" name="ar_gl" required max="60"></td>
          <td>国籍：<input type="text" name="ar_nationality" required></td>

        </tr>

        <tr>
          <td>民族：<input type="text" name="ar_race" required /></td>
          <td>政治面貌：<input type="text" name="ar_party" required></td>

        </tr>
        <tr>
          <td>出生日期：<input type="date" name="ar_birthday" required max="2001-12-31" min="1959-12-31"></td>
          <td>出生地：<input type="text" name="ar_birthplace" required /></td>
        </tr>
        <tr>
          <td>专业：<input type="text" name="ar_educated_major" required></td>
          <td>学历：
            <select name="ar_educated_degree">
              <option value="高中">高中</option>
              <option value="中专">中专</option>
              <option value="大专">大专</option>
              <option value="本科">本科</option>
              <option value="硕士">硕士</option>
              <option value="博士">博士</option>
          </select>
          </td>
        </tr>
        <tr>
          <td>电子邮件：<input type="email" name="ar_email" required></td>
          <td>手机号码：<input type="text" name="ar_telephone" required size="11"/></td>

        </tr>
        <tr>
          <td>QQ号码：<input type="text" name="ar_qq" required /></td>
          <td>特长：<input type="text" name="ar_speciality"  /></td>
        </tr>
        <tr>
          <td colspan="2">家庭住址：<input type="text" name="ar_address" required></td>
        </tr>
        <tr>
          <td colspan="2"><span >爱好:</span><textarea rows="6" cols="72" name="ar_love" ></textarea></td>
        </tr>
        <tr>
          <td colspan="2"><span >工作经历:</span><textarea rows="6" cols="72" name="ar_gzjl" ></textarea></td>
        </tr>
        <tr>

          <td colspan="3">员工图片:<input type="file" name="file" required></td>

        </tr>
        <tr>

          <td colspan="3"><input type="submit" value="增加"></td>

        </tr>
      </table>
    </div>
  </div>
</div>
</form>
</body>
</html>
