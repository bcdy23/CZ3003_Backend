document.addEventListener('DOMContentLoaded', function (arg){
	
	// CLOSE FORM BUTTON
	var closeBtn = document.getElementById('close_button');

	// ADD HAZE BUTTON, FIELD, AND FORM
	var addHazeBtn = document.getElementById('add_haze_btn');
	var addHazeField = document.getElementById('add_haze_field');
	var addHazeForm = document.getElementById('add_haze_form');
	
	
	// ADD HAZE EVENT HANDLER
	
	addHazeBtn.onclick = function (arg){
		addHazeField.style.display = 'block';
	};
	
	addHazeField.onclick = function (arg){
		this.style.display = 'none';
	};

	// CLOSE BTN EVENT HANDLER
	closeBtn.onclick = function (arg){
		addHazeField.style.display = 'none';
	};

	addHazeForm.onclick = function (arg){
		arg.stopPropagation();
	};

	
});