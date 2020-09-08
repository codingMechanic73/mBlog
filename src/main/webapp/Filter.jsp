<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    /*If user tries to click on browser back button then he/ she should not be able to access this page*/
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    String email = (String)session.getAttribute("email");
    if (email == null) {
        response.sendRedirect("/index.jsp");
    }
%>

<!DOCTYPE html>

<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In or Sign Up</title>
</head>
<body>
    <jsp:include page="/Nav.jsp"/>

     <div class="container" style="margin-top: 50px;">
        <div class="row justify-content-center">
            <div class="col-10 col-sm-12 col-md-8 col-lg-8 .col-xl-8">
                <form action="/postUtil" method="POST" class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchEmail">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="button" value="search">Search</button>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="/View.jsp"/>

</body>
</html>