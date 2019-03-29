<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | E-Shopper</title>
    <link href='<c:url value="/resource/css/bootstrap.min.css"></c:url>' rel="stylesheet">
    <link href='<c:url value="/resource/css/font-awesome.min.css"></c:url>' rel="stylesheet">
    <link href= '<c:url value="/resource/css/prettyPhoto.css"></c:url>'  rel="stylesheet">
    <link href='<c:url value="/resource/css/price-range.css"></c:url>' rel="stylesheet">
    <link href='<c:url value="/resource/css/animate.css"></c:url>'rel="stylesheet">
	<link href='<c:url value="/resource/css/main.css"></c:url>'rel="stylesheet">
	<link href='<c:url value="/resource/css/responsive.css"></c:url>' rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href='<c:url value="/resource/images/ico/favicon.ico"></c:url>'>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href='<c:url value="/resource/images/ico/apple-touch-icon-144-precomposed.png"></c:url>'>
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resource/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resource/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="resource/images/ico/apple-touch-icon-57-precomposed.png">
  
</head>
<body>
<tiles:insertAttribute  name="header"/>
<tiles:insertAttribute  name="banner"/>
<tiles:insertAttribute  name="body"/>
<tiles:insertAttribute  name="footer"/>
</body>
</html>