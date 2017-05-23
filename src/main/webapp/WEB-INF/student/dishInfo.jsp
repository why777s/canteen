<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: why777s
  Date: 2017/5/20
  Time: 10:55
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
    <title>餐品查询</title>
</head>
<body>

<blockquote>
    <s:set value="#request.admin" id="ad"/>
    <p> <s:property value="#ad.canteenByCanteenId.canteenCname"/> </p>
</blockquote>


<div class="tabbable" id="tabs-763851"><!-- Only required for left/right tabs -->
    <ul class="nav nav-tabs">
        <li class="active"><a contenteditable="false" data-toggle="tab" href="#panel-8835">一楼</a></li>
        <li ><a contenteditable="false" data-toggle="tab" href="#panel-529442">二楼</a></li>
        <li ><a contenteditable="false" data-toggle="tab" href="#panel-1234">三楼</a></li>
    </ul>

    <div class="tab-content">

        <%--一楼--%>
        <div class="tab-pane active" contenteditable="false" id="panel-8835">
            <s:iterator value="#request.first_windows" id="ff" status="st">
                <s:set name="ff_wid" value="#ff.wid"/>
                <h5> <s:property value="#st.count"/> 号窗口
                    <s:property value="#ff.wname"/>
                </h5>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>名称</th>
                        <th>价格</th>
                    </tr>
                    <s:iterator value="#request.dishes" id="dd">
                        <s:if test="#dd.windowByWid.wid== #ff.wid">
                            <tr>
                                <td width="50%"> <s:property value="#dd.dname"/> </td>
                                <td width="50%"> <s:property value="#dd.dprice"/> </td>
                            </tr>
                        </s:if>
                    </s:iterator>
                </table>
            </s:iterator>
        </div>


        <%-- 二楼 --%>
        <div class="tab-pane " contenteditable="false" id="panel-529442">
            <s:iterator value="#request.second_windows" id="sf" status="st2">
                <h5> <s:property value="#st2.count"/> 号窗口
                    <s:property value="#sf.wname"/>
                </h5>
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>名称</th>
                        <th>价格</th>
                    </tr>
                    <s:iterator value="#request.dishes" id="dd">
                        <s:if test="#dd.windowByWid.wid== #sf.wid">
                            <tr>
                                <td width="50%"> <s:property value="#dd.dname"/> </td>
                                <td width="50%"> <s:property value="#dd.dprice"/> </td>
                            </tr>
                        </s:if>
                    </s:iterator>
                </table>

            </s:iterator>
        </div>

        <div class="tab-pane" contenteditable="false" id="panel-1234" >
            <p>暂无该食堂信息...</p>
        </div>
    </div>
</div>


</body>
</html>