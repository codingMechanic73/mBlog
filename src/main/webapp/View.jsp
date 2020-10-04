<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.example.beans.Post, com.example.beans.User" %>
<div class="container">
<%  String url=(String)request.getAttribute("url");
    String userName = "";
    User user=(User)session.getAttribute("user");
    if (user != null) {userName = user.getUserName();}

    List<Post> posts = (List<Post>) request.getAttribute("posts");
    if (posts == null || posts.size() == 0) {
    %>
    <div class="alert alert-dark" role="alert" style="text-align:center; align:center">
        No posts exist!!!
    </div>
    <%
    } else {
    String currentPageStr = request.getParameter("page");
    int currentPage = 1;
    int totalPages = posts.size() % 9 == 0 ? posts.size() / 9: posts.size()/9 + 1;
    if (currentPageStr != null) {
        currentPage = Integer.parseInt(currentPageStr);
    }
    %>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
        <%
        for (int i  = 1; i <= totalPages; i++) {
        if (currentPage == i) {
        %>
                <li class="page-item active"><% out.print("<a class=\"page-link\" href=\"?page=" + i + request.getAttribute("search")+ "\""); %> ><%=i %></a></li>
        <%} else {
           %>
        <li class="page-item"><% out.print("<a class=\"page-link\" href=\"?page=" + i + request.getAttribute("search")+ "\""); %> ><%=i %></a></li>
        <%}
        }
        %>
      </ul>
    </nav>
    <div class="card-columns">
        <%
            Post post = null;
            for (int i = ((currentPage-1)*9); i < posts.size() && i < currentPage * 9; i++) {
            post = posts.get(i);
        %>
        <div class="card">
            <% if (post.getImgUrl() != null && !post.getImgUrl().equals("")) {
            out.print("<img src=\""+post.getImgUrl()+"\" class=\"card-img-top\" alt=\"...\">");
             }%>

            <div class="card-body">
                <h5 class="card-title"><%=post.getTitle()%></h5>
                <p class="card-text"><%=post.getDescription()%></p>
            </div>
            <div class="card-footer">
                 <i> Post By:
                 <%=post.getUserName()%>
                 </i>
                 <small class="text-muted"><%=post.getTimestamp()%></small>
                  <%if(post.getUserName().equals(userName)){
                      %>

                 <% out.print("<a href=\"delete?url="+url+"&postId="+post.getPostId()+"\">Delete</a>"); %>
                         <%
                      }
                      %>
            </div>

        </div>
        <%
        }
        }

        %>
    </div>
</div>