<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>框架整合测试!</h2>
<s:form action="login">
    <s:textfield name="username"/>
    <s:password name="password"/>
    <s:submit value="login"/>
</s:form>
</body>
</html>
