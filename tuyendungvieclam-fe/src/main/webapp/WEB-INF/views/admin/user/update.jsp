<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="updateUser" value="/api/user" />
<c:url var="listUser" value="/admin/user" />
<c:url var="listRole" value="/api/role" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body>
	<div class="form-group">
		<label for="usr" class="form-label">User name</label>
		<input type="text" class="form-control form-input" name="user_name" id="userName" placeholder="Ex: tuankul" disabled="disabled" value='<c:out value="${userDTO.userName}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Password</label>
		<input type="password" class="form-control form-input" name="password" id="password" placeholder="Ex: 123456" value="************">
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Full name</label>
		<input type="text" class="form-control form-input" name="full_name"	id="fullName" placeholder="Ex: Thái Thanh Tuấn" value='<c:out value="${userDTO.fullName}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Email</label>
		<input type="email" class="form-control form-input" name="email" id="email"	placeholder="Ex: test@gmail.com" value='<c:out value="${userDTO.email}"></c:out>'> 
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Phone</label>
		<input type="number" class="form-control form-input" name="phone" id="phone" placeholder="012332323232" value='<c:out value="${userDTO.phoneNumber}"></c:out>'>
	</div>
	
	<div class="form-group">
		<label for="usr" class="form-label">Image</label>
		<input type="file" style="padding-top: 3px;" class="form-control form-input" id = "form-avatar" name = "form_avatar">
	</div>
	<div class ="">
        <label class ="form-label-hidden"></label>
        <img src="" alt="avatar" class = "form-avatar-profile" id = "avater-review" >
        <input type="hidden" id = "fileNameAvatar" value='<c:out value="${userDTO.avatar}"></c:out>'>
    </div>
    
	<div class="form-group nhatnhat">
		<label>role</label>
		<div class="role-have-right nhat" id="listHaveRole"></div>
		<label>choose role</label>
		<div class="list-role nhat" id="listNoRole"></div>
	</div>

    <button type="submit" class="btn btn-success" id ="btn-update-user"><span>UPDATE</span></button>
    <input type="hidden" id = "listHaveRoleFromController" value='<c:out value="${userDTO.listHaveRoles}"></c:out>'>
    <input type="hidden" id = "listNoRolesFromController" value='<c:out value="${userDTO.listNoRoles}"></c:out>'>
    
    <script type="text/javascript">
	    var list = {};
	    $(document).ready(function (){
	    	$.ajax({
				url : '${listRole}',
				method : "GET",
				dataType : 'json',
				success : function(response) {
					list = response;
					const arrayHaveRole = JSON.parse($('#listHaveRoleFromController').val());
					const arrayNoRole = JSON.parse($('#listNoRolesFromController').val());
					$.each(list, function (index, item) {
						var roleId = parseInt(item.role_id);
						if (arrayHaveRole.includes(roleId)) {
							$('#listHaveRole').append('<label for = "'+item.role_name+'" title = "'+item.role_description+'"><input type="checkbox" id = "'+item.role_id+'" value="'+item.role_id+'" class = "checkbox-role not-role"><p class = "role-text">'+item.role_name+'</p></label><br/>');
						}
					});
					$.each(list, function (index, item) {
						var roleId = parseInt(item.role_id);
						if (arrayNoRole.includes(roleId)) {
							$('#listNoRole').append('<label for = "'+item.role_name+'" title = "'+item.role_description+'"><input type="checkbox" id = "'+item.role_id+'" value="'+item.role_id+'" class = "checkbox-role not-role"><p class = "role-text">'+item.role_name+'</p></label><br/>');
						}
					});
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(errorThrown)
				}
	    	});

	    	$("#avater-review").prop("src", "http://127.0.0.1:8887/tuyendungvieclam-fe/src/main/webapp/"+$("#fileNameAvatar").val());
	    });
    	$("#btn-update-user").click(function() {
			var userName = $('#userName').val();
			var fullName = $('#fullName').val();
			var email = $('#email').val();
			var phoneNumber = $('#phone').val();
			var password = $('#password').val();

        	var dataArray = {};
        	dataArray["user_name"] = userName;
	        dataArray["full_name"] = fullName;
	        dataArray["email"] = email;
	        dataArray["phone_number"] = phoneNumber;
	        dataArray["password"] = password;
    		$.ajax({
				url : '${updateUser}',
				method : "PUT",
				dataType: 'json',
				contentType:'application/json',
				data: JSON.stringify(dataArray),
				success: function (response) {
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
		        error: function (jqXHR, textStatus, errorThrown) {
		        	console.log(errorThrown)
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