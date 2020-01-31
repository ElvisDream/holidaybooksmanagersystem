function register() {
    var formObject = {};
    var formArray =$("#register_form").serializeArray();
    $.each(formArray,function(i,item){
        formObject[item.name] = item.value;
    });
    $.ajax({
        url: '/register_add',
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(formObject),
        dataType: 'json',
        success: function (res) {
            if (res.code !== 200) {
                alert(res.message);
            } else {
                window.location.href = "/success";
            }
        },
        error: function () {
            console.log("异常！");
        }
    });

}