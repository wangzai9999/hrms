<%--
  Created by IntelliJ IDEA.
  User: 倪浩川
  Date: 2019/8/13
  Time: 20:03
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
    <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
    <script type="text/javascript" src="js/javascript.js"></script>
    <script type="text/javascript" src="datepicker/WdatePicker.js"> </script>
</head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function(){

        list(1);

        $("body").on("click","#papa a",function(){
            var pp=$(this).attr("name");
            list(pp);
        })


    })

    function div(i){
        var s="#show"+i;
        if($(s).css('display')=='none'){
            $(s).css("display","block");
        }else{
            $(s).css("display","none");
    }}
    function query() {
        list();
    }
    function gopage() {
        var page=document.getElementById("page").value;
        list(page);
    }
    
    function list() {
        $.post("trs/getall.action","",function (res) {
            var trs=res.list;
            var tra=res.div;
            $("#trs").html("");
            for(var i=0;i<tra.length;i++){
                var tr=$("<tr></tr>");
                var td1=$("<td>"+tra[i].tr_id+"</td>");
                tr.append(td1);
                var td2=$("<td><span onclick='div("+i+")'>"+tra[i].tr_subject+"</span></td>");
                tr.append(td2);
                var td3=$("<td>"+tra[i].tr_havnum+"</td>");
                tr.append(td3);
                var traaaa =tra[i].tr_id;
                var div=$("<div id='show"+i+"' style='left:400px;color: #0E2D5F;display:none;'></div>");
                var tt=$("<tr><td>员工姓名</td><td>对本次培训评价</td><td>操作</td></tr>");
                div.append(tt);
                for(var j=0;j<trs.length;j++){
                    if (trs[j].ts_trid.tr_id==traaaa){var tr1=$("<tr></tr>");
                        var td1=$("<td>"+trs[j].ts_usid.us_name+"</td>");
                        var td2=$("<td>"+trs[j].ts_comm+"</td>");
                        var td3=$("<td><a href='trs/getOne.action?id="+trs[j].ts_id+"'>修改</a></td>")
                        tr1.append(td1);
                        tr1.append(td2);
                        tr1.append(td3);
                    }
                    div.append(tr1);
                }
                $("#trs").append(tr);
                $("#trs").append(div);
            }

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
         <div class="search_input">
             <form id="form_us">
             </ul>
             </form>
         </div>
         <div>
             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
                 <thead>
                 <tr>
                     <th width="15%">培训项目编号</th>
                     <th width="10%">培训项目名称</th>
                     <th width="15%">培训项目确认人数</th>
                 </tr>
                 </thead>
                 <tbody id="trs">

                 </tbody>
             </table>
         </div>

     </div>
</body>
</html>
