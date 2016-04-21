document.addEventListener('DOMContentLoaded', function() {
	// name change
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
		req.open('POST', '/Comp303FinalProject/ChangeName?name='
				+ nameInput.value);
		req.send();
	});

	// order cancellation
	var buttons = document.querySelectorAll('button.cancel');

	for(var i = 0; i<buttons.length; i++){
		buttons[i].addEventListener('click', function(e){
			var req = new XMLHttpRequest();
			var uid = this.dataset.id;
			console.log(this);
			req.addEventListener('load', function(e) {
				var data = JSON.parse(this.responseText);
				if (!data.error) {
						// var order = document.querySelector('p[orderDate="' + 'orderDate]"');
						var order = document.querySelector('p[data-id="' + uid + '"]');
						order.parentElement.removeChild(order);
				}
			});
			req.open('POST', '/Comp303FinalProject/CancelOrder?uid='
					+ uid);
			req.send();
		});
	}


});
