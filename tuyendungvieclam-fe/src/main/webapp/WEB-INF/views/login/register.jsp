<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="addUser" value="/api/client/user" />
<c:url var="login" value="/login" />
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script type='text/javascript' src='<c:url value="/template/admin/assets/js/jquery.min.js"/>'></script><!-- 3.5.1 -->
</head>
<body>
	<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30" style="width: 600px;">
			<span class="login100-form-title p-b-37">
					Dang ky
			</span>
			<form action='<c:url value= ""/>' method="post" enctype="multipart/form-data" id ="form-add-user">
				<div style="display: grid;
				    grid-auto-rows: minmax(min-content,max-content);
				    grid-template-columns: repeat(2,minmax(0,1fr));
				    grid-gap: 10px;
				    border-radius: 10px;
				    padding: 10px;
				    margin-top: 10px;">
					<div class="form-group">
						<label for="usr" class="form-label">User name</label>
						<input type="text" class="form-control form-input" name="user_name" id="userName" placeholder=""/>
					</div>
					<div class="form-group">
						<label for="usr" class="form-label">Password</label>
						<input type="password" class="form-control form-input" name="password" id="password" placeholder=""/>
					</div>
					<div class="form-group">
						<label for="usr" class="form-label">Full name</label>
						<input type="text" class="form-control form-input" name="full_name" id="fullName" placeholder=""/>
					</div>
					<div class="form-group">
						<label for="usr" class="form-label">Email</label>
						<input type="email"  class="form-control form-input" name="email" id="email" placeholder=""/>  
					</div>
					<div class="form-group">
						<label for="usr" class="form-label">Phone</label>
						<input type="text"  class="form-control form-input" name="phone_number" id="phoneNumber" placeholder=""/>
					</div>
					
					<!-- <div>
						<div class="form-group">
							<label for="usr" class="form-label">Image</label>
							<input type="file" style="padding-top: 3px;" class="form-control form-input" id = "form-avatar" name = "form_avatar">
						</div>
						<div class ="">
					        <label class ="form-label-hidden"></label>
					        <img style="margin-top: 0px;" src="" alt="avatar" class = "form-avatar-profile" id = "avater-review" >
					    </div>
					</div> -->
				</div>
				<div class="container-login100-form-btn" style="margin-top: 20px;">
					<button type="submit" class="login100-form-btn" id="btnDangKy">
						Dang ky
					</button>
				</div>
			</form>
			
			<div class="text-center" style="margin-top: 20px;">
					<a href="<c:url value='/login'/>" class="txt2 hov1">
						Login
					</a>
			</div>
		</div>
	</div>

	<script type="text/javascript">
    	var list = {};
    	$("#form-add-user").validate({
			rules: {
				user_name: {
					required: true,
					maxlength: 50
				},
				password: {
					required: true,
					maxlength: 30
				},
				full_name: {
					required: true,
					maxlength: 255
				},
				email: {
					required: true,
					maxlength: 255,
					email: true
				},
				phone_number: {
					required: true,
					maxlength: 11,
					minlength: 10
				}
			},
			messages: {
				user_name: {
					required: "Vui l??ng nh???p user name.",
					maxlength: "Chi???u d??i t???i ??a c???a user name l?? 50 k?? t???."
				},
				password: {
					required: "Vui l??ng nh???p password.",
					maxlength: "Chi???u d??i t???i ??a c???a password l?? 30 k?? t???."
				},
				full_name: {
					required: "Vui l??ng nh???p full_name.",
					maxlength: "Chi???u d??i t???i ??a c???a full_name l?? 255 k?? t???."
				},
				email: {
					required: "Vui l??ng nh???p email.",
					maxlength: "Chi???u d??i t???i ??a c???a email l?? 255 k?? t???.",
					email: "Kh??ng ph???i ?????nh d???ng c???a email."
				},
				phone_number: {
					required: "Vui l??ng nh???p phone_number.",
					maxlength: "Chi???u d??i t???i ??a c???a phone l?? 11 k?? t???.",
					minlength: "Chi???u d??i t???i thi???u c???a phone l?? 10 k?? t???.",
				}
			},
			submitHandler: function(form) {
				event.preventDefault();
				var userName = $('#userName').val();
				var fullName = $('#fullName').val();
				var email = $('#email').val();
				var phoneNumber = $('#phoneNumber').val();
				var password = $('#password').val();

				var addRoles = new Array();
				$('.not-role').each(function() {
					if($(this).prop('checked') == true) {
						addRoles.push($(this).val());
					}
				});
				
				var dataArray = {};
				dataArray["user_name"] = userName;
				dataArray["full_name"] = fullName;
				dataArray["email"] = email;
				dataArray["phone_number"] = phoneNumber;
				dataArray["password"] = password;
				$.ajax({
					url : '${addUser}',
					method : "POST",
					dataType : 'json',
					contentType : 'application/json',
					data : JSON.stringify(dataArray),
					success : function(response) {
						/* data: "User name ???? t???n t???i."
						message: "SUCCESS" */
						if (response.message == "FAIL") {
							//s??? b??o l???i
							//??em n???i dung data ra cho ng?????i d??ng th???y User name ???? t???n t???i.
							alert(response.data);
						} else {
							//t???o th??nh c??ng
							alert(response.data);
							window.location.href = "${login}";
						}
						console.log(response);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(errorThrown)
					}
				});
			}
		});
	</script>
</body>
</html>