<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/api/admin/sanpham" />
<c:url var="news" value="/admin/sanpham/list" />
<c:url var="editURL" value="/admin/sanpham/edit" />
<html>
<head>
	<title>Chỉnh sửa sản phẩm</title>
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
				<li class="active">Chỉnh sửa sản phẩm</li>
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
				<form:form id="formId" commandName="model">
					<div class="col-xs-12">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Loại
								sản phẩm</label>
							<div class="col-sm-9">
								<form:select path="categoryCode">
									<form:option value="" label="--- Chọn loại sản phẩm ---" />
									<form:options items="${model.categories}" />
								</form:select>
							</div>
						</div>
						<br /> <br />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Tên sản phẩm</label>
							<div class="col-sm-9">
								<form:input path="tenSanPham" cssClass="form-control" id="tenSanPham" />
							</div>
						</div>
						<br /> <br />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Mô
								tả ngắn</label>
							<div class="col-sm-9">
								<form:input path="moTa" cssClass="form-control"
											id="moTa" />
							</div>
						</div>
						<br /> <br />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Nhập giá sản phẩm
							</label>
							<div class="col-sm-9">
								<form:input type="number" path="giaSanPham" cssClass="form-control"
											   id="giaSanPham" />
							</div>
						</div>


						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Sản Phẩm nổi bật
							</label>
							<div class="col-sm-9">
								<form:checkbox path="sanPhamNoiBat" cssClass="form-control"
											   id="sanPhamNoiBat" />
							</div>
						</div>
						<br /> <br />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Chọn
								thumbnail</label>
							<div class="col-sm-9">
								<input type="file" name="file" id="uploadImage" />
							</div>
						</div>
						<br /> <br />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Xem
								trước</label>
							<div class="col-sm-9">
								<c:if test="${not empty model.thumbnail}">
									<img src="<c:url value='/repository/${model.thumbnail}'/>"
										 id="viewImage" width="150px" height="150px">
								</c:if>
								<c:if test="${empty model.thumbnail}">
									<img src="<c:url value='/template/image/default.png'/>"
										 id="viewImage" width="150px" height="150px">
								</c:if>
							</div>
						</div>
						<form:hidden path="id" id="newId" />
						<div class="form-group">
							<div class="col-sm-12">
								<c:if test="${empty model.id}">
									<input type="button"
										   class="btn btn-white btn-warning btn-bold"
										   value="Thêm mới sản phẩm" id="btnAddOrUpdateSanPham" />
								</c:if>
								<c:if test="${not empty model.id}">
									<input type="button"
										   class="btn btn-white btn-warning btn-bold"
										   value="Cập nhật san Pham" id="btnAddOrUpdateSanPham" />
								</c:if>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function () {

	});
	$('#uploadImage').change(function () {
		viewImageBefore(this, 'viewImage');
	});
	$('#btnAddOrUpdateSanPham').click(function (e) {
		e.preventDefault();
		var dataArray = {};
		var formData = $('#formId').serializeArray();
		$.each(formData, function (i,v) {
			dataArray[""+v.name+""] = v.value;
		});
		var newId = $('#newId').val();
		var files = $("#uploadImage")[0].files[0];
		if (files == undefined) {
			addOrUpdate(newId, dataArray);
		} else {
			var reader = new FileReader();
			reader.onload = function(e) {
				dataArray["base64"] = e.target.result;
				dataArray["fileName"] = files.name;
				addOrUpdate(newId, dataArray);
			};
			reader.readAsDataURL(files);
		}
	});
	function addNew(data) {
		$.ajax({
			url: '${formUrl}',
			type: 'POST',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(data),
			success: function(res){
				window.location.href = "${editURL}?id="+res.id+"&message=insert";
			},
			error: function (res) {
				console.log(res);
			}
		});
	}
	function updateNew(data, id) {
		$.ajax({
			url: '${formUrl}/'+id,
			type: 'PUT',
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(data),
			success: function(res){
				window.location.href = "${editURL}?id="+id+"&message=update";
			},
			error: function (res) {
				console.log(res);
			}
		});
	}
	function addOrUpdate(newId, dataArray) {
		if (newId == "") {
			addNew(dataArray);
		} else {
			updateNew(dataArray, newId);
		}
	}
	function viewImageBefore(input,viewImage) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#'+viewImage).attr('src', reader.result);
			};
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
</body>
</html>
