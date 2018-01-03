<!-- 
        时间:2017/12/5 9:01
        作者：Fangzq
        功能:主页展示

     -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>

<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
     <link rel="stylesheet" type="text/css" href="../css/slider.css">
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <script src="/js/jquery-2.1.0.js"></script>
    <script type="text/javascript" src='../js/bootstrap.min.js'></script>
    <script type="text/javascript"  src="../js/slider.js"></script>
    <script src="/layui/layui.js"></script>
    <script type="text/javascript"  src="/js/circle/handleCircle.js"></script>
    <script type="text/javascript"  src="/js/circle/main.js"></script>
    <script src="/js/uikit.js"></script>
    <script src="/js/components/grid-parallax.js"></script>
    <script src="/js/circle/circle.js"></script>
    <link rel="stylesheet" href="/css/uikit.css" />
    <style type="text/css">
    #navId {
        width: 1100px;
        height: 50px;
        margin: 0 auto;
        font-size: 16px;
    }

    #switcher {
        width: 100%;
        height: 336px;
        margin-top: 50px;
        background-color: #000000;
        /* 粉色*/
        /*#000000  黑色  #fffff白色 */
    }

    #switcherId {
        width: 730px;
        height: 100%;
        margin: 0 auto background-color:#D0ECEF;
        /* 蓝色 */
    }
    </style>
</head>

<body>
    <!-- 时间:2017/12/16  9:02
         功能：导航栏
         试了一上午得出一个结论还是自己写吧，嘤嘤.....
     -->
    <!-- 导航栏 -->

    <nav class="navbar-inverse navbar-fixed-top my-navbar" role="navigation" style="height: 50px">
        <div class="container-fluid" id='navId'>
            <table style="width: 100%">
                <tr>
                    <td>
                        <div class="collapse navbar-collapse " id="example-navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="#">首页</a></li>
                                <li><a href="#">分享</a></li>
                                <li>
                                    <a href="#">动态</a>
                                </li>
                                <li>
                                    <a href="#" id="bt_circle">圈子</a>
                                </li>
                                <li>
                                    <a href="#">最新</a>
                                </li>
                            </ul>
                        </div>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td>
                                    <form class="navbar-form" id="navFormId">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="音乐/动态">
                                        </div>
                                        <button type="submit" class="btn btn-default">搜索</button>
                                    </form>
                                </td>
                                <td>
                                    <ul class="nav navbar-nav">
                                        <div id="user_id" style="display:none">${user.id}</div>
                                        <s:if test="#session.user.username==null">
                                            <li><a href="Login_register.action">注册</a></li>
                                            <li><a href="Login_login.action">登录</a></li>
                                        </s:if>
                                        <s:else>
                                            <a href= >已登录</a>
                                        </s:else>
                                    </ul>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </nav>

    <!--功能：图片轮播
        设计想法：一个大的div中一个小的div(存放图片),图片轮转时，大div的背景颜色跟图片颜色一样。
        参考：网易云音乐
        时间：2017/12/16 15：:4
        作者：Fangzq

    -->
    <div id="switcher">
        <div class="container-fluid" id='switcherId'>
            <div class="wrap">
                <ul>
                    <li><img src="../images/index/lb1.jpg" ></li>
                    <li><img src="../images/index/lb2.jpg" ></li>
                    <li><img src="../images/index/lb3.jpg" ></li>
                    <li><img src="../images/index/lb4.jpg" ></li>
                    <li><img src="../images/index/lb5.jpg" ></li>
                    <li><img src="../images/index/lb6.jpg" ></li>
                    <li><img src="../images/index/lb7.jpg" ></li>
                    <li><img src="../images/index/lb8.jpg" ></li>
                </ul>
                <ol>
                    <li class="current"></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ol>
            </div>
        </div>
    </div>

    <div id="circle">
        <div id="myCircle">

        </div>
    </div>
</body>


</html>
