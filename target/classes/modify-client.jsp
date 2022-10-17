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
<title>Modify Client Details</title>
</head>
<body>
<header>
  <!-- Sidebar -->
  <%@ include file = "layout/side-bar.jsp" %>
</header>
<div class="container-lg mt-5 pt-5">
	<h3 class="mt-5 text-center mb-5">Formulaire client de modification</h3>
	<form method = "post" action = "update-client" style="margin-top: 15px;">
		  <!-- 2 column grid layout with text inputs for the first and last names -->
		  <div class="row mb-4">
		    <div class="col">
		      <div class="form-outline">
		        <input type="text" id="form6Example1" class="form-control" name="nom" value = ${client.getNom()} />
		        <label class="form-label" for="form6Example1">Nom</label>
		      </div>
		    </div>
		    <div class="col">
		      <div class="form-outline">
		        <input type="text" id="form6Example2" class="form-control" name="prenom" value = ${client.getPrenom()} />
		        <label class="form-label" for="form6Example2">Prenom</label>
		      </div>
		    </div>
		    <!-- Text input -->
		    <div class="col">
			  <div class="form-outline mb-4">
			    <input type="text" id="form6Example9" class="form-control" name="clientId" readonly value = ${client.getClientId()} />
			    <label class="form-label" for="form6Example9">Client Id</label>
			  </div>
			</div>  
		  </div>
		
		  <!-- Text input -->
		  <div class="form-outline mb-4">
		    <input type="text" id="form6Example3" class="form-control" name="nom_entreprise" value = ${client.getNomEntreprise()} />
		    <label class="form-label" for="form6Example3">Nom de l'entreprise</label>
		  </div>
		
		  <!-- Email input -->
		  <div class="form-outline mb-4">
		    <input type="email" id="form6Example4" class="form-control" name="mail" value = ${client.getMail()} />
		    <label class="form-label" for="form6Example4">Email</label>
		  </div>
		
			<!-- Text input -->
		  <div class="form-outline mb-4">
		    <input type="text" id="form6Example5" class="form-control" name="phone" value = ${client.getPhone()} />
		    <label class="form-label" for="form6Example5">Téléphone</label>
		  </div>
		
		  <!-- Text input -->
		  <div class="form-outline mb-4">
		    <input type="text" id="form6Example6" class="form-control" name="nom_identifiant" value = ${client.getUsername()} />
		    <label class="form-label" for="form6Example6">Username </label>
		  </div>
		  
		  <!-- Text input -->
		  <div class="form-outline mb-4">
		    <input type="password" id="form6Example7" class="form-control" name="mot_de_passe" value = ${client.getPassword()}/>
		    <label class="form-label" for="form6Example7">Password</label>
		  </div>
		
		  <!-- Text input -->
		  <div class="form-outline mb-4">
		    <select class="form-select" name="civilite" id="form8Example6">
				      <option selected>Civilité</option>
				      <option value=${client.getCivilite()} selected>${client.getCivilite()}</option>
				      <option value="Mlle.">Mlle.</option>
				      <option value="Mme.">Mme.</option>
				      <option value="Mr.">Mr.</option>
			</select>
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