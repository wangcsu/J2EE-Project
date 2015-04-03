<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Write New Blog</title>
        <link href="include/css/bootstrap.min.css" rel="stylesheet">
        <link href="include/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="include/header.jsp"></jsp:include>
        <div class="container">
            <form action="addBlog" method="post" name="newblog">
                <table>
                    <tr>
                        <td>Title</td>
                        <td><input type="text" name="blogtitle"/></td>
                    </tr>
                    <tr>
                        <td>Content</td>
                        <td><textarea name="blogcontent" rows="25" cols="100"></textarea></td>
                    </tr>
                </table>
                <input type="submit" class="btn btn-success" id="post" value="Post">
            </form>
        </div>

    </body>
</html>
