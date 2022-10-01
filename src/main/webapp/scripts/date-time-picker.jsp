<script type="text/javascript">
           
             $(function(){
            	 
            	  $('#datepicker').datepicker({
            		  startDate: new Date()
            	  });
            	  /*$("#date").datepicker({ dateFormat: 'yy-mm-dd' });
            	  $("#date").on("change", function(){
            		  var date = $(this).val();
            		  console.log(date);
            	  });*/
            	  $('#datepicker').datepicker('setDate', new Date());          	  
            	  
            	  var firstOpen = true;
                  var time;

                  $('#timePicker1').datetimepicker({
                    useCurrent: false,
                    format: "HH:mm:ss"
                  }).on('dp.show', function() {
                    if(firstOpen) {
                      time = moment().startOf('day');
                      firstOpen = false;
                    } else {
                      time = "01:00:00"
                    }
                    
                    $(this).data('DateTimePicker').date(time);
                  }); 
            	  
                  $('#timePicker2').datetimepicker({
                      useCurrent: false,
                      format: "HH:mm:ss"                      
                    }).on('dp.show', function() {
                      if(firstOpen) {
                        time = moment().startOf('day');
                        firstOpen = false;
                      } else {
                        time = "01:00:00"
                      }
                      
                      $(this).data('DateTimePicker').date(time);
                  }); 
            });  
             function getDiff() {  
            	             	 
            	var date = $('#date').val();
            	var dateForm = moment($("#date").val()).format('YYYY-MM-DD'); 
            	console.log("current date"+date);
            	console.log("new date"+dateForm);       	 
            	var tarif = $("#tarif").val();
	             var from = $("#timeFrom").val();
	             var to = $("#timeTo").val();
	             difference =  ( new Date("1970-1-1 " + to) - new Date("1970-1-1 " + from) ) / 1000 / 60;
	             /*heureTotal = new Date(new Date("1970-1-1 "+to) - new Date("1970-1-1 " + from)).toUTCString().split(" ")[4];*/
	             console.log("tarif"+tarif );
	             var hours = Math.floor(difference/60);
	             var mins = difference%60;
	             console.log(difference+" "+hours+" "+mins);
	             
	             if(mins >= 15)
	     		   	hours++;	        
	     		let calcTarif=tarif;	     
	     		const montant = hours*calcTarif;
	     		
	     		console.log( montant );
	     		
	     		$("#heureTotale").val(hours+"h");
	     		$("#montant").val(montant);
	     		$("#date").val(dateForm);
	     		if ($("#montant").val(montant) != null && $("#montant").val(montant) != ""
					&& $("#montant").val(montant) != "NaN" && $("#nomClient").val().length != 0 && $("#motif").val().length != 0) {
	     			$('#reserve').removeAttr('disabled');
	     			$('#montant').attr('readonly', true);
	     			$('#heureTotale').attr('disabled','disabled');
				}
	     		
             }
</script>