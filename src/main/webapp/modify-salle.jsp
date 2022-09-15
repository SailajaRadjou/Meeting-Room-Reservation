<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Rampart+One&display=swap" rel="stylesheet">
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
<title>Ajoute une nouvelle salle</title>
</head>
<body>
<header>
  <!-- Sidebar -->
  <%@ include file = "layout/side-bar.jsp" %>
</header>
<div class="container mt-5 pt-4">
<h3 class="mt-5 text-center mb-5">Ajoute une nouvelle Salle de Réunion</h3>
	<form method="post" action="update-salle" enctype="multipart/form-data" style="margin-top: 15px;">
	  <!-- 2 column grid layout with text inputs for the first and last names -->
	  <div class="row mb-4">
	    <div class="col">
	      <div class="form-outline">
	        <input type="text" id="form6Example1" class="form-control" name="salleId" readonly value = ${salle.getSalleId()} />
	        <label class="form-label" for="form6Example1">Salle Id</label>
	      </div>
	    </div>
	    <div class="col">
	      <div class="form-outline">
	        <input type="text" id="form6Example2" class="form-control" name="salleNom" value = ${salle.getSalleNom()} />
	        <label class="form-label" for="form6Example2">Nom de Salle</label>
	      </div>
	    </div>
	  </div>
	
	  <!-- Text input -->
	  <div class="form-outline mb-4">
	    <input type="text" id="form6Example3" class="form-control" name="localisation" value = ${salle.getLocalisation()} />
	    <label class="form-label" for="form6Example3">Localisation</label>
	  </div>
	
	  <!-- Number input -->
	  <div class="form-outline mb-4">
	    <input type="number" id="form6Example6" class="form-control" name="capacite" value = ${salle.getCapacite()} />
	    <label class="form-label" for="form6Example6">Capacite</label>
	  </div>
	  
	  <!-- Number input -->
	  <div class="form-outline mb-4">
	    <input type="number" id="form6Example4" class="form-control" name="tarif" value = ${salle.getTarif()} />
	    <label class="form-label" for="form6Example4">Tarif à l'heure</label>
	  </div>
	
	  <!-- File input -->
	  
	  <div class="form-outline mb-4">	    
	    <input type="file" class="form-control" value="Choisissez une image à télécharger" name="image" id="customFile">	
	  </div>		
	  	
	  <!-- Submit button -->
	  <button type="submit" class="btn btn-primary btn-block mb-4">Enregistrer</button>
	</form>
</div>
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>
</html>