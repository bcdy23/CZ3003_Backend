document.addEventListener('DOMContentLoaded', function (arg){
	
	// CLOSE FORM BUTTON
	var closeBtn = document.getElementById('close_button');

	// ADD INCIDENT CATEGORIES BUTTON, FIELD, AND FORM
	var addIncidentCategoriesBtn = document.getElementById('add_incident_categories_btn');
	var addIncidentCategoriesField = document.getElementById('add_incident_categories_field');
	var addIncidentCategoriesForm = document.getElementById('add_incident_categories_form');

	
	
	// ADD INCIDENT CATEGORIES EVENT HANDLER
	addIncidentCategoriesBtn.onclick = function (arg){
		addIncidentCategoriesField.style.display = 'block';
	};
	
	addIncidentCategoriesField.onclick = function (arg){
		this.style.display = 'none';
	};

	// CLOSE BTN EVENT HANDLER
	closeBtn.onclick = function (arg){
		addIncidentCategoriesField.style.display = 'none';
	};

	addIncidentCategoriesForm.onclick = function (arg){
		arg.stopPropagation();
	};	
	
});