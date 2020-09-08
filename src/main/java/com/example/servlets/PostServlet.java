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
import java.time.LocalDateTime;

@WebServlet(value = "/post")
public class PostServlet extends HttpServlet {

    PostService postService;

    @Override
    public void init() {
        postService = ServiceFactoryImpl.getInstance().getPostService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        if (email == null) {
            resp.sendRedirect("/index.jsp");
        } else {
            Post post = new Post(email,
                    req.getParameter("title"),
                    req.getParameter("tag"),
                    req.getParameter("description"),
                    LocalDateTime.now());
            if (postService.savePost(post)) {
                resp.sendRedirect("/Home.jsp");
            } else {
                req.setAttribute("errorMsg", "Something went wrong!");
                req.getRequestDispatcher("/AddPost.jsp").forward(req, resp);
            }
        }
    }
}
