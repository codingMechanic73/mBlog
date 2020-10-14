package com.example.servlets;

import com.example.beans.Post;
import com.example.beans.User;
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

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
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
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/");
        } else {
            List<Post> posts = postService.getAllPost();
            req.setAttribute("posts", posts);
            req.setAttribute("url", "home");
            req.setAttribute("search", "");
            req.getRequestDispatcher("/Display.jsp").forward(req, resp);
        }
    }
}
