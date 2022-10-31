<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="findAllUser" value="/api/user" />
<c:url var="deleteUser" value="/api/user/" />
<c:url var="updateUser" value="/admin/user/update-user/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
	<h6>User</h6>
	<div>
		<a title="Add user" class="btn btn-primary" href="<c:url value='/admin/user/add-user'/>">+</a>
	</div>
	<div class="card">
		<div class="card-body">
			<div class="data-tables">
				<table id="table-user" class="table table-hover">
					<thead class="text-capitalize">
						<tr>
							<th class="table-th table-th-no">No</th>
							<th class="table-th w-15-percent">Created By</th>
							<th class="table-th w-15-percent">Created Date</th>
							<th class="table-th w-15-percent">User Name</th>
							<th class="table-th w-15-percent">Update Date</th>
							<th class="table-th w-15-percent">Update By</th>
							<th class="table-th table-th-action">Action</th>
						</tr>
					</thead>
				</table>
				<ul class="pagination-sm" id="pagination-user"></ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function () {
			
		    var tableUser = $('#table-user').DataTable({
		    	"paging": false,
		    	"info": false
			});

			$.ajax({
				url : '${findAllUser}?page_number=1&page_size=10',
				method : "GET",
				dataType: 'json',
				success: function (response) {
					 $.each(response.data, function (index, item) {
						var rowData = [
							index + 1,
							'<p>'+ item.created_by +'</p>',
							'<p>'+ item.created_date +'</p>',
							'<p>'+ item.user_name +'</p>',
							'<p>'+ item.updated_date +'</p>',
							'<p>'+ item.updated_by +'</p>',
							'<a class="fa fa-edit editUser" id ="editUser" title = "Edit" ></a>' +
							'<a class="fa fa-remove" href="#" id = "deleteUser" title = "Delete"></a><input type="hidden" id ="userName" value="'+item.user_name+'"/>',
						];
						tableUser.row.add(rowData).draw(false);
					});
					$('#pagination-user').twbsPagination({
					        totalPages: response.pagination.total_page,
					        visiblePages: 5,
					        onPageClick: function (event, page) {
					        	tableUser.clear().draw();
			    	        	var noIndex = (page - 1) * 10;
			    	        	$.ajax({
			    	    	        type: 'GET',
			    	    	        url : '${findAllUser}?page_number='+page+'&page_size=10',
			    	    	        dataType: 'json',
			    	    	        success: function (response1) {
			    	    	        	$.each(response1.data, function (index, item) {
			    							var rowData = [
			    								noIndex + index + 1,
			    								'<p>'+ item.created_by +'</p>',
			    								'<p>'+ item.created_date +'</p>',
			    								'<p>'+ item.user_name +'</p>',
			    								'<p>'+ item.updated_date +'</p>',
			    								'<p>'+ item.updated_by +'</p>',
			    								'<a class="fa fa-edit editUser" id ="editUser" title = "Edit" ></a>' +
			    								'<a class="fa fa-remove" href="#" id = "deleteUser" title = "Delete"></a><input type="hidden" id ="userName" value="'+item.user_name+'"/>',
			    							];
			    							tableUser.row.add(rowData).draw(false);
			    						});
			    	    	        }
			    	        	});
					        }
					});
				},
		        error: function (jqXHR, textStatus, errorThrown) {
		        	console.log(errorThrown)
			    }
			});
		});
		$('body').on("click", "#editUser", function(){
			//$(this).parents('td') == $('td').find("#editUser")
			//$(this).parents('td') == $('td').find("#deleteUser")
			//$(this).parents('td') == $('td').find("#fa-userName")
			var userName = $(this).parents('td').find('#userName').val();
			window.location.href = "${updateUser}" + userName;
		});

		$('body').on("click", "#deleteUser", function(){
			var userName = $(this).parents('td').find('#userName').val();
			showAlertBeforeDelete(function() {
				$.ajax({
					url : '${deleteUser}' + userName,
					method : "DELETE",
					dataType: 'json',
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
			}, userName);
		});
	</script>
</body>
</html>