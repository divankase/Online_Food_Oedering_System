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
					<form action="updateemployeemanagement" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insertemployeemanagement" method="post" enctype="multipart/form-data">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Employee Details
            		</c:if>
						<c:if test="${user == null}">
            			Add New Employee Details
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value="<c:out value='${user.employeename}' />" class="form-control"
						name="employeename" required="required">
				</fieldset>

				

				<fieldset class="form-group">
					<label>Employee Phone </label> <input type="text" value="<c:out value='${user.employeephone}' />" class="form-control"
				           name="employeephone" required="required" oninput="validatePhoneNumber(this)">
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
					<label> Job Role</label> <br><select id = "div" name = "jobrole">
<option value="Week Day">Manager</option>
<option value="Week End">Admin</option>
<option value="All Days">Delivery Person</option>
</select>						
				</fieldset>
				
				<fieldset class="form-group">
    <label for="email">Email</label>
    <input type="email" 
           value="<c:out value='${user.email}' />" 
           class="form-control" 
           name="email" 
           id="email" 
           required="required">
    <small class="form-text text-muted">Please enter a valid email address.</small>
</fieldset>

<script>
    // Function to validate email address using JavaScript
    function validateEmail() {
        const emailInput = document.getElementById('email');
        const emailValue = emailInput.value;
        const emailPattern = /^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$/;

        if (!emailPattern.test(emailValue)) {
            alert('Please enter a valid email address.');
            emailInput.focus();
            return false;
        }

        return true;
    }

    // Add an event listener to the form to trigger the validation on form submit
    const form = document.querySelector('form'); // Replace 'form' with the actual form element
    form.addEventListener('submit', function (event) {
        if (!validateEmail()) {
            event.preventDefault(); // Prevent form submission if email is invalid
        }
    });
</script>


				<fieldset class="form-group">
					<label>Profile Photo</label> <input type="file" class="form-control"
						name="file" required="required">
				</fieldset>
				<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-dark">Save</button>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>