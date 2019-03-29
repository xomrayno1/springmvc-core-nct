<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:url value="/admin/add-product" var="url"></c:url>

 <div class="inner-block">
                            <div class="inbox">
                                <h2>Thêm Sản Phẩm</h2>
                                <div class="col-md-12 compose-right">
                                    <div class="inbox-details-default">
                                        <div class="inbox-details-heading">
                                            Compose New Message 
                                        </div>
                                        <div class="inbox-details-body">
                                            <div class="alert alert-info">
                                                Nhập Thông Tin Sản Phẩm
                                            </div>
                                            
                                            <form:form method="POST" action="${url}" modelAttribute="product" enctype="multipart/form-data">
                                            <label>Tên Sản Phẩm</label>
                                            <form:input path="nameProduct"/>
                                            <p style="color: red"><form:errors path="nameProduct"></form:errors></p>
                                            <label>Giá Tiền</label>
                                            <form:input path="priceProduct"/>
                                            <label>Discount</label>
                                            <form:input path="discountProduct"/>
                                            <label>Số Lượng</label>
                                            <form:input path="quantityProduct"/>
                                            <label>Url</label>
                                            <form:input path="urlProduct"/>
                                            <p style="color: red"><form:errors path="nameProduct"></form:errors></p>
                                            <label>Ram</label>
                                            <form:input path="ramProduct"/>
                                            <label>Loại</label>
                                            <form:select path="loaiProduct">
                                            <form:option value="dien-thoai">Điện Thoại</form:option>
                                            <form:option value="may-tinh-bang">Máy Tính Bảng</form:option>
                                            </form:select>
                                            <br>
                                            <br>
                                            	
                                            <label>Danh Mục</label>
                                            <form:select path="idCategory">
                                            <form:option value="1">Samsung</form:option>
                                            <form:option value="2">Sony</form:option>
                                            <form:option value="3">Nokia</form:option>
                                            <form:option value="4">Apple</form:option>
                                            <form:option value="5">Xiaomi</form:option>
                                            </form:select>
                                           
                                          <br>
                                          <br>
                                            <form:input path="multipartResolver" type="file" />
                                            <form:hidden path="viewProduct" value="1"/>
                                            <input type="submit" value="Thêm"> 
                                            </form:form>
                                           <p style="color: red"> ${mess}</p>
                                            
                                        </div>
                                    </div>
                                </div>

                                <div class="clearfix"> </div>     
                            </div>
 </div>