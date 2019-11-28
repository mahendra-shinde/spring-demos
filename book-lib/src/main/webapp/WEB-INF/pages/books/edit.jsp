<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Library : Edit an Existing Book</title>
</head>
<body>
	<h2>Editing book ${param.id}</h2>
	<s:form action="edit.htm" method="post" modelAttribute="book">
		<s:hidden path="id" />
	title of book : <s:input path="title" />
		<br />
	Author name: <s:input path="author" />
		<br />
	Category: <s:input path="category" />
		<br />
		<input type="submit" value="save" />
	</s:form>

</body>
</html>