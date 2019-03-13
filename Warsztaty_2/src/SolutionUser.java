import java.sql.SQLException;
import java.util.Scanner;

public class SolutionUser {
    public static void main(String[] args) throws SQLException {

        DBConnection connection = null;
        int user_id;
        String command = "";
        Scanner scanner = new Scanner(System.in);

        if (args.length != 0) {
            user_id = Integer.valueOf(args[0]);
        } else {
            System.out.println("podaj ID:");
            user_id = Integer.valueOf(scanner.nextLine());
        }

        try {
            connection = new DBConnection("programming_school", "root", "coderslab");
            PrintSolutionUser.begin(connection.getConnection());

            command = scanner.nextLine();

            while (!command.equals("quit")) {
                switch (command) {
                    case "add":
                        Solution solutionAdd = PrintSolutionUser.solutionAdd(connection.getConnection(), scanner, user_id);
                        solutionAdd.saveToDB(connection.getConnection());
                        command = "";
                        break;

                    case "view":
                        PrintSolutionUser.solutionView(connection.getConnection(), scanner, user_id);
                        command = "";
                        break;

                    case "quit":

                        command = scanner.nextLine();
                        break;

                    default:
                        PrintSolutionUser.begin(connection.getConnection());
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
