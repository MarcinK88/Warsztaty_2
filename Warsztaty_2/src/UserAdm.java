import java.sql.SQLException;
import java.util.Scanner;

public class UserAdm {
    public static void main(String[] args) throws SQLException {
        DBConnection connection = null;
        Scanner scanner = new Scanner(System.in);
        String command = "";

        try {
            connection = new DBConnection("programming_school", "root", "coderslab");

            PrintUserAdm.begin(connection.getConnection());

            command = scanner.nextLine();

            while(!command.equals("quit")) {
                switch (command) {
                    case "add":
                        System.out.println("wpisano add");
                        User userAdd = PrintUserAdm.userAdd(connection.getConnection(), scanner);
                        userAdd.saveToDB(connection.getConnection());
                        command = scanner.nextLine();
                        break;

                    case "edit":
                        System.out.println("wpisano edit");
                        User userEdit = PrintUserAdm.userEdit(connection.getConnection(),scanner);
                        userEdit.saveToDB(connection.getConnection());
                        command = scanner.nextLine();
                        break;

                    case "delete":
                        System.out.println("wpisano delete");
                        command = scanner.nextLine();
                        break;

                    case "quit":
                        System.out.println("wpisano quit");
                        command = scanner.nextLine();
                        break;

                    default:
                        PrintUserAdm.begin(connection.getConnection());
                        command = scanner.nextLine();

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeConnection();
        }
    }
}
