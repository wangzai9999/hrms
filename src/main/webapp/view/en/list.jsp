<%--
  Created by IntelliJ IDEA.
  User: 倪浩川
  Date: 2019/8/13
  Time: 20:03
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
</head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function(){

        $.get("pos/getall.action", "", function (res) {
            for (var i = 0; i < res.length; i++) {
                $("#pos").append("<option value='" + res[i].pos_id + "'>" + res[i].pos_name + "</option>");
            }
        }, "json");

        $.post("dep/getall.action", "", function (res) {
            for (var i = 0; i < res.length; i++) {
                $("#dep").append("<option value='" + res[i].de_id + "'>" + res[i].de_name + "</option>");
            }
        }, "json");

        show(1);

        $("body").on("click","#pages a",function () {
            var page = $(this).attr("name");
            show(page);
        });
        $("#select").click(function () {
            show(1);
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
        var getall = $("#getall").serialize()+"&page="+page;
        $.post("en/getall.action",getall,function (res) {
            $("#ens").html("");
            for (var i=0;i<res.list.length;i++) {
                var en = res.list[i];
                var tr=$("<tr></tr>");
                var td1=$("<td>"+en.en_id+"</td>");
                tr.append(td1);
                var td2=$("<td>"+en.en_dep.de_name+"</td>");
                tr.append(td2);
                var td3=$("<td>"+en.en_pos.pos_name+"</td>");
                tr.append(td3);
                var td4=$("<td>"+en.en_account+"</td>");
                tr.append(td4);
                var td5=$("<td>"+formateTime(en.en_deadline)+"</td>");
                tr.append(td5);
                var td6=$("<td>"+en.en_major_describe+"</td>");
                tr.append(td6);
                var td7=$("<td>"+en.en_experience+"</td>");
                tr.append(td7);
                var td8=$("<td>"+en.en_creater.us_name+"</td>");
                tr.append(td8);
                var td9=$("<td>"+formateTime(en.en_createtime)+"</td>");
                tr.append(td9);
                var td10=$("<td>"+en.en_status+"</td>");
                tr.append(td10);
                var td11=$("<td><a href='en/getone.action?en_id="+en.en_id+"'>修改</a><a href='en/del.action?en_id="+en.en_id+"'>删除</a></td>");
                tr.append(td11);
                $("#ens").append(tr);
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

        },"json")
    }

</script>
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
    <a href="view/en/add.jsp">发布招聘信息</a>
    <div class="operation_button">

    </div>
    <div class="search_input">
        <form id="getall">
            <ul class="txt">
                <li>最少人数：
                    <input type="text" name="minaccount" size="30" />
                </li>
                <li>最多人数：
                    <input type="text" name="miaxaccount" size="30" />
                </li>
                <li>开始时间：
                    <input type="text" name="mintime" size="30" />
                </li>
                <li>截止时间：
                    <input type="text" name="maxtime" size="30" />
                </li>
                <li>工作经验：
                    <select name="experience">
                        <option></option>
                        <option value="不限">不限</option>
                        <option value="1-2年">1-2年</option>
                        <option value="2-5年">2-5年</option>
                        <option value="5年以上">5年以上</option>
                    </select>
                </li>
                <li>部门：
                    <select name="depid" id="dep">
                            <option value="">请选择<option>
                    </select>
                </li>
                <li>职位：
                    <select name="posid" id="pos">
                        <option value="">请选择</option>
                    </select>
                </li>
            </ul>
            <input type="button" id="select" value="查询">
        </form>
    </div>
    <div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
            <thead>
            <tr>
                <th width="9%">招聘职位编号</th>
                <th width="9%">岗位所属部门</th>
                <th width="9%">所属职位</th>
                <th width="9%">招聘人数</th>
                <th width="9%">发布时间</th>
                <th width="9%">职位描述</th>
                <th width="9%">工作经验</th>
                <th width="9%">发布人</th>
                <th width="9%">截止时间</th>
                <th width="9%">状态</th>
                <th width="10%">操作</th>
            </tr>
            </thead>
            <tbody id="ens">

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
