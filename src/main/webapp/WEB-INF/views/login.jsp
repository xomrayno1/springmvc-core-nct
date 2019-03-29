<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="/user/dang-nhap" var="login"></c:url>
<c:url value="/register" var="dangki"></c:url>

<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Đăng nhập tài khoản</h2>
						<form action="${login}" method="POST" >
							<input type="text" name="username" placeholder="Nhập tài khoản" />
							<input type="password"  name="password" placeholder="Nhập mật khẩu" />
							<span>
								<input type="checkbox" class="checkbox"> 
								Lưu
							</span>
							<p style="color: red">${mess}</p>
							<button type="submit" class="btn btn-default">Đăng Nhập</button>
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<a href="${dangki}"><button type="submit" class="btn btn-default">Đăng Kí</button></a>
				
			</div>
		</div>
	</section><!--/form-->