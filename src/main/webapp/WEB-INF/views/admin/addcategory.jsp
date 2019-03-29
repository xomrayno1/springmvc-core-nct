<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="/admin/add-category" var="dangki"></c:url>

 <div class="inner-block">
                            <div class="inbox">
                                <h2>Thêm Danh Mục</h2>
                                <div class="col-md-12 compose-right">
                                    <div class="inbox-details-default">
                                        <div class="inbox-details-heading">
                                            Thêm Danh Mục
                                        </div>
                                        <div class="inbox-details-body">
                                            <div class="alert alert-info">
                                                Vui Lòng Điền Thông Tin
                                            </div>
                                            <form:form action="${dangki}" method="POST" modelAttribute="category"> 
                                            <label>Tên Danh Mục</label> 
                                            <form:input path="nameCategory"/>
                                            <p style="color: red"><form:errors path="nameCategory"/></p>
                                             <label>Url</label>
                                             <form:input path="urlCategory"/>
                                             <p style="color: red"><form:errors path="urlCategory"/></p>
                                            

							                                                        
                                                <input type="submit" value="Thêm"> 
                                            <p style="color: red">${mess}</p>

                                             </form:form>
                                            
                                        </div>
                                    </div>
                                </div>

                                <div class="clearfix"> </div>     
                            </div>
 </div>