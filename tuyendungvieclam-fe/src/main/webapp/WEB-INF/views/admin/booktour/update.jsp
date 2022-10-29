<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="updateNews" value="/api/booktour" />
<c:url var="listNews" value="/admin/booktour" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body>
	<div class="form-group">
		<label for="usr" class="form-label">ID Ung tuyen</label>
		<input type="text" class="form-control form-input" id="bookTourId" placeholder="" disabled="disabled" value='<c:out value="${bookTourDTO.bookTourId}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">ID News</label>
		<input type="text" class="form-control form-input" id="newId" placeholder="" disabled="disabled" value='<c:out value="${bookTourDTO.newId}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">UserName</label>
		<input type="text" class="form-control form-input" id="userName" placeholder="" disabled="disabled" value='<c:out value="${bookTourDTO.userName}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">fullNameCustomer</label>
		<input type="text" class="form-control form-input" id="fullNameCustomer" placeholder="" value='<c:out value="${bookTourDTO.fullNameCustomer}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">emailCustomer</label>
		<input type="text" class="form-control form-input" id="emailCustomer" placeholder="" value='<c:out value="${bookTourDTO.emailCustomer}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">phoneNumberCustomer</label>
		<input type="text" class="form-control form-input" id="phoneNumberCustomer" placeholder="" value='<c:out value="${bookTourDTO.phoneNumberCustomer}"></c:out>'>
	</div>
	<input type="hidden" id="bookTourId" value='<c:out value="${bookTourDTO.bookTourId}"></c:out>'>
    <button type="submit" class="btn btn-success" id ="btn-update-news"><span>UPDATE</span></button>
    
    <script type="text/javascript">
    	var editor = '';
    	$(document).ready(function () {
    		editor = CKEDITOR.replace('content');
    		CKFinder.setupCKEditor( editor, '${pageContext.request.contextPath}/ckfinder/' );
    	});
    	$("#btn-update-news").click(function() {
    		var bookTourId = $('#bookTourId').val();
    		var newId = $('#newId').val();
    		var userName = $('#userName').val();
    		var fullNameCustomer = $('#fullNameCustomer').val();
    		var emailCustomer = $('#emailCustomer').val();
    		var phoneNumberCustomer = $('#phoneNumberCustomer').val();
    		
        	var dataArray = {};
        	dataArray["book_tour_id"] = bookTourId;
        	dataArray["new_id"] = newId;
        	dataArray["user_name"] = userName;
        	dataArray["full_name_customer"] = fullNameCustomer;
        	dataArray["email_customer"] = emailCustomer;
        	dataArray["phone_number_customer"] = phoneNumberCustomer;
        	
	        
    		$.ajax({
				url : '${updateNews}',
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
						window.location.href = "${listNews}";
					}
					console.log(response);
				},
		        error: function (jqXHR, textStatus, errorThrown) {
		        	console.log(errorThrown)
			    }
			});
    	});
	</script>
</body>
</html>