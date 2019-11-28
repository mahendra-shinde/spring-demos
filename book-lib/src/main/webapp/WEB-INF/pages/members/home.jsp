<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Members Home</title>
</head>
<body>
<h2>Member Home Page</h2>

<h3>Search Member By ID</h3>

<form action="find-by-id.htm" method="post">
<!-- Retain the last value entered in text field using EL expression in VALUE attribute -->
	Member Id : <input type="text" name="id" value="${param.id}"  required/>
	<input type="submit" value="find"/> 
</form>

<h3>Search Member By First Name</h3>
<form action="find-by-fname.htm" method="post">
<!-- Retain the last value entered in text field using EL expression in VALUE attribute -->
	First Name: <input type="text" name="fname" value="${param.fname }" required/>
	<input type="submit" value="find"/> 
</form>
<br/>

<h3>Search Member By Last Name</h3>
<form action="find-by-lname.htm" method="post">
<!-- Retain the last value entered in text field using EL expression in VALUE attribute -->
	Last Name: <input type="text" name="lname" value="${param.lname }" required/>
	<input type="submit" value="find"/> 
</form>
<br/>


<div class="dataPanel">

<c:if test="${memberResults != null}">
<h3>Search Results</h3>
<table border="1"  cellspacing="0" cellpadding="5pt">
<thead>
<tr>
<td>Member Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>Availability</td>
<td>Actions</td>
</tr>
</thead>
<tbody>

<c:forEach items="${memberResults}" var="m">
<tr>
<td>${m.id }</td>
<td>${m.firstName }</td>
<td>${m.lastName }</td>
<td>${m.status=="A"?'No pending books':'Book not returned'}</td>
<td>
	<a href="edit.htm?id=${b.id}">Edit</a>
</td>

</tr>
</c:forEach>
</tbody>

</table>
</c:if>

</div>
<div class="notification">
<h4>${msg}</h4>
</div>

</body>
</html>