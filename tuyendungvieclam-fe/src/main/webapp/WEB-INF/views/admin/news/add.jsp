<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="addNews" value="/api/news" />
<c:url var="listNews" value="/admin/news" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add News</title>
</head>
<body>
	<div class="form-group">
		<label for="usr" class="form-label">Short-Description</label>
		<input type="text" class="form-control form-input" name="content" id="shortDescription" placeholder="">
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Ten cong ty</label>
		<input type="text" class="form-control form-input" name="tenCongTy"	id="tenCongTy" placeholder="">
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Han nop ho so</label>
		<input type="text" class="form-control form-input" name="hanNopHoSo" id="hanNopHoSo" placeholder="">
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Muc Luong</label>
		<input type="text" class="form-control form-input" name="mucLuong" id="mucLuong" placeholder="">
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Hinh thuc lam viec</label>
		<input type="text" class="form-control form-input" name="hinhThucLamViec" id="hinhThucLamViec" placeholder="">
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">So luong tuyen</label>
		<input type="text" class="form-control form-input" name="soLuongTuyen" id="soLuongTuyen" placeholder="">
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Cap bac</label>
		<input type="text" class="form-control form-input" name="capBac" id="capBac" placeholder="">
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Kinh nghiem</label>
		<input type="text" class="form-control form-input" name="kinhNghiem" id="kinhNghiem" placeholder="">
	</div>
	<div class="form-group">
		<label for="usr" class="form-label">Image</label>
		<input type="file" style="padding-top: 3px;" class="form-control form-input" id = "form-avatar" name = "form_avatar">
	</div>
	<div class ="">
        <label class ="form-label-hidden"></label>
        <img src="" alt="avatar" class = "form-avatar-profile" id = "avater-review" >
    </div>
	<div class="form-group">
		<label for="usr" class="form-label">Content</label>
		<textarea class="form-control form-input" cols="5" rows="20" name="content" id="content" placeholder="Ex: abc..."></textarea>
	</div>

    <button type="submit" class="btn btn-success" id ="btn-create-news"><span>Create</span></button>
    
    <script type="text/javascript">
    	var editor = '';
    	$("#btn-create-news").click(function() {
			var shortDescription = $('#shortDescription').val();
			var content = editor.getData();
			var tenCongTy = $('#tenCongTy').val();
			var hanNopHoSo = $('#hanNopHoSo').val();
			var mucLuong = $('#mucLuong').val();
			var hinhThucLamViec = $('#hinhThucLamViec').val();
			var soLuongTuyen = $('#soLuongTuyen').val();
			var capBac = $('#capBac').val();
			var kinhNghiem = $('#kinhNghiem').val();

        	var dataArray = {};
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
				url : '${addNews}',
				method : 'POST',
				dataType: 'json',
				contentType:'application/json',
				data: JSON.stringify(dataArray),
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
    	});
    	$(document).ready(function () {
    		editor = CKEDITOR.replace('content');
    		CKFinder.setupCKEditor( editor, '${pageContext.request.contextPath}/ckfinder/' );
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