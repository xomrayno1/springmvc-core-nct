<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="/user/them-user" var="dangki"></c:url>

<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>Đăng kí tài khoản mới !</h2>
						
							<form:form method="POST" action="${dangki}" modelAttribute="user" >
							
							<form:input path="username" placeholder="Nhập tài khoản"/>
							<p style="color: red"><form:errors  path="username"/></p>
							<form:password path="password" placeholder="Nhập mật khẩu"/>
							<p style="color: red"><form:errors  path="password"/></p>
							<form:input path="address" placeholder="Nhập địa chỉ"/>
							<p style="color: red"><form:errors  path="address"/></p>
							<form:input path="sdt" placeholder="Nhập số điện thoại"/>
							<p style="color: red"><form:errors  path="sdt"/></p>
							
						
							<form:hidden path="enabled" value="1"/>
							<form:hidden path="role" value="ROLE_USER"/>
							<button type="submit" class="btn btn-default">Đăng Kí</button>
							
							</form:form>
						<p style="color: red">${mess}</p>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->