import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PrintSolutionAdm {

    public static void begin(Connection connection) throws SQLException {

        ArrayList<Solution> solutions = Solution.loadAllSolutions(connection);
        for (Solution solution : solutions) {
            System.out.println("id: " + solution.getId() + " " + solution.getCreated() + " " +
                    solution.getUpdated() + " " + solution.getDescription() + " " + solution.getExercise_id() + " " +
                    solution.getUser_id());
        }

        System.out.println();
        System.out.println("Wybierz jedną z opcji:");
        System.out.println("add - przypisywanie zadań do użytkowników");
        System.out.println("view - przeglądanie rozwiązań danego użytkownika");
        System.out.println("quit - zakończenie programu");
    }

    public static Solution solutionAdd(Connection connection, Scanner scanner) {


        int exercise_id;
        int users_id;

        System.out.println("podaj id zadania:");
        exercise_id = Integer.valueOf(scanner.nextLine());

        System.out.println("podaj id użytkownika:");
        users_id = Integer.valueOf(scanner.nextLine());

        return new Solution(DBDate.setDate(new Date()),null,"", exercise_id, users_id);
    }

    public static void solutionView(Connection connection, Scanner scanner) throws SQLException {

        int users_id;

        System.out.println("podaj id użytkownika:");
        users_id = Integer.valueOf(scanner.nextLine());

        ArrayList<Solution> solutions = Solution.loadAllByUserId(connection,users_id);
        System.out.println("rozwiązania użytkownika o id = " + users_id);
        for (Solution solution : solutions) {
            System.out.println( solution.getId() + " " + solution.getCreated() + " " + solution.getUpdated()
                    + " " + solution.getDescription() + " " + solution.getExercise_id() + " " + solution.getUser_id());
        }

        System.out.println();
    }

}
