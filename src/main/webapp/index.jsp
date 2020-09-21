<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.example.services.ServiceFactoryImpl, com.example.services.PostService, com.example.beans.Post" %>

<%!
    PostService postService = null;
    public void jspInit( ) {
    try {
        postService = ServiceFactoryImpl.getInstance().getPostService();
        }catch(Exception e){}
    }
%>

<%
    /*If user tries to click on browser back button then he/ she should not be able to access this page*/
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

   String userName = (String)session.getAttribute("userName");
   if (userName != null) {
       response.sendRedirect("/Home.jsp");
   }
%>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Home</title>
</head>

<body>
    <jsp:include page="/NavLogin.jsp"/>

    <div class="container">

                <%
                    List<Post> posts = postService.getAllPost();
                    if (posts == null || posts.size() == 0) {
                %>
                    <div class="alert alert-dark" role="alert" style="text-align:center; align:center">
                        No posts exist!!!
                    </div>
                <%
                } else {
                %>
                <div class="card-columns">
                <%
                    for (Post post: posts) {
                %>


                  <div class="card">
                    <img src="https://wallpapercave.com/wp/SHkdY7B.jpg" class="card-img-top" alt="...">
                    <div class="card-body">


                      <h5 class="card-title"><%=post.getTitle()%></h5>
                      <p class="card-text"><%=post.getDescription()%></p>
                    </div>




                     <div class="card-footer">
                                                      <small class="text-muted"><%=post.getTimestamp()%></small>


                     </div>
                  </div>
           <% }
            }
            %>

            </div>
        </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
</body>

</html>