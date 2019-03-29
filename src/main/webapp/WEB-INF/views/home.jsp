<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<c:url value="/user/cartitem/home" var="url"></c:url>

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
						<h2 class="title text-center">Xem Nhiều Nhất</h2>
						
						
						<c:forEach items="${viewproduct}" var="viewproduct">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src='<c:url value="/resource/${viewproduct.imagesProduct}"></c:url>' alt="" />
											<h2>$${viewproduct.priceProduct}</h2>
											<a href='<c:url value="/${viewproduct.urlProduct}"></c:url>'><p>${viewproduct.nameProduct}</p></a>
											<a href="${url}/${viewproduct.idProduct}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
										
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href='<c:url value="/user/add-wish?idProduct=${viewproduct.idProduct}"></c:url>'><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
						</c:forEach>
						
						
						
						
						
						
					</div><!--features_items-->
					
					<div class="category-tab"><!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#tshirt" data-toggle="tab">Apple</a></li>
								<li><a href="#blazers" data-toggle="tab">Samsung</a></li>
								<li><a href="#sunglass" data-toggle="tab">Nokia</a></li>
								<li><a href="#kids" data-toggle="tab">Sony</a></li>
								<li><a href="#poloshirt" data-toggle="tab">Xiaomi</a></li>
							</ul>
						</div>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="tshirt" >
							
								<c:forEach items="${appleproduct}" var="apple">
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src='<c:url value="/resource/${apple.imagesProduct}"></c:url>' alt="" />
												<h2>$${apple.priceProduct}</h2>
												<a href='<c:url value="/${apple.urlProduct}"></c:url>'><p>${apple.nameProduct}</p></a>
												<a href='<c:url value="/${apple.urlProduct}"></c:url>' class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
								</c:forEach>
								
								
								
							</div>
							
							<div class="tab-pane fade" id="blazers" >
							
								<c:forEach items="${samsungproduct}" var="samsung">
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src='<c:url value="/resource/${samsung.imagesProduct}"></c:url>' alt="" />
												<h2>$${samsung.priceProduct}</h2>
												<p>Easy Polo Black Edition</p>
												<a href='<c:url value="/${samsung.urlProduct}"></c:url>'><p>${samsung.nameProduct}</p></a>
												<a href='<c:url value="/${samsung.urlProduct}"></c:url>' class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
								</c:forEach>
								
								
							</div>
							
							<div class="tab-pane fade" id="sunglass" >
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="resource/images/home/gallery3.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="resource/images/home/gallery4.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="resource/images/home/gallery1.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="resource/images/home/gallery2.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							
							<div class="tab-pane fade" id="kids" >
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="resource/images/home/gallery1.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="resource/images/home/gallery2.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="resource/images/home/gallery3.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="resource/images/home/gallery4.jpg" alt="" />
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							
							<div class="tab-pane fade" id="poloshirt" >
								<c:forEach items="${xiaomiproduct}" var="xiaomi">
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
											
												<img src='<c:url value="/resource/${xiaomi.imagesProduct}"></c:url>' alt="" />
												<h2>$${xiaomi.priceProduct}</h2>
												<a href='<c:url value="/${xiaomi.urlProduct}"></c:url>'><p>${xiaomi.nameProduct}</p></a>
												
												<a href='<c:url value="/${xiaomi.urlProduct}"></c:url>' class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
											</div>
											
										</div>
									</div>
								</div>
								</c:forEach>
								
					     	</div>
						</div>
					</div><!--/category-tab-->
					
				
					
				</div>
			</div>
		</div>
	</section>


