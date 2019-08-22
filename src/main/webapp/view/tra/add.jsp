<%--
  Created by IntelliJ IDEA.
  User: 倪浩川
  Date: 2019/8/14
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>Title</title>
    <link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">

        function save(prop,url){
            var  tr_man=$("#tr_man").val();
            var  tr_subject=$("#tr_subject").val();
            var tr_starttime=$("#tr_starttime").val();
            var tr_endtime=$("#tr_endtime").val();
            var tr_num=$("#tr_num").val();

            var num=/^\d+$/;
            if (tr_man==null||tr_man=="") {
                alert("培训人:不能为空");
            }else if (tr_subject==null||tr_subject=="") {
                alert("培训项目:不能为空");
            }else if (tr_starttime==null||tr_starttime=="") {
                alert("培训开始时间:不能为空");
            }else if (tr_endtime==null||tr_endtime=="") {
                alert("培训结束时间:不能为空");
            }else if (tr_num==null||tr_num=="") {
                alert("培训人数:不能为空");
            }else if (!num.test(tr_num)) {
                alert("培训人数:请填写数字");
            }else {
                var tra=$("#form_tra").serialize();
                $.post("tra/add.action",tra,function (res) {
                    if(res!=null) {
                        alert(prop+'成功！');
                        location.href=url;
                    } else {
                        alert(prop+"失败");
                    }
                });
            }
        }

    </script>
</head>

<body>
<div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >当前位置：客户服务管理&nbsp;&gt;&nbsp;添加员工
        <hr class="hr1" />
    </div><a href="view/tra/list.jsp"><button >列表员工</button></a>
    <div class="operation_button">
        <button title="保存" onclick="save('保存','view/tra/list.jsp')">保存</button>
    </div>
    <div class="out_bg">
        <form id="form_tra" method="post">
        <div class="in_bg" >
            <table border="0" cellpadding="0" cellspacing="0" class="table_input txt" style="text-align: center;">
                <tr style="margin: auto">
                    <td width="126"></td>
                    <td width="126"></td>
                    <td width="126">培训人</td>
                    <td><input type="text"  name="tr_man" id="tr_man" required="required"/></td>
                    <td width="126"></td>
                    <td  width="411"></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>培训项目</td>
                    <td><input type="text"  name="tr_subject" id="tr_subject"  required="required"/></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>培训开始时间</td>
                    <td><input type="text"  name="tr_starttime"  id="tr_starttime" required="required"/></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>培训结束时间</td>
                    <td><input type="text"name="tr_endtime" id="tr_endtime"  required="required"/></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>培训人数</td>
                    <td><input type="text"  name="tr_num" id="tr_num" required="required" /></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>备注</td>
                    <td><textarea rows="6" cols="72" name="tr_remark" ></textarea></td>
                </tr>
            </table>
        </div>
        </form>
    </div>
</div>
</body>
</html>
