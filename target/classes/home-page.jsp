<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
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
<title>EZ-Meet - Have a Flexible Meeting</title>
</head>
<body>
	<header>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white">
    <div class="container-fluid  justify-content-end">
	    <div class="dropdown">
		  <a
		    class="btn btn-primary dropdown-toggle"
		    href="#"
		    role="button"
		    id="dropdownMenuLink"
		    data-mdb-toggle="dropdown"
		    aria-expanded="false"
		  >
		    Connections
		  </a>
		
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
		    <li><a class="dropdown-item" href="loginClient">Client</a></li>
		    <li><a class="dropdown-item" href="loginUser">EZ-Meet Personnel</a></li>
		    <li><a class="dropdown-item" href="#">À propos de nous</a></li>
		  </ul>
		</div>
    </div>
  </nav>
  <!-- Navbar -->

  <!-- Background image -->
  <div class="p-5 text-center bg-image" style="background-image: url('http://localhost:8080/MeetingRoomReservation/images/jumbotron.jpg'); height: 400px;">
    <div class="mask">
      <div class="d-flex justify-content-center align-items-center h-100">
        <div class="text-white">
          <h1 class="mb-3 ez_title">EZ-MEET</h1>
          <h4 class="mb-3">An amazing event begins with us.</h4>
          <a class="btn btn-outline-light btn-lg border-3 rounded-pill h3" href="#!" role="button">
          En savoir plus</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Background image -->
</header>
<div class="container mt-5 pt-4">
	<%@ include file = "layout/home-room-card.jsp"%>
	<%@ include file = "layout/accordion-faq.jsp"%>
	
</div>
<%@ include file = "layout/footer-home.jsp"%>	
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>
</html>