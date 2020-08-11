<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><dec:title default="Trang chủ" /></title>

<!-- css -->
<link
	href="<c:url value='/template/web/font-awesome/css/font-awesome.css' />"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/template/web/css/style.css' />"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/template/web/css/bootstrap.css' />"
	rel="stylesheet" />
<link href="<c:url value='/template/web/ico/favicon.ico' />"
	rel="stylesheet" />
<!-- jquery -->

</head>
<body>
	<div class="wrap">
		<!-- header -->
		<%@ include file="/common/web/header.jsp"%>
		<!-- header -->
		<dec:body />
	</div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->


	<a href="#" id="toTop"> <span id="toTopHover"> </span>
	</a>

	<!-- javascript -->
	<script type="text/javascript"
		src="<c:url value='/template/web/js/jquery.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/js/shop.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/js/jquery.easing-1.3.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/js/jquery.scrollTo-1.4.3.1-min.js' />"></script>

</body>
</html>