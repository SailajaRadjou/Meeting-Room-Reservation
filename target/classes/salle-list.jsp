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
			<div class="card h-100" style="border-top: 5px solid #33b5e5;">
				<div class="col-md-12 col-4">
				  <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
				    <img src="images/${salle.getSalleImage()}" class='img-fluid rounded-start' style="height: 280px; width: 100%;"/>
				    
				  </div>
				 </div> 
				 <div class="col-md-12 col-8">
					  <div class="card-body">
						<div class="d-flex justify-content-between">					  
						    <h5 class="card-title">${salle.getSalleNom()}</h5>
						    <span>
							      <a href="modify-salle?salleid=${salle.getSalleId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
							        <i class="fas fa-pencil-alt mt-0"></i>
							      </a>
							      <a href="delete-salle?salleid=${salle.getSalleId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
							        <i class="far fa-trash-alt mt-0"></i>
							      </a>
							      <a href="salle-detail?salleid=${salle.getSalleId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
							        <i class="fas fa-info-circle mt-0"></i>
							      </a>
					    	</span>
					   </div> 	
					    <h6 class="card-title">${salle.getTarif()} €</h6>
					    <p class="card-text">Explore flexible meeting rooms  situated in the heart of ${salle.getLocalisation()}.</p>
					    <a href="#!" class="btn btn-primary">Réservez dès maintenant</a>
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