<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url value="/user/update-cart" var=" updatecart"></c:url>


<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<c:if test="${fn:length(wishlist)==5}">
				<h5 style="color: red">Đã Tối Đa, Xóa bớt để thêm</h5>
			</c:if>
			<h4>Danh Sách Item Yêu Thích , Tối Đa 5 Item</h4>
			
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${wishlist}" var="wish">
					
					
						<tr>
							<td class="cart_product">
								<a href='<c:url value="/${wish.urlProduct}"></c:url>'><img  title="wishlist" style="width: 200px ; height: 150px"  src='<c:url value="/resource/${wish.imagesProduct}"></c:url>' alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href='<c:url value="/${wish.urlProduct}"></c:url>'>${wish.nameProduct}</a></h4>
							
							</td>
							<td class="cart_price">
								<p>$${wish.priceProduct}</p>
							</td>
						
							
							<td class="cart_delete">
								<a class="cart_quantity_delete" href='<c:url value="/user/drop-wish?idProduct=${wish.idProduct}"></c:url>'><i class="fa fa-times"></i></a>
							</td>
						</tr>

				</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->l>