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
<title>Employee Listes</title>
</head>
<body>
<header>
  <!-- Sidebar -->
  <%@ include file = "layout/side-bar.jsp" %>
</header>
<div class="container-lg mt-5 pt-5">
	<div class="row mt-3">
	    <div class="col-md-12">
	        <!--Card-->
	        <!-- Table with panel -->
			<div class="card card-cascade narrower">
	
				  <!--Card image-->
				  <div
				    class="view view-cascade gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">
				
				    <!-- <div>
				      <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
				        <i class="fas fa-th-large mt-0"></i>
				      </button>
				      <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
				        <i class="fas fa-columns mt-0"></i>
				      </button>
				    </div> -->
				
				    <h2 class="white-text mx-3 text-center">Listes des Personnals </h2>
					<form method="post" action="searchEmployee" class="d-none d-md-flex input-group w-auto my-auto">
				        <input
				               autocomplete="off"
				               type="search"
				               class="form-control rounded"
				               placeholder='Recherche nom des employees...'
				               name="nom"
				               style="min-width: 285px"
				        />
				        <button type="submit" class="input-group-text border-0">
				        	<i class="fas fa-search"></i>
				        </button>
		      		</form> 
				    
				
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
				              Id			                
				            </th>
				            <th scope="col" class="th-lg">
				              Nom			              
				            </th>
				            <th scope="col" class="th-lg">
				              Prenom 		              
				            </th>				            
				            <th scope="col" class="th-lg">
				              Email			              
				            </th>
				            <th scope="col" class="th-lg">
				             Civilité			                
				            </th>
				            <th scope="col" class="th-lg">
				             Statut			                
				            </th>
				            <th scope="col" class="th-lg">			              			              
				            </th>
				          </tr>
				        </thead>
				        <!--Table head-->
				
				        <!--Table body-->
				        <tbody>
				        <c:forEach var = 'u' items="${users}">
				          <tr>
				            
				            <td>${u.getId()}</td>
				            <td>${u.getNom()}</td>
				            <td>${u.getPrenom()}</td>
				            <td>${u.getMail()}</td>
				            <td>${u.getCivilite()}</td>
				            <td>${u.getStatut()}</td>
				            <td>
				            <div class="d-flex justify-content-around">
						      <a href="modify-employee?idemployee=${u.getId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
						        <i class="fas fa-pencil-alt mt-0"></i>
						      </a>
						      <a href="delete-employee?idemployee=${u.getId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
						        <i class="far fa-trash-alt mt-0"></i>
						      </a>
						      <%-- <a href="employee-detail?idemployee=${u.getId()}" class="btn btn-outline-white btn-rounded btn-sm px-2">
						        <i class="fas fa-info-circle mt-0"></i>
						      </a> --%>
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
			
	    </div>
	</div>
</div>	
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>
</html>