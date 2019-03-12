import java.sql.SQLException;
import java.util.Scanner;

public class GroupAdm {
    public static void main(String[] args) throws SQLException {
        DBConnection connection = null;
        Scanner scanner = new Scanner(System.in);
        String command = "";

        try {
            connection = new DBConnection("programming_school", "root", "coderslab");

            PrintGroupAdm.begin(connection.getConnection());

            command = scanner.nextLine();

            while(!command.equals("quit")) {
                switch (command) {
                    case "add":
                        Group groupAdd = PrintGroupAdm.groupAdd(connection.getConnection(),scanner);
                        groupAdd.saveToDB(connection.getConnection());
                        command = "";
                        break;

                    case "edit":
                        Group groupEdit = PrintGroupAdm.groupEdit(connection.getConnection(),scanner);
                        groupEdit.saveToDB(connection.getConnection());
                        command = "";
                        break;

                    case "delete":
                        Group groupDelete = PrintGroupAdm.groupDelete(connection.getConnection(),scanner);
                        groupDelete.delete(connection.getConnection());
                        command = scanner.nextLine();
                        break;

                    case "quit":

                        command = scanner.nextLine();
                        break;

                    default:
                        PrintGroupAdm.begin(connection.getConnection());
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
