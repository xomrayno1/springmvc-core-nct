<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  
</head><!--/head-->

<body>
	<div class="container text-center">
		<div class="logo-404">
			<a href="home"><img src='<c:url value="/resource/images/home/logo.png"></c:url>' alt="" /></a>
		</div>
		<div class="content-404">
			<img src='<c:url value="/resource/images/404/404.png"></c:url>' class="img-responsive" alt="" />
			<h1><b>OPPS!</b> We Couldn’t Find this Page</h1>
			<p>Uh... So it looks like you brock something. The page you are looking for has up and Vanished.</p>
			<h2><a href='<c:url value="/home"></c:url>'>Bring me back Home</a></h2>
		</div>
	</div>

  
    
</body>
</html>