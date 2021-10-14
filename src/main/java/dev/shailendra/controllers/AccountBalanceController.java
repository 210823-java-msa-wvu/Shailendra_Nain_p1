package dev.shailendra.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.shailendra.models.AccountBalance;
import dev.shailendra.repositories.AccountBalanceRepo;
import dev.shailendra.repositories.hibernate.AccountBalanceHibernate;
import dev.shailendra.services.AccountBalanceServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AccountBalanceController implements FrontController{
    AccountBalance ab = new AccountBalance();
    AccountBalanceServices abs = new AccountBalanceServices();
    ObjectMapper om = new ObjectMapper();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        HttpSession session = request.getSession();
//        String email = (String) session.getAttribute("email");
//        if(email != null){
            String path = (String) request.getAttribute("path");
            System.out.println("Path attirbute: " + path);
            if(path == null || path.equals("")){
                switch (request.getMethod()){
                    case "GET": {
                        System.out.println("Getting all accounts from database...");
                        List<AccountBalance> accountBalanceList = abs.getAllAccounts();
                        response.getWriter().write(om.writeValueAsString(accountBalanceList));
                        break;
                    }
                    case "POST": {
                        AccountBalance ab = om.readValue(request.getReader(), AccountBalance.class);
                        System.out.println("Creating a new account");
                        response.getWriter().write(om.writeValueAsString(ab));
                        break;
                    }
                }
            }else {
                int accountid = Integer.parseInt(path);

                switch (request.getMethod()){

                    case "GET" : {
                        AccountBalance ab = abs.searchAccountById(accountid);
                        if(ab !=null){
                            response.getWriter().write(om.writeValueAsString(ab));
                        }else{
                            response.sendError(404, "Account Not Found");
                        }
                        break;
                    }
                    case "PUT": {
                        AccountBalance ab = om.readValue(request.getReader(), AccountBalance.class);
                            abs.updateApplication(ab);
                            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                            break;
                    }
                    case "DELETE": {
                        abs.searchAccountById(accountid);
                        response.setStatus(204);
                        break;
                    }
                    default: {
                        response.sendError(405);
                        break;
                    }
                }
            }
//        }

    }
}
