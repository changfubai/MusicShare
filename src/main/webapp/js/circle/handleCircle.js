function initial() {
    $('#bt_circle').on('click', function () {
        var userId = $("#user_id").text();
        // alert($("#user_id").text());
        if (userId == "" || userId == null) {
            alert("请先登陆？");
        } else {
            $('.version').hide();
            $('#trends').hide();
            $('#circle').show();
            $('#switcher').hide();
            loadCircle();
        }
    });
    $('#bt_trends').on('click', function () {
        var userId = $("#user_id").text();
        // alert($("#user_id").text());
        if (userId == "" || userId == null) {
            alert("请先登陆？");
        } else {
            loadTrends();
        }
    });
    $('#bt_initial').on('click', function () {
        $('.version').show();
        $('#switcher').show();
        $('#trends').hide();
        $('#circle').hide();
    });

}

function loadTrends() {
    parent.location.href="Trends_trendsList.action";
}
function loadCircle() {
    $.post("Circle_circle",
        function(data,status){
            // alert("Status: " + status);
            $('#myCircle').html(data);
            circle();
        });
}
function loadMyTrends() {
    $.post("Trends_collectTrends",
        function(data,status){
            // alert("Status: " + status);
            $('#mytrends').html(data);
        });
}
function loadCollectTrends() {
    $.post("Trends_collectTrends",
        function(data,status){
            // alert("Status: " + status);
            $('#mycollecttrends').html(data);
        });
}
