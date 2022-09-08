<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="row mt-3">
    <div class="col-md-12">
        <!--Card-->
        <!-- Table with panel -->
		<div class="card card-cascade narrower">

			  <!--Card image-->
			  <div
			    class="view view-cascade gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">
			
			    <div>
			      <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
			        <i class="fas fa-th-large mt-0"></i>
			      </button>
			      <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
			        <i class="fas fa-columns mt-0"></i>
			      </button>
			    </div>
			
			    <a href="" class="white-text mx-3">Listes des Salle de Réunion </a>
			
			    
			
			  </div>
			  <!--/Card image-->

			  <div class="px-4">
			
			    <div class="table-wrapper">
			      <!--Table-->
			      <table class="table table-hover mb-0">
			
			        <!--Table head-->
			        <thead>
			          <tr>
			            
			            <th scope="col" class="th-lg">
			              Client Id			                
			            </th>
			            <th scope="col" class="th-lg">
			              Nom			              
			            </th>
			            <th scope="col" class="th-lg">
			              Prenom 		              
			            </th>
			            <th scope="col" class="th-lg">
			              Nom de l'entreprise			                
			            </th>
			            <th scope="col" class="th-lg">
			              Email			              
			            </th>
			            <th scope="col" class="th-lg">
			              Phone no			                
			            </th>
			            <th scope="col" class="th-lg">
			             Civilité			                
			            </th>
			            <th scope="col" class="th-lg">			              			              
			            </th>
			          </tr>
			        </thead>
			        <!--Table head-->
			
			        <!--Table body-->
			        <tbody>
			        <c:forEach var = 'c' items="${clients}">
			          <tr>
			            
			            <td>${c.getClientId()}</td>
			            <td>${c.getNom()}</td>
			            <td>${c.getPrenom()}</td>
			            <td>${c.getNomEntreprise()}</td>
			            <td>${c.getMail()}</td>
			            <td>${c.getPhone()}</td>
			            <td>${c.getCivilite()}</td>
			            <td>
			            <div>
					      <a href="modify-client?idclient=${c.getClientId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
					        <i class="fas fa-pencil-alt mt-0"></i>
					      </a>
					      <a href="delete-client?idclient=${c.getClientId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
					        <i class="far fa-trash-alt mt-0"></i>
					      </a>
					      <a href="client-detail?idclient=${c.getClientId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
					        <i class="fas fa-info-circle mt-0"></i>
					      </a>
			    		</div>
			    		</td>
			          </tr>
			        </c:forEach>  
			        
			        </tbody>
			        <!--Table body-->
			      </table>
			      <!--Table-->
			    </div>
			
			  </div>

		</div>
		<!-- Table with panel -->
		<!--/.Card-->
		<%@ include file = "../modal.jsp" %>
    </div>
</div>