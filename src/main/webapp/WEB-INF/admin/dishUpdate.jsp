<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: why777s
  Date: 2017/5/20
  Time: 23:38
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

    <script>
        <s:if test="#request.message!=null">
            alert("<s:property value="#request.message"/>");
        </s:if>
    </script>

    <title>Title</title>
</head>
<body>


<blockquote>
    <s:set value="#request.admin" id="ad"/>
    <p> <s:property value="#ad.canteenByCanteenId.canteenCname"/> </p>
</blockquote>


<div class="tabbable" id="tabs-763851"><!-- Only required for left/right tabs -->
    <ul class="nav nav-tabs">
        <li class="active"><a contenteditable="false" data-toggle="tab" href="#yilou">一楼</a></li>
        <li ><a contenteditable="false" data-toggle="tab" href="#erlou">二楼</a></li>
        <li ><a contenteditable="false" data-toggle="tab" href="#error">三楼</a></li>

        <%--<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown">嘿嘿嘿<span class="caret"></span></a>--%>
            <%--<ul class="dropdown-menu">--%>
                <%--<s:iterator value="#request.second_windows" id="sw" status="st2">--%>
                    <%--<li>--%>
                        <%--<a data-toggle="tab" href="<s:url action="turn_dishUpdate">--%>
                                <%--<s:param name="ad_downmenu_wid"  value="%{wid}"/>--%>
                                     <%--</s:url>">--%>

                            <%--<s:property value="#st2.count"/>号窗口--%>
                            <%--<s:property value="#sw.wname"/>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</s:iterator>--%>
            <%--</ul>--%>
        <%--</li>--%>
    </ul>

    <div class="tab-content">
        <%--一楼--%>
        <div class="tab-pane active" style="min-height: 100%" contenteditable="false" id="yilou">
                <div class="dropdown">
                    <button class="btn btn-success" type="button"  data-toggle="dropdown">请选择要修改的窗口<span class="caret"></span></button>
                    <ul class="dropdown-menu" style="min-height: 100%">
                        <s:iterator value="#request.first_windows" id="fw">
                            <li>
                                <a href="<s:url action="turn_dishUpdate">
                                <s:param name="ad_downmenu_wid"  value="%{wid}"/>
                                     </s:url>">
                                    <s:property value="#fw.wname"/>
                                </a>
                            </li>
                        </s:iterator>
                    </ul>
                </div>

            <br>
            <s:property value="#request.windowByWid.wname"/>
            <br>
            <br>
            <s:form theme="simple" action="dish_update">
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>名称</th>
                        <th>价格</th>
                    </tr>
                    <s:iterator value="#request.dishes" id="dd" status="stst">
                        <s:if test="#dd.windowByWid.wid== ad_downmenu_wid">
                            <s:if test="#stst.getCount()%4==0">
                                <tr class="success">
                            </s:if>
                            <s:elseif test="#stst.getCount()%4==1">
                                <tr class="error">
                            </s:elseif>
                            <s:elseif test="#stst.getCount()%4==2">
                                <tr class="warning">
                            </s:elseif>
                            <s:elseif test="#stst.getCount()%4==3">
                                <tr class="info">
                            </s:elseif>
                                 <td>
                                     <s:textfield name="changed_dnames" value="%{dname}"/>
                                     <s:hidden name="dids" value="%{did}"/>
                                 </td>
                                <td> <s:textfield name="changed_dprices" value="%{dprice}"/> </td>
                            </tr>
                        </s:if>
                    </s:iterator>
                </table>
                <br>
                <s:submit class="btn btn-success" value="保存"/>
            </s:form>
        </div>


        <%-- 二楼 --%>
            <div class="tab-pane active" style="min-height: 100%" contenteditable="false" id="erlou">
                <div class="dropdown">
                    <button class="btn btn-success" type="button"  data-toggle="dropdown">2请选择要修改的窗口<span class="caret"></span></button>
                    <ul class="dropdown-menu" style="min-height: 100%">
                        <s:iterator value="#request.second_windows" id="sw">
                            <li>
                                <a href="<s:url action="turn_dishUpdate">
                                <s:param name="ad_downmenu_wid"  value="%{wid}"/>
                                     </s:url>">
                                    <s:property value="#sw.wname"/>
                                </a>
                            </li>
                        </s:iterator>
                    </ul>
                </div>

                <br>
                <s:property value="#request.windowByWid.wname"/>
                <br>
                <br>
                <s:form theme="simple" action="dish_update">
                    <table class="table table-hover table-bordered">
                        <tr>
                            <th>名称</th>
                            <th>价格</th>
                        </tr>
                        <s:iterator value="#request.dishes" id="dd" status="stst">
                            <s:if test="#dd.windowByWid.wid== ad_downmenu_wid">
                                <s:if test="#stst.getCount()%4==0">
                                    <tr class="success">
                                </s:if>
                                <s:elseif test="#stst.getCount()%4==1">
                                    <tr class="error">
                                </s:elseif>
                                <s:elseif test="#stst.getCount()%4==2">
                                    <tr class="warning">
                                </s:elseif>
                                <s:elseif test="#stst.getCount()%4==3">
                                    <tr class="info">
                                </s:elseif>
                                <td>
                                    <s:textfield name="changed_dnames" value="%{dname}"/>
                                    <s:hidden name="dids" value="%{did}"/>
                                </td>
                                <td> <s:textfield name="changed_dprices" value="%{dprice}"/> </td>
                                </tr>
                            </s:if>
                        </s:iterator>
                    </table>
                    <br>
                    <s:submit class="btn btn-success" value="保存"/>
                </s:form>
            </div>

        <div class="tab-pane" contenteditable="false" id="error" >
            <p>暂无该食堂信息...</p>

        </div>
x


    </div>

</div>


</body>
</html>
