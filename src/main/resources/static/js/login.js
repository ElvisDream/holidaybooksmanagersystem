function login() {
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '/loginIn',
        data: $('#login_form').serialize(),
        success: function (res) {
            if (res.code === 200) {
                alert(res.message);
            }else if (res.code === 400) {
                alert(res.message);
            }
        },
        error: function () {
            console.log("异常！")
        }
    });
}