
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Users</title>
    </head>
    <body>
        <table border="2px" align="center">
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
                <c:forEach var="user" items="${UsersData}">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.username}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="AccountMgmt.jsp">Go to Account</a>
    </body>
</html>
