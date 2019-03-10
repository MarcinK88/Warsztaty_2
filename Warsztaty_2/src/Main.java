import com.mysql.jdbc.Connection;

        import java.sql.PreparedStatement;
        import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        try (Connection connection = Conn.getConnection()) {

           User user1 = new User("name2", "mail2", "password");
            user1.saveToDB(connection);

//            User user2 = User.loadUserById(connection,1);
//            System.out.println("imie: " + user2.getUsername() + " id: " + user2.getId());

            ArrayList<User> users = User.loadAllUsers(connection);
           for (User user : users) {
                System.out.println("id: " + user.getId() + " imie: " + user.getUsername() + " email: " + user.getEmail());
           }



        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
