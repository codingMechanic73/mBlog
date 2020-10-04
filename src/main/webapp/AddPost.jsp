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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Post</title>
</head>
<body>
    <jsp:include page="Nav.jsp"/>

    <div class="container" style="margin-top: 20px">
        <div class="row justify-content-center">
            <div class="col-10 col-sm-8 col-md-6 col-lg-5 .col-xl-4">
                <form action="/post" method="POST">
                    <div class="form-group">
                        <label for="exampleFormControlInput1">Title</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Title" name="title" maxlength="50" minlength="5">
                    </div>

                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Description</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="4" name="description" maxlength="1000" minlength="15"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlInput1">Tags</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1"
                            placeholder="java" name="tag" maxlength = "20" >
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlInput2">Image Url</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2"
                            placeholder="https://wallpapercave.com/wp/SHkdY7B.jpg" name="imgUrl" maxlength = "200" >
                             <div class="alert alert-warning" role="alert" style="margin-top: 25px;">
                               Only admin is allowed to post pictures
                            </div>
                    </div>

                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Post" />
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

<% } %>