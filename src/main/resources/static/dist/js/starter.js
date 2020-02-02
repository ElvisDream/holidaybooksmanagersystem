$(document).ready(function () {
    const userName = $.cookie("userName");
    $("#a_userName").html(userName);
});

$(function () {

    $("nav ul li a").click(function () {

        $("nav a").each(function () {

            $(this).removeClass("active");

        });

        $(this).toggleClass("active");

        $(this).parent().parent().siblings().toggleClass("active");

    });

    $(".sys-exit").click(function () {
        window.location.href='/';
    });
});

window.onresize = function () {
    reinitIframe();
}
function reinitIframe(){
    var iframe = document.getElementById("mainiframe");
    try{
        iframe.height = $(".content-wrapper").height()-6;
    }catch (ex){}
}

