function addListeners(){
	var submitBtn = document.getElementById("searchBtn");
	if (submitBtn.addEventListener) { // google/FireFox
		submitBtn.addEventListener('click',validate, false);
	} else if(submitBtn.attachEvent){ //IE or edge
		submitBtn.attachEvent('click',validate);
	}
}
