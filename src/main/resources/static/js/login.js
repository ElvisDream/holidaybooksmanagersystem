function clearUserName() {

    $('input[name=userName]').focus(function () {
        $('#login-msg-div').hide();
    });
    $('input[name=password]').focus(function () {
        $('#login-msg-div').hide();
    });
}

function login() {
    const userName = $("input[name=userName]").val();
    const password = $("input[name=password]").val();
    if (userName === "" || userName === 'null') {
        $("#login-msg").html("请输入用户名");
        $("#login-msg-div").show();
        return;
    }
    if (password === "" || password === 'null') {
        $("#login-msg").html("请输入密码");
        $("#login-msg-div").show();
        return;
    }

    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '/loginIn',
        data: $('#login_form').serialize(),
        success: function (res) {
            if (res.code !== 200) {
                $("#login-msg").html(res.message);
                $("#login-msg-div").show();
                $("input[name=password]").val("");
            } else {
                window.location.href = "/success";
            }
        },
        error: function () {
            console.log("异常！")
        }
    });
}

