<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<c:url value="/user/update-password" var="update"></c:url>


<section id="form"><!--form-->
		<div class="container">
			<div class="row">
			
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>Đổi Mật khẩu!</h2>
						<form action="${update}" method="POST">							
							<input type="password" placeholder="Nhập mật khẩu mới" name="newpassword"/>
							
							<input type="password" placeholder="Nhập lại mật khẩu mới" name="repnewpassword"/>
							<button type="submit" class="btn btn-default">Cập Nhật</button>
					  <p style="color: red">${mess}</p>
						</form>
					</div><!--/sign up form-->
				</div>
				
		
			</div>
		</div>
</section><!--/form-->