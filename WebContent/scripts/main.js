document.addEventListener('DOMContentLoaded', function() {
	var name = document.getElementsByClassName('name')[0];
	var nameInput = name.getElementsByTagName('input')[0];

	name.getElementsByTagName('button')[0].addEventListener('click', function() {
		var req = new XMLHttpRequest();
		req.addEventListener('load', function(e) {
			var data = JSON.parse(this.responseText);
			if (data.newName && data.newName.length > 0) {
				name.getElementsByTagName('span')[0].textContent = data.newName;
				nameInput.value = '';
			}
		});
		req.open('POST', '/Comp303FinalProject/ChangeFirstName?name='
				+ nameInput.value);
		req.send();
	});
});
