<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
			<form action="j_spring_security_check" method="post" class="login100-form validate-form">
				<span class="login100-form-title p-b-37">
					Sign In
				</span>
				<c:if test="${param.incorrectAccount != null }">
					<div class="alert alert-block alert-danger">User Name hoặc Password không đúng</div>
				</c:if>
				<c:if test="${param.accessDenied != null }">
					<div class="alert alert-block alert-danger">Bạn không có quyền truy cập vào trang quản trị</div>
				</c:if>
				<div class="wrap-input100 validate-input m-b-20" data-validate="Enter username or email">
					<input class="input100" type="text" name="j_username" placeholder="username or email">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
					<input class="input100" type="password" name="j_password" placeholder="password">
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
					<button class="login100-form-btn">
						Sign In
					</button>
				</div>

				<div class="text-center" style="margin-top: 30px;">
					<a href="<c:url value='login/register'/>" class="txt2 hov1">
						register
					</a>
				</div>
			</form>
		</div>
	</div>
	
	

	<div id="dropDownSelect1"></div>
</body>
</html>