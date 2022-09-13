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
<title>Meeting Room Reservation</title>
</head>
<body>
<header>
  <!-- Sidebar -->
  <%@ include file = "layout/side-bar.jsp" %>
</header>
<div class="container mt-5 pt-4">
	<h3 class="mt-5 text-center mb-5">Listes des Salle de Réunion</h3>
	
	
	
	<c:set var="image" scope="request" value="${salle.getSalleImage()}"/>
	<%-- <c:out value="${image}"/> --%>
	<%
		String imgFileName=(String)request.getAttribute("image");
	%>
	<div class="row row-cols-1 row-cols-md-3 g-4 mt-5">
	<c:forEach var = 'salle' items="${salles}">
  		<div class="col-md-4 col-12">
			<div class="card h-100">
				<div class="col-md-12 col-4">
				  <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
				    <img src="images/${salle.getSalleImage()}" class='img-fluid rounded-start'/>
				    
				  </div>
				 </div> 
				 <div class="col-md-12 col-8">
					  <div class="card-body">
					    <h5 class="card-title">${salle.getSalleNom()}</h5>
					    <h6 class="card-title">${salle.getSalleImage()}</h6>
					    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					    <a href="#!" class="btn btn-primary">Button</a>
					  </div>
				</div>	  
			</div>
		</div>	
		</c:forEach>
	</div>	
	
</div>
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>
</html>