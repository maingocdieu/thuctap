<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/admin/sanpham/list" />
<c:url var="deleteNewAPI" value="/api/admin/sanpham" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách sản phẩm</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
                    chủ</a></li>
                <li class="active">Danh sách sản pham</li>
            </ul>
            <!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                           data-toggle="tooltip" title="Thêm sản phẩm mới"
                                           href='<c:url value="/admin/sanpham/edit"/>'> <span> <i
                                                class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
                                        </a>
                                        <button id="btnDelete" type="button"
                                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                disabled data-toggle="tooltip" title="Xóa sản phẩm"
                                                onclick="warningBeforeDelete()">
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <display:table name="model.listResult" cellspacing="0"
                                               cellpadding="0" requestURI="${formUrl}" partialList="true"
                                               size="${model.totalItems}" id="tableList"
                                               pagesize="${model.maxPageItems}" export="false"
                                               class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                               style="margin: 3em 0 1.5em;">
                                    <display:column
                                            title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>"
                                            class="center select-cell" headerClass="center select-cell">
                                        <fieldset>
                                            <input type="checkbox" class="check-box-element"
                                                   id="checkbox_${tableList.id}" value="${tableList.id}" />
                                        </fieldset>
                                    </display:column>
                                    <display:column headerClass="text-left" property="tenSanPham"
                                                    title="Tên sản phẩm" />
                                    <display:column headerClass="text-left"
                                                    property="moTa" title="Mô tả ngắn" />
                                    <display:column headerClass="text-left" title="Hinh" >
                                        <img height="100px" width="100px" src="<c:url value='/repository/${tableList.thumbnail}'/>" />
                                    </display:column>

                                    <display:column headerClass="col-actions" title="Thao tác">
                                        <c:url var="editNew" value="/admin/sanpham/edit">
                                            <c:param name="id" value="${tableList.id}" />
                                        </c:url>
                                        <a class="btn btn-sm btn-primary btn-edit"
                                           data-toggle="tooltip" title="Cập nhật sản phẩm"
                                           href='${editNew}'> <i class="fa fa-pencil-square-o"
                                                                 aria-hidden="true"></i>
                                        </a>
                                    </display:column>
                                </display:table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {

    });
    $(function () {
        var obj= $('#pagination-demo').twbsPagination({
            totalPages: 2,
            visiblePages: 7,
            startPage:1,
            next: 'Next',
            prev: 'Prev',
            onPageClick: function (event, page) {
                //fetch content and render here
                $('#page-content').text('Page ' + page) + ' content here';
            }
        });

    })
    function warningBeforeDelete() {
        showAlertBeforeDelete(function () {
            var dataArray = $('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            deleteNew(dataArray);
        });
    }
    function deleteNew(data) {
        $.ajax({
            url: '${deleteNewAPI}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function(res){
                window.location.href = "${formUrl}?message=delete";
            },
            error: function (res) {
                console.log(res);
            }
        });
    }

</script>
</body>
</html>
