<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<div class="sidebar" data-color="purple" data-background-color="white"
	data-image='<c:url value="/template/admin/assets/images/sidebar-1.jpg"/>'>
	<!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
	<div class="logo">
		<a href="<c:url value='/admin'/>"  class="simple-text logo-normal">
		    <i class="material-icons">star_border</i>
			MyMyPePes </a>
	</div>
	<div class="sidebar-wrapper">
		<ul class="nav">
			<li class="nav-item active  "><a class="nav-link"
				href="<c:url value='/admin'/>"> <i class="material-icons">dashboard</i>
					<p>ADMIN</p>
			</a></li>
			<li class="nav-item "><a class="nav-link" href="<c:url value='/admin/user'/>">
					<i class="material-icons">person</i>
					<p>User</p>
			</a></li>
			
			<li class="nav-item "><a class="nav-link" href="<c:url value='/admin/news'/>">
			        <i class="material-icons">library_books</i>
					<p>News</p>
			</a></li>
			
			<li class="nav-item "><a class="nav-link" href="<c:url value='/admin/comment'/>">
					<i class="material-icons">comment</i>
					<p>Comment</p>
			</a></li>
			
			<li class="nav-item "><a class="nav-link" href="<c:url value='/admin/booktour'/>">
					<i class="material-icons">book</i>
					<p>UngTuyen</p>
			</a></li>
			
			<li class="nav-item active-pro "><a class="nav-link" href="<c:url value='/logout'/>">  
				<i class="material-icons">forward</i>
					<p>LOGOUT</p>
			</a></li>
		</ul>
	</div>
</div>