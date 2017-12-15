<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>音乐分享之家</title>
    <link rel="stylesheet" href="css/uikit.min.css" />
    <link rel="stylesheet" href="css/components/slideshow.css" />
    <link rel="stylesheet" href="css/components/slidenav.css" />
    <link rel="stylesheet" href="css/components/dotnav.css" />
    <link rel="stylesheet" href="css/components/accordion.css" />
    <link rel="stylesheet" href="css/body.css" />

    <script src="js/jquery-1.8.0.min.js"></script>
    <script src="js/uikit.min.js"></script>
    <script src="js/components/accordion.js"></script>
    <script src="js/components/slideshow.js"></script>
    <script src="js/components/slideshow-fx.js"></script>
</head>
<body>
<div class="content">
    <div class="body">

        <%--<s:include value="common/head.jsp"></s:include>--%>
        <%--<%@ include file="head.jsp" %>--%>
            <jsp:include page="common/head.jsp"></jsp:include>

        <div class="uk-navbar-center">
            <div class="uk-slidenav-position" data-uk-slideshow style="text-align: center; margin-top: 30px;">
                <ul class="uk-slideshow" data-uk-slideshow="{kenburns:true}">
                    <li><img src="images/03.jpg" width="200" height="100" alt=""></li>
                    <li><img src="images/02.jpg" width="200" height="100" alt=""></li>
                    <li><img src="images/01.jpg" width="200" height="100" alt=""></li>
                    <li><img src="images/04.jpg" width="200" height="100" alt=""></li>
                </ul>
                <a href="" class="uk-slidenav uk-slidenav-contrast uk-slidenav-previous" data-uk-slideshow-item="previous"></a>
                <a href="" class="uk-slidenav uk-slidenav-contrast uk-slidenav-next" data-uk-slideshow-item="next" ></a>
            </div>
        </div>
        <div class="block" style="max-width: 30%; margin-left: 25%;">
<span class="uk-icon-music">
最新日推歌曲
</span>
        </div>
        <div class="uk-accordion" data-uk-accordion="{collapse: false}" style="max-width: 45%; margin-left: 15%;">

            <h3 class="uk-accordion-title" style="max-width: 45%;"><span class="uk-icon-angle-right" >那天她来听我演唱会</span></h3>
            <div class="uk-accordion-content">
                <div class="uk-panel">
                    撒打算打算打算打算
                </div>
            </div>

            <h3 class="uk-accordion-title" ><span class="uk-icon-angle-right" style="max-width: 45%;">词不达意</span></h3>
            <div class="uk-accordion-content">
                <div class="uk-panel">暖暖的
                </div>
            </div>

            <h3 class="uk-accordion-title"><span class="uk-icon-angle-right" style="max-width: 45%;">..Lobe</span></h3>
            <div class="uk-accordion-content">
                <div class="uk-panel">
                    速度读
                </div>
            </div>
        </div>

        <!--     <div class="uk-panel-badge uk-badge">...</div>
            <h3 class="uk-panel-title">公告</h3>

        </div> -->

        <div class="block">
<span class="uk-icon-fire ">
热门帖子
</span>
        </div>
        <dl class="talk"><li><a href="">撒打算打算</a><span class="uk-icon-user" style="float: right; color: #33CCFF">avril</span></li></dl>
        <dl class="talk"><li><a href="">sadasdas</a><span class="uk-icon-user" style="float: right; color:  #33CCFF">avril</span></li></dl>
        <dl class="talk"><li><a href="">161561616</a><span class="uk-icon-user" style="float: right; color: #33CCFF">avril</span></li></dl>
        <div class="block">
<span class="uk-icon-pencil">
留言板
</span>
            <a href=""><span class="uk-icon-edit" style="float: right;">我要留言</span></a>
        </div>
        <div class="uk-block" style="max-width: 50%; margin-left: auto;margin-right: auto;">
            <div class="uk-panel">
                <div class="uk-panel-badge uk-badge">罗钞</div>
                <h3 class="uk-panel-title">测试一</h3>
                哈哈哈祝biuker越来越好！
            </div>
        </div>
        <div class="uk-block" style="max-width: 50%; margin-left: auto;margin-right: auto;">
            <div class="uk-panel">
                <div class="uk-panel-badge uk-badge">罗钞</div>
                <h3 class="uk-panel-title">测试一</h3>
                哈哈哈祝biuker越来越好！
            </div>
        </div>
    </div>

    <jsp:include page="common/foot.jsp"></jsp:include>

</div>
</body>
</html>