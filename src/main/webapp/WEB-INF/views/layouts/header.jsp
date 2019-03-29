<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<c:url value="/danh-muc" var="danhmuc"></c:url>
<c:url value="/dang-xuat" var="exits"></c:url>
<c:url value="/tim-kiem/1" var="timkiem"></c:url>
<c:url value="/user/cart" var="cart"></c:url>

<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
								
								<security:authorize access="isAuthenticated()">
								<security:authentication property="principal" var="user"/>
								<li><a href="#"><i class="fa fa-envelope"></i>Xin chào,${user.username}</a></li>
               
								</security:authorize>
								
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href='<c:url value="/home"></c:url>'><img src='<c:url value="/resource/images/home/logo.png"></c:url>' alt="" /></a>
						</div>
						

					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href='<c:url value="/user/account"></c:url>'><i class="fa fa-user"></i> Account</a></li>
								<li><a href='<c:url value="/user/wish"></c:url>'><i class="fa fa-star"></i> Wishlist</a></li>
								<li><a href="${cart}"><i class="fa fa-shopping-cart"></i> Cart</a></li>
								<li><a href='<c:url value="/user/lich-su-dat-hang"></c:url>'><i class="fa fa-shopping-cart"></i>Lịch Sử Đặt Hàng</a></li>
								<security:authorize access="!isAuthenticated()"> 
								<li><a href='<c:url value="/login"></c:url>'><i class="fa fa-lock"></i> Login</a></li>
								 </security:authorize>
								 
								
								 <security:authorize access="isAuthenticated()">
								 <li><a href="${exits}"><i class="fa fa-lock"></i> Thoát</a></li>
								
								 </security:authorize>
 
								
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href='<c:url value="/home"></c:url>' class="active">Home</a></li>
                                <li class="dropdown"><a href="#">Điện Thoại<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                       
										<c:forEach var="category" items="${category}">
										 <li><a href="${danhmuc}/dien-thoai/${category.urlCategory}?page=1">${category.nameCategory}</a></li>
										</c:forEach>
                                    </ul>
                                </li>  
                                
								<li class="dropdown"><a href="#">Máy Tính Bảng<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                       
										<c:forEach var="category" items="${category}">
										 <li><a href="${danhmuc}/may-tinh-bang/${category.urlCategory}?page=1">${category.nameCategory}</a></li>
										</c:forEach>
                                    </ul>
                                </li> 
                                
                                <li><a href="#">Thiết bị khác</a></li>
								<li><a href="#">404</a></li>
								<li><a href="contact-us.html">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<form action="${timkiem}" method="get">
							<input type="text" placeholder="Nhập sản Phẩm" name="name"/>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->