$(document).ready(function () {
    bindEventCheckAllCheckBox();
    autoCheckCheckboxAll();
    enableOrDisableDeleteAll();
});

function bindEventCheckAllCheckBox() {
    $('#checkAll').change(function () {
        if ((this).checked) {
            $(this).closest('table').find('tbody').find('input[type=checkbox]').prop('checked', true);
        } else {
            $(this).closest('table').find('tbody').find('input[type=checkbox]').prop('checked', false);
            $('#btnDelete').prop('disabled', true);
        }
    });
}

function autoCheckCheckboxAll() {
    var totalCheckbox = $('#checkAll').closest('table').find('tbody').find('input[type=checkbox]').length;
    $('#checkAll').closest('table').find('tbody').find('input[type=checkbox]').each(function () {
        $(this).on('change', function () {
            var totalCheckboxChecked = $('#checkAll').closest('table').find('tbody').find('input[type=checkbox]:checked').length;
            if (totalCheckboxChecked == totalCheckbox) {
                $('#checkAll').prop('checked', true);
            } else {
                $('#checkAll').prop('checked', false);
            }
        });
    });
}

function enableOrDisableDeleteAll() {
    $('input[type=checkbox]').click(function () {
        if ($('input[type=checkbox]:checked').length > 0) {
            $('#btnDelete').prop('disabled', false);
        } else {
            $('#btnDelete').prop('disabled', true);
        }
    });
}
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
function addNew(data) {
    $.ajax({
        url: '${formUrl}',
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(data),
        success: function(res){
            window.location.href = "${editURL}&message=insert";
        },
        error: function (res) {
            console.log(res);
        }
    });
}

