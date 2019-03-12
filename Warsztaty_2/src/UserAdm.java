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

            switch (command) {
                case "add":
                    System.out.println("wpisano add");
                    break;

                case "edit":
                    System.out.println("wpisano edit");
                    break;

                case "delete":
                    System.out.println("wpisano delete");
                    break;

                case "quit":
                    System.out.println("wpisano quit");
                    break;

                    default:
                        System.out.println("wpisano niepoprawne polecenie");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeConnection();
        }
    }
}
