import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintGroupAdm {

    public static void begin(Connection connection) throws SQLException {

        ArrayList<Group> groups = Group.loadAllGroups(connection);
        for (Group group : groups) {
            System.out.println("id: " + group.getId() + " name:  " + group.getName());
        }

        System.out.println();
        System.out.println("Wybierz jedną z opcji:");
        System.out.println("add - dodanie grupy");
        System.out.println("edit - edycja grupy");
        System.out.println("delete - usunięcie grupy");
        System.out.println("quit - zakończenie programu");
    }

    public static Group groupAdd(Connection connection, Scanner scanner) {

        String title;

        System.out.println("podaj nazwę:");
        title = scanner.nextLine().toString();


        return new Group(title);
    }

    public static Group groupEdit(Connection connection, Scanner scanner) throws SQLException {

        String name;
        int id;

        System.out.println("podaj id:");
        id = Integer.valueOf(scanner.nextLine());

        Group group = Group.loadGroupById(connection, id);

        System.out.println("podaj nazwę:");
        name = scanner.nextLine();


        group.setName(name);

        return group;
    }
    public static Group groupDelete(Connection connection, Scanner scanner) throws SQLException {

        int id;
        System.out.println("podaj id:");
        id = scanner.nextInt();

        return Group.loadGroupById(connection, id);

    }

}
