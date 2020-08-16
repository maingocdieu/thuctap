<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng kí</title>
</head>
<body>
	<div class="position-relative">
		<div id="login-box" class="login-box visible widget-box no-border">
			<div class="widget-body">
				<div class="widget-main">
					<h4 class="header blue lighter bigger">
						<i class="ace-icon fa fa-coffee green"></i> Đăng kí
					</h4>
					<c:if test="${param.incorrectAccount != null}">
						<div class="alert alert-danger">Sai mật khẩu hay tài khoản</div>
					</c:if>
					<c:if test="${param.accessDenied != null}">
						<div class="alert alert-danger">Bạn không có quyền truy cập
							vào trang này</div>
					</c:if>
					<div class="space-6"></div>
					<form id="formId" class="form-horizontal loginFrm">
					<div class="control-group">
					<input type="text" class="span4"  name="userName"
					placeholder="Username">
					</div>

					<div class="control-group">
					<input type="password" class="span4" name="password"
					placeholder="Password">
					</div>
					<div class="control-group">
					<input type="text" class="span4"  name="fullName"
					placeholder="fullName">
					</div>
					<div class="control-group">
					<input type="email" class="span4" name="email"
					placeholder="Email">
					</div>

					<div class="control-group">
					<input type="text" class="span4" name="phone"
					placeholder="Phone">
					</div>
					<div class="control-group">

					<input type="button"
					class="btn btn-primary btn-bold"
					value="Đăng kí" id="btnAddUser" />
					</div>
					</form>
					<div class="space-6"></div>
				</div>
				<!-- /.widget-main -->
			</div>
			<!-- /.widget-body -->
		</div>
		<!-- /.login-box -->
	</div>
	<!-- /.position-relative -->
</body>
</html>