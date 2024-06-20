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
					<form action="updateuserfeedbacks" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insertuserfeedbacks" method="post" enctype="multipart/form-data">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User Feedback Details
            		</c:if>
						<c:if test="${user == null}">
            			Add New User Feedback Details
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>


				<fieldset class="form-group">
					<label> Customer Name</label> <input type="text"
						value="<c:out value='${user.customername}' />" class="form-control"
						name="customername" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="customeremail"  required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Subject</label> <input type="text"
						value="<c:out value='${user.subject}' />" class="form-control"
						name="subject" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Message</label> <input type="text"
						value="<c:out value='${user.message}' />" class="form-control"
						name="message" required="required">
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