package com.example.servlets;

import com.example.beans.User;
import com.example.exceptions.*;
import com.example.services.ServiceFactoryImpl;
import com.example.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {

    UserService userService;

    @Override
    public void init() {
        try {
            userService = ServiceFactoryImpl.getInstance().getUserService();
        } catch (SomethingWentWrong somethingWentWrong) {
            somethingWentWrong.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("userName") != null) {
            resp.sendRedirect("/home?page=1");
        } else {
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");
            String button = req.getParameter("button");

            if (button.equals("Sign In")) {
                try {
                    userService.getUser(new User(userName, "", password));
                    session.setAttribute("userName", userName);
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
                        userService.createUser(new User(userName, email, password));
                        session.setAttribute("userName", userName);
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
