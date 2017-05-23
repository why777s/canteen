<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: why777s
  Date: 2017/5/20
  Time: 01:19
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
    <title>订单信息</title>
</head>
<body>

<table class="table table-hover table-bordered">
    <tr class="success">
        <td>订单id</td>
        <td>下单时间</td>
        <td>操作</td>
    </tr>
    <s:iterator status="st" value="#request.orderList" id="ol">
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
        <td> <s:property value="#ol.oid"/> </td>
        <td> <s:property value="#ol.orderTime"/></td>
        <td width="15%"> <button class="btn btn-success">查看详情</button> </td>
        </tr>
    </s:iterator>
</table>


</body>
</html>