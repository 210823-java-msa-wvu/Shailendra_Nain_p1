package dev.shailendra.controllers;

import dev.shailendra.models.AccountBalance;
import dev.shailendra.repositories.AccountBalanceRepo;
import dev.shailendra.repositories.hibernate.AccountBalanceHibernate;
import dev.shailendra.services.AccountBalanceServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccountBalanceController implements FrontController{
    AccountBalance ab = new AccountBalance();
    AccountBalanceServices abs = new AccountBalanceServices();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");


    }
}
