<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<body>

    <%@include file="header.jsp"%>
    <div class="container" style="margin-left: 20%; padding-top: 5%">
        <div class="card">
            <div class="card-body">
                <c:if test="${user != null}">
                    <form action="updatepayment" method="post">
                </c:if>
                <c:if test="${user == null}">
                    <form action="insertpayment" method="post" enctype="multipart/form-data">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit Payment Details
                        </c:if>
                        <c:if test="${user == null}">
                            Add New Payment Details
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${user != null}">
                    <input type="hidden" name="payment_id" value="<c:out value='${user.payment_id}' />" />
                </c:if>

                <!-- <fieldset class="form-group">
                    <label>Payment Method</label>
                    <input type="text" value="<c:out value='${user.payment_method}' />" class="form-control" name="payment_method" required="required">
                </fieldset>-->
                <fieldset class="form-group">
    <label>Payment Method</label>
    <div>
        <label>
            <input type="radio" name="payment_method" value="Online Payment" <c:if test="${user.payment_method == 'Online Payment'}">checked</c:if> required="required">
            Online Payment
        </label>
        <label>
            <input type="radio" name="payment_method" value="Cash on Delivery" <c:if test="${user.payment_method == 'Cash on Delivery'}">checked</c:if> required="required">
            Cash on Delivery
        </label>
    </div>
</fieldset>
                
                

                <fieldset class="form-group">
    <label>Payment Amount</label>
    <input type="text" value="<c:out value='${user.amount}' />" class="form-control" name="amount" required="required" id="paymentAmount">
</fieldset>

<script>
    // Get the input element
    const paymentAmountInput = document.getElementById("paymentAmount");

    // Add an event listener to the input
    paymentAmountInput.addEventListener("input", function() {
        // Define a regular expression pattern to match numbers with two decimal places
        const pattern = /^\d+(\.\d{2})?$/;
        
        // Check if the entered value matches the pattern
        if (!pattern.test(this.value)) {
            // Display an error message and clear the input
            this.setCustomValidity("Payment amount must be a number with two decimal places.");
        } else {
            // Reset the validation
            this.setCustomValidity("");
        }
    });
</script>
                

                
                <fieldset class="form-group">
    <label>Payment Date</label>
    <input type="date" class="form-control" name="payment_date" required="required" id="paymentDate">
</fieldset>

<script>
    // Get the input element
    const paymentDateInput = document.getElementById("paymentDate");

    // Add an event listener to the input
    paymentDateInput.addEventListener("input", function() {
        // Parse the selected date
        const selectedDate = new Date(this.value);
        
        // Check if the selected year is not 2023
        if (selectedDate.getFullYear() !== 2023) {
            // Display an error message and clear the input
            this.setCustomValidity("Payment date must be in the year 2023.");
        } else {
            // Reset the validation
            this.setCustomValidity("");
        }
    });
</script>
                

                <fieldset class="form-group">
    <label>Card Number</label>
    <input type="text" value="<c:out value='${user.card_number}' />" class="form-control" name="card_number" required="required" onblur="validateCardNumber(this)">
    <div id="cardNumberError" style="color: red;"></div>
</fieldset>

				<script>
function validateCardNumber(input) {
    var cardNumberError = document.getElementById("cardNumberError");
    var cardNumberValue = input.value.replace(/\D/g, ''); // Remove non-digit characters

    // Check if the card number is 16 digits long and contains only digits
    if (/^\d{16}$/.test(cardNumberValue)) {
        // Card number is valid, clear any error message
        cardNumberError.textContent = "";
    } else {
        // Card number is not valid, display an error message
        cardNumberError.textContent = "Please enter a valid 16-digit card number.";
    }
}
</script>
				

                <fieldset class="form-group">
                    <label>Card Holder</label>
                    <input type="text" value="<c:out value='${user.card_holder_name}' />" class="form-control" name="card_holder_name" required="required">
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
