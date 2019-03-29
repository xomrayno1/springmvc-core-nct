<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<c:url value="/admin/update" var="update"></c:url>



 <div class="inner-block">
                            <div class="inbox">
                                <h2>Quản Lý Người Dùng</h2>
                                <div class="col-md-12 mailbox-content  tab-content tab-content-in">
                                    <div class="tab-pane active text-style" id="tab1">
                                        <div class="mailbox-border">
                                            <div class="mail-toolbar clearfix">
                                                <div class="float-left">
                                                 <a href='<c:url value="/admin/tat-ca-nguoi-dung"></c:url>' title="f5">
                                                    <div class="btn btn_1 btn-default mrg5R">
                                                        <i class="fa fa-refresh"> </i>
                                                    </div>
                                                </a>    
                                                     <a href='<c:url value="/admin/them-nguoi-dung"></c:url>' title="Thêm Tài Khoản">
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
                                                            IDD
                                                        </th>
                                                        <th>
                                                            Tài Khoản
                                                        </th>
                                                         <th>
                                                           Mật Khẩu
                                                        </th>
                                                         <th>
                                                            SDT
                                                        </th>
                                                        <th>
                                                            Địa Chỉ
                                                        </th>
                                                        
                                                         <td>ROLE</td>
                                                         <td>Enable</td>
                                                         <th>
                                                           Cập Nhật ROLE
                                                        </th>
                                                       
                                                        
                                                    </tr>
                                                    
                                                    
                                                   <c:forEach items="${listUser}" var="listUser">
                                                   
                                                    <tr class="unread checked">
                                                        <td class="hidden-xs">                                                      
                               
                                                         <a href='<c:url value="/admin/update/xoa?idUser=${listUser.idUser}"></c:url>'><img title="Delete" src='<c:url value="/resource/admin/images/close.png"></c:url>'></a>   
                                                        </td>
                                                        <td class="hidden-xs">
                                                             ${listUser.idUser}
                                                        </td>
                                                        <td >
                                                            ${listUser.username}
                                                        </td>
                                                       
                                                        <td>
                                                            ${listUser.password}
                                                        </td>
                                                        <td>                                                           
                                                             ${listUser.sdt}
                                                        </td>
                                                        <td>                                                           
                                                             ${listUser.address}
                                                        </td>
                                                        
                                                        <td>${listUser.role}</td>
                                                        
                                                        <td>${listUser.enabled}</td>
                                                         
                                                        <form action='<c:url value="/admin/update/cap-nhat?idUser=${listUser.idUser}"></c:url>' method="POST">
                                                        <td>
                                                    
                                                        <select name="role" >
                                                        <option value="ROLE_USER">User</option>
                                                        <option value="ROLE_ADMIN">Admin</option>
                                                        </select>
                                                                                                               
                                                        </td>
                                                        
                                                       
                                                        <td>
                                                        <button type="submit">Cập Nhật</button>
                                                        </td>
                                                     </form>

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