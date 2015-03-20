document.addEventListener('DOMContentLoaded', function (arg){
	
	// CLOSE FORM BUTTON
	var closeBtn = document.getElementById('close_button');

	// ADD HAZE BUTTON, FIELD, AND FORM
	var addStaffAccountsBtn = document.getElementById('add_staff_accounts_btn');
	var addStaffAccountsField = document.getElementById('add_staff_accounts_field');
	var addStaffAccountsForm = document.getElementById('add_staff_accounts_form');
	
	
	// ADD HAZE EVENT HANDLER
	
	addStaffAccountsBtn.onclick = function (arg){
		addStaffAccountsField.style.display = 'block';
	};
	
	addStaffAccountsField.onclick = function (arg){
		this.style.display = 'none';
	};

	// CLOSE BTN EVENT HANDLER
	closeBtn.onclick = function (arg){
		addStaffAccountsField.style.display = 'none';
	};

	addStaffAccountsForm.onclick = function (arg){
		arg.stopPropagation();
	};

	
});