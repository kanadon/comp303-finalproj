<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script>
	            $(document)
			.ready(
					function() {
						var username = "";
						$
								.get(
										'ProductServlet',
										{
											user : username
										},
										function(response) {
											console.log(response);
											var data = response;
											//$('#product_div').text(data.items[0].name); 
											console.log(data.items);
											var container = $('<div />');
											var $table = $("<table>").appendTo(
													$("#product_div"));
											for (var i = 0; i < 20; i++) {
												$("<tr>")
														.appendTo($table)
														.append(
																$("<td>")
																		.html(
																				'<img src="' + data.items[i].thumbnailImage + '"/>'))
														.append(
																$("<td>")
																		.html(
																				'<p id="product_Name">'
																						+ data.items[i].name
																						+ '</p>'
																						+ '<p id="product_Price">'
																						+ '$'
																						+ data.items[i].salePrice
																						+ '</p>'))
											}
										});
					});
</script>

<style>
#product_Price{
font-weight:bold;
font-size: 2em;
}

table{
width: 60%;
margin-left: auto;
margin-right: auto;
}

</style>
</head>
<body>
	<form id="form1">
		<h1>Check out our Trending Products</h1>
		<br />
		<br />

		<div id="product_div"></div>
	</form>
</body>
</html>
