
import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintUserAdm {


    public static void begin(Connection connection) throws SQLException {


        ArrayList<User> users = User.loadAllUsers(connection);
        for (User user : users) {
            System.out.println("id: " + user.getId() + " username:  " + user.getUsername() + " email: " + user.getEmail()
                    + " group_id: " + user.getGroup_id());
        }

        System.out.println();
        System.out.println("Wybierz jedną z opcji:");
        System.out.println("add - dodanie użytkownika");
        System.out.println("edit - edycja użytkownika");
        System.out.println("delete - usunięcie użytkownika");
        System.out.println("quit - zakończenie programu");

    }

    public static User userAdd(Connection connection, Scanner scanner) {

        String name;
        String email;
        String password;
        int group_id;

        System.out.println("podaj imię:");
        name = scanner.nextLine();
        System.out.println("podaj email:");
        email = scanner.nextLine();
        System.out.println("podaj hasło:");
        password = scanner.nextLine();
        System.out.println("podaj group_id");
        group_id = scanner.nextInt();

        return new User(name,email,password,group_id);
    }
}
