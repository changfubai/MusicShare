<%--
  Created by IntelliJ IDEA.
  User: luochao
  Date: 2017/12/1
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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
    <script src="_s/uikit.min.js"></script>
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
            <li><a href=# onclick="location.href='${pageContext.request.contextPath}/Login_login2.action'">登陆</a></li>
            <li class="uk-active"><a href="">注册</a></li>
        </ul>
        <div class="lu">
            <li>
                <div class="logininfo">
                    <form class="layui-form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">账号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="account" required  lay-verify="account" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">英文或数字不能含空格</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">昵称</label>
                            <div class="layui-input-block">
                                <input type="text" name="name" required  lay-verify="required" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-inline">
                                <input type="password" name="password" id="password" required lay-verify="password" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">6-16个字符，不能含有空格</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">确认密码</label>
                            <div class="layui-input-inline">
                                <input type="password" name="password2" id="password2" required lay-verify="required" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">验证码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="code" required  lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
                            </div>
                            <div><img src="__CONTROLLER__/verify" onclick="this.src=this.src+'__CONTROLLER__/verify'"  style="width: 118px;  height: 38px; cursor:pointer;" title="点击刷新">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn layui-btn-normal" lay-submit lay-filter="regestBtn">立即注册</button>
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
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.0.js"></script>
</html>

<script type="text/javascript">
    layui.use(['form','laydate','layer'], function(){
        var form = layui.form(),
            laydate = layui.laydate,
            layer=layui.layer,
            $ = layui.jquery;
        form.render(); //更新全部
        form.render('select');
        form.on('submit(regestBtn)', function(data) {
            var password=document.getElementById('password').value;
            var password2=document.getElementById('password2').value;
            if(password==password2){
                $.ajax({
                    url: '__url__/login/addregest',
                    type: 'POST',
                    data: data.field,
                    error: function(request){
                        layer.msg("请求服务器超时", {time: 1000, icon: 5});
                    },
                    success: function(data){
                        if (data.status){
                            layer.msg('注册成功', {time: 1000},function(){parent.location.href="__MODULE__/index/index";});
                        }else{
                            layer.msg(data.msg, {time: 1000});
                        }
                    }
                });
            }else{
                layer.msg('两次密码不一致!',{time:1000});
            }
            return false;
        });

        form.verify({
            account: function(value, item){ //value：表单的值、item：表单的DOM对象
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '用户名不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if(/[\u4E00-\u9FA5]/g.test(value)){
                    return '用户名不能含有汉字';
                }
            }

            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            ,password: [
                /^[\S]{6,12}$/
                ,'密码必须6到16位，且不能出现空格'
            ]
        });

    });
</script>

