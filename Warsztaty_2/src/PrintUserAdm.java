
import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.util.ArrayList;

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
}
