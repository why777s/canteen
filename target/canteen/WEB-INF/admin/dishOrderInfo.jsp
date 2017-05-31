<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: why777s
  Date: 2017/5/23
  Time: 22:08
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
<blockquote>
    <p>订单详情</p>
</blockquote>
<table class="table table-hover table-bordered">
    <tr>
        <td>订单号:</td>
        <td> <s:property value="oid_for_dishOrder"/> </td>
    </tr>
    <tr class="success">
        <td>下单时间:</td>
        <td>
            <s:property value="orderByOid.orderTime"/>
        </td>
    </tr>
    <tr class="error">
        <td>学号:</td>
        <td>
            <s:property value="orderByOid.studentBySid.sid"/>
        </td>
    </tr>
    <tr class="warning">
        <td>姓名:</td>
        <td>
            <s:property value="orderByOid.studentBySid.sname"/>
        </td>
    </tr>
    <tr class="info">
        <td>总价:</td>
        <td>
            <s:property value="orderByOid.oprice"/>
        </td>

    </tr>
</table>


<br>
<h4 align="center">点菜单</h4>
<table class="table table-hover table-bordered">
    <tr class="success">
        <th>餐品id</th>
        <th>餐品名</th>
        <th>数量</th>
        <th>单价</th>
    </tr>
    <s:iterator value="#request.dishOrders" id="do" status="st">
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
            <td> <s:property value="#do.did"/> </td>
            <td> <s:property value="#do.dishBydid.dname"/> </td>
            <td> <s:property value="#do.dnum"/> </td>
            <td> <s:property value="#do.dishBydid.dprice"/> </td>
            </tr>
    </s:iterator>
</table>

</body>
</html>
