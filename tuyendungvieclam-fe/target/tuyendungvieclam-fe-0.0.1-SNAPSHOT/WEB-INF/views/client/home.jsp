<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="findAllNew" value="/client/news" />
<c:url var="detailNew" value="/client/news/" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
    <div id="content">
      <!-- begin featured -->
      <div class="featured">
        <div class="thumb"> 
        	<a href="#">
        		<img src="<c:url value='/template/client/assets/images/1.jpg'/>" alt="" />
        	</a>
          	<div class="text">
            	<h3><a href="#">Riot Concert At The Park </a></h3>
            	<p>Lorem ipsum dolor sit amet porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora in...</p>
          	</div>
        </div>
      </div>
     
      <div class = "list-news">
      	<c:forEach items="${news}" var="item" varStatus="count">
      	<div class="f post">
	      	<a href="<c:url value='/client/news/${item.newId}'/>">
	      		<img style="width: 110px; height: 90px;" src="<c:url value='/template/client/assets/images/1.jpg'/>" alt="" />
	      	</a>
	        <h3><a style="text-decoration: none; font-weight: bold;" href="<c:url value='/client/news/${item.newId}'/>">${item.shortDescription}</a></h3>
	        <p class="details"><a href="<c:url value='/client/news/${item.newId}'/>">${item.tenCongTy}</a> | <a href="<c:url value='/client/news/${item.newId}'/>">${item.capBac}</a></p>
	        <p style="font-size: 11px;">Số lượng: ${item.soLuongTuyen} | Lương: ${item.mucLuong} triệu</p>
	        <p style="font-size: 11px;">Hạn nộp: ${item.hanNopHoSo}</p>
	      </div>
      	</c:forEach>
      </div>
    </div>
   
    <div id="lsidebar">
      <!-- begin pages -->
      <h2>Pages</h2>
      <ul>
        <li><a href="#">About</a></li>
        <li><a href="#">Links</a></li>
        <li><a href="#">Archives</a></li>
        <li><a href="#">Resources</a></li>
        <li><a href="#">Contact</a></li>
        <li><a href="#">Sitemap</a></li>
      </ul>
      <!-- end pages -->
      <!-- begin categories -->
      <h2>Categories</h2>
      <ul>
        <li><a href="#">Entertainment</a></li>
        <li><a href="#">Fashion</a></li>
        <li><a href="#">Food</a></li>
        <li><a href="#">Marketing</a></li>
        <li><a href="#">Lifestyle</a></li>
        <li><a href="#">Pictures</a></li>
        <li><a href="#">Videos</a></li>
      </ul>
      <!-- end categories -->
      <!-- begin archives -->
      <h2>Archives</h2>
      <ul>
        <li><a href="#">December 2022</a></li>
        <li><a href="#">November 2022</a></li>
        <li><a href="#">October 2022</a></li>
        <li><a href="#">Septemher 2022</a></li>
        <li><a href="#">August 2022</a></li>
      </ul>
      <!-- end archives -->
      <!-- begin blogroll -->
      <h2>Blogroll</h2>
      <ul>
        <li><a href="#">Documentation</a></li>
        <li><a href="#">Suggest Ideas</a></li>
        <li><a href="#">Support Forum</a></li>
      </ul>
      <!-- end blogroll -->
      <!-- begin meta -->
      <h2>Meta</h2>
      <ul>
        <li><a href="#">Login</a></li>
      </ul>
      <!-- end meta -->
    </div>
    <!-- END left sidebar -->
    <!-- BEGIN right sidebar -->
    <div id="rsidebar">
      <!-- begin site sponsors -->
      <h2>Site Sponsors</h2>
      <div class="sponsors">
      	<a href="#"><img src="<c:url value='/template/client/assets/images/111.jpg'/>" alt="" /></a>
      	<a href="#"><img src="<c:url value='/template/client/assets/images/444.jpg'/>" alt="" /></a>
      	<a href="#"><img src="<c:url value='/template/client/assets/images/222.jpg'/>" alt="" /></a>
      	<a href="#"><img src="<c:url value='/template/client/assets/images/333.jpg'/>" alt="" /></a>
      </div> 
      <!-- end site sponsors -->
      <!-- begin twitter updates -->
      <h2>Twitter Updates</h2>
      <div class="twitter"> Cleaning my garage at this hour.. can't sleep. </div>
      <!-- end twitter updates -->
      <!-- begin popular articles -->
      <h2>Popular Articles</h2>
      <ul>
        <li><a href="#">VW Scirocco EVO R by Caractere</a></li>
        <li><a href="#">Nitrous Oxide Tuning - NOS</a></li>
        <li><a href="#">Premier4509 Bentley Continental GT</a></li>
        <li><a href="#">Hennessey announces plans to modify the</a></li>
        <li><a href="#">VW Scirocco EVO R by Caractere</a></li>
        <li><a href="#">Nitrous Oxide Tuning - NOS</a></li>
      </ul>
      <!-- end popular articles -->
      <!-- begin featured video -->
      <h2>Featured Video</h2>
      <div class="video">
      	<img src="<c:url value='/template/client/assets/images/5.jpg'/>" alt="" />
      </div>
      <!-- end featured video -->
      <!-- begin flickr gallery -->
      <h2>Flickr Gallery</h2>
      <div class="flickr">
      	<a href="#"><img src="<c:url value='/template/client/assets/images/2810.png'/>" alt="" /></a>
      	<a href="#"><img src="<c:url value='/template/client/assets/images/777.jpg'/>" alt="" /></a>
      	<a href="#"><img src="<c:url value='/template/client/assets/images/28103.png'/>" alt="" /></a>
      	<a href="#"><img src="<c:url value='/template/client/assets/images/28102.jpg'/>" alt="" /></a>
      	<a href="#"><img src="<c:url value='/template/client/assets/images/999.jpg'/>" alt="" /></a>
      	<a href="#"><img src="<c:url value='/template/client/assets/images/99999.jpg'/>" alt="" /></a>
      </div>
      <!-- end flickr gallery -->
    </div>
    <!-- END right sidebar -->
    <div class="break"></div>
  
  <!-- END body -->
  
  <script type="text/javascript">
  	$(document).ready(function () {
		
	});
  </script>

</body>