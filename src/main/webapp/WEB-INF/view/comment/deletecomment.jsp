<%--
  Created by IntelliJ IDEA.
  User: la
  Date: 2017/12/28
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>评论删除确认</title>
    <style type="text/css">
        .bt{
            margin-right: 15px;
            height: 28px;
            width: 58px;
            font-size: 14px;
            color: #fff;
            border: 1px solid #2576A8;
            border-radius: 2px;
            background-color:#0080C0;
        }
    </style>
    <script type="text/javascript">
        function toClose() {
            window.parent.location.reload();
//            window.location.reload();
        }
    </script>
</head>
<body>
    <div style="height:200px; width:280px; margin:0 auto;">
        <article>
            <h1 style="text-align:center">删除确认？</h1>
            <p style="text-align:center">确认删除这条评论吗？</p>
        </article>
        <div style="text-align:center">
            <a href=# >
                <input type="button" value="确定" class="bt" style="margin-right: 15px;"
                       onclick="location.href='${pageContext.request.contextPath}/CommentDeleteAction.action?cDelId=<s:property value="cDelId"/>'"/></a>
            <a href="#" onclick="toClose()">
                <input type="button" value="取消" class="bt" style="margin-left: 15px;"/>
            </a>
        </div>
    </div>
</body>
</html>
