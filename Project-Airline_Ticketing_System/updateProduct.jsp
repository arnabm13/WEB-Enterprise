


<form action="productManager" method="post">
  <div class="container">
    <label><b>Flight ID</b></label>
    <input type="text" placeholder="Flight Id" id="Fid" name="Fid">	
	</br>
    <label><b>Source</b></label>
    <input type="text" placeholder="Source" id="Fsource" name="Fsource" required>
    </br>
	<label><b>Destination</b></label>
    <input type="text" placeholder="Destination" id="Fdestination" name="Fdestination" required>
	</br>
	</br>
	<label><b>Flight Type &ensp; &emsp;</b></label>	
	<select name="Ftype" id="Ftype">
    <option value="Domestic">Domestic</option>
    <option value="International">International</option>
	</select>
    </br>
	</br>
	</br>
	<label><b>Departure &emsp;&emsp;</b></label>
    <input type="Time" placeholder="eg. 01:30 AM " id="Fdep" name="Fdep"required>
	</br>
	</br>
	</br>
	<label><b>Arrival &emsp; &emsp;&emsp; </b></label>
    <input type="Time" placeholder="eg. 01:30 AM" id="Farrival" name="Farrival" required>
	</br>
	</br>
	</br>
	<label><b>Economy-Cost </b></label>
    <input type="number" placeholder=" eg. 120.00" id="FEcost" name="FEcost" required>
    </br>
	</br>
	</br>
	<label><b>Business-Cost</b></label>
    <input type="number" placeholder=" eg. 120.00" id="FBcost" name="FBcost" required>
    </br>
	</br>
	</br>
	<label><b>Total Capacity</b></label>
    <input type="number" placeholder="eg. 150" id="Fcapacity" name="Fcapacity" required>
    </br>
	</br>
	</br>
	
	<input type="hidden"  name="reqtype" value="update_product">
    <button id="submitbtn"type="submit"> Update Flight</button>
	</div>
  </div>
</form>
