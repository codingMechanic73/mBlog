package com.example.servlets;

import com.example.beans.User;
import com.example.exceptions.SomethingWentWrong;
import com.example.services.PostService;
import com.example.services.ServiceFactoryImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(value = "/delete")
public class DeletePostServlet extends HttpServlet {

    PostService postService;

    public void init() {
        try {
            postService = ServiceFactoryImpl.getInstance().getPostService();
        } catch (SomethingWentWrong e) {
            e.printStackTrace();
        }
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");


        if (user == null) {
            resp.sendRedirect("/");
        } else {
            String url = req.getParameter("url");
            int postId = Integer.parseInt(req.getParameter("postId"));
            try {
                postService.deletePost(postId, user.getUserName());
            } catch (SomethingWentWrong e) {
                e.printStackTrace();
            }

            switch (url) {
                case "home":
                    resp.sendRedirect("/home");
                    break;
                case "myPost":
                    resp.sendRedirect("/myPost");
            }
        }
    }
}
