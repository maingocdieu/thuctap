$(document).ready(function () {
    $('#btnAddUser').click(function (e) {
        e.preventDefault();
        var dataArray = {};
        var formData = $('#formId').serializeArray();
        $.each(formData, function (i,v) {
            dataArray[""+v.name+""] = v.value;
        });
        dataArray["status"] = 1;
        dataArray["code"] = "USER";


        addNew(dataArray);
    });

});


function addNew(data) {
    $.ajax({
        url: '/api/user',
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        success: function(res){

            alert("dang ki thanh cong");
            window.location.href="/trang-chu";
        },
        error: function (res) {
            console.log(res);
        }
    });
}


