document.addEventListener('DOMContentLoaded', function (arg){
	
	// CLOSE FORM BUTTON
	var closeBtn = document.getElementById('close_button');

	// ADD DENGUE BUTTON, FIELD, AND FORM
	var addDengueBtn = document.getElementById('add_dengue_btn');
	var addDengueField = document.getElementById('add_dengue_field');
	var addDengueForm = document.getElementById('add_dengue_form');
	

	// ADD DENGUE EVENT HANDLER
	
	addDengueBtn.onclick = function (arg){
		addDengueField.style.display = 'block';
	};
	
	addDengueField.onclick = function (arg){
		this.style.display = 'none';
	};

	// CLOSE BTN EVENT HANDLER
	closeBtn.onclick = function (arg){
		addDengueField.style.display = 'none';
	};

	addDengueForm.onclick = function (arg){
		arg.stopPropagation();
	};

	
});