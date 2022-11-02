<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
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
<%@ include file = "scripts/load.jsp"%>
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
		
		      <!-- <form class="d-flex md-form justify-content-center my-0">
		            Default input
		            <input type="search" placeholder="Type your query" aria-label="Search" class="form-control">
		            <a href="#" class="btn btn-primary"><i class="fas fa-search"></i></a>
		
		        </form>  -->
		     <form method="post" action="search" class="d-none d-md-flex input-group w-auto my-auto">
		        <input
		               autocomplete="off"
		               type="search"
		               class="form-control rounded"
		               placeholder='Recherche nom des clients...'
		               name="nom"
		               style="min-width: 245px"
		        />
		        <button type="submit" class="input-group-text border-0">
		        	<i class="fas fa-search"></i>
		        </button>
      		</form>   
		
		    </div>
		
		</div>
		<!-- Heading -->
		<c:if test="${statut==1 || statut==0}">
			<%@ include file = "layout/dashboard-content.jsp" %>
		</c:if>	
		
		<c:if test="${statut==-1}">
			<%@ include file = "layout/dashboard-content-user.jsp" %>
		</c:if>		
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
