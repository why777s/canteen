<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: why777s
  Date: 2017/5/19
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">
    <title>学生管理</title>
    <style type="text/css">
        body{
            overflow:scroll;
            overflow-y:hidden;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a>
                <a href="#" class="brand">欢迎订餐</a>
                <div class="nav-collapse collapse navbar-responsive-collapse">
                    <ul class="nav">
                        <li class="active">
                            <a href="<s:url action="stu_turn_dishInfo"/>" target="cont" >菜单查询</a>
                        </li>
                        <li>
                            <a href="<s:url action="stu_turn_orderInfo"/>" target="cont">订单查询</a>
                        </li>
                        <li>
                            <a href="<s:url action="stu_turn_commentInfo"/>" target="cont">评论查询</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<iframe name="cont"  height="100%" width="100%" frameborder="0px">
</iframe>

</body>
</html>