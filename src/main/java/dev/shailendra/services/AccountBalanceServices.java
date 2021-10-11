package dev.shailendra.services;

import dev.shailendra.models.AccountBalance;
import dev.shailendra.repositories.AccountBalanceRepo;
import dev.shailendra.repositories.hibernate.AccountBalanceHibernate;

public class AccountBalanceServices {
    private AccountBalanceRepo balanceRepo = new AccountBalanceHibernate();
    private AccountBalance ab = new AccountBalance();
    public AccountBalance createAccount(AccountBalance a){
           return balanceRepo.add(a);
    }
}
