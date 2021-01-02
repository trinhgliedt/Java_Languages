<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!-- <style>
 * {outline: 1px solid yellow};
</style> -->


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form:form class="form-horizontal col" action="/languages/${language.id }" method="POST" modelAttribute="language" >
  <input type="hidden" name="_method" value="put">
  <div class="form-group row">
    <label class="control-label col-sm-2 text-right" for="name">Name:</label>
    <div class="col-sm-4">
      <form:input path="name" type="text" class="form-control" id="name" />
      <form:errors path="name" class="col-2 text-danger"/>
    </div>
  </div>
  <div class="form-group row">
    <label class="control-label col-sm-2 text-right" for="creator">Creator:</label>
    <div class="col-sm-4">
      <form:input path="creator" type="text" class="form-control" id="creator" />
      <form:errors path="creator" class="col-2 text-danger"/>
    </div>
  </div>
  <div class="form-group row">
    <label class="control-label col-sm-2 text-right" for="version">Version:</label>
    <div class="col-sm-4">
      <form:input path="version" type="text" class="form-control" id="version" />
      <form:errors path="version" class="col-2 text-danger"/>
    </div>
  </div>
  <div class="form-group">
    <div class="row">
      <form:button type="submit" class="btn btn-default btn-info offset-5">Submit</form:button>
    </div>
  </div>
</form:form>
</body>
</html>