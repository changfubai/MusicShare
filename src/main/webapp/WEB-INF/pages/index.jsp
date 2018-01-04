<!--
时间:2017/12/5 9:01
作者：Fangzq
功能:主页展示
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%@page import="javax.servlet.*" %>
<%@page import="javax.servlet.http.*" %>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set var="context_path"
       value="#request.get('javax.servlet.forward.context_path')"></s:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Index</title>
    <%--butong--%>
    <script src="/js/jquery-2.1.0.js"></script>
    <script src="/js/uikit.js"></script>
    <script src="js/circle/Thetrends.js"></script>
    <script src="/layui/layui.js"></script>
    <script src="/js/circle/dateFormat.js"></script>
    <script src="/js/circle/circle.js"></script>
    <link rel="stylesheet" href="/css/uikit.css" />
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/circle/circle_all.css"/>

    <script type="text/javascript"  src="/js/circle/handleCircle.js"></script>
    <script type="text/javascript"  src="/js/circle/main.js"></script>
    <%--butong--%>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="/css/slider.css">
    <script type="text/javascript" src='/js/bootstrap.min.js'></script>
    <script type="text/javascript"  src="/js/slider.js"></script>

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
            margin: 0 auto;
            /* 蓝色 */
        }
        .current {
            background-color: #F00;
        }
        .version {
            background-color: #f9f9f9;
        }
        .versioniv {
            width: 1226px;
            position: relative;
            overflow: hidden;
            margin: 0 auto;
        }
        .versiontitle {
            margin: 0;
            font-size: 22px;
            font-weight: 200;
            line-height: 58px;
            color: #333;
        }
        .title {
            color: #333;
            margin: 0 10px;
            font-size: 14px;
            font-weight: 400;
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            var aDiv = $('.tabContent table');
            $(aDiv).mouseover(function () {
                //  alert("1");
                $(this).css("height", "340");
                $(this).css('box-shadow', "2px 3px 5px #999");
                //$(this).addClass('current');
            }).mouseout(function () {
                $(this).css("height", "330");
                $(this).css('box-shadow', "2px 3px 5px #FFF");
                // $(this).removeClass('current');
            });
        });
    </script>
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
                                <li><a href="#" id="bt_initial">首页</a></li>
                                <li><a href="#">分享</a></li>
                                <li>
                                    <a href="#" id="bt_trends">动态</a>
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
                                        <s:if test='#session.user=="" || #session.user == null'>
                                            <li><a href="login_page.action">登陆</a></li>
                                            <li><a href="register_page.action">注册</a></li>
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
                <li><img src="/images/index/lb1.jpg"></li>
                <li><img src="/images/index/lb2.jpg"></li>
                <li><img src="/images/index/lb3.jpg"></li>
                <li><img src="/images/index/lb4.jpg"></li>
                <li><img src="/images/index/lb5.jpg"></li>
                <li><img src="/images/index/lb6.jpg"></li>
                <li><img src="/images/index/lb7.jpg"></li>
                <li><img src="/images/index/lb8.jpg"></li>
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
<%
    String[] infoList = (String[]) session.getAttribute("info");
    for (String str : infoList) {
        if (str != null) {
            String[] str1 = str.split("#"); //得到类别
            System.out.println("类别:" + str1[0]);
%>
<div id="circle">
    <div id="myCircle">
    </div>
</div>
<%--<div id="trends">--%>
    <%--<div id="trendslist">--%>

    <%--</div>--%>
<%--</div>--%>
<%--<div id="mytrends">--%>
<%--</div>--%>
<%--<div id="mycollecttrends">--%>
<%--</div>--%>
<div class="version">
    <div class="versioniv">

        <table>
            <tr>
                <td><p class="versiontitle"><%=str1[0]%>
                </p></td>
            </tr>
            <%
                int count = 1;
                String[] str2 = str1[1].split(";"); //得到一组信息
                for (int j = 0; j < str2.length; j++) {
                    String[] str3 = str2[j].split(",");//
                    System.out.println("商品ID：" + str3[0] + " 名字:" + str3[1] + " 照片:" + str3[2]);
                    request.setAttribute("id", str3[0]);
                    //	if ((k+5) % 4 == 1) {
                    if (count % 4 == 1) {
            %>
            <tr>
                <%
                    }
                %>

                <td width="330" height="350">
                    <div class="tabContent">
                        <table id="<%=str3[0]%>" style="background-color: #FFF"
                               width="280" height="330">
                            <tr>
                                <td align="center">
                                    <s:a>
                                        <img src="${context_path}<%=str3[2]%>" width="180" height="180">
                                        <s:param name="id" value="#request.id"></s:param>
                                    </s:a></td>
                            </tr>
                            <tr>
                                <td><h3 class="title"><%=str3[1]%>
                                </h3></td>
                            </tr>
                            <%--<tr>--%>
                            <%--<td><p class="desc"><%=str3[3]%></p></td>--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                            <%--<td><p class="price">--%>
                            <%--<span class="num"><%=str3[2]%></span>元--%>
                            <%--</p></td>--%>
                            <%--</tr>--%>

                        </table>
                    </div>

                </td>
                <%
                    if (count % 4 == 0) {
                %>
            </tr>
            <%
                            }
                            count++;
                        }
                    }
                    //System.out.println("session传递过来的数组:" + infoList[i] + "i=:" + i);
                }
            %>


        </table>
    </div>
</div>


<div class="site-footer">
    <div class="container">

        <table width="100%">
            <tr>

                <td>
                    <table width="100%" class="desc">
                        <tr>
                            <td>©mi.com 京ICP证110507号 京ICP备10046444号
                                京公网安备11010802020134号 京网文[2014]0059-0009号
                            </td>
                        </tr>
                        <tr>
                            <td>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>


</body>

</html>