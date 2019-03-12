import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintExerciseAdm {

    public static void begin(Connection connection) throws SQLException {


        ArrayList<Exercise> exercises = Exercise.loadAllExercises(connection);
        for (Exercise exercise : exercises) {
            System.out.println("id: " + exercise.getId() + " title:  " + exercise.getTitle() + " description: " + exercise.getDescription());
        }

        System.out.println();
        System.out.println("Wybierz jedną z opcji:");
        System.out.println("add - dodanie zadań");
        System.out.println("edit - edycja zadań");
        System.out.println("delete - usunięcie zadań");
        System.out.println("quit - zakończenie programu");
    }

        public static Exercise exerciseAdd (Connection connection, Scanner scanner) {

            String title;
            String description;

            System.out.println("podaj tytuł:");
            title = scanner.nextLine();
            System.out.println("podaj opis:");
            description = scanner.next();

            return new Exercise(title,description);
        }

    public static Exercise exerciseEdit(Connection connection, Scanner scanner) throws SQLException {

        String title;
        String description;
        int id;

        System.out.println("podaj id:");
        id = Integer.valueOf(scanner.nextLine());

        Exercise exercise = Exercise.loadExerciseById(connection, id);

        System.out.println("podaj tytuł:");
        title = scanner.nextLine();
        System.out.println("podaj opis:");
        description = scanner.next();

        exercise.setTitle(title);
        exercise.setDescription(description);

        return exercise;
    }
    public static Exercise exerciseDelete(Connection connection, Scanner scanner) throws SQLException {

        int id;
        System.out.println("podaj id:");
        id = scanner.nextInt();

        return Exercise.loadExerciseById(connection, id);

    }

}
