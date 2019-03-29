<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<c:url value="/user/update-cart" var=" updatecart"></c:url>

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listCartItem}" var="cartitem">
						<tr>
							<td class="cart_product">
								<a href=""><img style="width: 200px  ;height: 150px;" src='<c:url value="/resource/${cartitem.product.imagesProduct}"></c:url>' alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href='<c:url value="/${cartitem.product.urlProduct}"></c:url>'>${cartitem.product.nameProduct}</a></h4>
								
							</td>
							<td class="cart_price">
								<p>$${cartitem.product.priceProduct}</p>
							</td>
							
							
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<form action='<c:url value="/user/update-cart"></c:url>' method="get"> 
									
									<input class="cart_quantity_input" type="number" name="quantity" max="10" min="1"  value="${cartitem.quantity}" >
									<input type="hidden" name="idProduct" value="${cartitem.product.idProduct}">
									<button type="submit" style="background: orange;">Cập Nhật</button>
								  </form>
								  
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">$${cartitem.totalPrice}</p> 
								
							</td>
							
							<td class="cart_delete">
								<a class="cart_quantity_delete" href='<c:url value="/user/drop-cart?idProduct=${cartitem.product.idProduct}"></c:url>'><i class="fa fa-times"></i></a> 
							</td>
						</tr>
						</c:forEach>

					 
					</tbody>
				</table>
				
				<a  class="btn btn-default update" href='<c:url value="/user/thanh-toan"></c:url>' >Thanh Toán</a>
			</div>
			
		</div>
		
	</section> <!--/#cart_items-->
	

	