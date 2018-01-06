<%--
  Created by IntelliJ IDEA.
  User: la
  Date: 2017/12/25
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <link rel="stylesheet" href="css/commentc.css"/>

    <script type="text/javascript">
        function checkContent(){
            var result = document.getElementById("content").value;

            if(result == null||result.length()<=0  ){
                alert('您未输入,请输入点什么吧!');
                window.parent.location.reload();
                return false;
            }
//            window.parent.location.reload();
            return true;
//            alert(document.getElementById("content").value);
        }

    </script>
    <title>回复</title>
    </head>

    <body>
        <form id="formid" method="post" action="${pageContext.request.contextPath}/CommentWriteToAction.action?wbytrend=<s:property value="wbytrend"/>&repliedId=<s:property value="repliedId"/>"
          onsubmit="return checkContent();">
        <table class="up" border="0" width="100%">
            <tr class="top"><td><textarea name="content"></textarea></td></tr>

            <tr class="bottom">
                <td><a href = "javascript:"
                       <%--onclick="location.href='${pageContext.request.contextPath}/CommentWriteToAction.action?wbytrend=<s:property value="wbytrend"/>&repliedId=<s:property value="repliedId"/>'">--%>>
                    <input type="submit"  class="send" value="发表"/></a></td></tr>
        </table>
    </form>
    </body>
</html>