<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="findAllNew" value="/api/booktour" />
<c:url var="deleteNews" value="/api/booktour/" />
<c:url var="updateNews" value="/admin/booktour/update-booktour/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h6>UngTuyen</h6>
	<%-- <div>
		<a title="Add news" class="btn b tn-primary" href="<c:url value='/admin/news/add-news'/>">+</a>
	</div> --%>
	
	<div class="card">
		<div class="card-body">
			<div class="data-tables">
				<table id="table-news" class="table table-hover">
					<thead class="text-capitalize">
						<tr>
							<th class="table-th table-th-no">No</th>
							<th class="table-th w-15-percent idbooktour">ID Ung Tuyen</th>
							<th class="table-th w-15-percent">FullNameCustomer</th>
							<th class="table-th w-15-percent" style="width: 229.531px;">PhoneNumberCustomer</th>
							<th class="table-th w-15-percent">Email</th>
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
		    var tableNews = $('#table-news').DataTable();
		    
		<!--lay thong tin-->
			$.ajax({
				url : '${findAllNew}',
				method : 'GET',
				dataType: 'json',
				success: function (data) {
					 $.each(data, function (index, item) {
						var rowData = [
							index + 1,
							/* '<p class ="width-news-id">'+ item.book_tour_id +'</p>', */
							'<p>'+ item.book_tour_id +'</p>',
							'<p>'+ item.full_name_customer +'</p>',
							'<p>'+ item.phone_number_customer +'</p>',
							'<p>'+ item.email_customer +'</p>',
							'<a class="fa fa-edit editNews" id ="editNews" title = "Edit" ></a>' +
							'<a class="fa fa-remove" href="#" id = "deleteNews" title = "Delete"></a><input type="hidden" id ="newId" value="'+item.book_tour_id+'"/>',
						];
						tableNews.row.add(rowData).draw(false);
					})
				},
		        error: function (jqXHR, textStatus, errorThrown) {
		        	console.log(errorThrown)
			    }
			});
		});

		$('body').on("click", "#editNews", function(){
			
			var bookTourId = $(this).parents('td').find('#newId').val();
			window.location.href = "${updateNews}" + bookTourId;
		});

		$('body').on("click", "#deleteNews", function(){
			var bookTourId = $(this).parents('td').find('#newId').val();
			showAlertBeforeDelete(function() {
				$.ajax({
					url : '${deleteNews}' + bookTourId,
					method : "DELETE",
					dataType: 'json',
					success: function (response) {
						
						if (response.message == "FAIL") {
							
							alert(response.data);
						} else {
							
							alert(response.data);
							window.location.href = "${listNews}";
						}
						console.log(response);
					},
			        error: function (jqXHR, textStatus, errorThrown) {
			        	console.log(errorThrown)
				    }
				});
			}, bookTourId);
		});
		
	</script>
</body>
</html>