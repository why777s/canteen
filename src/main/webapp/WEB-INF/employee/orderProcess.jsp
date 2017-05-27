<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: why777s
  Date: 2017/5/24
  Time: 13:20
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

    <script>
        <s:if test="#request.message!=null">
            alert("<s:property value="#request.message"/>");
        </s:if>
    </script>

    <title>Title</title>
</head>
<body>

<blockquote>
    <p>新订单~</p>
</blockquote>
<table class="table table-hover table-bordered">
    <tr class="success">
        <td>订单id</td>
        <td>学生id</td>
        <td>下单时间</td>
        <td>操作</td>
    </tr>
    <s:iterator status="st" value="#request.new_orders" id="no">
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
        <td> <s:property value="#no.oid"/></td>
        <td> <s:property value="#no.studentBySid.sid"/></td>
        <td> <s:property value="#no.orderTime"/></td>
        <td width="15%"> <button class="btn btn-success">接单</button> </td>
        </tr>
    </s:iterator>
</table>

<blockquote>
    <p>待领取订单~</p>
</blockquote>
<table class="table table-hover table-bordered">
    <tr class="success">
        <td>订单id</td>
        <td>学生id</td>
        <td>下单时间</td>
        <td>操作</td>
    </tr>
    <s:iterator status="st" value="#request.ready_orders" id="ro">
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
        <td> <s:property value="#ro.oid"/></td>
        <td> <s:property value="#ro.studentBySid.sid"/></td>
        <td> <s:property value="#ro.orderTime"/></td>
        <td width="15%">
            <a class="btn btn-success" href="<s:url action="alterOrderToReady">
                         <s:param name="oidForAlter" value="%{oid}"/>
                     </s:url> ">通知取餐
            </a>


        </td>
        </tr>
    </s:iterator>
</table>

<blockquote>
    <p>已完成订单~</p>
</blockquote>
<table class="table table-hover table-bordered">
    <tr class="success">
        <td>订单id</td>
        <td>学生id</td>
        <td>下单时间</td>
    </tr>
    <s:iterator status="st" value="#request.finished_orders" id="fo">
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
        <td> <s:property value="#fo.oid"/></td>
        <td> <s:property value="#fo.studentBySid.sid"/></td>
        <td> <s:property value="#fo.orderTime"/></td>
        </tr>
    </s:iterator>
</table>


<blockquote>
    <p>全部订单~</p>
</blockquote>
<table class="table table-hover table-bordered">
    <tr class="success">
        <td>订单id</td>
        <td>学生id</td>
        <td>下单时间</td>
        <td>订单状态</td>
    </tr>
    <s:iterator status="st" value="#request.all_orders" id="ao">
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
        <td> <s:property value="#ao.oid"/></td>
        <td> <s:property value="#ao.studentBySid.sid"/></td>
        <td> <s:property value="#ao.orderTime"/></td>
        <td> <s:property value="#ao.orderStatus"/> </td>
        </tr>
    </s:iterator>
</table>

</body>
</html>
