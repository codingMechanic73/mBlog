package com.example.servlets;

import com.example.beans.Post;
import com.example.beans.User;
import com.example.exceptions.*;
import com.example.services.PostService;
import com.example.services.ServiceFactoryImpl;
import com.example.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {

    UserService userService;
    PostService postService;

    @Override
    public void init() {

        try {
            userService = ServiceFactoryImpl.getInstance().getUserService();
            postService = ServiceFactoryImpl.getInstance().getPostService();
        } catch (SomethingWentWrong somethingWentWrong) {
            somethingWentWrong.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("userName") != null) {
            resp.sendRedirect("/home");
        } else {
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");
            String button = req.getParameter("button");

            if (button.equals("Sign In")) {
                List<Post> posts = postService.getAllPost();
                req.setAttribute("posts", posts);
                try {
                    User user = userService.getUser(new User(userName, "", password));
                    session.setAttribute("user", user);
                    resp.sendRedirect("/home");
                } catch (UserDoesntExist userDoesntExist) {
                    req.setAttribute("errorMsg", "User Doesn't Exist!");
                    req.getRequestDispatcher("/LandingPage.jsp").forward(req, resp);
                } catch (InvalidCredentials invalidCredentials) {
                    req.setAttribute("errorMsg", "Invalid credentials!");
                    req.getRequestDispatcher("/LandingPage.jsp").forward(req, resp);
                }

            } else if (button.equals("Sign Up")) {
                String email = req.getParameter("email");
                String repeatPassword = req.getParameter("passwordrepeat");
                if (password.equals(repeatPassword)) {
                    try {
                        User user = new User(userName, email, password);
                        userService.createUser(user);
                        session.setAttribute("user", user);
                        resp.sendRedirect("/home");
                    } catch (EmailExists | UserNameExists | SomethingWentWrong e) {
                        req.setAttribute("errorMsg", e.getMessage());
                        req.getRequestDispatcher("/SignUp.jsp").forward(req, resp);
                    }
                } else {
                    req.setAttribute("errorMsg", "Passwords do not match");
                    req.getRequestDispatcher("/SignUp.jsp").forward(req, resp);
                }
            }
        }
    }
}
