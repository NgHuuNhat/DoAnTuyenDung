<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="findAllNew" value="/api/news" />
<c:url var="deleteNews" value="/api/news/" />
<c:url var="updateNews" value="/admin/news/update-news/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h6>News</h6>
	<div>
		<a title="Add news" class="btn b tn-primary" id="btn-addnews" href="<c:url value='/admin/news/add-news'/>">+</a>
	</div>
	
	<div class="card">
		<div class="card-body">
			<div class="data-tables">
				<table id="table-news" class="table table-hover">
					<thead class="text-capitalize">
						<tr>
							<th class="table-th table-th-no">No</th>
							<th class="table-th w-15-percent newsid">ID News</th>
							<th class="table-th w-15-percent" style="width: 251.062px;">ShortDescription</th>
							<th class="table-th w-15-percent">Ten cong ty</th>
							<th class="table-th w-15-percent">Cap bac</th>
							<th class="table-th w-15-percent" style="width: 133.344px;">Han nop ho so</th>
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
							'<p class ="width-news-id">'+ item.new_id +'</p>',
							'<p>'+ item.short_description +'</p>',
							'<p>'+ item.tenCongTy +'</p>',
							'<p>'+ item.capBac +'</p>',
							'<p>'+ item.hanNopHoSo +'</p>',
							'<a class="fa fa-edit editNews" id ="editNews" title = "Edit" ></a>' +
							'<a class="fa fa-remove" href="#" id = "deleteNews" title = "Delete"></a><input type="hidden" id ="newId" value="'+item.new_id+'"/>',
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
			//$(this).parents('td') == $('td').find("#editUser")
			//$(this).parents('td') == $('td').find("#deleteUser")
			//$(this).parents('td') == $('td').find("#fa-userName")
			var newId = $(this).parents('td').find('#newId').val();
			window.location.href = "${updateNews}" + newId;
		});

		$('body').on("click", "#deleteNews", function(){
			var newId = $(this).parents('td').find('#newId').val();
			showAlertBeforeDelete(function() {
				$.ajax({
					url : '${deleteNews}' + newId,
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
							window.location.href = "${listNews}";
						}
						console.log(response);
					},
			        error: function (jqXHR, textStatus, errorThrown) {
			        	console.log(errorThrown)
				    }
				});
			}, newId);
		});
		
	</script>
</body>
</html>