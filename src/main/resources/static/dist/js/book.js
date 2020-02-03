var booksData;
var currentBook;

//初始化书籍界面
function init() {
    let books = queryBookByInfo();
    loadAllBooks(books);
}

$(function () {
    //借书
    $("#rentModal").on('hide.bs.modal', function () {
        $("#rentModal-div-left").empty();
        $("#rentModal-div-right").empty();
    });
    //还书
    $("#returnModal").on('hide.bs.modal', function () {
        $("#returnModal-div-left").empty();
        $("#returnModal-div-right").empty();
    });

    //借书确认按钮事件处理
    $("#rentModal-btn-sure").click(function () {
        const rentNum = $("#rent-div-nums").val();
        const regExp = /^[1-9]*[1-9][0-9]*$/;
        if (!regExp.test(rentNum)) {
            alert("请输入正确的数量!!!");
            return false;
        }
        if (currentBook.bookNums < rentNum) {
            alert("当前库存不足");
            return false;
        }
        $.ajax({
            type: 'Delete',
            dataType: 'JSON',
            url: '/book/rent',
            data: "bookId=" + currentBook.id + "&num=" + rentNum,
            success: function (res) {
                if (res.code === 200) {
                    $("#rentModal").modal('hide');
                    init();
                }
            },
            error: function () {
                console.log("异常！")
            }
        });
    });

    //还书确认按钮事件处理
    $("#returnModal-btn-sure").click(function () {
        const returnNum = $("#return-div-nums").val();
        const regExp = /^[1-9]*[1-9][0-9]*$/;
        if (!regExp.test(returnNum)) {
            alert("请输入正确的数量");
            return false;
        }
        $.ajax({
            type: 'post',
            dataType: 'JSON',
            url: '/book/return',
            data: "bookId=" + currentBook.id + "&num=" + returnNum,
            success: function (res) {
                if (res.code === 200) {
                    $("#returnModal").modal('hide');
                    init();
                }
                if (res.code === 400) {
                    alert(res.message);
                }
            }
        });
    });

    $("#bookQuery-btn").click(function () {
        const bookName = $("#bookName-search").val();
        const author = $("#author-search").val();
        const bookCode = $("#bookCode-search").val();
        let searchData = '';
        if (bookName !== '' && bookName !== 'null') {
            searchData += 'bookName=' + bookName + '&';
        }
        if (author !== '' && author !== 'null') {
            searchData += 'author=' + author + '&';
        }
        if (bookCode !== '' && bookCode !== 'null') {
            searchData += 'bookCode=' + bookCode + '&';
        }
        queryBookByInfo(searchData.substr(0, searchData.length - 1));
    });
});

//获取所有书籍信息
function queryBookByInfo(searchData) {
    let allBooks = {};
    $.ajax({
        type: 'get',
        dataType: 'JSON',
        url: '/book/queryBookByInfo',
        async: false,
        data: searchData,
        success: function (res) {
            if (res.code === 200) {
                allBooks = res.data;
                loadAllBooks(res.data);
            }
        }
    });
    booksData = allBooks;
    return allBooks;
}

//动态加载书籍信息
function loadAllBooks(books) {
    $("#row-book").empty();
    $.each(books, function (id, book) {
        $("#row-book").append(`<div class="col-md-2 book-outer-div"
             style="height: 392px; margin-right: 22px;margin-top: 22px; padding:0; border: solid 1px lightgrey">
            <div style="height: 250px;background: url(${book.iconAddress});background-size:100% 100%"></div>
            <div style="text-align: center;margin-top:15px">
                <div>
                    <ul style="list-style-type: none">
                        <li>${book.bookName}</li>
                        <li>剩余数量<h style="color: red;font-size: larger"> ${book.bookNums} </h>本</li>
                    </ul>
                </div>
                <div style="margin: 0 auto">
                    <input type="button" id='rentBookBtn_${book.id}' bookId='${book.id}' data-toggle="modal" data-target="#rentModal" 
                    onclick="rentBook(this)" class="btn btn-block btn-outline-warning btn-sm"
                           style="width: 240px;margin: 4px auto"
                           value="借书">
                    <input type="button" id='returnBookBtn_${book.id}' bookId='${book.id}' data-toggle="modal" data-target="#returnModal" 
                    onclick="returnBook(this)" class="btn btn-block btn-outline-danger btn-sm"
                           style="width: 240px;margin: 4px auto"
                           value="还书">
                </div>
            </div>
        </div>`);
    });
}

//借书处理
function rentBook(btn) {
    const bookId = $(btn).attr('bookId');
    const now = getCurrentDate();
    const userName = $.cookie("userName");
    // language=HTML
    $.each(booksData, function (id, book) {
        if (book.id == bookId) {
            currentBook = book;
            $("#rentModal-div-left").append(`<img src='${book.iconAddress}'>`);
            $("#rentModal-div-right").append(`
                <ul style="list-style-type: none">
                    <li>书籍名称：${book.bookName}</li>
                    <li>价格：${book.price}</li>
                    <li>编号：${book.bookCode}</li>
                    <li>当前书籍剩余：<span style="color: red;font-size: larger">${book.bookNums}</span>本</li>
                    <li>借出时间：${now}</li>
                    <li>借书人：${userName}</li>
                    <li>借出数量：<input id="rent-div-nums" autocomplete="off" type="text" value="1"></li>
                </ul>`);
        }
    });
}

//还书处理
function returnBook(btn) {
    const bookId = $(btn).attr('bookId');
    const now = getCurrentDate();
    const userName = $.cookie("userName");
    // language=HTML
    $.each(booksData, function (id, book) {
        if (book.id == bookId) {
            currentBook = book;
            $("#returnModal-div-left").append(`<img src='${book.iconAddress}'>`);
            $("#returnModal-div-right").append(`
                <ul style="list-style-type: none">
                    <li>书籍名称：${book.bookName}</li>
                    <li>价格：${book.price}</li>
                    <li>编号：${book.bookCode}</li>
                    <li>当前书籍剩余：<span style="color: red;font-size: larger">${book.bookNums}</span>本</li>
                    <li>借出时间：${now}</li>
                    <li>借书人：${userName}</li>
                    <li>归还数量：<input id="return-div-nums" autocomplete="off" type="text" value="1"></li>
                </ul>`);
        }
    });
}

function getNow(s) {
    return s < 10 ? '0' + s : s;
}

//获取当前时间
function getCurrentDate() {
    var myDate = new Date();

    var year = myDate.getFullYear();        //获取当前年
    var month = myDate.getMonth() + 1;   //获取当前月
    var date = myDate.getDate();            //获取当前日


    var h = myDate.getHours();              //获取当前小时数(0-23)
    var m = myDate.getMinutes();          //获取当前分钟数(0-59)
    var s = myDate.getSeconds();

    return year + '-' + getNow(month) + "-" + getNow(date) + " " + getNow(h) + ':' + getNow(m) + ":" + getNow(s);
}