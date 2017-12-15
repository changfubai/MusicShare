<%--
  Created by IntelliJ IDEA.
  User: luochao
  Date: 2017/12/15
  Time: 12:32
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
            <li ><a href="location.href='${pageContext.request.contextPath}/Trends_trendsList.action'">所有动态</a></li>
            <li><a href=# onclick="location.href='${pageContext.request.contextPath}/Trends_mytrendsList.action'">我的动态</a></li>
            <li class="uk-active"><a href=# onclick="location.href='regest.html'">收藏动态</a></li>
        </ul>
        <div class="lu">
            <button class="layui-btn layui-btn-normal" style="float: right;margin-right: 10px;" id="pushBtn">
                <i class="layui-icon">&#xe608;</i> 发布动态
            </button>
                <s:iterator value="mycollect" status="stay" var="e">
                <li>
                    <article class="uk-comment">
                        <header class="uk-comment-header">
                            <img class="uk-comment-avatar" src="images/02.jpg" alt="" style="width:70px; height:70px; border-radius:50%; overflow:hidden;">
                            <h4 class="uk-comment-title"><s:property value="#e.id"/></h4>
                            <div class="uk-comment-meta"></div>
                        </header>
                        <div class="uk-comment-body">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property escapeHtml="false" value="#e.content"/>
                        </div>
                        <a href="javascript:;" class="uk-icon-hover uk-icon-close  cutcollect" data-id="<s:property value="#e.id"/>" data-userid="<s:property value="2"/>" style="float: right; margin-right: 10px; margin-top: 20px;" title="点击取消收藏"></a>
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
        //收藏
        $('.cutcollect').on('click',function(){
            var id = $(this).data('id');
            var userid = $(this).data('userid');
            layer.confirm('确定取消该收藏?', {
                btn: ['确定', '取消']
            }, function(){
            $.ajax({
                url:'${pageContext.request.contextPath}/Collect_cutcollect.action',
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
    });
</script>