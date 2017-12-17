<%--
  Created by IntelliJ IDEA.
  User: luochao
  Date: 2017/12/1
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="css/uikit.min.css" />
<link rel="stylesheet" href="css/uikit.css" />
<link rel="stylesheet" href="css/forumcss.css" />
<div class="header">
    <nav class="uk-navbar forumnav" style="margin-bottom: 0px;">
        <a href="default.action" class="uk-navbar-brand flogo"><i class="uk-icon-codepen uk-link-muted uk-h2"></i><span class="uk-h2" >音乐分享之家</span></a>
        <a href="${pageContext.request.contextPath}/Trends_trendsList.action" class="uk-navbar-brand uk-active">动态</a>
        <a href="${pageContext.request.contextPath}/Trends_mytrendsList.action" class="uk-navbar-brand uk-active">我的动态</a>
        <a href="${pageContext.request.contextPath}/Trends_findTrendsById.action" class="uk-navbar-brand uk-active">编辑</a>
        <span style="float: right; margin-right: 50px;">
    <a href="${pageContext.request.contextPath}/Login_login2.action" class="uk-navbar-brand" >登陆</a>
    <a href="${pageContext.request.contextPath}/Login_regest.action" class="uk-navbar-brand">注册</a>
     </span>
    </nav>
</div>