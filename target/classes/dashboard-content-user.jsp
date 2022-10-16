<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container container-sm container-md mt-5 pt-4">		
		<h2 class='text-center'>Réservation d'informations</h2> 
		    <div class="agenda">
		        <div class="table-responsive">
		            <table class="table table-condensed table-bordered table-striped table-hover">
		                <thead class="thread-light">
		                    <tr>
		                        <th scope="col" class="th-lg table_heading">Date de Reservation</th>
		                        <th scope="col" class="th-lg table_heading">Heure Debut</th>
		                        <th scope="col" class="th-lg table_heading">Heure Fin</th>
		                        <th scope="col" class="th-lg table_heading">Evenements</th>
		                        <th scope="col" class="th-lg"></th>
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
		                        <td>
						            <div class="d-flex justify-content-around">
								      <a href="modify-reservation?idreserve=${reservation.getReserveId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
								        <i class="fas fa-pencil-alt mt-0"></i>
								      </a>
								      <a href="delete-reservation?idreserve=${reservation.getReserveId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
								        <i class="far fa-trash-alt mt-0"></i>
								      </a>								      
						    		</div>
					    		</td>
		                    </tr>
		                  	</c:forEach>  		                    
		                </tbody>
		            </table>
		        </div>
		    </div>
</div>	