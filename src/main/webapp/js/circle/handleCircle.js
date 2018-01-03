function initial() {
    $('#bt_circle').on('click', function () {
        var userId = $("#user_id").text();
        // alert($("#user_id").text());
        if (userId == "" || userId == null) {
            alert("请先登陆？");
        } else {
            $('.version').hide();
            $('#circle').show();

            loadCircle();

        }
    });
    $('#bt_initial').on('click', function () {
        $('.version').show();
        $('#circle').hide();
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
