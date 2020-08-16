<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<C:url var="news" value="" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>
<body>

	<!--
Body Section
-->
	<div class="row">
		<div class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">

						<c:forEach items="${categories}" var="item">
							<li><a href="/trang-chu/${item.code}"><span
									class="icon-chevron-right"></span>${item.name}</a></li>
						</c:forEach>

				</ul>
			</div>
			</div>
		<div class="span9">

		<div class="well well-small">
			<h3> Featured Products  </h3>
			<hr class="soften"/>
			<div class="row-fluid">
				<ul class="thumbnails">
					<c:forEach items="${listSP}" var="item">
						<li class="span4">
							<div class="thumbnail">
								<a href="#" class="overlay"></a>
								<a class="zoomTool" href="#" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
								<a href="#"><img src="<c:url value='/repository/${item.thumbnail}'/>" alt=""></a>
								<div class="caption cntr">
									<p>Manicure & Pedicure</p>
									<p><strong> $22.00</strong></p>
									<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
									<div class="actionList">
										<a class="pull-left" href="#">Add to Wish List </a>
										<a class="pull-left" href="#"> Add to Compare </a>
									</div>
									<br class="clr">
								</div>
							</div>
						</li>
					</c:forEach>

				</ul>


			</div>
		</div>



	</div>
</body>
</html>