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
<title>Créer un nouveau compte pour un personnal de EZ-MEET</title>
</head>
<body>
<header>
  <!-- Sidebar -->
  <%@ include file = "layout/side-bar.jsp" %>
</header>
<div class="container-md pt-4 mt-5">
<h2 class="white-text m-5 text-center">Formulaire d'information sur l'employé</h2>
<form method = "post" action = "save-employee" style="margin-top: 15px;">
  <!-- 2 column grid layout with text inputs for the first and last names -->
  <div class="row mb-4">
    <div class="col">
      <div class="form-outline">
        <input type="text" id="form6Example1" class="form-control" name="nom"/>
        <label class="form-label" for="form6Example1">Nom</label>
      </div>
    </div>
    <div class="col">
      <div class="form-outline">
        <input type="text" id="form6Example2" class="form-control" name="prenom"/>
        <label class="form-label" for="form6Example2">Prenom</label>
      </div>
    </div>
  </div> 

  <!-- Email input -->
  <div class="form-outline mb-4">
    <input type="email" id="form6Example4" class="form-control" name="mail"/>
    <label class="form-label" for="form6Example4">Email</label>
  </div>	

  <!-- Text input -->
  <div class="form-outline mb-4">
    <input type="text" id="form6Example6" class="form-control" name="nom_identifiant"/>
    <label class="form-label" for="form6Example6">Username </label>
  </div>
  
  <!-- Text input -->
  <div class="form-outline mb-4">
    <input type="password" id="form6Example7" class="form-control" name="mot_de_passe"/>
    <label class="form-label" for="form6Example7">Password</label>
  </div>

  <!-- Text input -->
  <div class="row mb-4">
  	<div class="col">
		  <div class="form-outline mb-4">
		    <select class="form-select" name="civilite" id="form8Example6">
				      <option selected>Civilité</option>
				      <option value="Mlle.">Mlle.</option>
				      <option value="Mme.">Mme.</option>
				      <option value="Mr.">Mr.</option>
			</select>
		  </div>
  	</div>
  	<div class="col">
  	   <div class="form-outline mb-4">
	  		<select	id="form8Example7" class="form-select" name="statut">
						<option value="0" selected>0</option>					
						<option value="1">1</option>
			</select>
	   </div>	
    </div>	
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