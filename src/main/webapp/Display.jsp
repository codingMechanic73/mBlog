<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.beans.User" %>

<%
    /*If user tries to click on browser back button then he/ she should not be able to access this page*/
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

   User user = (User)session.getAttribute("user");
   if (user == null) {
       response.sendRedirect("/");
   } else {
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>mBlog</title>
</head>

<body>
    <jsp:include page="/Nav.jsp"/>
    <jsp:include page="/View.jsp"/>
</body>
</html>

<%}%>