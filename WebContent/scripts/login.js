document.addEventListener('DOMContentLoaded', function() {
var errorMsg = document.querySelector('.error');

	// login
	document.querySelector('button').addEventListener('click', function(e){
		e.preventDefault();

		var req = new XMLHttpRequest();
		var username = document.querySelector('input[name="username"]');
		var password = document.querySelector('input[name="password"]');
		req.addEventListener('load', function(e) {
			var data = JSON.parse(this.responseText);
			if (!data.error) {
				window.location.replace(data.redirect);
					errorMsg.setAttribute("hidden", true);
			}
			else{
				errorMsg.classList.add('show');
			}
		});
		req.open('POST', '/Comp303FinalProject/Login?username=' + username.value + '&password=' + password.value);
		req.send();
	});
});
