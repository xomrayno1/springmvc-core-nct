<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>




<c:set value="0" var="total"/>
 <div class="inner-block">
                            <div class="inbox">
                                <h2>Chi Tiết Đơn Hàng</h2>
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
                                                            +
                                                        </th>
                                                        <th class="hidden-xs">
                                                           Id
                                                        </th>
                                                        <th>
                                                         Sản Phẩm
                                                        </th>                                                       
                                                        <th>
                                                           Giá Tiền/1
                                                        </th>
                                                        <th>
                                                         Số Lượng
                                                        </th>
                                                        <th>
                                                           Giá Tiền/số lượng
                                                        </th>
                                                        
                                                        
                                                        
                                                    </tr>
                                                    
                                                    <c:forEach items="${bill}" var="bill">  
                                                    <tr class="unread checked">
                                                        <td class="hidden-xs">
                                                            <a href='<c:url value="#"></c:url>'><img title="Chi Tiết" src='<c:url value="/resource/admin/images/update.png"></c:url>'></a>
                                                            <a href='<c:url value="#"></c:url>'><img title="Xóa" src='<c:url value="/resource/admin/images/close.png"></c:url>'></a>
                                                        </td>
                                                        <td class="hidden-xs">
                                                           ${bill.idCartItem}
                                                        </td>
                                                        <td>
                                                           ${bill.product.nameProduct}
                                                        </td>
                                                        <td>
                                                            ${bill.product.priceProduct}.VND
                                                        </td>
                                                        <td>
                                                           ${bill.quantity}
                                                        </td>
                                                         <td>
                                                           ${bill.totalPrice}.VND
                                                        </td>                                                      
                                                        
                                                <c:set value="${total=total+bill.totalPrice}" var="total"/>       
                                                       
                                                 <c:set value="${bill.idbill}" var="idbill"/>           
                                                    </tr>
                                                    </c:forEach>
                                                    
                                                    
                                                    
                                                    
                                                    
                                                   
                                                                                                        
                                                </tbody>
                                            </table>
                                            <p>Tên Tài Khoản : ${user.username}<p> 
                                            <p>SDT : ${user.sdt}</p> 
                                            <p>Địa Chỉ: ${user.address}</p>
                                            Tổng Tiền Cần Thanh Toán : ${total} .VND <a href='<c:url value="/admin/xu-ly/?idbill=${idbill}"></c:url>'><button>Xử Lý</button></a>
                                            <a href='<c:url value="/admin/tat-ca-don-hang"></c:url>'><button>Quay lại Đơn Hàng</button></a>
                                        </div>   
                                    </div>
                                </div>
                                <div class="clearfix"> </div>     
                            </div>
                        </div>