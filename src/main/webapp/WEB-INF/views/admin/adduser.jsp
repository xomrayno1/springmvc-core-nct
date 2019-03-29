<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="/admin/add-user" var="dangki"></c:url>

 <div class="inner-block">
                            <div class="inbox">
                                <h2>Thêm Người Dùng</h2>
                                <div class="col-md-12 compose-right">
                                    <div class="inbox-details-default">
                                        <div class="inbox-details-heading">
                                            Thêm Thông  Tin
                                        </div>
                                        <div class="inbox-details-body">
                                            <div class="alert alert-info">
                                                Vui Lòng Điền Thông Tin
                                            </div>
                                            <form:form action="${dangki}" method="POST" modelAttribute="user">  
                                            
                                                <label>Tài Khoản</label>                                          
                                                <form:input path="username" placeholder="Nhập Tài Khỏan"/>
                                                <p style="color: red"><form:errors  path="username"/></p>
                                                <label>Mật Khẩu</label><br>                                    
                                                <form:password path="password"  placeholder="Nhập Mật Khẩu"/><br>
                                                <p style="color: red"><form:errors  path="password"/></p>
                                                <label>Địa Chỉ</label><br>
                                               
                                                <form:input path="address" placeholder="Nhập Địa Chỉ"/>
                                                <p style="color: red"><form:errors  path="address"/></p>
                                                <label>SDT</label>                                      
                                                 <form:input path="sdt" placeholder="Nhập Số Điện Thoại"/>
                                                  <p style="color: red"><form:errors  path="sdt"/></p>                    
                                                 <form:hidden path="enabled" value="1"/>
							                     <form:hidden path="role" value="ROLE_USER"/>   
							                                                        
                                                <input type="submit" value="Thêm"> 
                                            <p style="color: red">${mess}</p>
                                             </form:form>
                                            
                                        </div>
                                    </div>
                                </div>

                                <div class="clearfix"> </div>     
                            </div>
 </div>