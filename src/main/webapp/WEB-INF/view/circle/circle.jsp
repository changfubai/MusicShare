<%--
  Created by IntelliJ IDEA.
  User: changfubai
  Date: 2017/12/27
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
</head>

<body class="tm-background">
<div class="tm-middle">
    <div class="uk-container uk-container-center">
        <div class="uk-grid" data-uk-grid-margin>

            <h1 class="uk-article-title">我创建的圈子</h1>
            <span class="gap"></span>
            <span href="javascript:;" class="layui-btn layui-btn-radius layui-btn-normal createCircle">
                <i class="layui-icon">&#xe608;</i> 创建圈子
            </span>
            <div class="uk-width-1-1 uk-margin uk-clearfix">
                <div class="uk-grid uk-grid-match uk-grid-width-1-1 uk-grid-width-medium-1-3 " data-uk-grid-margin>
                    <s:iterator value="#session.circleList" var="e" status='st'>
                        <div class="uk-animation-scale-down uk-animation-10">
                            <div class="uk-panel uk-panel-box uk-animation-slide-bottom uk-animation-10
                            <s:if test="#st.index % 3 == 1 ">
                            uk-panel-box-primary</s:if>">
                                <h2 class="uk-panel-title getAll" data-id="<s:property value="#e.id"/>" style="cursor:hand"><s:property value="#e.name"/></h2>
                                <span href="javascript:;" data-id="<s:property value="#e.id"/>" class="layui-btn layui-btn-radius layui-btn-mini uk-position-top-right dissolveCircle">
                                    <a class="uk-icon-justify uk-icon-times"></a>解散
                                </span>
                                <h4 class="uk-navbar-nav-subtitle"><s:date format="yyyy-MM-dd" name="#e.createTime"/></h4>
                                <s:property value="#e.description"/>
                            </div>
                        </div>
                    </s:iterator>
                </div>
            </div>

        </div>

        <div class="uk-grid" data-uk-grid-margin>

            <h1 class="uk-article-title">我加入的圈子</h1>
            <span class="gap"></span>
            <div class="uk-width-1-1 uk-margin uk-clearfix">
                <div class="uk-grid uk-grid-match uk-grid-width-1-1 uk-grid-width-medium-1-3 " data-uk-grid-margin>
                    <s:iterator value="#session.circlesList" var="e" status='st'>
                        <div class="uk-animation-scale-down uk-animation-10">
                            <div class="uk-panel uk-panel-box uk-animation-slide-bottom uk-animation-10
                            <s:if test="#st.index % 3 == 1 ">
                            uk-panel-box-primary</s:if>">
                                <h2 class="uk-panel-title getAll" data-id="<s:property value="#e.circleId"/>" style="cursor:hand"><s:property value="#e.name"/></h2>
                                <span href="javascript:;" data-id="<s:property value="#e.id"/>" class="layui-btn layui-btn-radius layui-btn-mini uk-position-top-right quitCircle">
                                    <a class="uk-icon-justify uk-icon-times"></a>退出
                                </span>
                                <h4 class="uk-navbar-nav-subtitle">创建时间<s:date format="yyyy-MM-dd" name="#e.createTime"/></h4>
                                <h4 class="uk-navbar-nav-subtitle">加入时间<s:date format="yyyy-MM-dd" name="#e.joinTime"/></h4>
                                <s:property value="#e.desc"/>
                            </div>
                        </div>
                    </s:iterator>
                </div>
            </div>
        </div>

        <div class="uk-grid" data-uk-grid-margin>
            <h1 class="uk-article-title">有更多小伙伴在这里哟~~</h1>
            <span class="gap"></span>
            <form class="layui-form" action="#" id="search">
                <input type="text" name="name" required lay-verify="required" placeholder="Search here...">
                <button type="submit" lay-submit lay-filter="search">
                    search
                </button>
            </form>
            <div class="uk-width-1-1 uk-margin uk-clearfix">
                <div id="searchResult" class="uk-grid uk-grid-match uk-grid-width-1-1 uk-grid-width-medium-1-3 " data-uk-grid-margin>
                    <s:if test="#session.fCirclesList == null"><h1>哇，所有的圈子都被你涉足啦@！！@</h1></s:if>
                    <s:iterator value="#session.fCirclesList" var="e" status='st'>
                        <div class="uk-animation-scale-down uk-animation-10">
                            <div class="uk-panel uk-panel-box uk-animation-slide-bottom uk-animation-10
                            <s:if test="#st.index % 3 == 1 ">
                            uk-panel-box-primary</s:if>">
                                <h2 class="uk-panel-title getAll" data-id="<s:property value="#e.id"/>" style="cursor:hand"><s:property value="#e.name"/></h2>
                                <span href="javascript:;" data-id="<s:property value="#e.id"/>" class="layui-btn layui-btn-radius layui-btn-mini uk-position-top-right joinCircle">
                                    <i class="layui-icon">&#xe608;</i>加入
                                </span>
                                <h4 class="uk-navbar-nav-subtitle">创建于<s:date format="yyyy-MM-dd" name="#e.createTime"/></h4>
                                <s:property value="#e.description"/>
                            </div>
                        </div>
                    </s:iterator>
                </div>
            </div>
        </div>

    </div>
</div>


</body>
</html>
