<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<c:url value="/admin/locproduct" var="url"></c:url>


 <div class="inner-block">
                            <div class="inbox">
                                <h2>Quản Lý Sản Phẩm</h2>
                                <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                    <div class="tab-pane active text-style" id="tab1">
                                        <div class="mailbox-border">
                                            <div class="mail-toolbar clearfix">
                                                <div class="float-left">
                                                 <a href='<c:url value="/admin/tat-ca-san-pham"></c:url>' title="refesh">
                                                    <div class="btn btn_1 btn-default mrg5R">
                                                        <i class="fa fa-refresh"> </i>
                                                    </div>
                                                    </a>
                                                   <a href='<c:url value="/admin/them-san-pham"></c:url>' title="thêm">
                                                    <div class="btn btn_1 btn-default mrg5R">
                                                        <i class="fa fa-plus"> </i>
                                                    </div>
                                                   </a>
                                                    <div class="clearfix"> </div>
                                                </div>
                                                
                                                
                                                <form action="${url}" method="POST">
                                                <select name="category">
                                                <c:forEach items="${category}" var="category">
                                                <option value="${category.idCategory}">${category.nameCategory}</option> 
                                                </c:forEach>
                                               
                                                </select>
                                                <button>Lọc</button>
                                                </form>
                                                
                                                
                                                
                                                <div class="float-right">
                                                    <span class="text-muted m-r-sm">Showing 20 of 346 </span>
                                                    <div class="btn-group">
                                                        <a class="btn btn-default"><i class="fa fa-angle-left"></i></a>
                                                        <a class="btn btn-default"><i class="fa fa-angle-right"></i></a>
                                                    </div>	
                                                    <div class="clearfix"> </div>		        
                                                </div>
                                            </div>
                                            <table class="table tab-border">
                                                <tbody>
                                                    <tr class="unread checked">
                                                        <th class="hidden-xs">
                                                            +
                                                        </th>
                                                        <th class="hidden-xs">
                                                           Tên Sản Phẩm
                                                        </th>
                                                        <th>
                                                           Giá Tiền
                                                        </th>
                                                        <th>
                                                           Discount
                                                        </th>
                                                        <th>
                                                           Thời Gian 
                                                        </th>
                                                        <th>
                                                           Lượt Xem
                                                        </th>
                                                        <th>
                                                           Số lượng
                                                        </th>
                                                        <th>
                                                           Url
                                                        </th>
                                                        <th>
                                                           Ram
                                                        </th>
                                                        <th>
                                                          Loại
                                                        </th>
                                                         <th>
                                                          .
                                                        </th>
                                                        
                                                        
                                                    </tr>
                                                    <c:forEach items="${listProduct}" var="product">
                                                    <tr class="unread checked">
                                                        <td class="hidden-xs">
                                                            <a href='<c:url value="/admin/delete-san-pham?idproduct=${product.idProduct}"></c:url>'><img title="Delete" src='<c:url value="/resource/admin/images/close.png"></c:url>'></a>
                                                             <a href='<c:url value="/admin/update-product?idproduct=${product.idProduct}"></c:url>'><img title="Update" src='<c:url value="/resource/admin/images/update.png"></c:url>'></a>
                                                        </td>
                                                        <td class="hidden-xs">
                                                           ${product.nameProduct}
                                                        </td>
                                                        <td>
                                                           ${product.priceProduct}
                                                        </td>
                                                        <td>
                                                           ${product.discountProduct}
                                                        </td>
                                                        <td>
                                                           ${product.dateCreatedProduct}
                                                        </td>
                                                        <td>
                                                           ${product.viewProduct}
                                                        </td>
                                                        <td>
                                                           ${product.quantityProduct}
                                                        </td>
                                                        <td>
                                                           ${product.urlProduct}
                                                        </td>
                                                        <td>
                                                           ${product.ramProduct}
                                                        </td>
                                                         <td>
                                                           ${product.loaiProduct}
                                                        </td>
                                                        
                                                       
                                                        
                                                    </tr>
                                                    </c:forEach>
                                                    
                                                    
                                                    
                                                    
                                                    
                                                   
                                                                                                        
                                                </tbody>
                                            </table>
                                        </div>   
                                    </div>
                                </div>
                                <div class="clearfix"> </div>     
                            </div>
                        </div>