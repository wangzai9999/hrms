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
    <title>CRM_Left</title>
    <link rel="stylesheet" href="css/stylesheet.css" type="text/css"  />
    <link rel="stylesheet" href="css/sidebar.css" type="text/css"  />
    <script type="text/javascript" src="js/javascript.js"></script>
    <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
    <script src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        function ul(i){
            var s="#uul"+i;
            if($(s).css('display')=='none'){
                $(s).css("display","block");
            }else{
                $(s).css("display","none");
            }}
        $(function () {

            $.post("powers/getall.action","",function (res) {
                var a=0;
                var b=0;
                for (var i=0;i<res.length;i++){
                    a++;
                    var pr=res[i];
                    if (pr.children!=null&&pr.children.length>0 ){
                        var li=$(" <li> <a class='nav-top-item current' id='man_nav_"+a+"' onclick='ul("+i+")'> "+pr.text+" </a></li>");
                        var ul=$(" <ul id='uul"+i+"' style='display: none'></ul>");
                        for (var j=0;j<pr.children.length;j++){
                            var ch=pr.children[j];
                            if (ch.po_url!=null &&ch.po_url.length>0) {
                                b++;
                                var lll = (" <li> <a href='" + ch.po_url + "'id='a_nav_"+b+"' target='rightFrame'onclick='a_sub_nav(id)'> " + ch.text + " </a></li>");
                                ul.append(lll);
                            }
                        }
                        li.append(ul);
                    }

                    $("#main-nav").append(li);
                }
            },"json")

        })


    </script>
</head>

<body>
<div>
    <div id="sidebar">
        <div id="sidebar-wrapper">
            <ul id="main-nav">
                <%--<li> <a href="#" class="nav-top-item current" id="man_nav_1" onclick="list_sub_nav(id)" > 员工管理 </a>--%>
                    <%--<ul>--%>
                        <%--<li><a href="view/user/list.jsp" target="rightFrame"  onclick="a_sub_nav(id)" >员工展示</a></li>--%>
                        <%--<li><a href="view/user/add.jsp" target="rightFrame" id="a_nav_2" onclick="a_sub_nav(id)">员工添加</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
                <%--<li> <a href="#" class="nav-top-item" id="man_nav_2" onclick="list_sub_nav(id)"> 培训管理 </a>--%>
                    <%--<ul>--%>
                        <%--<li><a href="view/tra/list.jsp" target="rightFrame" id="a_nav_3" onclick="a_sub_nav(id)">培训信息管理</a></li>--%>
                        <%--<li><a href="view/tra/add.jsp" target="rightFrame" id="a_nav_4" onclick="a_sub_nav(id)">培训信息添加</a></li>--%>
                        <%--<li><a href="view/taf/list.jsp" target="rightFrame" id="a_nav_7" onclick="a_sub_nav(id)">申请培训人员表</a></li>--%>
                        <%--<li><a href="view/trs/list.jsp" target="rightFrame" id="a_nav_9" onclick="a_sub_nav(id)">培训人员表</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
                <%--<li> <a href="#" class="nav-top-item" id="man_nav_3" onclick="list_sub_nav(id)"> 薪酬标准管理 </a>--%>
                    <%--<ul>--%>
                        <%--<li><a href="view/salary/add.jsp" target="rightFrame" id="a_nav_5" onclick="a_sub_nav(id)">薪酬标准添加</a></li>--%>
                        <%--<li><a href="salt/getall.action" target="rightFrame" id="a_nav_6" onclick="a_sub_nav(id)">薪酬标准展示</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
                <%--<li> <a href="#" class="nav-top-item" id="man_nav_4" onclick="list_sub_nav(id)"> 招聘管理 </a>--%>
                    <%--<ul>--%>
                        <%--<li><a href="view/en/list.jsp" target="rightFrame" id="a_nav_12" onclick="a_sub_nav(id)">招聘信息</a></li>--%>
                        <%--<li><a href="view/resume/list.jsp" target="rightFrame" id="a_nav_10" onclick="a_sub_nav(id)">简历展示</a></li>--%>
                        <%--<li><a href="view/ach/list.jsp" target="rightFrame" id="a_nav_11" onclick="a_sub_nav(id)">招聘成绩</a></li>--%>
                        <%--<li><a href="view/en/add.jsp" target="rightFrame" id="a_nav_13" onclick="a_sub_nav(id)">招聘信息添加</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
                <%--<li> <a href="#" class="nav-top-item" id="man_nav_5" onclick="list_sub_nav(id)"> 部门管理 </a>--%>
                    <%--<ul>--%>
                        <%--<li><a href="view/department/deptree.jsp" target="rightFrame" id="a_nav_8" onclick="a_sub_nav(id)">部门员工展示</a></li>--%>

                    <%--</ul>--%>
                <%--</li>--%>
                <%--<li> <a href="#" class="nav-top-item" id="man_nav_7" onclick="list_sub_nav(id)"> 绩效管理 </a>--%>
                    <%--<ul>--%>
                        <%--<li><a href="view/achs/list.jsp" target="rightFrame" id="a_nav_17" onclick="a_sub_nav(id)">员工绩效考核</a></li>--%>
                        <%--<li><a href="view/av/list.jsp" target="rightFrame" id="a_nav_18" onclick="a_sub_nav(id)">绩效成绩</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
                <%--<li> <a href="#" class="nav-top-item" id="man_nav_8" onclick="list_sub_nav(id)"> 薪资 </a>--%>
                    <%--<ul>--%>
                        <%--<li><a href="view/sl/list.jsp" target="rightFrame" id="a_nav_20" onclick="a_sub_nav(id)">员工薪资</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
                <%--<li> <a href="#" class="nav-top-item" id="man_nav_6" onclick="list_sub_nav(id)"> 权限管理 </a>--%>
                    <%--<ul>--%>
                        <%--<li><a href="view/power/powers.jsp" target="rightFrame" id="a_nav_15" onclick="a_sub_nav(id)">权限树</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
