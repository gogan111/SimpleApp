<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>User list</title>

</head>
<body>
<h1>Definitely not important list</h1>

<tr>
    <c:if test="${updateUser == null}">
        <form method="post" action="/SimpleServlet-1.0-SNAPSHOT/">
            <td><input type="hidden" name="id" value="-1"/></td>
            <td><input type="text" name="name" placeholder="Please enter name"/></td>
            <td><input type="text" name="surname" placeholder="Please enter surname"/></td>
            <td><input type="number" name="age" placeholder="Please enter your age"/></td>
            <td><input type="hidden" name="id" value="-1"/>
                <button type="submit" name="action" value="add">add</button>
            </td>
        </form>
    </c:if>
    <c:if test="${updateUser != null}">
        <form method="post" action="/SimpleServlet-1.0-SNAPSHOT/">
            <td><input type="text" name="name" value="${updateUser.name}"/></td>
            <td><input type="text" name="surname" value="${updateUser.surname}"/></td>
            <td><input type="number" name="age" value="${updateUser.age}"/></td>
            <td><input type="hidden" name="id" value="${updateUser.id}"/>
                <button type="submit" name="action" value="add">update</button>
            </td>
        </form>
    </c:if>
</tr>

<c:forEach var="user" items="${users}">
    <p>

    <form method="post" action="/SimpleServlet-1.0-SNAPSHOT/">
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.surname}"/></td>
        <td><c:out value="${user.age}"/></td>
        <td><input type="hidden" name="userId" value="${user.id}"/>
            <button type="submit" name="action" value="update">edit</button>
            <button type="submit" name="action" value="delete">X</button>
        </td>
    </form>
    </p>

</c:forEach>

</body>
</html>
