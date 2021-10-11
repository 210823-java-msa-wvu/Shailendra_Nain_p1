import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import dev.shailendra.models.User;
import dev.shailendra.repositories.UserRepo;
import dev.shailendra.repositories.hibernate.UserHibernate;
import dev.shailendra.services.UserServices;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Driver {
    private static UserRepo ur = new UserHibernate();
    private static UserServices us = new UserServices();
   // private static Employee e = new Employee();
    public static void main(String[] args){

        User u1 = ur.getByEmail("lucky@gmail.com");
        System.out.println(u1);
        System.out.println(ur.getAll());
        String dateString = "19590709";
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date);





    }
}
