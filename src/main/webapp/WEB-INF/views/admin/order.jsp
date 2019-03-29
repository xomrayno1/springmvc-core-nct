<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>





 <div class="inner-block">
                            <div class="inbox">
                                <h2>Order</h2>
                                <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                    <div class="tab-pane active text-style" id="tab1">
                                        <div class="mailbox-border">
                                            <div class="mail-toolbar clearfix">
                                                <div class="float-left">
                                                    <a href='<c:url value="/admin/tat-ca-don-hang"></c:url>' title="refesh">
                                                    <div class="btn btn_1 btn-default mrg5R">
                                                        <i class="fa fa-refresh"> </i>
                                                    </div>
                                                    </a>
                                                    <div class="btn btn_1 btn-default mrg5R">
                                                        <i class="fa fa-plus"> </i>
                                                    </div>
                                                    <div class="clearfix"> </div>
                                                </div>
                                                <form action='<c:url value="/admin/locorder"></c:url>' method="POST">
                                                <select name="status">
                                                <option value="0">Chưa Xử Lý</option>
                                                <option value="1">Đã Xử Lý</option>
                                                </select>
                                                <button type="submit">Lọc</button>
                                                </form>
                                                Xuất :<a href='<c:url value="/admin/xuat-excel"></c:url>'><img alt="" src='<c:url value="/resource/images/excel.png"></c:url>'></a>
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
                                                          Mã Đơn Hàng
                                                        </th>
                                                        <th>
                                                          IdUser Đặt Hàng
                                                        </th>
                                                        
                                                        <th>
                                                           Thời gian
                                                        </th>
                                                        <th>
                                                         Tình Trạng
                                                        </th>
                                                        
                                                        
                                                        
                                                    </tr>
                                                    
                                                    <c:forEach items="${bill}" var="bill">  
                                                    <tr class="unread checked">
                                                        
                                                        <td class="hidden-xs">
                                                         <a href='<c:url value="/admin/chi-tiet-don-hang?idbill=${bill.idBill}&iduser=${bill.idUser}"></c:url>'><img title="chi tiết" src='<c:url value="/resource/admin/images/update.png"></c:url>'></a>
                                                        
                                                        </td>
                                                        <td >
                                                          ${bill.idBill}
                                                        </td>
                                                        <td>
                                                           ${bill.idUser}
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