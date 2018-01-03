<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
    <!--
    时间：2017/12/15   17:15
    作者：Fangzq
    功能：注册页面  -->
    <title>注册</title>
    <style type="text/css"></style>
    <link rel="stylesheet" type="text/css" href="../css/register.css"/>
    <script src="/js/jquery-2.1.0.js"></script>
    <script src="/js/register.js"></script>

</head>

<body>
<div id='largeHeader'>
    <canvas id="canvas"></canvas>

    <div class="logo_box">
        <h3>欢迎注册！</h3>
        <form action="register_success.action" method="post" id="registerForm"  >
            <div class="input_outer">
                <span class="reg_name_icon"></span>
                <input name="name" id="name" class="text" style="color: #FFFFFF !important" type="text"
                       placeholder="请输入昵称">
            </div>
            <label id="nameError" class="errorClass"></label>

            <div class="input_outer">
                <span class="reg_pass_icon"></span>
                <input name="password" id="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"
                       value="" type="password" placeholder="请输入3~20位密码">
            </div>
            <label id="passwordError" class="errorClass"></label>


            <div class="input_outer">
                <span class="reg_pass_icon"></span>
                <input name="repassword" id="repassword" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"
                       value="" type="password" placeholder="请再次输入密码">
            </div>
            <label id="repasswordError" class="errorClass"></label>

            <div class="input_outer">
                <span class="reg_phone_icon"></span>
                <input name="account" id="account" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"
                       value="" type="phone" placeholder="请输入手机号">
            </div>
            <label id="accountError" class="errorClass"></label>

            <div class="mb2"><input type="submit" id="submitBtn" value="立即注册" class="submit " style="color: #FFFFFF">
                <%--<a class="act-but submit" href="javascript:;" style="color: #FFFFFF">立即注册</a>--%>
            </div>
            <s:if test="#session.registerStatus == 1"><span>该手机号已被注册</span></s:if>

        </form>


    </div>
    <!--鼠标移动有星星跟随的效果  例子参照星空连线 -->
    <script type="text/javascript" src="../js/animateXingKong/TweenLite.min.js"></script>
    <script src="../js/animateXingKong/EasePack.min.js"></script>
    <script src="../js/animateXingKong/rAF.js"></script>
    <script type="text/javascript" src="../js/star/star.js"></script>
</div>
</body>

</html>