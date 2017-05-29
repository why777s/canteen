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
    <script src="<%=basePath%>/bootstrap/js/jquery.min.js"></script>

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
                    <%--<s:iterator value="#request.floorList" id="floor" status="st">--%>
                    <li class="active"><a contenteditable="false" data-toggle="tab" href="#panel-1">一楼</a></li>
                    <li ><a contenteditable="false" data-toggle="tab" href="#panel-2">二楼</a></li>
                    <%--<li><a contenteditable="false" data-toggle="tab" href="#panel-%{fid}"><s:property value="#st.count" />楼</a></li>--%>
                    <%--</s:iterator>--%>
                </ul>

                <div class="tab-content">
                        <%--一楼--%>
                    <%--<s:iterator value="#request.floorList" id="floor" status="st">--%>
                    <%--<div class="tab-pane" contenteditable="false" id="panel-<s:property value="#st.count"/>">--%>
                    <div class="tab-pane active" contenteditable="false" id="panel-1">
                        <ul class="list-pro">
                        <s:iterator value="#request.first_windows" id="ff" status="st">
                            <%--<s:if test="#ff.fid==#floor.fid">--%>
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
                                                    <textarea name="content" rows="5" cols="20"></textarea>
                                                    <s:hidden name="cmt_did" value="%{did}"/>
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
                                                <s:hidden class="or_dprice" value="%{dprice}" />
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                </s:if>
                            </s:iterator>
                            <%--</s:if>--%>
                        </s:iterator>
                        </ul>
                    </div>
                    <%--</s:iterator>--%>

                            <div class="tab-pane" contenteditable="false" id="panel-2">
                                <ul class="list-pro">
                                    <s:iterator value="#request.second_windows" id="ff" status="st">
                                            <h5 style="margin-left: 20px"><s:property value="#st.count"/> 号窗口:<s:property value="#ff.wname"/></h5>
                                            <s:iterator value="#request.dishList" id="dd">
                                                <s:if test="#dd.wid==#ff.wid">
                                                    <li>
                                                        <a class="dishcm">
                                                            <img src="<%=basePath%>bootstrap/img/images/<s:property value="#dd.did"/>.png" class="list-pic">
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
                                                                        <textarea name="content" rows="5" cols="20"></textarea>
                                                                        <s:hidden name="cmt_did" value="%{did}"/>
                                                                    </s:form>
                                                                </div>
                                                            </div>

                                                        </div>
                                                        <div class="list-cart">
                                                            <div class="d-stock ">
                                                                <a class="decrease">-</a>
                                                                <input id="num" readonly="" class="text_box" name="" type="text" value="0">
                                                                <a class="increase">+</a>
                                                                    <%--下单用数据,用JSON大法好--%>
                                                                <div class="orderdish" style="display: none;">
                                                                    <s:hidden class="or_did" value="%{did}" />
                                                                    <s:hidden class="or_dname" value="%{dname}" />
                                                                    <s:hidden class="or_dprice" value="%{dprice}" />
                                                                </div>
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

    <div id="orderdiv" style="position:fixed;width:300px;height:auto;padding:5px;background:#333;line-height:20px;color:#FFF;margin-bottom:50px;bottom:0px;left:0px;">
        <span>购物车:</span>
        <button class="btn btn-success" style="float: right" id="senddishorderlist">下单</button>
        <%--<button class="btn btn-success" style="float:right;">清空</button>--%>
        <hr/>
        <form id="orderaction" action="stu_saveorder" method="POST">
<%--<s:     <s:iterator value="#request.dishList" id="dd" status="st">--%>
            <%--<div class="did" style="display: none;">--%>
                <%--<span>dname</span>--%>
                <%--<input readonly="true" class="dnum" name="dishOrderList[0].dnum" value="dnum">--%>
                <%--<input type="hidden" name="dishOrderList[0].did" value="did">--%>
            <%--</div>--%>
        <%--</s:iterator>--%>
            <span>总价：</span>
            <input class="priceinput" readonly="true" name="orderStu.oprice" value="0">元
        </form>
    </div>


<script>

function prependOrder(orderaction,did,dname,dprice,dnum,orderstu_num) {
    var txt1="<div class='div' id='"+did+"'><span>"+dname+"("+dprice+"元)：</span>"+
            "<input readonly='true' class='dnuminput' value=\""+dnum+"\">"+
//            "<input readonly='true' class='dnuminput' name=\"dishOrderList["+orderstu_num+"].dnum\" value=\""+dnum+"\">"+
            "<input type='hidden' class='didinput'  value=\""+did+"\"></div>";
    orderaction.prepend(txt1);
};

$(document).ready(function(){
    var orderstu_price=0;
    var orderstu_num=0;
    var orderdiv=$("#orderdiv");
    var orderaction=$("#orderaction");
    var priceinput=orderaction.children(".priceinput");

    <%--//数量增减--%>
    $('.increase').click(function(){
        var self = $(this);
        var orderdish=self.siblings(".orderdish");
        var did=orderdish.children(".or_did").val();
        var dname=orderdish.children(".or_dname").val();
        var dprice=orderdish.children(".or_dprice").val();
        var dnum = parseInt(self.siblings('input').val());
        dnum += 1;

        if(dnum>0){
            self.siblings(".decrease").fadeIn();
            self.siblings(".text_box").fadeIn();
            if(dnum==1){
                prependOrder(orderaction,did,dname,dprice,dnum,orderstu_num);
                orderaction.find("input").attr("style","width:30px;")
                orderstu_num+=1;
            }else{
                var inputdiv=orderaction.children("#"+did);
                inputdiv.children(".dnuminput").val(dnum);
            }
        }
        orderstu_price+=parseInt(dprice);
        priceinput.val(orderstu_price);
        self.siblings('input').val(dnum);
    });

    $('.decrease').click(function(){
        var self = $(this);
        var orderdish=self.siblings(".orderdish");
        var did=orderdish.children(".or_did").val();
        var dname=orderdish.children(".or_dname").val();
        var dprice=orderdish.children(".or_dprice").val();
        var dnum = parseInt(self.siblings('input').val());
        if(dnum > 0){
            dnum -= 1;
            var inputdiv=orderaction.children("#"+did);
            inputdiv.children(".dnuminput").val(dnum);
            //显示在订单中
            if(dnum < 1){
                self.fadeOut();
                self.siblings(".text_box").fadeOut();
                var inputdiv=orderaction.find("#"+did);
                inputdiv.remove();
            }
            orderstu_price-=parseInt(dprice);
            priceinput.val(orderstu_price);
            self.siblings('input').val(dnum);
        }
    });
    //菜品评论显示
    $(".dishcm").click(function () {
        var self=$(this);
        self.siblings('.shop-list-mid').children('.dishcomment').fadeToggle();
    });

    //点评按钮
    $(".comment").click(function (){
        var self=$(this);
        var dianping=self.siblings('.dianping');
        var form=dianping.children("form");
        if(form.children("textarea").val()!="") {
            form.submit();
            alert("点评成功！");
        }else{
            dianping.fadeToggle();
        }
    });
    //下单按钮
    $("#senddishorderlist").click(function () {
        var dnumList=orderaction.find(".dnuminput");
        var didList=orderaction.find(".didinput");
        for (var i=0;i<dnumList.length;i++){
//            重排name的List
            dnumList.eq(i).attr("name","dishOrderList["+i+"].dnum");
            didList.eq(i).attr("name","dishOrderList["+i+"].did");
        }
        orderaction.submit();
        alert("下单成功！");
    });

    //样式
    orderaction.find("input").attr("style","width:20px;")
});

</script>

</body>
</html>


