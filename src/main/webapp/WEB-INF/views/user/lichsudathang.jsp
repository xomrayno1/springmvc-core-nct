<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<c:url value="/user/update-password" var="update"></c:url>


<div class="inner-block">
                            <div class="inbox">
                                <h2>Lịch Sử đặt hàng</h2>
                                <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                    <div class="tab-pane active text-style" id="tab1">
                                        <div class="mailbox-border">
                                            <div class="mail-toolbar clearfix">
                                                <div class="float-left">
                                                    <div class="btn btn_1 btn-default mrg5R">
                                                        <i class="fa fa-refresh"> </i>
                                                    </div>
                                                    <div class="btn btn_1 btn-default mrg5R">
                                                        <i class="fa fa-plus"> </i>
                                                    </div>
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
                                                           Chi tiêt
                                                        </th>
                                                        <th class="hidden-xs">
                                                           Id
                                                        </th>
                                                        <th>
                                                         Thời Gian
                                                        </th>                                                       
                                                        <th>
                                                          Tình Trạng
                                                        </th>
                                                        
                                                        
                                                        
                                                        
                                                    </tr>
                                                    
                                                 <c:forEach items="${bill}" var="bill"> 
                                                    <tr class="unread checked">
                                                        <td class="hidden-xs">
                                                            <a href='<c:url value="/user/chi-tiet-don-hang?idbill= ${bill.idBill}"></c:url>'><img title="Chi Tiết" src='<c:url value="/resource/admin/images/update.png"></c:url>'></a>
                                                      
                                                        </td>
                                                        <td class="hidden-xs">
                                                         ${bill.idBill}
                                                        </td>
                                                        <td>
                                                          ${bill.date}
                                                        </td>
                                                        <td>
                                                         ${bill.status}
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