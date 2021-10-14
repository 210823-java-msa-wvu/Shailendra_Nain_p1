package dev.shailendra.services;

import dev.shailendra.models.AccountBalance;
import dev.shailendra.models.Application;
import dev.shailendra.models.User;
import dev.shailendra.repositories.AccountBalanceRepo;
import dev.shailendra.repositories.UserRepo;
import dev.shailendra.repositories.hibernate.AccountBalanceHibernate;
import dev.shailendra.repositories.hibernate.UserHibernate;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class AccountBalanceServices {
    private ApplicationServices as = new ApplicationServices();
    private AccountBalanceRepo balanceRepo = new AccountBalanceHibernate();
    private UserRepo ur = new UserHibernate();
    public AccountBalance createAccount(AccountBalance a){
            return balanceRepo.add(a);
    }

    public AccountBalance searchAccountById(Integer id) {
        if(id != null || id.equals(balanceRepo.getById(id))){
            return balanceRepo.getById(id);
        }
        return null;
    }

    public List<AccountBalance> getAllAccounts() {
        return balanceRepo.getAll();
    }

    public void updateApplication(AccountBalance ab) {

        balanceRepo.update(ab);
    }

    public void deleteAccount(Integer id) {

        balanceRepo.delete(id);
    }



}
