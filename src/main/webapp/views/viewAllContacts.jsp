<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script>
	function notifyWhenDelete(){
		return confirm("Are you sure, you want to delete?");
	}
</script>
<title>sandeep</title>
</head>
<body>
	<!-- 	<h2>coming soon</h2> -->
	<font color='red'>${delMsg}</font>
	<h2>All contacts</h2>
	<a href="/">+ Add New Contact</a>

	<table border="1" bordercolor='black'>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Number</th>
			<th>Actions</th>
		</tr>

		<c:forEach items="${allContacts}" var="eachContact">
			<tr>
				<td>${eachContact.cname}</td>
				<td>${eachContact.cemail}</td>
				<td>${eachContact.cnumber}</td>
				<td>
					<a href="editContact?cid=${eachContact.cid }">Edit</a> 
					<a href="deleteContact?contactid=${eachContact.cid}" onclick="return notifyWhenDelete()" >Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>