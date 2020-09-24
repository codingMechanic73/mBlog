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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/postUtil")
public class PostUtil extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        if (userName == null) {
            resp.sendRedirect("/LandingPage.jsp");
        } else {
            String button = req.getParameter("button");
            if (button.equals("search")) {
                List<Post> posts = new ArrayList<>();
                String query = req.getParameter("query");
                if (query != null && query.startsWith("#")) {
                    posts = postService.getPostByTag(query.substring(1));
                } else if (query != null && query.startsWith("@")) {
                    posts = postService.getPostByUserName(query.substring(1));
                }
                req.setAttribute("posts", posts);
                req.getRequestDispatcher("Search.jsp").forward(req, resp);
            }
        }
    }
}
