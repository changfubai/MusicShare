<%--
  Created by IntelliJ IDEA.
  User: luochao
  Date: 2017/12/11
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>发布动态</title>
    <link rel="stylesheet" href="layui/css/layui.css" />
</head>
<body>
<form class="layui-form" enctype="multipart/form-data">
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">动态内容</label>
        <div class="layui-input-block" style="margin-top: 50px;">
            <textarea id="content" name="content" class="layui-textarea" style="width:900px;height:300px;"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="pushBtn" style="margin-top: 40px;">发布</button>
        </div>
    </div>
</form>
</body>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript">
    KindEditor.ready(function(K) {
        window.editor = K.create('#content',{
            cssPath : 'kindeditor/plugins/code/prettify.css',
            uploadJson : 'kindeditor/jsp/upload_json.jsp',
            fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
            allowFileManager : true,
            afterCreate : function(){
                this.sync();
            },
            afterChange: function(){
                this.sync();
            },
            afterBlur : function(){this.sync();}
        });
    });
</script>
</html>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.0.js"></script>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form();
        form.on('submit(pushBtn)', function(data) {

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