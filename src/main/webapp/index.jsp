<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>


    <title>登录界面</title>
    <link href="<%=basePath%>css/login.css" type="text/css" rel="stylesheet">

</head>
<body>
<%--<s:form action="login">--%>
    <%--<s:textfield name="username"/>--%>
    <%--<s:password name="password"/>--%>
    <%--<s:submit value="login"/>--%>
<%--</s:form>--%>


<div class="login">
    <div class="message">食堂自助点餐</div>
    <div id="darkbannerwrap"></div>
    <s:form method="post" id="theform" action="login">
        <input name="username" placeholder="用户名" required="" type="text">
        <hr class="hr15">
        <input name="password" placeholder="密码" required="" type="password">
        <hr class="hr15">
        <input value="登录" style="width:100%;" type="submit">
        <hr class="hr20">
    </s:form>
</div>

</body>
</html>
