

<html>
<head>
<title>Admin Panel</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
<style>
html {
	background-image: url('../assets/background.png') !important;
}

thead {
	background: #000000;
	color: white;
}

table.dataTable tbody tr {
	background: #b4c8f7;
	font-weight: 600;
	color: black;
}

.sidebar-container {
	position: fixed;
	width: 220px;
	height: 100%;
	left: 0;
	overflow-x: hidden;
	overflow-y: auto;
	background: #000000;
	color: #fff;
}

.content-container {
	padding-top: 20px;
}

.sidebar-logo {
	padding: 10px 15px 10px 30px;
	font-size: 20px;
	background-color: #4b0082;
}

.sidebar-navigation {
	padding: 0;
	margin: 0;
	list-style-type: none;
	position: relative;
}

.sidebar-navigation li {
	background-color: transparent;
	position: relative;
	display: inline-block;
	width: 100%;
	line-height: 20px;
}

.sidebar-navigation li a {
	padding: 10px 15px 10px 30px;
	display: block;
	color: #fff;
}

.sidebar-navigation li .fa {
	margin-right: 10px;
}

.sidebar-navigation li a:active, .sidebar-navigation li a:hover,
	.sidebar-navigation li a:focus {
	text-decoration: none;
	outline: none;
}

.sidebar-navigation li::before {
	background-color: #4b0082;
	position: absolute;
	content: '';
	height: 100%;
	left: 0;
	top: 0;
	-webkit-transition: width 0.2s ease-in;
	transition: width 0.2s ease-in;
	width: 3px;
	z-index: -1;
}

.sidebar-navigation li:hover::before {
	width: 100%;
}

.sidebar-navigation .header {
	font-size: 12px;
	text-transform: uppercase;
	background-color: #00000;
	padding: 10px 15px 10px 30px;
}

.sidebar-navigation .header::before {
	background-color: transparent;
}

.content-container {
	padding-left: 220px;
}

.sidebar-navigation li a {
	padding: 10px 15px 10px 30px;
	display: block;
	color: #fff;
	line-height: 40px;
	font-size: 18px;
	font-weight: 600;
}
</style>

</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="sidebar-container">
			<div class="sidebar-logo">Online Food Ordering System</div>
			<ul class="sidebar-navigation">
				<li class="header">EAT 24/7</li>
				
				<li><a href="listrestaurantdetails"> <i class="fa fa-tachometer"
						aria-hidden="true"></i>RESTAURANT DETAILS
				</a></li>				
				<li><a href="listpayment"> <i class="fa fa-info-circle"
						aria-hidden="true"></i>PAYMENT
				</a></li>
				<li><a href="listemployeemanagement"> <i class="fa fa-info-circle"
						aria-hidden="true"></i>EMPLOYEEMENT MANAGEMENT
				</a></li>
				<li><a href="listuserfeedbacks"> <i class="fa fa-info-circle"
						aria-hidden="true"></i>USER FEEDBACKS
				</a></li>

				<li><a href="index.html"> <i class="fa fa-info-circle"
						aria-hidden="true"></i>LogOut
				</a></li>
			</ul>
		</div>
	</div>
</body>
</html>

