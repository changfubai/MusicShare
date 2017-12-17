<%--
  Created by IntelliJ IDEA.
  User: luochao
  Date: 2017/12/1
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
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

    <script src="js/jquery-1.8.0.min.js"></script>
    <script src="js/uikit.min.js"></script>
    <style type="text/css">

        .layui-input, .layui-textarea {
            display: block;
            width: 190px;
            padding-left: 10px;
        }

    </style>
</head>

<jsp:include page="../common/head.jsp"></jsp:include>

<body>
<div class="loginmain">
    <div class="lm">
        <ul class="uk-tab" data-uk-tab>
            <li class="uk-active"><a href="">登陆</a></li>
            <li><a href=# onclick="location.href='${pageContext.request.contextPath}/Login_regest.action'">注册</a></li>
        </ul>
        <div class="lu">
            <li>
                <div class="logininfo">
                    <form class="layui-form loginform" action="">
                        <input type="hidden" name="userId" name="userId" value="2" class="layui-input">
                        <div class="layui-form-item">
                            <label class="layui-form-label">内容</label>
                            <div class="layui-input-block">
                                <input type="text" name="content" name="content" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="url" id="url" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <%--<div class="layui-form-item">--%>
                            <%--<label class="layui-form-label">验证码</label>--%>
                            <%--<div class="layui-input-inline">--%>
                                <%--<input type="text" name="code" required  id="code" lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">--%>
                            <%--</div>--%>
                            <%--<div><img src="__CONTROLLER__/verify" onclick="this.src=this.src+'__CONTROLLER__/verify'"  style="width: 118px;  height: 38px; cursor:pointer" title="点击刷新"></div>--%>
                        <%--</div>--%>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn layui-btn-normal" lay-submit lay-filter="loginBtn">立即登录</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </li>
        </div>
    </div>
</div>
</body>
<jsp:include page="../common/foot.jsp"></jsp:include>
</html>
<script src="layui/layui.js"></script>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form();
        form.on('submit(loginBtn)', function(data) {

            $.ajax({
                url:'${pageContext.request.contextPath}/Trends_pushTrends.action',
                type: 'POST',
                data: data.field,
                dataType:'json',
                error: function(request){
                    layer.msg("请求服务器超时", {time: 1000, icon: 6});
                },
                success: function(data){
                    var json = eval("("+data+")");
                    if (json.status==1){
                        layer.msg(json.msg, {time: 1000},function(){parent.location.href="${pageContext.request.contextPath}/Trends_trendsList.action";});
                    }else{
                        layer.msg(json.msgl, {time: 1000});
                    }
                }
            });

            return false;
        });
    });
</script>

