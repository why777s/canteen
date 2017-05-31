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

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">
    <title>后台管理</title>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="page-header">
                <h2>
                    餐饮管理系统 <small>欢迎管理员:<s:property value="#session.userID"/> </small>
                </h2>
            </div>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="#">首页</a>
                </li>
                <li>
                    <a href="#">资料</a>
                </li>
                <li class="disabled">
                    <a href="#">信息</a>
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
                <li>
                    <a href="<s:url action="turn_allCommentInfo"/>" target="cont">查看评论</a>
                </li>
                <li class="nav-header">
                    食堂操作
                </li>
                <li>
                    <a href="#">窗口修改</a>
                </li>
                <li>
                    <a href="<s:url action="turn_dishUpdate"/>" target="cont">餐品修改</a>
                </li>

                <li class="nav-header">
                    订单操作
                </li>
                <li>
                    <a href="<s:url action="admin_turn_orderInfo"/>" target="cont">订单查询</a>
                </li>
                <li>
                    <a href="#">订单处理</a>
                </li>
                <li>
                    <a href="#">订单统计</a>
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
