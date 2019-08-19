<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17 0017
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
    <script type="text/javascript" src="js/javascript.js"></script>
    <script type="text/javascript" src="datepicker/WdatePicker.js"> </script>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">

        $(function () {
            show(1);

            $("body").on("click","#pages a",function(){
                var page = $(this).attr("name");
                show(page);
            })

        })

        function formateTime(time)
        {
            var date = new Date(time);
            Y = date.getFullYear() + '-';
            M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
            D = date.getDate() + ' ';
            h = date.getHours() + ':';
            m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) : date.getMinutes()) + ':';
            s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) : date.getSeconds());
            return Y+M+D+h+m+s;
        }

        function show(page){
            var enid;
            if(${enid eq null}){
                enid=0;
            }else{
                enid = ${enid};
            }

            $.post("resume/getall.action","page="+page+"&enid="+enid,function (res) {
                $("#resumes").html("");
                for (var i=0;i<res.list.length;i++){
                    var re = res.list[i];
                    var tr1=$("<tr></tr>");

                    var td1=$("<td>"+re.re_id+"</td>");
                    tr1.append(td1);
                    var td2=$("<td>"+re.re_name+"</td>");
                    tr1.append(td2);
                    var td3=$("<td>"+re.re_position+"</td>");
                    tr1.append(td3);
                    var td4=$("<td>"+re.re_enid.en_major_describe+"</td>");
                    tr1.append(td4);
                    var td5=$("<td>"+formateTime(re.re_time)+"</td>");
                    tr1.append(td5);
                    var td8=$("<td>"+re.re_status+"</td>");
                    tr1.append(td8);
                    var td6=$("<td><a href='resume/download.action?filename="+re.re_url+"'>查看<a/></td>");
                    tr1.append(td6);
                    if(re.re_status=="新增"){
                        var td7=$("<td><a href='resume/getone.action?re_id="+re.re_id+"'>考核<a/>||<a href='resume/del.action?re_id="+re.re_id+"'>删除</a></td>");
                        tr1.append(td7);
                    }
                    if(re.re_status=="未通过"){
                        var td7 = $("<td><a href='resume/del.action?re_id="+re.re_id+"'>删除</a></td>");
                        tr1.append(td7);
                    }

                    $("#resumes").append(tr1);
                }
                $("#pages").html("");
                var a1=$("<a name='1'>首页</a>");
                $("#pages").append(a1);
                var a2=$("<a name='"+(res.currpage-1)+"'>上一页</a>");
                $("#pages").append(a2);
                var a3=$("<a name='"+(res.currpage+1)+"'>下一页</a>");
                $("#pages").append(a3);
                var a4=$("<a name='"+(res.totalPage)+"'>尾页</a>");
                $("#pages").append(a4);
            })
        }

    </script>
</head>
<body>
<div id="div1">
    <table>
        <tr>

        </tr>
        <thead id="thead1">

        </thead>
    </table>

</div>
<div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户流失管理&nbsp;&gt;&nbsp;流失信息
        <hr class="hr1" />
    </div>
    <div class="operation_button">

    </div>
    <div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
            <thead>
            <tr>
                <th width="9%">简历编号</th>
                <th width="9%">姓名</th>
                <th width="9%">应聘职位</th>
                <th width="9%">职位信息</th>
                <th width="9%">投简时间</th>
                <th width="9%">状态</th>
                <th width="9%">简历</th>
                <th width="9%">操作</th>
            </tr>
            </thead>
            <tbody id="resumes">

            </tbody>
        </table>
    </div>
    <div class="position" id="pages">
        <%--共59条记录&nbsp;每页10条&nbsp;第1页/共5页
        <a href="#" title="首页">&laquo;首页</a><a href="#" title="上一页">&laquo; 上一页</a><a href="#" title="下一页">下一页&raquo;</a><a href="#" title="末页">末页&raquo;</a> 转到&nbsp;
        <input value="1" size="2" />
        &nbsp;页<a href="#">GO</a>
        </li>--%>
    </div>
</div>
</body>
</html>