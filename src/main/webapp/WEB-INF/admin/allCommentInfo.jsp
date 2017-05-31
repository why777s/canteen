<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: why777s
  Date: 2017/5/24
  Time: 01:02
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
    <title>Title</title>
</head>
<body>

<table class="table table-hover table-bordered">
    <tr class="success">
        <td>评论编号</td>
        <td>餐品名</td>
        <td>学生姓名</td>
        <td>评论内容</td>
    </tr>
    <s:iterator status="st" value="#request.comments">
    <s:if test="#st.getCount()%4==0">
    <tr class="success">
        </s:if>
        <s:elseif test="#st.getCount()%4==1">
    <tr class="error">
        </s:elseif>
        <s:elseif test="#st.getCount()%4==2">
    <tr class="warning">
        </s:elseif>
        <s:elseif test="#st.getCount()%4==3">
    <tr class="info">
        </s:elseif>
        <td> <s:property value="commentId"/> </td>
        <td> <s:property value="dishByDid.dname"/> </td>
        <td> <s:property value="studentBySid.sname"/> </td>
        <td> <s:property value="commentContent"/> </td>
        </s:iterator>
</table>

</body>
</html>
