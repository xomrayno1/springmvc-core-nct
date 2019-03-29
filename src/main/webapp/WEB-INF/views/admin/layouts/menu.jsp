<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<div class="sidebar-menu">
		  	<div class="logo"> <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> <a href="#"> <span id="logo" ></span> 
			      <!--<img id="logo" src="" alt="Logo"/>--> 
			  </a> </div>		  
		    <div class="menu">
		      <ul id="menu" >
		        <li id="menu-home" ><a href='<c:url value="/admin/home"></c:url>'><i class="fa fa-tachometer"></i><span>Home</span></a></li>	
		        <li id="menu-academico" ><a href="#"><i class="fa fa-shopping-cart"></i><span>Sản Phẩm</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul id="menu-academico-sub" >
		          	 <li id="menu-academico-boletim" ><a href='<c:url value="/admin/them-san-pham"></c:url>'>Thêm Sản Phẩm</a></li>
		            <li id="menu-academico-avaliacoes" ><a href='<c:url value="/admin/tat-ca-san-pham"></c:url>'>Quản Lý Sản Phẩm</a></li>		           
		          </ul>
		        </li>
		        <li id="menu-academico" ><a href="#"><i class="fa fa-file-text"></i><span>Người Dùng</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul id="menu-academico-sub" >
		          	 <li id="menu-academico-boletim" ><a href='<c:url value="/admin/them-nguoi-dung"></c:url>'>Thêm Người Dùng</a></li>
		            <li id="menu-academico-avaliacoes" ><a href='<c:url value="/admin/tat-ca-nguoi-dung"></c:url>'>Quản Lý Người Dùng</a></li>		           
		          </ul>
		        </li>
		         
		        <li id="menu-comunicacao" ><a href="#"><i class="fa fa-bar-chart"></i><span>Order</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul id="menu-comunicacao-sub" >
		            
		            <li id="menu-arquivos" ><a href='<c:url value="/admin/tat-ca-don-hang"></c:url>'>Danh Sách Order</a></li>
		            
		            
		          </ul>
		        </li>
		        <li id="menu-academico" ><a href="#"><i class="fa fa-file-text"></i><span>Danh Mục</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul id="menu-academico-sub" >
		          	 <li id="menu-academico-boletim" ><a href='<c:url value="/admin/them-danh-muc"></c:url>'>Thêm Danh Mục</a></li>
		            <li id="menu-academico-avaliacoes" ><a href='<c:url value="/admin/category"></c:url>'>Quản Lý Danh Mục</a></li>		           
		          </ul>
		        </li>
		        
		        
		        
		         <li><a href="#"><i class="fa fa-cog"></i><span>System</span><span class="fa fa-angle-right" style="float: right"></span></a>
		         	 <ul id="menu-academico-sub" >
			            <li id="menu-academico-avaliacoes" ><a href='<c:url value="/404"></c:url>'>404</a></li>
			      
		             </ul>
		         </li>
		         

		      </ul>
		    </div>
	 </div>