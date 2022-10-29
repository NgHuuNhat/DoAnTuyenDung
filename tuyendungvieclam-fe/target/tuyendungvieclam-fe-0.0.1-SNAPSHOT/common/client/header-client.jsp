<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.tuyendungvieclam.security.SecurityUtils"%>
<!DOCTYPE html>
<div id="header">
	
	<div style="padding: 5px 100px; background-color: beige; display: flex; justify-content: space-between; align-items: center;">
		<h2><a href="<c:url value='/'/>" style="color: black;">Tuyển Dụng Việc Làm</a></h2>
		<div class="nav-search">
            <form action="" class="search" method="post">
                <input type="text" class="searchTerm" id="search" placeholder="Tìm kiếm ...">
            </form>
        </div>
		<div>
			<security:authorize access="!isAuthenticated()">
				<div style="display: flex;">
					<li><a style="text-decoration: none; font-size: 15px;" href="<c:url value='/login'/>">Login</a></li>
					<li><a style="text-decoration: none; font-size: 15px;" href="<c:url value='/login/register'/>">Dang ky</a></li>
				</div>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<div style="display: flex;">
					<li><a style="text-decoration: none; font-size: 15px;" class="login" href="<c:url value='/logout'/>">Logout</a></li>
					<li><span style="font-size: 15px;" id="userNameLogin"><security:authentication property="name"/></span></li>
				</div>	
			</security:authorize>
		</div>
	</div>
	
	<ul style="padding: 5px 100px;">
		<li class="f"><a href="<c:url value='/'/>">Home</a></li>
		<li><a href="#">Việc làm</a></li>
		<li><a href="#">Hồ sơ & CV</a></li>
		<li><a href="#">Công ty</a></li>
	</ul>
	
	<hr>
	
</div>
<!-- <script type="text/javascript">
	function timkiem(){
		var 
	}
</script> -->
