<%@ page import="com.example.beans.Post" %>
<%@ page import="java.util.*, com.example.services.PostService, com.example.services.ServiceFactoryImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" style="margin-top: 50px;">
    <div class="row row-cols-1 row-cols-md-4 ">
    <%
    List<Post> posts = null;
    String from = (String)request.getAttribute("from");
    if (from != null && from.equals("filter")) {
        posts = (List<Post>) request.getAttribute("posts");
    } else {
        posts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Post post = new Post();
            post.setPostId(1);
            post.setPostBy("hi");
            post.setTitle("title");
            post.setTag("tag");
            post.setDescription("This is a description");
            posts.add(post);
        }
    }
    if (posts == null) {
        %>
        <div class="alert alert-warning" role="alert" style="margin-top: 25px;">
            No posts found!
        </div>
        <%
    } else {
            for (Post post: posts) { %>
            <div class="col mb-4">
                <div class="card h-100">
                    <div class="card-body">
                        <h5 class="card-title"><%=post.getTitle() %></h5>
                        <p class="card-text"><%=post.getDescription() %></p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">By: alan</small>
                        <small class="text-muted">10:15:</small>
                    </div>
                </div>
            </div>
           <% }
        }
    %>
    </div>
</div>