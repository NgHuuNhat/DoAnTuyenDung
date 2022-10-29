<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="updateNews" value="/api/news" />
<c:url var="listNews" value="/admin/news" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update News</title>
</head>
<body>
	<div class="form-group">
		<label for="usr" class="form-label">ID</label>
		<input type="text" class="form-control form-input" name="newId" id="newId" placeholder="" disabled="disabled" value='<c:out value="${newsDTO.newId}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Short Description</label>
		<input type="text" class="form-control form-input" id="shortDescription" placeholder="Ex: 0123" value='<c:out value="${newsDTO.shortDescription}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Ten cong ty</label>
		<input type="text" class="form-control form-input" name="tenCongTy"	id="tenCongTy" placeholder="" value='<c:out value="${newsDTO.tenCongTy}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Han nop ho so</label>
		<input type="text" class="form-control form-input" name="hanNopHoSo" id="hanNopHoSo" placeholder="" value='<c:out value="${newsDTO.hanNopHoSo}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Muc Luong</label>
		<input type="text" class="form-control form-input" name="mucLuong" id="mucLuong" placeholder="" value='<c:out value="${newsDTO.mucLuong}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Hinh thuc lam viec</label>
		<input type="text" class="form-control form-input" name="hinhThucLamViec" id="hinhThucLamViec" placeholder="" value='<c:out value="${newsDTO.hinhThucLamViec}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">So luong tuyen</label>
		<input type="text" class="form-control form-input" name="soLuongTuyen" id="soLuongTuyen" placeholder="" value='<c:out value="${newsDTO.soLuongTuyen}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Cap bac</label>
		<input type="text" class="form-control form-input" name="capBac" id="capBac" placeholder="" value='<c:out value="${newsDTO.capBac}"></c:out>'>
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Kinh nghiem</label>
		<input type="text" class="form-control form-input" name="kinhNghiem" id="kinhNghiem" placeholder="" value='<c:out value="${newsDTO.kinhNghiem}"></c:out>'>
	</div>
	
	<div class="form-group">
		<label for="usr" class="form-label">Content</label>
		<textarea class="form-control form-input" cols="5" rows="60" name="content" id="content" placeholder="Ex: abc..."><c:out value="${newsDTO.content}"></c:out></textarea>
	</div>
	<input type="hidden" id="newsId" value='<c:out value="${newsDTO.newId}"></c:out>'>
    <button type="submit" class="btn btn-success" id ="btn-update-news"><span>UPDATE</span></button>
    
    <script type="text/javascript">
    	var editor = '';
    	$(document).ready(function () {
    		editor = CKEDITOR.replace('content');
    		CKFinder.setupCKEditor( editor, '${pageContext.request.contextPath}/ckfinder/' );
    	});
    	$("#btn-update-news").click(function() {
    		var newId = $('#newId').val();
    		var shortDescription = $('#shortDescription').val();
			var content = editor.getData();
			var tenCongTy = $('#tenCongTy').val();
			var hanNopHoSo = $('#hanNopHoSo').val();
			var mucLuong = $('#mucLuong').val();
			var hinhThucLamViec = $('#hinhThucLamViec').val();
			var soLuongTuyen = $('#soLuongTuyen').val();
			var capBac = $('#capBac').val();
			var kinhNghiem = $('#kinhNghiem').val();
    		var content = editor.getData();
    		
        	var dataArray = {};
        	dataArray["new_id"] = newId;
        	dataArray["short_description"] = shortDescription;
        	dataArray["tenCongTy"] = tenCongTy;
	        dataArray["hanNopHoSo"] = hanNopHoSo;
	        dataArray["mucLuong"] = mucLuong;
	        dataArray["hinhThucLamViec"] = hinhThucLamViec;
	        dataArray["soLuongTuyen"] = soLuongTuyen;
	        dataArray["capBac"] = capBac;
	        dataArray["kinhNghiem"] = kinhNghiem;
	        dataArray["content"] = content;
	        
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