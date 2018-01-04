<%--
  Created by IntelliJ IDEA.
  User: luochao
  Date: 2017/12/9
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <link rel="stylesheet" href="layui/css/layui.css" />
</head>
<body>
<s:iterator value="edTrends" var="e">
<form class="layui-form" enctype="multipart/form-data">
    <input type="hidden" name="id" value="<s:property value="#e.id" />">
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">动态内容</label>
        <div class="layui-input-block" style="margin-top: 50px;">
            <textarea id="content" name="content" class="layui-textarea" style="width:900px;height:300px;" ><s:property value="#e.content" /></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="pusheditBtn" style="margin-top: 40px;">提交</button>
        </div>
    </div>
</form>
</s:iterator>
</body>
<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript">
    KindEditor.ready(function(K) {
        window.editor = K.create('#content',{
            cssPath : 'kindeditor/plugins/code/prettify.css',
            uploadJson : '${pageContext.request.contextPath}/Trends_uploadImage.action',
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
<script src="/layui/layui.js"></script>
<script src="/js/jquery-2.1.0.js"></script>
<script>
    //Demo
    layui.use(['form','layer','jquery'], function(){
        var form = layui.form,
            layer = layui.layer,
            $ = layui.jquery;

        form.on('submit(pusheditBtn)', function(data){
            var myUrl = "Trends_editTrends";
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
                        layer.msg(json.msg, {time: 1000},function(){parent.location.href="Trends_trendsList.action";});
                    }else{
                        layer.msg(json.msgl, {time: 1000});
                    }
                }
            });
            return false;
        });

        <%--form.on('submit(pusheditBtn)', function(data) {--%>
            <%--$.ajax({--%>
                <%--url:'${pageContext.request.contextPath}/Trends_editTrends.action',--%>
                <%--type: 'POST',--%>
                <%--data: data.field,--%>
                <%--error: function(request){--%>
                    <%--layer.msg("请求服务器超时", {time: 1000, icon: 6});--%>
                <%--},--%>
                <%--success: function(data){--%>
                    <%--var json = eval("("+data+")");--%>
                    <%--if (json.status==1){--%>
                        <%--layer.msg(json.msg, {time: 1000},function(){parent.location.href="Trends_mytrendsList.action";});--%>
                    <%--}else{--%>
                        <%--layer.msg(json.msgl, {time: 1000});--%>
                    <%--}--%>
                <%--}--%>
            <%--});--%>

            <%--return false;--%>
        <%--});--%>
    });
</script>
