<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse bg-white mt-3">
    <div class="position-sticky">
      <div class="list-group list-group-flush mx-3 mt-4">
        <a href="dashboard" class="list-group-item list-group-item-action py-2 ripple active" aria-current="true">
          <i class="fas fa-tachometer-alt fa-fw me-3"></i>
          <span>Main dashboard</span>
        </a>
        
        <a class="list-group-item list-group-item-action py-2 ripple" role="button" data-mdb-toggle="dropdown" aria-expanded="false">
          <i class="fas fa-chart-area fa-fw me-3"></i>
          <span>Salle de Reunion</span>
        </a>
        	<span class="visually-hidden">Toggle Dropdown</span>		  
			<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMenuLink">
				<c:if test="${statut!=-1}">
	            	<li><a class="dropdown-item" href="add-salle">Ajoute une Salle</a></li>
	            </c:if>	
	            <!-- <li><a class="dropdown-item" href="#">Modifier le Profil</a></li> -->
	            <li><a class="dropdown-item" href="salle-list">Listes des Salles</a></li>
          	</ul>        
        <c:if test="${statut!=-1}">
		    <a class="list-group-item list-group-item-action py-2 ripple dropdown-toggle" role="button" data-mdb-toggle="dropdown" aria-expanded="false">
		         <i class="fas fa-building fa-fw me-3"></i><span>Clients</span>
		           
		    </a> 
			    <span class="visually-hidden">Toggle Dropdown</span>		  
				<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMenuLink">
		            <li><a class="dropdown-item" href="add-client">Ajoute un nouveau Client</a></li>
		            <li><a class="dropdown-item" href="client-list">Listes des Clients</a></li>
	          	</ul>
		
	        <a href="agenda-reservation" class="list-group-item list-group-item-action py-2 ripple">
	        	<i class="fas fa-calendar fa-fw me-3"></i>
	           <span>Reservation de la salle</span>
	        </a>
	        <c:if test="${statut==1}">
		        <a role="button" data-mdb-toggle="dropdown" aria-expanded="false" class="list-group-item list-group-item-action py-2 ripple dropdown-toggle">
		            <i class="fas fa-users fa-fw me-3"></i>
			        <span>Utilisateurs</span>
			    </a>	     		  
					<span class="visually-hidden">Toggle Dropdown</span>		  
					<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMenuLink">
			            <li><a class="dropdown-item" href="add-employee">Ajoute un compte Employee</a></li>
			            <!-- <li><a class="dropdown-item" href="#">Modifier le Profil</a></li> -->
			            <li><a class="dropdown-item" href="employee-list">Listes des Personnels</a></li>
		          	</ul>
		    </c:if>      	
	    </c:if>      	
        <a href="contact" class="list-group-item list-group-item-action py-2 ripple">
	        <i class="fas fa-envelope"></i>
	        <span>Contact</span>
        </a>
          
      </div>
    </div>
  </nav>
  <!-- Sidebar -->

  <!-- Navbar -->
  <nav
       id="main-navbar"
       class="navbar navbar-expand-lg navbar-light bg-white fixed-top mb-5 navbar_bg_display"
       >
    <!-- Container wrapper -->
    <div class="container-fluid">
      <!-- Toggle button -->
      <button
              class="navbar-toggler"
              type="button"
              data-mdb-toggle="collapse"
              data-mdb-target="#sidebarMenu"
              aria-controls="sidebarMenu"
              aria-expanded="false"
              aria-label="Toggle navigation"
              >
        <i class="fas fa-bars"></i>
      </button>

      <!-- Brand -->
      <a class="navbar-brand" href="#">
        <img class="image_logo"
             src="https://cdn3.vectorstock.com/i/thumb-large/18/12/teamwork-people-united-logo-vector-911812.jpg"
             height="45"
             alt="Logo EZ-Meet"
             loading="lazy"
             />
         <span class="ez_title_dash">EZ-MEET</span>    
      </a>
       <!-- Search form -->
      <!--<form class="d-none d-md-flex input-group w-auto my-auto">
        <input
               autocomplete="off"
               type="search"
               class="form-control rounded"
               placeholder='Search...'
               style="min-width: 225px"
               />
        <span class="input-group-text border-0"
              ><i class="fas fa-search"></i
          ></span>
      </form> -->

      <!-- Right links -->
      <ul class="navbar-nav ms-auto d-flex flex-row">
        <!-- Notification dropdown -->        

        <!-- Avatar -->
        <li class="nav-item dropdown">
          <a
             class="nav-link dropdown-toggle hidden-arrow d-flex align-items-center username_style"             
             id="navbarDropdownMenuLink"
             role="button"
             data-mdb-toggle="dropdown"
             aria-expanded="false"
             >
            Bonjour ${username}
          </a>
          <ul
              class="dropdown-menu dropdown-menu-end"
              aria-labelledby="navbarDropdownMenuLink"
              >
            <li><a class="dropdown-item" href="affiche-profile?username=${username}">My profile</a></li>
            <!-- <li><a class="dropdown-item" href="#">Settings</a></li> -->
            <li><a class="dropdown-item" href="home-page">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
    <!-- Container wrapper -->
  </nav>
  <!-- Navbar -->