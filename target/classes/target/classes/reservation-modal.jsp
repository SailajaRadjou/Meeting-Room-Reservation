

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary reservation" data-mdb-toggle="modal" data-mdb-target="#exampleModal" data-id="${salle.getSalleId()}">
  Réservez Maintenant
</button>

<!-- Modal -->
<div class="modal top fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-mdb-backdrop="true" data-mdb-keyboard="true">
  <div class="modal-dialog modal-xl ">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
      </div>
      
      
      <form method="post" action="save-reservation">  
      	<div class="modal-body">		    
	      	<div class="row">
	      		<div class="form-group col-md-4">
				<label for="typeText">Tarif horaire</label>
					<div class="input-group">
					  <input type="text" id="salleId" class="form-control" readonly />					  
					</div>
				</div>
	      		<div class="form-group col-md-8">
			      <label for="date">Date de réservation</label>
				     <div class="input-group date" id="datepicker">
				        <input type="text" class="form-control" id="date"/>
				        <span class="input-group-append">
				          <span class="input-group-text bg-light d-block">
				            <i class="fa fa-calendar"></i>
				          </span>
				        </span>
				      </div>
				</div>
			</div>	
			<div class="row">			   
			    <div class="form-group col-md-6">
			      <label for="time">De : </label>
			      <div class="input-group time" id="timePicker1">
			        <input type="text" class="form-control timePicker">
			        <span class="input-group-addon">
			        	<span class="input-group-text bg-light d-block">
			        		<i class="fa fa-clock-o" aria-hidden="true"></i>
			        	</span>
			        </span>	
			      </div>
			    </div>
			    <div class="form-group col-md-6">
			      <label for="time">À : </label>
			      <div class="input-group time" id="timePicker2">
			        <input type="text" class="form-control timePicker">
			        <span class="input-group-addon">
			        	<span class="input-group-text bg-light d-block">
			        		<i class="fa fa-clock-o" aria-hidden="true"></i>
			        	</span>
			        </span>	
			      </div>
			    </div>
			</div> 
			<div class="row">
				<div class="form-group col-md-8">
				<label for="motifText">Motif de réservation</label>
					<div class="input-group">
					  <input type="text" id="motifText" class="form-control" />					  
					</div>
				</div>
			</div>  
			<div class="row">
				<div class="form-group col-md-8">
				<label for="montantText">Montant à payer</label>
					<div class="input-group">
					  <input type="text" id="montantText" class="form-control" />					  
					</div>
				</div>
			</div>
			  
  		
	  		<div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">
	          Close
	        </button>
	        <button type="submit" class="btn btn-primary">Save changes</button>
	      </div>
      	</div>
      </form>
    </div>
  </div>
</div>

