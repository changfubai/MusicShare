<%--
  Created by IntelliJ IDEA.
  User: luochao
  Date: 2017/12/8
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>动态</title>
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <link rel="stylesheet" href="/css/uikit.css" />
    <link rel="stylesheet" href="/css/login.css" />
    <link rel="stylesheet" href="/css/forumcss.css" />
    <style>
    img {
    width: auto;
    /*height: 30px;*/
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
            <li><a href=# onclick="loadTrends()">所有动态</a></li>
            <li class="uk-active"><a href="#">我的动态</a></li>
            <li><a href=# onclick="loadCollectTrends()">收藏动态</a></li>
        </ul>
        <div class="lu">
            <button class="layui-btn layui-btn-normal" style="float: right;margin-right: 10px;" id="pushBtn">
                <i class="layui-icon">&#xe608;</i> 发布动态
            </button>
            <s:iterator value="mylist" var="e">
                <li>
                    <article class="uk-comment">
                        <header class="uk-comment-header">
                            <img class="uk-comment-avatar" src="images/02.jpg" alt="" style="width:70px; height:70px; border-radius:50%; overflow:hidden;">
                            <h4 class="uk-comment-title"><s:property value="#e.id"/></h4>
                            <div class="uk-comment-meta">2017-12-9<s:date name="#e.update_time" format="yyyy-MM-dd"/></div>
                            <div>
                                <a href="javascript:;" data-id="<s:property value="#e.id"/>" class="layui-btn layui-btn-primary layui-btn-mini editBtn" >
                                    <i class="layui-icon">&#xe642;</i>编辑
                                </a>
                                <a href="javascript:;" data-id="<s:property value="#e.id"/>" class="layui-btn layui-btn-primary layui-btn-mini del">
                                    <i class="layui-icon">&#xe640;</i>删除
                                </a>
                            </div>
                        </header>
                        <div class="uk-comment-body">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property escapeHtml="false" value="#e.content"/>
                        </div>
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
        //发布动态
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
        //动态编辑
        $('.editBtn').on('click',function(){
            var id = $(this).data('id');
            layer.open({
                type: 2,
                title: ['修改动态'],
                content: "${pageContext.request.contextPath}/Trends_findTrendsById.action"+"?id="+id,
                area:['60%','60%'],  //宽高
                resize: false,    //是否允许拉伸
                scrollbar: false,
                maxmin: true,
                end: function(){
                    location.reload();
                }
            });
        });
        $('.del').on('click', function(){
            var id = $(this).data('id');
            layer.confirm('确定删除该动态?', {
                btn: ['确定', '取消']
            }, function(){
                $.ajax({
                    url: "${pageContext.request.contextPath}/Trends_deleteTrends.action"+"?id="+id,
                    type: 'POST',
                    dataType: 'json',
                    error: function(request){
                        layer.msg("请求服务器超时", {time: 1000, icon: 5});
                    },
                    success: function(data){
                        var json = eval("("+data+")");
                        if (json.status==1){
                            layer.msg(json.msg, {time: 1000},function(){parent.location.href="${pageContext.request.contextPath}/Trends_mytrendsList.action";});
                        }else{
                            layer.msg(json.msgl, {time: 1000});
                        }
                    }
                });

            });
        });
    });
</script>