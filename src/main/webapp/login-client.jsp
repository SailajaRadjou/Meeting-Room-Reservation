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
<title>Login Page Client</title>
</head>
<body>
<div class="container-md pt-4 mt-5">
<!-- Pills navs -->
<ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
  <li class="nav-item" role="presentation">
    <a
      class="nav-link active"
      id="tab-login"
      data-mdb-toggle="pill"
      href="#pills-login"
      role="tab"
      aria-controls="pills-login"
      aria-selected="true"
      >Login</a
    >
  </li>
  <li class="nav-item" role="presentation">
    <a
      class="nav-link"
      id="tab-register"
      data-mdb-toggle="pill"
      href="#pills-register"
      role="tab"
      aria-controls="pills-register"
      aria-selected="false"
      >Register</a
    >
  </li>
</ul>
<!-- Pills navs -->

<!-- Pills content -->
<div class="tab-content">
  <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
    <form method="post" action="loginValid">
      
      <!-- Username input -->
      <div class="form-outline mt-5 mb-4">
        <input type="text" id="loginName" class="form-control" name="username"/>
        <label class="form-label" for="loginName">Username</label>
      </div>

      <!-- Password input -->
      <div class="form-outline mb-4">
        <input type="password" id="loginPassword" class="form-control" name="password" />
        <label class="form-label" for="loginPassword">Password</label>
      </div>

      <!-- 2 column grid layout -->
      <div class="row mb-4">
        <div class="col-md-6 d-flex justify-content-center">
          <!-- Checkbox -->
          <div class="form-check mb-3 mb-md-0">
            <input class="form-check-input" type="checkbox" value="" id="loginCheck" checked />
            <label class="form-check-label" for="loginCheck"> Remember me </label>
          </div>
        </div>

        <div class="col-md-6 d-flex justify-content-center">
          <!-- Simple link -->
          <a href="#!">Forgot password?</a>
        </div>
      </div>

      <!-- Submit button -->
      <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

      <!-- Register buttons -->
      <div class="text-center">
        <p>Not a member? <a href="#!">Register</a></p>
      </div>
    </form>
  </div>
  <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
    <form method = "post" action = "save-client" style="margin-top: 15px;">
  <!-- 2 column grid layout with text inputs for the first and last names -->
  <div class="row mb-4">
    <div class="col">
      <div class="form-outline">
        <input type="text" id="form8Example1" class="form-control" name="nom" />
        <label class="form-label" for="form8Example1">Nom</label>
      </div>
    </div>
    <div class="col">
      <div class="form-outline">
        <input type="text" id="form8Example2" class="form-control" name="prenom" />
        <label class="form-label" for="form8Example2">Prenom</label>
      </div>
    </div>
  </div>

  <!-- Text input -->
  <div class="form-outline mb-4">
    <input type="text" id="form8Example3" class="form-control" name="nom_entreprise" />
    <label class="form-label" for="form8Example3">Nom de l'entreprise</label>
  </div>
  
  <!-- Email input -->
  <div class="form-outline mb-4">
    <input type="email" id="form8Example4" class="form-control" name="mail" />
    <label class="form-label" for="form8Example4">Email</label>
  </div>
  
  <!-- Number input -->
  <div class="form-outline mb-4">
    <input type="text" id="form8Example5" class="form-control" name="phone" />
    <label class="form-label" for="form8Example5">Phone</label>
  </div>

  <!-- Text input -->
  

  <!-- Message input -->
  <div class="form-outline mb-4">
    <input type="text" id="form8Example7" class="form-control" name="nom_identifiant" />
    <label class="form-label" for="form8Example7">Username</label>
  </div>

  <div class="form-outline mb-4">
    <input type="password" id="form8Example8" class="form-control" name="mot_de_passe" />
    <label class="form-label" for="form8Example8">Password</label>
  </div>	  

	<!-- Text input -->
  <div class="form-outline mb-4">
  	<select class="form-select" name="civilite" id="form8Example6">
		      <option selected>Civilit�</option>
		      <option value="Mlle.">Mlle.</option>
		      <option value="Mme.">Mme.</option>
		      <option value="Mr.">Mr.</option>
	</select>
    
    
  </div>
  <!-- Submit button -->
  <button type="submit" class="btn btn-primary btn-block mb-4">Cr�er un compte</button>
</form>
  </div>
</div>
</div>
<!-- Pills content -->
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>
</html>