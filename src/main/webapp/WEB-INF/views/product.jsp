<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<c:url value="/danh-muc" var="danhmuc"></c:url>


<section id="advertisement">
		<div class="container">
			<img src='<c:url value="/resource/images/shop/advertisement.jpg"></c:url>' alt="" />
		</div>
	</section>
<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							
						
							
						
							<c:forEach items="${category}" var="category">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="">${category.nameCategory}</a></h4>
								</div>
							</div>
							</c:forEach>
						</div><!--/category-products-->
					
						
						
						
						
						<div class="shipping text-center"><!--shipping-->
							<img src='<c:url value="/resource/images/home/shipping.jpg"></c:url>' alt="" />
						</div><!--/shipping-->
						
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						
						
						<c:forEach items="${product}" var="product">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src='<c:url value="/resource/${product.imagesProduct}"></c:url>' alt="" />
										<h2>$${product.priceProduct}</h2>
									
									<p><a href='<c:url value="/${product.urlProduct}"></c:url>'>${product.nameProduct}</a></p>
										<a href='<c:url value="/${product.urlProduct}"></c:url>' class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
									
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href='<c:url value="/user/add-wish?idProduct=${product.idProduct}"></c:url>'><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
										<li><a href=""><i class="fa fa-plus-square"></i>Add to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
						</c:forEach>
						
						

						
					
						<c:set value="0" var="value" />
						
						<ul class="pagination">
				
							
                            <c:forEach begin="1" end="${countpage}">
                            
                            <c:set value="${value=value+1}" var="value" />
                            
                            <li><a href="${danhmuc}/${loai}/${url}/?page=${value}">${value}</a></li>
                            
                            </c:forEach>
							
						
							
						</ul>
					</div><!--features_items-->
				</div>
			</div>
		</div>
	</section>