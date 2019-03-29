<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>





 <div class="inner-block">
                            <div class="inbox">
                                <h2>Category</h2>
                                <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                    <div class="tab-pane active text-style" id="tab1">
                                        <div class="mailbox-border">
                                            <div class="mail-toolbar clearfix">
                                                <div class="float-left">
                                                    
                                                    <div class="btn btn_1 btn-default mrg5R" >
                                                        <i class="fa fa-refresh"> </i>
                                                    </div>
                                                    
                                                    <a href="#" title="thêm">
                                                    <div class="btn btn_1 btn-default mrg5R">
                                                        <i class="fa fa-plus"> </i>
                                                    </div>
                                                    </a>
                                                    <div class="clearfix"> </div>
                                                </div>

                                                
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
                                                        
                                                       
                                                        
                                                        <th>
                                                          ID
                                                        </th>
                                                        <th>
                                                         Tên
                                                        </th>
                                                        <th>
                                                         Đường dẫn
                                                        </th>
                                                        
                                                        
                                                        
                                                    </tr>
                                                    
                                                    <c:forEach items="${category}" var="category">  
                                                    <tr class="unread checked">
                                                        <td class="hidden-xs">
                                                            <a href="#"><img title="Sữa" src='<c:url value="/resource/admin/images/update.png"></c:url>'></a>
                                                            <a href='<c:url value="/admin/delete-danh-muc?idcategory=${category.idCategory}"></c:url>'><img title="Xóa" src='<c:url value="/resource/admin/images/close.png"></c:url>'></a>
                                                        </td>
                                                        <td>                                                      
                                                           ${category.idCategory}
                                                        </td>
                                                        <td>
                                                           ${category.nameCategory}
                                                        </td>
                                                        <td>
                                                            ${category.urlCategory}
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