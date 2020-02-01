function register() {
    var formObject = {};
    var formArray =$("#register_form").serializeArray();
    $.each(formArray,function(i,item){
        formObject[item.name] = item.value;
    });
    if (formObject['userName'] === "" || formObject['userName'] === 'null') {
        $("#register-msg").html("请输入用户名");
        return;
    }
    if (formObject['userPwd'] === "" || formObject['userPwd'] === 'null') {
        $("#register-msg").html("请输入密码");
        return;
    }
    if (formObject['userPwd'] !== formObject['password-second']) {
        $("#register-msg").html("密码不一致");
        return;
    }
    $.ajax({
        url: '/register_add',
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(formObject),
        dataType: 'json',
        success: function (res) {
            if (res.code !== 200) {
                $("#register-msg").html(res.message);
            } else {
                window.location.href = "/success";
            }
        },
        error: function () {
            console.log("异常！");
        }
    });

}