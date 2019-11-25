<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Home</title>
</head>
<body>
<h2>Book Home Page</h2>

<h3>Search Book By ID</h3>

<form action="find-by-id.htm" method="post">
	Book Id : <input type="text" name="id" required/>
	<input type="submit" value="find"/> 
</form>

<h3>Search Book By Title</h3>
<form action="find-by-title.htm" method="post">
	Book Title : <input type="text" name="title" required/>
	<input type="submit" value="find"/> 
</form>
<br/>

<h3>Create new Book</h3>
<s:form action="add-book.htm" method="post" modelAttribute="book">
	title of book : <s:input path="title" /><br/>
	Author name: <s:input path="author" /><br/>
	Category: <s:input path="category" /><br/>
	<input type="submit" value="save"/>
</s:form>

<div class="dataPanel">

<c:if test="${bookResults != null}">
<h3>Search Results</h3>
<table border="1"  cellspacing="0" cellpadding="5pt">
<thead>
<tr>
<td>Book Id</td>
<td>Title</td>
<td>Author</td>
<td>Category</td>
<td>Availability</td>
<td>Actions</td>
</tr>
</thead>
<tbody>

<c:forEach items="${bookResults}" var="b">
<tr>
<td>${b.id }</td>
<td>${b.title }</td>
<td>${b.author }</td>
<td>${b.category }</td>
<td>${b.status=="A"?'Available':'Not Available'}</td>
<td>
	<a href="#">Edit</a>
	<a href="#">Delete</a>
	<a href="#">Update</a>
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