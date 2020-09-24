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
import java.util.List;

@WebServlet(value = "/myPost")
public class MyPost extends HttpServlet {
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
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        List<Post> posts = postService.getPostByUserName(userName);

        req.setAttribute("posts", posts);
        if (userName == null) {
            resp.sendRedirect("/");
        } else {
            req.setAttribute("search", "");
            req.getRequestDispatcher("/MyPost.jsp").forward(req, resp);
        }
    }
}