package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hiber.model.Car;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Harry", "Braun", "Braun@gmail.ru", new Car("BMW", 325)));
      userService.add(new User("Gans", "Granger", "Granger@mail.ru", new Car("Honda", 5)));
      userService.add(new User("Ron", "Weas", "Weas@yandex.ru", new Car("Porsche", 11)));
      userService.add(new User("Jan", "Lupin", "Lupin@mail.ru", new Car("Lada", 21014)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
         System.out.println("___________________________");

      }
      User getUser1 = userService.getUserByCar("Porsche", 11);
      System.out.println("Car owner " + getUser1.getCar().getModel() + " " + getUser1.getCar().getSeries());
      System.out.println("Id = " + getUser1.getId());
      System.out.println("First Name = " + getUser1.getFirstName());
      System.out.println("Last Name = " + getUser1.getLastName());
      System.out.println("Email = " + getUser1.getEmail());
      System.out.println("______________________________");

      context.close();
   }
}
