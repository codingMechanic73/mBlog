package com.example.servlets;

import com.example.beans.Post;
import com.example.exceptions.SomethingWentWrong;
import com.example.services.PostService;
import com.example.services.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet(value = "/post")
public class PostServlet extends HttpServlet {

    PostService postService;

    @Override
    public void init() {

        try {
            postService = ServiceFactoryImpl.getInstance().getPostService();
        } catch (SomethingWentWrong somethingWentWrong) {
            somethingWentWrong.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        if (userName == null) {
            resp.sendRedirect("/LandingPage.jsp");
        } else {
            Post post = new Post(
                    1,
                    null,
                    userName,
                    req.getParameter("title"),
                    req.getParameter("tag"),
                    req.getParameter("description"),
                    LocalDateTime.now());
            if (postService.savePost(post)) {
                req.setAttribute("posts", postService.getAllPost());
                resp.sendRedirect("/myPost");
            } else {
                req.setAttribute("errorMsg", "Something went wrong!");
                req.getRequestDispatcher("/AddPost.jsp").forward(req, resp);
            }
        }
    }
}
