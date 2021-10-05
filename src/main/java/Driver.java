import dev.shailendra.models.User;
import dev.shailendra.repositories.UserRepo;
import dev.shailendra.repositories.hibernate.UserHibernate;
import dev.shailendra.services.UserServices;

public class Driver {
    private static UserRepo ur = new UserHibernate();
    private static UserServices us = new UserServices();
   // private static Employee e = new Employee();
    public static void main(String[] args){

        User u1 = ur.getByEmail("lucky@gmail.com");
        System.out.println(u1);
        System.out.println(ur.getAll());


    }
}
