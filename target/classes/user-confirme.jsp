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
<title>Confirmation de nouveau Employee</title>
</head>
<body>
<header>
  <!-- Sidebar -->
  <%@ include file = "layout/side-bar.jsp" %>
</header>
<div class="container mt-5 pt-5">
	<div class="card container" style="width: 30rem;">
	  <div class="card-header px-3">Employee ajouté avec succès</div>
	  <ul class="list-group list-group-light list-group-small">
	    <li class="list-group-item px-3">#Employee Id&emsp;:&emsp;${user.getId()}</li>
	    <li class="list-group-item px-3">Nom&emsp;:&emsp;${user.getNom()}</li>
	    <li class="list-group-item px-3">Prenom&emsp;:&emsp;${user.getPrenom()}</li>
	    <li class="list-group-item px-3">Email&emsp;:&emsp;${user.getMail()}</li>	    
	    <li class="list-group-item px-3">Civilité&emsp;:&emsp;${user.getCivilite()}</li>
	    <li class="list-group-item px-3">Username&emsp;:&emsp;${user.getUsername()}</li>
	    <li class="list-group-item px-3">Password&emsp;:&emsp;****${password}****</li>
	    <li class="list-group-item px-3">Statut&emsp;:&emsp;${user.getStatut()}</li>
	  </ul>
	</div>
</div>	
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>
</html>