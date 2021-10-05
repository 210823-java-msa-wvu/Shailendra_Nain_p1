package dev.shailendra.services;

import dev.shailendra.models.User;
import dev.shailendra.repositories.UserRepo;
import dev.shailendra.repositories.hibernate.UserHibernate;

import java.util.List;

public class UserServices {
    UserRepo userRepo = new UserHibernate();
    public boolean login(String email, String password) {
        // in order to log in a user, we will need username and password
        // that information is stored in our database
        // the repository layer needs to take care of this
        User u = userRepo.getByEmail(email); // more of the Sole Responsibility Principle at work
        // check to make sure User object is not null
        if (u != null) {
            // now check to make sure it matches
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
