<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: why777s
  Date: 2017/5/24
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <script src="<%=basePath%>/jQuery/jquery.min.js"></script>
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">


    <script>
        
        function testalert() {
            alert(document.getElementById("qqq").value);
        }

        function testalert2() {
            alert(document.getElementById("caonima").value);
        }
        $.ajax({
            url:'http://localhost:8080/testAjax.action',
            data:{
                a:'aaa',
                s:'woshizuibangde'
//                oid:caonima
            },
            type:'post',
            success:function (data) {
                if(data.message =="true"){
                    alert("成功");
                }else {
                    view(data.msg);
                }
            },
            error:function(){
                alert("异常");
            }
        });

    </script>
    <title>Title</title>
</head>
<body>
<s:set name="ooid" value="1111"/>
<input id="caonima"  value="<s:property value="ooid"/>" >
<br>
oooooo
<br>

<s:property value="ooid"/>

<br>
<p  id="add"> 123</p>
<p class="addd"> 456</p>
<br>

<button onclick="testalert()">啊速度撒</button>
<button onclick="testalert2()">啊速度撒</button>




</body>
</html>
