<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>User list</title>

</head>
<body>
<h1>Definitely not important list</h1>

<form method="post" action="/SimpleServlet_war/MainServlet">
    <input type="text" name="name" placeholder="Please enter name">
    <input type="text" name="surname" placeholder="Please enter surname">
    <button type="submit">Add</button>

</form>

</body>
</html>
