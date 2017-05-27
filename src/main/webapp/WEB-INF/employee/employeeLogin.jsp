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
    <title>员工管理</title>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="page-header">
                <h2>
                    餐饮管理系统 <small>欢迎员工:<s:property value="#session.userID"/></small>
                </h2>
            </div>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="#">首页</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span8">
            <iframe name="cont"  height="100%" width="100%" frameborder="0px">
            </iframe>
        </div>
        <div class="span4">
            <ul class="nav nav-list">
                <li class="nav-header">
                    基本查询
                </li>
                <li>
                    <a href="<s:url action="turn_canteenInfo"/>" target="cont">食堂查询</a>
                </li>
                <li>
                    <a href="<s:url action="turn_dishInfo"/>" target="cont">餐品查询</a>
                </li>
                <li class="nav-header">
                    订单操作
                </li>
                <li>
                    <a href="<s:url action="turn_orderProcess"/>" target="cont">订单处理</a>
                </li>
                <li class="divider">
                </li>
                <li>
                    <a href="#">帮助</a>
                </li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>