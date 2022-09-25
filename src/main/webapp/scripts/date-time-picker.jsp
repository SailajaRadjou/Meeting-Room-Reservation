<script type="text/javascript">
           
             $(function(){
            	 
            	  $('#datepicker').datepicker({
            		  startDate: new Date()
            	  });
            	  $('#datepicker').datepicker({ dateFormat: 'yyyy/mm/dd' });
            	  $('#datepicker').datepicker('setDate', new Date());
            	  
            	  var firstOpen = true;
                  var time;

                  $('#timePicker1').datetimepicker({
                    useCurrent: false,
                    format: "hh:mm A"
                  }).on('dp.show', function() {
                    if(firstOpen) {
                      time = moment().startOf('day');
                      firstOpen = false;
                    } else {
                      time = "01:00 PM"
                    }
                    
                    $(this).data('DateTimePicker').date(time);
                  }); 
            	  
                  $('#timePicker2').datetimepicker({
                      useCurrent: false,
                      format: "hh:mm A"
                    }).on('dp.show', function() {
                      if(firstOpen) {
                        time = moment().startOf('day');
                        firstOpen = false;
                      } else {
                        time = "01:00 PM"
                      }
                      
                      $(this).data('DateTimePicker').date(time);
                  }); 
            });             
             
</script>