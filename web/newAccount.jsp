
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link href="include/css/bootstrap.min.css" rel="stylesheet">
        <link href="include/css/styles.css" rel="stylesheet">
    </head>
    <body background="include/images/login_background.jpg">
        <jsp:include page="include/header.jsp"></jsp:include>
            <div class="loginform">
                <div class="slogan">Let's Explore the World!</div>
                <form name="newAccount" action="AddUser" method="POST" id="newacct">
                    <!--<jsp:useBean id="user" scope="session" class="ExciteWorld.main.bean.UserAccount"/>-->
                <div class="input-group input-group-sm">
                    <input type="text" class="form-control" placeholder="First Name" name="firstname">
                </div>
                <div class="input-group input-group-sm">
                    <input type="text" class="form-control" placeholder="Last Name" name="lastname">
                </div>
                <div class="input-group input-group-sm">
                    <input type="text" class="form-control" placeholder="Email Address" name="email">
                </div>
                <div class="input-group input-group-sm">
                    <input type="text" class="form-control" placeholder="Username" name="username">
                </div>
                <div class="input-group input-group-sm">
                    <input type="password" class="form-control" placeholder="Password" name="password">
                </div>
                <div class="input-group input-group-sm">
                    <input type="password" class="form-control" placeholder="Enter Password Again">
                </div>
                <input type="submit" class="btn btn-success" id="newacctbtn" value="Submit">
            </form>
            <span class="pptu">
                We're committed to protecting your privacy and will not rent or sell your e-mail address. 
                By proceeding, you agree to our <a href="#">Privacy Policy</a> and <a href="#">Terms of Use</a>.
            </span>
        </div>
    </body>
</html>
