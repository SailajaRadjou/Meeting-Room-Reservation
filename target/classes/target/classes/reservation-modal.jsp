<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-mdb-toggle="modal" data-mdb-target="#exampleModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal top fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-mdb-backdrop="true" data-mdb-keyboard="true">
  <div class="modal-dialog modal-xl ">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
		<form action="">      
	      	<div class="row">
	      		<div class="form-group col-md-6">
			      <label for="date">Date</label>
				     <div class="input-group date" id="datepicker">
				        <input type="text" class="form-control" id="date"/>
				        <span class="input-group-append">
				          <span class="input-group-text bg-light d-block">
				            <i class="fa fa-calendar"></i>
				          </span>
				        </span>
				      </div>
				</div>			   
			    <div class="form-group col-md-6">
			      <label for="time">Time</label>
			      <div class="input-group date" id="timePicker">
			        <input type="text" class="form-control timePicker">
			        <span class="input-group-addon">
			        	<span class="input-group-text bg-light d-block">
			        		<i class="fa fa-clock-o" aria-hidden="true"></i>
			        	</span>
			        </span>	
			      </div>
			    </div>
			</div>   
  		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">
          Close
        </button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
