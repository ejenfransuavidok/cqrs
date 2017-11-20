<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>


function callAdd(elem) {
	cart.push(elem);
	document.getElementById(elem.id + "Rem").style.visibility = "visible";
	document.getElementById(elem.id + "Add").style.visibility = "hidden";
	cartList(cart);
};

function callRemove(id) {
	for (var i = cart.length; i--;) {
		if (cart[i].id == id) {
			cart.splice(i, 1);
			document.getElementById(id + "Add").style.visibility = "visible";
			document.getElementById(id + "Rem").style.visibility = "hidden";
			cartList(cart);
		}
	}
};

function cartList(mycart){
	var itemList = "";
	for (i=0;i<mycart.length;i++)
		itemList+='<li><h2>'+mycart[i].name+'</h2><p>'+mycart[i].price+'<p></li>';
	
	document.getElementById('cartList').innerHTML=itemList;
	
}

var cart = [];
$(document).ready(function() {

  var plantsData = "/cqrs/resources/json/data.json";
  console.log("plantsData " + plantsData);
  var result = '';
  
  $.getJSON( "/cqrs/resources/json/data.json", function(data  ) {
	     $.each( data.results, function( i, item ) {
	   		  //iterate through the json object
	   		  //how do I reference the json "page" item? (#value.page doesn't work nor does #page)
	   				  
	   			result +='<div data-role="collapsible" data-collapsed="false">';
	 			result +=' <h4><img src="'+item.image+'" width="40" height="40">'+item.name+':      price '+item.price+'</h4>';
	 			
				result +='<div class="ui-grid-a">';	  				  
	   				  
				// image
				result +='<div class="ui-block-a">';
				result +='<img id="image-2" alt=""	src="'+item.image+'"';
				result +='	width="400" height="400" />';
				result +='</div>';
				// end image
				
				//
	   		 	result +=' <div class="ui-grid-a">';
	   		 	
	   		 	result +='<div class="ui-block-a">';
				result +='<p align="left">'+item.description+'</p>';
				result +='<h4> price: '+item.price+'</h4>';
				result +='<p></p>';
				result +='</div>';
				

				result +='<div class="ui-block-b">';
				result +='<p></p>';
				result +='<h4> availability: '+item.availability+'</h4>';

				result +='<p></p>';				
				result +='<h4> Select quantity</h4>';
				result +='<select name="number" id="number">';
				for (i=1;i<=item.availability;i++)
					result +=' <option>'+i+'</option>';
				result +='</select>';
				
// 				result +='</div>';
				
				result +='</div>';
				
				result +='</div>';
				
				// buttons 
	   		 	result +='<div class="ui-grid-a">';
	   			result +='<div class="ui-block-a" id="'+item.id+'Add">';
	   			result +='	<input type="submit" value="add to cart"';
	   			result +="		onclick='callAdd("+JSON.stringify(item)+")'>";
	   			result +='</div>';

	   			result +='<div class="ui-block-b"  id="'+item.id+'Rem" style="visibility:hidden">';
	   			result +='	<input type="submit" value="remove from cart"';
	   			result +='		onclick="callRemove('+item.id+')">';
	   		 	result +='</div>';

	   		 	result +='</div>';
	   			// end buttons
	   		    
	   		 	result +='</div>'; // end div class="ui-grid-a

	   		 	result +='</div>'; // end div data-role="collapsible
	   		    
	   		});
		    console.log("2 result: " + result);
	     $('#collapsible-set-1').append(result); 
	     $('#collapsible-set-1').trigger("create");
      });
  
  
});
</script>

</head>
<body>
	<div data-role="tabs" id="tabs-1">
		<div data-role="navbar">

			<ul>
				<li><a href="#tab-1a" data-ajax="false">Choose Item</a></li>
				<li><a href="#tab-1b" data-ajax="false">My Cart</a></li>

				<li><a href="#tab-1c" data-ajax="false">Payment and
						Delivery</a></li>
				<li><a href="#tab-1d" data-ajax="false">Confirm</a></li>
			</ul>
		</div>
		<div id="tab-1a" class="ui-body-d ui-content">

			<ul data-role="listview" id="listview-1">

				<div data-role="collapsible-set" id="collapsible-set-1"></div>
			</ul>

		</div>

		<div id="tab-1b" class="ui-body-d ui-content">
			<div data-role="collapsible" data-collapsed="false">
				<ul data-role="listview" id="cartList">
					<li>Canary</li>
					<li>Cat</li>
					<li></li>
				</ul>
			</div>
		</div>


	<div id="tab-1c" class="ui-body-d ui-content">TAB C</div>

	<div id="tab-1d" class="ui-body-d ui-content">TAB D</div>

	</div>
</body>


    
</html>