<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Personal Info</title>
        <link href="include/css/bootstrap.min.css" rel="stylesheet">
        <link href="include/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="include/header.jsp"></jsp:include>
        <div class="container">
            <h4>Please update your information:</h4>
            <form action="UpdateUserInfo" method="POST" name="updateAccount">
                <table class="table">
                    <tr>
                        <td>First Name</td>
                        <td><input name="firstname" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input name="lastname" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td><input name="username" type="text"/></td>
                    </tr>
                </table>
                <input type="submit" class="btn btn-success" id="loginbtn" value="Update">
            </form>
        </div>
    </body>
</html>
