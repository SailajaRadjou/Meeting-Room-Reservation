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
		<h3 class="mt-5 text-center mb-5">Reservation la Salle de Reunion</h3>
		<form method="post" action="update-reservation?salleid=${salle.getSalleId()}&reserveid=${reservation.getReserveId()}" style="margin-top: 25px;"> 
			<h4 class="mt-5 text-center mb-5">${salle.getSalleNom()}</h4>
			<div class="row mb-4">
				<div class="form-group col-md-6">
				<label for="username">Nom d'utilisateur*</label>
					<div class="input-group">
					  <input type="text" id="nomClient" class="form-control" name="username" value = ${client.getUsername()} />					  
					</div>
				</div>
				<div class="form-group col-md-6">
				<label for="motif">Motif de reservation</label>
					<div class="input-group">
					  <input type="text" id="motif" class="form-control" name="motif" value = "${reservation.getMotif()}" />					  
					</div>
				</div>
			</div>       	  
	      	<div class="row mb-4">
	      		<div class="form-group col-md-6">
				<label for="typeText">Capacite</label>
					<div class="input-group">
					  <input type="text" id="salleId" class="form-control" readonly value = "${salle.getCapacite()} Personnes" />					  
					</div>
				</div>
	      		<div class="form-group col-md-6">
				<label for="typeText">Tarif horaire</label>
					<div class="input-group">
					  <input type="text" id="tarif" class="form-control" readonly value = "${salle.getTarif()}" />					  
					</div>
				</div>
			</div>
			<div class="row mb-4">	
	      		<div class="form-group col-md-8">
			      <label for="date">Date de reservation</label>
				     <div class="input-group date" id="datepicker">
				        <input type="text" class="form-control" id="date" name="reserveDate" value = "${reservation.getDateReserve()}" />
				        <span class="input-group-append">
				          <span class="input-group-text bg-light d-block">
				            <i class="fa fa-calendar"></i>
				          </span>
				        </span>
				      </div>
				</div>
			</div>	
			<div class="row mb-4 bootstrap-timepicker">			   
			    <div class="form-group col-md-6">
			      <label for="time">De : </label>
			      <div class="input-group time" id="timePicker1">
			        <input type="text" class="form-control timePicker" id="timeFrom" name="startTime" />
			        <span class="input-group-addon">
			        	<span class="input-group-text bg-light d-block">
			        		<i class="fa fa-clock-o" aria-hidden="true"></i>
			        	</span>
			        </span>	
			      </div>
			    </div>
			    <div class="form-group col-md-6 bootstrap-timepicker">
			      <label for="time">A : </label>
			      <div class="input-group time" id="timePicker2">
			        <input type="text" class="form-control timePicker" id="timeTo" name="endTime" onChange="getDiff()" />
			        <span class="input-group-addon">
			        	<span class="input-group-text bg-light d-block">
			        		<i class="fa fa-clock-o" aria-hidden="true"></i>
			        	</span>
			        </span>	
			      </div>
			    </div>
			</div> 
			
			<div class="row mb-4">
			 <div class="form-group col-md-4">
					<label for="heureTotale">Nombre d'heures totales</label>
					<div class="input-group">
					  <input type="text" id="heureTotale" class="form-control" />					  
					</div>
				</div>
			
				<div class="form-group col-md-8">
				<label for="montant">Montant a payer</label>
					<div class="input-group">
					  <input type="number" id="montant" class="form-control" name="montant" />					  
					</div>
				</div>
				
			</div> 			
			
			<div class="row mb-4" style="margin-top: 3rem;">
				<div class="form-group col-md-4">
					<a href="salle-list" class="btn btn-primary btn-block mb-4">Annuler la Reservation</a>
				</div>
				<div class="form-group col-md-4">	
					<button type="submit" id="reserve" class="btn btn-primary btn-block mb-4" disabled>Reserver</button> 
				</div>		
			</div> 
	  		
      </form>
	</div>
	
	<%@ include file = "scripts/date-time-picker.jsp"%> 
 	
	<script
	  type="text/javascript"
	  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
	></script>
	
</body>
</html>