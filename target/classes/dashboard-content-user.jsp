<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container mt-5 pt-4">		
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