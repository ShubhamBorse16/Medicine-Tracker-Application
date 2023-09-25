<%@page import="connectdb.*" %> 
<%@page import="medicinetrackerapplication.User" %> 
<%@page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Medico</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<style type="text/css">
table {
  border-collapse: collapse;
  border: 2px solid lightgreen; /* 10px border with light green color */
}

/* Optional: Additional styling for table cells */
td, th {
  padding: 8px;
  border: 1px solid lightgreen;
}
</style>
</head>
	
<body>
<!-- header -->
	<div class="agileits_header">
		<div class="w3l_offers" style="width: 1500px;">
			<a href="products.html">Medico</a>
		</div>
		
	<div class="w3l_search">
			
		</div>
	
	</div>
<!-- script-for sticky-nav -->
	<script>
	$(document).ready(function() {
		 var navoffeset=$(".agileits_header").offset().top;
		 $(window).scroll(function(){
			var scrollpos=$(window).scrollTop(); 
			if(scrollpos >=navoffeset){
				$(".agileits_header").addClass("fixed");
			}else{
				$(".agileits_header").removeClass("fixed");
			}
		 });
		 
	});
	</script>
<!-- //script-for sticky-nav -->
	<div class="logo_products">
		<div class="container">
			<div class="w3ls_logo_products_left">
				<h1><a href="index.html"><span></span>Medico</a></h1>
			</div>
			
			<div class="w3ls_logo_products_left1">
				
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- banner -->

<!-- banner -->

	
<!-- //top-brands -->
<!-- fresh-vegetables -->

<!-- //fresh-vegetables -->
<!-- newsletter -->

		<div class="container">
			
			<div class="w3l_banner_nav_left" style="margin-left: -100px;">
			<nav class="navbar nav_bottom">
			 <!-- Brand and toggle get grouped for better mobile display -->
			  <div class="navbar-header nav_2">
				  <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
			   </div> 
			   <!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav nav_1">
						<li><a href="addmedicine.jsp">Add Medicine</a></li>
												<li class="dropdown mega-dropdown active">
							<a href="medicalpannel.html" >Return to Medical Pannel<span class=""></span></a>				
								
						</li>
					<li class="dropdown">
							<a href="index.html">Logout<span class=></span></a>
							
						</li>
					<!--	<li><a href="index.html">Logout</a></li>
						<li class="dropdown">
							<a href="offers.html" >Offers<span class=></span></a>
							
						</li>
						<li><a href="aboutus.html">About Us</a></li>
						<li><a href="contactus.html">Contact Us</a></li>
						<li><a href="governmentupdates.html">Government Updates</a></li>
	-------->
					</ul>
				 </div><!-- /.navbar-collapse -->
			</nav>
		</div>
			<div class="w3l_banner_nav_right">
<!-- login -->
		<div class="w3_login" style="margin-top: -200px;">
			<h3>All Orders</h3>
		<table style="margin-top: 20px;">
					<thead>
					
					<tr>
						<td width="150px"> Order Id </td>
						<td width="150px"> User Name </td>
						<td width="150px"> Medicine Name </td>
						<td width="150px"> Medical Name </td>
						<td width="150px"> Price</td>
						<td width="150px">Status</td>
						<td width="150px">Address</td>
						
					</tr>
						
					</thead>
				
				<%
					Connection con = ConnectDB.connect();
				try{
					String medname=User.getName();
				PreparedStatement ps1 = con.prepareStatement("select * from order_tbl where mname=?");
				ps1.setString(1,medname);
				ResultSet rs = ps1.executeQuery();
				while(rs.next())
				{
				%>
				<tr>
				<td><%=rs.getString("oid")%></td>
				<td> <%=rs.getString("uname")%></td>
				<td> <%=rs.getString("medname")%></td>
				<td> <%=rs.getString("mname")%></td>
				<td> <%=rs.getString("price")%></td>
				<td> <%=rs.getString("quantity")%></td>
				<td> <%=rs.getString("status")%></td>
				<td> <%=rs.getString("address")%></td>
				
			   
				</tr>
			<%
				}
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
				%>
				</tbody>
				</table>
			<script>
				$('.toggle').click(function(){
				  // Switches the Icon
				  $(this).children('i').toggleClass('fa-pencil');
				  // Switches the forms  
				  $('.form').animate({
					height: "toggle",
					'padding-top': 'toggle',
					'padding-bottom': 'toggle',
					opacity: "toggle"
				  }, "slow");
				});
			</script>
		</div>
<!-- //login -->
		</div>
			<div class="clearfix"> </div>
		</div>
	
<!-- //newsletter -->
<!-- footer -->

<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
});
</script>
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
<script src="js/minicart.js"></script>
<script>
		paypal.minicart.render();

		paypal.minicart.cart.on('checkout', function (evt) {
			var items = this.items(),
				len = items.length,
				total = 0,
				i;

			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}

			if (total < 3) {
				alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
				evt.preventDefault();
			}
		});

	</script>
</body>
</html>