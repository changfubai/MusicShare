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
            loadCircle();
        }
    });
    $('#bt_trends').on('click', function () {
        var userId = $("#user_id").text();
        // alert($("#user_id").text());
        if (userId == "" || userId == null) {
            alert("请先登陆？");
        } else {
            $('.version').hide();
            $('#trends').show();
            $('#circle').hide();
            loadTrends();
        }
    });
    $('#bt_initial').on('click', function () {
        $('.version').show();
        $('#trends').hide();
        $('#circle').hide();
    });

}

function loadTrends() {
    $.post("Trends_trendsList",
        function(data,status){
            // alert("Status: " + status);
            $('#trends').html(data);
        });
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
            $('#trends').html(data);
        });
}
function loadCollectTrends() {
    $.post("Trends_collectTrends",
        function(data,status){
            // alert("Status: " + status);
            $('#trends').html(data);
        });
}
