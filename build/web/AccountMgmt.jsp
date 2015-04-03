
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Management</title>
        <link href="include/css/bootstrap.min.css" rel="stylesheet">
        <link href="include/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="include/header.jsp"></jsp:include>
        <div class="container">
            <div class="username">
                <h3>Hello, ${username}</h3>
            </div>
            
            <div class="row">
                <div class="col-md-4">
                    <p><a class="btn btn-primary btn-lg" href="newBlog.jsp" role="button">Write New Blog</a></p>
                </div>
                <div class="col-md-4">
                    <p><a class="btn btn-primary btn-lg" href="manageBlog" role="button">Manage All Blogs</a></p>
                </div>
                <div class="col-md-4">
                    <p><a class="btn btn-primary btn-lg" href="editInfo.jsp" role="button">Edit Personal Info</a></p>
                </div>
            </div>

        </div>

    </body>
</html>
