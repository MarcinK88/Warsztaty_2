import com.mysql.jdbc.Connection;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) throws SQLException {

        DBConnection connection = null;

        try {
            connection = new DBConnection("programming_school", "root", "coderslab");
//            ArrayList<User> users = User.loadAllUsers(connection.getConnection());
//            for (User user : users) {
//                System.out.println("id: " + user.getId() + " imie: " + user.getUsername() + " email: " + user.getEmail());
//            }


//            User user1 = new User("name5", "mail5", "password");
//            user1.saveToDB(connection.getConnection());

//            User user2 = User.loadUserById(connection.getConnection(),4);
//            System.out.println("imie: " + user2.getUsername() + " id: " + user2.getId());

        Exercise exercise1 = new Exercise("exercise2","description2");
        exercise1.saveToDB(connection.getConnection());

            ArrayList<Exercise> exercises = Exercise.loadAllExercises(connection.getConnection());
            for (Exercise exercise : exercises) {
                System.out.println("id: " + exercise.getId() + " tytuł:  " + exercise.getTitle() + " opis: " + exercise.getDescription());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeConnection();
        }
    }
}
