<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="include/css/bootstrap.min.css" rel="stylesheet">
        <link href="include/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="include/header.jsp"></jsp:include>
            <div class="container">
                <table border="2px" align="center" id="allblog">
                    <tr>
                        <td>Title</td>
                        <td></td>
                    </tr>
                    <c:forEach var="blog" items="${BlogInfo}">
                    <tr>
                        <td>${blog.blog_title}</td>
                        <td><form action="DeleteBlog" method="POST">
                                <input type="hidden" id="thisField" name="blogtitle" value="${blog.blog_title}">
                                <input type="submit" value="Delete">   
                            </form>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
                <a href="AccountMgmt.jsp">Go Back to My Profile</a>
            </div>
    </body>
</html>
