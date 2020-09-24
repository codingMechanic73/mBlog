<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    /*If user tries to click on browser back button then he/ she should not be able to access this page*/
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    String userName = (String)session.getAttribute("userName");
    if (userName != null) {
        response.sendRedirect("/home");
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

    <jsp:include page="/NavLogin.jsp"/>

    <div class="container" >
        <div class="row justify-content-center">
            <div class="col-10 col-sm-8 col-md-6 col-lg-4 .col-xl-4">
                <form action="/user" method="POST">
                    <div class="form-group">
                        <label for="userName">User Name</label>
                        <input type="text" class="form-control" name="userName" placeholder="UserName" minlength="6" maxlength="30" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <input type="email" class="form-control" name="email" placeholder="email" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="password" placeholder="**********" required minlength="8" maxlength="15">
                    </div> <div class="form-group">
                        <label for="passwordrepeat">Repeat Password</label>
                        <input type="passwordrepeat" class="form-control" name="passwordrepeat" placeholder="**********" required minlength="8" maxlength="15">
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary btn-lg btn-block" name="button" value="Sign Up" />
                        </div>
                    </div>
                </form>
                <%
                    String errorMsg = (String) request.getAttribute("errorMsg");
                    if (errorMsg != null) {
                %>
                <div class="alert alert-warning" role="alert" style="margin-top: 25px;">
                    <%=errorMsg %>
                </div>
                <%
                }
                %>
            </div>
        </div>
    </div>

</body>

</html>