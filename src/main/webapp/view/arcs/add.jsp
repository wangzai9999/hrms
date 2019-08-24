<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    if (usid==false){
        var uid=$("#usid").val();
        $.post("user/getone.action","usid="+uid,function (user) {
            $("#usname").attr("value",user.us_name);
        },"json");
    }else {
        $.getJSON("user/getone.action","usid="+usid,function (res) {
            $("#usid").attr("value",res.us_id);
            $("#usname").attr("value",res.us_name);
        });
    }


    $("#telephone").change(function () {
      $(this).next("span").html("");
      var phone=$(this).val();
      var ph=/^1[0-9]{10}$/;
      if (!ph.test(phone)) {
        $(this).next("span").html("请输入正确的电话号码！");
      }
    });
    $("#idcard").change(function () {
      $(this).next("span").html("");
      var ic=$(this).val();
      var reg=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
      if (!reg.test(ic)) {
        $(this).next("span").html("请输入正确的身份证号码！");
      }
    })
  });

  $(function () {
    $("#subt").click(function () {



     var phone1=$("#telephone").val();
      var ph=/^1[0-9]{10}$/;
      if (!ph.test(phone1)) {
        alert("请输入正确的电话号码！");
        return false;
      }


      var icd=$("#idcard").val();
      var reg=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
      if (!reg.test(icd)) {
        alert("请输入正确的身份证号码！");
        return false;
      }

     $("#arcsform").submit();

    });
  })





</script>
</head>

<body>


<form action="arc/add.action" method="post" enctype="multipart/form-data" id="arcsform" >
<!--标准表单-->
<div style="padding:5px;">
  <div class="out_bg">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <input type="hidden" name="ar_uid.us_id" value="${arc.ar_uid.us_id}" id="usid">
          <td>员工姓名：<input type="text" name="name" value="${arc.ar_uid.us_name}" id="usname" disabled></td>
          <td>身份证号：<input type="text" name="ar_id_card" value="${arc.ar_id_card}" id="idcard" required/><span style="color: red">${ar_id_card}</span></td>
        </tr>
        <tr>
          <td>性别：男<input type="radio" name="ar_sex" value="男" ${((arc.ar_sex eq '男') or (arc.ar_sex eq null)) ?'checked':''}/>女<input type="radio" name="ar_sex" value="女" ${arc.ar_sex eq '女'?'checked':''}/></td>
          <td>年龄：<input type="number" name="ar_age" required value="${arc.ar_age}" min="18" max="65"/></td>

        </tr>
        <tr>
          <td>工龄：<input type="number" name="ar_gl" required max="60" value="${arc.ar_gl}"></td>
          <td>国籍：<input type="text" name="ar_nationality" value="${arc.ar_nationality}" required></td>

        </tr>

        <tr>
          <td>民族：<input type="text" name="ar_race" value="${arc.ar_race}" required /></td>
          <td>政治面貌：<input type="text" name="ar_party" value="${arc.ar_party}" required></td>

        </tr>
        <tr>
          <td>出生日期：<input type="date" name="ar_birthday" value='<fmt:formatDate value="${arc.ar_birthday}" pattern="yyyy-MM-dd"/>' required max="2001-12-31" min="1959-12-31"></td>
          <td>出生地：<input type="text" name="ar_birthplace" value="${arc.ar_birthplace}" required /></td>
        </tr>
        <tr>
          <td>专业：<input type="text" name="ar_educated_major" value="${arc.ar_educated_major}" required></td>
          <td>学历：
            <select name="ar_educated_degree">
              <option value="高中" ${arc.ar_educated_degree eq '高中'?'selected':''}>高中</option>
              <option value="中专" ${arc.ar_educated_degree eq '中专'?'selected':''}>中专</option>
              <option value="大专" ${arc.ar_educated_degree eq '大专'?'selected':''}>大专</option>
              <option value="本科" ${arc.ar_educated_degree eq '本科'?'selected':''}>本科</option>
              <option value="硕士" ${arc.ar_educated_degree eq '硕士'?'selected':''}>硕士</option>
              <option value="博士" ${arc.ar_educated_degree eq '博士'?'selected':''}>博士</option>
          </select>
          </td>
        </tr>
        <tr>
          <td>电子邮件：<input type="email" name="ar_email" value="${arc.ar_email}" required></td>
          <td>手机号码：<input type="text" name="ar_telephone" value="${arc.ar_telephone}" required  id="telephone"/><span style="color: red">${ar_telephone}</span></td>

        </tr>
        <tr>
          <td>QQ号码：<input type="text" name="ar_qq" required value="${arc.ar_qq}"/></td>
          <td>特长：<input type="text" name="ar_speciality" value="${arc.ar_speciality}" /></td>
        </tr>
        <tr>
          <td colspan="2">家庭住址：<input type="text" name="ar_address" value="${arc.ar_address}" required></td>
        </tr>
        <tr>
          <td colspan="2"><span >爱好:</span><textarea rows="6" cols="72" name="ar_love" >${arc.ar_love}</textarea></td>
        </tr>
        <tr>
          <td colspan="2"><span >工作经历:</span><textarea rows="6" cols="72" name="ar_gzjl" >${arc.ar_gzjl}</textarea></td>
        </tr>
        <tr>

          <td colspan="3">员工图片:<input type="file" name="file" required></td>

        </tr>
        <tr>

          <td colspan="3"><input type="button" value="增加" id="subt"></td>

        </tr>
      </table>
    </div>
  </div>
</div>
</form>
</body>
</html>
