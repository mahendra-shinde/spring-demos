<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page!</title>
</head>
<body>
<h2>Home Page</h2>

<c:if test="${param.errors != null}">
 <h3>${param.errors }</h3>
</c:if>

<c:if test="${errors != null and not empty errors}">
<div class="errorList">
	<h3>Errors Occurred!</h3>
	<ul>
	<c:forEach items="${errors}" var="e">
	<li>${e}</li>
	</c:forEach>
	</ul>
</div>
</c:if>

<form action=login.htm method=post>
	Username: <input type="text" name="uname" /><br/>
	Password: <input type="password" name="pass" /><br/>
	<input type="hidden" name="destination" value="${target}"/>
	<input type="submit" value="Login"/>
</form>
</body>
</html>