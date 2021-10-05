package dev.shailendra.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.shailendra.models.User;
import dev.shailendra.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserController implements FrontController{
    private UserServices us = new UserServices();
    ObjectMapper om = new ObjectMapper();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if(session != null && session.getAttribute("email") != null){
            String email = (String) session.getAttribute("email");
            System.out.println( us.getUser(email));
            response.getWriter().write(om.writeValueAsString(us.getUser(email)));
        }else {
            assert false;
            session.invalidate();
            response.sendRedirect("static/index.html");
        }
    }
}
