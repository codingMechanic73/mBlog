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
    <jsp:include page="Nav.jsp"/>
    <div class="container" style="margin-top: 50px">
        <div class="row justify-content-center">
            <div class="col-10 col-sm-8 col-md-6 col-lg-5 .col-xl-4">
                <form action="/post" method="POST">
                    <div class="form-group">
                        <label for="exampleFormControlInput1">Title</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Title">
                    </div>

                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Description</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="6"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlInput1">Tags</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1"
                            placeholder="java, cloud technology">
                    </div>

                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Post" />
                </form>
            </div>
        </div>
    </div>
</body>
</html>