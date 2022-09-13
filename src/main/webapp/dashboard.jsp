<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.css"
  rel="stylesheet"
/>
<%@ include file = "css/style.jsp"%>
<%@ include file = "css/home-style.jsp"%>
<title>Meeting Room Reservation</title>
</head>
<body>
<header>
  <!-- Sidebar -->
  <%@ include file = "layout/side-bar.jsp" %>
</header>
<!--Main Navigation-->

<!--Main layout-->
<main style="margin-top: 58px">
  <div class="container pt-4">
		<!-- Heading -->
		<div class="mb-4 wow fadeIn">
		
		    <!--Card content-->
		    <div class="d-sm-flex justify-content-between">
		
		        <h4 class="mb-sm-0 pt-3">
		            <a href="/" target="_blank">Home</a>
		            <span>/</span>
		            <span>Dashboard</span>
		        </h4>
		
		       <!--  <form class="d-flex md-form justify-content-center my-0">
		            Default input
		            <input type="search" placeholder="Type your query" aria-label="Search" class="form-control">
		            <a href="#" class="btn btn-primary"><i class="fas fa-search"></i></a>
		
		        </form> -->
		
		    </div>
		
		</div>
		<!-- Heading -->
		<%@ include file = "layout/dashboard-content.jsp" %>
  </div>  
</main>
<!--Main layout-->
    <!--Container Main end-->
    <!-- MDB -->
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>

</html>
