
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thank you!</title>
    </head>

    <body>
        <h3>Thank you for Joining us!</h3>
        <p>Here is the information that you entered!</p>
        <jsp:useBean id="user" scope="session" class="ExciteWorld.main.bean.UserAccount"/>
        <table border="1">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email Address</th>
                    <th>Username</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><jsp:getProperty name="user" property="firstname"/></td>
                    <td><jsp:getProperty name="user" property="lastname"/></td>
                    <td><jsp:getProperty name="user" property="email"/></td>
                    <td><jsp:getProperty name="user" property="username"/></td>
                </tr>
            </tbody>
        </table>
    <a href="AccountMgmt.jsp">My Account</a>
    <a href="index.jsp">Home</a>
    <a href="DisplayUser">Display all users</a>
</body>
</html>
