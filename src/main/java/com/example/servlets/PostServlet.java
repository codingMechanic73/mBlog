package com.example.servlets;

import com.example.beans.Post;
import com.example.beans.User;
import com.example.exceptions.SomethingWentWrong;
import com.example.services.PostService;
import com.example.services.ServiceFactoryImpl;
import com.example.util.DateTimeFormatter;

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

        try {
            postService = ServiceFactoryImpl.getInstance().getPostService();
        } catch (SomethingWentWrong somethingWentWrong) {
            somethingWentWrong.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/");
        } else {
            String imgUrl = req.getParameter("imgUrl");
            if (!user.getUserType().equals("admin")) {
                imgUrl = "";
            }
            Integer count = (Integer) getServletContext().getAttribute("maxId");
            Post post = new Post(
                    count,
                    imgUrl,
                    user.getUserName(),
                    req.getParameter("title"),
                    req.getParameter("tag"),
                    req.getParameter("description"),
                    DateTimeFormatter.format(LocalDateTime.now()));
            if (postService.savePost(post)) {
                getServletContext().setAttribute("maxId", count + 1);
                resp.sendRedirect("/myPost");
            } else {
                req.setAttribute("errorMsg", "Something went wrong!");
                req.getRequestDispatcher("/AddPost.jsp").forward(req, resp);
            }
        }
    }
}
