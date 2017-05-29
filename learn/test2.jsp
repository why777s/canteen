<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: why777s
  Date: 2017/5/26
  Time: 15:24
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

    <title>Title</title>

    <script type="text/javascript">
        $(document).ready(function() {
            function getStatus() {
                var rate = document.getElementById("rate").value;
                $.ajax({
                    url : '/test/testAjax.action',
                    type : 'POST',
                    data : {
                        rate : rate
                    },
                    dataType : 'json',
                    success : function(data) {
                        $("#allUser").append("输出了：iad:" + data.result);
                        if (data.result == "FINISH"){
                            alert("请取餐");
                            clearInterval(timer);
                        }
                    }
                });
            }
            var timer = setInterval(getStatus,5000);
        });
    </script>

</head>
<body>
<s:hidden id="rate" value="1"/>

<div>
    <input id="btn" type="button" value="提交" />
</div>
<div id="allUser">input_user:</div>


</body>
</html>
