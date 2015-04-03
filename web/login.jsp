<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
        <link href="include/css/bootstrap.min.css" rel="stylesheet">
        <link href="include/css/styles.css" rel="stylesheet">
    </head>
    <body background="include/images/login_background.jpg">
        <jsp:include page="include/header.jsp"></jsp:include>
        <div class="loginform">
            <div class="slogan">Let's Explore the World!</div>
            
            <form name="login" action="LoginServlet" method="POST">
                <div class="input-group input-group-lg">
                    <input type="text" class="form-control" placeholder="Username" name="username">
                </div>
                <div class="errorMsg">${Message}</div>
                <div class="input-group input-group-lg">
                    <input type="password" class="form-control" placeholder="Password" name="password">
                </div>
                <input type="submit" class="btn btn-success" id="loginbtn" value="Login">
            </form>
            <span class="reg">
                Not yet a member? 
                <a href="newAccount.jsp" id="reglink">Join us</a>
                right now!
            </span>
        </div>
    </body>
</html>
