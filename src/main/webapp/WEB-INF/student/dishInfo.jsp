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
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">
    <%--自制样式表--%>
    <link href="<%=basePath%>/bootstrap/css/style.css" rel="stylesheet">

    <title>菜单查询</title>

</head>
<body>
    <div class="content-list" id="outer">
        <%--左菜单--%>
        <div class="list-left" id="tab">
            <li><a style="position: relative;">菜单总览<i class="num"><s:property value="#request.dishsize"/> </i></a></li>
            <s:iterator value="#request.dishList" id="dl">
                <li><a><s:property value="#dl.dname"/></a></li>
            </s:iterator>
        </div>
            <%--右列表--%>
        <div class="list-right" id="content">
            <%--切换tab--%>
            <div class="tabbable" id="tabs-763851"><!-- Only required for left/right tabs -->
                <ul class="nav nav-tabs">
                    <li class="active"><a contenteditable="false" data-toggle="tab" href="#panel-1">一楼</a></li>
                    <li ><a contenteditable="false" data-toggle="tab" href="#panel-2">二楼</a></li>
                </ul>

                <div class="tab-content">
                        <%--一楼--%>
                    <div class="tab-pane active" contenteditable="false" id="panel-1">
                        <ul class="list-pro">
                        <s:iterator value="#request.first_windows" id="ff" status="st">
                        <h5> <s:property value="#st.count"/> 号窗口:<s:property value="#ff.wname"/></h5>
                            <s:iterator value="#request.dishList" id="dd">
                                <s:if test="#dd.wid==#ff.wid">
                                <li>
                                    <a href="#"><img src="<%=basePath%>/bootstrap/img/images/<s:property value="#dd.did"/>.png" class="list-pic"></a>
                                    <div class="shop-list-mid">
                                        <div class="tit"><a href="#"><s:property value="#dd.dname"/></a></div>
                                        <div class="am-gallery-desc"><s:property value="#dd.dprice"/>元</div>
                                    </div>
                                    <div class="list-cart">
                                        <div class="d-stock ">
                                            <a class="decrease">-</a>
                                            <input id="num" readonly="" class="text_box" name="" type="text" value="0">
                                            <a class="increase">+</a>
                                        </div>
                                    </div>
                                </li>
                                </s:if>
                            </s:iterator>
                        </s:iterator>
                        </ul>
                    </div>
                            <%--二楼--%>
                    <div class="tab-pane " contenteditable="false" id="panel-2">
                        <ul class="list-pro">
                            <s:iterator value="#request.second_windows" id="ff" status="st">
                                <h5> <s:property value="#st.count"/> 号窗口:<s:property value="#ff.wname"/></h5>
                                <s:iterator value="#request.dishList" id="dd">
                                    <s:if test="#dd.wid==#ff.wid">
                                        <li>
                                            <a href="#"><img src="<%=basePath%>/bootstrap/img/images/<s:property value="#dd.did"/>.png" class="list-pic"></a>
                                            <div class="shop-list-mid">
                                                <div class="tit"><a href="#"><s:property value="#dd.dname"/></a></div>
                                                <div class="am-gallery-desc"><s:property value="#dd.dprice"/>元</div>
                                            </div>
                                            <div class="list-cart">
                                                <div class="d-stock ">
                                                    <a class="decrease">-</a>
                                                    <input id="num1" readonly="" class="text_box" name="" type="text" value="0">
                                                    <a class="increase">+</a>
                                                </div>
                                            </div>
                                        </li>
                                    </s:if>
                                </s:iterator>
                            </s:iterator>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--不能响应布局，会乱！--%>
    <%--<div class="fix-bot">--%>
        <%--<a href="" class="list-js">合计：<i>0元</i><em>(0份)</em></a>--%>
        <%--<a href="" class="list-jsk">选好了</a>--%>
    <%--</div>--%>


    <%--js--%>
<script>
    <%--数量增减--%>
$(document).ready(function(){
    $('.increase').click(function(){
        var self = $(this);
        var current_num = parseInt(self.siblings('input').val());
        current_num += 1;
        if(current_num>0){
            self.siblings(".decrease").fadeIn();
            self.siblings(".text_box").fadeIn();
        }
        self.siblings('input').val(current_num);
//        update_item(self.siblings('input').data('item-id'));
    })
    $('.decrease').click(function(){
        var self = $(this);
        var current_num = parseInt(self.siblings('input').val());
        if(current_num > 0){
            current_num -= 1;
            if(current_num < 1){
                self.fadeOut();
                self.siblings(".text_box").fadeOut();
            }
            self.siblings('input').val(current_num);
//            update_item(self.siblings('input').data('item-id'));
        }
    })
});
</script>
</body>
</html>


