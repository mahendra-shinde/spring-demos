<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Library : Add new book</title>
</head>
<body>

<h3>Create new Book</h3>
<s:form action="add-book.htm" method="post" modelAttribute="book">
	title of book : <s:input path="title" /><br/>
	Author name: <s:input path="author" /><br/>
	Category: <s:input path="category" /><br/>
	<input type="submit" value="save"/>
</s:form>

</body>
</html>