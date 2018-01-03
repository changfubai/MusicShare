function initial() {
    $('#bt_circle').on('click', function () {
        var userId = $("#user_id").text();
        // alert($("#user_id").text());
        if (userId == "" || userId == null) {
            alert("请先登陆？");
        } else {
            $('#circle').show();
            var div = $('#myCircle').html();
            $.post("Circle_circle",
                function(data,status){
                    // alert("Status: " + status);
                    $('#myCircle').html(data);
                });
        }
    });

}
