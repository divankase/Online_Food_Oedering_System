<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<body>

	<%@include file="header.jsp"%>
	<div class="container" style="margin-left: 20%; padding-top: 5%"
		>
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="updaterestaurantdetails" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insertretaurantdetails" method="post" enctype="multipart/form-data">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Restaurant Details
            		</c:if>
						<c:if test="${user == null}">
            			Add New Restaurant Details
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Restaurant Name</label> <input type="text"
						value="<c:out value='${user.restaurantname}' />" class="form-control"
						name="restaurantname" required="required">
				</fieldset>

				
				<fieldset class="form-group">
				    <label>Restaurant Contact</label>
				    <input type="text" value="<c:out value='${user.phone}' />" class="form-control"
				           name="phone" required="required" oninput="validatePhoneNumber(this)">
				    <div id="phoneError" style="color: red;"></div>
				</fieldset>
				
				<script>
					function validatePhoneNumber(input) {
    // Regular expression to match a valid phone number (adjust this as needed)
    var phoneNumberPattern = /^[0-9]{10}$/;

    var phoneError = document.getElementById("phoneError");

    if (phoneNumberPattern.test(input.value)) {
        // Phone number is valid, clear any error message
        phoneError.textContent = "";
    } else {
        // Phone number is not valid, display an error message
        phoneError.textContent = "Invalid phone number format. Please enter a 10-digit number.";
    }
}
</script>
			<fieldset class="form-group">
    <label> Location</label>
    <input type="text" value="<c:out value='${user.location}' />" class="form-control"
           name="location" required="required" onblur="validateLocation(this)">
    <div id="locationError" style="color: red;"></div>
</fieldset>
			
			<script>
function validateLocation(input) {
    var locationError = document.getElementById("locationError");
    var locationValue = input.value.trim();  // Remove leading/trailing spaces

    // Check if the location ends with "Sri Lanka"
    if (locationValue.endsWith("Sri Lanka")) {
        // Location is valid, clear any error message
        locationError.textContent = "";
    } else {
        // Location is not valid, display an error message
        locationError.textContent = "Location must end with 'Sri Lanka'.";
    }
}
</script>
			
				
				
				
				
				
				<fieldset class="form-group">
					<label> Working Days</label> <br><select id = "div" name = "workingdays">
<option value="Week Day">Week Day</option>
<option value="Week End">Week End</option>
<option value="All Days">All Days</option>
</select>						
				</fieldset>
				

				<fieldset class="form-group">
					<label>Menu Details</label> <input type="file" class="form-control"
						name="file" required="required">
				</fieldset>
				<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-dark">Add Details</button>
				</div>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>