<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<spring:url value="/employee/add" var="userActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="employeeDetail" action="${userActionUrl}">

<h1>Employee Details</h1>



<div id="container">


<spring:bind path="empname">
	<div id="name_container" class="form-group ${status.error ? 'has-error' : ''}">

		<label id="name_label">Employee Name</label>

		<div id="name_input_div">

			<form:input path="empname" id="name_input" type="text" placeholder="Name" ></form:input>
<form:errors path="empname"></form:errors>
		</div>

	</div>

</spring:bind>



<spring:bind path="empmail">
	<div id="email_container">

		<label id="email_label">Employee Email</label>

		<div id="email_input_div">
			<form:input path="empmail"  id="email_input" placeholder="Personal Email"></form:input>
<form:errors path="empmail"></form:errors>
		</div>

	</div>

</spring:bind>

<spring:bind path="empage">
	<div id="age_container">

		<label id="age_label">Employee Age</label>

		<div id="age_input_div">
			<form:input path="empage" type="number" min="19" max="58" id="age_input" placeholder="Employee Age" maxlength="2"></form:input>
		<form:errors path="empage"></form:errors>
		</div>

	</div>

</spring:bind>
<spring:bind path="empnumber">
	<div id="number_container">

		<label id="number_label">Mobile Number</label>

		<div id="number_input_div">
			<form:input path="empnumber" type="number" id="number_input" placeholder="Mobile no" maxlength="10"></form:input>
		<form:errors path="empnumber"></form:errors>
		</div>

	</div>

</spring:bind>

<spring:bind path="empcity">
	<div id="city_container">

		<label id="city_label">Employee City</label>

		<div id="city_input_div">
			<form:input path="empcity" id="city_input" placeholder="City"></form:input>
		<form:errors path="empcity"></form:errors>
		</div>

	</div>

</spring:bind>

<div id="submit_container">

<button type="submit" id="add_button">Add</button>

</div>



</div>

</form:form>

<spring:url value="/resources/core/js/min_js.js" var="minJs" />
<script src="${minJs}"></script>
<spring:url value="/resources/core/js/employee.js" var="mainJs" />
	 <script src="${mainJs}"></script>
</html>