package dev.shailendra.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.shailendra.models.Application;
import dev.shailendra.services.ApplicationServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ApplicationController implements FrontController {
    ObjectMapper om = new ObjectMapper();
    ApplicationServices applicationServices = new ApplicationServices();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        HttpSession session = request.getSession();
//        String email = (String) session.getAttribute("email");
//        if(email != null){
            String path = (String) request.getAttribute("path");
            System.out.println("Path attribute: " + path);

            if (path == null || path.equals("")) {


                switch (request.getMethod()) {

                    case "GET": {
                        // maybe this is a l=place where you want to check a user's permission/role
                        System.out.println("Getting all applications...");

                        List<Application> a = applicationServices.getAllApplications();
                        response.getWriter().write(om.writeValueAsString(a));
                        break;
                    }

                    case "POST": {
                        System.out.println("Creating new application...");
                        Application a = om.readValue(request.getReader(), Application.class);
                        // or Author a = om.readValue(request.getInputStream(), Author.class);

//                    a.setId((authorService.createAuthor(a)).getId());
                        a = applicationServices.createApplication(a);
                        //response.setStatus(201); // Resource created
                        response.getWriter().write(om.writeValueAsString(a));
                        break;
                    }

                }


            } else {

                int applicationId = Integer.parseInt(path);

                switch (request.getMethod()) {

                    case "GET": {
                        Application a = applicationServices.searchApplicationById(applicationId);
                        if (a != null) {
                            response.getWriter().write(om.writeValueAsString(a));
                        } else {
                            response.sendError(404, "Application not found");
                        }
                        break;
                    }

                    case "PUT": {
                        Application a = om.readValue(request.getReader(), Application.class);
                        applicationServices.updateApplication(a);
                        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                        // 204 - server doesn't have any content to send back, but the request was successful
                        break;
                    }

                    case "DELETE": {
                        applicationServices.deleteApplication(applicationId);
                        response.setStatus(204);
                        break;
                    }

                    default: {
                        response.sendError(405);
                        break;
                    }
                }
            }
//        }else{
//            session.invalidate();
//            response.sendRedirect("static/index.html");
//        }
    }
}
