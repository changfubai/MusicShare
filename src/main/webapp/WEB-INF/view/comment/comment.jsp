<%--
  Created by IntelliJ IDEA.
  User: la
  Date: 2017/12/20
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <link href="css/commentc.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/uikit.min.css" />
    <link rel="stylesheet" href="css/uikit.css" />
    <link rel="stylesheet" href="layui/css/layui.css" />
    <title>评论</title>
</head>

<body STYLE="margin: 0px; padding: 0px;">
<div style="padding: 0px; margin: 0px; width: 100%; height:100%; background: rgba(168,168,168,0.59) url(/images/bg/m2.jpg) no-repeat;
  background-size: 100% 100%; opacity:0.85;">
<div class="big" style="overflow-y: auto; margin-top: 5px; height:600px;" >
<s:iterator value="commentlist" >
    <div style="width: 100%; height: 20px; "></div>
    <div class="comment">
        <div class="left">
            <%--<img src="images/jikepic1.png" style="height:36px; width:36px"/>--%>
            <img src="<s:property value="user.photo"/>" style="height:36px; width:36px"/>
        </div>
        <div class="right" style="width: 640px;">
            <div><font color="#4A4A97"><span><s:property value="user.name" />回复 <s:property value="uparent.name"/> :</span></font>
            <span><s:property value="content"/> </span></div>
            <div class="time">
                <div style="float: left; width: 94px; height: 14px; overflow: hidden;"><font color="#555555." size="-1"><span><s:property value="comment_time"/></span></font></div>
                <a href="javascript:;" class="uk-icon-hover uk-icon-close del" style="float:left;  height: 14px; width:14px; margin-left: 5px; " title="删除" data-id="<s:property value="id"/>">
                </a>
                <a href="javascript:;" class="uk-icon-hover uk-icon-commenting wcomment" data-id="<s:property value="id" />" style="float: left; height: 14px; width:14px; margin-left: 5px; " title="回复">
                </a>

            </div>
        </div>
    </div>

</s:iterator>
</div>
</div>
</body>
</html>

<script src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['layer','form','jquery'],function(){
        var layer = layui.layer,
            $ = layui.jquery;
        //写评论
        $('.wcomment').on('click',function(){
            var rid = $(this).data('id');
            layer.open({
                type: 2,
                title: ['写评论'],
                content: ["${pageContext.request.contextPath}/CommentWriteAction.action?id="+rid,'no'],
                area:['520px','350px'],  //宽高
                resize: false,    //是否允许拉伸
                scrollbar: false,
                maxmin: true,
                end: function(){
                    location.reload();
                }
            });
        });
        $('.del').on('click',function(){
            var delId = $(this).data('id');
            layer.open({
                type: 2,
                title: ['删除确认'],
                content: ["${pageContext.request.contextPath}/CommentIsDelAction.action"+"?delId="+delId, 'no'],
                area:['280px','200px'],  //宽高
                resize: false,    //是否允许拉伸
                scrollbar: false,
                maxmin: true,
                end: function(){
                    location.reload();
                }
            });
        });
    });

</script>