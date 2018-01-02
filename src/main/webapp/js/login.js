$(function() {
    /*
    得到所有的错误信息，循环遍历之。调用一个方法来确定是否显示错误信息
     */
    $(".errorClass").each(function(){
        showError($(this));//遍历每个元素，使用每个元素来调用showerror方法
    })

    /*
    输入框获取焦点时隐藏错误信息
     */
    $(".text").focus(function () {
        var labelId=$(this).attr("id")+"Error";  //通过输入框来找到对应lable的id
        $("#"+labelId).text(""); //把label的内容清空
        showError($("#"+labelId)); //隐藏没有信息的label
    });
    /*
    输入框失去焦点进行校验
     */
    $(".text").blur(function () {
        var id=$(this).attr("id");//获取当前输入框的id
        var funName="validate"+id.substring(0,1).toUpperCase()+id.substring(1)+"()";//得到对应的校验函数
        eval(funName);

    });

    /*
表单提交时进行校验
 */
    $('#registerForm').submit(function () {
        var bool = true; //表示校验通过
        if (!validateName()) {
            bool = false;
        }
        if(!validatePassword()){
            bool=false;
        }
        if(!validateRepassword()){
            bool=false;
        }
        if(!validateAccount()){
            bool=false;
        }
        alert("bool："+bool);
        return bool;
    });


});


function validatePassword() {
    var password = "password";
    var value = $("#" + password).val();  //获取输入框内容

    /*
    1.非空校验
     */
    if (!value) {
        /*
        获取对应的label
        添加错误信息
        显示label
         */
        $("#" + password + "Error").text("密码不能为空！");
        showError($("#"+password+"Error"));
        return false;
    }

    return true;
}


function validateAccount() {
    var account = "account";
    var value = $("#" + account).val();
    /*
    1.非空校验
     */
    if (!value) {
        /*
        获取对应的label
        添加错误信息
        显示label
         */
        $("#" + account + "Error").text("账号不能为空！");
        showError($("#"+account+"Error"));
        return false;
    }
    if(value.length != 11){
        $("#" + account + "Error").text("请输入正确的手机号码");
        showError($("#"+account+"Error"));
        return false;

    }

    return true;

}
/*
判断当前元素是否存在内容，如果存在显示，没有就不显示！
 */

function showError(ele) {
    var text =ele.text();  //获取元素的内容
    if (!text){//如果没有内容
        ele.css("display","none"); //隐藏元素


    }else{  //如果有内容
        ele.css("display",""); //显示元素

    }
}