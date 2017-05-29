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
    <script src="<%=basePath%>/jQuery/jquery.min.js"></script>
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">


    <script>
        var aj = $.ajax({
            url:'http://localhost:8080/testAjax.action',
            data:{
                oid:$('#name').val()
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



    <title>订单信息</title>
</head>
<body>

<table class="table table-hover table-bordered">
    <tr class="success">
        <th>订单id</th>
        <th>订单总价</th>
        <th>下单时间</th>
        <th>操作</th>
        <th>订单详情</th>
    </tr>
    <s:iterator status="st" value="#request.orderstuList" id="osl">

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
        <td> <s:property value="#osl.oid"/> </td>
        <td><s:property value="#osl.oprice"/>元</td>
        <td> <s:property value="#osl.orderTime"/></td>
        <td width="15%"> <button class="btn btn-success">查看详情</button> </td>
        <td>
        <%--隐藏订单详情--%>
            <div id="light" class="white_content" >
                <table class="table table-hover table-bordered">
                    <tr class="success">
                        <th>菜名</th>
                        <th>单价</th>
                        <th>数量</th>
                    </tr>
                    <s:iterator value="#request.dishOrderList_look" id="dol">
                    <s:if test="#dol.oid==#osl.oid">
                        <tr>
                            <td><s:property value="#dol.dishByDid.dname"/></td>
                            <td><s:property value="#dol.dishByDid.dprice"/>元</td>
                            <td><s:property value="#dol.dnum"/></td>
                        </tr>
                    </s:if>
                    </s:iterator>
                </table>
                <%--<script>--%>
                    <%--$(document).ready(function(){--%>
                        <%--$("#close,#fade").click(function(){--%>
                            <%--$("#light").hide();--%>
                            <%--$("#fade").hide();--%>
                        <%--});--%>
                    <%--});--%>
                <%--</script>--%>
            </div>

        </td>
        </tr>
    </s:iterator>
</table>


</body>
</html>