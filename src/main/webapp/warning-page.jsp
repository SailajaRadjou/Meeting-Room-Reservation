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
<%@ include file = "css/style.jsp"%>
<%@ include file = "css/home-style.jsp"%>
<title>Meeting Room Reservation System - Warning</title>
</head>
<body>
	<header>
	  <!-- Sidebar -->
	  <%@ include file = "layout/side-bar.jsp" %>
	</header>
	<div class="container-lg" style="margin-top: 5rem;">
		<h1 class="text-center" style="color: red; font-weight: 600;">Warning Message</h1>
		<div class="alert alert-warning" role="alert" style="margin-top: 5rem;">
			  <h3 class="alert-heading">WARNING !!!</h3>
			  <p style="font-size: 1.5rem; font-weight: 400;">Attention Please read this important alert message !!!</p>
			  <hr>
			  <p class="mb-0" style="font-size: 1.5rem; color: red; font-weight: 600;">${message}</p>			  
		</div>
	</div>
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>	
</body>
</html>