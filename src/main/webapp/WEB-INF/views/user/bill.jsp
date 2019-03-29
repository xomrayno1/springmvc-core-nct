<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<c:url value="/user/update-cart" var=" updatecart"></c:url>

<c:set value="0" var="total"/>
<c:forEach items="${sessionScope.listCartItem}" var="listcart">
<c:set value="${total=total+listcart.totalPrice}" var="total"/>
</c:forEach>


<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>Bill</h3>
				<p style="color: red">${mess}</p>
			</div>
			<div class="row">
				
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Số Sản Phẩm :  <span>${fn:length(listCartItem)}</span></li> 
							<li>Tiền Ship <span>Free</span></li>
							<li>Tổng Tiền <span>$${total}</span></li>
						</ul>
							<a class="btn btn-default update" href='<c:url value="/user/cart"></c:url>'>Quay lại giỏ hàng</a>
							<a class="btn btn-default check_out" href='<c:url value="/user/chap-nhan"></c:url>'>Chấp Nhận</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->