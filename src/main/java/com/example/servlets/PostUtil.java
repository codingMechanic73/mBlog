package com.example.servlets;

import com.example.beans.Post;
import com.example.services.PostService;
import com.example.services.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/postUtil")
public class PostUtil extends HttpServlet {

    PostService postService;
    @Override
    public void init() throws ServletException {
        postService = ServiceFactoryImpl.getInstance().getPostService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        if (email == null) {
            resp.sendRedirect("/index.jsp");
        } else {
            String button = (String) "button";
            switch (button) {
                case "button":
                    String searchEmail = (String) req.getAttribute("searchEmail");
                    List<Post> posts = postService.getPostsByEmailId(searchEmail);
                    req.setAttribute("posts", posts);
                    req.setAttribute("from", "filter");
                    req.getRequestDispatcher("/Filter.jsp").forward(req, resp);
                    break;
            }
        }
    }
}
