<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="login" value="/login" />
<c:url var="bookTour" value="/api/book-tour" />
<c:url var="addComment" value="/api/comment" />
<c:url var="getAllCommentByNewId" value="/api/comment?newId=" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<br>
	<br>
	<h5 id="tourName" style="    font-weight: bold;">
		<c:out value="${news.shortDescription }"></c:out>
	</h5>
	<br>
	<div class="thumb" style="display:flex;">
		<img src="<c:url value='/template/client/assets/images/1.jpg'/>" alt="" style="width: 35rem;" />
		<div style="margin-left: 50px; width: 500px;">
			<h6 style="width: 500px; margin-bottom: 20px;">
				ID News:
				<c:out value="${news.newId }"></c:out>
			</h6>
			<h6 style="width: 500px;">
				Ten cong ty:
				<c:out value="${news.tenCongTy }"></c:out>
			</h6>
			<h6>
				Muc Luong:
				<c:out value="${news.mucLuong }"></c:out>
				triệu
			</h6>
			<h6>
				Hinh thuc lam viec:
				<c:out value="${news.hinhThucLamViec }"></c:out>
			</h6>
			<h6>
				So luong tuyen:
				<c:out value="${news.soLuongTuyen }"></c:out>
				người
			</h6>
			<h6>
				Cap bac:
				<c:out value="${news.capBac }"></c:out>VND
			</h6>
			<h6>
				Kinh Nghiem:
				<c:out value="${news.kinhNghiem }"></c:out>
			</h6>
			<h6>
				Han nop ho so:
				<c:out value="${news.hanNopHoSo }"></c:out>
			</h6>
			<button style="margin-top:20px;" class="btn btn-success" id="datTour" data-toggle="modal" data-target="#myModal" data-keyboard="false" data-backdrop="static">Ứng Tuyển</button>
		</div>
	</div>

	<div class="modal" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content modal-content-user" style="margin-top: 70px; margin-left: -190px; width: 180%;">
				<form action='<c:url value= ""/>' method="POST" enctype="multipart/form-data" id="form-book-tour">
					<!-- Modal Header -->
					<div class="modal-header" id="modalHeaderBookTour">
						<h6 class="modal-title" id ="headerTourName"></h6>
					</div>
					<!-- Modal body -->
					<div class="modal-body" id="modalBookTour">
						<div class="form-group">
							<label for="usr" class="form-label">Tên</label>
                        	<input type="text" class="form-control form-input-role" id = "fullNameCustomer">
                        	<input type="hidden" class="form-control form-input-role" id = "newIdBookTour">
                        	<input type="hidden" class="form-control form-input-role" id = "userNameBookTour">
						</div>
						<div class="form-group">
							<label for="usr" class="form-label">Email</label>
                        	<input type="email" class="form-control form-input-role" id = "emailCustomer">
						</div>
						<div class="form-group">
							<label for="usr" class="form-label">Số điện thoại</label>
                        	<input type="text" class="form-control form-input-role" id = "phoneNumberCustomer">
						</div>
					</div>
					<!-- Modal footer -->
					<div class="modal-footer modal-footer-user">
						<button type="button" class="btn btn-danger" data-dismiss="modal" id="btn-close-user">Close</button>
						<button type="submit" class="btn btn-success" id="btn-book-tour">
							<!-- <i class="fa fa-circle-o-notch fa-spin display-none"></i> --><span>Create</span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<p hidden=true id ="newId"><c:out value="${news.newId }"></c:out></p>
	<br>
	<hr>
	<br>
	<p>${news.content}</p>
	<br>
	<br>
	<hr>
	<div class="list-comment">
		<h6>Comment</h6>
	</div>
	<div class ="comment-content" style="padding-left: 20px;">
		<textarea rows="3" cols="106" class="display-block comment-text" id="noiDungBinhLuan" style="display: block; border-radius: 10px;background-color: #f0f2f5; border: none; padding: 10px;"></textarea>
		<button class="btn btn-success" id="commentTour" style="display: block;">Bình luận</button>
	</div>
	<br>
	<br>
	<script type="text/javascript">
		$(document).ready(function () {
			var newId = $('#newId').text();
			$.ajax({
				url : '${getAllCommentByNewId}' + newId,
				method : 'GET',
				dataType: 'json',
				success: function (response) {
					console.log(response);
					$.each(response, function (index, item) {
						$('.list-comment').append('<div class="comment-detail"><div><span style="font-weight: bold;">'+item.user_comment+'</span></div><div><span>'+item.comment_content+'</span></div><div><span style="margin-left: 480px;">'+item.created_date+'</span></div></div>');
					});
				},
		        error: function (jqXHR, textStatus, errorThrown) {
		        	console.log(errorThrown)
			    }
			});
		});
		$("#datTour").click(function(){
			var userName = $('#userNameLogin').text();
			if (userName == "" || userName == undefined) {
				window.location.href = "${login}";
				return;
			}
			var tourName = $('#tourName').text();
			var newId = $('#newId').text();
			$('#modalHeaderBookTour #headerTourName').text(tourName);
			$('#modalBookTour #userNameBookTour').val(userName);
			$('#modalBookTour #newIdBookTour').val(newId);
		});

		$("#commentTour").click(function(){
			var userName = $('#userNameLogin').text();
			if (userName == "" || userName == undefined) {
				window.location.href = "${login}";
				return;
			}
			var content = $('#noiDungBinhLuan').val();
			if (content == "" || content == undefined) {
				alert("vui lòng nhập nội dung bình luận");
				return;
			}
			var newId = $('#newId').text();
			var dataArray = {};
        	dataArray["content"] = content;
	        dataArray["new_id"] = newId;
	        $.ajax({
				url : '${addComment}',
				method : 'POST',
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
						var newId = $('#newId').text();
						$.ajax({
							url : '${getAllCommentByNewId}' + newId,
							method : 'GET',
							dataType: 'json',
							success: function (response) {
								$('.comment-detail').remove();
								$.each(response, function (index, item) {
									$('.list-comment').append('<div class="comment-detail"><div><span style="font-weight: bold;">'+item.user_comment+'</span></div><div><span>'+item.comment_content+'</span></div><div><span style="margin-left: 480px;">'+item.created_date+'</span></div></div>');
								});
							},
					        error: function (jqXHR, textStatus, errorThrown) {
					        	console.log(errorThrown)
						    }
						});
					}
				},
		        error: function (jqXHR, textStatus, errorThrown) {
		        	console.log(errorThrown)
			    }
			});
		});
		
		$("#btn-book-tour").click(function(){
			event.preventDefault();
			var fullNameCustomer = $('#modalBookTour #fullNameCustomer').val();
			var emailCustomer = $('#modalBookTour #emailCustomer').val();
			var phoneNumberCustomer = $('#modalBookTour #phoneNumberCustomer').val();
			var newIdBookTour = $('#modalBookTour #newIdBookTour').val();
			var userName = $('#modalBookTour #userNameBookTour').val();
			
			var dataArray = {};
	        dataArray["full_name_customer"] = fullNameCustomer;
	        dataArray["email_customer"] = emailCustomer;
	        dataArray["phone_number_customer"] = phoneNumberCustomer;
	        dataArray["user_name"] = userName;
	        dataArray["new_id"] = newIdBookTour;
	        
    		$.ajax({
				url : '${bookTour}',
				method : 'POST',
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