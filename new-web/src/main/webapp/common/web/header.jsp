<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/api/user" />
<c:url var="editURL" value="/trang-chu" />
<%@ page import="com.example.security.util.SecurityUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="topNav">
		<div class="container">
			<div class="alignR">
				<div class="pull-left socialNw">
					<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
						class="icon-facebook"></span></a> <a href="#"><span
						class="icon-youtube"></span></a> <a href="#"><span
						class="icon-tumblr"></span></a>
				</div>
				<security:authorize access="isAnonymous()">
				<ul style="margin: 2px" class="nav pull-right">
					<%--<li class="dropdown"><a data-toggle="dropdown"--%>
											<%--class="dropdown-toggle" href="#"><span class="icon-lock"></span>--%>
						<%--Login <b class="caret"></b></a>--%>
						<%--<div class="dropdown-menu">--%>
							<%--<form action="j_spring_security_check" method="POST" class="form-horizontal loginFrm">--%>
								<%--<div class="control-group">--%>
									<%--<input type="text" class="span2"  name="j_username"--%>
										   <%--placeholder="Username">--%>
								<%--</div>--%>
								<%--<div class="control-group">--%>
									<%--<input type="password" class="span2" name="j_password"--%>
										   <%--placeholder="Password">--%>
								<%--</div>--%>
								<%--<div class="control-group">--%>

									<%--<button type="submit" class="shopBtn btn-block">Sign--%>
										<%--in</button>--%>
								<%--</div>--%>
							<%--</form>--%>
						<%--</div></li>--%>
						<li class="" style="margin-right: 4px"><a
								class="btn btn-success" href='<c:url value="/dang-ki"/>'>
							<span style="color: white">Đăng kí</span></a>
						</li>
						<li class=""><a
												class="btn btn-primary" href='<c:url value="/dang-nhap"/>'><span class="icon-lock"></span>
							<span style="color: white">Đăng nhập</span></a>
						</li>

				</ul>

				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<a href="#">Xin chào <%=SecurityUtils.getPrincipal().getFullName()%></a>
					<a href='<c:url value="/logout"/>'>Thoát</a>
				</security:authorize>
			</div>
		</div>
	</div>
</div>


<!--
Lower Header Section
-->
<div class="container">

	<div id="gototop"></div>
	<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="/trang-chu"><span>Twitter Bootstrap
						ecommerce template</span> <img
						src="<c:url value='/template/web/img/logo-bootstrap-shoping-cart.png'/>"
					alt="bootstrap sexy shop"> </a>
			</h1>
		</div>
		<div class="span4">
			<div class="offerNoteWrapper">

			</div>
		</div>
		<div class="span4 alignR">
			<p>
				<br> <strong> Support (24/7) : 0800 1234 678 </strong><br>
				<br>
			</p>
			<span class="btn btn-mini">[ 2 ] <span
				class="icon-shopping-cart"></span></span>
		</div>
	</div>
	</header>

	<!--
    Navigation Bar Section
    -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container">
				<a data-target=".nav-collapse" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>

				<div class="nav-collapse">
					<ul class="nav">
						<li class=""><a href="/trang-chu">Home </a></li>
						<li class=""><a href="#">Menu </a></li>
					</ul>
					<form action="#" class="navbar-search pull-left">
						<input type="text" placeholder="Search" class="search-query span2">
					</form>

				</div>
			</div>
		</div>
	</div>
