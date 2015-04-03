document.addEventListener('DOMContentLoaded', function (arg){
	
	// CLOSE FORM BUTTON
	var closeBtn = document.getElementById('close_button');

	// ADD HAZE BUTTON, FIELD, AND FORM
	var addAgencyBtn = document.getElementById('add_agency_btn');
	var addAgencyField = document.getElementById('add_agency_field');
	var addAgencyForm = document.getElementById('add_agency_form');
	
	
	// ADD HAZE EVENT HANDLER
	
	addAgencyBtn.onclick = function (arg){
		addAgencyField.style.display = 'block';
	};
	
	addAgencyField.onclick = function (arg){
		this.style.display = 'none';
	};

	// CLOSE BTN EVENT HANDLER
	closeBtn.onclick = function (arg){
		addAgencyField.style.display = 'none';
	};

	addAgencyForm.onclick = function (arg){
		arg.stopPropagation();
	};

	
});