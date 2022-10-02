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

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous" />
<link href='https://use.fontawesome.com/releases/v5.0.6/css/all.css' rel='stylesheet' />

<link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.6.0/main.min.css" rel='stylesheet' />
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.6.0/main.min.js"></script>
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
		<div id='calendar'></div>
		<h2>Agenda</h2> 
		    <div class="agenda">
		        <div class="table-responsive">
		            <table class="table table-condensed table-bordered">
		                <thead>
		                    <tr>
		                        <th>Date de Reservation</th>
		                        <th>Heure Debut</th>
		                        <th>Heure Fin</th>
		                        <th>Evenements</th>
		                    </tr>
		                </thead>
		                <tbody>
		                    <!-- Single event in a single day -->
		                    <c:forEach var = 'reservation' items="${reservations}">
		                    <tr>
		                        <td class="agenda-date reserve-date" rowspan="1">
		                            ${reservation.getDateReserve()}
		                        </td>
		                        <td class="agenda-time reserve-time-start">
		                            ${reservation.getHeureDebut()}
		                        </td>
		                        <td class="agenda-time reserve-time-end">
		                            ${reservation.getHeureFin()}
		                        </td>
		                        <td class="agenda-events">
		                            <div class="agenda-event evenement">
		                                
		                                ${reservation.getMotif()}
		                            </div>
		                        </td>
		                    </tr>
		                  	</c:forEach>  
		                    
		                </tbody>
		            </table>
		        </div>
		    </div>
		</div>	
		
<%@ include file = "scripts/agenda.jsp" %>	
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>
</html>