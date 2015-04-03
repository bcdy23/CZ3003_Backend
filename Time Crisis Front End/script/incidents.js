document.addEventListener('DOMContentLoaded', function (arg){
	
	// CLOSE FORM BUTTON
	var closeBtn = document.getElementById('close_button');

	// ADD INCIDENT BUTTON, FIELD, AND FORM
	var addIncidentBtn = document.getElementById('add_incident_btn');
	var addIncidentField = document.getElementById('add_incident_field');
	var addIncidentForm = document.getElementById('add_incident_form');
	

	// ADD INCIDENT EVENT HANDLER
	
	addIncidentBtn.onclick = function (arg){
		addIncidentField.style.display = 'block';
	};
	
	addIncidentField.onclick = function (arg){
		this.style.display = 'none';
	};

	// CLOSE BTN EVENT HANDLER
	closeBtn.onclick = function (arg){
		addIncidentField.style.display = 'none';
	};

	addIncidentForm.onclick = function (arg){
		arg.stopPropagation();
	};

	
});