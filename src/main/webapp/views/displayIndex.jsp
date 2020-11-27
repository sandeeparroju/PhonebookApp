<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <title>jjj</title> -->
</head>
<body>
<!-- 	<h1>Welcome Phonebookapp</h1> -->
	
	<%-- <h2>${sccMsg}</h2> --%>
	<p><font color='green'>${sccMsg}</font></p>
	<p><font color='red'>${errMsg}</font></p>

	<form:form action="saveContact" method="POST" modelAttribute="contactpojo">
		<table>
			<tr>
				<td>Name::</td>
				<td><form:input path="cname" /></td>
				
				<form:hidden path="cid"/>
			</tr>
			<tr>
				<td>Email::</td>
				<td><form:input path="cemail" /></td>
			</tr>
			<tr>
				<td>Number::</td>
				<td><form:input path="cnumber" /></td>
			</tr>			
			<tr>
				<!-- <td><input type="submit" value="Save Contact" /></td> -->
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	
	<a href="viewAll">ViewAllContacts</a>
</body>
</html>