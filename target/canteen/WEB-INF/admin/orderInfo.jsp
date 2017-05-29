<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: why777s
  Date: 2017/5/22
  Time: 16:35
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
    <tr>
        <th>订单号</th>
        <th>学生号</th>
        <th>下单时间</th>
        <th>操作</th>
    </tr>
    <s:iterator value="#request.finished_orders" id="fo" status="st">
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
            <td> <s:property value="#fo.oid"/> </td>
            <td> <s:property value="#fo.studentBySid.sid"/> </td>
            <td> <s:property value="#fo.orderTime"/> </td>
            <td width="15%"> <button class="btn btn-success">查看详情</button> </td>
            </tr>
    </s:iterator>
</table>

</body>
</html>
