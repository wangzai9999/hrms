<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
   function modpic() {
     $("#photo").html("");
     $("#photo").append('<td >员工图片:<input type="file" name="file" ></td>');
   }
</script>
</head>

<body>


<form action="arc/mod.action" method="post" enctype="multipart/form-data" >
<!--标准表单-->
<div style="padding:5px;">
  <div class="out_bg">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <input type="hidden" name="ar_id" value="${arc.ar_id}">
          <input type="hidden" name="ar_uid.us_id" value="${arc.ar_uid.us_id}" >
          <td>员工姓名：<input type="text" name="ar_uid" value="${arc.ar_uid.us_name}" disabled></td>
          <td>身份证号：<input type="text" name="ar_id_card" value="${arc.ar_id_card}" required /></td>
        </tr>
        <tr>
          <input type="hidden" name="ar_regist" value="${arc.ar_regist}">
          <td>性别：男<input type="radio" name="ar_sex" value="男" ${(arc.ar_sex eq "男")?'checked':''} />女<input type="radio" name="ar_sex" value="女" ${(arc.ar_sex eq "女")?'checked':''}/></td>
          <td>年龄：<input type="number" name="ar_age" value="${arc.ar_age}" required /></td>

        </tr>
        <tr>

          <td>工龄：<input type="text" name="ar_gl" value="${arc.ar_gl}" required></td>
          <td>国籍：<input type="text" name="ar_nationality" value="${arc.ar_nationality}" required></td>

        </tr>

        <tr>
          <td>民族：<input type="text" name="ar_race" value="${arc.ar_race}" required /></td>
          <td>政治面貌：<input type="text" name="ar_party" value="${arc.ar_party}" required></td>

        </tr>
        <tr>
          <td>出生日期：<input type="date" name="ar_birthday" value="<fmt:formatDate value="${arc.ar_birthday}" pattern="yyyy-MM-dd"/>"   required></td>
          <td>出生地：<input type="text" name="ar_birthplace" value="${arc.ar_birthplace}" required /></td>
        </tr>
        <tr>
          <td>专业：<input type="text" name="ar_educated_major" value="${arc.ar_educated_major}" required></td>
          <td>学历：
            <select name="ar_educated_degree">
              <option value="高中" ${arc.ar_educated_degree=="高中"?'selected':''}>高中</option>
              <option value="中专" ${arc.ar_educated_degree=="中专"?'selected':''}>中专</option>
              <option value="大专" ${arc.ar_educated_degree=="大专"?'selected':''}>大专</option>
              <option value="本科" ${arc.ar_educated_degree=="本科"?'selected':''}>本科</option>
              <option value="硕士" ${arc.ar_educated_degree=="硕士"?'selected':''}>硕士</option>
              <option value="博士" ${arc.ar_educated_degree=="博士"?'selected':''}>博士</option>
          </select>
          </td>
        </tr>
        <tr>
          <td>电子邮件：<input type="email" name="ar_email" value="${arc.ar_email}" required></td>
          <td>手机号码：<input type="text" name="ar_telephone" value="${arc.ar_telephone}" required /></td>

        </tr>
        <tr>
          <td>QQ号码：<input type="text" name="ar_qq" value="${arc.ar_qq}" required /></td>
          <td>特长：<input type="text" name="ar_speciality" value="${arc.ar_speciality}"  /></td>
        </tr>
        <tr>
          <td >档案状态<input type="text" name="ar_status" value="${arc.ar_status}" ></td>
          <td >家庭住址：<input type="text" name="ar_address" value="${arc.ar_address}" required></td>
        </tr>
        <tr>
          <td colspan="2"><span >爱好:</span><textarea rows="6" cols="72" name="ar_love" >${arc.ar_love}</textarea></td>
        </tr>
        <tr>
          <td colspan="2"><span >工作经历:</span><textarea rows="6" cols="72" name="ar_gzjl" >${arc.ar_gzjl}</textarea></td>
        </tr>
        <tr id="photo">
          <input type="hidden" name="ar_photo" value="${arc.ar_photo}">

          <td colspan="2"><input id="gopic" type="image" src="${arc.ar_photo}" id="oldphoto"><button onclick="modpic()">重上传图像</button></td>


        </tr>
        <tr>

          <td colspan="2"><input type="submit" value="修改"></td>

        </tr>
      </table>
    </div>
  </div>
</div>
</form>
</body>
</html>
