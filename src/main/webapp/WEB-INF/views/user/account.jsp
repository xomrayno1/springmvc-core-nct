<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<c:url value="/user/update" var="update"></c:url>
<c:url value="/user/update-mat-khau" var="updatepassword"></c:url>

<section id="form"><!--form-->
		<div class="container">
			<div class="row">
			
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>Cập Nhật  Thông Tin!</h2>
						<form action="${update}" method="POST">							
							<input type="text" placeholder="Nhập địa chỉ" name="diachi"/>
							<input type="text" placeholder="Nhập số điện thoại" name="sdt"/>
							<button type="submit" class="btn btn-default">Cập Nhật</button>
					  
						</form>
					</div><!--/sign up form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
				<div class="signup-form">
				
				<h2> Thông Tin Hiện Tại!</h2>
				<table border="1">
				<tr>
				<th>ID</th>
				<th>Username</th>
				<th>Địa Chỉ</th>
				<th>SDT</th>
				</tr>
				<tr>
				<td>${user.idUser}</td>
				<td>${user.username}</td>
				<td>${user.address}</td>
				<td>${user.sdt}</td>
				</tr>
				</table>
				<br>
				 <a href="${updatepassword}"><button  class="btn btn-default" style="background: red">Đổi Mật Khẩu</button></a>
				</div>
				</div>
			</div>
		</div>
</section><!--/form-->