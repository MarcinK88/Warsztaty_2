import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PrintSolutionUser {

    public static void begin(Connection connection) throws SQLException {


        System.out.println("Wybierz jedną z opcji:");
        System.out.println("add - dodawanie rozwiązania");
        System.out.println("view - przeglądanie swoich rozwiązań");
        System.out.println("quit - zakończenie programu");
    }

    public static Solution solutionAdd(Connection connection, Scanner scanner, int users_id) throws SQLException {

        int exercise_id;
        String description;
        ArrayList<Integer> exerciseIds = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from exercise where id not in (select exercise_id from solution as s where s.users_id=?);");
        preparedStatement.setInt(1, users_id);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            exerciseIds.add(resultSet.getInt("id"));
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("title") +
                    " " + resultSet.getString("description"));
        }

        System.out.println("podaj id zadania:");
        exercise_id = Integer.valueOf(scanner.nextLine());

            while(!exerciseIds.contains(exercise_id)) {
                System.out.println("podano nieprawidłowy id zadania, wpisz ponownie");
                exercise_id = Integer.valueOf(scanner.nextLine());
            }

            System.out.println("podaj treść rozwiązania:");
            description = scanner.nextLine();


        return new Solution(DBDate.setDate(new Date()),DBDate.setDate(new Date()),description, exercise_id, users_id);

    }

    public static void solutionView(Connection connection, Scanner scanner, int users_id) throws SQLException {

        ArrayList<Solution> solutions = Solution.loadAllByUserId(connection,users_id);
        System.out.println("rozwiązania użytkownika o id = " + users_id);
        for (Solution solution : solutions) {
            System.out.println( solution.getId() + " " + solution.getCreated() + " " + solution.getUpdated()
                    + " " + solution.getDescription() + " " + solution.getExercise_id() + " " + solution.getUser_id());
        }

        System.out.println();
    }
}
