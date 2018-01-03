function circle() {
    layui.use(['layer', 'form', 'jquery'], function () {
        var layer = layui.layer,
            form = layui.form,
            $ = layui.jquery;
        var url_create = "Circle_form.action";
        var url_del = "Circle_dissolveCircle";
        var url_quit = "JoinCircle_quit";
        var url_join = "JoinCircle_join";
        var url_search = "Circle_search";
        // 创建圈子
        $('.createCircle').on('click', function () {
            layer.open({
                type: 2,
                title: ['创建圈子'],
                content: url_create,
                area: ['600px', '400px'],  //宽高
                resize: false,    //是否允许拉伸
                scrollbar: false,
                maxmin: true,
                end: function () {
                    location.reload();
                }
            });
        });
        //解散圈子
        $('.dissolveCircle').on('click', function () {
            var id = $(this).data('id');
            layer.confirm('确定要解散圈子么？圈友们会难过的~', {
                btn: ['哎，领散伙饭吧~', '算了吧！'] //按钮
            }, function () {
                layer.msg('唔，那我去通知大家吧~·~ ',
                    {anim: 5, time: 500});
                // 点击确认后的处理
                $.ajax({
                    url: url_del,
                    type: 'GET',
                    data: {id: id},
                    error: function (request) {
                        layer.msg("请求服务器超时", {time: 1000, icon: 6});
                    },
                    success: function (data) {
                        var json = eval("(" + data + ")");
                        if (json.status == 1) {
                            layer.msg(json.msg, {time: 1000, anim: 5}, function () {
                                // parent.location.href = "Circle_circle.action";
                                loadCircle();
                            });
                        } else {
                            layer.msg(json.msgl, {time: 1000});
                        }
                        return false;
                    }
                });
            }, function () {
                layer.msg('圈友们爱你~~么么哒！！', {
                    time: 1000,
                    anim: 4
                });
            });
        });

        // 获取圈子成员动态
        $('.getAll').on('click', function () {
            var id = $(this).data('id');
            $.ajax({
                url: '${pageContext.request.contextPath}/Trends_thumbTrends.action',
                type: 'GET',
                data: {id: id},
                error: function (request) {
                    layer.msg("请求服务器超时", {time: 1000, icon: 6});
                },
                success: function (data) {
                    var json = eval("(" + data + ")");
                    if (json.status == 1) {
                        layer.msg(json.msg, {time: 1000, icon: 6}, function () {
                            loadCircle();
                            // parent.location.href = "${pageContext.request.contextPath}/Trends_trendsList.action";
                        });
                    } else {
                        layer.msg(json.msgl, {time: 1000});
                    }
                    return false;
                }
            });
        });
        // 退出圈子
        $('.quitCircle').on('click', function () {
            var id = $(this).data('id');
            layer.confirm('确定要退出圈子么？退出了就看不到圈友们的动态了哟~', {
                btn: ['我去意已决~', '再等等！'] //按钮
            }, function () {
                layer.msg('挥泪告别~ ',
                    {anim: 5, time: 500});
                // 点击确认后的处理
                $.ajax({
                    url: url_quit,
                    type: 'GET',
                    data: {id: id},
                    error: function (request) {
                        layer.msg("请求服务器超时", {time: 1000, icon: 6});
                    },
                    success: function (data) {
                        var json = eval("(" + data + ")");
                        if (json.status == 1) {
                            layer.msg(json.msg, {time: 1000, anim: 5}, function () {
                                loadCircle();
                            });
                        } else {
                            layer.msg(json.msgl, {time: 1000});
                        }
                        return false;
                    }
                });
            }, function () {
                layer.msg('圈友们爱你~~么么哒！！', {
                    time: 1000,
                    anim: 4
                });
            });
        });
        // 加入圈子
        $('.joinCircle').on('click', function () {
            var id = $(this).data('id');
            $.ajax({
                url: url_join,
                type: 'GET',
                data: {circleId: id},
                error: function (request) {
                    layer.msg("请求服务器超时", {time: 1000, icon: 6});
                },
                success: function (data) {
                    var json = eval("(" + data + ")");
                    if (json.status == 1) {
                        layer.msg(json.msg, {time: 2000, icon: 6, anim:5}, function () {
                            loadCircle();
                        });
                    } else {
                        layer.msg(json.msgl, {time: 1000});
                    }
                    return false;
                }
            });
        });

        // 搜索可加入的圈子
        form.on('submit(search)', function(data){
            $.ajax({
                url: url_search,
                type: 'POST',
                data: data.field,
                dataType:'json',
                error: function(request){
                    layer.msg("请求服务器超时", {time: 1000, icon: 6});
                },
                success: function(data){
                    if (data == "") {
                        var html = "<h1>哇，所有的圈子都被你涉足啦@！！@</h1>";
                        $("#searchResult").empty();
                        $("#searchResult").html(html);
                        return false;
                    }
                    var jsonArr = JSON.parse(data);
                    var html = "";

                    for (var i = 0; i < jsonArr.length; i++) {
                        html += "<div class=\"uk-animation-scale-down uk-animation-10\">"
                            + "<div class=\"uk-panel uk-panel-box uk-animation-slide-bottom uk-animation-10 ";
                        var obj = jsonArr[0];
                        var time = obj.createTime.time.toString();
                        if (i % 3 == 1) {
                            html += "uk-panel-box-primary";
                        }
                        html += "\"><h2 class=\"uk-panel-title getAll\" data-id=\""+ obj.id +"\" style=\"cursor:hand\">"+ obj.name+"</h2>"
                            + "<span href=\"javascript:;\" data-id=\""+ obj.id +"\" class=\"layui-btn layui-btn-radius layui-btn-mini uk-position-top-right joinCircle\">"
                            + "<i class=\"layui-icon\">&#xe608;</i>加入"
                            + "</span><h4 class=\"uk-navbar-nav-subtitle\">创建于" + new Date(Number(time)).Format("yyyy-MM-dd") +"</h4>"
                            + obj.description
                            + "</div></div>";
                    }
                    $("#searchResult").empty();
                    $("#searchResult").html(html);
                }
            });
            return false;
        });

    });
}
