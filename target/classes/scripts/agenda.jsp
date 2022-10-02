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
		  
		  /* const dateFromPicker = "2022-03-20";
		  const timeFromPicker = "12:30";

		  const dateParts = dateFromPicker.split("-");
		  const timeParts = timeFromPicker.split(":");
		  const localDate = new Date(Date.parse(dateParts[0], dateParts[1]-1, dateParts[2], timeParts[0], timeParts[1]));
		  /*localDate.setMinutes(localDate.getMinutes() + localDate.getTimezoneOffset());
		  let dateStr = localDate.toDateString();*/
		  
		/* console.log("localDate : "+localDate.toISOString());  */
		
		
		  var evts = []; // variable for events
		//this is the part  where i tested to create a json format
		for (var i in reserveDates) {			
		    evts.push({
		        title: '\n'+evenements[i].innerText,
		        start: new Date([reserveDates[i].textContent, startTimes[i].textContent]),
		        end: new Date([reserveDates[i].textContent, endTimes[i].textContent]),
		        		        
		    });
		    //console.log("local : "+new Date([reserveDates[i].textContent+startTimes[i].textContent]));
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
		  //eventTimeFormat: { hour: "numeric", minute: "2-digit", timeZoneName: "short" },
		    eventTimeFormat: { // like '14:30'
		        hour: 'numeric',
		        minute: '2-digit',		        
		        hour12: false
		      }, 
		   // displayEventTime: false,  
			     displayEventEnd: true,
			   
		    events: evts,	    	
		    
		  });
		  
		  calendar.render();
		  
		});
</script>