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
    setCookie();   //调用设置Cookie的方法
    if (userName === "" || userName === 'null') {
        $("#login-msg").html("请输入用户名");
        return;
    }
    if (password === "" || password === 'null') {
        $("#login-msg").html("请输入密码");
        return;
    }

    $.ajax({
        type: 'POST',
        dataType: 'JSON',
        // contentType: 'application/json',
        url: '/loginIn',
        data: "userName=" + userName + "&password=" + password,
        success: function (res) {
            if (res.code !== 200) {
                $("#login-msg").html(res.message);
            } else {
                window.location.href = "/success";
            }
        },
        error: function () {
            console.log("异常！")
        }
    });
}

function setCookie() {
    const userName = $("input[name=userName]").val();
    const password = $("input[name=password]").val();
    const isChecked = $("input[type='checkbox']").is(":checked");//获取是否选中
    if (isChecked === true) {//如果选中-->记住密码登录
        $.cookie("userName", userName.trim(), 7);//有效时间7天，也可以设置为永久，把时间去掉就好
        $.cookie("passWord", password.trim(), 7);
    } else {//如果没选中-->不记住密码登录
        $.cookie("passWord", "");
        $.cookie("userName", "");
    }
}

function getCookie() {
    const userName = $.cookie("userName"); //获取cookie中的用户名
    const pwd = $.cookie("passWord"); //获取cookie中的登陆密码
    if (pwd) {//密码存在的话把“记住用户名和密码”复选框勾选住
        $("#remember").attr("checked", "true");
    }
    if (userName != "") {//用户名存在的话把用户名填充到用户名文本框
        $("input[name=userName]").val(userName);
    } else {
        $("input[name=userName]").val("");
    }
    if (pwd != "") {//密码存在的话把密码填充到密码文本框
        $("input[name=password]").val(pwd);
    } else {
        $("input[name=password]").val("");
    }
}

