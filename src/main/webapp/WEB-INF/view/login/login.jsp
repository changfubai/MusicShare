<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>登录</title>
    <style type="text/css" > </style>
    <link rel="stylesheet" type="text/css"   href="../css/login.css" />
    <script src="../js/jquery-2.1.0.js"></script>
    <script src="../js/register.js"></script>
</head>

<body>
<!-- 时间：2017/11/30
     作者:Fangzq
     功能：进入页面
 -->
<!-- 'bg'背景图的div -->
<div id='largeHeader'>
    <canvas id="canvas"></canvas>
    <div class="logo_box">
        <h3>欢迎你！</h3>
        <form action="login_success.action" name="f" method="post">
            <div class="input_outer">
                <span class="u_user"></span>
                <input name="account" id="account" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
            </div>
            <label id="accountError" class="errorClass"></label>


            <div class="input_outer">
                <span class="us_uer"></span>
                <input name="password" id="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="" type="password" placeholder="请输入密码">
            </div>
            <label id="passwordError" class="errorClass"></label>
            <%--<div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF">登录</a></div>--%>
            <div class="mb2"><input type="submit" value="登录" class="submit " style="color: #FFFFFF"></div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="../js/animateXingKong/TweenLite.min.js"></script>
<script src="../js/animateXingKong/EasePack.min.js"></script>
<script src="../js/animateXingKong/rAF.js"></script>
<script type="text/javascript" src="../js/animateXingKong/xingkong.js"></script>

</html>