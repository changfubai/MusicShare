<%--
  Created by IntelliJ IDEA.
  User: changfubai
  Date: 2017/12/31
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css" />
    <script src="/js/jquery-2.1.0.js"></script>
    <script src="/layui/layui.js"></script>
</head>
<body>
<div style="margin-top: 50px;"></div>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">圈子名</label>
        <div class="layui-input-block">
            <input type="text" name="name" required style="width: 400px;"  lay-verify="required" placeholder="给我起个名儿吧~" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">圈子描述</label>
        <div class="layui-input-block">
            <textarea name="description" required lay-verify="required" placeholder="描述的越动人，圈友越多哟~" style="width: 400px;" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
</html>
<script>
    //Demo
    layui.use(['form','jquery'], function(){

        var form = layui.form,
            $ = layui.jquery;

        //监听提交
        form.on('submit(formDemo)', function(data){
            var myUrl = "Circle_create";
//            + "?" + 'name="' + data.field.name + +'"\&\&desc="'
//                + data.field.desc + '"';

            $.ajax({
                url: myUrl,
                type: 'POST',
                data: data.field,
                dataType:'json',
                error: function(request){
                    layer.msg("请求服务器超时", {time: 1000, icon: 6});
                },
                success: function(data){
                    var json = eval("("+data+")");
                    if (json.status==1){
                        layer.msg(json.msg, {time: 1000},function(){parent.location.href="indexAction.action";});
                    }else{
                        layer.msg(json.msgl, {time: 1000});
                    }
                }
            });
            return false;
        });
    });
</script>
