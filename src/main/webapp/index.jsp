<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In or Sign Up</title>
</head>
<%
    String email = (String)session.getAttribute("email");
    if (email != null) {
        response.sendRedirect("/Home.jsp");
    }
%>

<body>

    <div class="container" style="margin-top: 100px;">
        <div class="row justify-content-center">
            <div class="col-10 col-sm-8 col-md-6 col-lg-4 .col-xl-4">
                <form action="/user" method="POST">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" placeholder="email" required>

                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="**********" required>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary btn-lg btn-block" value="Sign In" name="button" />
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