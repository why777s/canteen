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
                            <h5 style="margin-left: 20px"><s:property value="#st.count"/> 号窗口:<s:property value="#ff.wname"/></h5>
                            <s:iterator value="#request.dishList" id="dd">
                                <s:if test="#dd.wid==#ff.wid">
                                <li>
                                    <a class="dishcm">
                                        <img src="<%=basePath%>/bootstrap/img/images/<s:property value="#dd.did"/>.png" class="list-pic">
                                    </a>
                                    <div class="shop-list-mid">
                                        <%--简介区--%>
                                        <div class="tit"><a><s:property value="#dd.dname"/></a></div>
                                        <div class="am-gallery-desc"><s:property value="#dd.dprice"/>元</div>

                                        <%--评论查看区--%>
                                        <div class="dishcomment" style="display:none;margin-top: 5px;"><dl>
                                            <h5>评论:</h5>
                                            <s:iterator value="#request.dish_commentList" id="dcl">
                                                <s:if test="#dcl.did==#dd.did">
                                                <dt>用户:<s:property value="#dcl.studentBySid.sname"/></dt>
                                                <dd><s:property value="#dcl.commentContent"/> </dd>
                                                </s:if>
                                            </s:iterator>
                                        </dl></div>

                                        <%--点评区--%>
                                        <div>
                                            <a class="comment">我要吐槽！</a>
                                            <div class="dianping"  style="display: none;">
                                                <s:form action="stu_savecomment" theme="simple" method="POST">
                                                    <%--<s:textarea name="content"/>--%>
                                                    <textarea name="content" rows="5" cols="20"></textarea>
                                                    <s:hidden name="cmt_did" value="%{did}"/>
                                                    <%--<button class="btn btn-success" class="comment" type="submit">点评</button>--%>
                                                </s:form>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="list-cart">
                                        <div class="d-stock ">
                                            <a class="decrease">-</a>
                                            <input id="num" readonly="" class="text_box" name="" type="text" value="0">
                                            <a class="increase">+</a>
                                            <%--下单用数据--%>
                                            <div class="orderdish" style="display: none;">
                                                    <s:hidden class="or_did" value="%{did}" />
                                                    <s:hidden class="or_dname" value="%{dname}" />
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                </s:if>
                            </s:iterator>
                        </s:iterator>
                        </ul>
                    </div>
                            <%--&lt;%&ndash;二楼&ndash;%&gt;--%>
                    <%--<div class="tab-pane " contenteditable="false" id="panel-2">--%>
                        <%--<ul class="list-pro">--%>
                            <%--<s:iterator value="#request.second_windows" id="ff" status="st">--%>
                                <%--<h5 style="margin-left: 20px"> <s:property value="#st.count"/> 号窗口:<s:property value="#ff.wname"/></h5>--%>
                                <%--<s:iterator value="#request.dishList" id="dd">--%>
                                    <%--<s:if test="#dd.wid==#ff.wid">--%>
                                        <%--<li>--%>
                                            <%--<a class="dishcm"><img src="<%=basePath%>/bootstrap/img/images/<s:property value="#dd.did"/>.png" class="list-pic"></a>--%>
                                            <%--<div class="shop-list-mid">--%>
                                                <%--<div class="tit"><a><s:property value="#dd.dname"/></a></div>--%>
                                                <%--<div class="am-gallery-desc"><s:property value="#dd.dprice"/>元</div>--%>
                                            <%--</div>--%>
                                            <%--&lt;%&ndash;评论区&ndash;%&gt;--%>
                                            <%--<div class="dishcomment" style="display:none;margin-top: 5px;"><dl>--%>
                                                <%--<dt>--%>
                                                    <%--评论:--%>
                                                <%--</dt>--%>
                                                <%--<s:iterator value="#request.dish_commentList" id="dcl">--%>
                                                    <%--<s:if test="#dcl.did==#dd.did">--%>
                                                        <%--<dt>用户:<s:property value="#dcl.studentBySid.sname"/></dt>--%>
                                                        <%--<dd><s:property value="#dcl.commentContent"/> </dd>--%>
                                                    <%--</s:if>--%>
                                                <%--</s:iterator>--%>
                                            <%--</dl></div>--%>
                                            <%--<div class="list-cart">--%>
                                                <%--<div class="d-stock ">--%>
                                                    <%--<a class="decrease">-</a>--%>
                                                    <%--<input id="num1" readonly="" class="text_box" name="" type="text" value="0">--%>
                                                    <%--<a class="increase">+</a>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                        <%--</li>--%>
                                    <%--</s:if>--%>
                                <%--</s:iterator>--%>
                            <%--</s:iterator>--%>
                        <%--</ul>--%>
                    <%--</div>--%>

                </div>
            </div>
        </div>
    </div>

    <%--<div class="fix-bot">--%>
        <%--<a href="" class="list-js">合计：<i>0元</i><em>(0份)</em></a>--%>
        <%--<a href="" class="list-jsk">选好了</a>--%>
    <%--</div>--%>

    <%--js调试信息输出位置--%>
    <script type="text/javascript">
        function order_msg() {
            var orderdiv = document.createElement('div');
            orderdiv.id = "orderdiv";
            orderdiv.setAttribute('style','position:fixed;width:300px;height:auto;padding:5px;background:#333;line-height:20px;color:#FFF;margin-top:0px;top:0px;right:0px;');
            orderdiv.innerHTML="Dish List:";
            document.body.appendChild(orderdiv);
        }
        order_msg();
    </script>
    <%--js--%>
<script>
$(document).ready(function(){
    var price_sum;
    var num_sum;
    var orderdiv=$("#orderdiv");
    //数量增减
    $('.increase').click(function(){
        var self = $(this);
        var orderdish=self.siblings(".orderdish");
        var did=orderdish.children(".or_did").val();
        var dname=orderdish.children(".or_dname").val();
        var current_num = parseInt(self.siblings('input').val());
        current_num += 1;
        if(current_num>0){
            self.siblings(".decrease").fadeIn();
            self.siblings(".text_box").fadeIn();
            //显示在订单中
            orderdiv.find("."+did).remove();
            orderdiv.append("<p class=\""+ did + "\">"+dname+","+current_num+"</p>");
        }
        self.siblings('input').val(current_num);
    });
    $('.decrease').click(function(){
        var self = $(this);
        var orderdish=self.siblings(".orderdish");
        var did=orderdish.children(".or_did").val();
        var dname=orderdish.children(".or_dname").val();
        var current_num = parseInt(self.siblings('input').val());
        if(current_num > 0){
            current_num -= 1;
            //显示在订单中
            orderdiv.find("."+did).remove();
            orderdiv.append("<p class=\""+ did + "\">"+dname+","+current_num+"</p>");
            if(current_num < 1){
                self.fadeOut();
                self.siblings(".text_box").fadeOut();
                orderdiv.find("."+did).remove();
            }
            self.siblings('input').val(current_num);
        }
    });
    //评论查看显示
    $(".dishcm").click(function () {
        var self=$(this);
        self.siblings('.shop-list-mid').children('.dishcomment').fadeToggle();
    });
    //点评
    $(".comment").click(function (){
        var self=$(this);
        var dianping=self.siblings('.dianping');
        var form=dianping.children("form");
        if(form.children("textarea").val()!="") {
            form.submit();
        }else{
            dianping.fadeToggle();
        }
    });
});



</script>
</body>
</html>


