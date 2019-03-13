import java.sql.SQLException;
import java.util.Scanner;

public class SolutionAdm {
    public static void main(String[] args) throws SQLException {
        DBConnection connection = null;
        Scanner scanner = new Scanner(System.in);
        String command = "";

        try {
            connection = new DBConnection("programming_school", "root", "coderslab");
            PrintSolutionAdm.begin(connection.getConnection());

            command = scanner.nextLine();

            while(!command.equals("quit")) {
                switch (command) {
                    case "add":
                        Solution solutionAdd = PrintSolutionAdm.solutionAdd(connection.getConnection(),scanner);
                        solutionAdd.saveToDB(connection.getConnection());
                        command = "";
                        break;

                    case "view":
                        PrintSolutionAdm.solutionView(connection.getConnection(),scanner);
                        command = "";
                        break;

                    case "quit":

                        command = scanner.nextLine();
                        break;

                    default:
                        PrintSolutionAdm.begin(connection.getConnection());
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
