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
			Dang ky
		</span>
		<div class="form-group">
			<label for="usr" class="form-label">User name</label>
			<input type="text" class="form-control form-input" name="user_name" id="userName" placeholder="">
		</div>
		<div class="form-group">
			<label for="usr" class="form-label">Password</label>
			<input type="password" class="form-control form-input" name="password" id="password" placeholder="">
		</div>
		<div class="form-group">
			<label for="usr" class="form-label">Full name</label>
			<input type="text" class="form-control form-input" name="full_name"	id="fullName" placeholder="">
		</div>
		<div class="form-group">
			<label for="usr" class="form-label">Email</label>
			<input type="email" class="form-control form-input" name="email" id="email"	placeholder="">
		</div>
		<div class="form-group">
			<label for="usr" class="form-label">Phone</label>
			<input type="number" class="form-control form-input" name="phone" id="phone" placeholder="">
		</div>
		<div class="form-group">
		<label for="usr" class="form-label">Image</label>
		<input type="file" style="padding-top: 3px;" class="form-control form-input" id = "form-avatar" name = "form_avatar">
		</div>
		<div class ="">
	        <label class ="form-label-hidden"></label>
	        <img src="" alt="avatar" class = "form-avatar-profile" id = "avater-review" >
	    </div>
	    <div class="container-login100-form-btn" style="margin-top: 20px;">
			<button class="login100-form-btn">
				Dang ky
			</button>
		</div>
		<div class="text-center" style="margin-top: 20px;">
			<a href="<c:url value='/login'/>" class="txt2 hov1">
				Login
			</a>
		</div>
		</form>

			
		</div>
	</div>

	<script type="text/javascript">
    	var list = {};
	    $(document).ready(function (){
	    	$.ajax({
				url : '${listRole}',
				method : "GET",
				dataType : 'json',
				success : function(response) {
					list = response;
					console.log(list);
					$.each(list, function (index, item) {
						$('#listRole').append('<label for = "'+item.role_name+'" title = "'+item.role_description+'"><input type="checkbox" id = "'+item.role_id+'" value="'+item.role_id+'" class = "checkbox-role not-role"><p class = "role-text">'+item.role_name+'</p></label><br/>');
					});
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(errorThrown)
				}
	    	});
	    	$("#form-user").validate({
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
					phone: {
						required: true,
						maxlength: 11,
						minlength: 10
					}
				},
				messages: {
					user_name: {
						required: "Vui lòng nhập user name.",
						maxlength: "Chiều dài tối đa của user name là 50 ký tự."
					},
					password: {
						required: "Vui lòng nhập password.",
						maxlength: "Chiều dài tối đa của password là 30 ký tự."
					},
					full_name: {
						required: "Vui lòng nhập full_name.",
						maxlength: "Chiều dài tối đa của full_name là 255 ký tự."
					},
					email: {
						required: "Vui lòng nhập email.",
						maxlength: "Chiều dài tối đa của email là 255 ký tự.",
						email: "Không phải định dạng của email."
					},
					phone: {
						required: "Vui lòng nhập phone.",
						maxlength: "Chiều dài tối đa của phone là 11 ký tự.",
						minlength: "Chiều dài tối thiểu của phone là 10 ký tự.",
					}
				},
				submitHandler: function(form) {
					event.preventDefault();
					var userName = $('#userName').val();
					var fullName = $('#fullName').val();
					var email = $('#email').val();
					var phoneNumber = $('#phone').val();
					var password = $('#password').val();

					var addRoles = new Array();
					$('.not-role').each(function() {
						if($(this).prop('checked') == true) {
							addRoles.push($(this).val());
						}
					});

					var files = $('#form-avatar')[0].files[0];
					var reader = new FileReader();
					
					var dataArray = {};
					reader.onload = function (e) {
						dataArray["user_name"] = userName;
						dataArray["full_name"] = fullName;
						dataArray["email"] = email;
						dataArray["phone_number"] = phoneNumber;
						dataArray["password"] = password;
						dataArray["list_role"] = addRoles;
						dataArray["file_name"] = files.name;
						dataArray["base64"] = e.target.result;
						$.ajax({
							url : '${addUser}',
							method : "POST",
							dataType : 'json',
							contentType : 'application/json',
							data : JSON.stringify(dataArray),
							success : function(response) {
								/* data: "User name đã tồn tại."
								message: "SUCCESS" */
								if (response.message == "FAIL") {
									//sẽ báo lỗi
									//đem nội dung data ra cho người dùng thấy User name đã tồn tại.
									alert(response.data);
								} else {
									//tạo thành công
									alert(response.data);
									window.location.href = "${listUser}";
								}
								console.log(response);
							},
							error : function(jqXHR, textStatus, errorThrown) {
								console.log(errorThrown)
							}
						});
		            }
		            reader.readAsDataURL(files);
				}
			});
	    });
	    $('#form-avatar').change(function(){
	        openImage(this, $("#avater-review"));
	    });

	    function openImage(input, imageView) {
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();
	            reader.onload = function (e) {
	                $(imageView).attr('src', reader.result);
	            }
	            reader.readAsDataURL(input.files[0]);
	        } else {
	            $(imageView).attr('src', "");
	        }
	    }
	</script>
</body>
</html>