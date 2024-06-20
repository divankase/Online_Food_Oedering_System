<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="home/css/style.css">
</head>
<body>
<%@include file="header.jsp" %>
		<div class="container" style="margin-left: 20%; padding-top:5%">
			<h3 class="text-center">Employee Details</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newemployeemanagement" class="btn btn-secondary">Add Employee Details</a>
			</div>
			
				<div class="container text-right">

				<a href="<%=request.getContextPath()%>/employeemanagementpdf" class="btn btn-secondary">Generate Report</a>
			</div>
			<br>
			<table id="dtBasicExample" class="table table-striped table-bordered table-sm">
				<thead>
					<tr>
					
						<th>Employee Name</th>
						<th>Employee Phone</th>				
						<th>Job Role</th>
						<th>Email</th>
						<th>Employee Photo</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${listemployeemanegemnt}">
						<tr>
						<td><c:out value="${user.employeename}" /></td>	
							<td><c:out value="${user.employeephone}" /></td>
							<td><c:out value="${user.jobrole}" /></td>
							<td><c:out value="${user.email}" /></td>
								<td><img src="<c:out value="${user.path}" />"   width="200" height="200"/></td>

							<td><a href="editemployeemanagement?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteemployeemanagement?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta3/js/bootstrap.bundle.min.js" integrity="sha512-DSdiuNZtfUhehZHXtit9Sa/83i06YSnvT8Js8drwdkVCDMk3JwpIxdhf2oRUByUDB3wguN2iAzoTNfxFAuqGyA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.24/datatables.min.js"></script>
<script src="/js/index.js"></script>
<script>
    $(document).ready(function () {
        $("table").DataTable({
            order: [0, 'desc']
        });
    });
</script>
</body>
</html>