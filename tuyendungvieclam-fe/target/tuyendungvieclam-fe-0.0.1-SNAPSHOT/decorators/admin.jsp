<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
<title>Admin</title>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href = "<c:url value='/template/admin/assets/images/apple-icon.png'/>">
  <link rel="icon" type="image/png" href= "<c:url value='/template/admin/assets/images/favicon.png'/>">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="<c:url value='/template/admin/assets/css/material-dashboard.css?v=2.1.2'/>" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="<c:url value='/template/admin/assets/demo/demo.css'/>" rel="stylesheet" />
  <script type='text/javascript' src='<c:url value="/template/admin/assets/js/jquery.min.js"/>'></script><!-- 3.5.1 -->
  <link rel="stylesheet" href = "<c:url value='/template/admin/assets/css/jquery.dataTables.css'/>" rel="stylesheet" type="text/css" media="all">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/template/admin/sweetalert2/sweetalert2.min.css"/>">
  <link href="<c:url value='/template/admin/assets/css/mystyle.css'/>" rel="stylesheet" />
</head>

<body>
	<div class="wrapper ">
	   <%@ include file="/common/admin/sidebar-menu.jsp"%>
	   <div class="main-panel">
	   		<%@ include file="/common/admin/header.jsp"%>
	   		<div class="content">
	   			<dec:body/>
	   		</div>
	   		<%@ include file="/common/admin/footer.jsp"%>
	   </div>
	</div>
  <!--   Core JS Files   -->
  <script type='text/javascript' src='<c:url value="/template/admin/sweetalert2/sweetalert2.min.js"/>'></script>
  <script src="<c:url value='/template/admin/assets/js/core/jquery.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/js/core/popper.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/js/core/bootstrap-material-design.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/js/plugins/perfect-scrollbar.jquery.min.js'/>"></script>
  <!-- Forms Validations Plugin -->
  <script src="<c:url value='/template/admin/assets/js/plugins/jquery.validate.min.js'/>"></script>
  <!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
  <script src="<c:url value='/template/admin/assets/js/plugins/jquery.dataTables.min.js'/>"></script>
  <!--  Notifications Plugin    -->
  <script src="<c:url value='/template/admin/assets/js/plugins/bootstrap-notify.js'/>"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="<c:url value='/template/admin/assets/js/material-dashboard.js?v=2.1.2'/>" type="text/javascript"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="<c:url value='/template/admin/assets/demo/demo.js'/>"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <script type="text/javascript" src="<c:url value="/ckeditor/ckeditor.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/ckfinder/ckfinder.js"/>"></script>
  <script src = "<c:url value='/template/admin/assets/js/pagination.js'/>"></script>
  <script>
    $(document).ready(function() {
      // Javascript method's body can be found in assets/js/demos.js
      md.initDashboardPageCharts();

    });
    function showAlertBeforeDelete(callback, id) {
        swal({
  		   title: "Xác nhận xóa!",
           text: "Bạn có muốn xóa '" + id + "' ?",
           type: "warning",
           showCancelButton: true,
           confirmButtonText: "Đồng ý",
           cancelButtonText: "Hủy",
           confirmButtonClass: "btn btn-success",
           cancelButtonClass: "btn btn-danger"
        }).then(function (isConfirm) {
            if (isConfirm) {
                callback();
            }
        });
    }
  </script>









































<%-- 
	<div class="container-fluid">
		<div class="row content">
			<%@ include file="/common/admin/admin-menu.jsp"%>
			<div class="col-sm-10 height-100">
				<%@ include file="/common/admin/admin-header.jsp"%>
				<div class="row">
					<dec:body />
				</div>
			</div>
		</div>
	</div>
	<img src = "<c:url value = '/template1/admin/img/reload.gif'/>" class = "gif-loading"></img>                                                                                                                                                                                                               
<script src = "<c:url value='/template1/admin/js/javascript.js'/>"></script>
<script src="https://use.fontawesome.com/b59cf34d3a.js"></script>
<script type='text/javascript' src='<c:url value="/template1/admin/js/popper.min.js"/>'></script><!-- 1.16.0 -->
<script type='text/javascript' src='<c:url value="/template1/admin/js/bootstrap.min.js"/>'></script>
<script type='text/javascript' src='<c:url value="/template1/admin/js/jquery.dataTables.js"/>'></script><!--  1.10.21-->
<script src = "<c:url value='/template1/admin/js/pagination.js'/>"></script>
<script src = "<c:url value='/template1/admin/js/validate.js'/>"></script>
<script src = "<c:url value='/template1/admin/js/notify.js'/>"></script>
<script src = "<c:url value='/template1/admin/js/notify.min.js'/>"></script>
<script type="text/javascript">
   function showAlertBeforeDelete(callback, id) {
       swal({
           title: "Comfirm delete",
           text: "Are you sure to delete '" + id + "' ?",
           type: "warning",
           showCancelButton: true,
           confirmButtonText: "Sure",
           cancelButtonText: "Cancel",
           confirmButtonClass: "btn btn-success",
           cancelButtonClass: "btn btn-danger"
       }).then(function (isConfirm) {
           if (isConfirm) {
               callback();
           }
       });
   }

   function showAlertBeforeUnlock(callback, id) {
       swal({
           title: "Comfirm Active",
           text: "Are you sure to active '" + id + "' ?",
           type: "warning",
           showCancelButton: true,
           confirmButtonText: "Sure",
           cancelButtonText: "Cancel",
           confirmButtonClass: "btn btn-success",
           cancelButtonClass: "btn btn-danger"
       }).then(function (isConfirm) {
           if (isConfirm) {
               callback();
           }
       });
   } --%>
</script>
</body>
</html>