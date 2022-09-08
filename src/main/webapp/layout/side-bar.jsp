<nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse bg-white">
    <div class="position-sticky">
      <div class="list-group list-group-flush mx-3 mt-4">
        <a href="dashboard" class="list-group-item list-group-item-action py-2 ripple active" aria-current="true">
          <i class="fas fa-tachometer-alt fa-fw me-3"></i>
          <span>Main dashboard</span>
        </a>
        <a href="table" class="list-group-item list-group-item-action py-2 ripple">
          <i class="fas fa-chart-area fa-fw me-3"></i>
          <span>Salle de Reunion</span>
        </a>        
        <span class="dropend">
	        <a class="list-group-item list-group-item-action py-2 ripple dropdown-toggle"
	           href="#" data-mdb-toggle="dropdown" aria-expanded="false">
	           <i class="fas fa-building fa-fw me-3"></i><span>Clients</span>
	           
	        </a> 
		    <span class="visually-hidden">Toggle Dropdown</span>		  
			  <ul class="dropdown-menu">
			    <li><a class="dropdown-item" href="#">Action</a></li>
			    <li><a class="dropdown-item" href="#">Another action</a></li>
			    <li><a class="dropdown-item" href="#">Something else here</a></li>
			    <li><hr class="dropdown-divider" /></li>
			    <li><a class="dropdown-item" href="#">Separated link</a></li>
			  </ul>
		</span>
        <a
           href="#"
           class="list-group-item list-group-item-action py-2 ripple"
           ><i class="fas fa-calendar fa-fw me-3"></i>
           <span>Reservation de la salle</span>
        </a>
        <span class="dropend">
	        <a href="#" data-mdb-toggle="dropdown" aria-expanded="false"
	           class="list-group-item list-group-item-action py-2 ripple dropdown-toggle">
	           <i class="fas fa-users fa-fw me-3"></i>
	           <span>Utilisateurs</span>
	        </a>
	     		  
			  <ul class="dropdown-menu">
			    <li><a class="dropdown-item" href="#">Action</a></li>
			    <li><a class="dropdown-item" href="#">Another action</a></li>
			    <li><a class="dropdown-item" href="#">Something else here</a></li>
			    <li><hr class="dropdown-divider" /></li>
			    <li><a class="dropdown-item" href="#">Separated link</a></li>
			  </ul>
		</span>   
        <a href="contact" class="list-group-item list-group-item-action py-2 ripple">
	        <i class="fas fa-money-bill fa-fw me-3"></i>
	        <span>Contact</span>
        </a>
          
      </div>
    </div>
  </nav>
  <!-- Sidebar -->

  <!-- Navbar -->
  <nav
       id="main-navbar"
       class="navbar navbar-expand-lg navbar-light bg-white fixed-top"
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
        <img
             src="https://mdbootstrap.com/img/logo/mdb-transaprent-noshadows.png"
             height="25"
             alt=""
             loading="lazy"
             />
      </a>
      <!-- Search form -->
      <form class="d-none d-md-flex input-group w-auto my-auto">
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
      </form>

      <!-- Right links -->
      <ul class="navbar-nav ms-auto d-flex flex-row">
        <!-- Notification dropdown -->
        <li class="nav-item dropdown">
          <a
             class="nav-link me-3 me-lg-0 dropdown-toggle hidden-arrow"
             href="#"
             id="navbarDropdownMenuLink"
             role="button"
             data-mdb-toggle="dropdown"
             aria-expanded="false"
             >
            <i class="fas fa-bell"></i>
            <span class="badge rounded-pill badge-notification bg-danger"
                  >1</span
              >
          </a>
          <ul
              class="dropdown-menu dropdown-menu-end"
              aria-labelledby="navbarDropdownMenuLink"
              >
            <li><a class="dropdown-item" href="#">Some news</a></li>
            <li><a class="dropdown-item" href="#">Another news</a></li>
            <li>
              <a class="dropdown-item" href="#">Something else here</a>
            </li>
          </ul>
        </li>

        <!-- Icon -->
        <li class="nav-item">
          <a class="nav-link me-3 me-lg-0" href="#">
            <i class="fas fa-fill-drip"></i>
          </a>
        </li>
        <!-- Icon -->
        <li class="nav-item me-3 me-lg-0">
          <a class="nav-link" href="#">
            <i class="fab fa-github"></i>
          </a>
        </li>

        

        <!-- Avatar -->
        <li class="nav-item dropdown">
          <a
             class="nav-link dropdown-toggle hidden-arrow d-flex align-items-center"
             href="#"
             id="navbarDropdownMenuLink"
             role="button"
             data-mdb-toggle="dropdown"
             aria-expanded="false"
             >
            <img
                 src="https://mdbootstrap.com/img/Photos/Avatars/img (31).jpg"
                 class="rounded-circle"
                 height="22"
                 alt=""
                 loading="lazy"
                 />
          </a>
          <ul
              class="dropdown-menu dropdown-menu-end"
              aria-labelledby="navbarDropdownMenuLink"
              >
            <li><a class="dropdown-item" href="#">My profile</a></li>
            <li><a class="dropdown-item" href="#">Settings</a></li>
            <li><a class="dropdown-item" href="home-page">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
    <!-- Container wrapper -->
  </nav>
  <!-- Navbar -->