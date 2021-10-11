package dev.shailendra.services;

import dev.shailendra.models.User;
import dev.shailendra.repositories.UserRepo;
import dev.shailendra.repositories.hibernate.UserHibernate;

import java.util.List;

public class UserServices {
    UserRepo userRepo = new UserHibernate();
    public boolean login(String email, String password) {
        User u = userRepo.getByEmail(email);
        if (u != null) {
           if (email.equals(u.getEmail()) && password.equals(u.getUserPass())) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String data){
        User u = userRepo.getByEmail(data);
        return u;
    }
    public List<User> getAllUsers() {

        return userRepo.getAll();

    }

    public void defaultBalance(){

    }

}
