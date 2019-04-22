<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>

<title>Employee Details</title>


<spring:url value="/resources/core/css/employee.css" var="employeeCss" />
<link href="${employeeCss}" rel="stylesheet" />

</head>

<spring:url value="/employee/add" var="addEmployee" />

<spring:url value="/employee/getAllEmployee" var="allEmployee" />

<nav id="nav_bar">

<div id="container">

<div id="add_employee">

<h1>	<a class="navbar-brand" href="${addEmployee}">Add New Employee</a>

</h1>
</div>

<div id="all_employee">

<h1>	<a class="navbar-brand" href="${allEmployee}">All Details</a>

</h1>
</div>




</div>


</nav>