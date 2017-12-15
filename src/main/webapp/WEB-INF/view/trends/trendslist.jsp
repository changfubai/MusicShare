<%--
  Created by IntelliJ IDEA.
  User: luochao
  Date: 2017/12/7
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>动态</title>
    <link rel="stylesheet" href="css/uikit.min.css" />
    <link rel="stylesheet" href="layui/css/layui.css" />
    <link rel="stylesheet" href="css/uikit.css" />
    <link rel="stylesheet" href="css/login.css" />


    <link rel="stylesheet" href="css/uikit.min.css" />
    <link rel="stylesheet" href="css/uikit.css" />
    <link rel="stylesheet" href="css/forumcss.css" />


    <link rel="stylesheet" href="css/uikit.min.css" />
    <link rel="stylesheet" href="css/uikit.css" />
    <link rel="stylesheet" href="css/forumcss.css" />
    <style>
        img {
            width: auto;
            height: 30px;
            box-sizing: border-box;
            border: 0px solid ;
        }
    </style>
    <script src="js/jquery-1.8.0.min.js"></script>
    <script src="js/uikit.min.js"></script>
</head>
<body>
<a href="default.action" class="uk-navbar-brand flogo"><i class="uk-icon-codepen uk-link-muted uk-h2"></i><span class="uk-h2" >音乐分享之家</span></a>
<div class="loginmain">
    <div class="lm">
        <ul class="uk-tab" data-uk-tab>
            <li class="uk-active"><a href="">所有动态</a></li>
            <li><a href=# onclick="location.href='${pageContext.request.contextPath}/Trends_mytrendsList.action'">我的动态</a></li>
            <li><a href=# onclick="location.href='${pageContext.request.contextPath}/Trends_collectTrends.action'">收藏动态</a></li>
        </ul>
        <div class="lu">
            <button class="layui-btn layui-btn-normal" style="float: right;margin-right: 10px;" id="pushBtn">
                <i class="layui-icon">&#xe608;</i> 发布动态
            </button>
    <s:iterator value="list" var="e">
            <li>
                <article class="uk-comment">
                    <header class="uk-comment-header">
                        <img class="uk-comment-avatar" src="images/02.jpg" alt="" style="width:70px; height:70px; border-radius:50%; overflow:hidden;">
                        <h4 class="uk-comment-title"><s:property value="#e.id"/></h4>
                        <div class="uk-comment-meta"><s:date name="#e.update_time" format="yyyy-MM-dd"/></div>
                    </header>
                    <div class="uk-comment-body">
                               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property escapeHtml="false" value="#e.content"/>
                    </div>
                    <a href="javascript:;" class="uk-icon-hover uk-icon-heart-o collect" data-id="<s:property value="#e.id"/>" data-userid="<s:property value="2"/>" style="float: right; margin-right: 10px; margin-top: 20px;" title="点击收藏"></a>
                    <a href="javascript:;" class="uk-icon-hover uk-icon-thumbs-o-up thumb" data-id="<s:property value="#e.id"/>" style="float: right; margin-right: 15px; margin-top: 20px;" title="已被点赞数"><s:property value="#e.star"/></a>
                    <a href="" class="uk-icon-hover uk-icon-commenting-o" style="float: right; margin-right: 20px; margin-top: 20px;" title="点击评论"></a>
                </article>
            </li>
        <hr class="layui-bg-black">
    </s:iterator>
        </div>
    </div>
</div>
</body>
</html>
<script src="layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['layer','form','jquery'],function(){
        var layer = layui.layer,
            $ = layui.jquery;
        $('#pushBtn').on('click',function(){
            layer.open({
                type: 2,
                title: ['发布动态'],
                content: "${pageContext.request.contextPath}/Trends_pushshow.action",
                area:['60%','60%'],  //宽高
                resize: false,    //是否允许拉伸
                scrollbar: false,
                maxmin: true,
                end: function(){
                    location.reload();
                }
            });
        });
        //点赞
        $('.thumb').on('click',function(){
            var id = $(this).data('id');
            $.ajax({
                url:'${pageContext.request.contextPath}/Trends_thumbTrends.action',
                type: 'GET',
                data:{id:id},
                error: function(request){
                    layer.msg("请求服务器超时", {time: 1000, icon: 6});
                },
                success: function(data){
                    var json = eval("("+data+")");
                    if (json.status==1){
                        layer.msg(json.msg, {time: 1000,icon:6},function(){parent.location.href="${pageContext.request.contextPath}/Trends_trendsList.action";});
                    }else{
                        layer.msg(json.msgl, {time: 1000});
                    }
                    return false;
                }
            });
        });
        //收藏
        $('.collect').on('click',function(){
            var id = $(this).data('id');
            var userid = $(this).data('userid');
            $.ajax({
                url:'${pageContext.request.contextPath}/Collect_collectTrends.action',
                type: 'GET',
                data:{trendsId:id,userId:userid},
                error: function(request){
                    layer.msg("请求服务器超时", {time: 1000, icon: 6});
                },
                success: function(data2){
                    var json2 = eval("("+data2+")");
                    if (json2.status==1){
                        layer.msg(json2.msg, {time: 1000,icon:6},function(){parent.location.href="${pageContext.request.contextPath}/Trends_trendsList.action";});
                    }else{
                        layer.msg(json2.msgl, {time: 1000,icon:5});
                    }
                    return false;
                }
            });
        });
    });
</script>
