<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<title>Show Language</title>
</head>
<body>
<div class="text-center">
	<a href="/languages" class="btn btn-link">Dashboard</a>
</div>
<p><c:out value= "${language.name}"/></p>
<p><c:out value= "${language.creator}"/></p>
<p><c:out value= "${language.version}"/></p>

<a href= "/languages/<c:out value = "${language.id}/edit"/>" class = "btn btn-link">Edit</a>

<form style="display:inline" class= "mt-0 pt-0" action="/languages/${language.id}" method="POST">
				    <input type="hidden" name="_method" value="delete">
				    <input class="btn btn-link" role="link"  type="submit" value="Delete">
				</form>


	
</body>
</html>