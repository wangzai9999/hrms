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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../common/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/star-main.css" media="all" type="text/css"/>
    <script src="../common/js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        var grade=0;
$(function () {
    $('[name="starLevel"]').bind("click",function(){
        alert($(this)[0].value);
        $("#starNum").val($(this)[0].value);
        var starNum = $(this)[0].value;
        if(starNum == 1) $("#starStr").text("1");
        if(starNum == 2) $("#starStr").text("2");
        if(starNum == 3) $("#starStr").text("3");
        if(starNum == 4) $("#starStr").text("4");
        if(starNum == 5) $("#starStr").text("5");
    })
})

    </script>
</head>

<body>
<div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >当前位置：客户服务管理&nbsp;&gt;&nbsp;评论
        <hr class="hr1" />
    </div>
    <div class="out_bg">
        <form action="tra/pinglun.action" method="post">
        <div class="in_bg" >
            <table border="0" cellpadding="0" cellspacing="0" class="table_input txt" style="text-align: center;">
                <input type="hidden" name="tr_id" value="${tra.tr_id}">
                <input type="hidden" name="tr_status" value="${tra.tr_status}" >
                <tr style="margin: auto">
                    <td width="126"></td>
                    <td width="126"></td>
                    <td width="126">培训名</td>
                    <td width="411"><input type="text" value="${tra.tr_subject}" disabled="disabled" /></td>
                    <td width="126"></td>
                    <td  width="411"></td>
                </tr>
                <tr> <div class="panel panel-default">
                    <td ></td><td></td>
                    <td>
                        <div class="panel-heading">满意度&nbsp;：</div>
                    </td><td>
                        <div class="panel-body">
                            <input name="pf" id="starNum" type="hidden"/>
                            <div class="starability-container">
                                <fieldset class="starability-slot">
                                    <input type="radio" id="rate_1_0_1_5" name="starLevel" value="5" />
                                    <label for="rate_1_0_1_5" title="5星"></label>
                                    <input type="radio" id="rate_1_0_1_4" name="starLevel" value="4" />
                                    <label for="rate_1_0_1_4" title="4星"></label>
                                    <input type="radio" id="rate_1_0_1_3" name="starLevel" value="3" />
                                    <label for="rate_1_0_1_3" title="3星"></label>
                                    <input type="radio" id="rate_1_0_1_2" name="starLevel" value="2" />
                                    <label for="rate_1_0_1_2" title="2星"></label>
                                    <input type="radio" id="rate_1_0_1_1" name="starLevel" value="1" />
                                    <label for="rate_1_0_1_1" title="1星"></label>
                                </fieldset>
                            </div>
                            <span style="font-size: 2rem;line-height: 2.9rem;padding: 1rem;font-style: oblique;"  id="starStr"></span>
                        </div>
                    </div></td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td>评论</td>
                    <td><textarea style="height: 150px;width: 200px" name="pj">${tra.pj}</textarea>
                        </td>
                </tr>
                <tr>
                    <td ></td><td></td>
                    <td colspan="2"><input type="submit" value="提交" /></td></tr>
            </table>
        </div>
        </form>
    </div>
</div>

</body>
<style>
    .page-header{
        padding-bottom: 1px !important;
        margin: 18px 0 20px !important;
    }
    .submit_btn{
        width: 100%;
    }
    .textarea.form-control{
        height: 28rem !important;
    }
    h3{
        font-size: 22px;
    }

    h2{
        font-size: 19px;
    }
</style>
</html>
