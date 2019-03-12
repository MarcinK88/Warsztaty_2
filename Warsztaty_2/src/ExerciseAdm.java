import java.sql.SQLException;
import java.util.Scanner;

public class ExerciseAdm {
    public static void main(String[] args) throws SQLException {
        DBConnection connection = null;
        Scanner scanner = new Scanner(System.in);
        String command = "";

        try {
            connection = new DBConnection("programming_school", "root", "coderslab");

            PrintExerciseAdm.begin(connection.getConnection());

            command = scanner.nextLine();

            while(!command.equals("quit")) {
                switch (command) {
                    case "add":
                        Exercise exerciseAdd = PrintExerciseAdm.exerciseAdd(connection.getConnection(),scanner);
                        exerciseAdd.saveToDB(connection.getConnection());
                        command = scanner.nextLine();
                        break;

                    case "edit":
                        Exercise exerciseEdit = PrintExerciseAdm.exerciseEdit(connection.getConnection(),scanner);
                        exerciseEdit.saveToDB(connection.getConnection());
                        command = scanner.nextLine();
                        break;

                    case "delete":

                        command = scanner.nextLine();
                        break;

                    case "quit":

                        command = scanner.nextLine();
                        break;

                    default:
                        PrintExerciseAdm.begin(connection.getConnection());
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
