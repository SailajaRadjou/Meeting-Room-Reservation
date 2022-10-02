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
<title>Confirmation de Reservation</title>
</head>
<body>
<header>
  <!-- Sidebar -->
  <%@ include file = "layout/side-bar.jsp" %>
</header>
<div class="container mt-5 pt-5">
	<div class="card container" style="width: 30rem;">
	  <div class="card-header px-3">Reservation Confirmer</div>
	  <ul class="list-group list-group-light list-group-small">
	    <li class="list-group-item px-3">#Client Id&emsp;:&emsp;${reservation.getClient().getClientId()}</li>
	    <li class="list-group-item px-3">Nom&emsp;:&emsp;${client.getNom()}</li>
	    <li class="list-group-item px-3">Prenom&emsp;:&emsp;${client.getPrenom()}</li>
	    <li class="list-group-item px-3">Nom de l'entreprise&emsp;:&emsp;${client.getNomEntreprise()}</li>
	    <li class="list-group-item px-3">Salle r�serv�e&emsp;:&emsp;${salle.getSalleNom()}</li>
	    <li class="list-group-item px-3">Date de Reservation&emsp;:&emsp;${reservation.getDateReserve()}</li>
	    <li class="list-group-item px-3">Tarif � l'heure&emsp;:&emsp;${salle.getTarif()}</li>
	    <li class="list-group-item px-3">Montant � Payer&emsp;:&emsp;${reservation.getMontant()}</li>	    
	  </ul>
	</div>
</div>	
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>
</html>