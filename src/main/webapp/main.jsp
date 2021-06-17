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
    <c:if test="${updateUser != null}">
        <form method="post" action="/SimpleServlet-1.0-SNAPSHOT/">
            <div> Name:
                <input type="text" name="name" value="${updateUser.name}"/>
                <error>
                    <c:if test="${validator != null}">
                        ${validator.nameError}
                    </c:if>
                </error>
            </div>
            <div> Surname:
                <input type="text" name="surname" value="${updateUser.surname}"/>
                <error>
                    <c:if test="${validator != null}">
                        ${validator.surnameError}
                    </c:if>
                </error>
            </div>
            <div> Age:
                <input type="number" name="age" value="${updateUser.age}"/>
                <error><c:if test="${validator != null}">${validator.ageError}</c:if></error>
            </div>
            <div> Email:
                <input type="text" name="email" value="${updateUser.email}"/>
                <error><c:if test="${validator != null}">${validator.emailError}</c:if></error>
            </div>
            <input type="hidden" name="id" value="${updateUser.id}"/>
            <div>
                <button type="submit" name="action" value="add">update</button>
            </div>
        </form>
    </c:if>

    <c:if test="${updateUser == null}">
        <form method="post" action="/SimpleServlet-1.0-SNAPSHOT/">
            <input type="hidden" name="id" value="-1"/>
            <div> Name:
                <input type="text" name="name" placeholder="Please enter name"/>
            </div>
            <div> Surname:
                <input type="text" name="surname" placeholder="Please enter surname"/>
            </div>
            <div> Age:
                <input type="number" name="age" placeholder="Please enter your age"/>
            </div>
            <div> Email:
                <input type="email" name="email" placeholder="example@email.com"/>
            </div>
            <div>
                <button type="submit" name="action" value="add">add</button>
            </div>
        </form>
    </c:if>
</tr>

<c:forEach var="user" items="${users}">
    <p>

    <form method="post" action="/SimpleServlet-1.0-SNAPSHOT/">
        <c:out value="${user.id}"/>
        <c:out value="${user.name}"/>
        <c:out value="${user.surname}"/>
        <c:out value="${user.age}"/>
        <c:out value="${user.email}"/>
        <input type="hidden" name="userId" value="${user.id}"/>
        <button type="submit" name="action" value="update">edit</button>
        <button type="submit" name="action" value="delete">X</button>
    </form>
    </p>

</c:forEach>

</body>
<style>
    error {
        color: red;
    }
</style>
</html>
