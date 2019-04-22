<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>

<h1>All Employee</h1>


<table>

<tr>

<th>Employee Id</th>
<th>Employee Age</th>
<th>Employee Name</th>
<th>Employee Email</th>
<th>Employee Number</th>
<th>Employee City</th>
<th>Edit</th>
</tr>


<c:forEach var="employee" items="${employeeList}">
<tr>
<td>${employee.id}</td>
<td>${employee.empage}</td>
<td>${employee.empname}</td>
<td>${employee.empmail}</td>
<td>${employee.empnumber}</td>
<td>${employee.empcity}</td>
<td>
<button id="deleteButton">Delete</button>
<button id="updateButton">Update</button>
</td>
</tr>
</c:forEach>


</table>


</body>

</html>