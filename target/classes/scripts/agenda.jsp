<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function() {
		  var calendarEl = document.getElementById('calendar');
		  var reserveDates = document.querySelectorAll('.reserve-date');
		  var evenements = document.querySelectorAll('.evenement');
		  var evenReser = reserveDates[1].textContent;
		  console.log("Reserve Date : "+ evenements[2].innerText);
		  for (let x of evenements){
			  console.log("Reserve Date : "+ x.textContent);
		  }
		  
		  var evts = []; // variable for events
		//this is the part  where i tested to create a json format
		for (var i = 1; i <= reserveDates.length; i++) {
			//evenReser = evenements[i].innerText;
		    evts.push({
		        title: evenements[1].innerText,
		        start: new Date(reserveDates[1].textContent),
		        
		    });
		}
		  
		  var calendar = new FullCalendar.Calendar(calendarEl, {
		    initialView: 'dayGridMonth',
		    initialDate: '2022-03-01',
		    themeSystem: "bootstrap",
		    headerToolbar: {
		      left: 'prev,next today',
		      center: 'title',
		      right: 'dayGridMonth,timeGridWeek,timeGridDay'
		    },
		    
		    events: evts
		    	/*[
		    		  	
		      {
		    	 
		        title: 'All Day Event',
		        
		        start:  new Date(dateReser)
		    	 
		      },
		    		
		       {
		        title: 'Long Event',
		        start: '2022-08-07',
		        end: '2022-08-10'
		      },
		      {
		        
		        title: 'Repeating Event',
		        start: '2022-09-09'
		      },
		      {
		        groupId: '999',
		        title: 'Repeating Event',
		        start: '2022-09-16T16:00:00'
		      },
		      {
		        title: 'Conference',
		        start: '2022-10-11',
		        end: '2022-10-13'
		      },
		      {
		        title: 'Meeting',
		        start: '2022-10-12T10:30:00',
		        end: '2022-10-12T12:30:00'
		      },
		      {
		        title: 'Lunch',
		        start: '2022-04-12T12:00:00'
		      },
		      {
		        title: 'Meeting',
		        start: '2022-04-12T14:30:00'
		      },
		      {
		        title: 'Birthday Party',
		        start: '2022-09-13T07:00:00'
		      },
		      {
		        title: 'Click for Google',
		        url: 'http://google.com/',
		        start: '2022-10-28'
		      } 
		    ]*/
		    
		  });
		  
		  calendar.render();
		  
		});
</script>