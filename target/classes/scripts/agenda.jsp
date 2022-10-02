<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function() {
		  var calendarEl = document.getElementById('calendar');
		  var reserveDates = document.querySelectorAll('.reserve-date');
		  var evenements = document.querySelectorAll('.evenement');
		  var startTimes = document.querySelectorAll('.reserve-time-start');
		  var endTimes = document.querySelectorAll('.reserve-time-end');
		  
		  /*for (let x of times){
			  console.log("Reserve Date : "+ x.textContent);
		  }*/		  
		 	
		  var evts = []; // variable for events
		//this is the part  where i tested to create a json format
		for (var i in reserveDates) {			
		    evts.push({
		        start: new Date([reserveDates[i].textContent, startTimes[i].textContent]),
		        end: new Date([reserveDates[i].textContent, endTimes[i].textContent]),
		        title: "\n"+evenements[i].innerText,
		        allDay: false
		    });
		    
		}
		var calendar = new FullCalendar.Calendar(calendarEl, {
			
		    initialView: 'dayGridMonth',		    
		    initialDate: new Date('2022-03-01'),		     
		    themeSystem: "bootstrap",
		    headerToolbar: {
		      left: 'prev,next today',
		      center: 'title',
		      right: 'dayGridMonth,timeGridWeek,timeGridDay'
		    },		    
		    timeZone: 'local',
		    eventColor: '#6264A7',
		    eventTextColor: '#fff',
		    eventTimeFormat: { // like '14:30'
		        hour: 'numeric',
		        minute: '2-digit',		        
		        hour12: false
		      }, 
		   // displayEventTime: false,  
			displayEventEnd: true,
			editable: true,
	        eventLimit: false, // allow "more" link when too many events    
		    events: evts,	    	
		    
		  });
		  
		  calendar.render();
		  
		});
</script>