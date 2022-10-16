<style>
*, ::before,::after{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  scroll-behavior: smooth;
}

html, body{
  position: relative;
  width: 100%;
  overflow-x:hidden; 
  
  height: 100vh;
}
img{
  object-fit: cover;
}
.image_logo{
	border-radius: 25px !important;
}
body {
  background-color: #fbfbfb;
}
.navbar_bg_display{
	background: radial-gradient(circle, rgba(0,112,187,1) 0%, rgba(192,229,242,1) 76%);
}
.btn-primary, .btn-info{
    background-color: rgb(0,112,187) !important;
    font-size: 1rem !important;
}  

/* Responsive pour Mobile*/
@media screen and (min-width : 767px) and (max-width : 1025px)
{
	 .container, .container-md, .container-sm {
	    max-width: 100% !important;
	}  
	 .container_display {
    	flex-wrap: nowrap !important;
	} 
	.col-sm-4 {
        width: 50% !important;
	}
} 
@media (min-width: 991.98px) {
  main {
    padding-left: 240px;
  }
}
.table_heading{
	font-size: 1.2rem;
	font-weight: 700 !important;
}
/* AGENDA */
#calendar {
  max-width: 1100px;
  margin: 40px auto;
}
.fc-event-title{
    white-space: normal;
    overflow: visible !important;
    text-overflow: ellipsis;
    max-height:30px;
    max-width: 100%;    
    padding-left: 5px;
    font-weight: bold;
}
.fc-daygrid-dot-event{
    flex-wrap: wrap !important;
    height: 5em;
}
.fc-daygrid-day-events{
	min-height: 5em !important;
	
}
.fc-daygrid-event{
	font-size: 1rem !important;
	color: white !important;
}

.fc-event-start{
	background-color: #CD5700 !important;
	
}

/* Sidebar */
.sidebar {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  padding: 58px 0 0; /* Height of navbar */
  box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
  width: 240px;
  z-index: 600;
}

@media (max-width: 991.98px) {
  .sidebar {
    width: 100%;
  }
}
.sidebar .active {
  border-radius: 5px;
  box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
}

.sidebar-sticky {
  position: relative;
  top: 0;
  height: calc(100vh - 48px);
  padding-top: 0.5rem;
  overflow-x: hidden;
  overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
}
/***************************** Contact.jsp*************************************/
.border-top {
      border-top: 5px solid #33b5e5 !important;
      border-top-left-radius: .25rem!important;
    	border-top-right-radius: .25rem!important;
 }
 
 /**************************** Login Client ***************************************/
 .background-radial-gradient {
      background-color: hsl(218, 41%, 15%);
      background-image: radial-gradient(650px circle at 0% 0%,
          hsl(218, 41%, 35%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%),
        radial-gradient(1250px circle at 100% 100%,
          hsl(218, 41%, 45%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%);
    }

    #radius-shape-1 {
      height: 220px;
      width: 220px;
      top: -60px;
      left: -130px;
      background: radial-gradient(#44006b, #ad1fff);
      overflow: hidden;
    }

    #radius-shape-2 {
      border-radius: 38% 62% 63% 37% / 70% 33% 67% 30%;
      bottom: -60px;
      right: -110px;
      width: 300px;
      height: 300px;
      background: radial-gradient(#44006b, #ad1fff);
      overflow: hidden;
    }

    .bg-glass {
      background-color: hsla(0, 0%, 100%, 0.9) !important;
      backdrop-filter: saturate(200%) blur(25px);
    }
    /**************************** Dashboard Content ******************************/
    .container_display{

	display: flex;
	justify-content: space-evenly;
    align-items: center;
    
	}
	.card-body{
		box-shadow: 5px 5px 15px 5px rgba(0,0,0,0.38);
		/*background: radial-gradient(circle, rgba(240,241,233,1) 51%, rgba(201,225,227,1) 98%);*/
		background: radial-gradient(circle, rgba(240,241,233,1) 51%, rgba(247,250,250,1) 98%);
	}
	.card_display{
		width: 30rem !important;
		padding: 25px;
		
	}
	
	.count_card{
		max-width: 25rem;
		box-shadow: 5px 5px 15px 5px rgba(0,0,0,0.38);
	}
	.card-header{
	 	/*background-image: linear-gradient( 109.6deg,  rgba(22,155,215,1) 11.2%, rgba(34,45,101,1) 99.8% );*/
	 	background-image: linear-gradient( 109.6deg,  rgba(22,155,215,1) 11.2%, rgba(34,45,101,1) 99.8% );
	 	font-size: 1.6rem;
	 	color: white;
	}
</style>