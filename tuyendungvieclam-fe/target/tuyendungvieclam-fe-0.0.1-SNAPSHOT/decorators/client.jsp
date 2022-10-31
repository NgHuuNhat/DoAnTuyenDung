	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
<title>Tuyen dung</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<c:url value='/template/client/assets/css/style.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/template/client/css/mystyle.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/template/client/assets/css/ie.css'/>">
<script type='text/javascript' src='<c:url value="/template/admin/assets/js/jquery.min.js"/>'></script><!-- 3.5.1 -->
</head>
<body>
	<div id="wrapper">
		<%@ include file="/common/client/header-client.jsp"%>
		<div id="body">
	   			<dec:body/>
	    </div>
	</div>
	<%@ include file="/common/client/footer-client.jsp"%>
	<script type="text/javascript" src="<c:url value='/template/client/assets/js/unitpngfix.js'/>"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>