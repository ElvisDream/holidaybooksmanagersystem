var $table = $('#user-table');

$(function () {
    InitMainTable();
});

function InitMainTable() {
    const queryUrl = "/user/findUserByInfo";
    $table.bootstrapTable({
        method: 'get',
        url: queryUrl,//这个接口需要处理bootstrap table传递的固定参数
        queryParams: function (params) {
            return {
                userName: '',
                email: '',
                pageNumber: params.pageNumber,
                pageSize: params.pageSize
            };
        },
        columns: [{
            field: 'id',
            title: '用户ID'
        }, {
            field: 'userName',
            title: '用户名'
        }, {
            field: 'phone',
            title: '电话号码'
        }, {
            field: 'email',
            title: '邮箱'
        }]
    });
}


