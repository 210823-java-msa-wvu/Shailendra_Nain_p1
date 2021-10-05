package dev.shailendra.controllers;



import com.fasterxml.jackson.databind.ObjectMapper;
import dev.shailendra.services.UserServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController implements FrontController {
    private Logger log = LogManager.getLogger(LoginController.class);
    private UserServices us = new UserServices();
    ObjectMapper om = new ObjectMapper();
    HttpSession session = null;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("Username: " + email + " Password: " + password);
        if ((email == null || email.isEmpty()) || (password == null || password.isEmpty())) {
            response.setContentType("text/html");
            response.getWriter().write(om.writeValueAsString("<H1>Invalid Credentials!</H1>"
                    +
                    "<a href='http://localhost:8080/home/static/index.html'>Back to Login Page</a>"));

        } else if (us.login(email, password)) {
            session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("static/application.html");

        }else{
            response.setContentType("text/html");
            response.getWriter().write(om.writeValueAsString("<H1>Invalid Credentials!</H1>" +
                    "<a href='http://localhost:8080/home/static/index.html'>Back to Login Page</a>"));
        }

    }
}

