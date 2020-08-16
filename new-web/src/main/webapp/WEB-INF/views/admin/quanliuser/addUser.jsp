<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/api/admin/new" />
<c:url var="news" value="/admin/new/list" />
<c:url var="editURL" value="/admin/new/edit" />
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

						<div class="col-xs-12">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Email
								</label>
								<div class="col-sm-9">
									<input class="form-control" type="text">
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Userame</label>
								<div class="col-sm-9">
									<input class="form-control" type="text">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Password</label>
								<div class="col-sm-9">
									<input class="form-control" type="text">
								</div>
							</div>



						</div>

				</div>
			</div>
		</div>
	</div>


</body>
</html>
