

var deleteForms = document.getElementsByClassName("deletepost");

for(var i = 0; i < deleteForms.length; i++) {
	
	deleteForms[i].onsubmit = function() {
		if (confirm("Are you sure you want to delete?") == true) {
			return true;
		} else {
			return false;
		}
	}
		
}
		
