<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

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

<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha3/dist/css/bootstrap.min.css" crossorigin="anonymous" /> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" crossorigin="anonymous" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" crossorigin="anonymous" />

<script src="https://rawgit.com/moment/moment/2.29.4/min/moment.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.min.js"></script>
 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script> 
<!--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js" crossorigin="anonymous"></script> -->

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
	<h3 class="mt-5 text-center mb-5">Listes des Salle de Reunion</h3>	
	<c:set var="image" scope="request" value="${salle.getSalleImage()}"/>
	<%-- <c:out value="${image}"/> --%>
	<%
		String imgFileName=(String)request.getAttribute("image");
	%>
	<div class="row row-cols-1 row-cols-md-3 g-4 mt-5 mb-5">
	<c:forEach var = 'salle' items="${salles}">
  		<div class="col-md-4 col-12">
			<div class="card h-100" style="border-top: 5px solid #33b5e5;">
				<div class="col-md-12">
				  <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
				    <img src="http://localhost:8080/MeetingRoomReservation/images/${salle.getSalleImage()}" class='img-fluid rounded-start' style="height: 280px; width: 100%;"/>
				    
				  </div>
				 </div> 
				 <div class="col-md-12">
					  <div class="card-body">
						<div class="d-flex justify-content-between">					  
						    <h5 class="card-title">${salle.getSalleNom()}</h5>
						    <c:if test="${statut!=-1}">
							    <span>
								      <a href="modify-salle?salleid=${salle.getSalleId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
								        <i class="fas fa-pencil-alt mt-0"></i>
								      </a>
								      <a href="delete-salle?salleid=${salle.getSalleId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
								        <i class="far fa-trash-alt mt-0"></i>
								      </a>
								      <%-- <a href="salle-detail?salleid=${salle.getSalleId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
								        <i class="fas fa-plus-circle"></i>
								      </a> --%>
						    	</span>
					    	</c:if>
					   </div> 	
					    <h6 class="card-title">${salle.getTarif()} <i class="fas fa-euro-sign"></i> /heure</h6>
					    <p class="card-text">Explore flexible meeting rooms  situated in the heart of ${salle.getLocalisation()}.</p>
					    <a href="salle-reservation?salleid=${salle.getSalleId()}" class="btn btn-primary">Reservez maintenant</a> 
					 	
					   	
					  </div>
				</div>	  
			</div>
		</div>	
		</c:forEach>
	</div>	
	
</div>
 <%@ include file = "scripts/date-time-picker.jsp"%> 
 <!-- <script type="text/javascript">//for modal
							$(".reservation").on("click", function () {
							    var id = $(this).data('id');
							    console.log(id);
							    $(".modal-body #salleId").val( id );
							});
						</script> -->		
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>

</body>
</html>